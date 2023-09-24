package Behavioral.Command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionManger {

    Map<Integer,Customer> customerMap = new HashMap<>();
    Map<Integer, List<Transaction>> transactionsPerUser;

    public TransactionManger() {
        transactionsPerUser = new HashMap<>();
    }

    public int addCustomer(String name) {
        Customer customer = new Customer(name);
        int code = customer.getCode();
        customerMap.put(code,customer);
        transactionsPerUser.put(code,new ArrayList<>());
        return code;
    }

    public void performTransaction(int code1, int amount, String type) {
        Customer customer = customerMap.get(code1);
        if(customer==null) {
            //raise exception
            throw new RuntimeException("No user with code " + code1 + " found");
        }
        List<Transaction> list = transactionsPerUser.get(code1);
        list.add(new Transaction(amount, type));
        if(type.equals("sale")) {
            customer.addSalePrice(amount);
        }else if(type.equals("receipt")) {
            customer.addReceipt(amount);
        }else {
            //invalid transaction type; raise exception
        }
    }

    public String getName(int code) {
        return customerMap.get(code).getName();
    }

    public int getBalance(int code) {
        customerMap.get(code).getBalance();
        return 0;
    }

    public void printTransaction(int code) {
        List<Transaction> transactions = transactionsPerUser.get(code);
        for (Transaction t:transactions){
            System.out.println("Amount :" + t.getAmount()+"  "+"of type :"+ t.getType());
        }
    }

    public void  undoTransaction(int code) {
        List<Transaction> transactions = transactionsPerUser.get(code);
        if(transactions.size()>0) {
            int size = transactions.size();
            Transaction transaction = transactions.remove(size-1);
            Customer customer = customerMap.get(code);
            if(transaction.getType().equals("sale")) {
                customer.addSalePrice(-transaction.getAmount());
            }else if(transaction.getType().equals("receipt")) {
                customer.addReceipt(-transaction.getAmount());
                customer.getBalance();
            }else {
                //invalid transaction type; raise exception
            }
        }else {
            //No transaction found
        }
    }
}
