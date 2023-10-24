/*This file contains the polynomial class with six methods: The constructor, add, eval, toString, and solve. 
 * All of these methods are used to create, manage, interpret, and solve (using Newton's method) polynomials. 
*/

public class Polynomial{
	//Initialize a new OrderedLinkedList named "Polynomial" to hold and sort monomials.
	private OrderedLinkedList<Monomial> Polynomial = new OrderedLinkedList<>();
	
	//Constructor method, creates an empty polynomial object with no monomials. 
	public Polynomial()
	{
		Polynomial newPolynomial = null; 
	}
	
	//Add method, used to insert a new monomial to the OrderedLinkedList object. 
	public void add(int coefficient, int degree) //@param, the monomials coefficient and degree. 
	{
		//initialize and insert a new monomial object  named "newMonomial" that holds the coefficient and degree. 
		Monomial newMonomial = new Monomial(coefficient,degree);
		Polynomial.insert(newMonomial);
		
	}
	/*Derivative method, used to obtain a new polynomial containing the derivative of the polynomial 
	 * stored as monomials in the OrderedLinkedList object. 
	*/
	public Polynomial derivative()
	{
		Polynomial newPolynomial = new Polynomial();
		
		/*for loop that takes the coefficient and degree contained in each monomial, creates a new monomial containing
		 * the updated derivative values, and adds it's derivative to the new polynomial object. 
		 */
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
		return  newPolynomial; //@return the new polynomial object containing the derivative. 
	}
	
	//eval method, used to evaluate the polynomial at a given double value. 
	public double eval(double x) //@param, double value which the polynomial will be evaluated at
	{
		double evaluation = 0.0;
		
		/* for loop that takes the coefficient and degree in each monomial, evaluates it with the 
		 * given value, and adds it to the double "evaluation".
		*/
		for (int i = 0; i < Polynomial.getSize();i++) 
		{
			Monomial monomial = Polynomial.get(i);
			int degree = monomial.getDegree();
			
			int coefficient = monomial.getCoefficient();
			
			
			double result = coefficient * Math.pow(x , degree); 
			evaluation += result;
		}

		return evaluation; //@return, new double obtained after evaluating polynomial. 
	}
	
	//toString method, used to return the polynomial as a string
	public String toString() 
	{
		String polyAsString = "";
		String operator = "";
		
		//for loop that gets the coefficient and degree from each monomial, adds the correct operator, and adds it to a string
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

		return (polyAsString); //@return, new string describing the polynomial 
	}
	
	//solve method, used to find the solution of the polynomial using Newton's method. 
	public double solve (double x0, double e, int T) throws SolutionNotFound //@param, initial value, stop value, and max attempts.
	{
		double current = 0.0;
		double previous = x0;
		
		//values for evaluation of previous at the polynomial and it's derivative. using derivative and eval methods. 
		double atPrevious = eval(previous);
		double atPreviousDerivative = derivative().eval(previous);
		
		
		//if the previous value at the derivative is not 0, using Newton's method, update the current value.
		if (atPreviousDerivative != 0) 
		{
			current = previous - (atPrevious / atPreviousDerivative);
		}
		
		//throw SolutionNotFound exception as the divisor (previous at derivative) will be 0
		else
		{
			throw new SolutionNotFound("divide by zero error");
		}
		
		int count = 0;
		
		//while the *
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
			return current; //@return the value of the solution
		}
	}
}
