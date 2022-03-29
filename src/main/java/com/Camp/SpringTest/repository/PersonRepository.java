package com.Camp.SpringTest.repository;

import com.Camp.SpringTest.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
