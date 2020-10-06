import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public static void main(String[] args) throws ParseException {
		Test a=new Test();
		Date today=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateFormat = sdf.format(today);
		Date rs=sdf.parse(dateFormat);
		System.out.println("Date today:"+today);
		System.out.println("dateFormat:"+dateFormat);
		System.out.println("rs:"+rs);
	}
}
