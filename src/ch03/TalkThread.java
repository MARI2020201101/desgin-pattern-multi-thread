package ch03;

class TalkThread extends Thread{
    private RequestQueue input;
    private RequestQueue output;
    TalkThread(RequestQueue input, RequestQueue output, String name){
        super(name);
        this.input = input;
        this.output = output;
    }
    private String getThreadName(){
        return Thread.currentThread().getName();
    }
    @Override
    public void run() {
        System.out.println(getThreadName() + " Begin");
        for (int i = 0; i < 20; i++) {
            Request request1 = input.getRequest();
            System.out.println(getThreadName() + " gets " + request1);
            Request request2 = new Request(request1.getMessage() + "!");
            System.out.println(getThreadName() + " puts " + request2);
            output.putRequest(request2);
        }
        System.out.println(getThreadName() + " End");
    }
}
