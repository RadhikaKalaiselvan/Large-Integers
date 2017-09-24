// Sample code for Level 2 driver for lp1

// Change following line to your group number
package cs6301.g23;

import java.util.LinkedList;

public class LP1L2 {
    public static void main(String[] args) throws Exception {
    	Num x = new Num("1100",100);
    	Num y = new Num("200",100);
    	//Num.checkEqualLengthAndPadZeros(x, y);
    	Num result=Num.product(x, y);
    	result.printList();
    System.out.println("result "+result+" x sign "+x.isNeg+" y "+y.isNeg);
	//Num.checkEqualLengthAndPadZeros(x,y);
	//Num z =Num.product(x, y);
	//z.printList();
	//Num.padZeros(x, 10).printList();
    }
}
