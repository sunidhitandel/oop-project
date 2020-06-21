package Login;

import Mainfiles.Companymain;
import Mainfiles.*;
import java.util.Scanner;

public class Login {
        Scanner sc=new Scanner(System.in);
    public Login() throws Exception
    {
        this.login();
    }
    void login() throws Exception
    {
       System.out.println("Enter your choice \n1.Student\n2.Company\n3.Back");
        int ch=sc.nextInt();
        switch(ch)
        {
            case 1:
                StudentLogin s=new StudentLogin();
                break;
            case 2:
                Companylogin c=new Companylogin();
                break;
            case 3:
                Mainmenu m=new Mainmenu();
                break;
            default:
                System.out.println("------------ENTER VALID INPUT------------");
                this.login();
        } 
    }
}
