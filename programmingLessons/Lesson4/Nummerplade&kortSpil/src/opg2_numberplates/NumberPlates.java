package opg2_numberplates;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * VOP eksamen F2014 Kodeskelet til opgave 2
 *
 * @author erso
 */
public class NumberPlates {

    public static final int LENGTH = 7;         // Noejagtig laengde paa nummerplade

    public Map<String, String> districtMap;    // Kendingsbogstaver -> Politikreds
    private final File file;
    private final VehicleType[] vehicleTypes = { // Intervaller for anvendelse
        new VehicleType("Motorcykel", 10000, 19999),
        new VehicleType("Privat personvogn", 20000, 45999),
        new VehicleType("Udlejningsvogn", 46000, 46999),
        new VehicleType("Hyrevogn", 47000, 48999),
        new VehicleType("Skolevogn", 49000, 49899),
        new VehicleType("Ambulance el. lign.", 49900, 49999),
        new VehicleType("Diverse andre ", 50000, 84999)
    };

    public NumberPlates() {
        // opg 2a) initialiser districtMap
        this.districtMap = new TreeMap<>();
        this.file = new File("Nummerplader.txt");
        readFile();
    }

    public void readFile() {
        // opg 2a) Indlaes filen og put i mappen
        try (Scanner scanFile = new Scanner(file)) {
            while (scanFile.hasNext()) {
                String[] stringData = scanFile.nextLine().split(":");

                String keyID = stringData[0];
                String townName = stringData[1];

                this.districtMap.put(keyID, townName);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found!");
        }
    }

    public String validate(String plate) {
        // Opg 2b) Tjek nummerpladen og returner anvendelse og politidistrikt   
        if (plate.length() != LENGTH) {
            return "Illegal laengde ";
        }

        String district = plate.substring(0, 2);
        String number = plate.substring(2, 7);

        return validateVehicleType(Integer.valueOf(number)) + " fra " + validateDistrict(district);

    }

    private String validateDistrict(String districtCode) {
        // Opg 2b) Tjek kendingsbogstaver og returner politidistrikt

//        String temp = districtCode.toUpperCase();
//
//        if (districtMap.containsKey(temp)) {
//            return districtMap.get(temp);
//        }
//
//        return "District kreds ikke fundet";
        String vDisString = "Kreds district findes ikke";
        for (String s : districtMap.keySet()) {
            if (s.equalsIgnoreCase(districtCode)) {
                vDisString = districtMap.get(s);
            }
        }
        return vDisString;

    }

    private String validateVehicleType(int number) {
        // Opg 2b) Tjek hvilket interval number ligger i og returner anvendelse
        String vVehType = "Illegalt nummer: " + number;
        for (int i = 0; i < vehicleTypes.length; i++) {
            if (vehicleTypes[i].isA(number)) {
                vVehType = vehicleTypes[i].getVehicleType();
            }
        }
        return vVehType;
    }

    public static void main(String[] arg) {
        // Opg 2) Kan benyttes til test af opgave 2a og 2b
        NumberPlates pd = new NumberPlates();

        System.out.println("KC39078: " + pd.validate("KC39078"));
        System.out.println("kc49900: " + pd.validate("kc49900"));
        System.out.println("KO47078: " + pd.validate("KO47078"));
        System.out.println("EN19022: " + pd.validate("EN19022"));
        System.out.println("EN90022: " + pd.validate("EN90022"));
        System.out.println("EN190220: " + pd.validate("EN190220"));
    }

}
