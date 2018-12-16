package samples;
public class StringClassMethods 
{
	public static void main(String[] args) 
	{
		//By Using SubString() Method
		String x="FPL REG 3116864513762446";
		String y=x.substring(8);
		System.out.println(y);
		//By Using Split() Method
		String y1[]=x.split(" ");
		System.out.println(y1.length);//array size printed
		System.out.println(y1[2]);//3rd one printed
		//By Using Replace() Method
		String y2=x.replaceAll(" ","");
		System.out.println(y2);
	}

}
