package yaksha.soap_ws.mod_calculator.service;

import org.springframework.stereotype.Component;
import yaksha.soap_ws.mod_calculator.bean.CalculatorBean;

@Component
public class CalculatorService {
	public CalculatorBean performCalculation(CalculatorBean calculator)
	{
		String output="A";
		int operand1=calculator.getOperand1();
		int operand2=calculator.getOperand2();
		String operator=calculator.getOperator();
	 
		try
		{
			
			switch(operator)
			{
			case "+": output=""+(operand1+operand2);break;
			case "-": output=""+(operand1-operand2);break;
			case "*": output=""+(operand1*operand2);break;
			case "/": output=""+(operand1/operand2);break;
			}
						
		}catch(ArithmeticException ae)
		{
			output="B";
		}
		calculator.setResult(output);
		return calculator;
	}
}
