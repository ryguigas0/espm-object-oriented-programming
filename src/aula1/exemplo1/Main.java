package aula1.exemplo1;

public class Main {
    public static void main(String[] args) throws Exception {
        String x = "Bom dia";

        String y = "Bom";
        y += " dia";

        System.out.println("x => " + x);
        System.out.println("y => " + y);

        System.out.println(x + ((x.equals(y)) ? "equals ==" : " equals != ") + y);
        System.out.println(x + ((x == y) ? "== == " : " == != ") + y);

    }
}
