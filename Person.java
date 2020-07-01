/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HealthCenterInheritance;

import HealthCenterInterface.PersonInterface;

public abstract class Person implements PersonInterface{
    protected String name;
    protected String surname;
    protected String ssn;

    public Person() {
    }

    public Person(String name, String surname, String id) {
        this.name = name;
        this.surname = surname;
        this.ssn = id;
    }
    
    public boolean findPerson(String id){
        return this.ssn.equalsIgnoreCase(id);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSsn() {
        return ssn;
    }
    
    public String getPersonInfo() {
        return name + "/" + surname + "/" + ssn;
    }

    @Override
    public String toString() {
        return "Name: "+name+"\n"
                +"Surname: "+surname+"\n"
                +"Social Security Number: "+ssn+"\n";
    }
    
    abstract public double SocialBenefit();
}
