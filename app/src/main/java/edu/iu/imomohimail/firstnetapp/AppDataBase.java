package edu.iu.imomohimail.firstnetapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")



public class AppDataBase {

    @PrimaryKey
    private int user_phone_number;

    @ColumnInfo(name = "user_name")
    private String name;

    @ColumnInfo(name = "user_allergies")
    private String allergies;

    @ColumnInfo(name = "user_medications")
    private String medications;

    @ColumnInfo(name = "user_surgical_history")
    private String surgical_history;

    @ColumnInfo(name = "user_medical_conditions")
    private String medidcal_conditions;

    @ColumnInfo(name = "user_preferred_hospital")
    private String preferred_hospital;

    @ColumnInfo(name = "user_emergency_contact_phone_number")
    private String emergency_contact_phone_number;


    public int getUser_phone_number() {
        return user_phone_number;
    }

    public void setUser_phone_number(int user_phone_number) {
        this.user_phone_number = user_phone_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getMedications() {
        return medications;
    }

    public void setMedications(String medications) {
        this.medications = medications;
    }

    public String getSurgical_history() {
        return surgical_history;
    }

    public void setSurgical_history(String surgical_history) {
        this.surgical_history = surgical_history;
    }

    public String getMedidcal_conditions() {
        return medidcal_conditions;
    }

    public void setMedidcal_conditions(String medidcal_conditions) {
        this.medidcal_conditions = medidcal_conditions;
    }

    public String getPreferred_hospital() {
        return preferred_hospital;
    }

    public void setPreferred_hospital(String preferred_hospital) {
        this.preferred_hospital = preferred_hospital;
    }

    public String getEmergency_contact_phone_number() {
        return emergency_contact_phone_number;
    }

    public void setEmergency_contact_phone_number(String emergency_contact_phone_number) {
        this.emergency_contact_phone_number = emergency_contact_phone_number;
    }
}
