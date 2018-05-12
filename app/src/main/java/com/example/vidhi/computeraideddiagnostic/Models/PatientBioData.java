package com.example.vidhi.computeraideddiagnostic.Models;

/**
 * Created by Sudhanshu on 24-Sep-17.
 */

public class PatientBioData {

    int id;
   public String COLUMN_NAME;
    public String COLUMN_OCCUPATION;
    public String COLUMN_AGE;
    public String COLUMN_GENDER;
    public String COLUMN_PATIENT_HEIGHT;
    public String COLUMN_PATIENT_WEIGHT;
    public String COLUMN_DOB;
    public String COLUMN_MARTIAL_STATUS;
    public String COLUMN_ADDRESS;
    public String COLUMN_CONTACT;
    public String COLUMN_EMAIL ;
    public String COLUMN_BLOOD_GROUP;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCOLUMN_NAME() {
        return COLUMN_NAME;
    }

    public void setCOLUMN_NAME(String COLUMN_NAME) {
        this.COLUMN_NAME = COLUMN_NAME;
    }

    public String getCOLUMN_OCCUPATION() {
        return COLUMN_OCCUPATION;
    }

    public void setCOLUMN_OCCUPATION(String COLUMN_OCCUPATION) {
        this.COLUMN_OCCUPATION = COLUMN_OCCUPATION;
    }

    public String getCOLUMN_AGE() {
        return COLUMN_AGE;
    }

    public void setCOLUMN_AGE(String COLUMN_AGE) {
        this.COLUMN_AGE = COLUMN_AGE;
    }

    public String getCOLUMN_GENDER() {
        return COLUMN_GENDER;
    }

    public void setCOLUMN_GENDER(String COLUMN_GENDER) {
        this.COLUMN_GENDER = COLUMN_GENDER;
    }

    public String getCOLUMN_PATIENT_HEIGHT() {
        return COLUMN_PATIENT_HEIGHT;
    }

    public void setCOLUMN_PATIENT_HEIGHT(String COLUMN_PATIENT_HEIGHT) {
        this.COLUMN_PATIENT_HEIGHT = COLUMN_PATIENT_HEIGHT;
    }

    public String getCOLUMN_PATIENT_WEIGHT() {
        return COLUMN_PATIENT_WEIGHT;
    }

    public void setCOLUMN_PATIENT_WEIGHT(String COLUMN_PATIENT_WEIGHT) {
        this.COLUMN_PATIENT_WEIGHT = COLUMN_PATIENT_WEIGHT;
    }

    public String getCOLUMN_DOB() {
        return COLUMN_DOB;
    }

    public void setCOLUMN_DOB(String COLUMN_DOB) {
        this.COLUMN_DOB = COLUMN_DOB;
    }

    public String getCOLUMN_MARTIAL_STATUS() {
        return COLUMN_MARTIAL_STATUS;
    }

    public void setCOLUMN_MARTIAL_STATUS(String COLUMN_MARTIAL_STATUS) {
        this.COLUMN_MARTIAL_STATUS = COLUMN_MARTIAL_STATUS;
    }

    public String getCOLUMN_ADDRESS() {
        return COLUMN_ADDRESS;
    }

    public void setCOLUMN_ADDRESS(String COLUMN_ADDRESS) {
        this.COLUMN_ADDRESS = COLUMN_ADDRESS;
    }

    public String getCOLUMN_CONTACT() {
        return COLUMN_CONTACT;
    }

    public void setCOLUMN_CONTACT(String COLUMN_CONTACT) {
        this.COLUMN_CONTACT = COLUMN_CONTACT;
    }

    public String getCOLUMN_EMAIL() {
        return COLUMN_EMAIL;
    }

    public void setCOLUMN_EMAIL(String COLUMN_EMAIL) {
        this.COLUMN_EMAIL = COLUMN_EMAIL;
    }

    public String getCOLUMN_BLOOD_GROUP() {
        return COLUMN_BLOOD_GROUP;
    }

    public void setCOLUMN_BLOOD_GROUP(String COLUMN_BLOOD_GROUP) {
        this.COLUMN_BLOOD_GROUP = COLUMN_BLOOD_GROUP;
    }

    public PatientBioData() {

    }

    public PatientBioData(String COLUMN_NAME, String COLUMN_OCCUPATION, String COLUMN_AGE, String COLUMN_GENDER, String COLUMN_PATIENT_HEIGHT, String COLUMN_PATIENT_WEIGHT, String COLUMN_DOB, String COLUMN_MARTIAL_STATUS, String COLUMN_ADDRESS, String COLUMN_CONTACT, String COLUMN_EMAIL, String COLUMN_BLOOD_GROUP) {

        this.COLUMN_NAME = COLUMN_NAME;
        this.COLUMN_OCCUPATION = COLUMN_OCCUPATION;
        this.COLUMN_AGE = COLUMN_AGE;
        this.COLUMN_GENDER = COLUMN_GENDER;
        this.COLUMN_PATIENT_HEIGHT = COLUMN_PATIENT_HEIGHT;
        this.COLUMN_PATIENT_WEIGHT = COLUMN_PATIENT_WEIGHT;
        this.COLUMN_DOB = COLUMN_DOB;
        this.COLUMN_MARTIAL_STATUS = COLUMN_MARTIAL_STATUS;
        this.COLUMN_ADDRESS = COLUMN_ADDRESS;
        this.COLUMN_CONTACT = COLUMN_CONTACT;
        this.COLUMN_EMAIL = COLUMN_EMAIL;
        this.COLUMN_BLOOD_GROUP = COLUMN_BLOOD_GROUP;
    }

    public PatientBioData(int id, String COLUMN_NAME, String COLUMN_OCCUPATION, String COLUMN_AGE, String COLUMN_GENDER, String COLUMN_PATIENT_HEIGHT, String COLUMN_PATIENT_WEIGHT, String COLUMN_DOB, String COLUMN_MARTIAL_STATUS, String COLUMN_ADDRESS, String COLUMN_CONTACT, String COLUMN_EMAIL, String COLUMN_BLOOD_GROUP) {

        this.id = id;
        this.COLUMN_NAME = COLUMN_NAME;
        this.COLUMN_OCCUPATION = COLUMN_OCCUPATION;
        this.COLUMN_AGE = COLUMN_AGE;
        this.COLUMN_GENDER = COLUMN_GENDER;
        this.COLUMN_PATIENT_HEIGHT = COLUMN_PATIENT_HEIGHT;
        this.COLUMN_PATIENT_WEIGHT = COLUMN_PATIENT_WEIGHT;
        this.COLUMN_DOB = COLUMN_DOB;
        this.COLUMN_MARTIAL_STATUS = COLUMN_MARTIAL_STATUS;
        this.COLUMN_ADDRESS = COLUMN_ADDRESS;
        this.COLUMN_CONTACT = COLUMN_CONTACT;
        this.COLUMN_EMAIL = COLUMN_EMAIL;
        this.COLUMN_BLOOD_GROUP = COLUMN_BLOOD_GROUP;
    }

}
