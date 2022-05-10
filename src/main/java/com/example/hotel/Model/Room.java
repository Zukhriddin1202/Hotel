package com.example.hotel.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String xonaRaqami;
    @Column(nullable = false)
    private int qavat;
    @Column(nullable = false)
    private int xonalarSoni;
    @ManyToOne
    Hotel hotel;

}
