package andrianoPasquale97;

import com.github.javafaker.Faker;
import entities.Libri;
import entities.Periodicita;
import entities.Rivista;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static org.apache.commons.io.function.IOConsumer.forEach;

public class Application {

    public static void main(String[] args) {
        Random random=new Random();
        Faker faker= new Faker();
        Periodicita[] values = Periodicita.values();

        List<Libri> listaLibri=new ArrayList<>();
        List<Rivista> listRiviste=new ArrayList<>();
        LocalDate data=LocalDate.now();
        List<String> autori=new ArrayList<>();
        autori.add(faker.book().author());
        autori.add(faker.book().author());
        autori.add(faker.book().author());
        autori.add(faker.book().author());
        List<String>generi=new ArrayList<>();
        generi.add(faker.book().genre());
        generi.add(faker.book().genre());
        generi.add(faker.book().genre());
        Supplier<Libri> createLibro= (()->new Libri(random.nextInt(1,20000),faker.book().title(), random.nextInt(2000,2024), random.nextInt(1,100),autori.get(random.nextInt(0, autori.size())),generi.get(random.nextInt(0, generi.size()))));
      Supplier<Rivista> createRivista=(()-> new Rivista(random.nextInt(1,20000),faker.book().title(),random.nextInt(2000,2024),random.nextInt(1,100),values[random.nextInt(0, values.length)]));
    for(int i=0;i<50;i++){
       listaLibri.add(createLibro.get()) ;

    }
       for(int i=0;i<50;i++){
           listRiviste.add(createRivista.get()) ;

       }
    for(int i=0;i< listaLibri.size();i++){
        listaLibri.get(i).dettagli();
    }
        for(int i=0;i< listRiviste.size();i++){
            listRiviste.get(i).dettagli();
        }
     Scanner scanner=new Scanner(System.in);

        cicloPadre:
        while(true){
            System.out.println("Scegliere cosa vuoi fare");
            System.out.println("0. Aggiungi un nuovo libro o rivista");
            System.out.println("1. Elimina un libro o rivista");
            System.out.println("2. Cerca un libro o rivista");
            System.out.println("3. Cerca un libro per autore");
            System.out.println("4. Chiudere il programma");
            int n=scanner.nextInt();


            int j=0;
            switch (n){
                case 0:System.out.println("Scegliere cosa vuoi aggiungere");
                    System.out.println("0. Aggiungi un libro");
                    System.out.println("1. Aggiungi una rivista");
                    j=scanner.nextInt();
                    switch (j){

                        case 0: listaLibri.add(createLibro.get());
                            System.out.println("Aggiunto un libro");
                            break;
                        case 1: listRiviste.add(createRivista.get());
                            System.out.println("Aggiunto una rivista");
                            break;
                    }
                    break;
                case 1:
                    System.out.println("Scegliere cosa vuoi eliminare");
                    System.out.println("0. Elimina un libro");
                    System.out.println("1. Elimina una rivista");
                    j=scanner.nextInt();
                    switch (j){
                        case 0:
                            System.out.println("Inserisci il numero dell'ISBN del libro da eliminare");
                            int isbn=scanner.nextInt();
                            listaLibri.stream().filter(x->x.getISBN()!=isbn).collect(Collectors.toList()).forEach(x->x.dettagli());
                            break;
                        case 1:
                            System.out.println("Inserisci il numero dell'ISBN della rivista da eliminare");
                            int isbn1=scanner.nextInt();
                            listRiviste.stream().filter(x->x.getISBN()!=isbn1).collect(Collectors.toList()).forEach(x->x.dettagli());
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Scegliere cosa vuoi cercare");
                    System.out.println("0. Cerca un libro");
                    System.out.println("1. Cerca una rivista");
                    j=scanner.nextInt();
                    switch (j) {
                        case 0:
                            System.out.println("Inserisci l'anno di pubblicazione del libro da cercare");
                            int anno = scanner.nextInt();
                            listaLibri.stream().filter(x -> x.getAnnoDiPubblicazione() == anno).collect(Collectors.toList()).forEach(x -> x.dettagli());
                            break;
                        case 1:
                            System.out.println("Inserisci l'anno di pubblicazione della rivista da cercare");
                            int anno1 = scanner.nextInt();
                            listRiviste.stream().filter(x -> x.getAnnoDiPubblicazione() == anno1).collect(Collectors.toList()).forEach(x -> x.dettagli());
                            break;
                    }
                    break;
                case 3:
                    Scanner scanner1=new Scanner(System.in);
                    System.out.println("Inserisci l'autore del libro da cercare");
                    String autore = scanner1.nextLine();
                    listaLibri.stream().filter(x->x.getAutore().equalsIgnoreCase(autore)).collect(Collectors.toList()).forEach(x->x.dettagli());
                    break;

                    case 4:
                    break cicloPadre;

            }
        }

    }

}
