package ch03.v2;

class Request {
    private final String message;

    Request(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return " "+message+" ";
    }
}
