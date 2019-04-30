package opg3_playingcards;

import java.util.Random;

/**
 * VOP eksamen F2014 Kodeskelet til opgave 3c og 3d
 *
 * @author erso
 */
public class DeckOfCards implements CardInterface {

    private Card[] deck;

    public DeckOfCards() {
        // Opg 3c. Initialiser deck, dan de 52 lovlige kort og saet dem i deck-arrayet
        deck = new Card[NUMBER_OF_CARDS];

//        for (int face = 0; face < KING; face++) {
//            for (int suit = 0; suit < SPADES; suit++) {
//
//                deck[suit + (face * SPADES)] = new Card(face+ 1, suit + 1);    // Credit to Mathias
//
//            }
//
//        }
        for (int face = ACE; face <= KING; face++) {    // e.g. Clubs is the first suit

            for (int suit = CLUBS; suit <= SPADES; suit++) {    // Here we run all the clubs face, 
                // e.g. es(1), 2, 3, 4 ... 10, J(11), Q(12), K(13)

                deck[((suit - 1) + ((face - 1) * SPADES))] = new Card(face, suit);
                // Multiply by 13 or divide by 52 / 4 as there is 13 different faces for one suit ( - 1 to avoid indexOutOfBound)

            }

        }
    }

    // Faerdiskrevet metode til "paen" udskrift af kortbunken
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < deck.length; i++) {
            if (i != 0 && i % 4 == 0) {
                sb.append("\n");
            }
            sb.append(deck[i]);
            if (i != deck.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public void shuffle(int swaps) {
//        List<Card> list = new ArrayList<>(Arrays.asList(deck));
//        for (int i = 1; i < swaps; i++) {
//            Collections.swap(list, (int) (Math.random() * deck.length), (int) (Math.random() * deck.length));
//        }
//        deck = list.toArray(new Card[NUMBER_OF_CARDS]);
        Random ran = new Random();
        for (int i = 0; i < swaps; i++) {
            int ind1 = ran.nextInt(deck.length);
            int ind2 = ran.nextInt(deck.length);
            Card tempCard = deck[ind1];
            deck[ind1] = deck[ind2];
            deck[ind2] = tempCard;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Card(1, 3));
        System.out.println(new Card(3, 1));
        System.out.println(new Card(13, 4));
        System.out.println(new Card(12, 3));
        System.out.println(new Card(17, 5));

        // Til test af opg 3 c
        DeckOfCards deckOfCards = new DeckOfCards();

        System.out.println("Opg 3c:\n" + deckOfCards.toString());

        // Til test af opg 3 d
        deckOfCards.shuffle(100);
        System.out.println("Opg 3d:\n" + deckOfCards);
    }

}
