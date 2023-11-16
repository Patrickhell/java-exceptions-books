package org.lessons.java;

public class Libro {

	 private String titolo;
	 private int numeroPagine;
	 private String autore;
	 private String editore;
	 
	 public Libro (String titolo, int numeroPagine, String autore, String editore) throws Exception  {
		 
		 setTitolo(titolo);
		 setNumeroPagine(numeroPagine);
		 setAutore(autore);
		 setEditore(editore);
		 
		 
	 }

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) throws Exception {
		
		
		if(titolo.isBlank() || titolo.isEmpty() || titolo == null)
			
			throw new Exception ("Il campo Titolo non pùo essere vuoto!");
		
		this.titolo = titolo;
	}
	

	public int getNumeroPagine() {
		return numeroPagine;
	}

	public void setNumeroPagine(int numeroPagine) throws Exception {
		
		if(numeroPagine <= 0)
			
			throw new Exception("Il Numero di pagine deve essere superiore a 0");
		
		this.numeroPagine = numeroPagine;
	}
	

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) throws Exception {
		
        if(autore.isBlank() || autore.isEmpty() || autore == null)
			
			throw new Exception("Il campo Autore non pùo essere vuoto!");
        
		this.autore = autore;
	}
	

	public String getEditore() {
		return editore;
	}

	public void setEditore(String editore) throws Exception {
		
        if(editore.isBlank() || editore.isEmpty() || editore == null)
			
			throw new Exception("Il campo Editore non pùo essere vuoto!");
        
		this.editore = editore;
	}
	
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "Editore: " + getEditore() + "\n"
		       + "Autore: " + getAutore() + "\n"
		       + "Titolo: " + getTitolo() + "\n"
		       + "Numero pagine: " + getNumeroPagine() + "\n";
    		   
    			
    }
}
