package ch01.mutex;

class Gate {
    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

    public void pass(String name, String address){
        this.counter++;
        this.name = name;
        this.address = address;
        check();
    }

    private void check() {
        System.out.println("counter => " + counter + " , name => "+ name + " ,  address => "+ address);
        if(name.charAt(0) != address.charAt(0)){
            System.out.println("***** Broken State *****");
        }
    }
}
