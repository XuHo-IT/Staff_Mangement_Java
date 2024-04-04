package Control;
import Model.PatientList;
import Model.Validation;
import View_controller.Menu;

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
//                for (Patient i : PatientList.patientList) {
//                    while (true) {
//                        System.out.println("Enter id ");
//                        String staffID = Validation.getValidStringInput();
//                        if(staffID.equals(i.getStaffId())) {
//                            i.login();
//                            break;
//                        }
//                        else System.out.println("Wrong id, enter again");
//                    }
//                    System.out.println("Change password interface");
//                    i.changePassword();
//                }
                break;
//            case 5:
//              deleteStaff();
//              break;
//            case 6:
//                for (Patient i : PatientList.patientList) {
//                    System.out.println("Login inter face");
//                    while (true) {
//                        System.out.println("Enter id ");
//                        String staffID = Validation.getValidStringInput();
//                        if(staffID.equals(i.g())) {
//                            i.login();
//                            break;
//                        }
//                        else System.out.println("Wrong id, enter again");
//                    }
//                }
            case 0:
                return;
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
        System.out.println("0. Exit");
        System.out.println("____________________________");
        while (true){
            System.out.print("Enter your choice: ");
            int choice = Validation.getValidIntegerInput();
            if (choice == 0 ) return;
            else if (choice >= 1 && choice <= 5 ) stl.searchByProperties(choice);
            else System.out.println("Invalid choice, type again");
        }
    }

    public static void main(String[] args) throws ParseException, IOException {
        Menu menu = new Menu() {
            @Override
            public void execute(int n) throws ParseException {

            }
        };
        PatientList stl1 = new PatientList();
        stl1.loadFile();
        menu.run();
    }
}

