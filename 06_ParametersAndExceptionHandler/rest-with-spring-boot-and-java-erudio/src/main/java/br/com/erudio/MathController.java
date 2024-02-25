package br.com.erudio;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import br.com.erudio.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {

	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}

	private Double convertToDouble(String strNumber) {
		if(strNumber == null ) return 0D;
		// BR 10,25 US 10.25
		String number = strNumber.replaceAll(",", ".");
		if (isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null ) return false; 
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
		
	}
	
	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public double subtration(@PathVariable(value = "numberOne") double numberOne,
			@PathVariable(value = "numberTwo") double numberTwo) {
		return numberOne-numberTwo;
		
}
	@RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public double multiplication(@PathVariable(value = "numberOne") double numberOne,
			@PathVariable(value = "numberTwo") double numberTwo) {
		return numberOne*numberTwo;
		
}
	
	@RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public double division(@PathVariable(value = "numberOne") double numberOne,
			@PathVariable(value = "numberTwo") double numberTwo) {
		return numberOne / numberTwo;

}
	@RequestMapping(value = "/average/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public double average(@PathVariable(value = "numberOne") double numberOne,
			@PathVariable(value = "numberTwo") double numberTwo) {
		return (numberOne + numberTwo) / 2;
}
	@RequestMapping(value = "/squareroot/{number}", method = RequestMethod.GET)
	public double SquareRoot(@PathVariable(value = "number") double number) throws Exception {
		if(number < 0) {
			throw new UnsupportedMathOperationException("Não é possível calcular a raiz quadrada de um número negativo.");
		}
		return Math.sqrt(number);
}
}
