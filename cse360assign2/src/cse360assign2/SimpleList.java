/**
 * @author Joseph Cushmore
 * 
 * ClassID: 168
 * Assign2 
 * 
 * This file contains the definition of the SimpleList class.
 */
package cse360assign2;

/**
 * This is a SimpleList class that can store up to 10 integers.
 */
public class SimpleList
{
	/**
	 * The maximum number of integers that can be stored in a SimpleList.
	 */
	public static final int MAX_COUNT = 10;
	
    /**
     * Private array for list of integers.
     */
	private int[] list;
	
	/**
     * Private count holds the current size of the list.
     */
    private int count;
    
    
     /**
      * Constructor for the SimpleList. List is empty to start with.
      */
     public SimpleList()
     {
    	this.list = new int[MAX_COUNT];
    	this.count = 0;
     }
	
     
	/**
	 * This method adds an integer to the front of the SimpleList. 
	 * If the SimpleList is full, the last element will fall off of the
	 * list, and the size of the list will remain unchanged.
	 * Otherwise, the size of the list will be increment by one.
	 * 
	 * @param num The number to be added to the front of the list. 
	 */
     public void add(int num)
     {
      	 // Determine the first "target index" that we will use to move
    	 // values in the list in order to shift them all forward by one spot.
    	 int first_target_index = this.count;
    	 
    	 if (this.count == MAX_COUNT)
    	 {
    		 first_target_index = this.count - 1;
    	 }

    	 // Now loop to shift values forward, leaving a spot at index 0
    	 // for the "num" to be added.
    	 for (int target_index = first_target_index;
    	      target_index > 0;
    	      --target_index)
    	 {
    		 this.list[target_index] = this.list[target_index - 1];
    	 }
     	 
     	 // Now we have room to save the num at the front of the list.
    	 this.list[0] = num;
    	 
    	 // Only increment the count if the list is not already full.
    	 if (this.count < MAX_COUNT)
    	 {
    		 ++this.count;
    	 }
     }
     
     
     /**
      * This method will remove the supplied value from the SimpleList.
      * Only the first occurrence of the supplied value will be removed
      * from the list (if found). The list will remain unchanged if the
      * supplied value is not in the list.
      *  
      * @param num The number to be removed from the list.
      */
     public void remove(int num)
     {
    	 int foundIndex = this.search(num);
    	 
    	 if (foundIndex != -1)
    	 {
    		 // Shift stuff to fill foundIndex (hole).
    		 for (int targetIndex = foundIndex; 
    			  targetIndex < this.count - 1;
    			  ++targetIndex)
    		 {
    			 this.list[targetIndex] = this.list[targetIndex + 1];
    		 }
    		 
    		 // Be sure to update the count (since we removed one item).
    		 --this.count;
    	 }
     }
     
     
     /**
      * This method returns the size of the SipmleList.
      * 
      * @return The size of the SimpleList.
      */
     public int count()
     {
    	 return this.count;
     }
     
     
     /**
      * This method prints a formatted string of the SimpleList.
      * 
      * @return The formatted string.
      */
     public String toString()
     {
    	 StringBuilder myStr = new StringBuilder("");
    	
    	 for (int index = 0; index < this.count; ++index)
    	 {
    		 myStr.append(this.list[index]);

    		 if (index !=  (this.count - 1))
    		 {
    			 myStr.append(" ");
    		 }
    	 } 
    	 return myStr.toString();
     }
     
     
     /**
      * This method is used to search for a number in the list,
      * returning the index of the first occurrence of the number
      * within the list (if found).
      * If the supplied number is not found then a value of -1 
      * will be returned. 
      * 
      * @param num The number to search for.
      * 
      * @return The index of the first occurrence of the supplied 
      *         number if found, or -1 if not found.
      */
     public int search(int num)
     {
    	 int foundIndex = -1;
    	 
    	 for (int searchIndex = 0;
    	      (searchIndex < this.count) && (foundIndex == -1);
    		  ++searchIndex)
    	 {
    		 if (this.list[searchIndex] == num)
    		 {
    			 foundIndex = searchIndex;
    		 }
    	 }
    	 
    	 return foundIndex;
     }
	
}