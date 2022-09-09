package ch10.practice;

import java.util.function.Predicate;

class Demo {
    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c', 'd'};
        //bba를 찾는다
        calculate(chars, 3, i -> i[0]==1 && i[1]==1 && i[2] == 0);
    }
    static void calculate(char[] a, int k, Predicate<int []> decider){
        int n = a.length;
        if(k < 1 || k > n) throw new IllegalArgumentException("Forbidden");

        int[] indexes = new int[n];
        int total =(int) Math.pow(n,k);

        while(total-- > 0){
            for(int i = 0; i < n-(n-k); i++)
                System.out.print(a[indexes[i]]);
            System.out.println();

            if(decider.test(indexes)) break;

            for(int i = 0; i < n ; i++){
                if(indexes[i] >= n-1){
                    indexes[i] = 0;
                }else{
                    indexes[i]++;
                    break;
                }
            }
        }
    }
}
