package com.netprohets.app;

public class Model {
		
	private int numZero;
	private int numOne;
	private int totalLength;
	
	public int getTotalLength() {
		return totalLength;
	}


	public Model() {
		// TODO Auto-generated method stub
		this.numZero=0;
		this.numOne=0;
		this.totalLength=0;
	}
	
	
	@Override
	public String toString() {
		return "Model [numZero=" + numZero + ", numOne=" + numOne + ", totalLength=" + totalLength + "]";
	}

	public int getNumZero() {
		return numZero;
	}
	public void setNumZero(int numZero) {
		this.numZero = numZero;
		this.totalLength+=numZero;
	}
	public int getNumOne() {
		return numOne;
	}
	public void setNumOne(int numOne) {
		this.numOne = numOne;
		this.totalLength+=numOne;
	}
	
	
}
