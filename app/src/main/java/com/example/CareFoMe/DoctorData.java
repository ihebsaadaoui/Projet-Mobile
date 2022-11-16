package com.example.CareFoMe;

import java.io.Serializable;

public class DoctorData implements Serializable {

    static int doc_fav_id=1 ;
    String email;
    String name_f;

      DoctorData(){
        this.doc_fav_id=doc_fav_id++;
        this.email =email;
        this.name_f= name_f;


    }

    public DoctorData(String email, String name_f) {
        this.email = email;
        this.name_f = name_f;
    }

    public static int getDoc_fav_id() {
        return doc_fav_id;
    }

    public static void setDoc_fav_id(int doc_fav_id) {
        DoctorData.doc_fav_id = doc_fav_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName_f() {
        return name_f;
    }

    public void setName_f(String name_f) {
        this.name_f = name_f;
    }


    @Override
    public String toString() {
        return "DoctorData{" +
                "email='" + email + '\'' +
                ", name_f='" + name_f + '\'' +
                '}';
    }
}
