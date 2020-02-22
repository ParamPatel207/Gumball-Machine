import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GumballTester {
	//testing all correct inputs
	@Test
	void test() {
		GumballMachine test1 = new GumballMachine();
		//insert coins
		test1.insertCoin(0.05);
		test1.insertCoin(0.25);
		test1.getRedGumBall();
		//total money left as red gumball cost 0.05 is 0.25
		assertEquals(test1.moneyleft(),0.25);
		assertEquals(test1.returnChange(),0.25);
		//nothing left
		assertEquals(test1.moneyleft(),0.0);
	}
	//wrong coin insert
	@Test
	void test1() {
		GumballMachine test2 = new GumballMachine();
		test2.insertCoin(0.05);
		//invalid coin hence returned all coin
		test2.insertCoin(0.3);
		assertEquals(test2.moneyleft(),0.0);
		//insert coins
		test2.insertCoin(0.05);
		test2.insertCoin(0.25);
		//get red gum ball
		test2.getRedGumBall();
		assertEquals(test2.moneyleft(),0.25);
		assertEquals(test2.returnChange(),0.25);
		assertEquals(test2.moneyleft(),0.0);
	}
	//negative coins and 2 different ball and also negative moneyleft check
	@Test
	void test2()
	{
		GumballMachine test2 = new GumballMachine();
		test2.insertCoin(-1);
		//invalid coin hence returned all coin
		test2.insertCoin(0.3);
		assertEquals(test2.moneyleft(),0.0);
		System.out.println(test2.moneyleft());
		//insert coins
		test2.insertCoin(0.05);
		test2.insertCoin(0.10);
		//get red gum ball
		test2.getRedGumBall();
		test2.getYellowGumBall();
		assertEquals(0.0,test2.returnChange());
		assertEquals(0.0,test2.moneyleft());
		
	}
	//not enough money
	@Test
	void test3()
	{
		GumballMachine test2 = new GumballMachine();
		test2.insertCoin(0.05);
		test2.insertCoin(0.10);
		//get red gum ball
		test2.getRedGumBall();
		test2.getYellowGumBall();
		//not enough money in print
		//not enough money in print
		test2.getRedGumBall();
		test2.getYellowGumBall();
		assertEquals(0.0,test2.returnChange());
		assertEquals(0.0,test2.moneyleft());
		
	}
	//extra coins
	@Test
	void test4()
	{
		GumballMachine test2 = new GumballMachine();
		test2.insertCoin(0.05);
		test2.insertCoin(0.10);
		test2.insertCoin(0.05);
		test2.insertCoin(0.10);
		test2.insertCoin(0.05);
		test2.insertCoin(0.10);
		test2.insertCoin(0.05);
		test2.insertCoin(0.10);
		test2.insertCoin(0.05);
		test2.insertCoin(0.25);
		test2.insertCoin(0.05);
		test2.insertCoin(0.10);
		test2.getRedGumBall();
		test2.getYellowGumBall();
		test2.getRedGumBall();
		test2.getYellowGumBall();
		test2.getRedGumBall();
		test2.getYellowGumBall();
		test2.getRedGumBall();
		test2.getYellowGumBall();
		assertEquals(0.45,test2.returnChange());
		assertEquals(0.0,test2.moneyleft());	
	}
}
