package Mainfiles;
import static Mainfiles.Studentmain.index;
import Registration.RegisterCompany;
import Registration.RegisterStudent;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.*;
public class Companymain {
    public static final int MAX=1000;
    static int index=0;
    String path="C:\\Users\\Sunidhi\\Desktop\\SerializedFile_Company\\";
    static RegisterCompany c[]=new RegisterCompany[1000]; 
    public void Register_Company() throws Exception
    {
        this.loadpreviousdatac();
        c[index]=new RegisterCompany();
        
            try{
                ObjectOutputStream os2 = new ObjectOutputStream(new FileOutputStream(path+c[index].getname() + ".ser"));
                os2.writeObject(c[index]);
                os2.close();
            }
            catch(Exception exx){
                exx.printStackTrace();
            }
        
          //writing operation on display file:
          try{
              BufferedWriter fw=new BufferedWriter(new FileWriter("C:\\Users\\Sunidhi\\Desktop\\OOP project\\display.txt",true));
              fw.write("New Company Registred:  "+c[index].getname()+"\taligibility criteria is"+c[index].getaligibilitycriteria()+"emailid"+c[index].getemailid()+"\t vacancies"+c[index].getprofile()+"\n");
              fw.close();
              BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\Sunidhi\\Desktop\\OOP project\\Company_details.txt",true));
              bw.write(""+c[index].toString()+"\n"); 
              bw.close();
          }
          catch(Exception Ignores)
          {
              Ignores.printStackTrace();
          }
          index++;
    }
    public RegisterCompany[] getarr() throws Exception {
        this.loadpreviousdatac();
        if(index!=0)
        {
        RegisterCompany rc1[]=new RegisterCompany[index]; 
        for(int i=0;i<index;i++)
            rc1[i]=c[i];
        return rc1;
        }
        else
            return null;
    }
    public void loadpreviousdatac() throws Exception
    {
        RegisterCompany  objectc = null;
        try {
        index=0;
        File f=new File(path);
        File[] files=f.listFiles();
        for(int i=0;i<files.length&&files[i].isFile();i++)
        {
        ObjectInputStream ob1= new ObjectInputStream(new FileInputStream(files[i]));
        objectc= (RegisterCompany) ob1.readObject();
        c[index]=objectc;
        index++;
        ob1.close();
        }
        } catch (FileNotFoundException ex) {
                ex.printStackTrace();
        }
    }
    public void rnoupdate(String name,String sinfo) throws FileNotFoundException
    {
        int i=0;
        for(;i<index;i++)
        {
            if(name.equals(c[i].getname()))break;
        }   
        c[i].setcandidate();
        if(!c[i].setstu_details(sinfo))
            System.out.println("User has already Registered");
        else
        {
        ObjectOutputStream os2;
        try {
            os2 = new ObjectOutputStream(new FileOutputStream(path+c[i].getname() + ".ser"));
            os2.writeObject(c[i]);
            os2.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("Interview is scheduled on"+c[i].getinterview());
        }
    }
}
