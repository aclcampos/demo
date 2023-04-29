package com.projetopoo;

import java.time.LocalDate;

import com.projetopoo.desafio.dominio.Bootcamp;
import com.projetopoo.desafio.dominio.Conteudo;
import com.projetopoo.desafio.dominio.Curso;
import com.projetopoo.desafio.dominio.Dev;
import com.projetopoo.desafio.dominio.Mentoria;


public class App 
{
    public static void main( String[] args ){
        Curso curso1 = new Curso(); 
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descrição do curso Java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso(); 
        curso2.setTitulo("Curso Python");
        curso2.setDescricao("Descrição do curso Python");
        curso2.setCargaHoraria(10);

     

        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTitulo("Mentoria de Java");
        mentoria1.setDescricao("Mentorias sobre a Java");
        mentoria1.setData(LocalDate.now());

        /*System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria1);*/


        Bootcamp bootcamp = new Bootcamp(); 
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Devwloper");
        bootcamp.getConteudos().add(curso1); 
        bootcamp.getConteudos().add(curso2); 
        bootcamp.getConteudos().add(mentoria1); 

        Dev devAnaClara = new Dev(); 
        devAnaClara.setNome("AnaClara");
        devAnaClara.InscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos" + devAnaClara.getConteudoInscristo());


        Dev devCamille = new Dev(); 
        devCamille.setNome("Camille"); 
        devCamille.InscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos" + devCamille.getConteudoInscristo());

    }
}
