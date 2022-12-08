import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class BobaJoint {
    /* 
    Declares and initializes all arrays for flavors (size 1000), toppings (size 12), cost (size 1000). Furthermore, calls for two orders for customers. 
    @param Default
    @return Nothing.
    */
    public static void main(String[] args) throws FileNotFoundException {
        String[] flavors = new String[1000];
        String[] toppings = new String[12];
        Scanner in = new Scanner(System.in);
        inputFlavors(in, flavors);
        inputToppings(in, toppings);
        double[] toppingPrice = {0.45, 0.99, 0.99, 0.50, 0.99, 0.60, 0.80, 0.90, 1.00, 1.00, 0.35, 0.50};
        double[] originalcst = {1.45, 2.99, 3.99, 5.99, 4.99, 1.99, 3.00, 4.00, 5.00, 2.00, 1.00, 1.50};
        double[] flavcst = new double[1000];
        for (int i=0;i<originalcst.length;i++) {
            flavcst[i]=originalcst[i];
        }
        order(flavors, toppings, toppingPrice, flavcst, in);
        order(flavors, toppings, toppingPrice, flavcst, in);
        order(flavors, toppings, toppingPrice, flavcst, in);
        in.close();
    }
    /* 
    Completes one customer order by calling the menu, pick flavors, pick toppings and adding the flavor and toppings to cost depending on whether or not the flavors array was updated. In addition printing out the final bill. 
    @param flavors array of flavors
    @param toppings array of toppings
    @param toppingPrice array of topping Prices
    @param flavcst array of flavor costs
    @param in The scanner passed from main
    @return New and updated array of flavors after updating the flavors array
    */
    public static void order(String[] flavors, String[] toppings, double[] toppingPrice, double[] flavcst, Scanner in) {
        double cst=0;
        int ind;
        menu(flavors);
        ind = pickYourFlavor(flavors, in);
        if (ind==-1) {
            for (ind=0;ind<flavors.length;ind++) {
                if (flavors[ind]==null) {
                    break;
                }
            }
            flavcst[ind-1]=(int) (Math.random() * 5 + 1);
        } else {
            cst+=flavcst[ind];
        }
        toppingsMenu(toppings);
        ind = pickYourToppings(toppings, in);
        if (ind!=-1) {
            cst+=toppingPrice[ind];
        }
        System.out.println("This has in total cost you: $"+cst);
    }
    public static void myBobaWorld(int ct) {
        System.out.println("Welcome to the world of BOBA! House of "+ct+" high yummy calorie intakes!");
    }
    public static void menu(String[] flavors) {
        int ct=0;
        for (int i=0;i<flavors.length;i++) {
            if (flavors[i]!=null) {
                ct++;
            }
        }
        myBobaWorld(ct);
        System.out.println("Here are your choices: ");
        char letter;
        for (int i=0;i<flavors.length;i++) {
            if (flavors[i]!=null) {
                letter=(char) ('a'+i);
                System.out.println(letter+". "+flavors[i]);
            }
        }
    }
    public static void toppingsMenu(String[] toppings) {
        System.out.println("Here are your toppings choices: ");
        char letter;
        for (int i=0;i<toppings.length;i++) {
            letter=(char) ('a'+i);
            System.out.println(letter+". "+toppings[i]);
        }
    }
    public static int pickYourFlavor(String[] flavors, Scanner in) {
        System.out.print("Hello customer! What flavor would you like?");
        String inp;
        inp = in.nextLine();
        int i;
        for (i=0;i<flavors.length;i++) {
            if (flavors[i]==null) {
                break;
            }
            if (inp.equals(flavors[i])) {
                System.out.println("Here you go! A "+flavors[i]+" coming! Enjoy!");
                return i;
            }
        }
        System.out.println("Sorry, we do not have that.");
        flavors[i] = inp;
        return -1;
    }
    public static int pickYourToppings(String[] toppings, Scanner in) {
        System.out.print("Hello customer! What topping would you like?");
        String inp;
        inp = in.nextLine();
        int i;
        if (inp.equals("none")) {
            System.out.println("Ok, Sure.");
            return -1;
        }
        for (i=0;i<toppings.length;i++) {
            if (inp.equals(toppings[i])) {
                System.out.println("Added your topping! Enjoy!");
                return i;
            }
        }
        System.out.println("Sorry, we do not have that.");
        return -1;
    }
    public static void inputFlavors(Scanner in, String[] flavors) throws FileNotFoundException {
        System.out.print("Enter the flavors file path: ");
        String filepath = in.nextLine();
        File flavorsFile = new File(filepath);
        Scanner fileinput = new Scanner(flavorsFile);
        int i=0;
        while(fileinput.hasNextLine()) {
            flavors[i]=fileinput.nextLine();
            i++;
        }
        fileinput.close();
    }
    public static void inputToppings(Scanner in, String[] toppings) throws FileNotFoundException {
        System.out.print("Enter the toppings file path: ");
        String filepath = in.nextLine();
        File toppingsFile = new File(filepath);
        Scanner fileinput = new Scanner(toppingsFile);
        int i=0;
        while(fileinput.hasNextLine()) {
            toppings[i]=fileinput.nextLine();
            i++;
        }
        fileinput.close();
    }
}