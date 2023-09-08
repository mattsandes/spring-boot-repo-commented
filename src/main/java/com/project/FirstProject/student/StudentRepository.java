package com.project.FirstProject.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository //anotando essa classe como um repositorio e como um acesso a dados no banco;
public interface StudentRepository extends JpaRepository<Student, Long>{
    
    //essa classe serve como uma ponto entre o banco de dados e a classe de servico

    //A query sera  SELECT * FROM student;

    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
