package Model;

import java.time.LocalDate;
import java.util.Scanner;

public class Patient implements Comparable<Patient> {

    private String patientId;
    private String fullName;

    private LocalDate dateOfBirth;
    private String phone;
    public Patient(String patientId, String fullName,  LocalDate dateOfBirth,String phone ) {
        this.patientId = patientId;
        this.fullName = fullName;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
    }
    public Patient() {
    }
    public String getpatientId() {
        return patientId;
    }

    public void setpatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public String toString() {
        return "This patient has id: " + this.patientId + ", name: " + this.fullName + ", phone: " + this.phone+ ", date of birth: " + this.dateOfBirth;
    }

    @Override
    public int compareTo(Patient o) {
        return this.dateOfBirth.compareTo(o.getDateOfBirth());
    }

}
