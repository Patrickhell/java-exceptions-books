package org.lessons.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
	
	public static File fileText = new File("/tmp/tmp/test.txt");

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//Chiedo all'utente qualti libri vorrebbe controllando che non inserisca
		// un numero di libri inferiore o uguale a 0; fino a che non inserrisca un numero di libri 
		//superiore a 0 il programma non prosegue
		
        int nLibri = -1;
		
		while(nLibri <= 0) {
			
			try {
				
				System.out.print("Quanti libri vuoi inserire?" + "\n");
				nLibri = Integer.valueOf(sc.nextLine());
				
			} catch (Exception e) {
				
				System.out.println("Errore Riprova" + e.getMessage() );
			}
		}
		
        // creo o istanzio un nuovo oggetto libro della classe Libro, che inserisco nell'array di libri
		//contente nLibri.
		Libro[] libri = new Libro[nLibri];
		
		//per creare il libro chiedo all'utente di inserire i dati necessari
		// e la fine il libro viene inserito ad ogni iterazione di i nell'array libri così si crea un
		//array libri di nLibri a partir da un oggetto Libro.
		
		for(int i = 0; i < nLibri; i++) {
			
			System.out.println("Numero di libri: " + (i + 1) );
			
			System.out.println("Titolo:" + "\n");
			String titolo = sc.nextLine();
			
			System.out.print("Numero pagine: " + "\n");
			int numeroPagine = Integer.valueOf(sc.nextLine());
			
			System.out.print("Autore: " + "\n");
			String autore = sc.nextLine();
			
			System.out.print("Editore: " + "\n");
			String editore = sc.nextLine();
			
			// Exception: qui vienne controllato che l'utente inserisca i dati correttamente 
			// seconto il settaggio dei diversi metodi della classe Libro. 
			//se le regole non vengono rispettate si generano le exception alla fine dell'inserimento dei dati
			
			
			try {
				
				Libro libro = new Libro(titolo, numeroPagine, autore, editore);
				
				libri[i] = libro;
				
			} catch(Exception e) {
				
				System.out.println("Il libro non puo' essere creato: " + e.getMessage());
				i--;
			}
			

			System.out.println("\n--------------------------------------\n");
			
		}
		// si convertono i dati del/i libro/i sotto forma di array
		
		System.out.println(Arrays.asList(libri));
		
		
		// ANDIAMO A SCRIVERE I DATI DEL/I LIBRO/I INSERITI DALL'UTENTE
		
		FileWriter myWriter = null;
		
		try {
			
			myWriter = new FileWriter(fileText);
			
			for(int x = 0;x < nLibri; x++) {
				
				Libro libro = libri[x];
				
				System.out.println("Libro " + (x + 1) + ":\n" + libro);
				
				myWriter.write("titolo: " + libro.getTitolo() + "\n" + "Numero pagine: " + libro.getNumeroPagine() + "\n" + "Autore: " + libro.getAutore() + "\n" + "Editore: " + libro.getEditore() );
			}
			
		} catch(IOException e) {
			
			System.out.println("Errore di scrittura del file: " + e.getMessage());
			
		} finally {
			
			if (myWriter != null)
				try {
					myWriter.close();
				} catch (IOException e) { }
		}
		
		
		// ORA ANDIAMO A LEGGERLI
		
		
		Scanner reader = null;
		
		try {
			
			reader = new Scanner(fileText);
			
			while(reader.hasNextLine()) {
				
				String data = reader.nextLine();
				
				System.out.println(data);
				
			} 
			
			
		} catch (FileNotFoundException e) {
			
			System.out.println("Errore di lettura del file: " + e.getMessage());
			
		} finally {
			
			if (reader != null)
				
				reader.close();
		}
		
		
    }
}
