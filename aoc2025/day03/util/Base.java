package aoc2025.day03.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Base {
    public static ArrayList<String> getSequences() throws IOException {
        BufferedReader reader = Files.newBufferedReader(Path.of("aoc2025", "day03", "inputs.txt"));

        ArrayList<String> sequences = new ArrayList<String>();

        String line;
        while ((line = reader.readLine()) != null) {
            sequences.add(line);
        }

        reader.close();

        return sequences;
    }
}