package Practice_Day2;

import java.util.*;

public class Practice {
	public static void main(String[] args) {

		List<Person> ll = new ArrayList<>();

		ll.add(new Person("Akash", 172, 32));
		ll.add(new Person("Ayush", 170, 25));
		ll.add(new Person("Akshat", 180, 30));
		ll.add(new Person("Ashish", 160, 22));
		ll.add(new Person("Basant", 160, 32));
		ll.add(new Person("Arnav", 160, 32));
		ll.add(new Person("Arun", 175, 28));

		Collections.sort(ll,
				(a, b) -> a.h == b.h ? a.age == b.age ? a.name.compareTo(b.name) : a.age - b.age : a.h - b.h);

		for (Person p : ll) {
			System.out.println(p);
		}
	}

	static class Person {
		String name;
		int h;
		int age;

		public Person(String name, int h, int age) {
			this.name = name;
			this.h = h;
			this.age = age;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.name + "->" + this.h + "->" + this.age;
		}
	}
}
