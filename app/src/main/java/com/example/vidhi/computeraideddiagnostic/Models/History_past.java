package com.example.vidhi.computeraideddiagnostic.Models;

/**
 * Created by marka_000 on 24-09-2017.
 */

public class History_past {
    int COLUMN_HEAD;
    int COLUMN_LEG;
    int COLUMN_EYE;
    int COLUMN_CHEST;
    int COLUMN_OTHERS;
    public String COLUMN_OTHERS_SURGICAL;
    public String COLUMN_OTHERS_MEDICAL;

    public void setHEAD(int COLUMN_HEAD) {
        this.COLUMN_HEAD = COLUMN_HEAD;
    }

    public int getHEAD() {
        return COLUMN_HEAD;
    }

    public void setLEG(int COLUMN_LEG) {
        this.COLUMN_LEG = COLUMN_LEG;
    }

    public int getLEG() {
        return COLUMN_LEG;
    }

    public void setEYE(int COLUMN_EYE) {
        this.COLUMN_EYE = COLUMN_EYE;
    }

    public int getEYE() {
        return COLUMN_EYE;
    }

    public void setCHEST(int COLUMN_CHEST) {
        this.COLUMN_CHEST = COLUMN_CHEST;
    }

    public int getCHEST() {
        return COLUMN_CHEST;
    }

    public void setOTHERS(int COLUMN_OTHERS) {
        this.COLUMN_OTHERS = COLUMN_OTHERS;
    }

    public int getOTHERS() {
        return COLUMN_OTHERS;
    }

//    public String getCOLUMN_OTHERS_SURGICAL() {
//        return COLUMN_OTHERS_SURGICAL;
//    }
//    public static void setCOLUMN_OTHERS_SURGICAL(String COLUMN_OTHERS_SURGICAL) {
//        this.COLUMN_OTHERS_SURGICAL = COLUMN_OTHERS_SURGICAL;
//    }
//
//    public String getCOLUMN_OTHERS_MEDICALL() {
//        return COLUMN_OTHERS_MEDICAL;
//    }
//
//    public static void setCOLUMN_OTHERS_MEDICAL(String COLUMN_OTHERS_MEDICAL) {
//        this.COLUMN_OTHERS_MEDICAL = COLUMN_OTHERS_MEDICAL;
//    }


}
