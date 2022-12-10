
    public class Bank extends account
    {
        //Pola klasy
        public Boolean accountBlock = false;
        public Bank(Double balance, String setName, String setPassword, Boolean accountBlock, Double credit, Boolean creditCheck)
        {
            super(balance, setName, setPassword, credit, creditCheck);
            this.accountBlock = accountBlock;
        }

        public  String toString()
        {
            return ". Name: " + setName + ", Password: "+ setPassword + ", Balance: " + balance + ", Account Block(true=blocked): " + accountBlock + ", Credit(true=the credit has been taken): " + creditCheck;
        }
    }

