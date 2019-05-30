package vop15reexamf15.opg4_cards;

/**
 * VOP eksamen F2014 Tom klasse til opgave 3
 *
 * @author erso
 */
public class Card implements CardInterface {

    private int face;
    private int suit;

    public Card(int face, int suit) {
        if (face < ACE || face > KING || suit < CLUBS || suit > SPADES) {
            System.out.println("Ulovligt kort: " + suit + " " + face);

        } else {
            this.face = face;
            this.suit = suit;
        }

    }

    @Override
    public String toString() {
//        String faceCard = face == ACE ? ACE_NAME
//                : // if true set ace name else go next
//                face == JACK ? JACK_NAME
//                        : // if true set jack name else go next
//                        face == QUEEN ? QUEEN_NAME
//                                : // if true set queen name else go next
//                                face == KING ? KING_NAME : String.valueOf(face); // if true set king name else return the string of string object face
//        String suitCard = suit == SPADES ? SPADES_NAME
//                : suit == HEARTS ? HEARTS_NAME
//                        : suit == DIAMONDS ? DIAMONDS_NAME
//                                : suit == CLUBS ? CLUBS_NAME : String.valueOf(suit);
        String suitCard = "", faceCard = "";

        switch (face) {
            case ACE:
                faceCard = ACE_NAME;
                break;
            case JACK:
                faceCard = JACK_NAME;
                break;
            case QUEEN:
                faceCard = QUEEN_NAME;
                break;
            case KING:
                faceCard = KING_NAME;
                break;
            default:
                faceCard = String.valueOf(face);
        }

        switch (suit) {
            case HEARTS:
                suitCard = HEARTS_NAME;
                break;
            case DIAMONDS:
                suitCard = DIAMONDS_NAME;
                break;
            case CLUBS:
                suitCard = CLUBS_NAME;
                break;
            case SPADES:
                suitCard = SPADES_NAME;
                break;
            default:
                suitCard = String.valueOf(suit);
        }

        return suitCard + "- " + faceCard;

    }

}
