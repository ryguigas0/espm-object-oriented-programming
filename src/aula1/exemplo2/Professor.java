package aula1.exemplo2;

public class Professor {
    String id;
    String nome;
    double valorHoraAula;

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Professor) && ((Professor) obj).id.equals(this.id);
    }

    @Override
    public String toString() {
        return id + " - " + nome;
    }
}