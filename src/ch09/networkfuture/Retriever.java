package ch09.networkfuture;

class Retriever {
    public static Content retrieve(String urlStr){
        final AsyncContent future = new AsyncContent();
        new Thread(()->future.setContent(new SyncContent(urlStr))).start();
        return future;
    }
}
