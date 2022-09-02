package ch04.test;

class Demo {
    public static void main(String[] args) {
//       new TestThread().start();
        TestThread thread = new TestThread();
        while(true){
            thread.start();
            //스레드 인스턴스 별 start 는 단 한번만 부를 수 있다.
       }
    }
}
