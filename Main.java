import java.util.Arrays;
import java.util.Vector;

class Main {
    public static void main(String[] args) {
        Vector<String> headers = new Vector<>(Arrays.asList("science", "maths", "spanish", "english", "Investigation about great life"));
        Vector<Integer> values = new Vector<>(Arrays.asList(130, 50, -1, 20, 75));
        Graphic subjects = new Graphic(headers, values);
        subjects.createGraphic(subjects.STAR);
    }
}
