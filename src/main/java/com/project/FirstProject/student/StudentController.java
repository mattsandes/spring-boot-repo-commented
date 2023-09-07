package com.project.FirstProject.student;

//Essa classe é responsavel por envia a resposta para a requisicao feita para algum endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "my/api/student") //o caminho para encontrar esse end point sera "locahost:8080/my/api/student"
public class StudentController {

    //Esse metodo vai servir como um retorno quando um get for feito;

    //criando uma referencia para a camada service que servira como adminstrador da logica de negocio para manipular as informacoes;
    private final StudentService studentService;

    //nessa parte, estamos usando injecao de dependencias (unindo a classe de service com essa de controle)
    @Autowired
    private StudentController(StudentService studentService){
        // this.studentService = new StudentService(); = deve-se evitar isso quando estamos codando para tornar a classe mais flexivel;

        //o autowired junta essa instance sem que seja necessario criar uma instancia de StudnetService dentro do controller;
        this.studentService = studentService; //devemos usar isso com o @Autowired ao invez do exemplo acima;
    }

	@GetMapping("/getStudent") //"hello/" e o que sera visto quando o get for feito;
	public List<Student> getStudents(){ //passando como um item de uma lista para ficar como json;
        return studentService.getStudents(); //pegando a referencia da classe StudentService;
	}
}
