package streamss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class stream {

	public static void main(String[] args)
	
	
	
//	, Object[] testStrings)
{
//		System.out.println(Stream.of(1,2, 3, 4, 5, 6, 7, 8)
//	             .filter(n -> {
////	                 System.out.println("filter " + n);
//	                 return n % 2 == 0;
//	              }));
	             
	     		
//		int valeur =
		
		
//		Stream.of(1,2,4,6,8).filter(n->n<6).forEach(System.out::println);
//		Stream.of(1,2,4,6,8).filter(n->n>6).forEach(System.out::println);
		
		System.out.println(Stream.of(1,2,4,6,8).max(Integer::compareTo).get());
		
		System.out.println(Stream.of(1,2,4,6,10).mapToInt((x)->x).average().getAsDouble());
//		Stream.of(1,2, 3, 4, 5, 6, 7, 8).map(n ->  n % 2 ==0).forEach(System.out::println);

//		Stream.of(9,8,7).forEach(System.out::println);
//		
//		System.out.println(Stream.of(9,8,7).min(Integer::compareTo).get());
//		
//		System.out.println(Stream.of(9,8,7).mapToInt((x)->x).average().getAsDouble());
//			
//		System.out.println(Stream.of(9,8,7).anyMatch((x)->x>10));
//		System.out.println("hello");
//		System.out.println(Stream.of(9,8,7));
//		Arrays.sort(testStrings,(String s1,String s2)->{return(s1.length()-s2.length());}
		
//				);
		
		
		
		

//	    System.out.println(valeur);
//		 List<Personne> personnes = new ArrayList<>(6);
//		    personnes.add(new Personne("p1", Genre.HOMME, 176));
//		    personnes.add(new Personne("p2", Genre.HOMME, 190));
//		    personnes.add(new Personne("p3", Genre.FEMME, 172));
//		    personnes.add(new Personne("p4", Genre.FEMME, 162));
//		    personnes.add(new Personne("p5", Genre.HOMME, 176));
//		    personnes.add(new Personne("p6", Genre.FEMME, 168));
//		    
//		    resultat = personnes
//		      .stream()
//		      .filter(p -> p.getGenre() == Genre.FEMME)
//		      .mapToInt(p -> p.getTaille())
//		      .average()
//		      .getAsDouble();
//		    System.out.println("Taille moyenne des femmes = " + resultat);
//		
		
	
	}
	
}
