package assignment3strategy.payment;

import assignment3strategy.IOE;

public class MoneyBankTransfer implements PaymentMethod {

    private String fromAccount;
    private String toAccount;

    public MoneyBankTransfer(String fromAccount, String toAccount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
    }

    @Override
    public void pay(double amount) {
        System.out.println(IOE.green("Η μεταφορά του ποσού των " + amount
                + " ευρώ από τον λογαριασμό σας " + fromAccount
                + " προς τον λογαριασμό μας " + toAccount + " έγινε επιτυχώς !"));
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

}
