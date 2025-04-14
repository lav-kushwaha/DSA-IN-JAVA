package Questions.Questions;

class jugglerSequence {
    static List<Long> jugglerSequence(long n) {
         List<Long> arr = new ArrayList<>();
        arr.add(n);
        return recursiveHelper(n, arr);
    }
    
    private static List<Long> recursiveHelper(long n, List<Long> arr) {
        if (n <= 1) {
            return arr;
        }
        if (n % 2 == 0) {
            n = (long) Math.pow(n, (float) 1 / 2);
            arr.add(n);
        } else {
            n = (long) Math.pow(n, (float) 3 / 2);
            arr.add(n);
        }
        return recursiveHelper(n, arr);
    }

}