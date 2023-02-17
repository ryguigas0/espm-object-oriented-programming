package aula1.exemplo2;

import java.util.HashSet;
import java.util.Set;

public class Sala {
    String nome = null;
    Professor prof;
    Set<Aluno> alunos = new HashSet<Aluno>();

    @Override
    public String toString() {
        String output = "";
        output += "-------------\n";
        output += String.format("NOME: %s\n", nome);
        output += String.format("PROFESSOR: %s\n", prof);
        output += String.format("ALUNOS: %s\n", alunos);
        output += "-------------\n";
        return output;
    }
}