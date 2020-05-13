package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

    List<Whisky> findByName(String name);

    List<Whisky> findByAge(int age);

    List<Whisky> findByYear(int year);

    List<Whisky> findByDistilleryNameAndAge(String distilleryName, int age);
}
