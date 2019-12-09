package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @PostMapping(path = "/people")
    public Person createPerson(@RequestBody Person p) {
        return this.personRepository.save(p);

    }

    @GetMapping("/people/{id}")
    public Person getPerson(@PathVariable Integer id) {
        return this.personRepository.findOne(id);
    }

    @GetMapping("/people")
    public List<Person> getPersonList() {
        return (List<Person>)this.personRepository.findAll();
    }

    @PutMapping("/people/{id}")
    public Person updatePerson(@PathVariable Integer id, @RequestBody Person p) {
        Person previous = getPerson(id);
        previous.setFIRST_NAME(p.getFIRST_NAME());
        previous.setLAST_NAME(p.getLAST_NAME());

        return this.personRepository.save(previous);
    }

    @DeleteMapping("people/{id}")
    public void DeletePerson(@PathVariable Integer id){
        this.personRepository.delete(id);
    }

}