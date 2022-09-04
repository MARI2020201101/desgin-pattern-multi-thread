package ch09.networkfuture;

class Retriever {
    public static Content retrieve(String urlStr){
        return new SyncContent(urlStr);
    }
}
