package tarea3_poo;

public class Calculo_fac {

    public static int facWhile(int n) {
        int resultado = 1;
        while (n > 1) {
            resultado *= n;
            n--;
        }
        return resultado;
    }

    public static int facEquiposRec(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * facEquiposRec(n - 1);
    }
}
