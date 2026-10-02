import java.io.IOException;
import java.util.ArrayList;
import util.Base;

public class Part2 extends Base {
	public static void main(String[] args) throws IOException {
		ArrayList<String> numbers = getIds();

		long totalInvalid = 0;
		for (String string : numbers) {
			int length = string.length();

			ArrayList<Integer> divisors = new ArrayList<Integer>();
			for (int i = 1; i < length; i++) {
				if (length % i == 0) {
					divisors.add(i);
				}
			}

			boolean isValid = true;
			for (Integer divisor : divisors) {
				int count = length / divisor;

				String lastSplit = null;
				boolean divisorIsValid = false;
				for (int i = 0; i < count; i++) {
					String thisSplit = (String)string.substring(i * divisor, (i + 1) * divisor);
					if (lastSplit != null && !lastSplit.equals(thisSplit)) {
						divisorIsValid = true;
						break;
					}
					lastSplit = thisSplit;
				}

				if (!divisorIsValid) {
					isValid = false;
					break;
				}
			}

			if (!isValid) {
				totalInvalid += Long.parseLong(string);
			}
		}

		System.out.print(totalInvalid);
	}
}