package Login;

import Exception.InvalidPassword;
import Mainfiles.Companymain;
import Mainfiles.Studentmain;
import Registration.RegisterCompany;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Companylogin {
    String uname,password;
    RegisterCompany  object ;
    String path="C:\\Users\\Sunidhi\\Desktop\\SerializedFile_Company";
    Scanner sc=new Scanner(System.in);
    public Companylogin() throws Exception
    {
        this.getdetails();
    }
    void getdetails() throws Exception
    {
        try{
        System.out.println("username:");
        uname=sc.nextLine();
        System.out.println("password:");
        password=sc.next();
        File f=new File(path);
        File[] files=f.listFiles();
        int register=0,i;
        for(i=0;i<files.length;i++)
        {
            try
            {
            if(files[i].getName().startsWith(uname))
            {
                System.out.println(files[i]);
            ObjectInputStream ob1 = new ObjectInputStream(new FileInputStream(files[i]));  
            // Method for deserialization of object 
            object= (RegisterCompany) ob1.readObject();
            ob1.close();
            System.out.println("Object has been deserialized "); 
            System.out.println("password = " + object.getpassword()); 
                  try{
                      if(! this.password.equals(object.getpassword()))
                           throw new InvalidPassword();
                        System.out.println("---------------USER VERFIED:---------------");
                        object.getStudentlist();
                        System.out.println(object.getstu_details());
                        System.out.println("You can contact students who fall under you're crieteria with given Contact no.");
                        System.out.println("----------------------Thank You!----------------------");
                        System.out.println("            For consedering our Services :            ");
                        System.out.println("-------------YOU'VE LOGGED OUT SUCEEFULLY-------------");
                        break;
                      } 
                 catch(InvalidPassword ip)
                    {
                       System.out.println("invalid Password:");
                       register=1;
                    }
            }
            }   
            catch(Exception e1)
            {
                e1.printStackTrace();
                register=1;
            }
           }
            if(i==files.length)
            register=1;
            if(register!=0)
            {
                String temp=sc.nextLine();
                System.out.println("Do you want to register???\n1.Yes\n2.No");
                int ans=sc.nextInt();
                switch(ans)
                {
                    case 1:
                        Companymain s=new Companymain();
                        s.Register_Company();
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("---------ENTER VALID ENTRY---------");
                        
                }
            }
        }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    }
}
