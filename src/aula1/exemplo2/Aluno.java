package aula1.exemplo2;

public class Aluno {
    String nome;
    String registroMatricula;

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Aluno) &&
                ((Aluno) obj).registroMatricula.equals(registroMatricula);
    }

    @Override
    public String toString() {
        return registroMatricula + " - " + nome;
    }
}