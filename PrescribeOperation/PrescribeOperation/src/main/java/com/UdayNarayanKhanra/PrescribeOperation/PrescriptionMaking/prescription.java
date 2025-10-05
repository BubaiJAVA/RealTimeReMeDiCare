package com.UdayNarayanKhanra.PrescribeOperation.PrescriptionMaking;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String medicineName;
    private LocalTime time; // Only hours and minutes
    private int totalMedicineToTake;
    private String afterBeforeEat; // "After Eat" or "Before Eat"
    private LocalDate expirydate;
    private String username;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public int getTotalMedicineToTake() {
        return totalMedicineToTake;
    }

    public void setTotalMedicineToTake(int totalMedicineToTake) {
        this.totalMedicineToTake = totalMedicineToTake;
    }

    public String getAfterBeforeEat() {
        return afterBeforeEat;
    }

    public void setAfterBeforeEat(String afterBeforeEat) {
        this.afterBeforeEat = afterBeforeEat;
    }

    public LocalDate getExpiryDate() {
        return expirydate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expirydate = expiryDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
