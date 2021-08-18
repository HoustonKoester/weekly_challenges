import java.util.*;
public class week1 {
    public static void main(String[] args){
        bucketize("she sells sea shells by the sea", 10);
        bucketize("the mouse jumped over the cheese", 7);
        bucketize("fairy dust coated the air", 20);
        bucketize("a b c d e", 2);
    }

    public static ArrayList<String> bucketize(String sentence, int maxsize) {
        //needed declarations
        ArrayList<String> buckets = new ArrayList<String>();
        String[] words = sentence.split(" ");
        String bucket = "";

        //business logic
        for(int i=0; i<words.length; i++) {
            // return empty buckets if total word length is more than the max size allowed
            if(words[i].length() > maxsize) {
                buckets.clear();
                return buckets;
            }
            //attempt to add new word to bucket
            String attempt = bucket + " " + words[i];

            //if less than maxsize add word to bucket and move to next
            //else push bucket to buckets and move to next set
            if(attempt.trim().length() <= maxsize) {
                bucket = attempt.trim();
                continue;
            }else {
                buckets.add(bucket);
                bucket = words[i];
            }
        }
        //add remaining bucket post for loop
        buckets.add(bucket);
        
        //return logic + print for testing
        System.out.println(buckets);
        return buckets;
    }
}
