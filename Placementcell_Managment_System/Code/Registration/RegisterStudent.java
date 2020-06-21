package Registration;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.logging.*;
import java.util.regex.Pattern;
import Exception.*;
import Mainfiles.Companymain;
import Login.*;
import absclass.BaseStudent;
public class RegisterStudent implements BaseStudent,Serializable
{
    private static final long serialVersionUID = -6470090944414208496L;
    transient Scanner sc = new Scanner(System.in);
    private String name,branch,emailid,pno;
    private double agg;
    private int salary,ID;
    Date dob;
    char p[];
    public RegisterStudent()
    {
        try {
        this.setname();
        this.setdob();
        this.setbranch();
        this.setemailid();
        this.setagg();
        this.setpno();
        this.setpassword();
        this.setId();
        this.setsalary();
        this.setresume();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void setId() throws Exception
    {
        int id=0;
        StudentLogin s=null;
        System.out.println("Enter you're unique ID of 3 digits:");
        id=sc.nextInt();
        try
        {
        if(this.isnotvalidId(id))
            throw new Idalreadyexsist();
        this.ID=id;
        BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\Sunidhi\\Desktop\\OOP project\\Student_id.txt",true));
        bw.write(""+ID+"\n"); 
        bw.close();
        System.out.println(ID);
        }
        catch(Idalreadyexsist e)
        {
            System.out.println("ID already exsist!.....Enter valid id:");
            System.out.println("Do you want to login????");
            try{
            String str=sc.next();
            if(str.equalsIgnoreCase("yes"))
                s=new StudentLogin();
            else
                setId();
            }
            catch(InputMismatchException ex)
            {
                ex.printStackTrace();
             }
        }
        
        
    }
    private boolean isnotvalidId(int id)
    {
        if(String.valueOf(id).length()!=3)
            return true;
            String line =null;
            try
            {
            BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\Sunidhi\\Desktop\\OOP project\\Student_id.txt"));
            while((line=br.readLine())!= null)
            {
                if(id==Integer.parseInt(line)||String.valueOf(id).length()!=3)
                    return true;
            }
            }
            catch(Exception e)
            { e.printStackTrace();
            }
        return false;
    }
    public int getId()
    {
        return ID;
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
    public String getdob()
    {
        DateFormat df =new SimpleDateFormat("dd/MM/yyyy");
        return df.format(dob);
    }
    public void setdob()
    {
       System.out.println("Enter DOB :");
       
        try {
            String d=sc.nextLine();
            dob = new SimpleDateFormat("dd/MM/yyyy").parse(d);
            if(dob.getYear()<=2019) {
            } else {
                throw new InvalidDOB();
            }
        } catch (ParseException ex) {
            Logger.getLogger(RegisterStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(InvalidDOB e)
        {
            System.out.println(e);
            this.setdob();
        }
    }
    public String getbranch()
    {
       return branch;
    }
    public void setbranch()
    {
        System.out.println("Enter Branch :");
       branch=sc.nextLine();
    }
    public String getpno()
    {
        return pno;
    }
    public void setpno()
    {
        System.out.println("Enter Phone num.:");
       try{
       pno=sc.next();
       if(pno.length()!=10)
           throw new InvalidMobileNumber(pno.length());
       
       }
       catch(InvalidMobileNumber e1)
       {
           System.out.println(e1);
           this.setpno();
       }
    }
    public String getemailid()
    {
        return emailid;
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
            this.setemailid();
        }
    } 
    public double getagg()
    {
      return agg;  
    }
    public void setagg()
    {
        System.out.println("Enter your CGPA:");
        try{
        agg=sc.nextDouble();
        }
        catch(NumberFormatException n)
        {
            System.out.println(n);
            this.setagg();
        }
        
    }
    public void setresume()
    {
        System.out.println("Enter the data to be entered in resume:");
        String r=sc.next();
    }
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
    @Override
    public String toString()
    {
        return ""+ID+"\t "+name+"\t"+branch+"\t"+agg+"\t"+emailid+"\t"+pno;
    }
    public void setsalary()
    {
        System.out.println("Enter your expected salary:");
        this.salary=sc.nextInt();
    }
    public int getsalary()
    {
        return salary;
    }
    public String getCompanylist() 
    {
        String c_name="";
        try{
            Companymain c=new Companymain();
            RegisterCompany rc[]=c.getarr(); 
                class Sortbysalary implements Comparator<RegisterCompany>
                {
                    public int compare(RegisterCompany a, RegisterCompany b)
                    {
                        return a.getsalarybound() - b.getsalarybound();
                    }
                    
                }
                int x=-1,i;
                if(rc!=null)
                {
                Arrays.sort(rc, new Sortbysalary());
                System.out.println("\nSorted by Salary:");
                for (i=0; i<rc.length; i++)
                    System.out.println(rc[i].toString());
                //RegisterStudent selectedstudents[]=new RegisterStudent[index];
                for(i=0;i<rc.length;i++)
                {
                    if(rc[i].getsalarybound()>=this.salary)
                    {   x=i;
                    break;
                    }
                }
                if(x!=-1)
                {
                    System.out.println("Companies According to your requirements are:");
                    for(x=rc.length-1;x>=i;x--)
                    {
                        if(this.getagg()>=rc[x].getaligibilitycriteria())
                        { System.out.println(rc[x].toString());
                          c_name=""+c_name+rc[x].getname()+"\t";
                        }
                    }
                }
                else
                {
                    System.out.println("No Company satisfy your Creiteria We will notify if there register Such Company.");
                    System.out.println("Thanks for cosidering our service ;).See you soon!");
                }
              }
              else
                    System.out.println("---------NO COMPANY HAS REGISTERED YET!---------");
             }
            catch(Exception e)
            {e.printStackTrace();
            }
        return c_name;
        }
}

