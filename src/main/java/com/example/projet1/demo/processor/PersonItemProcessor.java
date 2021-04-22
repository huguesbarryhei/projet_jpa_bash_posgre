package com.example.projet1.demo.processor;

import com.example.projet1.demo.entity.Person;
import com.example.projet1.demo.entity.Pharmacien;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class PersonItemProcessor implements ItemProcessor<Person, Pharmacien> {

    //On instancie un nouvelle personne avec les infos récupérées par le reader
    @Override
    public Pharmacien process(Person person) throws Exception {
            Pharmacien pharmacien = new Pharmacien();

            pharmacien.setNom(person.getNom().toUpperCase(Locale.ROOT));

            String prenom = person.getPrenom();
            prenom = prenom.substring(0,1).toUpperCase(Locale.ROOT) + prenom.substring(1).toLowerCase(Locale.ROOT);
            pharmacien.setPrenom(prenom);

            pharmacien.setAdresse(person.getAdresse());

            return pharmacien;
    }
}
