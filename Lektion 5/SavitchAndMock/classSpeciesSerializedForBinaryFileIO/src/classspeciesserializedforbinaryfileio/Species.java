/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classspeciesserializedforbinaryfileio;

import java.io.Serializable;

/**
 *
 * @author AleksanderStationaer
 */
public class Species implements Serializable {

    private String name;
    private int population;
    private double growthRate;

    public Species() {
        name = null;
        population = 0;
        growthRate = 0;
    }

    public Species(String initialName, int initialPopulation,
            double initialGrowthRate) {
        name = initialName;
        if (initialPopulation >= 0) {
            population = initialPopulation;
        } else {
            System.out.println("ERROR: Negative population.");
            System.exit(0);
        }
        growthRate = initialGrowthRate;
    }

    public String toString() {
        return ("Name = " + name + "\n"
                + "Population = " + population + "\n"
                + "Growth rate = " + growthRate + "%");
    }

}
