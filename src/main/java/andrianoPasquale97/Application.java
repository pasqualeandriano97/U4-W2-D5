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
        Supplier<Libri> createLibro= (()->new Libri(random.nextInt(1,20000),faker.book().title(), random.nextInt(2000,2024), random.nextInt(1,100),autori.get(random.nextInt(1, autori.size())),generi.get(random.nextInt(1, generi.size()))));
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



    }

}
