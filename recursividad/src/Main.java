public class Main{
    public static void main(String[] args) {
        Recursion r = new Recursion();
        String string = "HelloDa";
        int[] arr = {1,2,3,4,5};
        System.out.println(r.factorial(4));
        System.out.println(r.binarySearch(arr, 5, 0, 4));
        // System.out.println(r.stringSize("pepe"));
        System.out.println(string.indexOf(0));

    }
}
