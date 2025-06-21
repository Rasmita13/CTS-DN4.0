public class FinancialForecast {

    public static double futureValue(double current, double rate, int periods) {
        if (periods == 0) return current;
        return futureValue(current * (1 + rate), rate, periods - 1);
    }

    public static void main(String[] args) {
        double currentAmount = 1000.0;
        double rate = 0.05; // 5%
        int periods = 5;

        System.out.println("Future Value after " + periods + " periods: " 
                           + futureValue(currentAmount, rate, periods));
    }
}

