import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

    List<Bank> bank = new ArrayList<Bank>();

    String adminName = "admin", adminPassword = "123";
    Boolean menuquit = true;
    Boolean adminMenuquit = true;
    Boolean loginMenu = true;

    Scanner scannerM1 = new Scanner(System.in);
    Scanner scannerM2 = new Scanner(System.in);
    Scanner scannerM3 = new Scanner(System.in);
    Scanner scannerM4 = new Scanner(System.in);
    Scanner scannerM5 = new Scanner(System.in);
    Scanner scannerM6 = new Scanner(System.in);
    Scanner scannerM7 = new Scanner(System.in);
    Scanner scannerM8 = new Scanner(System.in);
    Scanner scannerM9 = new Scanner(System.in);
    Scanner scannerM10 = new Scanner(System.in);
    Scanner scannerM11 = new Scanner(System.in);


    do {
        MessagePrinter.BaseMenu();
        int menuChoose = scannerM1.nextInt();

        switch (menuChoose)
        {
            case 1:
                Boolean nameDuplicatCheck = false;
                String setName;

                do
                {
                    nameDuplicatCheck = false;
                    System.out.println("\nEnter name: ");
                    setName = scannerM2.nextLine();

                    for(Bank banks: bank)
                    {
                        if (banks.setName.equals(setName))
                        {
                            System.out.println("Name already exist - enter other name!");
                            nameDuplicatCheck = true;
                            break;
                        }
                    }
                }while (nameDuplicatCheck == true);

                System.out.println("Enter password: ");
                String setPassword = scannerM3.nextLine();

                Double balanceSettoZero = 0.0;
                Double CreditSettoZero = 0.0;
                bank.add(new Bank(balanceSettoZero, setName, setPassword, false, CreditSettoZero, false));
                System.out.println("\nBank Account Added!\n");

                break;

            case 2:
                if (bank.size() == 0)
                {
                    System.out.println("Bank don't have any accounts");
                    break;
                }
                System.out.print("\nEnter name: ");
                String nameCheck = scannerM4.nextLine();

                System.out.print("Enter password: ");
                String passwordCheck = scannerM5.nextLine();

                Boolean accountChecker = true;

                for (Integer ix = 0; ix < bank.size(); ix++)
                {
                    if ((bank.get(ix).setName.equals(nameCheck) ) && (bank.get(ix).setPassword.equals(passwordCheck) ) && (bank.get(ix).accountBlock == false))
                    {
                        bank.get(ix).userIsLogged = true;

                        accountChecker = false;

                        System.out.println("Account Found!\nName: " + bank.get(ix).setName + "\nBalance: \n" + bank.get(ix).balance);
                        loginMenu = true;
                        do
                        {
                            for (ix = 0; ix < bank.size(); ix++)
                            {
                                if ((bank.get(ix).setName.equals(nameCheck) ) && (bank.get(ix).setPassword.equals(passwordCheck) ))
                                {
                                    System.out.println("\nName: " + bank.get(ix).setName + "\nBalance: \n" + bank.get(ix).balance);
                                }
                            }
                            MessagePrinter.UserMenu();
                            int loginMenuChoose = scannerM6.nextInt();

                            System.out.println("\n");

                            switch (loginMenuChoose)
                            {
                                case 1:
                                {
                                    int accNumBasic = 0;
                                    int accNum = -1;
                                    bank.get(accNumBasic).ListShuffelPlusDeposit(bank, nameCheck, accNum);
                                }
                                break;

                                case 2:
                                {
                                    int accNumBasic = 0;
                                    int accNum = -1;
                                    bank.get(accNumBasic).ListShuffelPlusWithdraw(bank, nameCheck, accNum);
                                }
                                break;

                                case 3:
                                {
                                    int accNumBasic = 0;
                                    int accNum = -1;
                                    bank.get(accNumBasic).ListShuffelPlusBalanceGet(bank, nameCheck, accNum);
                                }
                                break;

                                case 4:
                                {
                                    int accNumBasic = 0;
                                    int accNum = -1;
                                    bank.get(accNumBasic).ListShuffelPlusHistory(bank, nameCheck, accNum);
                                }
                                break;

                                case 5:
                                {
                                    int accNumBasic = 0;
                                    int accNum = -1;
                                    bank.get(accNumBasic).ListShuffelPlusTransferToOtherPerson(bank, nameCheck, accNum);
                                }
                                break;

                                case 6:
                                {
                                    int accNumBasic = 0;
                                    int accNum = -1;
                                    bank.get(accNumBasic).ListShuffelPlusCreditTake(bank, nameCheck, accNum);
                                }
                                break;

                                case 7:
                                    {
                                        int accNumBasic = 0;
                                        int accNum = -1;
                                        bank.get(accNumBasic).ListShuffelPlusCreditPayment(bank, nameCheck, accNum);
                                    }
                                    break;

                                case 8:
                                    {
                                        int accNumBasic = 0;
                                        int accNum = -1;
                                        bank.get(accNumBasic).ListShuffelPlusLogOut(bank, nameCheck, accNum);
                                        loginMenu = false;
                                    }
                                    break;
                            }
                        } while (loginMenu == true);
                    }
                    else if ((bank.get(ix).setName.equals(nameCheck)) && (bank.get(ix).setPassword.equals(passwordCheck)) && (bank.get(ix).accountBlock == true))
                    {
                        System.out.println("Account is blocked!");
                        accountChecker = false;
                    }
                }
                if(accountChecker == true)
                {
                    System.out.println("Account is not found or name/password is wrong!");
                }
                accountChecker = false;
                break;

            case 3:
                System.out.print("Enter Admin name: ");
                String adminNameCheck = scannerM7.nextLine();
                System.out.print("Enter Admin password: ");
                String adminPasswordCheck = scannerM8.nextLine();;

                for(Bank accounts : bank)
                {
                if (accounts.userIsLogged == true)
                {
                    System.out.println("You are logged as user, you must log out from user to log in as admin");
                    break;
                }
            }
            if (adminNameCheck.equals(adminName)  && adminPasswordCheck.equals(adminPassword))
            {
                adminMenuquit = true;
                do
                {
                    MessagePrinter.AdminMenu();
                    int adminChoose = scannerM9.nextInt();

                    switch (adminChoose)
                    {
                        case 1:
                        {
                            if (bank.size() == 0)
                            {
                                System.out.println("\nNo accounts to lock.\n");
                                break;
                            }

                            System.out.println("Lock account(insert account name): ");
                            String userNameToLock = scannerM10.nextLine();
                            if (bank.size() > 0)
                            {
                                int accNum = -1;
                                for (int ix = 0; ix < bank.size(); ix++)
                                {
                                    if (bank.get(ix).setName.equals(userNameToLock))
                                    {
                                        accNum = ix;
                                    }
                                }
                                if (accNum != -1)
                                {
                                    if (bank.get(accNum).accountBlock == true)
                                    {
                                        System.out.print("\nAccount (" + userNameToLock +") - is already locked\n");
                                        break;
                                    }

                                    bank.get(accNum).accountBlock = true;
                                    System.out.print("\nAccount (" + userNameToLock + ") - has been locked\n");
                                }
                                else
                                {
                                    System.out.print("\nAccount not found.\n");
                                }
                            }
                        }
                        break;

                        case 2:
                        {
                            if (bank.size() == 0)
                            {
                                System.out.print("\nNo accounts to Unlock.\n");
                                break;
                            }

                            System.out.print("Unlock account(insert account name): ");
                            String userNameToUnLock = scannerM11.nextLine();
                            if (bank.size() > 0)
                            {
                                int accNum = -1;
                                for (int ix = 0; ix < bank.size(); ix++)
                                {
                                    if (bank.get(ix).setName.equals(userNameToUnLock))
                                    {
                                        accNum = ix;
                                    }
                                }

                                if (accNum != -1)
                                {
                                    if (bank.get(accNum).accountBlock == false)
                                    {
                                        System.out.print("\nAccount is not blocked.\n");
                                        break;
                                    }
                                    bank.get(accNum).accountBlock = false;
                                    System.out.print("Account ("+ userNameToUnLock +") - has been unlocked\n");
                                }
                                else
                                {
                                    System.out.print("\nAccount not found.\n");
                                }
                            }
                        }
                        break;

                        case 3:
                        {
                            int x = 1;
                            for(Bank banks : bank)
                            {
                                System.out.print(x);
                                x++;
                                System.out.println(banks.toString());
                            }
                        }

                        break;

                        case 4:
                        {
                            adminMenuquit = false;
                        }
                        break;
                    }
                } while (adminMenuquit == true);
            }
            else
            {
                System.out.println("\nWrong admin name or password!\n");
            }
            break;

            case 4:
                menuquit = false;
                break;
        }
    } while (menuquit == true);
}
}
