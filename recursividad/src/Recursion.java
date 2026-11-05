/**
 * Recursion
 */
public class Recursion {
    private int[] arr = new int[5];
    
// Implementar una funcion recursiva que calcule el resultado de la operacion factorial.
  public int factorial(int n){
    if(n== 0 || n==1){
      return 1;
    }
    return n*factorial(n-1);
  }
  // Implementar busqueda binaria de manera recursiva 
  public int binarySearch(int[] arr, int target, int low, int high){
    int mid = (high+low)/2;
    if(arr[mid] == target){ //caso base 
      return mid;
    } else if(low <= high){
      if(arr[mid]< target){
        return binarySearch(arr, target, mid+1, high);
      }
      return binarySearch(arr, target, low, mid-1);
    }
    return -1;
  }
  public int stringSize(String target){
    if(target.indexOf(0) == 0){
      return 0;
    }
    return target.indexOf(0) + stringSize(target);
  }
}
