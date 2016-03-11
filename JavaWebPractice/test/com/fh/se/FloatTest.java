package com.fh.se;

import java.math.BigDecimal;

public class FloatTest {
	public static void main(String[] args) {
		float f = 1.999999999999f;
		System.out.println(f);
		
		BigDecimal bigDecimal = new BigDecimal(1.999999999+"");
		bigDecimal.doubleValue();
		System.out.println(bigDecimal);
		BigDecimal setScale = bigDecimal.setScale(5, BigDecimal.ROUND_HALF_DOWN);
		System.out.println("big:"+setScale);
		System.exit(0); 
	}
}
