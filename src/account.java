import java.util.*;
import java.time.LocalDateTime;
public class account {
        public List<Double> DepositHistory = new ArrayList<Double>();

        public List<LocalDateTime> DateDepositHistory = new ArrayList<LocalDateTime>();

        public Double balance, credit;
        public String setName, setPassword;
        public Boolean creditCheck = false;

        public String userNameToTransfer;
        public Double transferAmount;

        public Boolean userIsLogged = false;
        public Boolean transferAction = false;

        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        Scanner scanner4 = new Scanner(System.in);
        Scanner scanner5 = new Scanner(System.in);
        Scanner scanner6 = new Scanner(System.in);



        public account(Double balance, String setName, String setPassword, Double Credit, Boolean creditCheck)
        {
            this.balance = 0.0;
            this.setName = setName;
            this.setPassword = setPassword;
            this.credit = 0.0;
            this.creditCheck = creditCheck;
        }
        public void deposit()
        {
            System.out.print("Enter amount to Deposit: \n");
            Double transactionHistoryPlus = scanner.nextDouble();

            if (transactionHistoryPlus > 0.0)
            {
                LocalDateTime dateTime = LocalDateTime.now();


                this.balance += transactionHistoryPlus;
                DepositHistory.add(transactionHistoryPlus);
                DateDepositHistory.add(dateTime);
                System.out.println("Amount successfully deposited!\n");
            }
            else
            {
                System.out.println("Invalid amount - You can't deposit 0 or less then 0");
            }
        }
        public void withdraw()
        {
            System.out.print("Enter amount to withdraw: \n");

            double transactionHistoryMinus = scanner2.nextDouble();
            if (transactionHistoryMinus <= 0)
            {
                System.out.println("You can't withdraw minus or 0 value");
            }
            else
            {
                if (this.balance >= transactionHistoryMinus)
                {
                    this.balance -= transactionHistoryMinus;
                    DepositHistory.add(transactionHistoryMinus * -1);


                    LocalDateTime dateTime = LocalDateTime.now();

                    DateDepositHistory.add(dateTime);
                    System.out.println("Amount successfully withdrawn!");
                }
                else
                {
                    System.out.println("Not enough funds to withdraw!\n");
                }
            }
        }
        public void showBalanceAmount()
        {
            System.out.println(balance);
        }
        public void history()
        {
            for (int x = 0; x < DepositHistory.size() || x < DateDepositHistory.size(); x++)
            {
                if (DepositHistory.get(x) < 0)
                {
                    System.out.println("In day: " + DateDepositHistory.get(x)
                            + ". Withdraw amount: " + DepositHistory.get(x));
                }
                else
                {
                    System.out.println("In day: " + DateDepositHistory.get(x)
                            + ". Account credited with: " + DepositHistory.get(x));
                }
            }

            System.out.println("Present balance: " + balance);
            System.out.println(" ");
        }
        public double credit() //User can take only ONE credit!
        {
            if (creditCheck == false)
            {
                System.out.println("You can take only one credit! \n");
                System.out.println("Credit amount: ");
                double Creditamount = scanner3.nextDouble();

                DepositHistory.add(Creditamount);

                LocalDateTime dateTime = LocalDateTime.now();

                DateDepositHistory.add(dateTime);

                credit = Creditamount;
                this.balance = this.balance + Creditamount;

                if (Creditamount > 0)
                {
                    creditCheck = true;
                }
            }
            else
            {
                System.out.println("You can't take another credit. The bank only allows take 1 credit.");
            }

            return 0;
        }
        public double creditpayment()
        {
            if (credit > 0)
            {
                System.out.println("The credit taken: " + credit);
                System.out.println("Enter credit repay amount:");
                double DepositAmt = scanner4.nextDouble();

                if (balance >= DepositAmt)
                {
                    DepositHistory.add(DepositAmt * -1);

                    LocalDateTime dateTime = LocalDateTime.now();

                    DateDepositHistory.add(dateTime);

                    credit = credit - DepositAmt;
                    this.balance = this.balance - DepositAmt;
                    return credit;
                }
                else
                    System.out.println("Not enough founds!");
            }
            else
                System.out.println("You don't have any credit.");
            return 0;
        }

        public void setRecipientName()
        {
            System.out.print("\nEnter recipient's name:");
            this.userNameToTransfer = scanner5.nextLine();
        }
        public void transferToOtherUser()
        {
            System.out.print("Enter Amount: ");
            this.transferAmount = scanner5.nextDouble();

            if (this.transferAmount <= 0)
            {
                System.out.print("You can't send 0 or less value!");
                return;
            }
            else if (this.transferAmount > this.balance)
            {
                System.out.print("Not enough founds!");
                return;
            }
            else
            {
                this.balance = this.balance - this.transferAmount;

                DepositHistory.add(transferAmount * -1);
                LocalDateTime dateTime = LocalDateTime.now();
                DateDepositHistory.add(dateTime);
                transferAction = true;
            }
        }

    public  String  toString()
    {
        return " ";
    }
}
