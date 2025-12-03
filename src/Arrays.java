import java.util.*;

public class Arrays {

    static  void pracArrays(int n){
        ArrayList<Integer> a1=new ArrayList<>(n);
        for (int i = 1; i <=n; i++) {
            a1.add(Integer.valueOf(Integer.toBinaryString(i)));
        }
        System.out.println(a1);
    }


    // Types of Array operations:
    static  int insert(int[] arr, int n, int x, int cap, int pos){
       if(n==cap){
           return n;
       }

       int idx=pos-1;
        for (int i = n-1; i >=idx; i--) {
            arr[i+1]=arr[i];
        }
        arr[idx]=x;
        return n+1;
    }
    static  int delete(int[]arr,int x,int n){
        int i;
        for (i = 0; i < n; i++) {
            if(arr[i]==x){
                break;
            }
        }
        if(i==n){
            return n;
        }
        for (int j = i; j <n-1 ; j++) {
            arr[j]=arr[j+1];
        }

        return n-1;
    }

    //Problem #1 : Range Sum Queries using Prefix Sum
    static  void sumquery(int[] arr,int l,int r){
        int n=arr.length;
        int[] prefix= new int[n];
        prefix[0]=arr[0];
        for (int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+arr[i];
        }
        if(l==0){
            System.out.println("sum:"+ prefix[r]);
        }
        else {
            System.out.println("sum:"+(prefix[r]-prefix[l-1]));
        }
    }

    //Problem #2 : Equilibrium index of an array
    static  int EquilibPoint(int[]arr){
        int leftsum=0,rightsum=0,sum=0;
        for (int j : arr) {
            sum += j;
        }

        for (int i = 0; i < arr.length; i++) {
            sum-=arr[i];
            if(leftsum==sum){
                return i;
            }
            leftsum=leftsum+arr[i];
        }
        return -1;
    }
//Problem #3 : Largest Sum Subarray
    static  void largesubarr(int[]arr){
        int maxsum=Integer.MIN_VALUE,maxsofar=0;
        for (int j : arr) {
            maxsofar += j;

            if (maxsum < maxsofar) {
                maxsum = maxsofar;
            }
            if (maxsofar < 0) {
                maxsofar = 0;
            }
        }
        System.out.println("Max sum : "+maxsum);
    }

    //Problem #4 : Merge two sorted Arrays
    static void mergetwoarr(int[] arr1,int[]arr2){
        int i=0,j=0,k=0,m=arr1.length,n=arr2.length;
        int[] arr3=new int[m+n];
        while (i<m && j<n){
            if(arr1[i]<arr2[j]){
                arr3[k++]=arr1[i++];
            }
            else {
                arr3[k++]=arr2[j++];
            }
        }
        while (i<m){arr3[k++]=arr1[i++];}
        while (j<n){arr3[k++]=arr2[j++];}

        for (int o:arr3){
            System.out.println(o);
        }
    }

    static int largest(int[]arr){
        int max=Integer.MIN_VALUE;

        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }

        return max;
    }

    static void seclargest(int[]arr){
        int l1=Integer.MIN_VALUE,l2=Integer.MIN_VALUE;
        for (int j : arr) {
            if (j > l1) {
                l2 = l1;
                l1 = j;
            } else if (j != l1 && j > l2) {
                l2 = j;
            }
        }
        System.out.println("largest element is:"+l1);
        System.out.println("2nd largest element is:"+l2);
    }

    static boolean checkifsort(int[]arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    static void revarr(int[]arr){
        int low=0,high=arr.length-1;
        while (low<high){
            int temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;
            low++;
            high--;
        }
        for (int i:arr){
            System.out.print(i+" ");
        }

    }
    static  int removdup(int[]arr){
        int res=1;
        for (int i = 1; i <arr.length ; i++) {
            if(arr[res-1]!=arr[i]){
                arr[res]=arr[i];
                res++;
            }
        }
        return res;
    }

    static void trailzeros(int[]arr){
        int res=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0 ){
             arr[res++]=arr[i];
            }
        }
        while (res<arr.length){
            arr[res++]=0;
        }
        for(int i:arr){
            System.out.print(i+" ");
        }
    }

    static void rotbyd(int[]arr,int d) {
        d=d%arr.length;
       rev(arr,0,d-1);
       rev(arr,d,arr.length-1);
       rev(arr,0,arr.length-1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
        static void rev(int[]arr,int low,int high){
            while (low<high){
                int temp=arr[low];
                arr[low]=arr[high];
                arr[high]=temp;
                low++;
                high--;
            }
        }


    static  void  leaders(int[]arr){
        Stack<Integer> st=new Stack<>();
        int leaders=arr[arr.length-1];
        st.push(leaders);
        for (int i = arr.length-2; i >=0 ; i--) {
            if(arr[i]>leaders) {
                leaders = arr[i];
               st.push(leaders);
            }
        }
        while (!st.empty()){
            System.out.println(st.pop()+" ");
        }
    }

    static int maxdiff(int[]arr){
        int sum=0,minval=Integer.MAX_VALUE;
        for (int j : arr) {
            minval = Math.min(j, minval);
            sum = Math.max(sum, j - minval);
        }
        return sum;
    }

    static void printfrequ(int[]arr){
        HashMap<Integer,Integer> h1=new HashMap<>();
        for (int j : arr) {
            h1.put(j, h1.getOrDefault(j, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : h1.entrySet()) {
            System.out.println("the frequency of " + entry.getKey() + " is : " + entry.getValue());
        }
    }

    static int stockbuysell(int[]arr){
        int sum=0;
        for (int i = 1; i <arr.length; i++) {
            if(arr[i]>arr[i-1]){
                sum+=arr[i]-arr[i-1];
            }
        }
        return sum;
    }
    static  int traprainwater(int[]arr){


        return -1;
    }

    public static void main(String[] args) {
        int[] arr={100, 180, 260, 310, 40, 535, 695};
        System.out.println(stockbuysell(arr));
    }
}
