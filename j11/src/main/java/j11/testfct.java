package j11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class testfct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println(cube.apply(3));
		//Stream.of(9,8,7).forEach(System.out::println)
	System.out.println(Stream.of("a","b","c").map((s) -> s.toUpperCase()).collect(Collectors.toList()));
		
	List<String> people=List.of("john","Maria");
	
	System.out.println(Stream.of(9,8,7).map((n)->cube.apply(n)).collect(Collectors.toList()));
	
	System.out.println(people.stream().map((s) -> s.repeat(2)).collect(Collectors.toList()));
	
	System.out.println(people.stream().map((s)->s.repeat(3)).collect(Collectors.toList()));
	
	System.out.println(Stream.of(9,8,7).map((var s) -> s*s*s).collect(Collectors.toList()));

	System.out.println(Stream.of(9,8,7).sorted().collect(Collectors.toList()));
	
	System.out.println(people.stream().map((var s) -> s.toUpperCase()).collect(Collectors.toList()));
	
	List<String> people2=List.of("john","Maria");
	
	System.out.println(people2.stream().map((s) -> s.contains("j")).collect(Collectors.toList()));
	
	
	List<Person> peopl =List.of(new Person("Maria",Gender.FEMALE),
			new Person("john",Gender.MALE),
			new Person("salima",Gender.FEMALE),
			new Person("alia",Gender.FEMALE)
			);
		
	
//	List<Person> females =new ArrayList<>();
//		for(Person person:peopl) {
//			if (Gender.FEMALE.equals(person.gender)){
//				females.add(person);
//				}
//			}
//		for(Person female:females) {
//			System.out.println	(female);
//			
//		}
		
//	peopl.stream().
//	filter(person-> Gender.FEMALE.equals(person.gender))
//	.collect(Collectors.toList())
//	.forEach(System.out::println);
	
	List<Person> females2=peopl.stream().
			filter(person-> Gender.FEMALE.equals(person.gender))
			.collect(Collectors.toList());
	females2.forEach(System.out::println);
	
	}
	
	static class Person{
		private final String name ;
		private final Gender gender ;
		public Person(String name, Gender gender) {
			super();
			this.name = name;
			this.gender = gender;
		}

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
		}
	
		enum Gender{
		MALE,FEMALE}
	static Function<Integer, Integer> cube  = (x) -> x * x * x;
}
