package com.example.projet1.demo.writer;

import com.example.projet1.demo.repository.PharmacienRepository;
import com.example.projet1.demo.entity.Pharmacien;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class PharmacienItemWriter implements ItemWriter<Pharmacien> {

    @Autowired
    private PharmacienRepository pharmacienRepository;

    @Override
    public void write(List<? extends Pharmacien> items) throws Exception {
        log.info(String.valueOf(items));
        pharmacienRepository.saveAll(items);
    }
}