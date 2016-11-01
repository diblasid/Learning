import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class WordUtil {

	private static List<String> dict;
	private static Random rng;
	public static char[] alphabet;

	static {
		alphabet = "abcdefghijklmnopqrstuvwxyz'-".toCharArray();
		rng = new Random();
		dict = new ArrayList<String>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(
					"/usr/share/dict/american-english"));
			String str;
			while ((str = in.readLine()) != null) {
				dict.add(str);
			}
			in.close();
		} catch (IOException e) {
		}
	}

	public static boolean check_for_word(String word) {
		return dict.contains(word);
	}

	public static Word generateWord(int length, double[][] cost) {
		char[] text = new char[length];
		for (int i = 0; i < length; i++) {
			text[i] = getRandomChar(cost[i]);
		}
		return new Word(text);
	}

	public static char getRandomChar(double[] cost) {
		double max = 0.0;
		char result = ' ';
		for (int i = 0; i < cost.length && i < alphabet.length; i++) {
			double val = rng.nextDouble() * cost[i];
			if (val > max) {
				max = val;
				result = alphabet[i];
			}
		}
		return result;
	}
}