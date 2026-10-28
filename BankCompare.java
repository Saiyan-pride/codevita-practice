import java.io.*;
public class BankCompare {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            double p = Double.parseDouble(br.readLine());
            int t = Integer.parseInt(br.readLine());
            int n1 = Integer.parseInt(br.readLine());
            double[][] arr1 = new double[n1][2]; 
            for(int i=0; i<n1; i++){
                String[] srr = br.readLine().split(" ");
                // interest rate
                arr1[i][0] = Double.parseDouble(srr[0]);
                // period
                arr1[i][1] = Double.parseDouble(srr[1]);
            }
            int n2 = Integer.parseInt(br.readLine());
            double[][] arr2 = new double[n2][2]; 
            for(int i=0; i<n2; i++){
                String[] srr = br.readLine().split(" ");
                arr2[i][0] = Double.parseDouble(srr[0]);
                arr2[i][1] = Double.parseDouble(srr[1]);
            }

            // System.out.println(p);
            // System.out.println(t);
            // System.out.println(n1);
            // for(int[] arr : arr1){
            //     System.out.println(arr[0]+" "+arr[1]);
            // }
            // for(int[] arr : arr2){
            //     System.out.println(arr[0]+" "+arr[1]);
            // }
            // System.out.println(n2);

            // logic

            double paidA = calc(p, t, arr1);
            double paidB = calc(p, t, arr2);

            double interestA = paidA - p;
            double interestB = paidB - p;

            if(interestA<=interestB){
                System.out.println("Bank A");
            }else{
                System.out.println("Bank B");
            }

        }catch(Exception e){
            System.out.println("invalid input");
        }
    }
    public static double calc(double p, int t, double[][] bank){
        double bal = p;
        double total = 0;
        int remaining = t*12;
        for(double[] b: bank){
            double ar = b[0];
            int month = (int) b[1]*12;
            double mr = ar/(12*100.0);
            month = Math.min(month, remaining);
            double emi;
            if(mr==0) emi = bal/remaining;
            else{
                double power = Math.pow(1+mr, remaining);
                emi = bal*mr*power/(power-1);
            }
            double power = Math.pow(1+mr, month);
            if(mr==0){
                bal -= emi*month;
            }else{
                bal = bal*power - emi*(power-1)/mr;
            }
            total += emi*month;
            remaining -= month;

            if(remaining<=0) break;
            
        }
        return total;
    }
}
