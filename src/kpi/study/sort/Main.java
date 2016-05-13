package kpi.study.sort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] a=new int[]{8,4,2,0,9,1,3,6,5,7};
        //SelectionSort(a);
        //QuickSort(a,0,a.length-1);
        //ShellSort(a);
        HeapSort(a);
        //InsertionSort(a);
        //BubbleSort(a);
        //MergeSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    public static void BubbleSort(int[] a){
        for (int i=a.length-1;i>0;i--){
            for (int j=0;j<i;j++){
                if (a[j]>a[j+1]){
                    int tmp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=tmp;
                }
            }
        }

    }
    public static void InsertionSort(int[] a){
        int i,j,value;
        for (i=1;i<a.length;i++){
            value=a[i];
            for (j=i-1;j>=0 && a[j]>value;j--){
                a[j+1] = a[j];
            }
            a[j+1]=value;
        }
    }

    public static void SelectionSort(int[] a){
        for(int i=0;i<a.length;i++){
            int min_i=i;
            for(int j=i+1;j<a.length;j++){
                if (a[j] < a[min_i]){
                    min_i=j;
                }
            }
            int temp=a[i];
            a[i]=a[min_i];
            a[min_i]=temp;
        }
    }

    public static void MergeSort(int[] a,int low,int high){
        int mid;
        if (low<high){
            mid=(low+high)/2;
            MergeSort(a,low,mid);
            MergeSort(a,mid+1,high);
            merge(a,low,mid,high);
        }
    }
    public static void QuickSort(int[] a, int first, int last)
    {
        int i = first, j = last, x = a[(first + last) / 2];
        do {
            while (a[i] < x) i++;
            while (a[j] > x) j--;

            if(i <= j) {
                if (i < j){
                    int tmp=a[j];
                    a[j]=a[i];
                    a[i]=tmp;}
                i++;
                j--;
            }
        } while (i <= j);
        if (i < last)
            QuickSort(a, i, last);
        if (first < j)
            QuickSort(a, first,j);
    }
    public static void ShellSort(int[] a){
        int i,t,j,k;
        for(k = a.length/2; k > 0; k /=2)
            for(i = k; i < a.length; i+=1)
            {
                t = a[i];
                for(j = i; j>=k; j-=k)
                {
                    if(t < a[j-k])
                        a[j] = a[j-k];
                    else
                        break;
                }
                a[j] = t;
            }
    }


    public static void HeapSort(int[] a)
    {
        int i;
        int temp;
        for (i = a.length / 2 - 1; i >= 0; i--)
        {
            shiftDown(a, i, a.length);
        }
        for (i = a.length - 1; i >= 1; i--)
        {
            temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            shiftDown(a, 0, i);
        }
    }
    //util functions
    static void shiftDown(int[] a, int i, int j)
    {
        boolean done = false;
        int maxChild;
        int temp;

        while ((i * 2 + 1 < j) && (!done))
        {
            if (i * 2 + 1 == j - 1)
                maxChild = i * 2 + 1;
            else if (a[i * 2 + 1] > a[i * 2 + 2])
                maxChild = i * 2 + 1;
            else
                maxChild = i * 2 + 2;

            if (a[i] < a[maxChild])
            {
                temp = a[i];
                a[i] = a[maxChild];
                a[maxChild] = temp;
                i = maxChild;
            }
            else
            {
                done = true;
            }
        }
    }
    public static void merge(int[] a,int low,int mid,int high){
        int[] b= new int[high+1-low];
        int h,i,j,k;
        h=low;
        i=0;
        j=mid+1;
        while((h<=mid)&&(j<=high))
        {
            if(a[h]<=a[j])
            {
                b[i]=a[h];
                h++;
            }
            else
            {
                b[i]=a[j];
                j++;
            }
            i++;
        }
        if(h>mid)
        {
            for(k=j;k<=high;k++)
            {
                b[i]=a[k];
                i++;
            }
        }
        else
        {
            for(k=h;k<=mid;k++)
            {
                b[i]=a[k];
                i++;
            }
        }
        for(k=0;k<=high-low;k++)
        {
            a[k+low]=b[k];
        }
    }
}
