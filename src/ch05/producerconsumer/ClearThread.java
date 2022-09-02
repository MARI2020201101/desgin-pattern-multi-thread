package ch05.producerconsumer;

class ClearThread extends Thread{
    private final Table table;
    public ClearThread(String name, Table table){
        super(name);
        this.table=table;
    }

    @Override
    public void run() {
        try {
            while(true){
                Thread.sleep(200);
                System.out.println(" ### "+ getName() + " cleared Table ### ");
                table.clear();
            }
        } catch (InterruptedException e) {
            e.printStackTrace(); //interrupt 를 받으면 예외스택트레이스를 print한 후 스레드 자동종료된다.
        }
    }
}
