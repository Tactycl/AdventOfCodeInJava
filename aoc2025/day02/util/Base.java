package aoc2025.day02.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Base {
	public static ArrayList<String> getIds() throws IOException {
		BufferedReader reader = Files.newBufferedReader(Path.of("aoc2025", "day02", "inputs.txt"));

		String line = reader.readLine();
		reader.close();

		String[] ranges = line.split(",");

		ArrayList<String> numbers = new ArrayList<String>();
		for (String string : ranges) {
			String[] numbers2 = string.split("-");
			if (numbers2[1] == null) {
				continue;
			}

			for (long i = Long.parseLong(numbers2[0]); i < Long.parseLong(numbers2[1]) + 1; i++) {
				numbers.add(Long.toString(i));
			}
		}

		return numbers;
	}
}