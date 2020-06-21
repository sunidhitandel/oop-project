/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

import Registration.*;

/**
 *
 * @author Sunidhi
 */
public class Idalreadyexsist extends Exception {

    /**
     * Creates a new instance of <code>Idalreadyexsist</code> without detail
     * message.
     */
    public Idalreadyexsist() {
    }

    /**
     * Constructs an instance of <code>Idalreadyexsist</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public Idalreadyexsist(String msg) {
        super(msg);
    }
}
