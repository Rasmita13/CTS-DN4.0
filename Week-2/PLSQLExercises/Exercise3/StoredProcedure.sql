

-- Scenario 1: Process monthly interest for all savings accounts
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN
  UPDATE Accounts
  SET Balance = Balance + (Balance * 0.01),
      LastModified = SYSDATE
  WHERE AccountType = 'Savings';

  COMMIT;
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Scenario 1 - Error processing monthly interest: ' || SQLERRM);
    ROLLBACK;
END;
/


-- Scenario 2: Update employee bonuses by department
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
  p_department IN VARCHAR2,
  p_bonus_percent IN NUMBER
)
IS
BEGIN
  UPDATE Employees
  SET Salary = Salary + (Salary * p_bonus_percent / 100)
  WHERE Department = p_department;

  IF SQL%ROWCOUNT = 0 THEN
    DBMS_OUTPUT.PUT_LINE('Scenario 2 - No employees found in department: ' || p_department);
  ELSE
    DBMS_OUTPUT.PUT_LINE('Scenario 2 - Bonus updated for employees in department: ' || p_department);
  END IF;

  COMMIT;
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Scenario 2 - Error updating employee bonus: ' || SQLERRM);
    ROLLBACK;
END;
/


-- Scenario 3: Transfer funds between customer accounts
CREATE OR REPLACE PROCEDURE TransferFunds(
  p_from_account_id IN NUMBER,
  p_to_account_id IN NUMBER,
  p_amount IN NUMBER
)
IS
  v_balance NUMBER;
BEGIN
  -- Check and lock source account
  SELECT Balance INTO v_balance
  FROM Accounts
  WHERE AccountID = p_from_account_id
  FOR UPDATE;

  IF v_balance < p_amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Scenario 3 - Insufficient balance in source account.');
  END IF;

  -- Deduct from source
  UPDATE Accounts
  SET Balance = Balance - p_amount,
      LastModified = SYSDATE
  WHERE AccountID = p_from_account_id;

  -- Credit to destination
  UPDATE Accounts
  SET Balance = Balance + p_amount,
      LastModified = SYSDATE
  WHERE AccountID = p_to_account_id;

  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Scenario 3 - Transfer completed successfully.');
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Scenario 3 - Transfer failed: ' || SQLERRM);
    ROLLBACK;
END;
/
