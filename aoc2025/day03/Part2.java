package aoc2025.day03;

import java.io.IOException;
import java.util.ArrayList;

import aoc2025.day03.util.Base;

public class Part2 {
    private static int sequenceLength = 12;

    private static int findBiggestDigitInSubSequence(String sequence, int startIndex, int endIndex) {
        int largestDigit = 0;
        int largestDigitPosition = startIndex;

        for (int i = startIndex; i < Math.min(sequence.length(), endIndex); i++) {
            int digit = Integer.parseInt(sequence.substring(i, i + 1));
            if (digit > largestDigit) {
                largestDigit = digit;
                largestDigitPosition = i;
            }
        }

        return largestDigitPosition;
    }

    private static Long findBiggestJoltageInSequence(String sequence) {
        String joltage = "";
        int nextDigitPosition = 0;
        for (int i = 0; i < sequenceLength; i++) {
            int largestDigitPosition = findBiggestDigitInSubSequence(sequence, nextDigitPosition, sequence.length() - sequenceLength + i);
            joltage += sequence.substring(largestDigitPosition, largestDigitPosition + 1);
            nextDigitPosition = largestDigitPosition + 1;
        }
        return Long.parseLong(joltage);
    }

    public static void main(String[] args) throws IOException {
        ArrayList<String> sequences = Base.getSequences();

        Long totalJoltage = 0l;
        for (String sequence : sequences) {
            totalJoltage += findBiggestJoltageInSequence(sequence);
        }

        System.out.println(totalJoltage);
    }
}
