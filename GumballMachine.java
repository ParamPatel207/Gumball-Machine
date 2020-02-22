import java.util.Scanner;
import java.text.DecimalFormat;

public class GumballMachine {
	private static DecimalFormat df = new DecimalFormat("0.00");
	private final double redGumBall = 0.05;
	private final double yellowGumBall = 0.1;
	private double totalCost = 0.0;
	
	private void sop(String stmt)
	{
		System.out.println(stmt);
	}
	double moneyleft()
	{
		return totalCost;
	}
	 void getRedGumBall()
	{
		if(totalCost> redGumBall) {
		totalCost = totalCost - redGumBall;
		sop("your redGumBall is in machine slot");
		}
		else
		{
			sop("Not enough money inserted for red");
		}
	}
	 void getYellowGumBall()
	{
		if(totalCost> yellowGumBall) {
		totalCost = totalCost - yellowGumBall;
		sop("your yellowGumBall is in machine slot");
		}
		else
		{
			sop("Not enough money inserted for yellow");
		}
	}
	
	 double returnChange()
	{
		if(totalCost>0)
		{
			double cost = totalCost;
			totalCost = 0;
			return cost;
		}
		else
		{
			return -1;
		}
	}
	boolean insertCoin(double coin) 
	{
		if(coin == 0.05 ||coin == 0.1||coin == 0.25)
		{
			totalCost = totalCost + coin;
			sop("total amount in machine is " + totalCost);
			return true;
		}
		else {
		totalCost = totalCost + coin;
		double total = returnChange();
		sop("money returned please insert valid coins 0.05,0.1,0.25 \n total amount returned = "+ total);
		return false;
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double balance = 0.0;
		int redGumball = 0;
		int yellowGumball = 0;
		System.out.println("Please insert coin(s) .05, .10, .25.");
		System.out.println("Enter '1' in order to proceed to the gumball menu");
		System.out.println("Enter '2' to return change");
		while (scan.hasNext()) {
			String input = scan.next();

//			 Checks to see if input is valid
			if (input.equals(".05") || input.equals(".1") || input.equals(".25")) {
				double coin = Double.parseDouble(input);
				balance += coin;
				System.out.println("Total Balance: " + df.format(balance));
			} else if (input.equals("1")) {
				System.out.println("Red Gumball: 0.05, Yellow Gumball: 0.10");
				System.out.println("Enter 'exit' to leave the gumball menu'");
				System.out.println("Please enter what color gumball you would like to purchase: ");

				while (scan.hasNext()) {
					String color = scan.next().toLowerCase();
//					doubles aren't reliable for a straight 0 answer here
					if (balance < 0.01) {
						System.out.println("Insufficient funds.");
						System.out.println("Please insert more coin(s) .05, .10, .25.");
						System.out.println("Enter '1' in order to proceed to the gumball menu");
						System.out.println("Enter '2' to return change");
						break;
					}

					if (color.equals("red")) {
						redGumball++;
						System.out.println("Red Gumball dispensing...");
						balance = balance - 0.05;
						System.out.println("Total Balance: " + df.format(balance));

					}

					else if (color.equals("yellow")) {

						yellowGumball++;
						System.out.println("Yellow Gumball dispensing...");
						balance = balance - 0.10;
						System.out.println("Total Balance: " + df.format(balance));

					}

					else if(color.equals("exit")) {
						System.out.println("Please insert coin(s) .05, .10, .25.");
						System.out.println("Enter '1' in order to proceed to the gumball menu");
						System.out.println("Enter '2' to return change");
						break;
					}
				}
			} 
			
			else if (input.equals("2") && balance > 0) {
				System.out.println("Balance: " + balance);
				System.out.println("Change dispensing...");
				break;
			}
			else if(input.equals("exit")) {
				break;
			}
			else {
				System.out.println("Please enter a valid input value!");
			}
		}
		System.out.println("Total red gumballs dispensed: " + redGumball);
		System.out.println("Total yellow gumballs dispensed: " + yellowGumball);

	}
}
