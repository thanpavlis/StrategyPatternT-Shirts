package assignment3strategy;

import assignment3strategy.payment.CashPayment;
import assignment3strategy.payment.CreditDebitCardPayment;
import assignment3strategy.payment.MoneyBankTransfer;
import assignment3strategy.variations.TShirt;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOE {

    private String in;
    private int n, ch;
    private final Scanner scan;
    private final List<TShirt> tshirts;//tha apothikeusw ta random mplouzakia gia na mou pei o xrhsths poia thelei na agorasei
    private final RandTshirtGen ranTSGen;//antikeimeno to opoio mou paragei ta tyxaia mplouzakia 
    private final ShoppingCart sc;//to aneikeimeno pou antiproswpeuei to kalathi

    public IOE() {
        scan = new Scanner(System.in);
        tshirts = new ArrayList<TShirt>();
        ranTSGen = RandTshirtGen.getRandTshirtGen();
        sc = new ShoppingCart();
    }

    public void numOfRandomTShirts() {//o pelaths epilegei posa tyxaia mplouzakia na ftiaxw
        do {
            System.out.println("-----------------------------------------");
            System.out.println("Πόσα τυχαία μπλουζάκια θέλεις να φτιάξω ?");
            System.out.println("-----------------------------------------");
            in = scan.nextLine();
            n = isNumber(in);
        } while (n <= 0);
        System.out.println(red("------------------------------------------------"));
        System.out.println(red("Τα διαθέσιμα μπλουζάκια για αγορά είναι τα εξής:"));
        System.out.println(red("------------------------------------------------"));
        for (int i = 0; i < n; i++) {//paragw n tyxaia mplouzakia symfwna me to plithos pou thelei o xrhsths
            tshirts.add(ranTSGen.getRandomTShirt());
            System.out.println(tshirts.get(i));
        }
    }

    public void whatTOBuy() {//o pelaths dialegei poia mplouzakia na prosthesw sto kalathi 
        do {
            System.out.println(red("----------------------------------------------------------------------"));
            System.out.println(red("Ποιό μπλουζάκι (δώσε id) να προσθέσω στο καλάθι ? (για πληρωμή δώσε 0)"));
            System.out.println(red("(Μπορείς περισσότερες από μία φορές να προσθέσεις ένα συγκεκριμένο.)"));
            System.out.println(red("----------------------------------------------------------------------"));
            in = scan.nextLine();
            ch = isNumber(in);
            if (ch >= 1 && ch <= n) {//diathesimo id ara prosthetw sto kalathi
                sc.addItem(tshirts.get(ch - 1));//prosthetw sto kalathi to tshirt pou dialexe o xrhsths, to index einai ch-1 sthn arraylist
                System.out.println(green("Το μπλουζάκι " + tshirts.get(ch - 1) + " προστέθηκε επιτυχώς στο καλάθι !"));
            } else if (ch != 0) {
                System.out.println(red("Μη διαθέσιμο id ξαναδώσε !"));
            }
        } while (ch != 0);
    }

    public void pay() {//o pelaths dialegei ton tropo plirwmhs 
        do {
            System.out.println(red("--------------------------------------------------------------------------------"));
            System.out.println(red("Με τι τρόπο θα ήθελες να πληρώσεις ?"));
            System.out.println(red("------------------------------------"));
            System.out.println(red("1-Αντικαταβολή (μετρητά κατά την παράδοση)."));
            System.out.println(red("2-Χρεωστική/Πιστωτική Κάρτα."));
            System.out.println(red("3-Με μεταφορά ποσού στο λογαριασμό μας."));
            System.out.println(red("0-Για ακύρωση και έξοδο !"));
            System.out.println(red("--------------------------------------------------------------------------------"));
            in = scan.nextLine();
            ch = isNumber(in);
            if (ch >= 1 && ch <= 3) {//diathesimos tropos plirwmhs 
                switch (ch) {
                    case 1:
                        sc.makePayment(new CashPayment());
                        break;
                    case 2:
                        makeCreditDebitPayment();//kalw thn methodo gia na diavasw ta aparaithta stoixeia kai na ektelesw thn plirwmh
                        break;
                    default:
                        makeMoneyTransfer();//kalw thn methodo gia na diavasw ta aparaithta stoixeia kai na ektelesw thn plirwmh
                }
            } else if (ch != 0) {
                System.out.println(red("Μη διαθέσιμος τρόπος πληρωμής ξαναδώσε !"));
            } else {
                System.out.println(red("Έξοδος !"));
            }
        } while ((ch < 0) || (ch > 3));
    }

    public void makeCreditDebitPayment() {//zhtaei ola ta aparaithta gia plirwmh me karta kai ektelei thn plhrwmh
        String cardName, cardNumber, cardExpDate, cardCVV;
        System.out.print("Δώσε το cardNumber: ");
        cardNumber = scan.nextLine();
        System.out.print("Δώσε το cardName: ");
        cardName = scan.nextLine();
        System.out.print("Δώσε το cardExpDate: ");
        cardExpDate = scan.nextLine();
        System.out.print("Δώσε το cardCVV: ");
        cardCVV = scan.nextLine();
        sc.makePayment(new CreditDebitCardPayment(cardName, cardNumber, cardExpDate, cardCVV));//ektelesh plhrwmhs 
    }

    public void makeMoneyTransfer() {//zhtaei ta aparaithta gia plhrwmh me metafora posou kai ektelei thn metafora/plhrwmh
        String fromAccount, toAccount;
        System.out.print("Δώσε τον αριθμό του λογαριασμού σου: ");
        fromAccount = scan.nextLine();
        System.out.print("Δώσε τον αριθμό του λογαριασμού που θα πάει το ποσό: ");
        toAccount = scan.nextLine();
        sc.makePayment(new MoneyBankTransfer(fromAccount, toAccount));//ektelesh plhrwmhs 
    }

    private int isNumber(String in) {//elegxei an dothike arithmos san input
        int num;
        try {
            num = Integer.parseInt(in);
            return (num);
        } catch (NumberFormatException e) {
            return (-1);
        }
    }

    public static String red(String s) {//gia na ektypwnw red sthn consola
        return "\u001B[31m" + s + "\u001B[0m";
    }

    public static String green(String s) {//gia na ektypwnw green sthn cosnola 
        return "\u001B[32m" + s + "\u001B[0m";
    }

}
