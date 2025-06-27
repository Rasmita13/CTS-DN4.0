DECLARE
  -- Variables for loan reminder
  v_due_date Loans.DueDate%TYPE;
  v_cust_id  Loans.CustomerID%TYPE;
BEGIN
  -- Scenario 1: Apply 1% discount for customers above 60
  FOR cust1 IN (SELECT CustomerID, Age, LoanInterestRate FROM Customers) LOOP
    IF cust1.Age > 60 THEN
      UPDATE Customers
      SET LoanInterestRate = LoanInterestRate - 1
      WHERE CustomerID = cust1.CustomerID;
    END IF;
  END LOOP;

  -- Scenario 2: Promote to VIP if balance > 10,000
  FOR cust2 IN (SELECT CustomerID, Balance FROM Customers) LOOP
    IF cust2.Balance > 10000 THEN
      UPDATE Customers
      SET IsVIP = 'TRUE'
      WHERE CustomerID = cust2.CustomerID;
    END IF;
  END LOOP;

  -- Scenario 3: Print reminders for loans due in next 30 days
  FOR loan_rec IN (
    SELECT CustomerID, DueDate
    FROM Loans
    WHERE DueDate BETWEEN SYSDATE AND SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE(
      'Reminder: Customer ID ' || loan_rec.CustomerID ||
      ', your loan is due on ' || TO_CHAR(loan_rec.DueDate, 'DD-MON-YYYY')
    );
  END LOOP;

  -- Commit updates
  COMMIT;
END;
/

