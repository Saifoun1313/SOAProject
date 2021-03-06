package com.cloudproject.livre.contoller;


import com.cloudproject.livre.entity.Emprunt;
import com.cloudproject.livre.entity.EmpruntPK;
import com.cloudproject.livre.repository.EmpruntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/emprunts")
public class EmpruntController {
    
    @Autowired 
    private EmpruntRepository empruntRepository;

   /* @GetMapping("/{idLivre}")
    public List<Emprunt> getEmpruntByLivre(@PathVariable("idLivre") long idLivre) {

        return empruntRepository.findByLivre(idLivre);
    }*/
/*
    @GetMapping("/{idEtd}")
    public List<Emprunt> getEmpruntByEtudiant(@PathVariable("idEtd") long idEtd) {

        return empruntRepository.findByEtudiant(idEtd);
    }

 */

    @GetMapping(value = "/")
    public List<Emprunt> showAll() throws ParseException {
        return empruntRepository.findAll();
    }

    @PostMapping(value="/{idLivre}&{idEtd}")
    public Emprunt addEmprunt(@RequestBody final Emprunt emprunt,@PathVariable("idLivre") Long idLivre,@PathVariable("idEtd") Long idEtd)
    {
        System.out.println("*****"+emprunt+idLivre+idEtd);
        EmpruntPK empruntPK =new EmpruntPK();
        empruntPK.setDateEmprunt(emprunt.getEmpruntPK().getDateEmprunt());
        empruntPK.setIdEtd(idEtd);
        empruntPK.setIdLivre(idLivre);
        emprunt.setEmpruntPK(empruntPK);
        return empruntRepository.save(emprunt);
    }
    @PutMapping(value="/")
    public Emprunt modifyEmprunt(@RequestBody final Emprunt emprunt/*,@PathVariable("idLivre") Long idLivre,@PathVariable("idEtd") Long idEtd*/)
    {
        /*System.out.println("*****"+emprunt+idLivre+idEtd);
        EmpruntPK empruntPK =new EmpruntPK();
        empruntPK.setDateEmprunt(emprunt.getDateRetour());
        empruntPK.setIdEtd(idEtd);
        empruntPK.setIdLivre(idLivre);
        emprunt.setEmpruntPK(empruntPK);*/
        System.out.println(emprunt);
        return empruntRepository.save(emprunt);
    }

    @PutMapping(value="/{idLivre}")
    public Boolean deleteEmprunt(@RequestBody final Emprunt emprunt,@PathVariable("idLivre") Long idLivre)
    {
        System.out.println(emprunt.toString());
        Emprunt Emprunt= empruntRepository.findById(emprunt.getEmpruntPK()).orElse(null);
        if (Emprunt!=null){
            empruntRepository.delete(Emprunt);
            return true;
        }
        else
            return false;

    }
    @GetMapping(value = "/{datedeb}&{datefin}")
    public int nbEmpruntByMonth (@PathVariable ("datedeb") String dateDeb, @PathVariable ("datefin") String datefin) throws ParseException {
        System.out.println(dateDeb);
        System.out.println(datefin);
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date datedb = formatter.parse(dateDeb);
        Date datefn = formatter.parse(datefin);
        return empruntRepository.findByDateEmpIn(datedb,datefn).size();
    }
   @GetMapping(value = "/encours")
    public int empEnCours (){
        return empruntRepository.getEmpEnCours().size();
    }

    @GetMapping(value = "/retard")
    public int empEnRetard (){
        return empruntRepository.getEmpRetard().size();
    }

    @GetMapping(value = "/dansdelai")
    public int empDansDelai (){
        return empruntRepository.getEmpDansDelai().size();
    }
}

