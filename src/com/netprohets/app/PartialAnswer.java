package com.netprohets.app;

public class PartialAnswer {
		
	private String a;
	private int count;
	@Override
	public String toString() {
		return "PartialAnswer [a=" + a + ", count=" + count + "]";
	}
	public PartialAnswer(String a) {
		super();
		this.a = a;
		this.count=1;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public int increment() {
		count +=1 ;
		return this.count;
	}
	
	
	
	
}
