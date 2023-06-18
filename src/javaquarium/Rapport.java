package javaquarium;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Rapport {

    public static final List<String> logs = new ArrayList<>();

    public static void info(String info) {
        System.out.println(info);
        logs.add(info);
    }

    public static void enregisterLogs() {

        try {
            PrintWriter printWriter = new PrintWriter("rapport.txt");
            logs.forEach(printWriter::println);
            printWriter.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
