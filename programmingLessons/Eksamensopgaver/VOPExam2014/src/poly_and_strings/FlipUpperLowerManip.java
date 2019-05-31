/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly_and_strings;

/**
 *
 * @author PCATG
 */
public class FlipUpperLowerManip extends AbstractManiplulable {

    public FlipUpperLowerManip(String originalString) {
        super(originalString);
    }

    @Override
    public String manip() {

        String s = super.originalString;
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (Character.isLowerCase(c)) {
                sb.setCharAt(i, Character.toUpperCase(c));
            } else {
                sb.setCharAt(i, Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }

}
