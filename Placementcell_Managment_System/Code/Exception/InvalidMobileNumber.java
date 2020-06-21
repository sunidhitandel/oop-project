package Exception;
public class InvalidMobileNumber extends Exception {

    public InvalidMobileNumber(int msg) {
        System.out.println("Enter valid Mobile No. .You've Entered of "+msg+" digits");
    }
}
