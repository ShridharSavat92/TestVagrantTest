package com.testvagrant.newspapersubscriptions;

import java.util.Arrays;

public class NewsPaperSub {
	
	private String newsPaperName;
	private double [] dailyCost;
	
	public NewsPaperSub(String newsPaperName, double[] dailyCost) {
		super();
		this.newsPaperName = newsPaperName;
		this.dailyCost = dailyCost;
	}

	public String getNewsPaperName() {
		return newsPaperName;
	}

	public void setNewsPaperName(String newsPaperName) {
		this.newsPaperName = newsPaperName;
	}

	public double[] getDailyCost() {
		return dailyCost;
	}

	public void setDailyCost(double[] dailyCost) {
		this.dailyCost = dailyCost;
	}

	@Override
	public String toString() {
		return "NewsPaperSub [newsPaperName=" + newsPaperName + ", dailyCost=" + Arrays.toString(dailyCost) + "]";
	}

}
