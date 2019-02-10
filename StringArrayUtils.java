 

/**
 * Created by leon on 1/29/18.
 */

import java.util.Arrays;
import java.util.ArrayList;

public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length-1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length-2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        boolean retVal = false;
        
        
        for(int i=0; i<array.length && retVal == false ;i++)
        {
            retVal = value.equals(array[i]);
        }
        
        // looks like there is an array util for the contains . But wanted to try with out using it
        return retVal;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        
        String arrayHold[] = new String[array.length];
        int arrayLen = array.length;
        
        for(int i=0; i<array.length;i++)
        {
            
            arrayHold[arrayLen-1] = array[i]; // 2 .. 0, 1..1 , 0 .. 2, 
            arrayLen--;
        }
        
      
        // there is a array String.Reverse, but wanted to figure it out with out using it
        return arrayHold;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        return Arrays.equals(array, reverse(array));
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        // concate the values to 1 string, then check the string
        String nonArrayString = "";
        boolean retVal = true;
        int charLength=0;
        char  tempHold;
       
        
        // put into string just to get the overall count
        for(int i=0;i<array.length;i++) {
            
            nonArrayString = nonArrayString + array[i];
        }
        
        //Move back into a string array of individual strings
        String newArray[] = new String[nonArrayString.length()];
        for(int b =0; b <nonArrayString.length() ; b++ ){
            tempHold= nonArrayString.charAt(b);
            newArray[b] = Character.toString(tempHold);
        }
        
        
        // now that it is 1 string - which is an array of chars, loop through single array
        for(Character value = 'a'; value < 'z'; value++) {
            //System.out.println((contains(newArray,value.toString())||contains(newArray,value.toString().toUpperCase())));
            if(!(contains(newArray,value.toString())||contains(newArray,value.toString().toUpperCase())))
            {
                retVal = false;
                //System.out.println("Not Found");
            }
            
        }
        
       
        return retVal;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
         int retVal = 0;
        
        
        for(int i=0; i<array.length ; i++)
        {
            if(value.equals(array[i])) {
                retVal++;
            }
        }
        
        // looks like there is an array util for the contains . But wanted to try with out using it
        return retVal;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        String retArray[] = new String[array.length-1];
        
        for(int n=0, i=0; i<array.length  ;i++, n++)
        { 
             if(valueToRemove.equals(array[i])){
                  i++;
                }
                retArray[n] = array[i];
        }
          return retArray;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        
        
         int numOfDups=0;
         int newArrayIndex=0;
         String prev=new String();
        // System.out.println("------");
         
         // get new size first
         for(int i=0; i<(array.length-1); i++){
            if(array[i].equals(array[i+1])){
                numOfDups++;
              //  System.out.println(array[i] + " " + array[i+1]);
            }
            
             //System.out.println(numOfDups );
        }
         
         String retArray[] = new String[array.length-numOfDups];
         
        for(int i=0; i<(array.length-1); i++){
            
                   
             if(array[i].equals(array[i+1])) {
                 
                }
                else {
                 retArray[newArrayIndex] = array[i];
                 newArrayIndex++;
                 System.out.println(array[i] + " " + i );
                }
     
              
            }
            retArray[newArrayIndex] = array[array.length-1];
            
            
            return retArray;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        
        //int n = 1;
        ArrayList<String> concatDups = new ArrayList<String>();
        String dupString = new String();
        
       // System.out.println("-----");
        
        for(int i=0;i<array.length;i++) // Loop through entire array List
    {
            if(i + 1 != array.length) { // if not out of bounds
                String next = array[i];
                while(array[i].equals(array[i+1])){ //  Loop to check for next val equals
                    next += array[i];
                    i++;
                    if (i + 1 == array.length) // check again for out of bounds
                    {break;
                    }
                 }
                concatDups.add(next); // concat to string element
            } else {
                concatDups.add(array[i]); // add string element to array list
            }
        
    }
       
        String[] retVal = new String[concatDups.size()]; //new concatDups.size();
        
        concatDups.toArray(retVal);
        
        return retVal;
    }


}
