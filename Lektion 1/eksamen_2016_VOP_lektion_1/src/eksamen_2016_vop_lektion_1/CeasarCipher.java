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
public class CeasarCipher extends AbstractCipher {

    private int rotFactor;

    public CeasarCipher(int rotFactor) {
        if (rotFactor > 0 && rotFactor < ALPHABETH.length) {
            this.rotFactor = rotFactor;
        } else {
            System.out.println("Fejl i rotFactor!");
        }
    }

    @Override
    public String encrypt(String original) {
        String combinedCharString = "";
        char combineCharString;
        for (int i = 0; i < original.length(); i++) {
            char c = original.charAt(i);
            int index = findCharIndex(c);
            if (Character.isLetter(c)) {
                index = index + rotFactor;

                combineCharString = ALPHABETH[Math.floorMod(index, ALPHABETH.length)];

            } else {
                combineCharString = c;
            }
            combinedCharString += Character.toString(combineCharString);
        }
        return combinedCharString;
    }

    @Override
    public String decrypt(String encrypted) {
       String combinedCharString = "";
        char combineCharString;
        for (int i = 0; i < encrypted.length(); i++) {
            char c = encrypted.charAt(i);
            int index = findCharIndex(c);
            if (Character.isLetter(c)) {
                index = (index - rotFactor);

                combineCharString = ALPHABETH[Math.floorMod(index, ALPHABETH.length)];

            } else {
                combineCharString = c;
            }
            combinedCharString += Character.toString(combineCharString);
        }
        return combinedCharString;
    }
}
