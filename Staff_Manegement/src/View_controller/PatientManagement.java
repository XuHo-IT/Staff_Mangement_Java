package View_controller;

import Model.PatientList;
import Model.Validation;

import java.io.IOException;
import java.text.ParseException;

    public class PatientManagement extends Menu {

        @Override
        public void execute(int n) throws ParseException {
            switch (n) {
                case 1:
                    PatientList stl = new PatientList();
                    stl.displayallStaff();
                    break;
                case 2:
                    searchingMenu();
                    break;
                case 3:
                    PatientList stls = new PatientList();
                    stls.inputuniqueStaff();
                    break;
                case 4:
                    PatientList st = new PatientList();
                    st.changePhoneNumber();
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        public static void searchingMenu () {
            PatientList stl = new PatientList();
            System.out.println("Searching by book's properties");
            System.out.println("1. Searching by id");
            System.out.println("2. Searching by full name ");
            System.out.println("5. Searching by date of birth");
            System.out.println("4. Searching by phone");
            System.out.println("____________________________");
            while (true){
                System.out.print("Enter your choice: ");
                int choice = Validation.getValidIntegerInput();
                if (choice == 0 ) return;
                else if (choice >= 1 && choice <= 4 ) stl.searchByProperties(choice);
                else System.out.println("Invalid choice, type again");
            }
        }


    }

