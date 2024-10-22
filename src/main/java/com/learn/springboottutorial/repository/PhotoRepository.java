package com.learn.springboottutorial.repository;

import com.learn.springboottutorial.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author anthonylee
 */
public interface PhotoRepository  extends JpaRepository<Photo, Long> {
}
