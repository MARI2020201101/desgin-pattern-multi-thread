package ch02.deadlock;

class EaterThread extends Thread{

    String name;
    Tool leftTool;
    Tool rightTool;
    EaterThread(String name, Tool leftTool, Tool rightTool){
        this.name = name;
        this.leftTool = leftTool;
        this.rightTool = rightTool;
    }
    public void eat(){
        synchronized (leftTool){
            System.out.println(name + " 가 " + leftTool + " 을 왼손에 쥐었습니다!");
            synchronized (rightTool){
                System.out.println(name + " 가 " + rightTool + "을 오른손에 쥐었습니다!");
                System.out.println("    식사를 시작합니다!");
            }
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
