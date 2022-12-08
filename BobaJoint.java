/**
  This is a project that simulates a boba joint that takes customer orders for flavors and toppings, then produces a bill at the end. 
 
  @author Patrick Zhou
  @version 1.2.1
  @since 2022-12-8
 */
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class BobaJoint {
    /**
    Declares and initializes all arrays for flavors (size 1000), toppings (size 12), cost (size 1000) and calls input methods. Furthermore, calls for three orders for customers. 
    @param Default
    */
    public static void main(String[] args) throws FileNotFoundException {
        // Array declarations and initialization
        String[] flavors = new String[1000];
        String[] toppings = new String[12];
        double[] toppingPrice = {0.45, 0.99, 0.99, 0.50, 0.99, 0.60, 0.80, 0.90, 1.00, 1.00, 0.35, 0.50};
        double[] originalcst = {1.45, 2.99, 3.99, 5.99, 4.99, 1.99, 3.00, 4.00, 5.00, 2.00, 1.00, 1.50};
        double[] flavcst = new double[1000];
        // filling in default values for flavor costs array
        for (int i=0;i<originalcst.length;i++) {
            flavcst[i]=originalcst[i];
        }
        // Scanner declaration and initialization
        Scanner in = new Scanner(System.in);
        // calling input methods
        inputFlavors(in, flavors);
        inputToppings(in, toppings);
        // calling 3 different orders
        order(flavors, toppings, toppingPrice, flavcst, in);
        order(flavors, toppings, toppingPrice, flavcst, in);
        order(flavors, toppings, toppingPrice, flavcst, in);
        // closing scanner for good practice. 
        in.close();
    }
    /**
    Prints the welcome message using the count of flavors.
    @param ct the number of flavors
    */
    public static void myBobaWorld(int ct) {
        System.out.println("Welcome to the world of BOBA! House of "+ct+" high yummy calorie intakes!");
    }
    /**
    Gets the number of flavors and stores it in the variable 'ct' to call the myBobaWorld method. Then prints the choices for flavors. 
    @param flavors array of flavors
    */
    public static void menu(String[] flavors) {
        // code to count current number of flavors
        int ct=0;
        for (int i=0;i<flavors.length;i++) {
            if (flavors[i]!=null) {
                ct++;
            }
        }
        // call myBobaWorld method to print the welcome message
        myBobaWorld(ct);
        // Prints choices for flavors
        System.out.println("Here are your choices: ");
        char letter;
        for (int i=0;i<flavors.length;i++) {
            if (flavors[i]!=null) {
                letter=(char) ('a'+i);
                System.out.println(letter+". "+flavors[i]);
            }
        }
    }
    /**
    Picks the flavor and returns the index of the flavor's cost
    @param flavors array of flavors
    @param in The scanner passed from main
    @return (int) The index of the flavor's cost
    */
    public static int pickYourFlavor(String[] flavors, Scanner in) {
        // prints prompt
        System.out.print("Hello customer! What flavor would you like?");
        // takes input for flavor
        String inp;
        inp = in.nextLine();
        // finds index of flavor to print dialog and return index of cost.
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
        // if the flavor is not found print the sorry dialog, adds flavor for next customer and returns -1 instead of index
        System.out.println("Sorry, we do not have that.");
        flavors[i] = inp;
        return -1;
    }
    /**
    Prints the choices for toppings 
    @param toppings array of toppings
    */
    public static void toppingsMenu(String[] toppings) {
        System.out.println("Here are your toppings choices: ");
        char letter;
        for (int i=0;i<toppings.length;i++) {
            letter=(char) ('a'+i);
            System.out.println(letter+". "+toppings[i]);
        }
    }
    /**
    Picks the topping and returns the index of the topping's cost
    @param toppings array of toppings
    @param in The scanner passed from main
    @return (int) The index of the topping's cost
    */
    public static int pickYourToppings(String[] toppings, Scanner in) {
        // prints prompt for customer to input topping
        System.out.print("Hello customer! What topping would you like?");
        // input topping
        String inp;
        inp = in.nextLine();
        // check if the customer wants no topping
        if (inp.equals("none")) {
            System.out.println("Ok, Sure.");
            return -1;
        }
        // interate through the toppings to get topping and return the topping's cost index
        int i;
        for (i=0;i<toppings.length;i++) {
            if (inp.equals(toppings[i])) {
                System.out.println("Added your topping "+toppings[i]+"! Enjoy!");
                return i;
            }
        }
        // if topping is not found, print sorry message and return -1 instead of topping's cost index
        System.out.println("Sorry, we do not have that.");
        return -1;
    }
    /**
    Inputs the flavors array from a text file
    @param flavors empty array of flavors
    @param in The scanner passed from main
    */
    public static void inputFlavors(Scanner in, String[] flavors) throws FileNotFoundException {
        // prompt for user to input the flavors.txt text file
        System.out.print("Enter the flavors file path: ");
        // declare and initialize file input readers
        String filepath = in.nextLine();
        File flavorsFile = new File(filepath);
        Scanner fileinput = new Scanner(flavorsFile);
        // traverse through the lines in the flavors.txt file and add to the flavors array
        int i=0;
        while(fileinput.hasNextLine()) {
            flavors[i]=fileinput.nextLine();
            i++;
        }
        // close the file input reader for good measure. 
        fileinput.close();
    }
    /**
    Inputs the toppings array from a text file
    @param toppings empty array of toppings
    @param in The scanner passed from main
    */
    public static void inputToppings(Scanner in, String[] toppings) throws FileNotFoundException {
        // prompt for user to input the toppings.txt text file
        System.out.print("Enter the toppings file path: ");
        // declare and initialize file input readers
        String filepath = in.nextLine();
        File toppingsFile = new File(filepath);
        Scanner fileinput = new Scanner(toppingsFile);
        // traverse through the lines in the toppings.txt file and add to the toppings array
        int i=0;
        while(fileinput.hasNextLine()) {
            toppings[i]=fileinput.nextLine();
            i++;
        }
        // close the file input reader for good measure.
        fileinput.close();
    }
    /** 
    Completes one customer order by calling the menu, pick flavors, pick toppings and adding the flavor and toppings to cost depending on whether or not the flavors array was updated. In addition printing out the final bill. 
    @param flavors array of flavors
    @param toppings array of toppings
    @param toppingPrice array of topping Prices
    @param flavcst array of flavor costs
    @param in The scanner passed from main
    */
    public static void order(String[] flavors, String[] toppings, double[] toppingPrice, double[] flavcst, Scanner in) {
        // declaration and initialization of variables
        double cst=0;
        int ind;
        // calling menu method to display menu
        menu(flavors);
        // calling pickYouFlavor method to pick flavor and receive returned index for cost
        ind = pickYourFlavor(flavors, in);
        // check if flavor was found. If found, add cost to total cost. Else, assign random cost for next time and add nothing. 
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
        // calling toppingsMenu method to display menu and pickYourToppings method to pick topping
        toppingsMenu(toppings);
        ind = pickYourToppings(toppings, in);
        // if topping was found, add topping to the total price. 
        if (ind!=-1) {
            cst+=toppingPrice[ind];
        }
        // print the 'bill' for this order.
        System.out.println("You total price for this order is: $"+cst);
    }
}