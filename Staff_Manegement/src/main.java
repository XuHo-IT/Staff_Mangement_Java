import Model.PatientList;
import View_controller.Menu;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws ParseException, IOException {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu() {
            @Override
            public void execute(int n) throws ParseException {
            }
        };
        PatientList stl1 = new PatientList();
        System.out.println("The original file");
        System.out.println("---------------------------------------------------");
        stl1.loadFile();
        System.out.println("---------------------------------------------------");
        menu.run();
    }
}
