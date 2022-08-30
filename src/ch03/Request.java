package ch03;

class Request {
    private final String message;

    Request(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Request{" +
                "message='" + message + '\'' +
                '}';
    }
}
