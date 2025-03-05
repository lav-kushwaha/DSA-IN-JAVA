package Questions.Questions;

//https://leetcode.com/problems/count-total-number-of-colored-cells/description/
//2579. Count Total Number of Colored Cells
class coloredCells {
    public long coloredCells(int n) {
        return 1 + (long) n * (n - 1) * 2;
    }
}
