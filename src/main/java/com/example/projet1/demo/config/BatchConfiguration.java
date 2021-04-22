package com.example.projet1.demo.config;

import com.example.projet1.demo.entity.Person;
import com.example.projet1.demo.entity.Pharmacien;
import com.example.projet1.demo.processor.PersonItemProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired private JobBuilderFactory jobBuilderFactory;
    @Autowired private StepBuilderFactory stepBuilderFactory;
    @Autowired private ItemReader<Person> itemReader;
    @Autowired private ItemProcessor<Person, Pharmacien> itemProcessor;
    @Autowired private ItemWriter<Pharmacien> itemWriter;

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("Première étape : Filtrer les pharmaciens")
                .<Person,Pharmacien>chunk(3)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();
    }

    @Bean
    public Job job(Step step1) {
        return jobBuilderFactory.get("Ajouter les pharmaciens dans la DB")
                .start(step1)
                .build();
    }


    @Bean
    public JpaPagingItemReader<Person> reader(EntityManagerFactory entityManagerFactory) {
        return new JpaPagingItemReaderBuilder<Person>()
                .name("personItemReader")
                .entityManagerFactory(entityManagerFactory)
                .queryString("SELECT prenom, nom, adresse from Person where metier=Pharmacien")
                .pageSize(10)
                .build();
    }

    /*
    @Bean
    public FlatFileItemReader<Person> reader(@Value("${inputFile}") Resource resource) {
        return new FlatFileItemReaderBuilder<Person>()
                .name("personItemReader")
                .resource(resource)
                .linesToSkip(1)
                .delimited()
                .names(new String[]{"nom", "prenom", "salaire"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {{
                    setTargetType(Person.class);
                }})
                .build();
*/

}
