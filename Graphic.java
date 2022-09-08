import java.util.Arrays;
import java.util.Vector;

public class Graphic {
    Vector<String> headers = new Vector<>();
    Vector<Integer> values = new Vector<>();
    final String STAR = "*";
    final String DEFAULT = "█";
    final String HASHTAG = "#";

    /**
     * A simple constructor
     */
    Graphic() {}

    /**
     * Constructor for initialize Graphic class
     *
     * @param headers the titles' names
     * @param values titles' values
     *
     * */
    Graphic(Vector<String> headers, Vector<Integer> values) {
        this.headers = headers;
        for(int i : values) if(i < 0) throw new IllegalArgumentException("You putted \"" + i + "\", NO NEGATIVE NUMBERS");
        this.values = values;
    }

    /**
     * If any header is equal or more than 20 characters that will be
     * cut
     *
     * @param header header to cut
     * @return header cut
     */
    public String cutHeader(String header) {
        if(header.length() <= 20) return header;
        char[] newHeader = new char[20];
        header.getChars(0, 17, newHeader, 0);
        for(int i = 17; i < 20; i++) newHeader[i] = '.';
        return new String(newHeader);
    }

    /**
     * Calculate area by the greatest title + the greatest value
     *
     * @return graphic area
     * */
    private int areaGraphic() {
        int mayorValue = 0, mayorHeader = 0;

        for(int lenValues : values) mayorValue = Math.max(lenValues, mayorValue);

        for(String lenHeaders : headers) mayorHeader = Math.max(lenHeaders.length(), mayorHeader);

        return mayorValue + mayorHeader;
    }

    /**
     * If user doesn't add graphic style, invoke graphic with DEFAULT design
     */
    public void createGraphic() {
        createGraphic(DEFAULT);
    }

    /**
     * if info is enough will create graphic, else return a message for give more data
     *
     * @param design graphic design (DEFAULT, STAR or HASHTAG)
     **/
    public void createGraphic(String design) {
        if(headers.isEmpty() && values.isEmpty())
            System.err.println("El vector de headers y/o values están vacíos, llenalas primero");

        System.out.println('┌' + "─".repeat(this.areaGraphic()) + '┐');

        for(int i = 0; i < headers.size(); i++) {
            System.out.printf("│ %20s:%s%s│\n",
                    this.cutHeader(headers.get(i)),
                    design.repeat(values.get(i)),
                    " ".repeat(this.areaGraphic() -
                            this.cutHeader(headers.get(i)).length() - (20 - this.cutHeader(headers.get(i)).length()) - values.get(i) - 2)
            );
        }
        System.out.println('└' + "─".repeat(this.areaGraphic()) + '┘');
    }

    public void setHeaders(String... arrayHeaders) {
        headers.addAll(Arrays.asList(arrayHeaders));
    }

    public void setValues(int... arrayValues) {
        for(int arrayValue : arrayValues) values.add(arrayValue);
    }
}
