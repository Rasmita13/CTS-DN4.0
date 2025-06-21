public class SP {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        System.out.println("Are both instances the same? " + (logger1 == logger2));
        logger1.log("This is the first message.");
        logger2.log("This is the second message.");
    }
}
