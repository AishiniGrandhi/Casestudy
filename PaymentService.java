package services;

public interface PaymentService {
    void processPayment(double amount);
    void displayPaymentDetails();
    String getPaymentStatus();
}