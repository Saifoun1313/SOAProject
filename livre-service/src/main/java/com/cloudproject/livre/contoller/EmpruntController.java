package com.cloudproject.livre.contoller;


import com.cloudproject.livre.entity.Emprunt;
import com.cloudproject.livre.repository.EmpruntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("emprunts")
public class EmpruntController {
    
    @Autowired 
    private EmpruntRepository empruntRepository;

    @GetMapping("/{idLivre}")
    public List<Emprunt> getEmpruntByLivre(@PathVariable("idLivre") long idLivre) {

        return empruntRepository.findByLivre(idLivre);
    }

    @GetMapping("/{idEtd}")
    public List<Emprunt> getEmpruntByEtudiant(@PathVariable("idEtd") long idEtd) {

        return empruntRepository.findByEtudiant(idEtd);
    }

    @GetMapping(value = "/")
    public List<Emprunt> showAll() throws ParseException {
        return empruntRepository.findAll();
    }

    @PostMapping(value="/")
    public Emprunt addEmprunt(@RequestBody final Emprunt Emprunt)
    {
        return empruntRepository.save(Emprunt);
    }
    @PutMapping(value="/")
    public Emprunt modifyEmprunt(@RequestBody final Emprunt Emprunt)
    {

        return empruntRepository.save(Emprunt);
    }

    /*@DeleteMapping(value="/emprunt/{id}")
    public Boolean deleteEmprunt(@PathVariable("id") long id)
    {
        Emprunt Emprunt= empruntRepository.findById(id).orElse(null);
        if (Emprunt!=null){
            empruntRepository.delete(Emprunt);
            return true;
        }
        else
            return false;
    }*/
    
}
