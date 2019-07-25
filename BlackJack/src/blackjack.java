import IBIO.IBIO;

/*
 * Program: 
 * Student Name: Rahul
 * Student Number: 661174
 * Description: Plays a game of black jack with the user, user can draw up to 5 cards, if the total of the cards exceeds
 * 21, YOU LOSE
 * 
*/


public class blackjack
{
  public static void main (String args[])
  {
    new blackjack();
  }
  
  public void Blackjack ()
  { 
    System.out.println ("****** WELCOME TO BLACKJACK! ******");
    System.out.println ("Each number card is worth that value, Kings , Queens and Jacks are worth 10, Aces are 11.");
    System.out.println ("Don't go over 21 or you will bust and lose, you can have a max of 5 cards.");
    System.out.println ("");
    char Cont = 'y'; //Restart Variable to restart the game
    System.out.print("Press enter to continue the dialogue...");
    try
    {
      System.in.read();
    }  
    catch(Exception e)
    {}  
    while (Cont == 'y'|| Cont == 'Y') 
    {
    int Tot1 = 0; // when game restarts, this clears the player and dealer card values
    int DTotal = 0;
    
    int Dcard1 = (int)(Math.random()*9)+2;  //makes the dealer's card value
    int Dcard2 = (int)(Math.random()*9)+2;  //makes the dealer's second card value
    DTotal = Dcard1 + Dcard2; //finds dealer's total
    
    int Pcard1 = (int)(Math.random()*9)+2; //the 2 random card values the user gets
    int Pcard2 = (int)(Math.random()*9)+2;
    Tot1 = Pcard1 + Pcard2; //total card value of user

      
   if (Tot1 <21) //if the player's total is below 21 this code executes (this is the draw more cards function)
      {
 System.out.println ("You still got room for more cards! "); 
 System.out.println ("Your total: " + Tot1); //prints users total to screen
 char Res1 = IBIO.inputChar("Want another card? (y/n) "); //this determines if the user wants to risk getting 
 // another card, this is used to keep the loop of the player getting new cards going
 int numcard = 2; //number of cards user has
 while (Tot1 <22 && (Res1 =='y'||Res1 =='Y')&& numcard <6 )
  //this loop will keep running as long 
  // 1)as the user agrees to keep getting cards (enters y or Y)
  // 2)Their total card amount is smaller than 22
  // 3)their total cards is below 6
  // if any of theese are false the loop will stop
  {
   numcard = numcard + 1; //whenever the loop runs it adds 1 to the number of cards
   //this is what limits the player to a max of 5 cards
   Tot1 = Tot1 + (int)(Math.random()*9)+2; //adds a random card to the player
   System.out.println("Your total is: " + Tot1); //prints out new total
  if (Tot1 < 21) //if the player still has below 6 cards (the loop will stop if they have more than 5)
    //and has a total of below 21, it will ask to repeat the loop
     {
      Res1 = IBIO.inputChar("Want another card? (y/n) "); //asking player if they want another card
     }
   else 
     {
       Res1 ='n'; //if the total value is not equal to or above 21 it will exit the loop, by setting the variable
       //that is used to continue the loop to negative we stop the loop
     }
 }
     }
   

    while (DTotal < 17) //if the dealer has a total below 17 they will draw a new card
    {
     DTotal = DTotal + (int)(Math.random()*9)+2; //gets the new card value for the dealer
    }
    if (Tot1 == 21) //if the players total is equal to 21 it will print out that they win
    { 
      System.out.println("YOU GOT A BLACKJACK, YOU WIN!!!!!!"); 
      Cont = IBIO.inputChar ("Want to play again? (y/n) ");
     
    }
    
    else if ( Tot1 > 21) //this makes sure that the players total is not over 21, if it is it tells the player they lost
    {
      System.out.println("Looks like you busted :(, Thanks for the money <3");
      Cont = IBIO.inputChar ("Want to play again? (y/n) ");
    
    }
   
     else if (DTotal > 21) //this makes sure that the dealer did not go over the limit, if the dealer busts it tells the player they won
       {
       System.out.println("Looks like Reyes busted, so YOU WIN!!!!!");
       System.out.println("Your total: " + Tot1);
       System.out.println("Reyes's total: " + DTotal);
       Cont = IBIO.inputChar ("Want to play again? (y/n) ");
       
       }
 
      else if ( DTotal > Tot1 )//determines if the dealer has a higher value than the player, if true it notifies the player they lost
     {
       System.out.println("Looks like the Reyes beat you, too bad!");
       System.out.println("Your total: " + Tot1);
       System.out.println("Reyes's total: " + DTotal);
       Cont = IBIO.inputChar ("Want to play again? (y/n) ");
       
     }
      
       else if ( DTotal == Tot1 )// if both the player and the dealer have the same total, it will notify the player of this
     {
       System.out.println("Looks like both of you got the same thing :/");
       System.out.println("Both of you got: " + Tot1);
       Cont = IBIO.inputChar ("Want to play again? (y/n) ");
      
     }
     else // the only possibility left is that the player has a higher total than the dealer, so it notifies the player they won
     {
       System.out.println("Looks like you beat Reyes, so YOU WIN!");
       System.out.println("Your total: " + Tot1);
       System.out.println("Reyes's total: " + DTotal);
       Cont = IBIO.inputChar ("Want to play again? (y/n) ");
      
      }
    }
  }
}

