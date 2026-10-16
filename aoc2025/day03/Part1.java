package aoc2025.day03;

import java.io.IOException;
import java.util.ArrayList;

import aoc2025.day03.util.Base;

public class Part1 {
    private static int getLargestJoltage(String sequence) {
        int largestJoltage = 0;
        for (int i = 0; i < sequence.length() - 1; i++) {
            for (int j = i + 1; j < sequence.length(); j++) {
                int joltage = Integer.parseInt(String.valueOf(sequence.charAt(i)) + String.valueOf(sequence.charAt(j)));
                if (joltage > largestJoltage) {
                    largestJoltage = joltage;
                }
            }
        }
        return largestJoltage;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<String> sequences = Base.getSequences();

        Integer totalJoltage = 0;
        for (String sequence : sequences) {
            totalJoltage += getLargestJoltage(sequence);
        }

        System.out.println(totalJoltage);
    }
}
