import java.text.DecimalFormat;

public class Prostokat implements Figura, Comparable<Figura>{
	
	private Punkt punkt;
	private double bokA;
	private double bokB;
	private String nazwa;
	
	
	
	private static DecimalFormat df2 = new DecimalFormat(".##");
	
	public Prostokat(String nazwa,Punkt punkt, double bokA, double bokB) {
		this.nazwa=nazwa;
		this.punkt = punkt;
		this.bokA = bokA;
		this.bokB = bokB;
	}
	
	@Override
	public double pole() {
		
		return bokA*bokB;
	}
	@Override
	public double obwod() {
		
		return 2*(bokA)+2*bokB;
	}
	
	
	
	
	

	public Punkt getPunkt() {
		return punkt;
	}

	public void setPunkt(Punkt punkt) {
		this.punkt = punkt;
	}

	public double getBokA() {
		return bokA;
	}

	public void setBokA(double bokA) {
		this.bokA = bokA;
	}

	public double getBokB() {
		return bokB;
	}

	public void setBokB(double bokB) {
		this.bokB = bokB;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(bokA);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(bokB);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Prostokat other = (Prostokat) obj;
		if (Double.doubleToLongBits(bokA) != Double.doubleToLongBits(other.bokA))
			return false;
		if (Double.doubleToLongBits(bokB) != Double.doubleToLongBits(other.bokB))
			return false;
		if (punkt == null) {
			if (other.punkt != null)
				return false;
		} else if (!punkt.equals(other.punkt))
			return false;
		return true;
	}

	
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

	@Override
	public String toString() {
		return "Prostokat [punkt=" + punkt + ", bokA=" + bokA + ", bokB=" + bokB + ", nazwa=" + nazwa + ", getClass()="
				+" pole: "+ df2.format(this.pole())+" obwod: "+df2.format( this.obwod())+"]";
	}

	
	
	public boolean przecinaSie(Figura c)
	{
		if(c instanceof Kwadrat)
		{
			 Kwadrat r = (Kwadrat) c;
			 

			 
			 return this.getPunkt().getPozycjaX() < r.getPunkt().getPozycjaX() + r.getBok() 
			 		 && this.getPunkt().getPozycjaX() + this.getBokA() > r.getPunkt().getPozycjaX() 
					 && this.getPunkt().getPozycjaY() < r.getPunkt().getPozycjaY() +  r.getBok() 
					 && this.getPunkt().getPozycjaY()+ this.getBokB() > r.getPunkt().getPozycjaY();
		}
		
		
		if(c instanceof Prostokat)
		{
			 Prostokat r = (Prostokat) c;
			  
			   
		
			 return this.getPunkt().getPozycjaX() < r.getPunkt().getPozycjaX() + r.getBokA() 
			 		&& this.getPunkt().getPozycjaX() + this.getBokA() > r.getPunkt().getPozycjaX() 
			 		&& this.getPunkt().getPozycjaY() < r.getPunkt().getPozycjaY() +  r.getBokB() 
			 		&& this.getPunkt().getPozycjaY()+ this.getBokB() > r.getPunkt().getPozycjaY();
		}
		
		if(c instanceof Kolo)
		{
			Kolo k = (Kolo) c;
			
			double DeltaX = k.getPunkt().getPozycjaX() - Math.max(this.getPunkt().getPozycjaX(), Math.min(k.getPunkt().getPozycjaX(), this.getPunkt().getPozycjaX() + this.getBokA()));
			double DeltaY = k.getPunkt().getPozycjaX()- Math.max(this.getPunkt().getPozycjaY(), Math.min(k.getPunkt().getPozycjaX(), this.getPunkt().getPozycjaY()+ this.getBokB()));
			 return (DeltaX * DeltaX + DeltaY * DeltaY) < (k.pole()* k.pole());
		}
		
		return false;
		
		
	}



	
	
	

	
}
