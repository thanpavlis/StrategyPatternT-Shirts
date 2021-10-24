package assignment3strategy;

import assignment3strategy.payment.PaymentMethod;
import assignment3strategy.variations.TShirt;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<TShirt> orederItems;//h lista twn antikeimenwn pou exei to kalathi

    public ShoppingCart() {
        orederItems = new ArrayList<TShirt>();//arxikopoihsh listas
    }

    public void addItem(TShirt tshirt) {//prosthiki antikeimenou sto kalathi
        orederItems.add(tshirt);
    }

    public void removeItem(TShirt tshirt) {//afairesh antikeimenou apo to kalathi
        orederItems.remove(tshirt);
    }

    public double calcTotalCost() {//ypologismos telikou posou olwn twn proiontwn pou einai sta kalathi
        double sum = 0;
        for (TShirt orderItem : orederItems) {
            sum += orderItem.getPrice();
        }
        return sum;
    }

    public void makePayment(PaymentMethod payment) {//ektelesh plirwmhs 
        double sum = calcTotalCost();
        if (sum == 0) {
            System.out.println(IOE.red("Το καλάθι είναι άδειο !"));
        } else {
            payment.pay(sum);
        }
    }
}
