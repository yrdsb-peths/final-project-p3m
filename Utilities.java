import greenfoot.*;
import java.util.ArrayList;

/**
 * Write a description of class Utilities here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Utilities  
{  
    //Methods to use quickswap
    public static void swap(ArrayList<Double> arr, int i, int j)
    {
        double temp = arr.get(i);
        double j2 = (double) j;
        arr.set(i, j2);
        arr.set(j, temp);
    }
    
    public static int partition(ArrayList<Double> arr, int low, int high)
    {
        int p = low, j;
        for(j = low + 1; j <= high; j++)
        {
            if(arr.get(j) < arr.get(low))
                swap(arr, ++p, j);
        }
        swap(arr, low, p);
        return p;
    }

    public static void quicksort(ArrayList<Double> arr, int low, int high)
    {
        if(low < high){
            int p = partition(arr, low, high);
            quicksort(arr, low, p - 1);
            quicksort(arr, p + 1, high);
        }
    }
}
