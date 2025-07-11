public class TaxUtil {

    public double calculateTax(double amount, double rate) {
        return amount * rate;
    }

    public static void main(String[] args) {
        TaxUtil taxUtil = new TaxUtil();
        double tax = taxUtil.calculateTax(1000, 0.15);
        System.out.println("Tax is: " + tax);
    }
}
