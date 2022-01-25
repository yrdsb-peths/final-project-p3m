/**
 * Write a description of class StackOfDoubles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StackOfDoubles{
    private Node first;
    
    private class Node 
    {
        private double item;
        private Node next;
    }
    
    public boolean isEmpty() 
    {
        return first == null;
    }
    
    public void push(double item) 
    {
        Node second = first;
        first = new Node();
        first.item = item;
        first.next = second;
    }
    
    public double pop() 
    {
        double item = first.item;
        first = first.next;
        return item;
    }
    
    public double peek() 
    {
         return first.item;
    }
}

