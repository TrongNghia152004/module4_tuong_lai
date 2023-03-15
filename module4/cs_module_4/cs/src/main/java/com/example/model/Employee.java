package com.example.model;

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
    @JoinColumn(name = "id_trinh_do" , nullable = false , referencedColumnName = "id_trinh_do")
}
