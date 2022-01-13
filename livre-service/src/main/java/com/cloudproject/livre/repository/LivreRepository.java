package com.cloudproject.livre.repository;

import com.cloudproject.livre.entity.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreRepository extends JpaRepository <Livre,Long> {

}
