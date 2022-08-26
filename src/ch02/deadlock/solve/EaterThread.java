package ch02.deadlock.solve;

class EaterThread extends Thread{

    String name;
    Pair pair;
    EaterThread(String name, Pair pair){
        this.name = name;
        this.pair = pair;
    }
    public void eat(){
        synchronized (pair){
            System.out.println(name + " 가 " + pair.leftTool + " 을 왼손에 쥐었습니다!");

            System.out.println(name + " 가 " + pair.rightTool + "을 오른손에 쥐었습니다!");
            System.out.println("    식사를 시작합니다!");

            System.out.println("    식사 완료!");
        }
    }
    @Override
    public void run() {
        while(true){
            eat();
        }
    }
}
