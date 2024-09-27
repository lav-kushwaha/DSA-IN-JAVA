package Questions.SEP;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/problems/my-calendar-ii/description/
//731. My Calendar II

//Line sweep algorithm
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


//second method - best
//class MyCalendarTwo {
//    List<int[]> bookings;
//    TreeMap<Integer,Integer> overlappedMap;
//    public MyCalendarTwo() {
//        bookings = new ArrayList<>();
//        overlappedMap = new TreeMap<>();
//    }
//
//    public boolean book(int start, int end) {
//        Integer prevVal = overlappedMap.lowerKey(end);
//        if(prevVal!=null && start<=overlappedMap.get(prevVal)-1){
//            return false;
//        }
//
//        for(int [] booking : bookings){
//            int commStart = Math.max(booking[0],start);
//            int commEnd = Math.min(booking[1],end);
//
//            if(commStart<commEnd){
//                overlappedMap.put(commStart,commEnd);
//            }
//        }
//
//        bookings.add(new int[]{start,end});
//        return true;
//    }
//}
//
///**
// * Your MyCalendarTwo object will be instantiated and called as such:
// * MyCalendarTwo obj = new MyCalendarTwo();
// * boolean param_1 = obj.book(start,end);
// */

