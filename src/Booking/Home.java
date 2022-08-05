package Booking;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;
public class Home {
	 static Map<Integer,Client> cl = new LinkedHashMap<Integer,Client>();
	 static int count=0;
	 boolean slot[]=new boolean[0];
	 Home()
     {  
	   boolean b=true;
	   while(b==true)
	   {
	   start();
	   time(1000);
	   }
     }
	 
	 public void start()
	 {
		    String choice="";
	        System.out.println("........Menu........");
			System.out.println("1.View booked Slots");
			System.out.println("2.Add Slot");
			System.out.println("3.Delete Slot");
			System.out.println("4.Display all Customer");
			System.out.println("5.Search Customer");
			System.out.println("6.Exit");
			choice=Input.getChoice();
            switch(choice)
	    	{
	    	 case "1":viewSlot();
	    	   break;
	    	 
	    	 case "2":addSlot();
	    	    break;
	    	 
	    	 case "3":deleteSlot();
	    	     break;
	    	 
	    	 case "4":viewAll();
	             break;
	             
	    	 case "5":search();
             break;
	         
	    	 case "6":System.out.println("Thank you");
	    		 System.exit(0);
		         break;
		     
	    	 default:
	    		 System.out.println("Invalid choice");
	    		 return;
	    	}		  
	 }
	 
	 // Creates new customer
     public static Client addClient()
     {
    	 return new Client(Input.getName(),Input.getAge(),Input.getEmail());
     }
     
     // view Slot
     public void viewSlot()
     {
    	int data=0;
    	for(int i=0;i<slot.length;i++){
    		if(slot[i]==true){
    		     data++;
    			System.out.println("Slot : "+(1+i)+" : "+cl.get(i+1));
    		}
    	}
    	 if(data==0)
      	   System.out.println("No Slot Booked Yet");
     }
     
     //book Slot
     public void bookSlot(int Choice)
     {
    	 try {
    	    cl.put(count,addClient());
    	    slot[count-1]=true;
      	    System.out.println("Slot Booked");
    	  }
    	  catch(InvalidEmailException e)
    	  {
    		  System.out.println(e);
    		  time(500);
    		  bookSlot(count);
    	  }
    	  
     }
     
     public void time(int i)
     {
    	 try { Thread.sleep(i);
	    	}
	    	catch(Exception e){}
     }
     
     // Check slot Available or not
     public boolean slotAvailable(int choice)
     {
    	 if(slot[choice-1]==true)
    		 return true;
    	 return false;
      }
     
     
     // Add Slot 
     public void addSlot(){
    	 boolean b[]= new boolean[slot.length+1];
    	 copyData(slot.length,b);
    	 slot=b;
    	 //choice=Input.getChoice();
    	    if(slotAvailable(++count)){
		    	  System.out.println(cl.get(count));
		          throw new SlotBookedException("Slot already booked");
		     }
		     bookSlot(count);
	    	 
     }
     
     public void copyData(int n,boolean b[])
     {
    	 for(int i=0;i<slot.length-1;i++)
    	 {
    		 b[i]=slot[i];
    	 }
     }
     //delete slot
     public void deleteSlot()
     {
    	 boolean b[]= new boolean[slot.length-1];
    	 copyData(slot.length-1,b);
    	 cl.remove(slot.length);
    	 slot=b;
    	 --count;
    	 System.out.println("Slot deleted SuccessFully");
     }
     
     //
     public void search()
     {
    	 System.out.println("1.Search By Slot");
	     System.out.println("2.Search By Customer Name");
	     System.out.println("3.Exit");
    	 String choice=Input.getChoice();
    	 switch(choice)
    	 {
    	 case "1":search(Input.getSlot());
             break;
         
    	 case "2":search(Input.getName());
             break;
         
    	 case "3":
         break;
         
    	 default:
    		 System.out.println("Invalid choice");
             break;
    	 }
     }
     
     //view all Customer
     public void viewAll()
     {
    	 if(cl.size()>0)
    	   System.out.println(cl);
    	 else
    	   System.out.println("No data found");
     }
     
     //Overridden method
     public void search(int sea)
     {
    	 if(cl.get(sea)!=null)
    	 System.out.println(cl.get(sea));
    	 else
    	 System.out.println("No data found");
     }
     
     //Overridden method
     public void search(String name)
     {
//    	 for(int i=1;i<=slot.length;i++)
//    	 {
//    		 if(cl.get(i)!=null && cl.get(i).equals(name))
//    		 {
//    			 System.out.println(cl.get(i));
//    			 return;
//    		 }
//    	 }
//    	 System.out.println("No data found");
    	 
    	 cl.entrySet().stream().filter((x)->x.getValue().getName().toLowerCase().startsWith(name.toLowerCase())).forEach(System.out::println);;
    	 Stream s=cl.entrySet().stream().filter((x)->x.getValue().getName().toLowerCase().startsWith(name.toLowerCase()));
    	 if(s.count()==0)
             System.out.println("No Data Found");
    	
     }
 }
