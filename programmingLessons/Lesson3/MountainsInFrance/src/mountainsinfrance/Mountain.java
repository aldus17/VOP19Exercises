package mountainsinfrance;

import java.util.Arrays;

/**
 *
 * @author erso Udleveret kode skelet med main()-metode til opgave 4, VOP
 * eksamen 10 juni 2016
 */
public class Mountain implements Comparable<Mountain> {

    private String name;
    private int heigth;
    private int prominence;
    private String latitude;
    private String longitude;
    private String range;

    public Mountain(String name, String heitgth, String prominence, String latitude, String longitude, String range) {
        this.name = name;
        this.heigth = Integer.parseInt(heitgth);
        this.prominence = Integer.parseInt(prominence);
        this.latitude = latitude;//Double.parseDouble(latitude);
        this.longitude = longitude;
        this.range = range;

    }

    @Override
    public String toString() {
        return "Mountain: " + this.name + ", h: " + this.heigth + ", pro: "
                + this.prominence + ", lat: " + this.latitude + ", lon: "
                + this.longitude + ", ran: " + this.range + "\n";
    }
    public String getRange() {
        return this.range;
    }

    @Override
    public int compareTo(Mountain o) {
        int i = o.prominence - this.prominence;
        if (i == 0) {
            i = o.heigth - this.heigth;
        } 
        return i;
        
//        if (this.prominence == o.prominence) {
//            return Integer.compare(this.heigth, o.heigth);
//        }
//        else {
//            return Integer.compare(this.prominence, o.prominence);
//        }

//        if (this.prominence.equalsIgnoreCase(o.prominence)) {
//            return this.heigth.compareTo(o.heigth);
//        } else {
//            return this.prominence.compareTo(o.prominence);
//        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // Til test af Mountain-klassen

        //Opg a Test af constructor og toString()
        // NB: \u00B0 er unicode for grade-tegnet
        Mountain m = new Mountain("Mont Ventoux", "1909", "1148", "44\u00B010'26\"", "05\u00B016'42\"", "Alps");

        System.out.println(m);
        // Opg b Test af compareTo()
        Mountain[] testArray = new Mountain[5];
        testArray[0] = new Mountain("Pic du Midi d'Ossau", "2886", "1092", "42\u00B048'22\"", "-00\u00B025'05\"", "Pyrenees");
        testArray[1] = new Mountain("Pic de Bure", "2709", "1268", "44\u00B037'38\"", "05\u00B056'07\"", "Alps");
        testArray[2] = new Mountain("Mont Chaberton", "3131", "1281", "44\u00B057'53\"", "06\u00B045'06\"", "Alps");
        testArray[3] = new Mountain("Pica d'Estats", "3143", "1281", "42\u00B042'43\"", "00\u00B057'23\"", "Pyrenees");
        testArray[4] = new Mountain("Test", "2000", "1281", "42\u00B042'43\"", "00\u00B057'23\"", "test");

        System.out.println("Usorteret: ");
        System.out.println(Arrays.toString(testArray));

        System.out.println("Sorteret: ");
        Arrays.sort(testArray);
        System.out.println(Arrays.toString(testArray));

    }

}
