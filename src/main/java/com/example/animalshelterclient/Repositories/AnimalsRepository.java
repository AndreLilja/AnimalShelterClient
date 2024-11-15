package com.example.animalshelterclient.Repositories;

import com.example.animalshelterclient.Models.Animals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalsRepository extends JpaRepository<Animals, Long> {
}
