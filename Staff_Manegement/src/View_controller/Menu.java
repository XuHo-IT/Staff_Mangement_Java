package View_controller;

import Control.PatientManagement;
import Model.Validation;

import java.text.ParseException;

public abstract class Menu {

    public Menu() {
    }

    public void run() throws ParseException {
        while (true) {
            PatientManagement stmng = new PatientManagement();
            mainMenuInterface();
            int n = Validation.getValidIntegerInput();
            stmng.execute(n);
            if (n == 5) break;
        }
        System.out.println("Thanks for using our app.");
    }
    public static void mainMenuInterface () {
        System.out.println("Patient Management ");
        System.out.println("1. Display all staffs (Already sort by date of birth)");
        System.out.println("2. Search patient");
        System.out.println("3. Add patient");
        System.out.println("4. Update phone number");
        System.out.println("5. Quit");
        System.out.println("____________________________");
        System.out.print("Enter your choice: ");
    }
    public abstract void execute(int n) throws ParseException;
}
