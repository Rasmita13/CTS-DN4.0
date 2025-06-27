SET SERVEROUTPUT ON;

-- Scenario 1: Generate monthly statements for all customers
DECLARE
  CURSOR cur_monthly_txns IS
    SELECT c.CustomerID, c.Name, t.TransactionDate, t.Amount, t.TransactionType
    FROM Customers c
    JOIN Accounts a ON c.CustomerID = a.CustomerID
    JOIN Transactions t ON a.AccountID = t.AccountID
    WHERE TRUNC(t.TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM')
    ORDER BY c.CustomerID;

  v_customer_id   Customers.CustomerID%TYPE;
  v_name          Customers.Name%TYPE;
  v_date          Transactions.TransactionDate%TYPE;
  v_amount        Transactions.Amount%TYPE;
  v_type          Transactions.TransactionType%TYPE;
BEGIN
  DBMS_OUTPUT.PUT_LINE('=== Scenario 1: Monthly Statements ===');
  FOR rec IN cur_monthly_txns LOOP
    DBMS_OUTPUT.PUT_LINE('Customer ID: ' || rec.CustomerID || ', Name: ' || rec.Name);
    DBMS_OUTPUT.PUT_LINE('Date: ' || TO_CHAR(rec.TransactionDate, 'DD-MON-YYYY') ||
                         ', Amount: ' || rec.Amount || ', Type: ' || rec.TransactionType);
    DBMS_OUTPUT.PUT_LINE('------------------------------------');
  END LOOP;
END;
/


-- Scenario 2: Apply annual fee to all accounts
DECLARE
  CURSOR cur_accounts IS
    SELECT AccountID, Balance FROM Accounts FOR UPDATE;

  v_fee CONSTANT NUMBER := 100;  -- Example fee
BEGIN
  DBMS_OUTPUT.PUT_LINE('=== Scenario 2: Applying Annual Fee ===');
  FOR rec IN cur_accounts LOOP
    UPDATE Accounts
    SET Balance = Balance - v_fee,
        LastModified = SYSDATE
    WHERE AccountID = rec.AccountID;

    DBMS_OUTPUT.PUT_LINE('Fee of ' || v_fee || ' applied to Account ID: ' || rec.AccountID);
  END LOOP;
  COMMIT;
END;
/


-- Scenario 3: Update loan interest rates based on a new policy
DECLARE
  CURSOR cur_loans IS
    SELECT LoanID, InterestRate FROM Loans FOR UPDATE;

  v_new_rate NUMBER;
BEGIN
  DBMS_OUTPUT.PUT_LINE('=== Scenario 3: Updating Loan Interest Rates ===');
  FOR rec IN cur_loans LOOP
    -- Example policy: increase by 0.5% if interest is below 6%
    IF rec.InterestRate < 6 THEN
      v_new_rate := rec.InterestRate + 0.5;
    ELSE
      v_new_rate := rec.InterestRate;
    END IF;

    UPDATE Loans
    SET InterestRate = v_new_rate
    WHERE LoanID = rec.LoanID;

    DBMS_OUTPUT.PUT_LINE('Loan ID: ' || rec.LoanID || ' - New Rate: ' || v_new_rate);
  END LOOP;
  COMMIT;
END;
/


