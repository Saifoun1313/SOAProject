package com.cloudproject.etudiant.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtd;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private Date dateInscrit;
    private Long idAdmin;


}
