 public class MessagePrinter {
     static public void UserMenu()
     {
         System.out.println("Press 1. To deposit: \nPress 2. To withdraw: \nPress 3. To check balance.\n" +
                 "Press 4. To check transaction history.\nPress 5. To make transfer to other user " +
                 "\nPress 6. To take credit.\nPress 7. To repay credit\nPress 8. To log out and quit to main menu");
     }
     static public void AdminMenu()
     {
         System.out.println("\nYou are in Admin Menu!\n\nPress 1. To lock user account\n" +
                 "Press 2. To unlock user accountn\nPress 3. To print all bank accounts\nPress 4. To quit.");
     }
     static public void BaseMenu()
     {
         System.out.println("Press 1. To create account. \nPress 2. To log in as user. \nPress 3. To log in as admin. \nPress 4. To quit.\n");
         System.out.print("Select function: ");
     }
 }
