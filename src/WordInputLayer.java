import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordInputLayer {

	public static final int MAX_WORDS = 20;
	private List<WordNeuron> words = new ArrayList<WordNeuron>();
	private Random rng = new Random();

	public WordInputLayer() {
		for (int i = 0; i < MAX_WORDS; i++) {
			words.add(new WordNeuron());
		}
	}

	public WordNeuron getWordNeuron(int index) {
		return words.get(index);
	}

	public Word getWord(double[] cost) {
		double max = rng.nextDouble() * cost[0];
		Word result = words.get(0).generateWord();
		for (int i = 1; i < MAX_WORDS; i++) {
			double val = rng.nextDouble() * cost[i];
			if (val > max) {
				result = words.get(i).generateWord();
			}
		}
		return result;
	}

}
