import java.time.LocalDateTime;
import java.util.*;

public class Bank extends account
    {
        //Pola klasy
        public Boolean accountBlock = false;
        public Bank(Double balance, String setName, String setPassword, Boolean accountBlock, Double credit, Boolean creditCheck)
        {
            super(balance, setName, setPassword, credit, creditCheck);
            this.accountBlock = accountBlock;
        }

        public void ListShuffelPlusCreditPayment(List<Bank> bank, String nameCheck, int accNum)
        {
            for (Integer ix = 0; ix < bank.size(); ix++)
            {
                if (bank.get(ix).setName.equals(nameCheck))
                {
                    accNum = ix;
                }
            }
            if (accNum != -1)
            {
                bank.get(accNum).creditpayment();
            }
        }
        public void ListShuffelPlusLogOut(List<Bank> bank, String nameCheck, int accNum)
        {
                for (Integer ix = 0; ix < bank.size(); ix++)
                {
                    if (bank.get(ix).setName.equals(nameCheck))
                    {
                        accNum = ix;
                    }
                }
                if (accNum != -1)
                {
                    bank.get(accNum).userIsLogged = false;
                }
        }

        public void ListShuffelPlusCreditTake(List<Bank> bank, String nameCheck, int accNum)
        {
            for (Integer ix = 0; ix < bank.size(); ix++)
            {
                if (bank.get(ix).setName.equals(nameCheck))
                {
                    accNum = ix;
                }
            }
            if (accNum != -1)
            {
                bank.get(accNum).credit();
            }
        }

        public void ListShuffelPlusHistory(List<Bank> bank, String nameCheck, int accNum)
        {
            for (Integer ix = 0; ix < bank.size(); ix++)
            {
                if (bank.get(ix).setName.equals(nameCheck))
                {
                    accNum = ix;
                }
            }
            if (accNum != -1)
            {
                bank.get(accNum).history();
            }
        }

        public void ListShuffelPlusBalanceGet(List<Bank> bank, String nameCheck, int accNum)
        {
            for (Integer ix = 0; ix < bank.size(); ix++)
            {
                if (bank.get(ix).setName.equals(nameCheck))
                {
                    accNum = ix;
                }
            }
            if (accNum != -1)
            {
                System.out.println("Balance: " + bank.get(accNum).balance);
            }
        }

        public void ListShuffelPlusWithdraw(List<Bank> bank, String nameCheck, int accNum)
        {for (Integer ix = 0; ix < bank.size(); ix++)
        {
            if (bank.get(ix).setName.equals(nameCheck))
            {
                accNum = ix;
            }
        }
            if (accNum != -1)
            {
                bank.get(accNum).withdraw();
            }
            else
            {
                System.out.println("Insufficient funds!");
            }
        }

        public void ListShuffelPlusDeposit(List<Bank> bank, String nameCheck, int accNum)
        {
            for (Integer ix = 0; ix < bank.size(); ix++)
            {
                if (bank.get(ix).setName.equals(nameCheck))
                {
                    accNum = ix;
                }
            }
            if (accNum != -1)
            {
                bank.get(accNum).deposit();
            }
            else
            {
                System.out.println("Account not found!");
            }
        }

        public void ListShuffelPlusTransferToOtherPerson(List<Bank> bank, String nameCheck, int accNum)
        {
            for (int ix = 0; ix < bank.size(); ix++)
            {
                if (bank.get(ix).setName.equals(nameCheck))
                {
                    accNum = ix;
                }
            }
            if (accNum != -1)
            {
                LocalDateTime dateTime = LocalDateTime.now();

                Boolean userTransferNameCheck = false;

                do
                {
                    bank.get(accNum).setRecipientName();

                    for (int ixUser = 0; ixUser < bank.size(); ixUser++)
                    {
                        if (bank.get(ixUser).setName.equals(bank.get(accNum).userNameToTransfer))
                        {
                            userTransferNameCheck = true;
                        }
                    }
                    if(userTransferNameCheck == false)
                    {
                        System.out.println("Account with that name don't exist! Enter other account name. ");
                        return;
                    }
                    else if(bank.get(accNum).setName.equals(bank.get(accNum).userNameToTransfer))
                    {
                        System.out.println("You can't transfer money to Yourself! Enter other account name.");
                        userTransferNameCheck = false;
                        return;
                    }
                } while (userTransferNameCheck == false);


                bank.get(accNum).transferToOtherUser();

                if (bank.get(accNum).transferAction == true)
                {
                    int accUserNum = -1;
                    for (int ixUser = 0; ixUser < bank.size(); ixUser++)
                    {
                        if (bank.get(ixUser).setName.equals(bank.get(accNum).userNameToTransfer))
                        {
                            accUserNum = ixUser;
                        }
                    }
                    if (accUserNum != -1)
                    {
                        bank.get(accUserNum).balance += bank.get(accNum).transferAmount;


                        LocalDateTime dateTime1 = LocalDateTime.now();

                        bank.get(accUserNum).DepositHistory.add(bank.get(accNum).transferAmount);
                        bank.get(accUserNum).DateDepositHistory.add(dateTime1);

                        bank.get(accNum).transferAction = false;
                    }
                }
            }
        }

        public  String toString()
        {
            return ". Name: " + setName + ", Password: "+ setPassword + ", Balance: " + balance + ", Account Block(true=blocked): " + accountBlock + ", Credit(true=the credit has been taken): " + creditCheck;
        }
    }

