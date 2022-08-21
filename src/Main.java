import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John", "Simon");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown", "Halfear");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        long UnderAge = persons.stream()
                .filter(p -> p.getAge() < 18)
                .count();
        List<String> Miltary = persons.stream()
                .filter(p -> p.getSex().equals(Sex.MAN))
                .filter(p -> p.getAge() >= 18 && p.getAge() < 27)
                .map(Person::getFamily)
                .toList();
        List<Person> EducatedWorkers = persons.stream()
                .filter(p -> p.getEducation().equals(Education.HIGHER))
                .filter(p -> p.getAge() >= 18)
                .filter(p -> p.getSex().equals(Sex.MAN) & p.getAge() < 65
                || (p.getSex().equals(Sex.WOMAN) & p.getAge() < 60))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
    }
}
