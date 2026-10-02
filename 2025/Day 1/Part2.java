import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Part2 {
	static final int POSITION_COUNT = 100;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = Files.newBufferedReader(Path.of("inputs.txt"));

		int currentPosition = 50;
		int password = 0;

		String line;
		while ((line = reader.readLine()) != null) {
			int offset = Integer.parseInt((String)line.subSequence(1, line.length()));
			boolean isReverse = line.charAt(0) == 'L';
			
			for (int i = 0; i < offset; i++) {
				currentPosition += isReverse ? -1 : 1;
				if (currentPosition < 0) {
					currentPosition += POSITION_COUNT;

				} else if (currentPosition > POSITION_COUNT - 1) {
					currentPosition -= POSITION_COUNT;
				}

				if (currentPosition == 0) {
					password++;
				}
			}
		}

		reader.close();

		System.out.print(password);
	}
}