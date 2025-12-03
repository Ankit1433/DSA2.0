import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Student {
    String name;
    int roll_no;
    public  Student(int roll_no,String name){
        this.name=name;
        this.roll_no=roll_no;
    }
    public  String toString(){
        return this.name+" "+this.roll_no;
    }
}

class sortbyroll_no implements Comparator<Student>{
    public int compare(Student a,Student b){
        return a.roll_no-b.roll_no;
    }
}

public class Sorting {


    static  void insertion_sort(int[]arr){

        for (int i = 1; i <arr.length ; i++) {
            int j=i-1,key=arr[i];
            while (j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }

        for(int i:arr){
            System.out.print(i+" ");
        }
    }

    static  void bubble_sort(int[]a){
        for (int i = 0; i < a.length; i++) {
            boolean swap=false;
            for (int j = 0; j < a.length-i-1; j++) {
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                    swap=true;
                }
            }
            if(!swap){
                break;
            }
        }
        for(int i:a){
            System.out.print(i+" ");
        }
    }

    static  void selection_sort(int[]arr){
        for (int i = 0; i < arr.length-1; i++) {
            int min_idx=i;
            for (int j = i+1; j <arr.length; j++) {
                if(arr[j]<arr[min_idx]){
                min_idx=j;
                }
            }
            int temp=arr[min_idx];
            arr[min_idx]=arr[i];
            arr[i]=temp;
        }
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
//
//    static void

    public static void main(String[] args) {
        Integer[] arr={4,3,2,10,12,1,5,6};
//        Arrays.sort(arr,0,3);
//        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr,Collections.reverseOrder());
//        selection_sort(arr);
        ArrayList<Student> ar= new ArrayList<>();
        ar.add(new Student(3,"ankit"));
        ar.add(new Student(2,"raju"));

        ar.sort(new sortbyroll_no());
        for(Student s : ar) System.out.println(s);
    }
}
