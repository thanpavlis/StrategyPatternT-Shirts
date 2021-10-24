package assignment3strategy.payment;

import assignment3strategy.IOE;

public class CreditDebitCardPayment implements PaymentMethod {

    private String cardName;
    private String cardNumber;
    private String cardExpDate;
    private String cardCVV;

    public CreditDebitCardPayment(String cardName, String cardNumber, String cardExpDate, String cardCVV) {
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.cardExpDate = cardExpDate;
        this.cardCVV = cardCVV;
    }

    @Override
    public void pay(double amount) {
        System.out.println(IOE.green("Η πληρωμή των " + amount + " ευρώ με την κάρτα σας " + cardNumber + " έγινε επιτυχώς !"));
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardExpDate() {
        return cardExpDate;
    }

    public void setCardExpDate(String cardExpDate) {
        this.cardExpDate = cardExpDate;
    }

    public String getCardCVV() {
        return cardCVV;
    }

    public void setCardCVV(String cardCVV) {
        this.cardCVV = cardCVV;
    }

}
