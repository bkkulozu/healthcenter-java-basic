/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HealthCenterHasA;

public class Drug {
    private String dName;
    private int dLevel;

    public Drug(String dName, int dLevel) {
        this.dName = dName;
        this.dLevel = dLevel;
    }

    public Drug() {
    }

    public String getdName() {
        return dName;
    }

    public int getdLevel() {
        return dLevel;
    }
    
     @Override
    public String toString() {
        return " "+dName +"     Drug Level: "+ dLevel+"\n";
    }
}
