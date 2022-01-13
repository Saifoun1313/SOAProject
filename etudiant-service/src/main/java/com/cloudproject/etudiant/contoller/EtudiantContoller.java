package com.cloudproject.etudiant.contoller;



import com.cloudproject.etudiant.entity.Etudiant;
import com.cloudproject.etudiant.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/etudiants")
public class EtudiantContoller {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @GetMapping("/{id}")
    public Etudiant getEtudiant(@PathVariable("id") long id) {

        return etudiantRepository.findById(id).orElse(null);
    }

    @GetMapping(value = "/")
    public List<Etudiant> showAll() throws ParseException {
        return etudiantRepository.findAll();
    }

    @PostMapping(value="/")
    public Etudiant addEtudiant(@RequestBody final Etudiant Etudiant)
    {
        return etudiantRepository.save(Etudiant);
    }
    @PutMapping(value="/")
    public Etudiant modifyEtudiant(@RequestBody final Etudiant Etudiant)
    {

        return etudiantRepository.save(Etudiant);
    }

    @DeleteMapping(value="/{id}")
    public Boolean deleteEtudiant(@PathVariable("id") long id)
    {
        Etudiant Etudiant= etudiantRepository.findById(id).orElse(null);
        if (Etudiant!=null){
            etudiantRepository.delete(Etudiant);
            return true;
        }
        else
            return false;
    }

}
