import java.util.Arrays;

public class week2 {
    public static void main(String[] args){
        validatecard("1234567890123456");
        validatecard("9231949850239192");
        validatecard("1234");
        validatecard("123456789023124124123456");
        validatecard("374245455400126");
        validatecard("6011000991300009");
    }


    public static boolean validatecard(String num){
        boolean result;
        if( num.length() > 19 || num.length() < 14){
            System.out.println("false, card number too short or too long");
            return false;
        }
        int checksum = num.charAt(num.length()-1) - '0';
        int[] remainder = strToIntArr(num.substring(0,num.length()-1));
        int[] reverse = new int[remainder.length];

        int i = 0;
        while( remainder.length > i){
            reverse[i] = remainder[remainder.length-1-i];
            i++;
        }

        i=0;
        while( remainder.length > i){
            reverse[i] *= 2;
            if(reverse[i] >= 10){
                reverse[i] = reverse[i]%10 + reverse[i]/10;
            }
            i = i +2;
        }

        i=0;
        int sum = 0;
        while(remainder.length > i){
            sum+=reverse[i];
            i++;
        }
        if(10 - sum%10 != checksum ){
            result = false;
        }else{
            result = true;
        }
        System.out.println(result);
    return false;
    }

    public static int[] strToIntArr(String num) {
        int[] arr = new int[num.length()];
        int i = 0;
        for (char c : num.toCharArray()) {
            arr[i] = c - '0';
            i++;
        }
        return arr;
    }
}
