import java.util.Scanner;

public class BobaJoint {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] flavors = new String[1000];
        String[] originalFlavors = {"Almond Milk Tea", "Coconut Milk Tea", "Coffee Milk Tea", "Honeydew Milk Tea", "House Milk Tea", "Jasmine Green Milk Tea", "Matcha Green Milk Tea", "Original Milk Tea", "Strawberry Milk Tea", "Taro Milk Tea", "Thai Milk Tea", "Vanilla Milk Tea"};
        String[] toppings = {"Boba", "Grass jelly", "Chia or basil seeds", "Popping boba", "Cheese foam", "Egg pudding", "Aloe vera", "Coffee jelly", "Taro", "Red bean", "Fruit jelly or boba", "Aiyu jelly"};
        double[] toppingPrice = {0.45, 0.99, 0.99, 0.50, 0.99, 0.60, 0.80, 0.90, 1.00, 1.00, 0.35, 0.50};
        for (int i=0;i<originalFlavors.length;i++) {
            flavors[i]=originalFlavors[i];
        }
        double[] flavcst = {1.45, 2.99, 3.99, 5.99, 4.99, 1.99, 3.00, 4.00, 5.00, 2.00, 1.00, 1.50};
        flavors = order(flavors, toppings, toppingPrice, flavcst, in);
        flavors = order(flavors, toppings, toppingPrice, flavcst, in);
        in.close();
    }
    public static String[] order(String[] flavors, String[] toppings, double[] toppingPrice, double[] flavcst, Scanner in) {
        double cst=0;
        int ind;
        menu(flavors);
        flavors = pickYourFlavor(flavors, in);
        for (ind=0;ind<flavors.length;ind++) {
            if (flavors[ind]==null) {
                break;
            }
        }
        if (flavors[999]!=null) {
            cst+=flavcst[Integer.parseInt(flavors[999])];
            flavors[999]=null;
        }
        toppingsMenu(toppings);
        ind = pickYourToppings(toppings, in);
        if (ind!=999) {
            cst+=toppingPrice[ind];
        }
        System.out.println("This has in total cost you: "+cst);
        return flavors;
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
    public static String[] pickYourFlavor(String[] flavors, Scanner in) {
        System.out.print("Hello customer! What flavor would you like?");
        String inp;
        inp = in.nextLine();
        int i;
        for (i=0;i<flavors.length;i++) {
            if (flavors[i]==null) {
                break;
            }
            if (inp.equals(flavors[i])) {
                System.out.println("Here you go!");
                flavors[999]=Integer.toString(i);
                return flavors;
            }
        }
        System.out.println("Sorry, we do not have that.");
        flavors[i] = inp;
        return flavors;
    }
    public static int pickYourToppings(String[] toppings, Scanner in) {
        System.out.print("Hello customer! What topping would you like?");
        String inp;
        inp = in.nextLine();
        int i;
        if (inp.equals("none")) {
            System.out.println("Ok, Sure.");
            return 999;
        }
        for (i=0;i<toppings.length;i++) {
            if (inp.equals(toppings[i])) {
                System.out.println("Added your topping! Enjoy!");
                return i;
            }
        }
        System.out.println("Sorry, we do not have that.");
        return 999;
    }
}