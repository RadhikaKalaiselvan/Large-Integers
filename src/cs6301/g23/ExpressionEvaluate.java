package cs6301.g23;

import java.util.List;

public class ExpressionEvaluate {
	
	String expression;
	Num result;
	String variable;
	int lineNumber;
	String label;
	boolean isNumberedExpression;
	
	public ExpressionEvaluate(){
		this.expression = null;
		this.result = null;
		this.variable = null;
		this.label = null;
		this.lineNumber = 0;
		this.isNumberedExpression = false;
	}
		
	public ExpressionEvaluate(String expression, Num result,
			String variable, int label) {
		this.expression = expression;
		this.result = result;
		this.variable = variable;
		label = 0;
		lineNumber = 0;
		isNumberedExpression = false;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public Num getResult() {
		return result;
	}

	public void setResult(Num result) {
		this.result = result;
	}

	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}
	
	public String getLabel() {
		return label;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public void evaluate() throws Exception{
//		String stringResult = PostFixEvaluate.evaluatePostfix(expression);
//		String[] result1 = stringResult.split("\\s+");
//		variable = result1[0].charAt(0);
//		result = new Num(result1[1]);
	}

	public boolean isNumberedExpression() {
		return isNumberedExpression;
	}

	public void setNumberedExpression(boolean isNumberedExpression) {
		this.isNumberedExpression = isNumberedExpression;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	
}
