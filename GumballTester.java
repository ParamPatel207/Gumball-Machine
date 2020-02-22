import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GumballTester {

	@Test
	void test() {
		GumballMachine test1 = new GumballMachine();
		//insert coins
		test1.insertCoin(0.05);
		test1.insertCoin(0.1);
		//invalid coin hence returned all coin
		test1.insertCoin(0.3);
		assertEquals(test1.moneyleft(),0.0);
		//insert coins
		test1.insertCoin(0.05);
		test1.insertCoin(0.25);
		//get red gum ball
		test1.getRedGumBall();
		//total money left as red gumball cost 0.05 is 0.25
		assertEquals(test1.moneyleft(),0.25);
		assertEquals(test1.returnChange(),0.25);
		//nothing left
		assertEquals(test1.moneyleft(),0.0);
	}

}
