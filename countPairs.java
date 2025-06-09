import java.util.Scanner;

public class countPairs {
    public static int mergeSort(int[] arr, int low, int high)
    {
        int c=0;
        if(low>=high) return c;
        int mid=(low+high)/2;
        c=c+ mergeSort(arr,low,mid);
        c=c+ mergeSort(arr,mid+1,high);
        c=c+ countPairs1(arr,low,mid,high);
        merge(arr,low,mid,high);
        return c;
    }
    public static int countPairs1(int[] arr,int low,int mid,int high)
    {
        int right=mid+1;
        int c=0;
        for(int i=low;i<=mid;i++)
        {
            while(right <= high && arr[i] > 2L*arr[right])
            {
                right++;
            }
            c=c+(right-(mid+1));
        }
        return c;
    }
    public static void merge(int[] arr,int low,int mid,int high)
    {
        int left=low;
        int right=mid+1;
        int[] temp =new int[high-low+1];
        int i=0;
        while(left<=mid && right<=high)
        {
            if(arr[left]<=arr[right])
            {
                temp[i++]=arr[left];
                left++;
            }
            else
            {
                temp[i++]=arr[right];
                right++;
            }
        }
        while(left<=mid)
        {
            temp[i++]=arr[left];
            left++;
        }
        while(right<=high)
        {
            temp[i++]=arr[right];
            right++;
        }
        System.arraycopy(temp,0, arr, low, high-low+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        System.out.println("Enter Elements in the array");
        int[] arr =new int[n];
        for(int i=0; i<n; i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("Before sorting array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int c= mergeSort(arr,0, arr.length-1);
        System.out.println("The number of inversions are: " + c);
        System.out.println("After sorting array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
