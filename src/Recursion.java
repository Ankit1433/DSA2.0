import java.util.ArrayList;
import java.util.List;

class Recursion{

    static public void rec1(int a){
        if(a==0){
            return;
        }
        System.out.printf("%d%n" ,a);
        rec1(a-1);

    }

    //sum using recursion
    static public int rec_sum(int a){

        if(a==0){
            return a;
        }
        return a+rec_sum(a-1);
    }

//Palindrome Check using Recursion
static public boolean palindromecheck(String a,int i,int j){
   if (i>=j){
       return true;
   }
   if(a.charAt(i)!=a.charAt(j)){
      return false;
   }
   return palindromecheck(a,i+1,j-1);

}

    // sum of its digits using recursion.

    static public int sumofdigits(int i){
        if(i==0){
            return 0;
        }
        return (i%10)+sumofdigits(i/10);
    }
    //rope cutting problem

    static public int ropecut(int n,int a,int b,int c){
        if(n==0){
            return 0;
        }
        if(n<0){
        return -1;}

        int res= Math.max(ropecut(n-a,a,b,c),
               Math.max(ropecut(n-b,a,b,c),ropecut(n-c,a,b,c))
        );
        if(res==-1){
            return -1;
        }
        return res+1;

    }
    public static List<List<Character>> generateSubsets(char[] arr){
        List<Character> current=new ArrayList<>();
        List<List<Character>> result=new ArrayList<>();
        powersetwise(arr,0,current,result);
        return result;
    }
    static  public  void powersetwise(char[] arr,int index,List<Character> curr,List<List<Character>> result){
            int n=arr.length;
            if(index==n)
            {
                result.add(new ArrayList<>(curr));
                return;
            }
            powersetwise(arr,index+1,curr,result);
            curr.add(arr[index] );
            powersetwise(arr,index+1,curr,result);
            curr.removeLast();
    }

    static  void towerOfHanoi(int arr,char from_rod,char to_rod,char aux_rod){
      if (arr==0){return;}
        towerOfHanoi(arr-1,from_rod,aux_rod,to_rod);
        System.out.println(" Move disk "+arr + " from rod "+ from_rod+" to rod "+to_rod);
        towerOfHanoi(arr-1,aux_rod,to_rod,from_rod);
    }

    static  int josephus(int n,int K){
        if(n==1){
            return 1;
        }
        return (josephus(n-1,K) + K-1 ) % n + 1;
    }

static  void printallpermutations(){
}

static  public String swap(String s,int i,int j){
        char[] arr=s.toCharArray();
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return String.valueOf(arr);
}

    public static void main(String[] args) {

//        System.out.println(rope cut(5,2,1,5));
        System.out.println("hy");
        String a="rand";
        char[] arr=a.toCharArray();
        System.out.println(swap(a,1,3));

  //        for (char i:arr){
 //            System.out.println(i);
 //        }

    }
}
