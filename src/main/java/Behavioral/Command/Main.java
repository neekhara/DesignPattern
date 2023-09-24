package Behavioral.Command;

public class Main {
    public static void main(String[] args) {
        Customer c1 = new Customer("Ajay");
        c1.addSalePrice(1000);
        c1.addReceipt(2000);
        c1.getBalance();

        // In above class we can't get the history of transaction

        TransactionManger tm = new TransactionManger();
        int code1 = tm.addCustomer("Ramesh");
        int code2 = tm.addCustomer("Suresh");
        tm.performTransaction(code1,1000,"sale"); //we are issuing a command perform transaction  (sale is command)
        tm.performTransaction(code1,1500,"sale");
        tm.performTransaction(code1,4500,"receipt");
        System.out.println("code : " + code1);
        System.out.println("Name :" + tm.getName(code1));
        tm.getBalance(code1);
        tm.printTransaction(code1);
        tm.performTransaction(code2,6000,"sale");
        tm.performTransaction(code2,90000,"sale");
        tm.performTransaction(code2,5000,"receipt");
        tm.performTransaction(code2,3000,"sale");
        tm.performTransaction(code2,50000,"receipt");
        System.out.println("code : " + code2);
        System.out.println("Name :" + tm.getName(code2));
        tm.getBalance(code2);
        tm.printTransaction(code2);
        tm.undoTransaction(code2);
        tm.undoTransaction(code2);
        System.out.println("transactions list after undoing last 2 transactions");
        System.out.println("code : " + code2);
        System.out.println("Name :" + tm.getName(code2));
        tm.getBalance(code2);
        tm.printTransaction(code2);
    }
}
