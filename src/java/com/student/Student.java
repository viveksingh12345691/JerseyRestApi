/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.student;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abhi
 */
@XmlRootElement(name = "student")
public class Student implements Serializable {

    int Student_no;
    String name, dob, doj;

    public Student() {
    }

    

    public Student(int Student_no, String name, String dob, String doj) {
        this.Student_no = Student_no;
        this.name = name;
        this.dob = dob;
        this.doj = doj;
    }

    public int getStudent_no() {
        return Student_no;
    }

    @XmlElement
    public void setStudent_no(int Student_no) {
        this.Student_no = Student_no;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    @XmlElement
    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDoj() {
        return doj;
    }

    @XmlElement
    public void setDoj(String doj) {
        this.doj = doj;
    }
@Override
    public String toString() {
        return "Student{" + "Student_no=" + Student_no + ", name=" + name + ", dob=" + dob + ", doj=" + doj + '}';
    }
}
