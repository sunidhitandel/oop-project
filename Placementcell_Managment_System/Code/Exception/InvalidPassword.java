
package Exception;
public class InvalidPassword extends Exception {

    public InvalidPassword() {
        System.out.println("Invalid Password");
    }
    public InvalidPassword(String msg) {
        super(msg);
    }
}
