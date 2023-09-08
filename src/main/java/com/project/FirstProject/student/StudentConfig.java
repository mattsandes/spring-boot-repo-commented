package com.project.FirstProject.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    
    //essa classe sera ficar responsvel por dizer ao repository o que pegar do banco de dados;

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student mateus = new Student(
                "Mateus Sandes", 
                "mateus.sandes@aidento.com", 
                LocalDate.of(1999, Month.APRIL, 28)
            ); // essas informacoes irão compor os objectos estudantes que estiverem sendo criados pelo metodo get;

            Student raquel = new Student(
                "Raquel Sandes", 
                "raquel.sandes@aidento.com", 
                LocalDate.of(2003, Month.AUGUST, 18)
            );

            Student zezin = new Student(
                "Zezinho da Ema", 
                "zezinho.da.ema@aidento.com", 
                LocalDate.of(1970, Month.APRIL, 23)
            );

            repository.saveAll(List.of(mateus, raquel, zezin));
        };
    }
}
