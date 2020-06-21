
package Exception;

public class Invalidemailid extends Exception {

    public Invalidemailid() {
        System.out.println("Invalid emailid:");
    }
    public Invalidemailid(String msg) {
        super(msg);
    }
}
