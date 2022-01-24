import greenfoot.*;
/**
 * Write a description of class Utilities here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Utilities  
{  
    //Methods to use quickswap
    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void shuffle(int[] arr)
    {
        int n = arr.length;
        for(int i = 0; i < n; i++)
        {
            int r = Greenfoot.getRandomNumber(n - i) + i;
            Utilities.swap(arr, i, r);
        }
    }
    
    public static void setup(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = i++;
        }
    }
}
