public class Polynomial{
	private OrderedLinkedList<Monomial> Polynomial = new OrderedLinkedList<>();
	
	public Polynomial()
	{
		
	}
	
	public void add(int coefficient, int degree)
	{
		Monomial newMonomial = new Monomial(coefficient,degree);
		Polynomial.insert(newMonomial);
		
	}
	
	public Polynomial derivative()
	{
		Polynomial newPolynomial = new Polynomial();
		
		for (int i = 0; i < Polynomial.getSize();i++) 
		{
			Monomial monomial = Polynomial.get(i);
			int degree = monomial.getDegree();
			int coefficient = monomial.getCoefficient();
			
			if (degree > 0)
			{
			int dCoefficient = coefficient * (degree);
			int dDegree = degree - 1;
			newPolynomial.add(dCoefficient,dDegree);
			}
		}
		return  newPolynomial;
	}
	
	public double eval(double x) 
	{
		double evaluation = 0.0;
		
		for (int i = 0; i < Polynomial.getSize();i++) 
		{
			Monomial monomial = Polynomial.get(i);
			int degree = monomial.getDegree();
			
			int coefficient = monomial.getCoefficient();
			
			
			double result = coefficient * Math.pow(x , degree); 
			evaluation += result;
		}

		return evaluation;
	}
	
	public String toString() 
	{
		String polyAsString = "";
		String operator = "";
		for (int i = 0; i < Polynomial.getSize();i++)
		{
			Monomial monomial = Polynomial.get(i);
			int degree = monomial.getDegree();
			int coefficient = monomial.getCoefficient();
			
			if (coefficient > 0 && i != 0)
			{
				operator = " + ";
			}
			
			else if (coefficient < 0)
			{
				operator = " - ";
			}
			
			if (degree >= 0)
			{
				polyAsString += (operator + Math.abs(coefficient) + "*x^" + degree);
			}
		}

		return (polyAsString);
	}
	
	public double solve (double x0, double e, int T) throws SolutionNotFound
	{
		
		
		
		//implement while loop after to check for tolerance and maxIterations

		
		
		double current = 0.0;
		double previous = x0;
		
		double atPrevious = eval(previous);
		double atPreviousDerivative = derivative().eval(previous);
		
		
		if (atPreviousDerivative != 0) 
		{
			current = previous - (atPrevious / atPreviousDerivative);
		}
		
		else
		{
			throw new SolutionNotFound("divide by zero error");
		}
		
		int count = 0;
		
		while (count < T && Math.abs(previous - current) > e)
		{
			previous = current;
			atPrevious = (eval(previous));
			atPreviousDerivative = derivative().eval(previous);
			
			if (atPreviousDerivative != 0) 
			{
			current = previous - (atPrevious / atPreviousDerivative);
			}
			else
			{
				throw new SolutionNotFound("divide by zero error");
			}
			 
			++count;
			}
		
		if (count >= T) 
		{
			throw new SolutionNotFound("maximum iteration exceeded");
		}
		else
		{
			return current; 
		}
	}
}
