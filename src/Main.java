import java.util.Random;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// System.out.print(WordUtil.check_for_word("hello"));
		final int AVERAGE_AMT = 10;
		Random rng = new Random();
		double cost[] = new double[WordInputLayer.MAX_WORDS];
		for (int i = 0; i < WordInputLayer.MAX_WORDS; i++) {
			cost[i] = rng.nextDouble();
		}

		WordInputLayer wordLayer = new WordInputLayer();

		while (true) {
			int total = 1;
			for (int i = 0; i < WordInputLayer.MAX_WORDS; i++) {
				WordNeuron neuron = wordLayer.getWordNeuron(i);
				Word word = neuron.generateWord();
				if (word.isWord()) {
					total++;
					neuron.propagate(1 + 1 / WordInputLayer.MAX_WORDS);
				} else {
					neuron.propagate(1 - 1 / WordInputLayer.MAX_WORDS);
				}

			}
			double average = ((double) total)
					/ ((double) (1 + WordInputLayer.MAX_WORDS));
			System.out.println(average);

			/*
			 * try { Thread.sleep(1000); } catch (InterruptedException e) {
			 * e.printStackTrace(); }
			 */
			/*
			 * double maxCost = 0.0; for (int i = 0; i < cost.length; i++) {
			 * cost[i] = average * cost[i]; if(cost[i] > maxCost){ maxCost =
			 * cost[i]; } } if(maxCost < 1){ for (int i = 0; i < cost.length;
			 * i++) { cost[i] = cost[i]/average; } }
			 */
		}
	}
}
