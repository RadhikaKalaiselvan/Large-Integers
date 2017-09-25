package cs6301.g23;

/**
 * 
 * @author Akshaya Udayakumar
 *
 */

import java.io.BufferedInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


public class PostFixEvaluate {
	public static void main(String[] args) throws Exception{
		Scanner in;
		 if (args.length > 0) {
		 File inputFile = new File(args[0]);
		 in = new Scanner(inputFile);
		 } 
		 else {
			 in = new Scanner(new BufferedInputStream(System.in)); 
		 }
		 List<String> read = new ArrayList<String>();
		 String s;
		 while(in.hasNextLine()){
			 	 s = in.nextLine();
			 	 if(s.equals(";")){
			 		 break;
			 	 }
			 	 else 
			 		 read.add(s);			 
		 }
		 evaluatePostfix(read);
		 
	}
	public static String evaluatePostfix(List<String> read) throws Exception{
		int i;
		Num a,b, result = null, finalResult = null;
		Stack<Num> stack = new Stack<Num>();
		StringBuilder variable = null; 
		
		for(i=0;i< read.size();i++){
			String s = read.get(i);
			
			
			String[] token = s.split("\\s+");
			int j=0;
			if(token[0].equals(";")){
				break;
			}
			else if(isAlphabet(token[0])){
				variable.append(token[0]);
				variable.append(" ");
			}
			if(token[1].equals("=")){
				j=2;
				while(j<token.length){
					
					if(isDigit(token[j])){
						stack.push(new Num(token[j]));
						j++;
					}
					else if(isAlphabet(token[j])){
						j= j+1;
					}
					else{
						if(token[j].equals("+")){
							a = stack.pop();
							b = stack.pop();
							result = Num.add(a, b);
						}
						else if(token[j].equals("-")){
							a = stack.pop();
							b = stack.pop();
							result = Num.subtract(a, b);
						}
						else if(token[j].equals("*")){
							a = stack.pop();
							b = stack.pop();
							result = Num.product(a, b);
						}
						else if(token[j].equals("/")){
							a = stack.pop();
							b = stack.pop();
							result = Num.divide(a, b);
						}
						else if(token[j].equals("%")){
							a = stack.pop();
							b = stack.pop();
							result = Num.mod(a, b);
						}
						else if(token[j].equals("^")){
							a = stack.pop();
							b = stack.pop();
							result = Num.power(a, b);
						}
						else if(token[j].equals("|")){
							a = stack.pop();
							result = Num.squareRoot(a);
						}
						stack.push(result);
						j++;
					}
					if(token[j].equals(";")){
						finalResult = stack.peek();
						System.out.println(finalResult.toString());
						break;
					}	
				}	
			}
		}
		finalResult.printList();
		variable.append(finalResult);
		return variable.toString();
	}
	
	public static boolean isDigit(String s){
		return s!=null && s.matches("[0-9]+");
	}
	
	public static boolean isAlphabet(String s){
		return s!=null && s.matches("[a-zA-Z]+");
	}
}
