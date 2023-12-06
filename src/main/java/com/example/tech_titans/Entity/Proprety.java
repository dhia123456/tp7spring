package com.example.tech_titans.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@Table(name = "property")
public class Proprety {
    @Id
    @GeneratedValue
    private Integer id_property;
    private String address;
    private double price;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RentalContract> rentalContracts = new ArrayList<>();
}
