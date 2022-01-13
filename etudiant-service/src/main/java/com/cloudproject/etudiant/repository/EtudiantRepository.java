package com.cloudproject.etudiant.repository;

import com.cloudproject.etudiant.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository <Etudiant,Long> {

}
