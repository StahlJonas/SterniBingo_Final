import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private List<Bierdeckel> bierdeckel;
    private List<BingoKarte> bingokarten;
    private List<Integer> bierdeckelInt;

    public Person(String name) {
        this.name = name;
        bierdeckel = new ArrayList<>();
        bingokarten = new ArrayList<>();
        bierdeckelInt = new ArrayList<>();
    }

    public void addBingokarte() {
        BingoKarte karte = new BingoKarte();
        bingokarten.add(karte);
    }
    public void addBingokarte(BingoKarte bingokarte) {
        bingokarten.add(bingokarte);
    }

    public void addBierdeckel(int wert) {
        Bierdeckel deckel = new Bierdeckel(wert, this);
        bierdeckel.add(deckel);
        bierdeckelInt.add(wert);
    }
    public void addBierdeckel(int[] werte) {
        for (int w : werte){
            Bierdeckel deckel = new Bierdeckel(w, this);
            bierdeckel.add(deckel);
            bierdeckelInt.add(w);
        }
    }


    public void printKarten() {
        for (BingoKarte k : bingokarten) {
            k.printBingokarte(bierdeckel);
            System.out.println();
        }
    }
}
