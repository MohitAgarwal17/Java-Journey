import java.util.Scanner;
public class countInversions
{
        public static int mergeSort(int[] arr,int[]temp, int low, int high)
        {
            int c=0;
            if (low >= high)
            {
                return c;
            }
            int mid = (low + high)/ 2;
            c+= mergeSort(arr,temp, low, mid);
            c+= mergeSort(arr,temp, mid + 1, high);
            c += merge(arr,temp, low, mid, high);
            return c;
        }
        static int merge(int[] arr, int[] temp, int low, int mid, int high)
        {
            int left=low;
            int right=mid+1;
            int i=low;
            int c=0;
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
                    c+=(mid-left+1);
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
            return c;
        }
        public static int numberOfInversions(int[] a, int[] temp, int n) {
            return mergeSort(a, temp,0, n - 1);
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
            int c= numberOfInversions(arr,temp, arr.length);
            System.out.println("The number of inversions are: " + c);
            System.out.println("After sorting array: ");
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

}