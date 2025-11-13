package hashroll;

import java.util.ArrayList;

public class RabinKarpRollingHash{

    //P is small prime number (we can take f.e. 37 and code would still work)
    //MOD exists to take mod from it by formula

    private final int p = 31;
    private final int MOD = 1_000_000_009;
    
    //Search pattern Method
    public ArrayList<Integer> search(String pattern, String originalString){
        int patternLength = pattern.length();
        int origStringLength = originalString.length();
        //Initialize the length of the inputs
        long[] pPow = new long[Math.max(origStringLength, patternLength)];
        pPow[0] = 1;
        //Sequence of powers (p^n-1)
        for(int i = 1 ; i < pPow.length; i ++){

            pPow[i] = ((pPow[i-1] * p) % MOD);

        }

        long[] h = new long[origStringLength+1];

        //Hashing every element in originalString and allocating hash to a new array named "h"

        for(int i = 0 ;i < origStringLength; i++){

            h[i+1] = ((h[i] + (originalString.charAt(i) - 'a' + 1) * pPow[i]) % MOD); 

        }
        
        long patternHash = 0;

        //Calculating total hash of the pattern

        for(int i = 0 ; i < patternLength; i++){

            patternHash = (patternHash + ((pattern.charAt(i) - 'a' + 1) * pPow[i])) % MOD;

        }

        //resulting array
        ArrayList<Integer> arrOfIndexes = new ArrayList<>();

        //By 1 loop check if pattern hash equals to the some hash in original sequence, if match double-check by substring.equals();

        for(int i = 0 ; i + patternLength <= origStringLength; i++){
            long currentHash = (h[i+patternLength] - h[i] + MOD) % MOD;
            long expectedHash = (patternHash * pPow[i]) % MOD;
            if (currentHash == expectedHash){ 
                if (originalString.substring(i, i + patternLength).equals(pattern)) {
                    arrOfIndexes.add(i);
                }
            }
        }
        //return the arraylist with indexes, which means the starting index of found pattern in original;
        return arrOfIndexes;

    }
}
