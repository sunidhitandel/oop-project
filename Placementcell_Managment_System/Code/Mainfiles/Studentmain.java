package Mainfiles;
import Registration.RegisterStudent;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Studentmain 
{
    public static final int MAX=1000;
    static int index=0;
    String path="C:\\Users\\Sunidhi\\Desktop\\Serialized File_Student\\";
    static RegisterStudent r[]=new RegisterStudent[1000]; 
    public void Register_Student() throws Exception
    {
        this.loadpreviousdata();
        r[index]=new RegisterStudent();
        System.out.println(index);
            try{
                ObjectOutputStream os1 = new ObjectOutputStream(new FileOutputStream(path+r[index].getname() + ".ser"));
                os1.writeObject(r[index]);
                os1.close();
            }
            catch(Exception exx){
                System.out.println(index);
                exx.printStackTrace();
            }
        
          //writing operation on display file:
          try{
              FileWriter fw=new FileWriter("C:\\Users\\Sunidhi\\Desktop\\OOP project\\display.txt",true);
              fw.write("New user registered "+"Username"+r[index].getname()+"Roll no"+r[index].getId()+"emailid"+r[index].getemailid()+"phone no."+r[index].getpno()+"with aggregation"+r[index].getagg()+"\n");
              fw.close();
              BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\Sunidhi\\Desktop\\OOP project\\Students_details.txt",true));
              bw.write(""+r[index].toString()+"\n"); 
              bw.close();
              }
          catch(Exception Ignores)
          {
              System.out.println(index);
              Ignores.printStackTrace();
          }
          index++;
    }
    
    public RegisterStudent[] getarr() throws Exception {
        this.loadpreviousdata();
        if(index!=0)
        {
        RegisterStudent r1[]=new RegisterStudent[index]; 
        for(int i=0;i<index;i++)
            r1[i]=r[i];
        return r1;
        }
        else 
            return null;
    }
    public void loadpreviousdata() throws Exception
    {
        RegisterStudent  object = null;
        try {
        index=0;
        File f=new File(path);
        File[] files=f.listFiles();
        for(int i=0;i<files.length&&files[i].isFile();i++)
        {
        ObjectInputStream ob1= new ObjectInputStream(new FileInputStream(files[i]));
        object= (RegisterStudent) ob1.readObject();
        r[index]=object;
        index++;
        ob1.close();
        }
        } catch (FileNotFoundException ex) {
                ex.printStackTrace();
        }
    }
    
}
