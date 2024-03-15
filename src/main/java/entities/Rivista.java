package entities;

import java.time.LocalDate;

public class Rivista extends Catalogo {

    private Periodicita periodicita;


    public Rivista(int ISBN, String titolo, int annoDiPubblicazione, int numeroPagine,Periodicita period) {
        super(ISBN, titolo, annoDiPubblicazione, numeroPagine);
        this.periodicita=period;
    }

    @Override
    public void dettagli() {
        System.out.println("Rivista{" +
                "periodicita=" + periodicita +
                ", ISBN=" + ISBN +
                ", titolo='" + titolo + '\'' +
                ", annoDiPubblicazione=" + annoDiPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}');
    }
}
