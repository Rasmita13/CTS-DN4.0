-- Prerequisite for Scenario 2: Create AuditLog table (if not already created)
CREATE TABLE AuditLog (
  LogID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  TransactionID NUMBER,
  AccountID NUMBER,
  TransactionDate DATE,
  Amount NUMBER,
  TransactionType VARCHAR2(10),
  LoggedAt DATE
);


-- Scenario 1: Automatically update the LastModified column
CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
  :NEW.LastModified := SYSDATE;
END;
/

-- Scenario 2: Insert audit record on every new transaction
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
  INSERT INTO AuditLog (
    TransactionID, AccountID, TransactionDate,
    Amount, TransactionType, LoggedAt
  ) VALUES (
    :NEW.TransactionID, :NEW.AccountID, :NEW.TransactionDate,
    :NEW.Amount, :NEW.TransactionType, SYSDATE
  );
END;
/


-- Scenario 3: Enforce deposit/withdrawal rules before transaction
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
  v_balance NUMBER;
BEGIN
  -- Get current balance of the account
  SELECT Balance INTO v_balance
  FROM Accounts
  WHERE AccountID = :NEW.AccountID;

  -- Check withdrawal rule
  IF :NEW.TransactionType = 'Withdrawal' AND :NEW.Amount > v_balance THEN
    RAISE_APPLICATION_ERROR(-20001, 'Withdrawal exceeds available balance.');
  END IF;

  -- Check deposit rule
  IF :NEW.TransactionType = 'Deposit' AND :NEW.Amount <= 0 THEN
    RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive.');
  END IF;
END;
/

