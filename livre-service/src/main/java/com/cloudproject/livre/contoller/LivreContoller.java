package com.cloudproject.livre.contoller;




import com.cloudproject.livre.entity.Livre;
import com.cloudproject.livre.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/livres")
public class LivreContoller {

    @Autowired
    private LivreRepository livreRepository;

    @GetMapping("/{id}")
    public Livre getLivre(@PathVariable("id") long id) {

        return livreRepository.findById(id).orElse(null);
    }

    @GetMapping(value = "/")
    public List<Livre> showAll() throws ParseException {
        return livreRepository.findAll();
    }

    @PostMapping(value="/")
    public Livre addLivre(@RequestBody final Livre Livre)
    {
        return livreRepository.save(Livre);
    }
    @PutMapping(value="/")
    public Livre modifyLivre(@RequestBody final Livre Livre)
    {

        return livreRepository.save(Livre);
    }

    @DeleteMapping(value="/{id}")
    public Boolean deleteLivre(@PathVariable("id") long id)
    {
        Livre Livre= livreRepository.findById(id).orElse(null);
        if (Livre!=null){
            livreRepository.delete(Livre);
            return true;
        }
        else
            return false;
    }

}
