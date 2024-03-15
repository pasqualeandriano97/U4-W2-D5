package file;

import com.github.javafaker.Faker;
import entities.Libri;
import entities.Periodicita;
import entities.Rivista;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class FileMain {
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
        File fileLibri=new File("src/libri.txt");
        File fileRiviste=new File("src/riviste.txt");
        try {
            FileUtils.writeStringToFile(fileLibri,listaLibri+ System.lineSeparator(), StandardCharsets.UTF_8);
            FileUtils.writeStringToFile(fileRiviste,listRiviste+ System.lineSeparator(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
       try {
           List<String> libri=FileUtils.readLines(fileLibri, StandardCharsets.UTF_8);           for (String line : libri) {
               System.out.println(line);
           }
           List<String> riviste=FileUtils.readLines(fileRiviste, StandardCharsets.UTF_8);           for (String line : riviste) {
               System.out.println(line);
           }
       } catch (IOException e) {
           System.err.println(e.getMessage());

       }
}
}
