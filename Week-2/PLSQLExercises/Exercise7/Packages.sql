
-- 🔹 Scenario 1: CustomerManagement Package
-- Group all customer-related procedures and functions

-- Package Specification
CREATE OR REPLACE PACKAGE CustomerManagement AS
  PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER);
  PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE);
  FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER;
END CustomerManagement;
/

-- Package Body
CREATE OR REPLACE PACKAGE BODY CustomerManagement AS
  PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER) IS
  BEGIN
    INSERT INTO Customers(CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_id, p_name, p_dob, p_balance, SYSDATE);
    COMMIT;
  EXCEPTION
    WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('Error adding customer: ' || SQLERRM);
  END;

  PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE) IS
  BEGIN
    UPDATE Customers
    SET Name = p_name,
        DOB = p_dob,
        LastModified = SYSDATE
    WHERE CustomerID = p_id;
    COMMIT;
  EXCEPTION
    WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('Error updating customer: ' || SQLERRM);
  END;

  FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER IS
    v_balance NUMBER;
  BEGIN
    SELECT Balance INTO v_balance FROM Customers WHERE CustomerID = p_id;
    RETURN v_balance;
  EXCEPTION
    WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('Error getting balance: ' || SQLERRM);
      RETURN NULL;
  END;
END CustomerManagement;
/


-- 🔹 Scenario 2: EmployeeManagement Package
-- Manage employee data

-- Package Specification
CREATE OR REPLACE PACKAGE EmployeeManagement AS
  PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_department VARCHAR2, p_hiredate DATE);
  PROCEDURE UpdateEmployee(p_id NUMBER, p_position VARCHAR2, p_salary NUMBER);
  FUNCTION GetAnnualSalary(p_id NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

-- Package Body
CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS
  PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_department VARCHAR2, p_hiredate DATE) IS
  BEGIN
    INSERT INTO Employees(EmployeeID, Name, Position, Salary, Department, HireDate)
    VALUES (p_id, p_name, p_position, p_salary, p_department, p_hiredate);
    COMMIT;
  EXCEPTION
    WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('Error hiring employee: ' || SQLERRM);
  END;

  PROCEDURE UpdateEmployee(p_id NUMBER, p_position VARCHAR2, p_salary NUMBER) IS
  BEGIN
    UPDATE Employees
    SET Position = p_position,
        Salary = p_salary
    WHERE EmployeeID = p_id;
    COMMIT;
  EXCEPTION
    WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('Error updating employee: ' || SQLERRM);
  END;

  FUNCTION GetAnnualSalary(p_id NUMBER) RETURN NUMBER IS
    v_salary NUMBER;
  BEGIN
    SELECT Salary INTO v_salary FROM Employees WHERE EmployeeID = p_id;
    RETURN v_salary * 12;
  EXCEPTION
    WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('Error calculating annual salary: ' || SQLERRM);
      RETURN NULL;
  END;
END EmployeeManagement;
/



-- 🔹 Scenario 3: AccountOperations Package
-- Group account-related procedures and functions

-- Package Specification
CREATE OR REPLACE PACKAGE AccountOperations AS
  PROCEDURE OpenAccount(p_id NUMBER, p_cust_id NUMBER, p_type VARCHAR2, p_balance NUMBER);
  PROCEDURE CloseAccount(p_id NUMBER);
  FUNCTION GetTotalBalance(p_cust_id NUMBER) RETURN NUMBER;
END AccountOperations;
/

-- Package Body
CREATE OR REPLACE PACKAGE BODY AccountOperations AS
  PROCEDURE OpenAccount(p_id NUMBER, p_cust_id NUMBER, p_type VARCHAR2, p_balance NUMBER) IS
  BEGIN
    INSERT INTO Accounts(AccountID, CustomerID, AccountType, Balance, LastModified)
    VALUES (p_id, p_cust_id, p_type, p_balance, SYSDATE);
    COMMIT;
  EXCEPTION
    WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('Error opening account: ' || SQLERRM);
  END;

  PROCEDURE CloseAccount(p_id NUMBER) IS
  BEGIN
    DELETE FROM Accounts WHERE AccountID = p_id;
    COMMIT;
  EXCEPTION
    WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('Error closing account: ' || SQLERRM);
  END;

  FUNCTION GetTotalBalance(p_cust_id NUMBER) RETURN NUMBER IS
    v_total NUMBER := 0;
  BEGIN
    SELECT SUM(Balance) INTO v_total FROM Accounts WHERE CustomerID = p_cust_id;
    RETURN NVL(v_total, 0);
  EXCEPTION
    WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('Error calculating total balance: ' || SQLERRM);
      RETURN NULL;
  END;
END AccountOperations;
/



