package com.example.CareFoMe;

import java.io.Serializable;

public class AppointementData implements Serializable
{
    static int Appointment_id=1;

    String Pname;
    String phNumber;
    String Dname;
    String emailA;
    String date;
    String time;

    public AppointementData() {
        this.Appointment_id = Appointment_id++;
        this.Pname = Pname;
        this.phNumber = phNumber;
        this.Dname = Dname;
        this.emailA = emailA;
        this.date = date;
        this.time = time;
    }

    public AppointementData(String Pname, String phNumber, String Dname, String emailA, String date, String time) {
        this.Pname = Pname;
        this.phNumber = phNumber;
        this.Dname = Dname;
        this.emailA = emailA;
        this.date = date;
        this.time = time;
    }


    public int getAppointment_id() {
        return Appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        Appointment_id = appointment_id;
    }

    public String getPname() {
        return Pname;
    }

    public void setPname(String pname) {
        Pname = pname;
    }

    public String getPhNumber() {
        return phNumber;
    }

    public void setPhNumber(String phNumber) {
        this.phNumber = phNumber;
    }

    public String getDname() {
        return Dname;
    }

    public void setDname(String dname) {
        Dname = dname;
    }

    public String getEmailA() {
        return emailA;
    }

    public void setEmailA(String emailA) {
        this.emailA = emailA;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "AppointementData{" +
                "Appointment_id=" + Appointment_id +
                ", Pname='" + Pname + '\'' +
                ", phNumber='" + phNumber + '\'' +
                ", Dname='" + Dname + '\'' +
                ", emailA='" + emailA + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}