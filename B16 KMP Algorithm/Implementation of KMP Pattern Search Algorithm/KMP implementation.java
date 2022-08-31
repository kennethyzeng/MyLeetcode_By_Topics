/*
Time Complexity:
Space Complexity:
Link: https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
*/ 

class KMP_String_Matching{
    void KMPSearch(String pat, String txt){
        int M = pat.length(); 
        int N = txt.length(); 

        int lps[] = new int [M]; 
        int j = 0;   //index for patp[]

        computeLPSArray(pat, M, lps); 

        int i = 0; // index for txt[]
        while (i < N) {
            if (pat.charAt[j] == txt.charAt[i]){
                i ++; 
                j ++;
            }
            if(j == M){
                System.out.println("Found Pattern at index: " + (i - j));
                j = lps[j -1];           //?
            }

            //mismatch after j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i){
                if (j != 0)
                    j = lps[j -1];
                else
                    i = i +1; 
            }

        }

    }

    // this part mainly find the longest prefix suffix
    void computeLPSArray(String pat, int M, int lps[]){
        int len = 0; 
        int i = 1; 
        lps[0] = 0;                 //lps[0] is always 0

        while (i < M){
            if (pat.charAt(i) == pat.charAt(len)){          //condition 1: 
                len++; 
                lps[i] = len; 
                i++;
            } else {        //trick part     ex; AAACAAAA
                if (len != 0){                              //condition 2: i is not moving forward, but len is reduced
                    len = lps[len -1];
                } else {                                    //condition 3: len == 0 ==> i move forward, lps[i] is recorded and stored
                    lps[i] = len; 
                    i++;
                }


            }
        }
    }

    public static void main(String args[]){
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        new KMP_String_Matching().KMPSearch(pat, txt);
    }
}