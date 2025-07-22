package Questions.Array_Questions.Array_Easy_Questions;

import java.util.ArrayList;
import java.util.List;

public class UnionOfTwoSortedArrays {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> ans = new ArrayList<Integer>();

        int i = 0;
        int j = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                addIfNotDuplicates(ans, a[i]);
                i++;
            } else if (a[i] > b[j]) {
                addIfNotDuplicates(ans, b[j]);
                j++;
            } else {
                addIfNotDuplicates(ans, a[i]);
                i++;
                j++;
            }
        }

        while (i < a.length) {
            addIfNotDuplicates(ans, a[i]);
            i++;
        }

        while (j < b.length) {
            addIfNotDuplicates(ans, b[j]);
            j++;
        }

        return ans;
    }

    public static void addIfNotDuplicates(List<Integer> list, int value) {
        if (list.isEmpty() || list.get(list.size() - 1) != value) {
            list.add(value);
        }
    }

    public static void main(String[] args) {

    }
}

//Intuition.
//1.Use two pointers to walk through both sorted arrays
//2.Compare and add the smaller (or equal) element
//3.Skip duplicates by checking the last inserted item
