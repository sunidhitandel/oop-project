package Mainfiles;
import java.util.*;
public class Registration {
    Scanner sc=new Scanner(System.in);
    Registration() throws Exception
    {
        this.register();
    }
    void register() throws Exception
    {
       System.out.println("Enter your choice \n1.Student\n 2.Company\n3.Back");
        int ch=sc.nextInt();
        switch(ch)
        {
            case 1:
                Studentmain s=new Studentmain();
                s.Register_Student();
                break;
            case 2:
                Companymain c=new Companymain();
                c.Register_Company();
                break;
            case 3:
                Mainmenu m=new Mainmenu();
                break;
           default:
                System.out.println("------------ENTER VALID INPUT------------");
                this.register();
        } 
    }
}
