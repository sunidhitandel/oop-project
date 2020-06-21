
package Exception;

import absclass.*;

/**
 *
 * @author Sunidhi
 */
public class InvalidDOB extends Exception {

    /**
     * Creates a new instance of <code>InvalidDOB</code> without detail message.
     */
    public InvalidDOB() {
        System.out.println("invalid DOB:");
    }

    /**
     * Constructs an instance of <code>InvalidDOB</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public InvalidDOB(String msg) {
        super(msg);
    }
}
