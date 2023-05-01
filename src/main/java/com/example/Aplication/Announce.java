package com.example.Aplication;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "announce")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Announce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String description;
    private String imagen;
    private String animal;
    private String genero;
    private Integer edad;
    private String raza;
    private String direccion;
}

