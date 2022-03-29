package com.Camp.SpringTest.dao;

import com.Camp.SpringTest.Model.Agify;
import com.Camp.SpringTest.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Camp.SpringTest.repository.PersonRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;


    @Transactional
    public Person addPerson(Agify agify) {
        Person person = new Person(
                agify.getName(),
                agify.getAge(),
                agify.getCount()
        );
        return repository.save(person);
    }

    @Transactional
    public void deletePerson(Person person) {
        repository.delete(person);
    }

    public Person getPerson(int count) {
        Person byId = repository.getById(count);
        return byId;
    }

    public List<Person> getAll() {
        return repository.findAll();
    }
}
