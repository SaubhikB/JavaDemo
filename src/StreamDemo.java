import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {

		Student[] arrayOfEmps = {
			    new Student("Jeff Hardy", 30, BigDecimal.valueOf(100000d)), 
			    new Student("Mark Henry", 30, BigDecimal.valueOf(200000d)), 
			    new Student("Mark Zuckerberg", 33, BigDecimal.valueOf(250000d)),
			    new Student("David Miller", 28, BigDecimal.valueOf(300000d)),
			    new Student("Jeff Martin", 28, BigDecimal.valueOf(400000d))
		};
		
		Stream<Student> stream = null;
		//Filter
		
		  stream = Arrays.asList(arrayOfEmps).stream(); 
		  Set<Student> stdSet = stream.filter(std -> std.getAge() >=
		  30).collect(Collectors.toSet()); System.out.println(stdSet);
		 
		
		//Map Ex
		
		  Stream<Integer> ageStr = Stream.of(30, 31, 33); List<Student> listStd =
		  ageStr.map(StudentUtil :: findByAge).collect(Collectors.toList());
		  System.out.println(listStd);
		 
		
		//FindFirst //Here Lazy-evaluation happens means This first processes Student with Age30 then with age 31. 
		//Then doest not process more element from Stream as FindFirst get result in Student with Age 31.
		
		  stream = Arrays.asList(arrayOfEmps).stream();
		  Optional<Student> stdFirst = stream.filter(std -> std.getAge() >
		  30).findFirst(); System.out.println(stdFirst.get());
		 
		
		//FlatMap
		
		  List<List<String>> namesNested = Arrays.asList( Arrays.asList("Jeff",
		  "Bezos"), Arrays.asList("Bill", "Gates"), Arrays.asList("Mark",
		  "Zuckerberg"));
		  
		  List<String> finalList = namesNested.stream().flatMap(Collection ::
		  stream).collect(Collectors.toList()); System.out.println(finalList);
		 
		
		//Infinite Stream
		
		  Stream<Integer> streamInfinite = Stream.iterate(2, i -> i*2);
		  
		  List<Integer> listInt =
		  streamInfinite.skip(2).limit(5).collect(Collectors.toList());
		  System.out.println(listInt);
		 
		
		//Sorted
		
		  stream = Arrays.asList(arrayOfEmps).stream(); Stream<Student>
		  stream2 = Arrays.asList(arrayOfEmps).stream(); List<Student> sortedByName =
		  stream.sorted((std1, std2) ->
		  std1.getName().compareTo(std2.getName())).collect(Collectors.toList());
		  List<Student> sortedByAge = stream2.sorted((e1, e2) ->
		  e1.getAge().compareTo(e2.getAge())).collect(Collectors.toList());
		  
		  System.out.println(sortedByName); System.out.println(sortedByAge);
		 
		
		//Reduce
		
		
		  stream = Arrays.asList(arrayOfEmps).stream(); Double totVal =
		  stream.map(Student :: getPropValue).map(BigDecimal ::
		  doubleValue).reduce(0.0, Double :: sum); System.out.println(totVal);
		 
		 
		
		
		//PartitioningBy
		
		  stream = Arrays.asList(arrayOfEmps).stream(); Map<Boolean,
		  List<Integer>> mapStd = stream.map(Student ::
		  getAge).collect(Collectors.partitioningBy(x -> x > 30));
		  System.out.println(mapStd);
		 
		
		//GroupingBy
		
		  stream = Arrays.asList(arrayOfEmps).stream(); Map<Integer,
		  List<Student>> grpStdByAge = stream.collect(Collectors.groupingBy(std ->
		  std.getAge())); System.out.println(grpStdByAge);
		 
		
		//Consumer Implementation
		
		  Consumer<String> consumer = StudentUtil :: printNames;
		  consumer.accept("abc"); consumer.accept("xyz"); consumer.accept("qwe");
		  
		  stream = Arrays.asList(arrayOfEmps).stream(); stream.map(std
		  -> std.getName()).forEach(StudentUtil :: printNames);
		 
		
		//Supplier Implementation
		  Supplier<Double> supplier = () -> {
		  return Math.random(); };
		  System.out.println(supplier.get()); 
		  System.out.println(supplier.get());
		  System.out.println(supplier.get());
		 
	}

}
