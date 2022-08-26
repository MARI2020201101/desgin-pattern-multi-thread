package ch03;

class StringTest {
    public static void main(String[] args) {
        String str = "ABC";
        String str2 = str.replace('A', 'W');
        System.out.println(str == str2);

    }
}
