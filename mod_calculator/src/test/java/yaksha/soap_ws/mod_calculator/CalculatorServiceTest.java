package yaksha.soap_ws.mod_calculator;

import static org.junit.Assert.*;
import org.junit.Test;
import yaksha.soap_ws.mod_calculator.bean.CalculatorBean;
import yaksha.soap_ws.mod_calculator.service.CalculatorService;
import static yaksha.soap_ws.mod_calculator.TestUtils.*;
public class CalculatorServiceTest {

	@Test
	public void testPerformCalculation() throws Exception {
		CalculatorBean calBean=new CalculatorBean(30, 10, "/");
		CalculatorBean output=new CalculatorService().performCalculation(calBean);
		String value=output.getResult();
		yakshaAssert(currentTest(),(value.equals("3")?"true":"false"),businessTestFile);
		calBean=new CalculatorBean(30, 10, "#");
		 output=new CalculatorService().performCalculation(calBean);
		value=output.getResult();
		yakshaAssert(currentTest(),(value.equals("A")?"true":"false"),businessTestFile);
		calBean=new CalculatorBean(30, 0, "/");
		 output=new CalculatorService().performCalculation(calBean);
		value=output.getResult();
		yakshaAssert(currentTest(),(value.equals("B")?"true":"false"),businessTestFile);
	}
	
	@Test
    public void testExceptionConditon() throws Exception{
	 yakshaAssert(currentTest(),true,boundaryTestFile);
      }

	@Test
	public void testBoundaryCondition() throws Exception {
	  yakshaAssert(currentTest(),true,exceptionTestFile);
   }
}
