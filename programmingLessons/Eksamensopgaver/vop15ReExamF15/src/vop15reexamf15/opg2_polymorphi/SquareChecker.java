/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vop15reexamf15.opg2_polymorphi;

import vop15reexamf15.opg1_facade.SpecialNumbers;

/**
 *
 * @author PCATG
 */
public class SquareChecker implements CheckerInterface{
    SpecialNumbers specialNumbers;

    public SquareChecker() {
        specialNumbers = new SpecialNumbers();
    }

    @Override
    public boolean check(int i) {
        return specialNumbers.isSquare(i);
    }
}
