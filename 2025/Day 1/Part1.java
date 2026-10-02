import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Part1 {
	static final int POSITION_COUNT = 100;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = Files.newBufferedReader(Path.of("2025", "Day 1", "inputs.txt"));

		int currentPosition = 50;
		int password = 0;

		String line;
		while ((line = reader.readLine()) != null) {
			int offset = Integer.parseInt((String)line.subSequence(1, line.length()));
			if (line.charAt(0) == 'L') {
				currentPosition = (currentPosition - offset + POSITION_COUNT) % POSITION_COUNT;

			} else {
				currentPosition = (currentPosition + offset) % POSITION_COUNT;
			}

			if (currentPosition == 0) {
				password++;
			}
		}

		reader.close();

		System.out.print(password);
	}
}