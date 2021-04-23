package com.example.projet1.demo.reader;

import com.example.projet1.demo.dao.PersonRepository;
import com.example.projet1.demo.entity.Person;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class PersonItemReader implements ItemReader<Person> {

    @Autowired
    private PersonRepository repository;

    private Iterator<Person> personIterator;

    @BeforeStep
    public void before(StepExecution stepExecution) {
        personIterator = repository.findPersonByMetier("Pharmacien").iterator();
    }

    @Override
    public Person read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(personIterator != null && personIterator.hasNext()) {
            return personIterator.next();
        } else {
            return null;
        }
    }
}
