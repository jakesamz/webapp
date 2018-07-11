package basic.collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TestList {
	
	public static void main(String[] args) {
		
		List<String> str = new ArrayList<>();
		
		Iterator<String> i = str.iterator();
		while(i.hasNext()) {
			i.next();
		}
		
	}
	
	public List<String> getStrings(){
		return Collections.emptyList();
	}

}
