package ch04.guardedtime;

class Demo {
    public static void main(String[] args) {
        Host host = new Host(5000);
        try{
            System.out.println("execute Begin");
            host.execute();
//            host.setExecutable(true);
        }catch (TimeoutException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
