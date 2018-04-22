import java.text.DecimalFormat;

public class Kwadrat extends FiguraForemna implements Comparable<Figura> {

	
	
	public Kwadrat(double bok, String nazwa, Punkt punkt) {
		super(bok,nazwa,punkt);

	}
	
	private static DecimalFormat df2 = new DecimalFormat(".##");
	
	
	
	@Override
	public double pole() {
		
		return super.getBok()*super.getBok();
	}

	@Override
	public double obwod() {
		
		return 4*(super.getBok());
	}

	@Override
	public double getBok() {
		// TODO Auto-generated method stub
		return super.getBok();
	}

	@Override
	public void setBok(double bok) {
		// TODO Auto-generated method stub
		super.setBok(bok);
	}

	@Override
	public String getNazwa() {
		// TODO Auto-generated method stub
		return super.getNazwa();
	}

	@Override
	public void setNazwa(String nazwa) {
		// TODO Auto-generated method stub
		super.setNazwa(nazwa);
	}

	@Override
	public Punkt getPunkt() {
		// TODO Auto-generated method stub
		return super.getPunkt();
	}

	@Override
	public void setPunkt(Punkt punkt) {
		// TODO Auto-generated method stub
		super.setPunkt(punkt);
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
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}








	@Override
	public String toString() {
		return "Kwadrat [pole()=" +df2.format(this.pole())+" obwod: "+df2.format( this.obwod())+ ", getBok()=" + getBok() + ", getNazwa()="
				+ getNazwa() + ", getPunkt()=" + getPunkt()  + "]";
	}

	public boolean przecinaSie(Figura c)
	{
		if(c instanceof Kwadrat)
		{
			 Kwadrat k = (Kwadrat) c;
			 
			 
			 return ( (Math.abs(this.getPunkt().getPozycjaX() -k.getPunkt().getPozycjaX())) < (this.getBok() / 2.0 + k.getBok()/ 2.0 )
			            && (Math.abs(this.getPunkt().getPozycjaY() -k.getPunkt().getPozycjaY()) < this.getBok() / 2.0 + k.getBok()/ 2.0) );
		}
		
		
		if(c instanceof Prostokat)
		{
			 Prostokat r = (Prostokat) c;
			  
	
			    
				 return this.getPunkt().getPozycjaX() < r.getPunkt().getPozycjaX() + r.getBokA() &&
						 this.getPunkt().getPozycjaX() + this.getBok() > r.getPunkt().getPozycjaX() && this.getPunkt().getPozycjaY() < r.getPunkt().getPozycjaY() + 
						 r.getBokB() && this.getPunkt().getPozycjaY()+ this.getBok() > r.getPunkt().getPozycjaY();
			    	 
		
		}
		if(c instanceof Kolo)
		{
			Kolo k = (Kolo) c;
			
			double DeltaX = k.getPunkt().getPozycjaX() - this.getPunkt().getPozycjaX();
			double DeltaY = k.getPunkt().getPozycjaY() - this.getPunkt().getPozycjaY();
			
			return (DeltaX * DeltaX + DeltaY * DeltaY) < (k.pole() * k.pole());
		}
		
		return false;
		
		
	}




	
	
	
	


	
}
