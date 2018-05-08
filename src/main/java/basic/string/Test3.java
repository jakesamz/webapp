package basic.string;

import java.util.HashSet;

public class Test3 {

    public static void main(String args[]) {
        
        
       HashSet<String> s = new HashSet<>();
       StringBuilder aaa = new StringBuilder("aaa");
       s.add(aaa.toString());
       
       s.add("aaabbb");
       
       aaa.append("bbb");
       System.out.println("aaabbb".hashCode());
       //aaa.append(aaa.toString());
       System.out.println(aaa.hashCode());
       s.add(aaa.toString());
       System.out.println(aaa);
       System.out.println(s);
    }
}
