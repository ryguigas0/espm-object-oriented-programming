package aula1.exemplo2;

import java.util.Scanner;

public class Terminal {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean alive = true;
        Sala sala = new Sala();

        do {
            System.out.print("> ");
            String input = s.nextLine().trim();

            if (input.length() == 0) {
                continue;
            }

            if (input.equalsIgnoreCase("help")) {
                System.out.println("add student -> adiciona aluno");
                System.out.println("show -> mostra a sala");
                System.out.println("exit -> encerra o terminal");
            } else if (input.equalsIgnoreCase("exit")) {
                alive = false;
            } else if (input.equalsIgnoreCase("show")) {
                System.out.println(sala);
            } else if (input.equalsIgnoreCase("add student")) {
                Aluno aluno = new Aluno();
                System.out.print("Digite o nome do aluno: ");
                aluno.nome = s.nextLine().trim();
                System.out.print("Digite o RA do aluno: ");
                aluno.registroMatricula = s.nextLine().trim();
                sala.alunos.add(aluno);
            } else {
                System.err.println("Comando desconhecido!");
            }
        } while (alive);

        s.close();
        System.out.println("Terminal encerrado");
    }
}
