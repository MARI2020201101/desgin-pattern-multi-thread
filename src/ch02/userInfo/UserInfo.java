package ch02.userInfo;
class Demo{
    public static void main(String[] args) {
        UserInfo alice = new UserInfo("Alice", "London");
        StringBuffer info = alice.getInfo();
        System.out.println(alice);
        info.append("bbbbbbb");
        System.out.println(alice);
        info.replace(0,5,"Bob");
        System.out.println(alice);

    }
}
class UserInfo {
    private final StringBuffer info;
    public UserInfo(String name, String address){
        this.info = new StringBuffer(name);
        info.append(" , ");
        info.append(address);
    }
    public StringBuffer getInfo(){
        return info;
    }

    @Override
    public String toString() {
        return info.toString();
    }
}
