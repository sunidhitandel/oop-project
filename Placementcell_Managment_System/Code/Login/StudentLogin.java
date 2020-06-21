package Login;
import java.io.*;
import java.util.*;
import Exception.*;
import Mainfiles.*;
import Registration.*;
public class StudentLogin {
//    int 
    String uname,password,clist;
    RegisterStudent  object = null;
    String path="C:\\Users\\Sunidhi\\Desktop\\Serialized File_Student";
    Scanner sc=new Scanner(System.in);
    public StudentLogin() throws Exception
    {
        this.getdetails();
    }
    void getdetails() throws Exception
    {
        try{
        System.out.println("username:");
        uname=sc.nextLine();
        System.out.println("password:");
        password=sc.nextLine();
        String x;String ishired=null;
        try{
        BufferedReader fr=new BufferedReader(new FileReader("C:\\Users\\Sunidhi\\Desktop\\OOP project\\hired_candidate.txt"));
        while((x=fr.readLine()) != null)
        {   
            if(x.startsWith(uname))
            {
            } else {
                System.out.println("CONGRATULATIONS!!!\n---------USER HAVE BEEN HIRED---------");
                return;
            } 
        }
        }
        catch(Exception e)
        {
            System.out.println("---------NO COMPANY HAVE REGISTERED YET---------");
        }   
        File f=new File(path);
        File[] files=f.listFiles();
        int register=0,i;
        for(i=0;i<files.length;i++)
        {
            
            try
            {
            if(files[i].getName().startsWith(uname))
            {
            ObjectInputStream ob1 = new ObjectInputStream(new FileInputStream(files[i]));  
            // Method for deserialization of object 
            object= (RegisterStudent) ob1.readObject();
            ob1.close();
            System.out.println("Object has been deserialized "); 
            System.out.println("password = " + object.getpassword()); 
                  try{
                      if(! this.password.equals(object.getpassword()))
                           throw new InvalidPassword();
                        System.out.println("---------------USER VERFIED:---------------");
                        clist=object.getCompanylist();
                        this.userupdates();
                        break;
                      } 
                 catch(InvalidPassword ip)
                    {
                       System.out.println("invalid Password:");
                       register=1;
                    }
                }
            
            }   
            catch(FileNotFoundException e1)
            {
                e1.printStackTrace();
                register=1;
            }
          }
        if(i==files.length)
            register=1;
        String ans;
        if(register!=0)
            {
                System.out.println("Do you want to register???");
                ans=sc.nextLine();
                if(ans.equalsIgnoreCase("Yes")){
                Studentmain s=new Studentmain();
                s.Register_Student();
            }
           
        }
        
    }
    catch(Exception e)
    { e.printStackTrace();
    }
    }
    public void userupdates()
    {
        int choice,CID;
        String cname;
        if(clist!="\0")
        {
            String[] listed_comp=clist.split("\t");
             System.out.println("Do you want to accept any proposal?\n1.Yes\n2.No");
            choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                String temp=sc.nextLine();
                System.out.println("Enter Company Name:");
                cname=sc.nextLine();
                int i;
                for(i=0;listed_comp[i]!=null&&(i<listed_comp.length);i++)
                {
                        if(cname.equals(listed_comp[i]))
                            break;
                }
                if(i==listed_comp.length)  
                    System.out.println("-------ERROR-------\n-----------ENTER VALID COMPANY----------");
                else
                {
                    Companymain c=new Companymain();
                    try{ 
                    c.rnoupdate(cname,object.toString());
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                    System.out.println("Do you want to appear in more interviews?\n1.Yes\n2.No");
                    choice=sc.nextInt();
                    if(choice==1)
                        this.userupdates();
                    else if(choice==2)
                    { System.out.println("----------------------Thank You!----------------------");
                      System.out.println("            For consedering our Services :            ");
                      System.out.println("-------------YOU'VE LOGGED OUT SUCEEFULLY-------------");
                    }
                    }
                break;
                case 2:
                    System.out.println("----------------------Thank You!----------------------");
                      System.out.println("            For consedering our Services :            ");
                      System.out.println("                   See You Soon :                   ");
                      System.out.println("-------------YOU'VE LOGGED OUT SUCEEFULLY-------------");
                      break;
                default:
                    System.out.println("----------------ENTER VALID CHOICE----------------------");
                    this.userupdates();
            }
        }
    }
}
