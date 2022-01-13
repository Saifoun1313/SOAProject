package com.cloudproject.livre.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Emprunt {

    @EmbeddedId
    private  EmpruntPK empruntPK;
    private Date dateRetour;
    private Date dateRetourRee;
}
