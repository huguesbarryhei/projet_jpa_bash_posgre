/*package com.example.projet1.demo.reader;

import com.example.projet1.demo.entity.Person;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.stereotype.Component;

@Component
public class CsvItemReader extends FlatFileItemReader<Person> {

    public FlatFileItemReader<Person> reader() {
        return new FlatFileItemReaderBuilder<Person>()
                .name("personItemReader")
                .resource()
                .linesToSkip(1)
                .delimited()
                .names(new String[]{"nom", "prenom", "salaire"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {{
                    setTargetType(Person.class);
                }})
                .build();
}
*/