/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameticket_package;
import static gameticket_package.GameTicket.intialPrice;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class GameTicket {
 /**
 * this method is display the information of fans
 * final method
 */  
  
 final static void displayINFO(ArrayList<Fan> fan)
    {
        int curruntPostion=1;
        for(Fan f:fan)
        {
           if(f!=null)
          {
            float totalPrice=0;
            System.out.printf("The information of Fan %d \n", curruntPostion);
            System.out.println("The Date of match is : ");
            System.out.println(f.match.getDate());
            System.out.println("The Code of match is : ");
            System.out.println(f.match.getCodeForGame());
            System.out.println("The Location of match is : ");
            System.out.println(f.match.getLocation());
            System.out.println("Team 1 is : ");
            System.out.println(f.match.getTeam1());
            System.out.println("Team 2 is : ");
            System.out.println(f.match.getTeam2());
            System.out.println("The number of tickets you reserve is : ");
            int count=0;
             for(Seat se:f.seat)
             {
                if(se!=null)
                 {
                    count++;
                 }
             }
            System.out.println(count);
          for(Seat s:f.seat)
          {
             if(s!=null)
            {
           
              System.out.println("The Category of your seat is : ");
              System.out.println(s.getCategory());
              System.out.println("The Number of your seat is : ");
              System.out.println(s.getNumberOfSeat());
              System.out.println("The Price of your seat is : ");
              System.out.println(s.getPrice());
              totalPrice+=s.getPrice();
            }
          }
           System.out.println("The total price of your tickets is : ");
           System.out.println(totalPrice);
           System.out.println("****************************************************");
           curruntPostion++;
          }
        }
    }
    /**
     * Static method
     * @param args the command line arguments
     * @pram intialPrice Final data member
     */
   static final float intialPrice=600;
    public static void main(String[] args) {
        // TODO code application logic here
       ArrayList<Fan> fan=new ArrayList<Fan>();
         Scanner input=new Scanner(System.in);
         Game matchs[]=new Game[4];
         Game Match =new nationalGame("Caio stadium","Ahly","Zamalek",30,LocalDate.of(2020, Month.JUNE, 30));
         Game Match1 =new nationalGame("Alexandria stadium","Zamalek","Ismaily",40,LocalDate.of(2020, Month.SEPTEMBER, 28));
         Game Match2=new InternationalGame ("Brazil stadium","Brazil","Egypt",20,LocalDate.of(2020, Month.NOVEMBER, 9));
         Game Match3=new InternationalGame ("Argentina stadium","Egypt","Argentina",10,LocalDate.of(2020, Month.OCTOBER, 3));
        matchs[0]=Match;
         matchs[1]=Match1;
         matchs[2]=Match2;
         matchs[3]=Match3;
         Date d=new Date();
         System.out.println("Welcom in Sports Game Ticket");
         System.out.println("The Date of today is: "+d);
         System.out.println("-------------------------------------------");
         System.out.println("The Number of Matchs we have in The current time period is : ");
         System.out.println(Game.numberOfmatchs);
         for(int i=0;i<matchs.length;i++)
           {
            if(matchs[i]!=null)
             {
                System.out.printf("Information for Match: %d \n ", i+1);
                matchs[i].DisplayINFO();
              }
           }
        
         try
         {
             /**
              * hard coded data
              */
             Seat seats[]=new Seat[3];
            Ticket tickets []=new Ticket[3];
             ERROR error=new ERROR();
            Availablity avail=new Availablity(); 
            error.AvalivleSeat(avail.CheckTheSeatsAvailablity(Match3,101,1));
            Seat seat=new Seat(Match3,101);
            seat.setPrice(intialPrice);
            seat.setCategory(1);
             seats[0]=seat;
             Ticket ticket=new Ticket(Match3,seat);
             tickets[0]=ticket;
             Fan fans=new Fan(Match3,seats,tickets);
             fans.ReserveTicket(Match3, seats);
             fan.add(fans);
             fans.BetForTheGameResult(Match3, "Argentina");
             
           
             
             Seat seats1[]=new Seat[3];
            Ticket tickets1 []=new Ticket[3];
            error.AvalivleSeat(avail.CheckTheSeatsAvailablity(Match1,305,3));
            Seat seat1=new Seat(Match1,305);
            seat1.setPrice(intialPrice);
            seat1.setCategory(3);
            Seat seat2=new Seat(Match1,306);
            seat2.setPrice(intialPrice);
            seat2.setCategory(3);
             seats1[0]=seat1;
             seats1[1]=seat2;
             Ticket ticket1=new Ticket(Match1,seat1);
             Ticket ticket2=new Ticket(Match1,seat2);
             tickets1[0]=ticket1;
             tickets1[1]=ticket2;
             Fan fans1=new Fan(Match1,seats1,tickets1);
             fans1.ReserveTicket(Match1, seats1);
             fan.add(fans1);
             fans1.UpgradeSeatCategory(2, Match1, seat1);
             fans1.BetForTheGameResult(Match1, "Zamalek");
             error.CanceleCheacked(Match1.getDate());
             fans1.CancelReserve(Match1, seat2);
             boolean ifdeleteseat=false;
            boolean ifdeleteticket=false;
            for(Fan fa:fan)
            {
                if(fa!=null)
                {
                   int count=0;
                    for(Seat se:fa.seat)
                     {
                        if(se!=null)
                         {
                             count++;
                          }
                     }
                  if(count>=2)
                  {   
                      for(Seat se:fa.seat)
                       {
                          if(se!=null)
                           {
                              if(se.getNumberOfSeat()==seat2.getNumberOfSeat() && fa.match.getCodeForGame().equals(Match1.getCodeForGame()))
                               {
                                  //fan.remove(fa.seat);
                                   int length = 0;
                                   for (int i = 0; i < fa.seat.length; i++)
                                    {
                                      if (fa.seat[i] != se) fa.seat[length++] = fa.seat[i];
                                     }
                                 
                                    ifdeleteseat=true;
                                     break;
                                }
                            
                             }
                        }
                        for(Ticket tic:fa.ticket)
                        {
                             if(tic!=null)
                              {
                                 if(tic.seat.getNumberOfSeat()==seat2.getNumberOfSeat() && fa.match.getCodeForGame().equals(Match1.getCodeForGame()))
                                  {
                                   int len = 0;
                                    for (int i = 0; i < fa.ticket.length; i++)
                                    {
                                      if (fa.ticket[i] !=tic ) fa.ticket[len++] = fa.ticket[i];
                                    }
                                 
                                     ifdeleteticket=true;
                                      break;
                                    }
                            
                                }
                        }
                        if(ifdeleteticket==true&& ifdeleteseat==true)
                        {
                           break;
                        }
                   
                  }
                  else
                  {
                    if(fa.seat[0].getNumberOfSeat()==seat2.getNumberOfSeat() && fa.match.getCodeForGame().equals(Match1.getCodeForGame()))
                    {
                        fan.remove(fa);
                    }
                  }
                }
            
            }
             
             
             Seat seats2[]=new Seat[3];
           Ticket tickets2[]=new Ticket[3];
             error.AvalivleSeat(avail.CheckTheSeatsAvailablity(Match2,200,2));
            Seat seat3=new Seat(Match2,200);
            seat3.setPrice(intialPrice);
            seat3.setCategory(2);
            seats2[0]=seat3;
            Ticket ticket3=new Ticket(Match2,seat3);
            tickets2[0]=ticket3;
            Fan fans3=new Fan(Match2,seats2,tickets2);
            fans1.ReserveTicket(Match2, seats2);
            fan.add(fans3);
            fans3.UpgradeSeatCategory(1, Match2, seat3);
            fans3.BetForTheGameResult(Match2, "Egypt");
          
            
    
         }
        catch(InVaildDataException e)
       {
           System.out.println("##################################################");
           System.out.println(e.getMessage());
           System.out.println("##################################################");
       }

             try
             {
                 /**
                  * interact with user
                  */
               ERROR error=new ERROR();
               while(true)
                {
                   
                    int choice;
                  
                  System.out.println("For Reservation Enter [1]");
                  System.out.println("For Cancelation Enter [2]");
                  System.out.println("For Upgrade your ticket Enter [3]");
                  System.out.println("For Bet For The Game Result Enter [4]");
                  choice=Integer.valueOf(input.nextInt());
                  if(choice == 1)
                  {
                    System.out.println("NOTICE : every fan have ONLY three tickets\n" +
                                           "maybe less but NOT more");
                    System.out.println("Enter the number of the match you want"); 
                    int numbermatch=Integer.valueOf(input.nextInt());
                    error.DoseNotExistMatch(numbermatch);
                    if(numbermatch==1)
                    { 
                        Seat seats[]=new Seat[3];
                        Ticket tickets []=new Ticket[3];
                       while(true)
                       {     
                        
                        Availablity ava=new Availablity(); 
                        System.out.println("Enter the number of seat"); 
                        int numberofseat=input.nextInt();
                        int numberCategory=numberofseat/100;
                        error.AvalivleSeat(ava.CheckTheSeatsAvailablity(Match, numberofseat, numberCategory));
                        Seat seat=new Seat(Match,numberofseat);
                        for(int j=0;j<seats.length;j++)
                        {
                            if(seats[j]==null)
                            {
                               
                             seats[j]=seat;
                             seats[j].setCategory(numberCategory);
                             seats[j].setPrice(intialPrice);
                             break;
                             
                            }
                        }    
                            Ticket ticket=new Ticket(Match,seat);
                          for(int i=0;i<tickets.length;i++)
                          {
                            if(tickets[i]==null)
                            {
                               tickets[i]=ticket;  
                               
                               break;
                            }
                          }
                       
                        System.out.println("Do you want to reserve another ticket");
                        String ch=input.next();
                        if(ch.equals("No")||ch.equals("no"))
                        {
                             Fan fans=new Fan(Match,seats,tickets);
                             fans.ReserveTicket(Match,seats);
                             fan.add(fans);
                            break;
                        }
                       }
                      
                    }
                    else if(numbermatch==2)
                    {
                        Seat seats[]=new Seat[3];
                        Ticket tickets []=new Ticket[3];
                        while(true)
                       {     
                       Availablity ava=new Availablity(); 
                        System.out.println("Enter the number of seat"); 
                        int numberofseat=input.nextInt();
                        int numberCategory=numberofseat/100;
                        error.AvalivleSeat(ava.CheckTheSeatsAvailablity(Match1, numberofseat, numberCategory));
                        Seat seat=new Seat(Match1,numberofseat);
                        for(int j=0;j<seats.length;j++)
                        {
                            if(seats[j]==null)
                            {
                               
                             seats[j]=seat;
                             seats[j].setCategory(numberCategory);
                             seats[j].setPrice(intialPrice);
                             break;
                             
                            }
                        }    
                            Ticket ticket=new Ticket(Match1,seat);
                          for(int i=0;i<tickets.length;i++)
                          {
                            if(tickets[i]==null)
                            {
                               tickets[i]=ticket;  
                               
                               break;
                            }
                          }
                       
                        System.out.println("Do you want to reserve another ticket");
                        String ch=input.next();
                        if(ch.equals("No")||ch.equals("no"))
                        {
                             Fan fans=new Fan(Match1,seats,tickets);
                             fans.ReserveTicket(Match1,seats);
                             fan.add(fans);
                            break;
                        }
                       }
                    
                    }
                    else  if(numbermatch==3)
                    {
                        Seat seats[]=new Seat[3];
                        Ticket tickets []=new Ticket[3];
                        while(true)
                       {     
                        Availablity ava=new Availablity(); 
                        System.out.println("Enter the number of seat"); 
                        int numberofseat=input.nextInt();
                        int numberCategory=numberofseat/100;
                        error.AvalivleSeat(ava.CheckTheSeatsAvailablity(Match2, numberofseat, numberCategory));
                        Seat seat=new Seat(Match2,numberofseat);
                        for(int j=0;j<seats.length;j++)
                        {
                            if(seats[j]==null)
                            {
                               
                             seats[j]=seat;
                             seats[j].setCategory(numberCategory);
                             seats[j].setPrice(intialPrice);
                             break;
                             
                            }
                        }    
                            Ticket ticket=new Ticket(Match2,seat);
                          for(int i=0;i<tickets.length;i++)
                          {
                            if(tickets[i]==null)
                            {
                               tickets[i]=ticket;  
                               
                               break;
                            }
                          }
                       
                        System.out.println("Do you want to reserve another ticket");
                        String ch=input.next();
                        if(ch.equals("No")||ch.equals("no"))
                        {
                             Fan fans=new Fan(Match2,seats,tickets);
                             fans.ReserveTicket(Match2,seats);
                             fan.add(fans);
                            break;
                        }
                       }
                    
                    }
                    else   if(numbermatch==4)
                    {
                        Seat seats[]=new Seat[3];
                        Ticket tickets []=new Ticket[3];
                        while(true)
                       {     
                        Availablity ava=new Availablity(); 
                        System.out.println("Enter the number of seat"); 
                        int numberofseat=input.nextInt();
                        int numberCategory=numberofseat/100;
                        error.AvalivleSeat(ava.CheckTheSeatsAvailablity(Match3, numberofseat, numberCategory));
                        Seat seat=new Seat(Match3,numberofseat);
                        for(int j=0;j<seats.length;j++)
                        {
                            if(seats[j]==null)
                            {
                               
                             seats[j]=seat;
                             seats[j].setCategory(numberCategory);
                             seats[j].setPrice(intialPrice);
                             break;
                             
                            }
                        }    
                            Ticket ticket=new Ticket(Match3,seat);
                          for(int i=0;i<tickets.length;i++)
                          {
                            if(tickets[i]==null)
                            {
                               tickets[i]=ticket;  
                               
                               break;
                            }
                          }
                       
                        System.out.println("Do you want to reserve another ticket");
                        String ch=input.next();
                        if(ch.equals("No")||ch.equals("no"))
                        {
                             Fan fans=new Fan(Match3,seats,tickets);
                             fans.ReserveTicket(Match3,seats);
                             fan.add(fans);
                            break;
                        }
                       }
                        
                    }
                   displayINFO(fan);
                  }
                  else if(choice==2)
                  {
                      boolean ifhasreserve=false;
                      boolean ifdeleteticket=false;
                      System.out.println("Please enter the code of match You booked it");
                      String codeofmatch=input.next();
                      System.out.println("Please enter the number of seat You booked it");
                      int numberofseat=input.nextInt();
                       for(Fan f : fan)
                      {
                           if(f!=null)
                           {
                                int count=0;
                                for(Seat se:f.seat)
                                {
                                    if(se!=null)
                                    {
                                        count++;
                                    }
                                }
                               if(count>=2)
                               {   
                                  for(Seat s:f.seat)
                                   { 
                                      if(s!=null)
                                      {   
                                         if(s.getNumberOfSeat()==numberofseat && f.match.getCodeForGame().equals(codeofmatch))
                                         {
                                             error.CanceleCheacked(f.match.getDate());
                                             f.CancelReserve(f.match, s);
                                              int length=0;
                                             for (int i = 0; i < f.seat.length; i++)
                                              {
                                                if (f.seat[i] != s) f.seat[length++] = f.seat[i];
                                              }
                                             ifhasreserve=true;
                                              break;
                                          }
                                      }
                                   }
                                   for(Ticket t:f.ticket)
                                   {
                                       if(t!=null)
                                       {
                                          if(t.seat.getNumberOfSeat()==numberofseat && f.match.getCodeForGame().equals(codeofmatch))
                                          {
                                              int len = 0;
                                              for (int i = 0; i < f.ticket.length; i++)
                                              {
                                                 if (f.ticket[i] !=t ) f.ticket[len++] = f.ticket[i];
                                              }
                                 
                                               ifdeleteticket=true;
                                               break;
                                          }
                            
                                        }
                                  }
                                  if(ifhasreserve==true&&ifdeleteticket==true)
                                   {
                                       System.out.println("Your Reservation has been cancelled");
                                       break;
                                   }
                               }
                               else if(count<2)
                               {
                                  if(f.seat[0].getNumberOfSeat()==numberofseat && f.match.getCodeForGame().equals(codeofmatch))
                                   {
                                      error.CanceleCheacked(f.match.getDate());
                                      f.CancelReserve(f.match, f.seat[0]);
                                      fan.remove(f);
                                      ifhasreserve=true;
                                      System.out.println("Your Reservation has been cancelled");
                                       break;
                                   }    
                               }
                               
                         } 
                        
                      }
                     error.DoseNothavereservation(ifhasreserve);
                  }
                  else if(choice ==3)
                  {
                      boolean ifhasreserve=false;
                       System.out.println("Please enter the code of match You booked it");
                      String codeofmatch=input.next();
                      System.out.println("Please enter the number of seat You booked it");
                      int numberofseat=input.nextInt();
                      for(Fan f : fan)
                      {
                          if(f!=null)
                          {
                          for(Seat s:f.seat)
                          {
                              if(s!=null)
                              {
                                 
                                 if(s.getNumberOfSeat()==numberofseat && f.match.getCodeForGame().equals(codeofmatch))
                                 {   
                                    System.out.println("Please enter the number of Category you want to upgrade to ");
                                     int numcategory=input.nextInt();
                                     f.UpgradeSeatCategory(numcategory, f.match,s );
                                     ifhasreserve=true;
                                     break;
                                 }
                               }
                              
                          }
                          if(ifhasreserve==true)
                          {
                              break;
                          }
                         }
                      }
                      error.DoseNothavereservation(ifhasreserve);
                  }
                  else if (choice ==4)
                  {
                       System.out.println("Please enter the code of match You booked it");
                      String codeofmatch=input.next();
                      System.out.println("Please enter the number of seat You booked it");
                      int numberofseat=input.nextInt();
                      for(Fan f : fan)
                      {
                          for(Seat s:f.seat)
                          {  
                          if(s.getNumberOfSeat()==numberofseat && f.match.getCodeForGame().equals(codeofmatch))
                          {
                             System.out.println("Please enter the name of team to make the bet ");
                             String winteam=input.next();
                             f.BetForTheGameResult(f.match, winteam);
                             break;
                           }
                         }
                       }
                    }
                    System.out.println("Do you want to make another process");
                        String ch=input.next();
                        if(ch.equals("No")||ch.equals("no"))
                        {
                            break;
                        }
                }
            
             }
            catch(InVaildDataException e)
           {
           System.out.println("##################################################");
           System.out.println(e.getMessage());
           System.out.println("##################################################");
          }
         catch(NumberFormatException e)
        {
           System.out.println("##################################################");
           System.out.println("you MUST enter the choice as a number");
           System.out.println("##################################################");
       
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
           System.out.println("##################################################");
           System.out.println("Index Out of Bounds");
           System.out.println("##################################################");
        }
        
        System.out.println("Do you want to display all details about the matchs and fans after updated them");
        String choice =input.next();
        if(choice.equals("yes")||choice.equals("Yes"))
        {    
           System.out.println("Welcom in Sports Game Ticket");
           System.out.println("The Date of today is: "+d);
           System.out.println("-------------------------------------------");
           System.out.println("The Number of Matchs we have in The current time period is : ");
           System.out.println(Game.numberOfmatchs);
           for(int i=0;i<matchs.length;i++)
            {
              if(matchs[i]!=null)
               {
                 System.out.printf("Information for Match: %d \n ", i+1);
                 matchs[i].DisplayINFO();
               }
            }
          System.out.println("Information about all fans in the system : ");
          displayINFO(fan);
        }
         
    }
}
/**
 * this class creates the matches of the system 
 * this abstract class
 * @pram Location which has the location of this match
 * @param date  which has the the date of this match
 * @param CodeForGame Location which has the code of this match
 * @param Team1  which has the first team of this match
 * @param Team2 which has the second team of this match
 * @param NumberOfSeats Location which has the number of seats of this match
 * @param Category  which has the category of seat in this match
 * @param CodeOfSeatsinCategory1[]  which has the number of seats in the category 1 in this match
 * @param CodeOfSeatsinCategory2[]  which has the number of seats in the category 3 in this match
 * @param CodeOfSeatsinCategory3[]  which has the number of seats in the category 3 in this match
 * @param seat
 * @param numberOfmatchs which is has the number of object that creates from Game class
 */
 abstract class Game {
   private String Location;
  private  LocalDate date;
   private String CodeForGame;
   private String Team1,Team2;
   private final int NumberOfSeats;
   private int Category;
    static int numberOfmatchs=0;
   public int CodeOfSeatsinCategory1[],  CodeOfSeatsinCategory2[],  CodeOfSeatsinCategory3[];
   Seat seat;
   /**
    * the constructor to set this parameter from user
    * @param Location
    * @param Team1
    * @param Team2
    * @param NumberOfSeats
    * @param date 
    */
   public Game(String Location,String Team1,String Team2 ,int NumberOfSeats ,LocalDate date)
   {
       this.Team1=Team1;
       this.Team2=Team2;
       this.Location=Location;
       this.NumberOfSeats=NumberOfSeats;
       this.date=date;
       this.CodeForGame=date+Team1+Team2;
       numberOfmatchs++;
     CodeOfSeatsinCategory1=new int[NumberOfSeats * 1/5];
     for(int i=0 ; i<CodeOfSeatsinCategory1.length;i++)
     {
         CodeOfSeatsinCategory1[i]=100+i;
     }
     CodeOfSeatsinCategory2=new int[NumberOfSeats * 1/5];
      for(int i=0 ; i<CodeOfSeatsinCategory2.length;i++)
     {
         CodeOfSeatsinCategory2[i]=200+i;
     }
     CodeOfSeatsinCategory3=new int[NumberOfSeats * 3/5];
      for(int i=0 ; i<CodeOfSeatsinCategory3.length;i++)
     {
         CodeOfSeatsinCategory3[i]=300+i;
     }
   }
/**
 * this method is get array number of seats in category 1
 * @return CodeOfSeatsinCategory1
 */
    public int[] getCodeOfSeatsinCategory1() {
        return CodeOfSeatsinCategory1;
    }
/**
 * this method is set array number of seats in category 1
 * @param CodeOfSeatsinCategory1
 */
    public void setCodeOfSeatsinCategory1(int[] CodeOfSeatsinCategory1) {
        this.CodeOfSeatsinCategory1 = CodeOfSeatsinCategory1;
    }
/**
 * this method is get array number of seats in category 2
 * @return CodeOfSeatsinCategory2
 */
    public int[] getCodeOfSeatsinCategory2() {
        return CodeOfSeatsinCategory2;
    }
/**
 * this method is set array number of seats in category 2
 * @param CodeOfSeatsinCategory2
 */
    public void setCodeOfSeatsinCategory2(int[] CodeOfSeatsinCategory2) {
        this.CodeOfSeatsinCategory2 = CodeOfSeatsinCategory2;
    }
/**
 * this method is get array number of seats in category 3
 * @return CodeOfSeatsinCategory3
 */
    public int[] getCodeOfSeatsinCategory3() {
        return CodeOfSeatsinCategory3;
    }
/**
 * this method is set array number of seats in category 3
 * @param CodeOfSeatsinCategory3
 */
    public void setCodeOfSeatsinCategory3(int[] CodeOfSeatsinCategory3) {
        this.CodeOfSeatsinCategory3 = CodeOfSeatsinCategory3;
    }
   /**
    * this method is display the information of matches
    */
    public  void DisplayINFO()
    {
      
        System.out.println("The Date of match is: ");
        System.out.println(getDate());
        System.out.println("The Code of match is: ");
        System.out.println(getCodeForGame());
        System.out.println("The Location of match is: ");
        System.out.println(getLocation());
        System.out.println("Team 1 is: ");
        System.out.println(getTeam1());
        System.out.println("Team 2 is: ");
        System.out.println(getTeam2());
        System.out.println("The Number of Seats in stadium is: ");
        System.out.println(getNumberOfSeats());
        System.out.println("The Number of Seats in Category 1 is: ");
        for(int i=0 ;i<CodeOfSeatsinCategory1.length;i++)
        { 
            if(getCodeOfSeatsinCategory1()[i]==-1)
            {
                continue;
            }
          System.out.println(getCodeOfSeatsinCategory1()[i]);
        }
        System.out.println("The Number of Seats in Category 2 is: ");
       for(int i=0 ;i<CodeOfSeatsinCategory2.length;i++)
        {
            if(getCodeOfSeatsinCategory2()[i]==-1)
            {
                continue;
            }
          System.out.println(getCodeOfSeatsinCategory2()[i]);
        }
        System.out.println("The Number of Seats in Category 3 is: ");
        for(int i=0 ;i<CodeOfSeatsinCategory3.length;i++)
        {
            if(getCodeOfSeatsinCategory3()[i]==-1)
            {
                continue;
            }
          System.out.println(getCodeOfSeatsinCategory3()[i]);
        }
        System.out.println("-----------------------------------------------");
      
    }
    /**
     * this method is get the location of the match
     * @return Location
     */
    public String getLocation() {
        return Location;
    }
/**
 * this method is set the location of the match
 * @param Location 
 */
    public void setLocation(String Location) {
        this.Location = Location;
    }
/**
* this method is get the team 1 of the match
 * @return Team1
 */
    public String getTeam1() {
        return Team1;
    }
/**
 * this method is set team1
 * @param Team1 
 */
    public void setTeam1(String Team1) {
        this.Team1 = Team1;
    }
/**
* this method is get the team 2 of the match
 * @return Team2
 */
    public String getTeam2() {
        return Team2;
    }
/**
 * this method is set team2
 * @param Team2 
 */
    public void setTeam2(String Team2) {
        this.Team2 = Team2;
    }
/**
* this method is get the code of the match
 * @return CodeForGame
 */
    public String getCodeForGame() {
        return CodeForGame;
    }
/**
 * this method is set code of the match
 * @param CodeForGame 
 */
    public void setCodeForGame(String CodeForGame) {
        this.CodeForGame =getDate()+getTeam1()+getTeam2();
    }
/**
* this method is get the number of seats  of the match
 * @return NumberOfSeats
 */
    public int getNumberOfSeats() {
        return NumberOfSeats;
    }
/**
* this method is get the date of the match
 * @return date
 */
    public LocalDate getDate() {
        return date;
    }
/**
 * this method is set date of the match
 * @param date 
 */
    public void setDate(LocalDate date) {
        this.date = date;
    }
    
}
/**
 * in this class we inheritans from the game class
 * and we just called the super which is the constructor of the game class who is the parent 
 * Inheritance tree
 */
 class InternationalGame extends Game {
    
    public InternationalGame(String Location,String Team1,String Team2,int NumberOfSeats,LocalDate date)
    {
      super( Location, Team1, Team2 , NumberOfSeats, date);  
    }
   
} 
/**
 * in this class we inheritans from the game class
 *  and we just called the super which is the constructor of the game class who is the parent
 * Inheritance tree
 */
 class nationalGame extends Game {
     public nationalGame(String Location,String Team1,String Team2,int NumberOfSeats,LocalDate date)
    {
      super( Location, Team1, Team2, NumberOfSeats, date);  
    }
     
}
/**
 * in this class we create the ticket
 * 
 */
 class Ticket{
    Game Match;
    Seat seat;
    public Ticket(Game Match,Seat seat)
    {
       this.Match=Match;
       this.seat=seat;
    }
     
}
/**
 * in this class we create the Seat
 * @param NumberOfSeat which is has the number of seat for the user
 * @param Category which is has the number of category depends on the number of seat for the user
 * @param Price which has the price depends on the category of the user
 */

 class Seat {
 
     private int NumberOfSeat;
     private int Category;
     private float Price; 
     Game match;
     /**
      * the constructor to set this parameter from user
      * @param match
      * @param NumberOfSeat 
      */
    public Seat(Game match,int NumberOfSeat)
    {
         this.NumberOfSeat=NumberOfSeat;
        this.match=match;
        this.Category=Category;
        
        
    }

/**
 * this method is get the price of seat depends on the category
 * @return Price
 */
  
    public float getPrice() {
        return Price;
    }
/**
 * this method is set the price of seat depends on the category
 * @param Price 
 * Calculated data members 
 */
    public void setPrice(float Price) {
        switch(Category)
         {
                case 1:
                    this.Price = Price*5;    
                break;
                case 2:
                   this.Price = Price*3;
                 break;
                 case 3:
                   this.Price = Price;
                break;
                 default:this.Price=Price;
         }
    }
/**
 * this method is get the category
 * @return Category
 */
    public int getCategory() {
        return Category;
    }
/**
 * this method is set the category
 * @param Category 
 */
    public void setCategory(int Category) {
        this.Category = Category;
    }
/**
 * this method is get the number of seat for the user
 * @return NumberOfSeat
 */
    public int getNumberOfSeat() {
        return NumberOfSeat;
    }
/**
 * this method is set the number of seat for the user
 * @param NumberOfSeat 
 */
    public void setNumberOfSeat(int NumberOfSeat) {
        this.NumberOfSeat = NumberOfSeat;
    }

  
}
/**
 * this class only have one responsibility which is take from user match and the number of seat he want
 * and number of category to check if the seat is available or not 
 * if boolean is true which is available
 * if boolean is false not available
 * the SOLID object-oriented design principles 
 * S is Single-responsibility-principle
 */
 class Availablity
{
 public boolean CheckTheSeatsAvailablity(Game match,int seat ,int numberCategory)
  {
      
      if(numberCategory==1)
      {
          for(int i=0 ;i<match.CodeOfSeatsinCategory1.length;i++)
          {
             if(seat==match.getCodeOfSeatsinCategory1()[i])
             {
                 
                 return true;
                 
             }
          }
          
      }
      else if (numberCategory==2)
      {
          
          for(int i=0 ;i<match.CodeOfSeatsinCategory2.length;i++)
          {
             if(seat==match.getCodeOfSeatsinCategory2()[i])
             {
                
                 return true;
                
             }
          }
          
      }
      else if (numberCategory==3)
      {
         for(int i=0 ;i<match.CodeOfSeatsinCategory3.length;i++)
          {
             if(seat==match.getCodeOfSeatsinCategory3()[i])
             {
                 
                 return true;
                 
             }
          } 
      }
      return false;
  }
}
/**
 * this class have all the function the user he will want 
 * Interface class
 * 
 */

 interface Forreservation
{
    
    public  void ReserveTicket(Game match,Seat[] seat);
    public  void CancelReserve(Game match ,Seat seat);
    public  void UpgradeSeatCategory(int category,Game match,Seat seat);
    public  void BetForTheGameResult(Game match ,String WinTeamFromUser);
   
}
/**
 * this class is implements Forreservation class
 * @param seat which is array of seats for one user
 * @param ticket which is array of tickets for one user
 */
 class Fan implements Forreservation {
     Game match;
      Seat[] seat=new Seat[3];
     Ticket ticket []=new Ticket[3];
     /**
      * the constructor to set this parameter from user
      * @param match
      * @param seat
      * @param ticket 
      */
     public Fan(Game match,Seat[] seat,Ticket[] ticket)
     {
         this.match=match;
         this.seat= seat;
         this.ticket=ticket;
     }
/**
 * this method to get array of seat
 * @return seat
 */
    public Seat[] getSeat() {
        return seat;
    }
/**
 * this method to set array of seat
 * @param seat 
 */
    public void setSeat(Seat[] seat) {
        this.seat = seat;
    }
/**
 * this method to get array of ticket
 * @return ticket
 */
    public Ticket[] getTicket() {
        return ticket;
    }
/**
 * this method to set array of ticket
 * @param ticket 
 */
    public void setTicket(Ticket[] ticket) {
        this.ticket = ticket;
    }
     /**
      * this function to reservation ticket for user 
      * it loops inside the array of category depends on the number of seat we got from user 
      * @param match his match he want to reserve
      * @param seat his seat he want to reserve in this match
      * Overriding method
      */
     @Override
    public  void ReserveTicket(Game match ,Seat[] seat)
   {
       
       for(int j=0 ;j<seat.length;j++)
       {
           if(seat[j]!=null)
           {
      if(seat[j].getCategory()==1)
      {
         for(int i=0 ;i<match.CodeOfSeatsinCategory1.length;i++)
          {
             if(seat[j].getNumberOfSeat()==match.getCodeOfSeatsinCategory1()[i])
             {
                 match.getCodeOfSeatsinCategory1()[i]=-1;
                 System.out.println("You have been successfully booked"); 
                 break;
             }
          }
          
      }
      else if (seat[j].getCategory()==2)
      {
          for(int i=0 ;i<match.CodeOfSeatsinCategory2.length;i++)
          {
             if(seat[j].getNumberOfSeat()==match.getCodeOfSeatsinCategory2()[i])
             {
                match.getCodeOfSeatsinCategory2()[i]=-1;
                System.out.println("You have been successfully booked"); 
                break; 
             }
          }
          
      }
      else if (seat[j].getCategory()==3)
      {
         for(int i=0 ;i<match.CodeOfSeatsinCategory3.length;i++)
          {
             if(seat[j].getNumberOfSeat()==match.getCodeOfSeatsinCategory3()[i])
             {
                match.getCodeOfSeatsinCategory3()[i]=-1;
                System.out.println("You have been successfully booked"); 
                break;  
             }
          } 
      }
      }
     }
    }
    /**
     * this function to cancelation ticket for user 
     * it loops inside the array of category depends on the number of seat we got from user 
     * and check before calling function on if exception needed to throw
     * @param match his match he want to cancele
     * @param seat his seat he want to reserve in this match
     * Overriding method
     */
   @Override
    public  void CancelReserve(Game match ,Seat seat)
    {
          int whichSeatInArray=seat.getNumberOfSeat()%10;
          if(seat.getCategory()==1)
         {
           for(int i=0 ;i<match.CodeOfSeatsinCategory1.length;i++)
            { 
               if(whichSeatInArray==i)
               {
                match.getCodeOfSeatsinCategory1()[i]=seat.getNumberOfSeat();
                break;
               }
            }
          
         }
        else if (seat.getCategory()==2)
        {
            for(int i=0 ;i<match.CodeOfSeatsinCategory2.length;i++)
           {
              if(whichSeatInArray==i)
              {
                match.getCodeOfSeatsinCategory2()[i]=seat.getNumberOfSeat();
               break;
              }
           }
          
       }
      else if (seat.getCategory()==3)
           {
             for(int i=0 ;i<match.CodeOfSeatsinCategory3.length;i++)
             {
                if(whichSeatInArray==i)
                {
                match.getCodeOfSeatsinCategory3()[i]=seat.getNumberOfSeat();
                break;
                }
               } 
            }
    
    }
   /**
     * this function to upgrade ticket for user 
     * it loops inside the array of category depends on the number of seat we got from user 
     * to find available seat to upgrade to
     * then set new price depends on his new category
     * and check inside function on if exception needed to throw
     * @param category the category he want to upgrade to
     * @param match his match he want to upgrade his seat in
     * @param seat his seat he want to upgrade in this match
     * Overriding method
     */
    @Override
    public  void UpgradeSeatCategory(int category,Game match,Seat seat)
    {
        ERROR error=new ERROR();
        try
        { 
          error.UpgradeIsDone(seat.getCategory() , category);
          int cat=seat.getCategory();
          int num=seat.getNumberOfSeat();
          boolean findnewSeat=false;
          
          if(cat==3)
          {
              
              if(category==2)
               {
                  for(int i=0 ;i<match.CodeOfSeatsinCategory2.length;i++)
                   {
                      if(match.getCodeOfSeatsinCategory2()[i]!=-1)
                       {
                            CancelReserve(match,seat);
                            seat.setCategory(category);
                            seat.setNumberOfSeat(match.getCodeOfSeatsinCategory2()[i]);
                            seat.setPrice(intialPrice);
                            findnewSeat=true;
                            match.getCodeOfSeatsinCategory2()[i]=-1;
                            System.out.println("You have been successfully upgraded"); 
                            break;
                       }
                    }
                 if(findnewSeat==false)
                  {
                    for(int i=0 ;i<match.CodeOfSeatsinCategory1.length;i++)
                     {
                        if(match.getCodeOfSeatsinCategory1()[i]!=-1)
                         {
                            CancelReserve(match,seat);
                            seat.setCategory(category);
                            seat.setNumberOfSeat(match.getCodeOfSeatsinCategory1()[i]);
                            seat.setPrice(intialPrice);
                            findnewSeat=true;
                            match.getCodeOfSeatsinCategory1()[i]=-1;
                            System.out.println("Sorry All Seats in Category 2 have been Reserved");
                            System.out.println("So, We Reserve For you in Caategory 1 & Have a Good Time. ");
                            break;
                        }
                      }
                      
                   }
                 error.UpgradeIsDone(findnewSeat, category);
            }
            else if(cat==1)
            {
                     for(int i=0 ;i<match.CodeOfSeatsinCategory1.length;i++)
                    {
                         if(match.getCodeOfSeatsinCategory1()[i]!=-1)
                         {
                              CancelReserve(match,seat);
                              seat.setCategory(category);
                              seat.setNumberOfSeat(match.getCodeOfSeatsinCategory1()[i]);
                              seat.setPrice(intialPrice);
                              findnewSeat=true;
                              match.getCodeOfSeatsinCategory1()[i]=-1;
                              System.out.println("You have been successfully upgraded");
                              break;
                         }
                    }
                     error.UpgradeIsDone(findnewSeat, cat);
                
            }
              
          }
          else if(cat==2)
          {
                for(int i=0 ;i<match.CodeOfSeatsinCategory1.length;i++)
                {
                   
                     if(match.getCodeOfSeatsinCategory1()[i]!=-1)
                     {
                        
                        CancelReserve(match,seat);
                        seat.setCategory(category);
                        seat.setNumberOfSeat(match.getCodeOfSeatsinCategory1()[i]);
                        seat.setPrice(intialPrice);
                        findnewSeat=true;
                        match.getCodeOfSeatsinCategory1()[i]=-1;
                        System.out.println("You have been successfully upgraded");
                        break;
                     }
                }
              error.UpgradeIsDone(findnewSeat, 1);  
          }
          
      
     
     }
          catch(InVaildDataException e)
       {
          System.out.println("##################################################");
          System.out.println(e.getMessage());
          System.out.println("##################################################");
       }
       
            
    }
    /**
     * this function to make the bet for user 
     * it is randomly pick the win team
     * then check on the bet of the user if it is same so the user win the bet else he lose the bet
     * @param match which is the match he want to make the bet on
     * @param WinTeamFromUser which is the win team of the user
     * Overriding method
     */
    @Override
     public  void BetForTheGameResult(Game match ,String WinTeamFromUser)
     {
     /**
      * @pram WinTeam Final data member
      */
       final String WinTeam;
         String [] teams=new String[2];
         teams[0]=match.getTeam1();
         teams[1]=match.getTeam2();
         int i = new Random().nextInt(teams.length);
          WinTeam=teams[i];
         
         if(match instanceof nationalGame)
         {
             
             if(WinTeam.equals(WinTeamFromUser))
             {
                 System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                 System.out.println("YOU WIN THE BET !!!");
                 System.out.printf("CONGRATORATIONS %s TEAM \n",WinTeam);
                 System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
             }
             else
             {
                 System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                 System.out.println("YOU LOSE THE BET !!!");
                 System.out.printf("CONGRATORATIONS %s TEAM \n",WinTeam);
                 System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
             }
         }
         else if(match instanceof InternationalGame)
         {
           
             if(WinTeam.equals(WinTeamFromUser))
             {
                 System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                 System.out.println("YOU WIN THE BET !!!");
                 System.out.printf("CONGRATORATIONS %s TEAM \n",WinTeam);
                 System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
             }
             else
             {
                 System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                 System.out.println("YOU LOSE THE BET !!!");
                 System.out.printf("CONGRATORATIONS %s TEAM \n",WinTeam);
                 System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                 
             }
         }
     }

   
}

 class InVaildDataException extends Exception
{
    InVaildDataException(String Message )
    {
       super(Message); 
    }    
}
/**
 * 
 * class to Exception handling my defined exception 
 */
 class ERROR
{
    /**
     * this method is check on the current date of day the user want
     * to cancelation his reserve if the days between current day
     * and date of match is less than 3 days it is throw exception
     * @param DateMatch the date of the match 
     * @throws InVaildDataException exception
     */
    void CanceleCheacked(LocalDate DateMatch) throws InVaildDataException
     {
        LocalDate now =LocalDate.now();
       long daybetween=ChronoUnit.DAYS.between(now,DateMatch);
        if (daybetween <3)
        {
            throw new InVaildDataException("Sorry, you CAN NOT cancele the reservetion, Becasue the number days befor match less than 3 days");
        }
         
    }
/**
 * this method it is check if the upgrade is done or not
 * if not it's throws exception
 * @param newSeat the boolean if is true the upgrade is done
 * @param categoryheWant the number of category he want to upgrade to
 * @throws InVaildDataException 
 * Overloading 
 * Exception handling 
 */    
    void UpgradeIsDone(boolean newSeat ,int categoryheWant) throws InVaildDataException
    {
        if(newSeat==false &&categoryheWant==2) 
        {
            throw new InVaildDataException("Sorry All Seats in Category 2 have been Reserved and "+
                    "We  try to upgrade to category 1 but it is also All Seats have been Reserved"+
                    "So,you STILL in your Caategory & Have a Good Time");
        }
        else if(newSeat==false &&categoryheWant==1)
        {
           throw new InVaildDataException("Sorry All Seats in Category 1 have been Reserved"+
                   "So,you STILL in your Caategory & Have a Good Time. ");
        }
        
    }
/**
 * this method it is check if the category he want to upgrade to is larger then of his already category throws exception
 * @param hiscategory his already category
 * @param categoryheWant the category he want to
 * @throws InVaildDataException 
 * Overloading 
 * Exception handling 
 */
    void UpgradeIsDone(int hiscategory ,int categoryheWant) throws InVaildDataException
    {
        if(hiscategory<categoryheWant)
        {
            throw new InVaildDataException("Sorry, you can NOT Upgrade  ");
        }
    }
/**
 * this method it is check if seat he enter is already taken throws exception
 * @throws InVaildDataException 
 */    
    void AvalivleSeat(boolean seat)throws InVaildDataException
    {
        if(seat==false)
        {
          
        throw new InVaildDataException("This Seat is already taken from another user ");
    
        }
        
    }    
/**
 * this method it is check if the match he enter is not exists throws exception
 * @param numberofmatch the number of the match he enter
 * @throws InVaildDataException 
 */
    void DoseNotExistMatch(int numberofmatch)throws InVaildDataException
    {
        if(numberofmatch >4)
        {
          throw new InVaildDataException("This Number of match is NOT Available ");
        }
        else if (numberofmatch <1)
        {
          throw new InVaildDataException("This Number of match is NOT Available ");
        }
      
    }
    
    void DoseNothavereservation(boolean ifhas)throws InVaildDataException
    {
        if(ifhas==false)
        {
          throw new InVaildDataException("You have NOT Reservation So, you can't make canceletion");
        }
       
      
    }
    
    
}

