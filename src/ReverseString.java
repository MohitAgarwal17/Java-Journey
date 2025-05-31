import java.util.*;
class ReverseString
{
    void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Sentence");
        String a = sc.nextLine();
        String w = " ";
        char ch;
        for (int i = 0; i < a.length(); i++) {
            ch = a.charAt(i);
            w = ch + w;
        }
        System.out.println(w);
    }
}