package _04_Switch_Statements;
import java.util.Scanner;
public class Enhance_Nested_Switch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int empID = sc.nextInt();
        String department = sc.next();
        switch (empID) {
            case 1 -> System.out.println("Lav Kushwaha");
            case 2 -> System.out.println("Suresh Raina");
            case 3 -> {
                System.out.println("Employe no. 3");
                switch (department) {
                    case "IT" -> System.out.println("IT Department");
                    case "Management" -> System.out.println("Management Department");
                    default -> System.out.println("No department entered ");
                }
            }
            default -> System.out.println("Enter correct EMPID");
        }
    }
}
