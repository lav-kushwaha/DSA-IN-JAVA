package _05_Functions_In_Java;

public class Swap {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        //swap number code
//        int temp = a;
//        a = b;
//        b = temp;

        swap(a,b);
        System.out.println(a+" "+b);

        String name = "lav kushwaha";
        ChangeName(name);
        System.out.println(name);

    }

    //String code
    static void ChangeName(String name) {
        name = "Ram";//creating a new object.

  }

  //Swaping number code.
  static void swap(int a,int b){
        int temp = a;
        a = b;
        b = temp;
        //this change will only be valid in this function scope only.
    }

}
