import java.util.Scanner;

public class Calculator {
    public static void main(String[] args){
        String temp;
        Scanner in = new Scanner(System.in);
        temp = in.next();
        System.out.print(Evaluate.EvaluateExpress(temp));
    }
}
