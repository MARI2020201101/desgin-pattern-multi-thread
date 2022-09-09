package ch12.activeobject;

abstract class MethodRequest {
    protected final Servant servant;
    protected final FutureResult future;

    public MethodRequest(Servant servant, FutureResult future) {
        this.servant = servant;
        this.future = future;
    }

    abstract void execute();
}

class DisplayRequest extends MethodRequest{
    private final String str;

    DisplayRequest(Servant servant, String str) {
        super(servant , null);
        this.str =str;
    }
    @Override
    void execute() {
        servant.displayString(str);
    }
}

class MakeStringRequest extends MethodRequest{
    private final int count;
    private final char c;

    public MakeStringRequest(Servant servant, int count, char c, FutureResult futureResult) {
        super(servant, futureResult);
        this.count = count;
        this.c = c;
    }

    @Override
    void execute() {
        Result result = servant.makeString(count, c);
        future.setResult(result);
    }
}
