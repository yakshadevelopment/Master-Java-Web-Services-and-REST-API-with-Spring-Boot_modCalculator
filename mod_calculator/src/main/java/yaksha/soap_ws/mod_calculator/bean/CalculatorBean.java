package yaksha.soap_ws.mod_calculator.bean;

public class CalculatorBean {
	private int operand1;
	private int operand2;
	private String operator;
	private String result;
	public CalculatorBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CalculatorBean(int operand1, int operand2, String operator, String result) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
		this.operator = operator;
		this.result = result;
	}
	
	public CalculatorBean(int operand1, int operand2, String operator) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
		this.operator = operator;
	}
	public int getOperand1() {
		return operand1;
	}
	public void setOperand1(int operand1) {
		this.operand1 = operand1;
	}
	public int getOperand2() {
		return operand2;
	}
	public void setOperand2(int operand2) {
		this.operand2 = operand2;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "CalculatorBean [operand1=" + operand1 + ", operand2=" + operand2 + ", operator=" + operator
				+ ", result=" + result + "]";
	}
}