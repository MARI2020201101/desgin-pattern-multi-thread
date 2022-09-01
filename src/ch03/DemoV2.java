package ch03;

class DemoV2 {
    public static void main(String[] args) {
        RequestQueue input = new RequestQueue();
        RequestQueue output = new RequestQueue();
        input.putRequest(new Request("Hello"));
        new TalkThread(input, output, "Alice").start();
        new TalkThread(output, input, "Bob").start();

    }
}
