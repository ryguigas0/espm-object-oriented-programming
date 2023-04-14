package aula6;

public class ExcecaoExemplo extends Exception{
    @Override
    public String getMessage() {
        return "Erro inesperado";
    }
}
