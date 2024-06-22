package _13_MathsForDSA.Maths;

import java.util.ArrayList;

public class FactorsOfNum {
    public static void main(String[] args) {
        int n = 20;
//       Factors(n);
//        factors2(n);
        factors3(n);//calling function
    }

    //time:O(n)
    static void Factors(int n){
        for (int i=1;i<=n;i++){
            if(n%i==0){
                System.out.println(i);
            }
        }
    }

    //O(sqrt(n))
    //this will print factors in unsorted order. i.e - 1 20 2 10 4 5
    static void factors2(int n){
        for(int i=1;i<=Math.sqrt(n);i++) {
            if (n % i == 0) {
                if (n/i == i) {
                    System.out.print(i + " ");
                }else {
                    System.out.print(i + " "+ n/i +" ");
                }
            }
        }
    }

    //both time and space with be O(sqrt(n))
    //this will print factors in sorted order. i.e - 1 2 4 5 10 20
    static void factors3(int n){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<=Math.sqrt(n);i++) {
            if (n % i == 0) {
                if (n/i == i) {
                    System.out.print(i + " ");
                }else {
                    System.out.print(i + " "); //here only i will be printing
                    list.add(n/i); //all the n/i element will be add in list i.e - 20 10 5
                }
            }
        }
        for(int i=list.size()-1;i>=0;i--){
            System.out.print(list.get(i)+" ");
        }

    }
}
