-- Scenario 1: Calculate the age of a customer based on date of birth
CREATE OR REPLACE FUNCTION CalculateAge(
  p_dob IN DATE
) RETURN NUMBER
IS
  v_age NUMBER;
BEGIN
  v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
  RETURN v_age;
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Scenario 1 - Error calculating age: ' || SQLERRM);
    RETURN NULL;
END;
/


-- Scenario 2: Calculate monthly loan installment
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
  p_loan_amount IN NUMBER,
  p_annual_interest_rate IN NUMBER,
  p_years IN NUMBER
) RETURN NUMBER
IS
  v_monthly_rate NUMBER;
  v_num_months   NUMBER;
  v_emi          NUMBER;
BEGIN
  v_monthly_rate := p_annual_interest_rate / 12 / 100;
  v_num_months := p_years * 12;

  IF v_monthly_rate = 0 THEN
    v_emi := p_loan_amount / v_num_months;
  ELSE
    v_emi := (p_loan_amount * v_monthly_rate * POWER(1 + v_monthly_rate, v_num_months)) /
             (POWER(1 + v_monthly_rate, v_num_months) - 1);
  END IF;

  RETURN ROUND(v_emi, 2);
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Scenario 2 - Error calculating installment: ' || SQLERRM);
    RETURN NULL;
END;
/

-- Scenario 3: Check if account has sufficient balance
CREATE OR REPLACE FUNCTION HasSufficientBalance(
  p_account_id IN NUMBER,
  p_amount IN NUMBER
) RETURN BOOLEAN
IS
  v_balance NUMBER;
BEGIN
  SELECT Balance INTO v_balance
  FROM Accounts
  WHERE AccountID = p_account_id;

  RETURN v_balance >= p_amount;
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    DBMS_OUTPUT.PUT_LINE('Scenario 3 - Account not found.');
    RETURN FALSE;
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Scenario 3 - Error checking balance: ' || SQLERRM);
    RETURN FALSE;
END;
/


