import java.util.*;
import java.io.*;
public class StringPairs{
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            String[] srr = br.readLine().split(" ");
            int[] arr = new int[n];
            for(int i=0; i<n; i++) arr[i] = Integer.parseInt(srr[i]);

            // logic

            HashMap<Integer, String> map = new HashMap<>();
            map.put(0, "zero");
            String[] ones = {
                "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
            };

            String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
            };

            for (int i=1; i<=100; i++){
                if(i<20) map.put(i, ones[i]);
                else if(i<100){
                    int ten = i/10;
                    int one = i%10;
                    if(one==0) map.put(i, tens[ten]);
                    else map.put(i, tens[ten]+" "+ones[one]);
                }
                else map.put(i, "hundred");
            }
            int d = 0;
            for(int ele : arr){
                String s = map.get(ele);
                int vowels = vCnt(s);
                d += vowels;
            }

            int pairs = 0;
            for(int i=0; i<n; i++){
                for(int j=i+1; j<n; j++){
                    if(arr[i]+arr[j]==d) pairs++;
                }
            }

            System.out.println(pairs);
            System.out.println(map.get(pairs));

        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }
    public static int vCnt(String s){
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') cnt++;
        }
        return cnt;
    }
}