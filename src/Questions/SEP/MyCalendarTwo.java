package Questions.SEP;

import java.util.Map;
import java.util.TreeMap;

class MyCalendarTwo {
    TreeMap<Integer, Integer> bookings;
    int maxOverAllowed;

    public MyCalendarTwo() {
        bookings = new TreeMap<>();
        maxOverAllowed = 2;
    }

    public boolean book(int start, int end) {
        bookings.put(start, bookings.getOrDefault(start, 0) + 1);
        bookings.put(end, bookings.getOrDefault(end, 0) - 1);

        int overlapCount = 0;
        for (Map.Entry<Integer, Integer> entry : bookings.entrySet()) {
            overlapCount += entry.getValue();
            if (overlapCount > maxOverAllowed) {
                bookings.put(start, bookings.getOrDefault(start, 0) - 1);
                bookings.put(end, bookings.getOrDefault(end, 0) + 1);
                
                if (bookings.get(start) == 0) {
                    bookings.remove(start);
                }
                if (bookings.get(end) == 0) {
                    bookings.remove(end);
                }
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        MyCalendarTwo myCalendar = new MyCalendarTwo();
        System.out.println(myCalendar.book(10, 20)); // true
        System.out.println(myCalendar.book(50, 60)); // true
        System.out.println(myCalendar.book(10, 40)); // true
        System.out.println(myCalendar.book(5, 15));  // false
        System.out.println(myCalendar.book(5, 10));  // true
        System.out.println(myCalendar.book(25, 55)); // true
    }
}

