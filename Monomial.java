public class Monomial implements Comparable<Monomial>{
	private int coefficient;
	private int degree;
	
	public Monomial(int coefficient, int degree) {
		
	}
	
	public int getCoefficient() {
		return this.coefficient;
	}
	
	public int getDegree() {
		return this.degree;
	}
	
	public int compareTo(Monomial m) {
		return this.degree - m.degree;
	}
}