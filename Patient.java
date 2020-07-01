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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Patient extends Person{
    private String sickness;
    private ArrayList<Drug> drugs = new ArrayList<>();

    public Patient() {
        drugs = new ArrayList<>();
    }

    public Patient(String name, String surname, String id, String sickness) {
        super(name, surname, id);
        this.sickness = sickness;
        drugs = new ArrayList<>();
    }
    
    public void addDrug(Drug d){
        drugs.add(d);
    }

    public String getSickness() {
        return sickness;
    }

    public ArrayList<Drug> getDrugs() {
        return drugs;
    }
    
    @Override
    public double SocialBenefit() {
        for(int i=0;i<drugs.size();i++)
            if(drugs.get(i).getdLevel()>2)
                return 30;
        return 5;
    }
    
     @Override
    public String toString() {
        String line = "";
        for (Drug d : drugs) {
            line += d.toString();
        }
        return "Patient\n" + super.toString()
                + "Sickness: " + sickness + "     Social Benefit by Government: " + SocialBenefit() +"\n"
                + "Drugs:" + line + "\n\n";

    }

    @Override
    public void writeFile() {
        File file = new File("person.txt");
        PrintWriter out =null;
        try {
            FileWriter fwriter = new FileWriter(file, true);
            out = new PrintWriter(fwriter);
            Drug d = new Drug();
            String result = "Patient/"+getPersonInfo()+"/"+sickness+"/"+d.getdName();
            out.println(result);
            
        } catch (IOException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
        out.close();
        
    }
    
    
}
