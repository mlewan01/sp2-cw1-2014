
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Copy rights Mariusz Lewandowski
 * http://www.artemlux.com
 * @author: mlwan01 <Mariusz Lewandowski, Student ref: 12906023>
 * class: sp2-2014
 */

public class Cw1 {
    final static int arrayCapacity = 100;
    public static void main(String[] arg){
        
        int[] a1 = new int[arrayCapacity];
        int[] a2 = new int[arrayCapacity];
        
        System.out.println("Entering values in to the first array.");
        a1 = fillIntArray(a1);
        System.out.println("Entering values in to the second array.");
        a2 = fillIntArray(a2);
        
        System.out.println("\n-------------------------------------------------\n");
        
        System.out.println("Printing elements of the first array: ");
        displayElements(a1);
        System.out.println("Printing elements of the second array: ");
        displayElements(a2);
        
        System.out.println("Printing common elements: ");
        int[] common = displayCommon(a1,a2);
        displayElements(common);
        
        System.out.println("Comon data is: " + common.length);
        
        System.out.println("Printing non-common elements in first array: ");
        displayElements(displayNonCommon(a1,common));
        
        System.out.println("Printing non-common elements in second array: ");
        displayElements(displayNonCommon(a2,common));
        
        
    }
    /**
     * the method checks whether an given integer already exists in given array
     * @param k represents an array of integers to be checked
     * @param m represents an integer to be found in the array
     * @param n indicate to which position in the array to search. For partially filled arrays for example 
     * @return false if integer "m" does not occur in the array "k". Returns true otherwise.
     */
    public static boolean isIntInArray(int[] k, int m, int n){
        for(int ii=0; ii<=n; ii++){
            //System.out.print(k[ii] + " , ");
            if( k[ii] == m){
                //System.out.println("The integer: "+m+" IS already in the array");
                return true;
            }
        }
        //System.out.println("The integer: "+m+" NOT found in the array");
        return false;
    }
    /**
     * The method will as user to enter integers in the console. It will exit while entered "0".
     * It will then check whether the integer already exists in the array. If not it will enter it to the array.
     * @param a is the array to which to enter the integers inputed from console
     * @return 
     */
    public static int[] fillIntArray(int[] a){
        Scanner s = new Scanner(System.in);
        int i, j=0;
        System.out.println("please enter and Int! enter 0 to exit:");
        while((i=s.nextInt()) != 0){
            if(!isIntInArray(a, i, j)) {
                a[j]=i;
            }else j--;
            //System.out.println("this is \"i\": "+i);
            j++;
            System.out.println("please enter and Int! enter 0 to exit:");
        }
        int[] k = new int[j];
        System.arraycopy(a, 0, k, 0, j);
        //System.out.println(Arrays.toString(k));
        return k;
    }
    /**
     * method will print out in console content of given array till the first O
     * @param a is the array to be printed its content
     */
    public static void displayElements(int[] a){
        for(int i =0; i<a.length; i++){
            System.out.print(a[i]+ " ");
        }
        System.out.println();
    }
    /**
     * function checks for common values in given arrays and
     * @param a first array with integer elements
     * @param b second array with integer elements
     * @return returns an array with common elements
     */
    public static int[] displayCommon(int[] a, int[] b){
        int z = a.length < b.length ? b.length : a.length;
        int[] c = new int[z];
        int k=0;
        for(int i=0; i<a.length; i++){
            for(int j=0; j<b.length; j++){
                if(a[i] == b[j]){
                    c[k] = b[j];
                    k++;
                    continue;
                }
            }
        }
        int[] ak = new int[k];
        System.arraycopy(c, 0, ak, 0, k);
        return ak;
    }
    
    /**
     * function checks for NOT common values in given arrays and
     * @param a first array with integer elements
     * @param b second array with integer elements to exclude form array a
     * @return returns an array with NOT common elements
     */
    public static int[] displayNonCommon(int[] a, int[]b){
        int z = a.length + b.length;
        int[] c = new int[z];
        int k=0;
        for(int i=0; i<a.length; i++){
            boolean non = true;
            for(int j=0; j<b.length; j++){
                if(a[i]== b[j]) {
                    non = false;
                }
            }
            if(non){
                c[k] = a[i];
                k++;
            }
        }
        int[] ak = new int[k];
        System.arraycopy(c, 0, ak, 0, k);
        return ak;
    }
}
