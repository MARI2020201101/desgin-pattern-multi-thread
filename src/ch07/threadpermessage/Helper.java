package ch07.threadpermessage;

class Helper {
    public void handle(int count, char c){
        System.out.println("Helper " + count + " handle Begin");
        for (int i = 0; i < count; i++) {
            System.out.print(c);
            slowy();
        }
        System.out.println();
        System.out.println("Helper " + count + " handle End");
    }

    private void slowy() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
