import java.util.Scanner;
import java.util.Vector;

class Main {

    /***
     * Esta funciòn evalua si un texto es mayor que 20 letras, si es asì
     * la recortara a 20 para no romper con el cuadro de la gráfica
     *
     * @param texto El texto a recortar
     * @return nuevo texto ya recortado<br><br/>
     *
     * <pre>
     * {@code
     * String materia = "Teoria de las causas sobre los accidentes automovilisticos"
     * materia = recortar(materia); // Teoria de las cau...
     * } <pre/>
     */
    public static String recortar(String texto) {
        char[] nuevoTexto = new char[20];
        texto.getChars(0, 17, nuevoTexto, 0);
        for(int i = 17; i < 20; i++) nuevoTexto[i] = '.';
        return new String(nuevoTexto);
    }

    public static void main(String[] args) {
        Vector<String> nombres = new Vector<>();
        Vector<Integer> calificaciones = new Vector<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("[Q para salir]");
        while(true) {
            System.out.print("Ponga la materia: ");
            String input = sc.nextLine();
            if(input.trim().equalsIgnoreCase("Q")) break;
            if(input.length() > 20) input = recortar(input);
            nombres.add(input);
        }

        for (String nombre : nombres) {
            System.out.printf("Ponga la calificación de la materia \"%s\": ", nombre);
            calificaciones.add(sc.nextInt());
        }

        System.out.printf("%c%s%c\n", '┌' , "─".repeat(125) , '┐');
        for(int i = 0; i < nombres.size(); i++) {
            System.out.printf("│ %20s: %s%s%c\n",
                    nombres.get(i),
                    "█".repeat(calificaciones.get(i)),
                    " ".repeat(102 - calificaciones.get(i)),
                    '│');
        } System.out.printf("%c%s%c\n", '└' , "─".repeat(125) , '┘');
    }
}