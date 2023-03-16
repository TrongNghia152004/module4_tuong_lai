package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "toy")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "nam_sinh")
    private String dateOfBirth;
    @Column(name = "gioi_tinh")
    private String gender;
    @Column(name = "dia_chi")
    private String address;
    @Column(name = "so_dien_thoai")
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name = "id_trinh_do", nullable = false, referencedColumnName = "id_trinh_do")
    @JsonBackReference
    private LevelEmployee levelEmployee;
    public Employee() {
    }

    public Employee(int id, String name, String dateOfBirth, String gender, String address, String phoneNumber, LevelEmployee levelEmployee) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.levelEmployee = levelEmployee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LevelEmployee getLevelEmployee() {
        return levelEmployee;
    }

    public void setLevelEmployee(LevelEmployee levelEmployee) {
        this.levelEmployee = levelEmployee;
    }
}
