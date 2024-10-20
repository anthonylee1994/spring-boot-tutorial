package com.learn.springboottutorial.repository;

import com.learn.springboottutorial.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author anthonylee
 */
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
