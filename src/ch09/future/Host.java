package ch09.future;

class Host {
    public Data request(final int count ,final char c){
        System.out.println("request Count. " + count +  " , [ "+ c +  " ] Begin ");
        final FutureData future = new FutureData();
        new Thread(()->{
            final RealData realData = new RealData(count, c);
            future.setContent(realData);
        }).start();
        return future;
    }
}
