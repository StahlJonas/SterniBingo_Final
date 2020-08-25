import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;


public class BingoKarte {
    private int[] bingokarte;
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_RESET = "\u001B[0m";
    public BingoKarte() {
        bingokarte= new int[25];
    }

    public BingoKarte(int[] karte) {
        bingokarte = karte;
    }

    void printBingokarte(List<Bierdeckel> bierdeckel) {
        for (int i = 0; i < 25; ++i) {
            int wert = bingokarte[i];
            boolean bierdeckelExists = bierdeckel.stream().anyMatch(item -> wert==item.getWert());
            if (bierdeckelExists){
                System.out.print(ANSI_RED_BACKGROUND);
                System.out.print(String.format("%02d ", bingokarte[i]));
                System.out.print(ANSI_RESET);
            }else {
                System.out.print(String.format("%02d ", bingokarte[i]));
            }
            if ((i + 1) % 5 == 0) {
                System.out.println();

            }
        }
    }
    public List<Bingo> getBingos(List<Bierdeckel> bierdeckel){
        List<Bingo> bingos = new ArrayList<>();
        boolean isBingo = false;
        for (int i = 0; i < 5; i++) {
            // horizontal bingos
            for (int j = 0; j < 5; j++) {
                int wert = bingokarte[i*5+j];
                if(!bierdeckel.stream().anyMatch(item -> wert==item.getWert())){
                    isBingo = false;
                    break;
                }else {
                    isBingo = true;
                }
            }
            if(isBingo){
                isBingo = false;
                Bierdeckel[] bingodeckel = new Bierdeckel[5];
                for (int j = 0; j < 5; j++) {
                    int wert = bingokarte[i*5+j];
                    bingodeckel[j] = bierdeckel.stream().filter(item -> wert==item.getWert()).findFirst().get();
                }
                bingos.add(new Bingo(this,bingodeckel));
            }
            // vertical bingos
            for (int j = 0; j < 5; j++) {
                int wert = bingokarte[i+j*5];
                if(!bierdeckel.stream().anyMatch(item -> wert==item.getWert())){
                    isBingo = false;
                    break;
                }else {
                    isBingo = true;
                }
            }
            if(isBingo){
                isBingo = false;
                Bierdeckel[] bingodeckel = new Bierdeckel[5];
                for (int j = 0; j < 5; j++) {
                    int wert = bingokarte[i+j*5];
                    bingodeckel[j] = bierdeckel.stream().filter(item -> wert==item.getWert()).findFirst().get();
                }
                bingos.add(new Bingo(this,bingodeckel));
            }

        }
        // diag bingo1
        for (int i = 0; i < 5; i++) {
            int wert = bingokarte[i*6];
            if(!bierdeckel.stream().anyMatch(item -> wert==item.getWert())){
                isBingo = false;
                break;
            }else {
                isBingo = true;
            }
        }
        if(isBingo){
            isBingo = false;
            Bierdeckel[] bingodeckel = new Bierdeckel[5];
            for (int i = 0; i < 5; i++) {
                int wert = bingokarte[i*6];
                bingodeckel[i] = bierdeckel.stream().filter(item -> wert==item.getWert()).findFirst().get();
            }
            bingos.add(new Bingo(this,bingodeckel));
        }
        // diag2 bingo
        for (int i = 0; i < 5; i++) {
            int wert = bingokarte[i*4+4];
            if(!bierdeckel.stream().anyMatch(item -> wert==item.getWert())){
                isBingo = false;
                break;
            }else {
                isBingo = true;
            }
        }
        if(isBingo){
            isBingo = false;
            Bierdeckel[] bingodeckel = new Bierdeckel[5];
            for (int i = 0; i < 5; i++) {
                int wert = bingokarte[i*4+4];
                bingodeckel[i] = bierdeckel.stream().filter(item -> wert==item.getWert()).findFirst().get();
            }
            bingos.add(new Bingo(this,bingodeckel));
        }
        return bingos;
    }
    boolean checkBierdeckel(Bierdeckel bierdeckel) {
        for (int i = 0; i < 25; ++i) {
            if (bierdeckel.getWert() == bingokarte[i]) {
                System.out.println("Bierdeckel ist dabei");
                return true;
            }
        }
        System.out.println("Bierdeckel ist nicht dabei");
        return false;
    }
}
