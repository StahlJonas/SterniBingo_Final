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
    boolean checkBingo(List<Bierdeckel> bierdeckel){
        

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
