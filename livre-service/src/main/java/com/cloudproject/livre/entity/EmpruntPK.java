package com.cloudproject.livre.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpruntPK implements Serializable {

    private Long idLivre;
    private Long idEtd;
    private Date dateEmprunt;

}
