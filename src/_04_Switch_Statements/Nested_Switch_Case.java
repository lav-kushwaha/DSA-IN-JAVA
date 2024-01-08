package _04_Switch_Statements;
import java.util.Scanner;
public class Nested_Switch_Case {
    public static void main(String[] args) {
        //Nested switch case means switch case inside another switch case.
        Scanner sc = new Scanner(System.in);
        int empID = sc.nextInt();
        String department = sc.next();

        switch(empID){
            case 1:
                System.out.println("Lav Kushwaha");
                break;
            case 2:
                System.out.println("Suresh Raina");
                break;
            case 3 :
                System.out.println("Employe no. 3");
               switch (department){
                   case "IT":
                       System.out.println("IT Department");
                       break;
                   case "Management":
                       System.out.println("Management Department");
                       break;
                   default:
                       System.out.println("No department entered ");
               }
               break;
            default:
                System.out.println("Enter correct EMPID");
        }
    }
}
