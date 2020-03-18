package it.polito.tdp.parole.model;

import java.util.*;

public class Parole {
	private LinkedList<String> words = new LinkedList<String>();
	public Parole() {
		//TODO
	}
	
	public void addParola(String p) {
		words.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(words);
		return words;
	}
	
	public void remove(String word) {
		words.remove(word);
	}
	
	public void reset() {
		words.removeAll(words);
	}

}
