import java.util.HashMap;

public class Bitwise {

    //isAnagram
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> h=new HashMap<>();

        for(char c:s.toCharArray()){
            h.put(c,h.getOrDefault(c,0)+1);
        }
        for(char c:t.toCharArray()){
            h.put(c,h.getOrDefault(c,0)-1);
        }

        for (int i:h.values()){
            if(i!=0){return  false;}
        }
        return true;
    }

    static  public boolean tocheckoddoreven(int a){
        if((a^1)==0){
            return  true;
        }
        else {
            return false;
        }
    }

    //to swap two numbers;

    static  public void swap(int a, int b){
    a^=b;
    b^=a;
    a^=b;
        System.out.println("A:"+a+" "+ "b:"+b);
    }

   // Problem 1: Given a number N, the task is to check whether the given number is a power of 2 or not.
    static  public  boolean tocheckpowerof2(int a){
        int b=a-1;
        if((a&b)==0){
            return true;
        }
        else {
            return  false;
        }
    }

    //Problem 2:  Given a number N, find the most significant set bit in the given number.
    static  public  double tofindmsbset(int a){
        int res=0;
        while (a>1){
            a=a>>2;
            res++;
        }
        return Math.pow(2,res);
    }

  //  Problem 3: Given a number N, the task is to find the XOR of all numbers from 1 to N.
  static  public  int xorofall(int a){
        int b=0;
      for (int i = 1; i <= a; i++) {
          b=i^(b);
      }
      return b;
  }

  // Problem 4: Given a number n, check if the Kth bit of n is set or not.
  static  public  int kthbit(int a,int n){
      int b;
     b=1<<(a-1);
     if((n&b)!=0){
         return 1;
     }
     else {
         return 0;
     }

  }

  // Problem 5: Write an efficient program to count the number of 1s in the binary representation of an integer.
  static  public  int count1s(int a){
        int count = 0;
      while (a>0){
          a=a&(a-1);
      count++;
      }
        return count;
  }
//power of 2
    static  public  int pow2(int a){
        if( (a&(a-1))==0){
            return 1;
        }
        else {
            return 0;
        }
    }

//ONE/two odd occurring
static  public  void twooddoccur(int[] a){
    HashMap<Integer,Integer> h1=new HashMap<>();
    int i=0;
    while (i!=a.length){
        h1.put(a[i],h1.getOrDefault(a[i],0)+1);
        i++;
    }
    for (int j :  h1.keySet()) {
        if((h1.get(j) %2) != 0){
            System.out.println(j);
        }
    }
    }

    //Power Set using Bitwise
    static  public  void powersetwise(char[] aw){
        int n=aw.length;
        int p =1<<n;
        for (int mask = 0; mask < p; mask++) {
            System.out.print('{');
          for(int i=0;i<n;i++){
              if((mask & (1<<i))!=0){
                  System.out.print(aw[i]+" ");
              }
          }
            System.out.println('}');
        }
}

    //maximum and
    static  public  int maxand(int[] aw){
                int maxval=0;
        for (int i = 0; i < aw.length; i++) {
            for (int j = i+1; j < aw.length; j++) {
                int temp=aw[i]&aw[j];

              maxval= Math.max(temp,maxval);
            }
        }
        return maxval;
    }




    public static void main(String[] args) {
        String s = "jar", t = "jam";
        Bitwise solution = new Bitwise();
        int a=23,b=13;
/*      bitwise-operations
//        System.out.println(a|b);
//        System.out.println(a&b);
//        System.out.println(a^b);
//        System.out.println(~a);
//        System.out.println(a<<2);
//        System.out.println(a>>2);
 */

        char[] xe={'a','b','c'};
        powersetwise(xe);

    }
}


/* hyy*/
