import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordNeuron {

	private static final char[] alphabet = "abcdefghijklmnopqrstuvwxyz'-"
			.toCharArray();
	public static final int MAX_LENGTH = 10;
	private double[] lengthCost;
	private double[][] charDataCost;
	private int length = 0;
	private int bestIndex = 0;
	private Random rng = new Random();
	private List<Integer> charIndices = new ArrayList<Integer>();

	public WordNeuron() {
		lengthCost = new double[MAX_LENGTH];
		charDataCost = new double[MAX_LENGTH][alphabet.length];

		for (int i = 0; i < MAX_LENGTH; i++) {
			lengthCost[i] = rng.nextDouble();
			for (int k = 0; k < alphabet.length; k++) {
				charDataCost[i][k] = rng.nextDouble();
			}
		}

	}

	public Word generateWord() {
		charIndices = new ArrayList<Integer>();

		double max = 0.0;
		for (int i = 0; i < MAX_LENGTH; i++) {
			double val = rng.nextDouble() * lengthCost[i];
			if (val > max) {
				max = val;
				length = i + 1;
				bestIndex = i;
			}
		}

		char[] text = new char[length];
		for (int i = 0; i < length; i++) {
			text[i] = getRandomChar(charDataCost[i]);
		}
		return new Word(text);
	}

	public void propagate(double scale) {
		lengthCost[bestIndex] *= scale;
		for (Integer i : charIndices) {
			charDataCost[bestIndex][i] *= scale;
		}
	}

	private char getRandomChar(double[] cost) {
		double max = 0.0;
		int newIndex = 0;
		for (int i = 0; i < cost.length && i < alphabet.length; i++) {
			double val = rng.nextDouble() * cost[i];
			if (val > max) {
				newIndex = i;
				max = val;
			}
		}
		charIndices.add(newIndex);
		return alphabet[newIndex];
	}
}
