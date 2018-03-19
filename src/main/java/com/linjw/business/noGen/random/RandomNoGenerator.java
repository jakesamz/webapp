package com.linjw.business.noGen.random;

import java.util.Random;

import com.linjw.business.noGen.NoGenerator;

public class RandomNoGenerator implements NoGenerator {
	
	private int bits;

	public RandomNoGenerator() {
		bits = 6;
	}

	public RandomNoGenerator(int bits) {
		setBits(bits);
	}

	public String generate() {
		String value = "";
		for (int i = 0; i < bits; i++) {
			value += new Random().nextInt(10);
		}
		return value;
	}

	public int getBits() {
		return bits;
	}

	public void setBits(int bits) {
		this.bits = bits;
	}
}
