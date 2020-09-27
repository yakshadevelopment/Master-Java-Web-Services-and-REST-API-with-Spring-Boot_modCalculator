package yaksha.soap_ws.mod_calculator.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import edu.yaksha.calculatorapp.Calculator;
import edu.yaksha.calculatorapp.GetCalculationRequest;
import edu.yaksha.calculatorapp.GetCalculationResponse;
import yaksha.soap_ws.mod_calculator.bean.CalculatorBean;
import yaksha.soap_ws.mod_calculator.bean.OperatorException;
import yaksha.soap_ws.mod_calculator.service.CalculatorService;

@Endpoint
public class CalculatorEndpoint {
    @Autowired
    CalculatorService service;
	@PayloadRoot(namespace = "http://yaksha.edu/calculatorapp", localPart = "GetCalculationRequest")
	@ResponsePayload
	public GetCalculationResponse processCalculationRequest(@RequestPayload GetCalculationRequest request)
	{
		
		CalculatorBean calculatorBean=service.performCalculation(new CalculatorBean(request.getOperand1(), request.getOperand2(),request.getOperator()));
		GetCalculationResponse response=new GetCalculationResponse();
		if(calculatorBean.getResult().equals("A"))
			throw new OperatorException("Wrong Math Operator:"+request.getOperator());
		else if(calculatorBean.getResult().equals("B"))
			throw new ArithmeticException("Divide by zero(0) not possible:");
		Calculator calculator=new Calculator();
		calculator.setOperand1(calculatorBean.getOperand1());
		calculator.setOperand2(calculatorBean.getOperand2());
		calculator.setOperator(calculatorBean.getOperator());
		calculator.setResult(Integer.parseInt(calculatorBean.getResult()));
		response.setCalculator(calculator);
		return response;
	}
}
