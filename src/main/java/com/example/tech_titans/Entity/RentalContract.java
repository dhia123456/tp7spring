package com.example.tech_titans.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Entity
@Data
@Table(name = "rentalcontract")
public class RentalContract {
    @Id
    @GeneratedValue
    private Integer id;
    private String tenant;
    private double monthlyRent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_owner")
    private Owner owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_property")
    private Proprety property;
}

