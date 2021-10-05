import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Reader {
    private String in ;
    private File file;
    private FileReader reader;
    private BufferedReader bufferedReader;

    public Reader(String file) throws FileNotFoundException {
        this.in = file;
        this.file = new File(in);
        this.reader = new FileReader(file);
        this.bufferedReader = new BufferedReader(reader);
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }
}
