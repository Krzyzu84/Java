import java.text.DecimalFormat;

public class Kolo implements Figura, Comparable<Figura>{

	public static final double PI=3.14159265359;
	
	
	private double bok;
	private String nazwa;
	private Punkt punkt;


	private static DecimalFormat df2 = new DecimalFormat(".##");
	

	public Kolo(double bok, String nazwa, Punkt punkt) {
		this.bok = bok;
		this.nazwa = nazwa;
		this.punkt = punkt;
	}

	@Override
	public double pole() {
		
		return Kolo.PI*(bok*bok);
		
	}

	@Override
	public double obwod() {
		
		return 2*(Kolo.PI)*bok;
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
		Kolo other = (Kolo) obj;
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
		
		
		return "Kolo [promien=" + bok + ", nazwa=" + nazwa + ", punkt=" + punkt + ", getClass()=" + getClass()
				+" pole: "+ df2.format(this.pole())+" obwod: "+df2.format( this.obwod())+"]";
	}

	@Override
	public int compareTo(Figura o) {
		if(this.pole() == o.pole())
		{
			return 0;
		}
		else if(this.pole() < o.pole()) {
			return 1;
		}
		else
			return -1;
	}



	

	public boolean przecinaSie(Figura c)
	{
		if(c instanceof Kolo)
		{
			 Kolo c2 = (Kolo) c;
			 
			return Math.pow(this.getPunkt().getPozycjaX() - c2.getPunkt().getPozycjaX(), 2)
					+ Math.pow(this.getPunkt().getPozycjaY() - c2.getPunkt().getPozycjaY(), 2) <= Math.pow(this.getBok() + c2.getBok(), 2);
		}
		
		
		if(c instanceof Prostokat)
		{
			 Prostokat r = (Prostokat) c;
			 
			 
			 
			 
			double DeltaX = this.getPunkt().getPozycjaX() - Math.max(r.getPunkt().getPozycjaX(), Math.min(this.getPunkt().getPozycjaX(), r.getPunkt().getPozycjaX() + r.getBokA()));
			double DeltaY = this.getPunkt().getPozycjaX()- Math.max(r.getPunkt().getPozycjaY(), Math.min(this.getPunkt().getPozycjaX(), r.getPunkt().getPozycjaY()+ r.getBokB()));
			 return (DeltaX * DeltaX + DeltaY * DeltaY) < (this.pole()* this.pole());
			 

		}
		
		if(c instanceof Kwadrat)
		{
			Kwadrat k = (Kwadrat) c;
			
			double DeltaX = this.getPunkt().getPozycjaX() - k.getPunkt().getPozycjaX();
			double DeltaY = this.getPunkt().getPozycjaY() - k.getPunkt().getPozycjaY();
			
			return (DeltaX * DeltaX + DeltaY * DeltaY) < (this.pole() * this.pole());
				
			
			
		}
		
		return false;
		
		
	}
	




	
	

}
