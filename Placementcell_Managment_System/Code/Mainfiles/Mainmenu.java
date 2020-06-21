package Mainfiles;
import Login.*;
import java.util.Scanner;
public class Mainmenu {
  public static void main(String args[]) throws Exception
  {
      int i=1;
      System.out.println("Welcome to Placement Cell Window.");
      while(i!=3)
      {
       Scanner sc=new Scanner(System.in);
      System.out.println("Enter your choice 1.Login 2.Registration 3.Quit");
      try{
      i=sc.nextInt();
      switch(i)
      {
          case 1:
              Login l=new Login();
              break;
          case 2:
              Registration r=new Registration();
              break;
          case 3:
              break;
          default:
              System.out.println("------------ENTER VALID INPUT------------");
              Mainmenu m=new Mainmenu();       
      }
      }
      catch(Exception e)
      {
         System.out.println("INVALID INPUT");
      }
      }
      
  }
}
