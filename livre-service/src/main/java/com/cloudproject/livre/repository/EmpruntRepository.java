package com.cloudproject.livre.repository;

import com.cloudproject.livre.entity.Emprunt;
import com.cloudproject.livre.entity.EmpruntPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface EmpruntRepository extends JpaRepository<Emprunt,EmpruntPK> {

    @Query("SELECT e FROM Emprunt e WHERE e.empruntPK.idEtd = :etd")
    public List<Emprunt> findByEtudiant(@Param("etd") Long idEtd);

    @Query("SELECT e FROM Emprunt e WHERE e.empruntPK.idLivre = :livre")
    public List<Emprunt> findByLivre(@Param("livre") Long idLivre);

    @Query("SELECT e FROM Emprunt e WHERE e.empruntPK.dateEmprunt >= :dateInf " +
            "AND e.empruntPK.dateEmprunt <= :dateSup")
    public List<Emprunt> findByDateEmpIn(@Param("dateInf") Date dateInf,@Param("dateSup") Date dateSup);

    @Query("SELECT e FROM Emprunt e WHERE e.empruntPK.idLivre >= :date")
    public List<Emprunt> findByDateEmpAfter(@Param("date") Date date);

    @Query("SELECT e FROM Emprunt e WHERE e.empruntPK.idLivre <= :date")
    public List<Emprunt> findByDateEmpBefore(@Param("date") Date date);

}
