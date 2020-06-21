package absclass;
import java.util.*;

public interface BaseCompany {
  
    abstract String getname();
    abstract void setname();
    abstract String getemailid();
    abstract void setemailid();
    abstract int getprofile();
    abstract void setprofile();
    abstract void setprofile(int i);
    abstract void setsalarybound();
    abstract int getsalarybound();
    abstract void setaligibilitycriteria(); 
    abstract double getaligibilitycriteria();  
    abstract boolean setstu_details(String name);
    abstract String getstu_details();
    abstract void setcandidate();
    abstract int getcandidate();
    abstract void setinterview();
    abstract String getinterview();
   
}
 