/* Name:Aiden Russo
Date:11/2/22
Description: In this program we made a simple number guessing game
Grade: I bieleve I should get a 90% on this lab, I did all the requirements but It's is being turned in lat

Sorry that this being turned in so late, I had a pretty long week last week and forgot to do a lot of school work.

*/

import java.util.*;
public class GameRusso
{
   
   public static void main(String[] args) {
      Scanner kb = new Scanner(System.in);
      interact(kb);
      action(kb);
   }
   
   
     /* 
     The purpose for this method is to ask the user to enter a positive integer value
     This method gets two paramters Scanner and a string. The string s holds the message being displayed for the user
      This method asks the user to enter a positive number. 
      As long as the entered value is not positive, the method will keep asking the user
      
      */  
   public static int prompt(Scanner kb, String s) 
   {
      int input;
        
       System.out.println(s);
        
		input = kb.nextInt();
		kb.nextLine();
       
       
       while(input < 0)
      {
		  System.out.println("Your input is not valid");
          System.out.println(s);
          input = kb.nextInt();
		  kb.nextLine();
      }
      return input;
   }
   
   /* This method displays the intro given in the sample output. It must match excatly with the sample output. Refer to the provided
   output
   */
   public static void interact(Scanner kb)
   {
		System.out.println("Hello, I am a computer playing a guessing game with you. What would you like to call me?" );
		String myName = kb.nextLine();
		System.out.println("Wow I really like the name " + myName);
		System.out.println("What is your name: ");
		String urName = kb.nextLine();
		System.out.println("Hey " + urName + " I am excited to play the guessing game with you");
		System.out.println("I will think of a number between a low  and a high values enerted by you\nand will allow you to guess until you get it.\nFor each guess, I will give you a hint whether the\nright answer is higher or lower than your guess.");
		System.out.println("---------------------------------------------------------------------------------");
   }
    /* this method gets two numbers called guess and randNum
    if guess is greater than randNum then return "Lower"
    else if guess is less than randNum return "Higher"
    else return match*/
    
   public static String match(int guess, int randNum) 
   {
	   if(guess > randNum) {
		   return "lower";
	   }
	   else if(guess < randNum) {
		   return "Higher";
	   }
	   else {
		return "match"; 
	   }
   }
/*
  this method displays the result on the screen. 
  This method gets two parameters representing the number of the games the person played and the total guesses 
  made for all the games played
*/
   public static void report(int numGames, int totGuesses) 
   {
	   System.out.println("Total games = " +numGames);
	   System.out.println("You got it right in " + totGuesses + " guesses");

   }
   
   
   /*This method plays the game. it will generate a random number between min and max.
     asks the user to guess the number generated by the computer. As long as the user is not making the correct guess
     will keep propmting the user. Once the user makes a correct guess, it will end the game
     Also it keeps track of the number of the guesses that the user has made. 
     Return: This method returns the number of the guesses the person made 
     Refer to the sample output
     
     
    */ 
   public static int funGame(Scanner kb, int min, int max) 
   {
       Random random = new Random();
        int compPick = random.nextInt(max - min + 1) + min;
        int userGuess = 0;
         int guesses = 0;
         System.out.println("I'm thinking of a number between " + min + " and " + max + " ...");
        System.out.println("Give me a few seconds then enter any key to strat the game");
	   while(userGuess != compPick) 
      {
         guesses += 1;
             System.out.println("guess?");
             userGuess = kb.nextInt();
             String result = match(userGuess, compPick);
         if(result.equals("match"))
		 {
			 System.out.println("*******Congratulations!*******");
			 System.out.println("You got it in " + guesses);
         }
			   else{
				   System.out.println(result);
			   }
      System.out.println();
      return guesses;
   }
   public static void action(Scanner kb)  
   {      
      int numGames = 0;
      int totGuesses = 0; 
      int min = 0;
      int max = 0 ;
      String repeat = "yes";           
      while (repeat.equalsIgnoreCase("yes")) {
         String s = "Enter a low value :";
         String s1 = "Enter the high value:";
         min = prompt(kb, s);
          max = prompt(kb, s1);
		 while(max < min)
         {
            System.out.println("You entered an invalid value for max. Max must be greater than min. lets start all over again\n");
            min = prompt(kb, s);
           max = prompt(kb, s1);
         }
           int gusses = funGame(kb, min, max);
          totGuesses += gusses;
         numGames += 1;
         System.out.println("Would you like to play again?");
         repeat = kb.next();
      }
       report(numGames, totGuesses);
   }

}
