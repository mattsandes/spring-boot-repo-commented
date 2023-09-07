package com.project.FirstProject.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;

@Service //essa anotacao serve para que a framework cuide das configuracoes que forem feitas dentro dela;
public class StudentService {

    //A classe service é responsavel por manter a regra de negocio de uma aplicacao, ou seja, é mais ou menos aqui que fica o cerebro de uma aplicacao spring

    public List<Student> getStudents() {
        return List.of(new Student(1L, "Mateus Sandes", "mateus.sandes@aidento.com", LocalDate.of(1999, Month.APRIL, 28), 24)); // isso é o que sera retornado quando uma get for feito;
    }
    
}
