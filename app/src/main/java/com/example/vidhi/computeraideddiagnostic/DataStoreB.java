package com.example.vidhi.computeraideddiagnostic;

/**
 * Created by nimesh on 18/9/17.
 */

public class DataStoreB {

    int id;
    String text1,text2;
    private static final String TAG="nimesh";

    public DataStoreB() {
    }

    public DataStoreB(String text1, String text2) {

        this.text1 = text1;
        this.text2 = text2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public DataStoreB(int id, String text1, String text2) {
        this.id = id;
        this.text1 = text1;
        this.text2 = text2;

    }
}
