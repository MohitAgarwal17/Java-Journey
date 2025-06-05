import java.util.*;
class Merge
{
    public static void mergeSort(int[] arr,int[]temp, int low, int high)
    {
        if (low >= high)
        {
            return;
        }
        int mid = (low + high)/ 2;
        mergeSort(arr,temp, low, mid);
        mergeSort(arr,temp, mid + 1, high);
        if (arr[mid] <= arr[mid + 1])
        {
            return;
        }
        merge(arr,temp, low, mid, high);
    }
    public static void merge(int[] arr,int[] temp, int low, int mid, int high)
    {
        int left=low;
        int right=mid+1;
        int i=low;
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
        System.arraycopy(temp,low, arr, low, high-low+1);
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
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
        System.out.println("After sorting array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}

