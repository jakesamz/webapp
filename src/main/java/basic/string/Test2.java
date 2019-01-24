package basic.string;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Test2 {

    public static void main(String args[]) {
        String x = "a";
        
        String y = "y";
        
        String r = x + "a" + "b" + "c" + y;
        
        String z = "a";
        
        z += "b";
        
        z += "c";
        
        z += "d";
        
        /*System.out.println(x == z);
        
        String s1 = "a";
        
        String s2 = "b";
        
        System.out.println(s1 + s2 == "ab");
        
        String a = "ab";
        
        String b = "ab";
        
        System.out.println(a == b);*/
        
      /* StringBuilder sb = new StringBuilder("ttt");
        sb.append("xx");
        sb.append("b");
        sb.append("c");*/
        //System.out.println(ab == v_ab);
        
        Entity xx = new Entity();
        Entity.Inner student = xx.new Inner();
        student.setLastName("Tonx");
        System.out.println(ReflectionToStringBuilder.toString(student));
    }
}


class Entity{
	protected String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	class Inner{
		protected String lastName;
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
	}
}
