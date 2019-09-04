package basic.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Zuhe {
	
	public static void main(String[] args) {
		
		char[] letters = {'a', 'b', 'c'};
		List<String> results = new ArrayList<>(6);
		for (int i = 0; i < letters.length; i++) {
			char firstl = letters[i];
			String result = String.valueOf(firstl);
			for (int j = 0; j < letters.length; j++) {
				/*if(result.contains(letters[j])) {
					
				}*/
			}
		}
		
	}
	/*
	abc,
	acb,
	bac,
	bca,
	cab,
	cba,
	
	abcd
	abdc
	acbd
	acdb
	adbc
	adcb
*/
}
