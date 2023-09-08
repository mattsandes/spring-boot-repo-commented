package com.project.FirstProject.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //essa anotacao serve para que a framework cuide das configuracoes que forem feitas dentro dela;
public class StudentService {

    private final StudentRepository studentRepository;

    //A classe service é responsavel por manter a regra de negocio de uma aplicacao, ou seja, é mais ou menos aqui que fica o cerebro de uma aplicacao spring
    
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if(studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }

        studentRepository.save(student);
    }
    
}
