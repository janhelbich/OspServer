package cz.fel.osp.servlet;

import java.util.HashSet;
import java.util.Set;

public class UniqueCounter {
	
	private final Set<String> uniques;
	
	private UniqueCounter () {
		uniques = new HashSet<>();
	}
	
	public static UniqueCounter getInstance() {
		return UniqueCounterHolder.INSTANCE;
	}
	
	private static final class UniqueCounterHolder {
		private static UniqueCounter INSTANCE = new UniqueCounter();
	}
	
	public void addWord(String word) {
		if (!uniques.contains(word)) {
			synchronized (uniques) {
				if (!uniques.contains(word)) {
					uniques.add(word);
				}
			}
		}
	}
	
	public int getUniquesCount() {
		return uniques.size();
	}
	
	public void clearUniques() {
		uniques.clear();
	}
	
	public Set<String> getUniques() {
		return new HashSet<>(uniques);
	}
}

