import java.util.ArrayList;

public class PhonePad {
    public static void main(String[] args) {
        // pad("" , "12");
        // ArrayList<String> ans = Pad("" , "12");
        // System.out.println(ans);
        System.out.println(padCount("", "12"));
    }

    static void pad(String p , String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0) - '0';  //this will convert '2' to 2;

        for( int i = (digit - 1) * 3 ; i < digit * 3 ; i++ ) {
            char ch = (char)('a' + i);
            pad(p + ch, up.substring(1));
        }
    }

    //using array list  
    static ArrayList<String> Pad(String p , String up) {
        if(up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        
        int digit = up.charAt(0) - '0';  //this will convert '2' to 2;
        
        ArrayList<String> list = new ArrayList<>();
        for( int i = (digit - 1) * 3 ; i < digit * 3 ; i++ ) {
            char ch = (char)('a' + i);
            list.addAll(Pad(p + ch, up.substring(1)));
        }
        return list;
    }

    static int padCount(String p , String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return 1;
        }

        int digit = up.charAt(0) - '0';  //this will convert '2' to 2;

        int count = 0;
        for( int i = (digit - 1) * 3 ; i < digit * 3 ; i++ ) {
            char ch = (char)('a' + i);
            count = count +padCount(p + ch, up.substring(1));
        }
        return count;
    }
}
