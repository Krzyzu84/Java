
public abstract class FiguraForemna implements Figura {

	private double bok;
	private String nazwa;
	private Punkt punkt;
	
	
	
	
	public FiguraForemna(double bok, String nazwa, Punkt punkt) {
		super();
		this.bok = bok;
		this.nazwa = nazwa;
		this.punkt = punkt;
	}
	
	@Override
	public double pole() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double obwod() {
		// TODO Auto-generated method stub
		return 0;
	}
	public double getBok() {
		return bok;
	}
	
	
	public void setBok(double bok) {
		this.bok = bok;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public Punkt getPunkt() {
		return punkt;
	}
	public void setPunkt(Punkt punkt) {
		this.punkt = punkt;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(bok);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nazwa == null) ? 0 : nazwa.hashCode());
		result = prime * result + ((punkt == null) ? 0 : punkt.hashCode());
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
		FiguraForemna other = (FiguraForemna) obj;
		if (Double.doubleToLongBits(bok) != Double.doubleToLongBits(other.bok))
			return false;
		if (nazwa == null) {
			if (other.nazwa != null)
				return false;
		} else if (!nazwa.equals(other.nazwa))
			return false;
		if (punkt == null) {
			if (other.punkt != null)
				return false;
		} else if (!punkt.equals(other.punkt))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FiguraForemna [bok=" + bok + ", nazwa=" + nazwa + ", punkt=" + punkt + "]";
	}
	
	
	
}
