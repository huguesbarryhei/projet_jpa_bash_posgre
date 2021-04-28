package com.example.projet1.demo.reader;

import com.example.projet1.demo.repository.PersonRepository;
import com.example.projet1.demo.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class PersonItemReader implements ItemReader<Person> {

    @Autowired
    private PersonRepository repository;

    private int i = -1;

    @Override
    public Person read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        List<Person> personnes = repository.findPersonByMetier("Pharmacien");
        if (i < personnes.size()-1) {
            i++;
            log.info(String.valueOf(personnes.get(i)));
            return personnes.get(i);
        }
        return null;
    }

}
