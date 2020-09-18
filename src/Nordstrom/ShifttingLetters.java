package Nordstrom;

public class ShifttingLetters {



        public String shiftingLetters(String S, int[] shifts) {


            if(S == null||S.length() == 0){
                return S;

            }

            char[] arr = S.toCharArray();

            int shift = 0;
            for(int i = shifts.length - 1; i >= 0; i--){
                shift += shifts[i];
                shift %= 26;//in case of overflow!!
                int index = arr[i] + shift;

                if(index > 'z'){
                    arr[i] = (char)((index - 'a')%26 + 'a');
                }else{
                    arr[i] = (char)index;
                }
            }

            return new String(arr);
        }

//S = "abc", shifts = [3,5,9]
//[a  b  c]  int c + 9    if index = c + 9 >'z' index - 'a'%26 + 'a'
}
