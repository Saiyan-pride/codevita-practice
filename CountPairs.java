import java.io.*;
import java.util.*;
public class CountPairs {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] srr = br.readLine().split(" ");
            int n = Integer.parseInt(srr[0]);
            int k = Integer.parseInt(srr[1]);
            srr = br.readLine().split(" ");
            int[] arr = new int[n];
            for(int i=0; i<n; i++) arr[i] = Integer.parseInt(srr[i]);

            // logic
            // as constraints n<=10^5, we can apply sorting means nlogn is acceptable

            Arrays.sort(arr);
            int cnt = 0;
            for(int i=0; i<n; i++){
                int lr = arr[i]-k;
                int ur = arr[i]+k;
                if(i==0){
                    if(arr[i+1]>ur) continue;
                }
                else if(i==n-1){
                    if(arr[i-1]<lr) continue;
                }
                else{
                    if(arr[i-1]<lr && arr[i+1]>ur) continue;
                }
                cnt++;
            }
            System.out.println(cnt);
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }    
}
