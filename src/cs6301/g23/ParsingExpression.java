package cs6301.g23;

import java.io.BufferedInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ParsingExpression {
	
	ExpressionEvaluate[] arrayObj = null;
	HashMap<String,Integer> mapVariables = new HashMap<String, Integer>();
	
	ParsingExpression(int size){
		this.arrayObj = new ExpressionEvaluate[size];
	}
	
	ExpressionEvaluate getObject(int index){
		return arrayObj[index];
	}
	
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
		 ParsingExpression pe = new ParsingExpression(read.size());
		 pe.parseInput(read);
		 pe.processInput(0);
	}
	
	public void parseInput(List<String> inputList){
		/**
		 * if input list contains assignment '=' store in the hashMap
		 * if it contains a expression 
		 */
		int index = 0 ; 
		String[] subExp = null;
		String postFix;
		
		for(int i=0;i<inputList.size();i++){
			ExpressionEvaluate obj = new ExpressionEvaluate();
			String s = inputList.get(i);
			String[] tokens = s.split("\\s+");
			obj.lineNumber = i;
			if(isDigit(tokens[0])){
				obj.label = tokens[0];
				obj.setVariable(tokens[1]);
				obj.setNumberedExpression(true);
				
				if(tokens.length > 2){
					subExp = Arrays.copyOfRange(tokens, 2, tokens.length);
				}
				else
					inputList.set(i, ";");
				
			}
			else{
				obj.setVariable(tokens[0]);
				if(tokens.length >2){
					
					subExp = Arrays.copyOfRange(tokens, 1, tokens.length);
					postFix = subExp.toString();
				}
			}
			
			postFix = infixToPostfix(subExp);
			inputList.set(i, postFix);
			System.out.println(inputList.get(i));
			obj.setExpression(postFix);
			if(!mapVariables.containsKey(obj.getVariable())){
				mapVariables.put(obj.getVariable(), i);
			}
			arrayObj[index] = obj;
			index++;
			
		}
		for(int i=0;i<inputList.size();i++){
			ExpressionEvaluate obj = arrayObj[i];
			System.out.println("line number "+obj.getLineNumber()+" label "+obj.getLabel()+" variable "+obj.getVariable()+" exp "+obj.getExpression()+" value"+obj.getResult());
		}
		System.out.println(Collections.singletonList(mapVariables));
	}
	
	public void processInput(int index) throws Exception{
		while(index < arrayObj.length){
			ExpressionEvaluate obj = getObject(index);
			String exp = obj.getExpression();
			String[] expression = exp.split("");
			String label;
			System.out.println(obj.getResult());
			if(expression[0].equals("?")){
				label = expression[2];
				int line = mapVariables.get(obj.variable);
				System.out.println("result"+arrayObj[line].result);
				while(!Num.checkZero(arrayObj[line].result)){
					for(ExpressionEvaluate ob:arrayObj){
						System.out.println("label "+ob.getLabel());
						if(label.equals(ob.getLabel())){
							processInput(ob.getLineNumber());
							break;
						}
					}	
				}
				
			}
			
			evaluatePostfix(exp, obj);
			index++;
		}
		
		
	}
	
	/**
	 * Function to convert infix to postfix
	 * @param infix
	 * @return
	 */
	
	public String infixToPostfix(String[] infix){
        StringBuilder postfixString = new StringBuilder();
        Stack<String> stack = new Stack<String>();
        
        for (int index = 0; index < infix.length; ++index) {
            String value = infix[index];
            if (value.equals("(")) {
                stack.push("("); 
            } 
            else if (value.equals(")")) {
                String oper = stack.peek();

                while (!(oper.equals("(")) && !(stack.isEmpty())) {
                    stack.pop();
                    postfixString.append(oper);
                    postfixString.append(" ");
                    if (!stack.isEmpty()) 
                        oper = stack.peek(); 
                }
                stack.pop(); 
            } 
            else if (value.equals("+") || value.equals("-")) {
                if (stack.isEmpty()) {
                    stack.push(value);
                } else {
                    String oper = stack.peek();
                    while (!(stack.isEmpty() || oper.equals(("(")) || oper.equals((")")))) {
                        oper = stack.pop(); 
                        postfixString.append(oper);
                        postfixString.append(" ");
                    }
                    stack.push(value);
                }
            } 
            else if (value.equals("*") || value.equals("/")) {
                if (stack.isEmpty()) {
                    stack.push(value);
                } else {
                    String oper = stack.peek();
                    while (!oper.equals(("(")) && !oper.equals(("+")) && !oper.equals(("-")) && !stack.isEmpty()) {
                        oper = stack.pop(); 
                        postfixString.append(oper);
                        postfixString.append(" ");
                    }
                    stack.push(value);
                }
            } 
            else if(value.equals(";")){
            	while(!stack.isEmpty()){
            		String oper = stack.pop();
            		postfixString.append(oper);
            		postfixString.append(" ");
            		
            	}
            	postfixString.append(value);
            	postfixString.append(" ");
            }
            else {
                postfixString.append(value);
                postfixString.append(" ");
            }
        }

        while (!stack.isEmpty()) {
            String oper = stack.peek();
            if (!oper.equals(("("))) {
                stack.pop();
                postfixString.append(oper); 
                postfixString.append(" ");
            }
        }
        return postfixString.toString();
    }
	
	public void evaluatePostfix(String line, ExpressionEvaluate object) throws Exception{
		Num a,b, finalResult = null;
		Num result = null;
		Stack<Num> stack = new Stack<Num>();
		StringBuilder variable = new StringBuilder(); 
		ExpressionEvaluate obj1 = null;
		String[] token = line.split(" ");
		int j=0;
		int lineNumber1 = 0;
		if(token[0].equals("=")){
			j=1;
			while(j<token.length){
				String curr = token[j];

				if(isDigit(curr)){
					System.out.print("inside "+new Num(curr).toString());
					stack.push(new Num(curr));
					j++;
				}
				else if(isAlphabet(curr)){
					lineNumber1 = mapVariables.get(curr);
					obj1 = arrayObj[lineNumber1];
					stack.push(obj1.getResult());
					j++;
				}
				else if(curr.equals(";")){
					finalResult = stack.peek();
					object.setResult(finalResult);
					lineNumber1 = object.getLineNumber();
					mapVariables.put(object.variable, lineNumber1);
					System.out.println("x = "+object.getResult().toString());
					break;
				}	
				else{
					if(curr.equals("+")){
						a = stack.pop();
						b = stack.pop();
						result = Num.add(a, b);
						object.setResult(result);
						mapVariables.put(object.variable, object.lineNumber);
					}
					else if(curr.equals("-")){
						a = stack.pop();
						b = stack.pop();
						result = Num.subtract(b, a);
						object.setResult(result);
						mapVariables.put(object.variable, object.lineNumber);
					}
					else if(curr.equals("*")){
						a = stack.pop();
						b = stack.pop();
						result = Num.product(a, b);
						object.setResult(result);
						mapVariables.put(object.variable, object.lineNumber);
					}
					else if(curr.equals("/")){
						a = stack.pop();
						b = stack.pop();
						result = Num.divide(b, a);
						object.setResult(result);
						mapVariables.put(object.variable, object.lineNumber);
					}
					else if(curr.equals("%")){
						a = stack.pop();
						b = stack.pop();
						result = Num.mod(a, b);
						object.setResult(result);
						mapVariables.put(object.variable, object.lineNumber);
					}
					else if(curr.equals("^")){
						a = stack.pop();
						b = stack.pop();
						result = Num.power(a, b);
						object.setResult(result);
						mapVariables.put(object.variable, object.lineNumber);
					}
					else if(curr.equals("|")){
						a = stack.pop();
						result = Num.squareRoot(a);
						object.setResult(result);
						mapVariables.put(object.variable, object.lineNumber);
					}
					stack.push(object.getResult());
					j++;
				}
			}	
		}
		
		//object.getResult().printList();
		variable.append(finalResult);
	}
	
	public boolean isDigit(String s){
		return s!=null && s.matches("[0-9]+");
	}
	
	public boolean isAlphabet(String s){
		return s!=null && s.matches("[a-zA-Z]+");
	}

	
}

