import com.sun.org.apache.xpath.internal.operations.Operation;

import java.util.Stack;

public class Evaluate {
    static char Precede(char a,char b){
        int i,j;
        char[][] table={
                {' ','+','-','*','/','(',')','='},
                {'+','>','>','<','<','<','>','>'},
                {'-','>','>','<','<','<','>','>'},
                {'*','>','>','>','>','<','>','>'},
                {'/','>','>','>','>','<','>','>'},
                {'(','<','<','<','<','<','=',' '},
                {')','>','>','>','>',' ','>','>'},
                {'=','<','<','<','<','<',' ','='}};
        for(i=0;i<8;i++){
            if(table[0][i] == a)
                break;
        }
        for(j=0;j<8;j++){
            if(table[j][0] == b)
                break;
        }
        return table[i][j];
    }
    static double operate(double a,char theta,double b){
        switch (theta){
            case '+':return a + b;
            case '-':return a - b;
            case '*':return a * b;
            case '/':return a / b;
        }
        return 0;
    }
    public static double EvaluateExpress(String getchar){
        String[] opnd = Opera_num.getNum(getchar);
        String optr = Op.getOpera(getchar);
        Stack<Character> OPTR = new Stack<Character>();
        Stack<Double> OPND = new Stack<Double>();
        OPTR.push('=');
        int OPND_pos = 0;
        int OPTR_pos = 0;
        int OPTR_len = optr.length();
        int OPND_len = opnd.length;
        boolean flag = true;
        while(OPTR_pos < OPTR_len || OPTR.peek()!='='){
            if(flag) {
                if(opnd[OPND_pos].equals(""))
                    OPND_pos++;
                OPND.push(Double.parseDouble(opnd[OPND_pos++]));
                flag = false;
                continue;
            }
            else {
                switch (Precede(OPTR.peek(),optr.charAt(OPTR_pos))){
                    case '<':
                        OPTR.push(optr.charAt(OPTR_pos++));
                        flag = true;
                            if((optr.charAt(OPTR_pos) == ')'))
                                flag = false;
                        break;
                    case '=':
                        if((optr.charAt(OPTR_pos) != '=')) {
                            flag = true;
                            OPTR.pop();
                        }
                        if((optr.charAt(OPTR_pos) == ')')){
                            flag = false;
                        }
                        OPTR_pos++;
                        break;
                    case '>':
                        double b = OPND.pop();
                        double a = OPND.pop();
                        char theta = OPTR.peek();
                        OPND.push(operate(a,theta,b));
                        OPTR.pop();
                        flag = false;
                        break;
                }
            }
        }
        return OPND.peek();
    }
}
