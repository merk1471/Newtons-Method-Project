public class Polynomial{
	private Monomial OrderedLinkedList;
	
	public Polynomial(){
		//creates an empty polynomial
	}
	
	public void add(int coefficient, int degree) {
		//adds new monomial to polynomial, monomial of same degree does not already exist in polynomial and degree is greater than or equal to 0
	}
	
	public Polynomial derivative() {
		//returns polynomial whose derivative method was called
		Polynomial z = new Polynomial();
		return z;

	}
	
	public double eval(double z) {
		//returns f(z) where f is the polynomial stored in the class
		return z;
	}
	
	public String toString() {
		String poly;
		poly = "new string";
		return poly;
	}
	
	public void solve (double hello, double hi, int helloo, int hii) {
		//newtons method
	}
}