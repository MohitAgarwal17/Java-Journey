class recursion2 {
    static void f(int i)
    {
        if(i<1)
            return;
        System.out.println(i);
        f(i-1);
        System.out.println(i);//backtracking prints in reverse
    }
    public static void main(String[] args) {
        int n=3;
        f(n);
    }
}