package com.example.fyp_app;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.Database;


@Entity
public class Remedy {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "CROPNAME")
    public String CropName;

    @ColumnInfo(name = "DISEASE")
    public String Disease;

    @ColumnInfo(name = "CAUSE")
    public String Cause;

    @ColumnInfo(name = "INDICATOR")
    public String Indicator;

    @ColumnInfo(name = "REMEDYNAME")
    public String Remedy_name;

    public Remedy() {
        // Empty constructor
    }
    @Override
    public String toString() {
        return "Remedy{" +
                "uid=" + uid +
                ", cropName='" + CropName + '\'' +
                ", disease='" + Disease + '\'' +
                ", cause='" + Cause + '\'' +
                ", indicator='" + Indicator + '\'' +
                ", remedy_name='" + Remedy_name + '\'' +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getCropName() {
        return CropName;
    }

    public void setCropName(String cropName) {
        CropName = cropName;
    }

    public String getDisease() {
        return Disease;
    }

    public void setDisease(String disease) {
        Disease = disease;
    }

    public String getCause() {
        return Cause;
    }

    public void setCause(String cause) {
        Cause = cause;
    }

    public String getIndicator() {
        return Indicator;
    }

    public void setIndicator(String indicator) {
        Indicator = indicator;
    }

    public String getRemedy_name() {
        return Remedy_name;
    }

    public void setRemedy_name(String remedy_name) {
        Remedy_name = remedy_name;
    }

    public Remedy(int uid, String cropName, String disease, String cause, String indicator, String remedy_name) {
        this.uid = uid;
        CropName = cropName;
        Disease = disease;
        Cause = cause;
        Indicator = indicator;
        Remedy_name = remedy_name;
    }

    public static Remedy[] populateData() {
        return new Remedy[] {
                new Remedy(1,"Apple","Apple Scab ","fungus","dry","pluck"),
                new Remedy(2,"blackgram","anthracnose","fungus","dry","pluck"),
                new Remedy(3,"blackgram","anthracnose","fungus","dry","pluck"),
                new Remedy(4,"blackgram","anthracnose","fungus","dry","pluck"),
                new Remedy(5,"blackgram","anthracnose","fungus","dry","pluck"),
                new Remedy(6,"blackgram","anthracnose","fungus","dry","pluck"),
                new Remedy(7,"blackgram","anthracnose","fungus","dry","pluck"),
                new Remedy(8,"blackgram","anthracnose","fungus","dry","pluck"),
                new Remedy(9,"blackgram","anthracnose","fungus","dry","pluck"),
                new Remedy(10,"blackgram","anthracnose","fungus","dry","pluck"),
                new Remedy(11,"blackgram","anthracnose","fungus","dry","pluck"),
                new Remedy(12,"blackgram","anthracnose","fungus","dry","pluck"),
                new Remedy(13,"blackgram","anthracnose","fungus","dry","pluck"),
                new Remedy(14,"blackgram","anthracnose","fungus","dry","pluck"),
                new Remedy(15,"blackgram","anthracnose","fungus","dry","pluck"),
                new Remedy(16,"blackgram","anthracnose","fungus","dry","pluck"),
                new Remedy(17,"blackgram","anthracnose","fungus","dry","pluck")


        };
    }

    public static Remedy getRemedyById(int uid) {
        // Create an array of Remedy objects
        Remedy[] remedies = {
                new Remedy(1,"Apple","Apple Scab ","fungus","dry","pluck"),
                new Remedy(2,"blackgram","anthracnose","fungus","dry","pluck"),
                new Remedy(3,"blackgram","anthracnose","fungus","dry","pluck"),
                new Remedy(4,"blackgram","anthracnose","fungus","dry","pluck"),
                new Remedy(5,"blackgram","anthracnose","fungus","dry","pluck"),
                new Remedy(6,"blackgram","anthracnose","fungus","dry","pluck"),
                new Remedy(7,"blackgram","anthracnose","fungus","dry","pluck"),
                new Remedy(8,"blackgram","anthracnose","fungus","dry","pluck"),
                new Remedy(9,"blackgram","anthracnose","fungus","dry","pluck"),
                new Remedy(10,"blackgram","anthracnose","fungus","dry","pluck"),
                new Remedy(11,"blackgram","anthracnose","fungus","dry","pluck"),
                new Remedy(12,"blackgram","anthracnose","fungus","dry","pluck"),
                new Remedy(13,"blackgram","anthracnose","fungus","dry","pluck"),
                new Remedy(14,"blackgram","anthracnose","fungus","dry","pluck"),
                new Remedy(15,"blackgram","anthracnose","fungus","dry","pluck"),
                new Remedy(16,"blackgram","anthracnose","fungus","dry","pluck"),
                new Remedy(17,"blackgram","anthracnose","fungus","dry","pluck")
        };

        // Loop through the array and return the Remedy object with the matching uid
        for (Remedy remedy : remedies) {
            if (remedy.getUid() == uid) {
                //todo link to the number from crop name
                System.out.println(remedy.getCropName().toString());
                return remedy;
            }
        }

        // If no matching Remedy object is found, return null
        return null;
    }






}