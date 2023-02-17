package aula1.exemplo2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Professor p1 = new Professor();
        p1.nome = "Humberto";
        p1.id = "5566";
        // Cria uma variável apontando para o objeto professor @123

        Professor p2 = new Professor();
        p2.nome = "Doisberto";
        p2.id = "5566";
        // Cria uma variável apontando para o objeto professor @456

        // p1 == p2 => false, porque são variáveis apontando para endereços diferentes

        // p2 = p1; //variável p2 aponta para o mesmo endereço da p1
        // p1 == p2 => true, porque são variávevis apontando para endereços iguais

        if (p1 == p2) {
            System.out.println("p1 == p2");
        } else {
            System.out.println("p1 != p2");
        }

        if (p1.equals(p2)) {
            System.out.println("p1 equals p2");
        } else {
            System.out.println("p1 not equals p2");
        }

        Aluno a1 = new Aluno();
        a1.nome = "Roberto";
        a1.registroMatricula = "235620";

        Aluno a2 = new Aluno();
        a2.nome = "Roberto";
        a2.registroMatricula = "235620";

        Aluno a3 = new Aluno();
        a3.nome = "Jonathan";
        a3.registroMatricula = "192309";

        Sala s = new Sala();
        s.nome = "Programação Orientada a Objetos";
        s.prof = p1;

        s.alunos.add(a1);
        s.alunos.add(a2);
        s.alunos.add(a3);

        System.out.println(s);

        Set<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(4);

        System.out.println("Set: " + set);

        List<Integer> lista = new ArrayList<Integer>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(4);

        System.out.println("Lista: " + lista);
    }
}