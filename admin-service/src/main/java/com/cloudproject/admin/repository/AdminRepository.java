package com.cloudproject.admin.repository;

import com.cloudproject.admin.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository <Admin,Long> {
    public Admin findByLoginAndAndPassword(String login,String password);
}
