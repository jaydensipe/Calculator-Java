/*COP 3330 Spring 2019. FT Quiz 2
 This Code is Written By: Jayden Sipe*/

public class Calculator {
	
	double number1;
	double number2;
	
	//Calculator Constructor
	
	Calculator(double num1, double num2)
	{
		number1 = num1;
		number2 = num2;
	}
	
	//Add method
	
	public double Add(double number1, double number2)
	{
		return number1 + number2;
	}
	
	//Subtract Method
	
	public double Sub(double number1, double number2)
	{
		return number1 - number2;
	}
	
	//Multiplication Method
	
	public double Mul(double number1, double number2)
	{
		return number1 * number2;
	}
	
	//Division Method
	
	public double Div(double number1, double number2)
	{
		return number1 / number2;
	}
	
	//Power Method
	
	public double Power(double number1, double number2)
	{
		return Math.pow(number1, number2);
	}
	
	//Modulus Method
	
	public double Mod(double number1, double number2)
	{
		return number1 % number2;
	}

	public double operatorFunction(double number1, double number2, String name) {
		
		if (name == "Add")
		{
			return Add(number1, number2);
		} else if (name == "Sub")
		{
			return Sub(number1, number2);
		} else if (name == "Mul")
		{
			return Mul(number1, number2);
		} else if (name == "Div")
		{
			return Div(number1, number2);
		} else if (name == "Power")
		{
			return Power(number1, number2);
		} else if (name == "Mod")
		{
			return Mod(number1, number2);
		}
		return 0;
	}
	
	
		
}