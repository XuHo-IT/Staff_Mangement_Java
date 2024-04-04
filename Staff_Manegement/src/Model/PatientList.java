package Model;
import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class PatientList  {
    public static ArrayList<Patient> patientList = new ArrayList<Patient>();
    public PatientList(ArrayList<Patient> patientList) {
        this.patientList = patientList;
    }
    public PatientList() {
    }

    public ArrayList<Patient> getStaffList() {
        return patientList;
    }

    public void setStaffList(ArrayList<Patient> patientList) {
        this.patientList = patientList;
    }
    public void loadFile() throws IOException, ParseException {
        String url = "staff (1).csv";
        FileInputStream fileInputStream = new FileInputStream(url);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(fileInputStream);
        Patient newPatient = null;
        int i = 0;
        while (sc.hasNextLine()) {
            String[] listProperty = sc.nextLine().split(",");
            String part[] = new String[4];
            for (int j = 0; j < listProperty.length; j++) {
                part[j] = listProperty[j];
            }
            boolean check = Validation.validStaffID(part[0]);
            if (check == true && Validation.isValidDate(part[2])) {
                newPatient = new Patient(part[0], part[1], LocalDate.parse(part[2], dateFormat), part[3]);
                patientList.add(newPatient);
                Collections.sort(patientList);
                System.out.println(newPatient.toString());
                i ++;
            }
        }
        fileInputStream.close();
    }
    public void inputuniqueStaff() {
        Scanner sc = new Scanner(System.in);
        String phone;
        System.out.println("Enter number of staffs to input: ");
        int numOfStaffs = Validation.getValidIntegerInput();
        int i = 0;
        boolean check = true;
        while (i < numOfStaffs) {
            while (true) {
                System.out.println("Enter staff's phone: ");
                phone = sc.nextLine();
                if (Validation.validphone(phone)) break;
                else System.out.println("Enter again staff phone");
            }
            for (Patient j : patientList) {
                if (phone.equals(j.getphone())) {
                    System.out.println("Staff phone can not be duplicate, enter again");
                    check = false;
                }
            }
            if (check == true) {
                System.out.println("Enter staff ID");
                String ID = Validation.getValidStringInput();
                System.out.println("Enter patient full name");
                String fullname = Validation.getValidStringInput();
                System.out.println("Enter staff date of birth");
                LocalDate dateofBirth = Validation.getvalidDateInput();
                patientList.add(new Patient(ID, fullname, dateofBirth, phone));
                i++;
            }
        }
        System.out.println("Input succesfully !");
    }
    public void searchByProperties(int choice) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your searching:");
        String search = sc.nextLine();
        int count = 0;
        for (Patient i : patientList) {
            String check[] = new String[4];
            check[0] = i.getpatientId();
            check[1] = i.getFullName();
            check[2] = i.getDateOfBirth().toString();
            check[3] = i.getphone();
            if (check[choice - 1].equalsIgnoreCase(search)) {
                System.out.println("Found: " + i.toString());
                count ++;
            }
            if (count == 0) System.out.println("No staff found!");
        }
    }

    public void displayallStaff() {
        for (Patient i : patientList) {
            System.out.println(i.toString());
        }
    }
    public void changePhoneNumber(){
        System.out.println("Please Enter your old number");
        Scanner sc = new Scanner(System.in);
        String enter = sc.nextLine();
        for (Patient patient: patientList){
            if ( enter.equals(patient.getphone())){
                System.out.println("Please Enter your new number");
                String newNum = sc.nextLine();
            } else  System.out.println("Please Reenter your old number");
        }
    }

}
