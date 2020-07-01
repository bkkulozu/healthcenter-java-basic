/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HealthCenterInheritance;

import HealthCenterHasA.Drug;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Doctor extends Person{
    private String speciality;
    private String workingDays;
    private int experience;
    
    public Doctor() {
    }

    public Doctor(String name, String surname, String id, String speciality, String workingDays, int experience) {
        super(name, surname, id);
        this.speciality = speciality;
        this.workingDays = workingDays;
        this.experience = experience;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getWorkingDays() {
        return workingDays;
    }

    public int getExperience() {
        return experience;
    }
    
    
    
    @Override
    public double SocialBenefit() {
        if(experience >= 20)
            return 50;
        else
            return 25;
    }
    
    @Override
    public String toString() {
        return "Doctor\n"+super.toString()
                +"Speciality: "+speciality+"\n"
                +"Working Days: "+workingDays+"\n"
                +"Experience Bonus Per Patient: "+SocialBenefit()+"\n";
    }
    
    @Override
    public void writeFile(){
        File file = new File("person.txt");
        PrintWriter out =null;
        try {
            FileWriter fwriter = new FileWriter(file, true);
            out = new PrintWriter(fwriter);
            Drug d = new Drug();
            String result = "Doctor/"+getPersonInfo()+"/"+speciality+"/"+workingDays+"/"+experience;
            out.println(result);
            
        } catch (IOException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
        out.close();
    }
    
    
}
