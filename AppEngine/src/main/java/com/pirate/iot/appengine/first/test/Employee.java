package com.pirate.iot.appengine.first.test;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * TODO
 * Exemple class, can be removed before release version !
 */
@XmlRootElement(name = "employee")
public class Employee {
    private String firstName;
    private String lastName;
    private Date hireDate;
    private String email;

    public Employee(String firstName, String lastName, Date hireDate, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hireDate = hireDate;
        this.email = email;
    }

    public Employee() {
    }

    @XmlElement
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlElement
    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @XmlElement
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("First: ").append(getFirstName());
        sb.append(" - Last: ").append(getLastName());
        sb.append(" - Date: ").append(getHireDate());
        sb.append(" - Email: ").append(getEmail());
        return sb.toString();
    }
}