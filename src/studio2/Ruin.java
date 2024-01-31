package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		System.out.print("What's the start amount?");
		int startAmount = scan.nextInt();
		System.out.print("What's the win chance?");
		double winChance = scan.nextDouble();
		System.out.print("What's the win limit?");
		int winLimit = scan.nextInt();
		System.out.print("What's the total simulations?");
		int totalSimulations = scan.nextInt();
		int currentAmount = startAmount;
		int days = 0;
        int amountRuin=0;
        double a=(1-winChance)/winChance;
        if(winChance==0.5) {
        	double expectedRuin=1-(startAmount/winLimit);
        }
        else
        { double expectedRuin=((Math.pow(a,startAmount)-Math.pow(a, winLimit))/(1-Math.pow(a,winLimit)));
        System.out.print("expected ruin rate=" +expectedRuin);
        }
		for (int i = 0; i < totalSimulations; i++) 
		{ days=0;
		 currentAmount=startAmount;
			while (currentAmount > 0 && currentAmount < winLimit) {
				double winOrNot = Math.random();
				if (winOrNot < winChance) {
					currentAmount++;
					days++;
				} else {
					currentAmount--;
					days++;
				}
			}
				
			if (currentAmount == 0) {
					System.out.println("Your day is ruined hahaha!");
					amountRuin++;
				} else
					System.out.println("You are successful! ");
				System.out.println("days= " + days);
			
		}
		System.out.println("Amount ruined= "+amountRuin);
		System.out.print("Ruin Rate="+ ((double)amountRuin)/totalSimulations);
	}

}
