class recursion1 {
    static void f(int i,int n)
    {
        if(i>n)
            return;
        System.out.println(i);
        f(i+1,n);
        System.out.println(i); //backtracking prints in reverse
    }
    public static void main(String[] args) {
        int n=3;
        f(1,n);
    }
}