import java.util.Arrays;

public class searching {

    static  int binarySearch(int[] arr,int x,int low,int high){
        while (low<=high){
            int mid= (low+((high-low)/2));

            if(arr[mid]==x){
                return mid;
            } else if (x<arr[mid]) {
                high=mid-1;
            } else {
                low=mid+1;
            }

        }
return -1;

    }

//Ternary Search
    static  int ternarySearch(int l,int r,int key,int[]arr){
        int mid1=l+(r-l)/3;
        int mid2=r-(r-l)/3;

        if(arr[mid1]==key){
            return mid1;
        }
        if (arr[mid2] == key) {
            return mid2;
        }

        if (key<arr[mid1]){
           return ternarySearch(l,mid1-1,key,arr);
        }
        else if (key>arr[mid2]){
           return ternarySearch(mid2+1,r,key,arr);
        }
        else {
            return ternarySearch(mid1+1,mid2-1,key,arr);
        }

    }

    //Problem #1 : Missing and Repeating Number
    static    void findmiss(int[] arr){
    Arrays.sort(arr);
    int repeating=-1;
    int missing=-1;

        for (int i = 1; i < arr.length; i++) {
            if(arr[i]==arr[i-1]){
                repeating=arr[i];
            }
            if(arr[i]>=arr[i-1]+1){
                missing=(arr[i-1]+1);
            }
        }
        if(missing==-1)
        {
        missing=arr.length;
        }
        System.out.println("repeating: "+repeating);
        System.out.println("missing: "+missing);
    }

    static  void findmissusingxor(int[] arr) {
        int n = arr.length;
        int xor = 0;
        for (int j : arr) {
            xor ^= j;
        }
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }

        int righmost = xor & (-xor);

        int bucket1 = 0, bucket2 = 0;

        for (int val : arr) {
            if ((val & righmost) != 0) {
                bucket1 ^= val;
            } else {
                bucket2 ^= val;
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((i & righmost) != 0) {
                bucket1 ^= i;
            } else {
                bucket2 ^= i;
            }
        }

        int repeating = -1, missing = -1;
        for (int val : arr) {
    if(val==bucket1){
        repeating=val;
        missing=bucket2;
        break;
    }
    else if(val==bucket2){
        repeating=val;
        missing=bucket2;
    }
        }
        System.out.println("Repeating = " + repeating);
        System.out.println("Missing = " + missing);
    }

    //Problem #2 : Find the index of first 1 in a sorted array of 0’s and 1’s

    static int findfirstindexof1(int[]arr){
        int low=0,high= arr.length-1;
        while (low<=high){
            int mid=(low+(high-low)/2);
            if(arr[mid]==1 && (mid==0 || arr[mid-1]==0)){
                return mid;
            } else if (arr[mid]==1) {
                high=mid-1;
            }
            else {
                low=mid+1;
            }

        }
       return -1;
    }

    //Problem #4 : Find Peak element in Unsorted Array
    static int findpeak(int[] arr){
        int low=0,high=arr.length-1;

        while (low<=high){
            int mid=low+(high-low)/2;

            if ((mid==0 || arr[mid]>arr[mid-1] )  && ( mid==arr.length-1 || arr[mid]>arr[mid+1]) ){
                return  arr[mid];
            } else if ((mid<=arr.length-1 && arr[mid]<arr[mid+1])) {
                low=mid+1;
            }
            else {
                high=mid-1;
            }
        }

        return -1;
    }
    //Index of first Occurrence and last Occurrence in Sorted array
    static void findfirnlast(int[]arr,int x){
        int first=-1,last=-1;
        for (int i = 0; i < arr.length; i++) {
            if(x!=arr[i]){
                continue;
            }
            else if(first==-1){
                first=i;
            }
            last=i;
        }
        System.out.println(first+"first");
        System.out.println(last+"last");
    }


//Count Occurrences in Sorted
static int countoccur(int[]arr,int x,int l,int r){
    int first = countfirstoccur(arr, x, l, r);
    if (first == -1) return 0;             // not found -> zero occurrences
    int last = countlastoccur(arr, x, l, r);
    // last must be >= first, but guard defensively
    if (last < first) return 0;
    return last - first + 1;


}
    static int countfirstoccur(int[]arr,int x,int l,int r){

            if(l>r){
                return -1;
            }
            int mid = l + (r - l) / 2;

            if (arr[mid] == x &&(mid==0 || arr[mid-1]!=x)) {
               return mid;
            } else if (arr[mid]>=x) {
                return countfirstoccur(arr,x,l,mid-1);
            }
            return countfirstoccur(arr,x,mid+1,r);
    }
    static  int countlastoccur(int[]arr,int x,int l,int r){
        if(l>r){
            return -1;
        }
        int mid = l + (r - l) / 2;
        if(arr[mid]==x && (mid==arr.length-1 || arr[mid+1]!=x)){
            return  mid;
        } else if (arr[mid]<=x) {
            return countlastoccur(arr,x,mid+1,r);
        }
       return countlastoccur(arr,x,l,mid-1);
    }

    //Count 1s in a Sorted Binary Array

    static  int firstOne(int[] arr, int l, int r){
        if(l>r) {return -1;}

        int mid=l+(r-l)/2;

        if(arr[mid]==1 &&(arr[mid]==0 ||arr[mid-1]==0)){
            return mid;
        }
        if(arr[mid]==1){
            return firstOne(arr,l,mid-1);
        }
        return  firstOne(arr,mid+1,r);
    }
    static int countOnes(int[] arr) {
        int n = arr.length;

        int first = firstOne(arr, 0, n - 1);

        if (first == -1) return 0;   // no 1s in array

        return n - first;
    }

    //Square root
    static  int root(int x){
        for (int i = 1; i <=x; i++) {
            if(i*i==x){
                return i;
            }
            else {
                continue;
            }
        }
        return -1;
    }

    static  int binroot(int x){
        long l=0,h=x/2,ans=0;
        if(x==0||x==1){
            return x;
        }
        while (l<h) {
            long mid = l + (h - l) / 2;

            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                l = (int) (mid + 1);
                ans = mid;
            } else {
                h = mid - 1;
            }
        }
            return (int) ans;
        }


        //Search in an Infinite Sized Array
    static int findinfinele(int[]arr,int x){

        int l=0,h=1;

        while (h<arr.length && arr[h]<x) {
            l = h;
            h = h * 2;
            if (h >= arr.length) {
                h = arr.length - 1;
            }
        }
            return binarySearch(arr, x, l, h);

    }

static int  findpeakd(int[]arr){
int n=arr.length;
if(n==1){return arr[0];}
if(arr[0]>arr[1]){return arr[0];}

    for (int i = 1; i < n-1; i++) {
        if(arr[i]>arr[i-1] && arr[i]>arr[i+1]){
            return arr[i];
        }
    }
    if(arr[n-1]>arr[n-2]){return arr[n-1];}

    return -1;
}

//Median of Two Sorted Arrays
    static int findmedian(int[]arr1,int[]arr2){

        return -1;

    }


    public static void main(String[] args) {
        System.out.println(" x element occur is:");
        int a[] = {-5, 3, 6, 12, 15}, b[] = {-12, -10, -6, -3, 4, 10};
        int l=0,r=a.length-1;
        int x=10;
            System.out.println(findpeakd(a));
    }
}

