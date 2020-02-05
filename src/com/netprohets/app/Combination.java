package com.netprohets.app;

public class Combination {
		
	private String a;
	private String b;
	private String ab;
	private String ba;

	
	public Combination() {
		this.a="";
		this.b="";
		this.ab="";
		this.ba="";			
	}
	
	@Override
	public String toString() {
		return "Combination [a=" + a + ", b=" + b + ", ab=" + ab + ", ba=" + ba + "]";
	}
	public String getA() {
		return a;
	}
	public void setAbBa(String a,String b) {
//		System.out.println("ab "+a+b);
//		System.out.println("ba "+b+a);
		
		this.ab=a+b;
		this.ba=b+a;
//		System.out.println("ab "+ab);
//		System.out.println("ba "+ab);
	}
	
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public String getAb() {
		return ab;
	}
	public String getBa() {
		return ba;
	}
	
	
	

}
	
