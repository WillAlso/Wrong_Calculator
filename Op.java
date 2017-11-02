import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Op {
    public static String getOpera(String temp){
        StringBuffer temp2 = new StringBuffer();
        Pattern p = Pattern.compile("[+*()=/-]");
        Matcher m = p.matcher(temp);
        while(m.find()) {
            temp2.append(m.group());
        }
        return temp2.toString();
    }
}
