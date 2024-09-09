
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;
class BankAccount {
    AccountPersonalDetails accDet=new AccountPersonalDetails();
    Vector<String> allAccNum = new Vector<String>();
    Map<String,AccountPersonalDetails> allAccDet=new HashMap<String,AccountPersonalDetails>();
    
    public BankAccount(){
        super();
    }
    void createAccount(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter name : ");
        accDet.name=sc.nextLine();
        System.out.println("Enter mobile number : ");
        accDet.mobile=sc.nextLine();
        System.out.println("Enter adhar number : ");
        accDet.adhar=sc.nextLine();
        System.out.print("Enter house number : ");
        accDet.address[0]=sc.nextLine();
        System.out.println("Enter village : ");
        accDet.address[1]=sc.nextLine();
        System.out.println("Enter district : ");
        accDet.address[2]=sc.nextLine();
        System.out.println("Enter state : ");
        accDet.address[3]=sc.nextLine();
        System.out.println("Enter pincode : ");
        accDet.address[4]=sc.nextLine();
        accDet.accountNumber = newAccountNumber();
        System.out.println("your account number : "+accDet.accountNumber);
        storeAccDetails();
    }

     String newAccountNumber() {
        String accNum=(allAccNum.size()+1)+"";
        int accNumLength=accNum.length();
        for(int i=0;i<5-accNumLength;i++){
            accNum="0"+accNum;
        }
        return new SimpleDateFormat("yyyyMMddhhmmss").format(new Date())+ accNum;
    }

    private void storeAccDetails() {
        allAccNum.add(accDet.accountNumber);
        allAccDet.put(accDet.accountNumber,accDet);
//        System.out.println("map "+allAccDet.get(accDet.accountNumber).name);
        

    }

    void showAccountDetails(String accountNumber) {
        AccountPersonalDetails accDet1 = allAccDet.get(accountNumber);
        System.out.println("Account details of account number "+accountNumber+" are");
        System.out.println("NAME : "+accDet1.name);
        System.out.println("MOBILE NUMBER : "+accDet1.mobile);
        System.out.println("AADHAR NUMBER : "+accDet1.adhar);
        System.out.println("H.No : "+accDet1.address[0]);
        System.out.println("VILLAGE : "+accDet1.address[1]);
        System.out.println("DISTRICT : "+accDet1.address[2]);
        System.out.println("STATE : "+accDet1.address[3]);
        System.out.println("PINCODE : "+accDet1.address[4]);
    }

    void displayBalance(String accountNumber) {
        AccountPersonalDetails accDet1 = allAccDet.get(accountNumber);
        System.out.println("balance in "+accountNumber+" is :"+accDet1.amount);
    }

    void depositAmount(String accountNumber,int amount) {
        AccountPersonalDetails accDet1 = allAccDet.get(accountNumber);
        accDet1.amount+=amount;
    }

    void withdrawAmount(String accountNumber,int amount) {
        AccountPersonalDetails accDet1 = allAccDet.get(accountNumber);
        if(accDet1.amount>=amount){
            accDet1.amount-=amount;
        }else
        System.out.println("Insufficient Funds");
    }

    void showTransactionDetails(String accountNumber) {
    }

}
class runBank {
    public static void main(String a[]) {
        BankAccount custDet = new BankAccount();
        Scanner sc = new Scanner(System.in);
        int proceed;
        String accountNumber;
        int amount;
        while (true) {
            System.out.println("press");
            System.out.println("1 : To create account");
            System.out.println("2 : To view account holder details");
            System.out.println("3 : To check balance");
            System.out.println("4 : To deposit account");
            System.out.println("5 : To withdraw account");
                        proceed = sc.nextInt();

            System.out.println("*** Enter account number *** : ");
//            why the below line is not executing
            accountNumber =sc.nextLine();
            switch (proceed) {
            case 1:
                custDet.createAccount();
                break;
            case 2:
                 accountNumber = sc.nextLine();
//                System.out.println("obj val"+custDet);r
                custDet.showAccountDetails(accountNumber);
                break;
            case 3:
                accountNumber = sc.nextLine();
                custDet.displayBalance(accountNumber);
                break;
            case 4:
                accountNumber = sc.nextLine();
                System.out.println("Enter amount to deposit : ");
                 amount=sc.nextInt();
                custDet.depositAmount(accountNumber,amount);
                break;
            case 5:
                accountNumber = sc.nextLine();
                System.out.println("Enter amount to withdraw : ");
                 amount=sc.nextInt();
                custDet.withdrawAmount(accountNumber,amount);
                break;
            }
            System.out.println("Enter \n 1 : to continue \n 0(zero):to exit");
            if(sc.nextInt()==0){
                break;
            }
        }
        

    }
}
class AccountPersonalDetails {
    String name;
    String mobile;
    String adhar;
    String accountNumber;
    String[] address=new String[5];
    long amount=0;
    public AccountPersonalDetails() {
        super();
        
    }
}
