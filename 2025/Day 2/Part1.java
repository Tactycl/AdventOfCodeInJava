import java.io.IOException;
import java.util.ArrayList;
import util.Base;

public class Part1 extends Base {
	public static void main(String[] args) throws IOException {
		ArrayList<String> numbers = getIds();

		long totalInvalid = 0;
		for (String string : numbers) {
			int mid = string.length() / 2;
			String first = (String)string.substring(0, mid);
			String last = (String)string.substring(mid, string.length());
			if (first.equals(last)) {
				totalInvalid += Long.parseLong(string);
			}
		}

		System.out.print(totalInvalid);
	}
}