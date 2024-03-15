package entities;

import java.time.LocalDate;

public abstract class Catalogo {
    protected int ISBN;
    protected String titolo;
    protected int annoDiPubblicazione;
    protected int numeroPagine;

    public int getISBN() {
        return ISBN;
    }

    public int getAnnoDiPubblicazione() {
        return annoDiPubblicazione;
    }

    public  Catalogo(int ISBN, String titolo, int annoDiPubblicazione, int numeroPagine) {
        this.ISBN = ISBN;
        this.titolo = titolo;
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.numeroPagine = numeroPagine;
    }
    protected abstract void dettagli ();
}
