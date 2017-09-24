package cs6301.g23;

// Sample code for Level 1 driver for lp1

// Change following line to your group number


public class LP1L1 {
	 public static void main(String[] args) throws Exception{
		   
	    	/*Num a = new Num("12414210002");
	    	Num b = new Num(252356);
	    	Num pro = Num.findProduct(a, b);
	    	System.out.println(pro.numList);
	    	
	    	//System.out.println(pro.numList);
	    	//System.out.println(a.numList);
	    	//System.out.println(b.numList);
	    	 
	    	Num c = Num.divide(a,b);
	    	Num d = Num.mod(a, b);
	    	
	    	System.out.println("division" + c.numList);
	    	System.out.println("mod" + d.numList);
	    	
	    	Num s = Num.squareRoot(a);
	    	System.out.println("sqrt" + s);
	    	
	    //	Num u = new Num(12764);
	   // 	System.out.println(Num.productOf(u, u));
	    	
	   // 	Num check = new Num("1242232");
	   // 	int base = 100;
	   // 	System.out.println(Num.baseConversion(check.numList, 100).numList);
	    	
	    	/*
	    	System.out.println("A = " + a.numList );
	    	System.out.println("B = " + b.numList);
	    	System.out.println(Num.subtract(a, b).numList);
	    	*/
	    	//System.out.println(Num.product(Num.productOf(x,x));

	    /*	
	    	Num p = new Num(200000);
	    	Num x = new Num(5);
	    	Num g = Num.power(p, x);
	    	System.out.println("power" + g.numList);
	    	
	    	//System.out.println(Num.product(new Num("1242"),b).numList);
	    	//System.out.println(a.numList);
	    	//System.out.println(b.numList);
	    	*/
		 Long l=new Long("98765");
		// Long s=new Long("98");
		 System.out.println(l*l*l*l);
		 Num a=new Num(new Long("98765"));
		 Num b=new Num(new Long("3"));
		 Num c=Num.power(a, 4);
	    c.printList();
		 System.out.println("str "+c.toString());
	    	
	    }
}
