
public class Punkt {

	private double pozycjaX;
	private double pozycjaY;
	
	
	public Punkt()
	{
		this.pozycjaX=0;
		this.pozycjaY=0;
	}
	
	public Punkt(double pozycjaX, double pozycjaY) {
		super();
		this.pozycjaX = pozycjaX;
		this.pozycjaY = pozycjaY;
	}
	
	public void setPozycjaY(double pozycjaY) {
		this.pozycjaY = pozycjaY;
	}

	
	
	public double getPozycjaX() {
		return pozycjaX;
	}
	public void setPozycjaX(double pozycjaX) {
		this.pozycjaX = pozycjaX;
	}
	public double getPozycjaY() {
		return pozycjaY;
	}
	
	

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(pozycjaX);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(pozycjaY);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punkt other = (Punkt) obj;
		if (Double.doubleToLongBits(pozycjaX) != Double.doubleToLongBits(other.pozycjaX))
			return false;
		if (Double.doubleToLongBits(pozycjaY) != Double.doubleToLongBits(other.pozycjaY))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Punkt [pozycjaX=" + pozycjaX + ", pozycjaY=" + pozycjaY + "]";
	}

	
	
	
}
