/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eksamen_2016_vop_lektion_1;

/**
 *
 * @author AleksanderSTUD
 */
public class AtbashCipher extends AbstractCipher {

    @Override
    public String encrypt(String original) {

        String combinedCharString = "";
        char combineChar;
        for (int i = 0; i < original.length(); i++) {
            char c = original.charAt(i);
            if (Character.isLetter(c)) {
                int lookFromBehind = ALPHABETH.length - findCharIndex(c);

                combineChar = ALPHABETH[lookFromBehind - 1];

            } else {
                combineChar = c;
            }

            combinedCharString += Character.toString(combineChar);

        }
        return combinedCharString;

    }

    @Override
    public String decrypt(String encrypted) {
        String combinedCharString = "";
        char combineChar;
        for (int i = 0; i < encrypted.length(); i++) {
            char c = encrypted.charAt(i);
            if (Character.isLetter(c)) {
                int lookFromBehind = ALPHABETH.length - findCharIndex(c);

                combineChar = ALPHABETH[lookFromBehind - 1];

            } else {
                combineChar = c;
            }

            combinedCharString += Character.toString(combineChar);

        }
        return combinedCharString;
    }

}
