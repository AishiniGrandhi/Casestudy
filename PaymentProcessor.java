package services;

public class PaymentProcessor implements PaymentService {
    private String paymentStatus;
    private double amount;
    private String transactionId;

    @Override
    public void processPayment(double amount) {
        this.amount = amount;
        this.transactionId = "TXN" + System.currentTimeMillis();
        this.paymentStatus = "COMPLETED";
    }

    @Override
    public void displayPaymentDetails() {
        System.out.println("\n=== Payment Receipt ===");
        System.out.println("Transaction ID: " + transactionId);
        System.out.printf("Amount Paid: $%.2f\n", amount);
        System.out.println("Status: " + paymentStatus);
        System.out.println("Thank you for your payment!");
    }

    @Override
    public String getPaymentStatus() {
        return paymentStatus;
    }
}