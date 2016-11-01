import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Word {

	private HashMap<Character, Set<Short>> counter;

	private char[] text;

	public Word(char[] text) {
		counter = new HashMap<Character, Set<Short>>();
		this.text = text;
		for (short i = 0; i < this.text.length; i++) {
			if (counter.containsKey(this.text[i])) {
				((Set<Short>) counter.get(this.text[i])).add(i);
			} else {
				Set<Short> temp = new HashSet<Short>();
				temp.add(i);
				counter.put(this.text[i], temp);
			}
		}
	}

	public HashMap<Character, Set<Short>> getCharData() {
		return counter;
	}

	public boolean isWord() {
		System.out.print(new String(text) + " ");
		System.out.println(WordUtil.check_for_word(new String(text)));
		return WordUtil.check_for_word(new String(text));
	}
}
