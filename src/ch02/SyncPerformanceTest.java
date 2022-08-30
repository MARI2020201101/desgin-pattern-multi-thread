package ch02;

class SyncPerformanceTest {
    public static void main(String[] args) {
        trial("Not Sync", 1000000000L, new NotSync());
        trial("Sync", 1000000000L , new Sync()); //54배 걸렸음 ㅋㅋㅋㅋㅋㅋㅋ
    }
    private static void trial(String msg, long count, Object obj){
        System.out.println(msg + " 시작!");
        long start= System.currentTimeMillis();
        for(int i = 0; i < count ; i++){
            obj.toString();
        }
        System.out.println(msg + " 종료!");
        long end = System.currentTimeMillis();
        System.out.println("소요 시간 : "+ (end - start));
    }
}
class NotSync{
    private final String name = "NotSync";
    @Override
    public String toString() {
        return name;
    }

}
class Sync {
    private final String name = "Sync";

    @Override
    public synchronized String toString() {
        return name;
    }
}