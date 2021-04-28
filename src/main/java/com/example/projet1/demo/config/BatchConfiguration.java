package com.example.projet1.demo.config;

import com.example.projet1.demo.entity.Person;
import com.example.projet1.demo.entity.Pharmacien;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

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

}
