package com.projetopoo.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.Iterator;

public class Dev {
    private String nome; 
    private Set<Conteudo> conteudoInscristo = new LinkedHashSet<>();
    private Set<Conteudo> conteudoConcluido = new LinkedHashSet<>(); 
    
    public void InscreverBootcamp(Bootcamp bootcamp){
        this.conteudoInscristo.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this); 
    }

    public void progredir() {
      Optional<Conteudo> conteudo =  this.conteudoInscristo.stream().findFirst();
      if(conteudo.isPresent()){
        this.conteudoConcluido.add(conteudo.get());
        this.conteudoInscristo.remove(conteudo.get());
      }else {
        System.err.println("Você não está matrículado em nenhum conteúdo");
      }
    }

    public double calcularTotalXp() {
        Iterator<Conteudo> iterator = (Iterator<Conteudo>) this.conteudoConcluido.iterator();
        double soma = 0;
        while(iterator.hasNext()){
            double next = iterator.next().calcularXP();
            soma += next;
        }
        return soma;
    }
    private double extracted(Conteudo conteudo) {
        return conteudo.calcularXP();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudoInscristo() {
        return conteudoInscristo;
    }

    public void setConteudoInscristo(Set<Conteudo> conteudoInscristo) {
        this.conteudoInscristo = conteudoInscristo;
    }

    public Set<Conteudo> getConteudoConcluido() {
        return conteudoConcluido;
    }

    public void setConteudoConcluido(Set<Conteudo> conteudoConcluido) {
        this.conteudoConcluido = conteudoConcluido;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((conteudoInscristo == null) ? 0 : conteudoInscristo.hashCode());
        result = prime * result + ((conteudoConcluido == null) ? 0 : conteudoConcluido.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dev other = (Dev) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (conteudoInscristo == null) {
            if (other.conteudoInscristo != null)
                return false;
        } else if (!conteudoInscristo.equals(other.conteudoInscristo))
            return false;
        if (conteudoConcluido == null) {
            if (other.conteudoConcluido != null)
                return false;
        } else if (!conteudoConcluido.equals(other.conteudoConcluido))
            return false;
        return true;
    }

    
    
}
