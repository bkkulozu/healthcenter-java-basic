/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SYSClass_Main;

import HealthCenterInheritance.Doctor;
import HealthCenterHasA.Drug;
import HealthCenterInheritance.Patient;
import HealthCenterInheritance.Person;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonSys {
    public static HashSet<Person> people = new HashSet();
    public static String FILENAME = "person.txt";
    
    public static void readFile() {
        File file = new File(FILENAME);
        Scanner input = null;
        try {
            input = new Scanner(file);
            while (input.hasNext()) {
                String line = input.nextLine();
                String[] data = line.split("/");
                if (data[0].equalsIgnoreCase("Patient")) {
                    Patient pat = new Patient(data[1], data[2], data[3], data[4]);
                    Drug drug = new Drug(data[5], Integer.parseInt(data[6]));
                    pat.addDrug(drug);
                    people.add(pat);
                } else if (data[0].equalsIgnoreCase("Doctor")) {
                    Doctor doc = new Doctor(data[1], data[2], data[3], data[4],data[5], Integer.parseInt(data[6]));
                    people.add(doc);
                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PersonSys.class.getName()).log(Level.SEVERE, null, ex);
        }
        input.close();
    }
    
    public static boolean addPerson(Person p) {
        for (Person pe : people) {
            if (pe.findPerson(pe.getSsn())) {
                return false;
            }
        }
        people.add(p);
        return true;
    }
    
    public static void writeDataToFile(Person p) {
        p.writeFile();
    }
    
    public static Person searchPerson(String ssn) {
        for (Person ppl : people) {
            String res = ppl.getSsn();
            if (res.equalsIgnoreCase(ssn)) {
                return ppl;
            }
        }
        return null;
    }
    
    public static boolean deletePerson(String ssn) {
        for (Person ppl : people) {
            if (ppl.getSsn().equalsIgnoreCase(ssn)) {
                return people.remove(ppl);
            }   
        }
        return false;
    }
    
    public static String displayDoctor() {
        String result = "";
        for (Person p : people) {
            if (p instanceof Doctor) {
                result += p.toString() + "\n";
            }
        }
        return result;
    }

    public static String displayPatient() {
        String result = "";
        for (Person p : people) {
            if (p instanceof Patient) {
                result += p.toString() + "\n";
            }
        }
        return result;
    }
}
