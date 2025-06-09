import java.util.*;
class mergeVector
{
    public static void sortArray(int[] array)
    {
        Vector<Integer> arr=new Vector<>();
        for(int num: array)
        {
            arr.add(num);
        }
        mergeSort(arr, 0, array.length-1);
        /* for(int i=0; i<array.length;i++)//used to convert vector to integer array to return array as int
        {
            array[i]=arr.get(i);
        } */
    }
     private static void mergeSort(Vector<Integer> arr, int low, int high) 
     {
        if (low >= high) 
        {
            return;
        }
        int mid = (low + high)/ 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }
    private static void merge(Vector<Integer> arr, int low, int mid, int high) 
    {
        Vector<Integer> temp=new Vector<>();
        int left=low;
        int right=mid+1;
        while(left<=mid && right<=high)
        {
            if(arr.get(left)<=arr.get(right))
            {
                temp.add(arr.get(left));
                left++;
            }
            else
            {
                temp.add(arr.get(right));
                right++;
            }
        }
        while(left<=mid)
        {
            temp.add(arr.get(left));
                left++;
        }
        while(right<=high)
        {
            temp.add(arr.get(right));
            right++;
        }
        for(int i=0; i<temp.size(); i++)
        {
            arr.set(i+low,temp.get(i));
        }
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
        sortArray(arr);
        System.out.println("After sorting array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
