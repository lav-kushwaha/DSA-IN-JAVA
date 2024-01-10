package _05_Functions_In_Java;

public class Scope {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        String name = "lav";
        {
//            int a = 120;//we can't re-initialized same reference variable.
            a = 100;//but we can change the value, here we re-assign the original reference variable to some other value.
            int c = 120;
            //values initialised in this block, will remain in block.
            name = "Ram";
            System.out.println(name);

        }
        int c = 10;//we can intialised the same reference variable which is already present in block scope.
//        System.out.println(c);//we can't used block scope reference variable outside the block.

        //Scoping in for loops.
        for(int i = 0; i<4; i++){
            System.out.println(i);
            int num = 90;
//            int a = 10;
        }
//        System.out.println(i);

    }

    static void random (int marks){
        int num = 67;
        System.out.println(num);
        System.out.println(marks);
    }

}
