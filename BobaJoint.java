import java.util.Scanner;

public class BobaJoint {
    public static void main(String[] args) {
        String[] flavors = new String[100];
        String[] originalFlavors = {"Almond Milk Tea", "Coconut Milk Tea", "Coffee Milk Tea", "Honeydew Milk Tea", "House Milk Tea", "Jasmine Green Milk Tea", "Matcha Green Milk Tea", "Original Milk Tea", "Strawberry Milk Tea", "Taro Milk Tea", "Thai Milk Tea", "Vanilla Milk Tea"};
        for (int i=0;i<originalFlavors.length;i++) {
            flavors[i]=originalFlavors[i];
        }
        double[] flavcst = {1.45, 2.99, 3.99, 5.99, 4.99, 1.99, 3.00, 4.00, 5.00, 2.00, 1.00, 1.50};
        menu(flavors);
        flavors = pickYourFlavor(flavors);
        flavors = pickYourFlavor(flavors);
    }
    public static void myBobaWorld(int ct) {
        System.out.println("Welcome to the world of BOBA! House of "+ct+" high yummy calorie intakes!");
    }
    public static void menu(String[] flavors) {
        myBobaWorld(flavors.length);
        System.out.println("Here are your choices: ");
        char letter;
        for (int i=0;i<flavors.length;i++) {
            if (flavors[i]!=null) {
                letter=(char) ('a'+i);
                System.out.println(letter+". "+flavors[i]);
            }
        }
    }
    public static String[] pickYourFlavor(String[] flavors) {
        Scanner in = new Scanner(System.in);
        System.out.print("Hello customer! What flavor would you like?");
        String inp;
        inp = in.nextLine();
        int i;
        for (i=0;i<flavors.length;i++) {
            if (flavors[i]==null) {
                break;
            }
            if (inp.equals(flavors[i])) {
                System.out.print("Here you go! Enjoy!");
                return flavors;
            }
        }
        System.out.println("Sorry, we do not have that.");
        flavors[i] = inp;
        return flavors;
    }
}