/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aldus17_ta_2;

/**
 *
 * @author erso
 */
public interface CallbackInterface {
    
    void updateBuffer(int index, Character value);
    void updateConsumer(String oldName, String newName);
    
}
