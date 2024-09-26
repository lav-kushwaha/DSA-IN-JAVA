package Questions.Questions;
import java.util.TreeMap;

//https://leetcode.com/problems/my-calendar-i/description/
//729. My Calendar I

class MyCalendar {
    TreeMap<Integer, Integer> map;

    // Constructor
    public MyCalendar() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prevVal = map.lowerKey(end);

        if (prevVal != null && start < map.get(prevVal)) {
            return false; // Return false if there is an overlap.
        }
        map.put(start, end);
        return true; // Return true indicating the event was successfully booked.
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20)); // true, booking [10, 20]
        System.out.println(myCalendar.book(15, 25)); // false, overlaps with [10, 20]
        System.out.println(myCalendar.book(20, 30)); // true, no overlap with [10, 20] or [15, 25]
        System.out.println(myCalendar.book(5, 10));  // true, no overlap with existing events
        System.out.println(myCalendar.book(30, 40)); // true, no overlap with existing events
    }
}
