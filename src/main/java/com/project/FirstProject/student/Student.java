package com.project.FirstProject.student;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity //essa anotacao diz que essa classe sera uma tabela no banco de dados;
@Table //usada para melhor criar a tabela no banco de dados;

public class Student {
    //Essa classe servira como um modulo para as informacoes que serao adicionadas no banco de dados;

    @Id //essa parte esta criando um gerador de ids para ser colocado no banco de dados;
    @SequenceGenerator( //estrutura do gerador de ids;
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )

    //gerando os valores para serem jogado no banco de dados;
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )

    private Long id;
    private String nome;
    private String email;
    private LocalDate dateDeNascimento;
    private Integer idade;
    
    //getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateDeNascimento() {
        return dateDeNascimento;
    }

    public void setDateDeNascimento(LocalDate dateDeNascimento) {
        this.dateDeNascimento = dateDeNascimento;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Student() { //construtor sem nada;
    }

    //construtores;

    public Student(String nome, String email, LocalDate dateDeNascimento, Integer idade) { //constutor sem id (sera gerado pelo banco de dados)
        this.nome = nome;
        this.email = email;
        this.dateDeNascimento = dateDeNascimento;
        this.idade = idade;
    }

    public Student(Long id, String nome, String email, LocalDate dateDeNascimento, Integer idade) { //construtor completo;
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dateDeNascimento = dateDeNascimento;
        this.idade = idade;
    }

    @Override //sobreescrevendo o metodo to string
    public String toString() {
        return "Student [id=" + id + ", nome=" + nome + ", email=" + email + ", dateDeNascimento=" + dateDeNascimento
                + ", idade=" + idade + "]";
    }
}
