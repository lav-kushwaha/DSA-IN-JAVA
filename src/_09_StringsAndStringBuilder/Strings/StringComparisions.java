package _09_StringsAndStringBuilder.Strings;

public class StringComparisions {
    public static void main(String[] args) {
        //case - 01 :When String is pointing to the same objects.
        String str1  = "Lav";
        String str2 = "Lav";
        System.out.println(str1);
        System.out.println(str1==str2); //true.
        //the ans is true bcz reference of variable is pointing to the same objects in string pool.
        //string pool is nothing just a another memory structure which is inside memory heap where string objects/literals stores.

        //case - 02 : When String is not pointing to the same objects.
        String name1 = new String("lav");
        String name2 = new String("lav");
        System.out.println(name1==name2); //false.
        //ans is false bcz object created in heap memory and it is not pointing to the same objects it is created different objects.

        //This How we can check value is equal or not ?
        System.out.println(name1.equals(name2));//true
        //ans is true bcz 'equals' method doesn't care reference variable is pointing to the same objects or not its just check value "lav" equal or not.




    }
}
