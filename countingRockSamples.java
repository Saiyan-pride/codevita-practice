import java.util.*;
import java.io.*;
public class countingRockSamples{
    public static void main(String[] args) {
        // inputs 
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] srr = br.readLine().split(" ");
            int s = Integer.parseInt(srr[0]);
            int r = Integer.parseInt(srr[1]);
            srr = br.readLine().split(" ");
            int[] arr = new int[s];
            for(int i=0; i<s; i++)
                arr[i] = Integer.parseInt(srr[i]);
            int[][] range = new int[r][2];
            for(int i=0; i<r; i++){
                srr = br.readLine().split(" ");
                range[i][0] = Integer.parseInt(srr[0]);
                range[i][1] = Integer.parseInt(srr[1]);
            }
            // input test
            // System.out.println(s+" "+r);
            // for(int ele : arr) System.out.print(ele +" ");
            // System.out.println();

            // for(int[] ran : range){
            //     System.out.println(ran[0]+" "+ran[1]);
            // }

            //logic
            Arrays.sort(arr);
            int[] res = new int[r];

            for(int i=0; i<r; i++){
                int start = range[i][0];
                int end = range[i][1];

                res[i] = find(arr, start, end);
            }
            for(int ans : res){
                System.out.print(ans+" ");
            }
            System.out.println();

        } catch (Exception e) {
            System.out.println("invalid input");
        }
    }
    public static int find(int[] arr, int start, int end){
        int lo = lowerbound(arr, start);
        int hi = upperbound(arr, end);
        return hi-lo+1;
    }
    public static int lowerbound(int[] arr, int key){
        if(arr[arr.length-1]<key) return arr.length; 
        int lo=0, hi=arr.length-1, res = 0;
        while(lo<=hi){
            int mid = (hi+lo)/2;
            if(arr[mid]>=key){
                res = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return res;
    }
    public static int upperbound(int[] arr, int key){
        int n = arr.length;
        if(arr[0]>key) return -1;
        int lo=0, hi=n-1, res=0;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(arr[mid]<=key){
                res = mid;
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        } 
        return res;
    }
}