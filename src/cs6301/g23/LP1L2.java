// Sample code for Level 2 driver for lp1

// Change following line to your group number
package cs6301.g23;

import java.util.LinkedList;

public class LP1L2 {
    public static void main(String[] args) throws Exception {
    	Num x = new Num("98765432123456789012456789012646378589165127456376",10);
    	Num y = new Num("56698364876147630847612984618476284587653095761286",10);
    	Num z = new Num("9876543212345678901",10);
    	//Num.checkEqualLengthAndPadZeros(x, y);
    	
    	Num result=Num.product(x, y);
   // 	result.printList();
  //  System.out.println("result "+result+" x sign "+x.isNeg+" y "+y.isNeg);
    	Num c = Num.subtract(x,y);
  //  	c.printList();
  //  System.out.println("c "+ c +" x sign "+x.isNeg+" y "+y.isNeg); 	
    
	//Num.checkEqualLengthAndPadZeros(x,y);
	//Num z =Num.product(x, y);
	//z.printList();
	//Num.padZeros(x, 10).printList();
     //  Num p = new Num("42067067247309158164843804394170094001512031695090",100);
     //  Num z = new Num("9876543212345678901",100);
    Num p = new Num("98765432123456789012456789012646378589165127456376",500);
    Num q = new Num("56698364876147630847612984618476284587653095761286",500);
    Num v = new Num("9876543212345678901",500);
    Num Z = Num.subtract(p,q);
       
       Num e = new Num("85849037612648764376549098612765874365348765673543");
       Num f = new Num("566983648761476308476145");
   //    div.printList();
  //     System.out.println("num : " + Num.dividetwo());
      System.out.println("div actual : " + Num.divide(c,z));
      System.out.println("div test : " + Num.divide(Z,v));
      
 //     Num mod = Num.mod(c,z);
      System.out.println("mod actual: " + Num.mod(c,z));
      System.out.println("mod test : " + Num.mod(Z,v));
      
    //  Num  l = new Num("98765432123456789012456789012646378589165127456376");
    //  Num sqrt = Num.squareRoot(l);
      System.out.println("sqrt actual : " + Num.squareRoot(x));
      System.out.println("sqrt test : " + Num.squareRoot(p));
      
      
      Num threee = new Num("2",10);
      Num three = new Num("2",500);
      System.out.println("power : "+ Num.power(c, threee));
      System.out.println("power : "+ Num.power(Z, three));
      
      
      Num test = new Num("98765432123456789012456789012646378589165127456376",567);
      System.out.println("test : " + Num.divideTwo(test));
      System.out.println("actual : " + Num.dividetwo(p));
    }
}
