import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeSet;

import javax.sound.midi.Soundbank;
import javax.swing.text.html.HTMLDocument.Iterator;
/*
 * Autor: Krzysztof Ptak 104166, grupa nr 2
 */
public class Rysunek {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		TreeSet<Figura> figury = new TreeSet<Figura>();
		
		double p1=0;
		double p2=0;
		
		double bok=0;
		double bok2=0;
		String nazwa;
		

		int wybor=0;
		
	
		
		
		while(wybor != 4) {
			try {
			
			System.out.println("Wybierz jaka figure chcesz stworzyc: ");
			System.out.println("1)Kolo\n2)Kwadrat\n3)Prostokat\n4)Zakoncz wprowadzanie danych");
			wybor = in.nextInt();
			

	
			
		if(wybor == 1) {

			Punkt wspol = new Punkt();
			
			System.out.println("Podaj dlugosc promienia: ");
			bok = in.nextDouble();
			if(bok < 0)
			{
				throw new IllegalArgumentException("Promien moze miec tylko wartosci dodatnie!");
			}
			
			System.out.println("Podaj wspolrzedne srodka punktu A: ");
			p1=in.nextDouble();
			wspol.setPozycjaX(p1);
			System.out.println("Podaj Wspolrzedne srodka punktu B: ");
			p2=in.nextDouble();
			wspol.setPozycjaY(p2);
			
			in.nextLine();
			System.out.println("Podaj nazwe Kola:");
			nazwa = in.nextLine();
			
			
			
			
			Kolo kolo = new Kolo(bok,nazwa,wspol);
			if(figury.contains(kolo)) {
				
				throw new IllegalArgumentException("Ten element juz istnieje!");
			}
			
			figury.add(kolo);
		}
			
		else if(wybor == 2) {

			Punkt wspol = new Punkt();
			
			System.out.println("Podaj dlugosc boku: ");
			bok = in.nextDouble();
			if(bok < 0)
			{
				throw new IllegalArgumentException("Bok moze miec tylko wartosci dodatnie!");
			}
			
			System.out.println("Podaj Wspolrzedne srodka punktu A: ");
			p1=in.nextDouble();
			wspol.setPozycjaX(p1);
			System.out.println("Podaj Wspolrzedne srodka punktu B: ");
			p2=in.nextDouble();
			wspol.setPozycjaY(p2);
			
			in.nextLine();
			System.out.println("Podaj nazwe Kwadratu:");
			nazwa = in.nextLine();
			
			Kwadrat kwadrat = new Kwadrat(bok,nazwa,wspol);
			if(figury.contains(kwadrat)) {
				
				throw new IllegalArgumentException("Ten element juz istnieje!");
			}
			figury.add(kwadrat);
		    

			
		}
		else if(wybor == 3) {

			Punkt wspol = new Punkt();
			
			System.out.println("Podaj dlugosc boku: A ");
			bok = in.nextDouble();
			if(bok < 0)
			{
				throw new IllegalArgumentException("Bok moze miec tylko wartosci dodatnie!");
			}
			
			System.out.println("Podaj dlugosc boku: B ");
			bok2 = in.nextDouble();
			
			if(bok2 < 0)
			{
				throw new IllegalArgumentException("Bok moze miec tylko wartosci dodatnie!");
			}
			System.out.println("Podaj Wspolrzedne srodka punktu A: ");
			p1=in.nextDouble();
			
			wspol.setPozycjaX(p1);
			System.out.println("Podaj Wspolrzedne srodka punktu B: ");
			p2=in.nextDouble();
			wspol.setPozycjaY(p2);
			
			in.nextLine();
			System.out.println("Podaj nazwe Prostokata:");
			nazwa = in.nextLine();
			
			Prostokat prostokat = new Prostokat(nazwa,wspol,bok,bok2);
			
			if(figury.contains(prostokat)) {
				
				throw new IllegalArgumentException("Ten element juz istnieje!");
			}
			figury.add(prostokat);
				
		}
		else {
			clearScreen();
		}
			

		
	   }catch (IllegalArgumentException e) {
		   clearScreen();
		    System.out.println(e.getMessage());
		    in.nextLine();
		}
		catch (InputMismatchException ex) {
			clearScreen();
		    System.out.println("Podales litere zamiast liczby! ");
		    in.nextLine(); 
		}

		
			
			

	
	}
		
		
		System.out.println("Wszystkie figury uporzadkowene rosnaco: ");
		for(Figura i: figury)
		{
			System.out.println(i.toString());
		}
		System.out.println("\n\n");
		
		
		
		TreeSet<Figura> figuryKlon = new TreeSet<Figura>();
		
		figuryKlon.addAll(figury);
		
		TreeSet<Figura> figuryPrzecinajace= new TreeSet<Figura>();
		
		  
		
		
		for(Figura i:figury) {

			
			for(Figura j: figuryKlon) {

			if(!i.equals(j)) {
				boolean spr = i.przecinaSie(j);
				if(spr)
				{
					figuryPrzecinajace.add(j);
				}
			}
			
		}
				
		System.out.println("Figura "+i.toString()+"\nPrzecina sie z: ");	
		for(Figura k:figuryPrzecinajace)
		{
			System.out.println(k.toString());
		}
		figuryPrzecinajace.clear();;
		System.out.println("\n");
			
	}
		System.out.println("Koniec Programu!");
		
		

		
		
		

	}
	
	public static void clearScreen() 
	{
	
		for(int i =0;i<7;i++)
			System.out.println(" ");

	}

}
