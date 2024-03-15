package entities;

import java.time.LocalDate;

public class Libri extends Catalogo {

    private String autore;
    private String genere;

    public Libri(int ISBN, String titolo,int annoDiPubblicazione, int numeroPagine, String autore, String genere) {
        super(ISBN, titolo, annoDiPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    @Override
    public void dettagli() {
        System.out.println("Libri{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                ", ISBN=" + ISBN +
                ", titolo='" + titolo + '\'' +
                ", annoDiPubblicazione=" + annoDiPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}');
    }
}
