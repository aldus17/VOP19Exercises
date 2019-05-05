package vop15reexamf15.opg4_cards;

public class Card implements CardInterface {

    private int face;
    private int suit;

    public Card(int face, int suit)  {  
        // Implementer tjek af parametre og tildeling af værdier

    }

    @Override
    public String toString() {
        // Implementer generering af navn på kort
        String cardName = "";


        return cardName;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
       
            System.out.println(new Card(1, 3));
            System.out.println(new Card(3, 1));
            System.out.println(new Card(13, 4));
            System.out.println(new Card(12, 3));
            System.out.println(new Card(17, 5));
    
    }

}
