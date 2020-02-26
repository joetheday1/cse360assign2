/**
 * @author Joseph Cushmore
 * 
 * ClassID: 168
 * Assign2 
 * Version 4
 *            ==== github link =======
 * https://github.com/joetheday1/cse360assign2
 * 
 * This file contains the definition of the SimpleList class.
 */
package cse360assign2;

/**
 * This is a SimpleList class that can store any number of integers,
 * up to the amount of memory available.
 */
public class SimpleList
{
	/**
	 * The initial size of the array in a SimpleList.
	 */
	public static final int INITIAL_SIZE = 10;
	
    /**
     * Private array for list of integers.
     */
	private int[] list;
	
	/**
     * Private count holds the current number of items in the list.
     */
    private int count;
	
	/**
     * Private size holds the allocated size of the array of integers.
     */
    private int size;
    
    
     /**
      * Constructor for the SimpleList.
      * 
      * List is empty to start with, and has an allocated size of 10.
      */
     public SimpleList()
     {
    	this.list = new int[INITIAL_SIZE];
    	this.count = 0;
    	this.size = INITIAL_SIZE;
     }
	
     
	/**
	 * This method adds an integer to the front of the SimpleList,
	 * incrementing the "count" of the list by one as a result.
	 * 
	 * This will make the underlying array "grow" if needed.
	 * 
	 * @param num The number to be added to the front of the list. 
	 */
     public void add(int num)
     {
    	 int[] target_list = null;
    	 int[] new_list = null;
    	 
    	 if (this.count < this.size)
    	 {
    		 // Just use this.list as the target_list.
    		 target_list = this.list;
    	 }
    	 else
    	 {
    		 // There is no more room in this.list, so we need to make
    		 // a new_list and then have it be the target_list.
    		 
    		 // Start with 100% of the current size.
    		 int new_size = this.size;
    		 
    		 // Add 50% more.
    		 new_size += this.size / 2;
    		 
    		 // If there was any remainder, add one more to the new_size.
    		 if (this.size % 2 > 0)
    		 {
    			 ++new_size;
    		 }
    		 
    		 // Deal with the special case where new_size is 0 at this
    		 // point, by setting the new_size to be 1 instead (since
    		 // we need at least one spot to add the num to the list).
    		 if (new_size == 0)
    		 {
    			 new_size = 1;
    		 }
    		 
    		 // Now change our size data member to the new size.
    		 this.size = new_size;
    		 
    		 // And create the new list (with the new size) and make
    		 // it be the target_list.
    		 new_list = new int[this.size];
    		 target_list = new_list;
    	 }
    	 
      	 // Determine the first "target index" that we will use to move
    	 // values in the list in order to shift them all forward by one spot.
    	 int first_target_index = this.count;
    	 
    	 // Now loop to copy values from this.list into the target_list,
    	 // but with the indexes in the target list being one larger
    	 // than the corresponding index in this.list.  Note that this
    	 // loop goes "backwards" (decrements the target_index).
    	 for (int target_index = first_target_index;
    	      target_index > 0;
    	      --target_index)
    	 {
    		 target_list[target_index] = this.list[target_index - 1];
    	 }
     	 
     	 // Now we can save the num at the front of the target list.
    	 target_list[0] = num;
    	 
    	 // Increment the count to account for the newly added item.
    	 ++this.count;
    	 
    	 if (new_list != null)
    	 {
    		 this.list = new_list;
    	 }
     }
     
     
     /**
      * This method will remove the supplied value from the SimpleList.
      * Only the first occurrence of the supplied value will be removed
      * from the list (if found). The list will remain unchanged if the
      * supplied value is not in the list.
      * 
      * If a value is removed from the list, then the size of the
      * underlying array will be changed if the percentage of empty
      * spots in the array is 25% or greater, and the new size will
      * match the number of "counted" values in the list. 
      *  
      * @param num The number to be removed from the list.
      */
     public void remove(int num)
     {
    	 int foundIndex = this.search(num);
    	 
    	 if (foundIndex != -1)
    	 {
    		 //======================
    		 // Perform the removal
    		 //======================

    		 // Shift stuff to fill the hole starting with the foundIndex.
    		 for (int targetIndex = foundIndex; 
    			  targetIndex < this.count - 1;
    			  ++targetIndex)
    		 {
    			 this.list[targetIndex] = this.list[targetIndex + 1];
    		 }
    		 
    		 // Be sure to update the count (since we removed one item).
    		 --this.count;
    		 
    		 //===================================================
    		 // Now deal with potentially re-sizing the array as
    		 // a result of performing the removal.
    		 //===================================================
    		 
    		 // Check to see if we should resize the array, which we
    		 // will do if there is 25% or more empty places in the array. 		 
    		 int numEmpty = this.size - this.count;
    		 
    		 int percentEmpty = (100 * numEmpty) / this.size;
    		 
    		 if (percentEmpty == 100)
    		 {
    			 // Special case - the entire list is empty!
    			 //
    			 // We know that this.count is already 0 (since there
    			 // are no "counted" values in the array).
    			 //
    			 // We will set this.size to be 0 and the.list to
    			 // be null, for this case.
    			 this.size = 0;
    			 this.list = null;
    		 }
    		 else if (percentEmpty >= 25)
    		 {
    			 // We need to create a new array, with the size being
    			 // set to the current count, and then copy the values
    			 // from the original array to the new array.
    			 int[] newList = new int[this.count];
    			 
    			 // Copy all items from this.list array to newList array.
    			 for (int index = 0; index < this.count; ++index )
    			 {
    				 newList[index] = this.list[index];
    			 }
    			 
    			 // Set this.list to the newList.
    			 this.list = newList;
    			 
    			 // Change the size to this.count.
    			 this.size = this.count;
    		 }
    	 }
     }
     
     
     /**
      * This method returns the number of values stored in the SimpleList.
      * 
      * @return The number of values currently stored in the SimpleList.
      */
     public int count()
     {
    	 return this.count;
     }
     
     /**
      * This method returns the first value stored in the SimpleList.
      * 
      * @return The number of values currently stored in the SimpleList.
      * 		If the list is empty and there is no first value -999 will
      * 		be returned.
      */
     public int first()
     {
    	 if (this.count > 0)
    	 {
    		 return this.list[0];
    	 }
    	 
    	 // NOTE: This case was not specified in the documentation.
    	 //       Furthermore, if the size can be 0, then there is
    	 //       no list at all (it is null).
    	 return -999;
     }
     
     
     /**
      * This method returns the size of the size of the array.
      * 
      * @return The value of the size of the array.
      */
     public int size()
     {
    	 return this.size;
     }
    
     /**
      * This method adds a number to the end of the list.
      * If the list is full the method will add 50% to the 
      * array.
      * 
      * @param num The value to be added to the end of the list.
      */
     public void append(int num)
     {
    	 if (this.count >= this.size)
    	 {
    		 // We need room to append the number.
    		 
    		 // Compute the newSize for the newList
    		 int newSize = this.size + (this.size / 2);
    		 
    		 if ((this.size % 2) > 0)
    		 {
    			++newSize; 
    		 }
    		 
    		 // The newSize must minimally be 1 in order to have a spot
    		 // for the "num" that we are appending to the list.
    		 if (newSize < 1)
    		 {
    			 newSize = 1;
    		 }
    		 
    		 // Create the newList for the newSize.
    		 int[] newList = new int[newSize];
    		 
    		 // Copy over the values of this.list into the newList.
    		 for (int index = 0; index < this.count; ++index)
    		 {
    			 newList[index] = this.list[index];
    		 }
    		 
    		 // Now we can update our list to be the newList and
    		 // update our size to be the newSize.
    		 this.list = newList;
    		 this.size = newSize;
    	 }

    	 // Copy the supplied number into the list at the "count" index,
    	 // and increment the count.
		 this.list[this.count] = num;
 		 ++this.count;
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