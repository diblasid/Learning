import java.util.Random;

public class LengthInputLayer {
	public static final int MAX_LENGTH = 10;
	private static Random rng = new Random();

	public static int getNextLength(double[] cost) {
		double max = 0.0;
		int length = 0;
		for (int i = 0; i < MAX_LENGTH; i++) {
			double val = rng.nextDouble() * cost[i];
			if (val > max) {
				max = val;
				length = i + 1;
			}
		}
		return length;
	}

	public static int getLength(int i) {
		return i + 1;
	}
}
