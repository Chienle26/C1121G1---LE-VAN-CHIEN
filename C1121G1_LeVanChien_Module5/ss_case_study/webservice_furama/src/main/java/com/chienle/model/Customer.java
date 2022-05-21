package com.chienle.model;

import javax.persistence.*;

@Entity(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String customerCode;

    private String customerName;
    @Column(columnDefinition = "date")
    private String customerBirthday;

    @Column(columnDefinition = "bit(1)")
    private Integer customerGender;

    private Integer customerIdCard;

    private String customerPhone;

    private String customerEmail;

    private String customerAddress;

    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "id")
    private CustomerType customerType;
}
