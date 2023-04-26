package com.testvagrant.newspapersubscriptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NewsPaperSubDriver {
	public static double[] getWeeklyCost(ArrayList<NewsPaperSub> a1) {
		double [] weeklyCost=new double[a1.size()];
		for(int i=0; i<a1.size(); i++) {
			double [] amount=a1.get(i).getDailyCost();
			double sum=0;
			for(int i1=0; i1<amount.length; i1++) {
				sum+=amount[i1];
			}
			
			weeklyCost[i]=sum;
		}
		return weeklyCost;
	}
	
	public static void getCombinations(ArrayList<NewsPaperSub> a1, double [] weeklyCost, int budget) {
		ArrayList<String []> ans=new ArrayList<>();
		for(int i=0; i<a1.size(); i++) {
			double currentSum=weeklyCost[i];
			for(int j=i+1; j<a1.size(); j++) {
				currentSum+=weeklyCost[j];
				String [] combi=new String[2];
				if(currentSum<=budget) {
					combi[0]= a1.get(i).getNewsPaperName(); 
					combi[1]= a1.get(j).getNewsPaperName();
					ans.add(combi);
				}
				else if(currentSum<29) {
					System.out.println("combination not found");
					break;
				}
				currentSum=weeklyCost[i];
			}
		}
		
		for(String [] b1: ans) {
			System.out.print(Arrays.toString(b1)+" ");
		}
	}
	
	public static void main(String[] args) {
		ArrayList<NewsPaperSub> a1=new ArrayList<>();
		a1.add(new NewsPaperSub("TOI",new double [] {3,3,3,3,3,5,6}));
		a1.add(new NewsPaperSub("Hindu",new double [] {2.5,2.5,2.5,2.5,2.5,4,4}));
		a1.add(new NewsPaperSub("ET",new double [] {4,4,4,4,4,4,10}));
		a1.add(new NewsPaperSub("BM",new double [] {1.5,1.5,1.5,1.5,1.5,1.5,1.5}));
		a1.add(new NewsPaperSub("HT",new double [] {2,2,2,2,2,4,4}));
		
		double [] weeklyCost=getWeeklyCost(a1);
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the amount of weekly subscriptions budget:");
		try {
		int budget=sc.nextInt();
		if(budget<0) {
			throw new NegativeInputException();
			}
		
		getCombinations(a1, weeklyCost, budget);
		
		}
		catch(InputMismatchException i) {
			System.out.println("Please, enter valid input to execute successfully!");
		}
		
	}

}
