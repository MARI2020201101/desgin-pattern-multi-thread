package ch01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class BankThreadTest {
    public static void main(String[] args) {
        Bank bank = new Bank(10, "월급통장");
        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.execute(()-> {
            boolean isOk = bank.withDraw(10);
            while(isOk) {
                bank.deposit(10);
                isOk = bank.withDraw(10);
            }
            System.out.println("2 종료 ");
        });
        executor.shutdown();

        try{
            Thread.sleep(500000);
        }catch (Exception e){}
        System.out.println("Main 종료 ");
    }
}
class Bank{
     private int money;
     private String name;
     public Bank(int money, String name){
         this.money = money;
         this.name = name;
     }
     public void deposit(int m){
         money+= m ;
     }
     public boolean withDraw(int m){
         if(money >= m){
             money-=m;
             check();
             return true;
         }
         return false;
     }

    private void check() {
        if(money < 0){
            throw new RuntimeException("돈이없다....");
        }
    }
}