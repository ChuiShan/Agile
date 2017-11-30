/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlaceOrder_Pc;
import java.util.ArrayList;
import java.util.Scanner;

public class PlaceOrder {

       String ans;
       String Yes;
       
  public class AddOrder{
      
  }
   
    public static void main(String[] args) {
        PlaceOrder po=new PlaceOrder();
       Scanner scanner= new Scanner(System.in);
       
           ArrayList<String> odList = new ArrayList<String>();
           String[]prod={"Chicken Burger","FrenchFried","Nugget","Cola"};
           odList.add("1.Chicken Burger");
           odList.add("2.FrenchFried");
           odList.add("3.Nugget");
           odList.add("4.Cola");
           for (int i = 0; i < odList.size(); i++) {
           
           System.out.println(odList.get(i));
      
}
           String ans[];
         System.out.printf("Please Select Your Order: ");
         
          po.ans=scanner.nextLine();
          System.out.println();
          System.out.printf("Do you want to add order?");
          po.Yes=scanner.nextLine();
          System.out.println();
            
        do{
            for (int i = 0; i < odList.size(); i++) {
           
           System.out.println(odList.get(i));
           
           }  System.out.printf("Please Select Your Order: ");
         
          po.ans=scanner.nextLine();
          System.out.println();
          System.out.printf("Do you want to add order?");
          po.Yes=scanner.nextLine();
          System.out.println();
        
        }while(po.Yes.equals("Y")|| po.Yes.equals("y"))     ;  
            System.out.println("Thank You^.^");
        }

    }
    

