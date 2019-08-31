import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentUtil {

	private static Student[] arrayOfEmps = {
		    new Student("Jeff Hardy", 30, BigDecimal.valueOf(100000d)), 
		    new Student("Mark Henry", 31, BigDecimal.valueOf(200000d)), 
		    new Student("Mark Zuckerberg", 33, BigDecimal.valueOf(250000d)),
		    new Student("David Miller", 28, BigDecimal.valueOf(300000d)),
		    new Student("Jeff Martin", 29, BigDecimal.valueOf(400000d))
	};
	
	
	public static Student findByAge(Integer age) {
		
		Stream<Student> stream = Arrays.asList(arrayOfEmps).stream();
		List<Student> retStd = stream.filter(std -> std.getAge().equals(age)).collect(Collectors.toList());
		
		return retStd.get(0);
	}
	
	public static void printNames(String name) {
		
		System.out.println("Name: " + name);
	}
}
