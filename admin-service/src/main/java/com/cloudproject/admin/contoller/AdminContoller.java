package com.cloudproject.admin.contoller;


import com.cloudproject.admin.entity.Admin;
import com.cloudproject.admin.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admins")
public class AdminContoller {

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/{id}")
    public Admin getAdmin(@PathVariable("id") long id) {

        return adminRepository.findById(id).orElse(null);
    }

    @GetMapping(value = "/")
    public List<Admin> showAll() throws ParseException {
        return adminRepository.findAll();
    }

    @PostMapping(value="/")
    public Admin addAdmin(@RequestBody final Admin admin)
    {
        return adminRepository.save(admin);
    }
    @PutMapping(value="/")
    public Admin modifyAdmin(@RequestBody final Admin admin)
    {

        return adminRepository.save(admin);
    }

    @DeleteMapping(value="/{id}")
    public Boolean deleteAdmin(@PathVariable("id") long id)
    {
        Admin admin= adminRepository.findById(id).orElse(null);
        if (admin!=null){
            adminRepository.delete(admin);
            return true;
        }
        else
            return false;
    }

}
