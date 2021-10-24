package assignment3strategy.payment;

import assignment3strategy.IOE;

public class CashPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {//+5 eurw epipleon xrewsh 
        System.out.println(IOE.green("Παρακαλώ πληρώστε το ποσό των " + amount + " ευρώ κατά την παράδοση !"));
    }

}
