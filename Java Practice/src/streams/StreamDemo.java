package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
	public static void main(String[] args) {
		List<List<Integer>> list = Arrays.asList(Arrays.asList(3,1,1,5,6,8),Arrays.asList(3,6,1,7,2,8));
		
//		Stream<Integer> stream = list.stream();
//		list.parallelStream();
		
//		long count = stream.count();
//		System.out.println(count);
//		stream.forEach(System.out::println);
		
//		Stream<Integer> sortedStream = stream.sorted();
//		sortedStream.forEach(System.out::println);

//		Stream<Integer> mappedData = stream.map(n -> n*2);
//		mappedData.forEach(System.out::println);
		
		list.stream()
			.flatMap(l -> l.stream())
			.filter(n -> n%2 != 0)
			.sorted()
			.map(n -> n*n)
			.distinct()
			.forEach(System.out::println);
		
		List<String> stringList = Arrays.asList("Java is fun","Steams are little nice");
		
		List<String> words =  stringList.stream()
				.peek(System.out::println)
				  .flatMap(s -> Arrays.stream(s.split(" ")))
				  .peek(System.out::println)
				  .collect(Collectors.toList());	
		
		System.out.println(words);
		
	}
}
