public class Opera_num {
    public static String[] getNum(String temp){
        String temp2 = temp.replaceAll(" ","");
        System.out.println(temp2);
        String[] num = temp2.split("[+*()=/-]");
        return num;
    }
}
