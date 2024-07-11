package _09_StringsAndStringBuilder.StringBuilder;
//Example with Loop
//Here's an example showing why StringBuilder is preferred in loops:
public class StringBuilderPerformanceExample {
    public static void main(String[] args) {
        // Using StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());

        // Using String (inefficient)
        String str = "";
        for (int i = 0; i < 1000; i++) {
            str += i + " ";  // This creates many intermediate String objects
        }
        System.out.println(str);
    }
}


//Note : Performance Considerations
//Using StringBuilder is more efficient than using regular string concatenation in loops or when performing numerous modifications.
// This is because StringBuilder can change its content without creating new objects, unlike immutable String objects.

//Important :-
//In the loop example, StringBuilder is much more efficient because it modifies the existing sequence of characters rather than creating new string objects each time the loop iterates.
//This results in better performance and lower memory usage.