
package Registration;
import Exception.Invalidemailid;
import absclass.BaseCompany;
import Exception.*;
import Mainfiles.Studentmain;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class RegisterCompany implements BaseCompany,Serializable
{
    private static final long serialVersionUID = -6470090944414208497L;
    transient Scanner sc = new Scanner(System.in);
    private String name,emailid,interview_det;
    char []p;
    double min_crieteria;
    StringBuffer interview_student;
    private int salary,registered_no=0,profile;
    public String getpassword()
    {
        return String.valueOf(p);
    }
    public void setpassword()
    {
        System.out.println("Enter Password:");
        try{
        p=sc.next().toCharArray();
        if(p.length<8)
            throw new InvalidPassword();
        }
        catch(InvalidPassword e)
        {
            System.out.println(e);
            setpassword();
        }
    }
     public RegisterCompany()
    {
        this.setname();
        this.setemailid();
        this.setprofile();
        this.setaligibilitycriteria();
        this.setpassword();
        this.setinterview();
    }
   public String getname()
    {
        return name;
    }
    public void setname()
    {
       System.out.println("Enter Name :");
       name=sc.nextLine();
    }
    public void setsalarybound()
    {
        System.out.println("Enter Minimum salary you're willing to pay:");
        this.salary=sc.nextInt();
    }
    public int getsalarybound()
    {
        return salary;
    }
    public String getemailid()
    {
        return emailid;
    }
    public String toString()
    {
        return ""+this.getname()+"\t"+this.getemailid()+"\t"+this.getsalarybound()+"\t"+this.getaligibilitycriteria();
    }
    public void setemailid()
    {
        System.out.println("Enter emailid:");
        emailid=sc.nextLine();
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        try{
        boolean v=pat.matcher(emailid).matches(); 
        if(emailid==null)v=false;
        if(!v)
            throw new Invalidemailid();
        }
        catch(Invalidemailid e)
        {
            System.out.println(e);
            setemailid();
        }
    } 
    public void setprofile(int i)
    {
        profile = profile -i;
    }
    public void setprofile()
    {
        System.out.println("Enter no of profiles u'll offer:");
        this.profile=sc.nextInt();
    }
    public int getprofile()
    {
        return profile;
    }
    public double getaligibilitycriteria()
    {
        return min_crieteria;
    }
    public void setaligibilitycriteria()
    {
        System.out.println("Enetr eligibility crieteria in CGPA:");
        min_crieteria=sc.nextDouble();
        this.setsalarybound();
    }
    public void getStudentlist()
    {
        Studentmain s=new Studentmain();
        class Sortbyagg implements Comparator<RegisterStudent> 
        { 
         public int compare(RegisterStudent a, RegisterStudent b) 
            { 
             return (int) (a.getagg() - b.getagg()); 
            } 
        }
        RegisterStudent r[];
        try {
            r = s.getarr();
            //System.out.println(r[0].toString());
        int x=-1,i;
        if(r.length>1)
            Arrays.sort(r, new Sortbyagg()); 
        System.out.println("\nSorted by agg"); 
        for (i=0; i<r.length; i++) 
            System.out.println(r[i].toString());
        //RegisterStudent selectedstudents[]=new RegisterStudent[index];
        for(i=0;i<r.length;i++)
        {   
            if(r[i].getagg()>=this.getaligibilitycriteria())
            {   x=i;
                break;
            }
        }
        if(x!=-1)
        {
            System.out.println("Students According to your requirements are:");
             for(x=r.length-1;x>=i;x--)
             {
                 if(this.getsalarybound()>=r[x].getsalary())
                   System.out.println(r[x].toString());
             }
             System.out.println("Among which no. of Students appearig in you're interviews are :"+ this.getcandidate());
             if(this.getcandidate()!=0)
             {System.out.println("---LIST---\n"+this.getstu_details());
             System.out.println("Have you hired any of them???");
             String choice=sc.next();
             if(choice.equalsIgnoreCase("yes"))
                     {
                         do{
                         System.out.println("Enter name of candidate...");
                         try{
                         String name=sc.nextLine();
                         File file = new File("C:\\Users\\Sunidhi\\Desktop\\Serialized File_Student\\"+name+".ser");
                         file.delete();
                         }
                         catch(Exception e)
                         {
                             System.out.println("FILE NOT FOUND!");
                             System.out.println("Do you want to re-enter the name?");
                             choice=sc.next();
                             if(choice.equalsIgnoreCase("no"))
                                 break;
                         }
                         FileWriter fw=new FileWriter("C:\\Users\\Sunidhi\\Desktop\\OOP project\\hired_candidate.txt",true);
                         fw.write(name+"\n");
                         fw.close();
                         }while(choice.equalsIgnoreCase("yes"));
                     }
             }
             
        }
        
        else
        {
            System.out.println("No Student satisfy your Creiteria We will notify if there register Such Student.");
            System.out.println("Thanks for cosidering our service ;).See you soon!");
                
        }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void setinterview()
    {
        String temp=sc.nextLine();
        System.out.println("Enter Interview details:");
        interview_det=sc.nextLine();
    }
    public String getinterview()
    {
        return interview_det;
    }
    public void setcandidate()
    {
        registered_no=registered_no+1;
    }
    public int getcandidate()
    {
        return registered_no;
    }
    public void getCompanylist() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public boolean setstu_details(String sinfo)
    {
        if(interview_student == null) interview_student = new StringBuffer("");
        String roll = sinfo.split("\t")[0];
        String[] details = interview_student.toString().split("\n");
        for(int i=0;i<details.length;i++)
        {
            if(roll.equals(details[i].split("\t")[0]))
                return false;
        }
        interview_student.append("" +sinfo+ "\n");
        return true;
    }
    public String getstu_details()
    {
        if(interview_student == null || interview_student.toString().equals(""))
            return "";
        return interview_student.toString();
    }
}
