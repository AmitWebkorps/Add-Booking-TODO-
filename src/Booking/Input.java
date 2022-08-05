package Booking;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Input {
   static Scanner sc = new Scanner(System.in);
   public static String getChoice()
   {
	   System.out.println("Enter Your Choice :");
	   return sc.next();
   }
   public static int getSlot()
   {
	   System.out.println("Enter Slot:");
	   return sc.nextInt();
   }
   public static String getName()
   {
	   System.out.println("Enter Customer Name :");
	   return sc.next();
   }
   public static int getAge()
   {
	   System.out.println("Enter Customer Age :");
	   return sc.nextInt();
   }
   public static String getEmail()
   {
	   System.out.println("Enter Customer Email :");
	   return sc.next();
   }
}
