import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

//    Найти количество несовершеннолетних (т.е. людей младше 18 лет).
//    Получить список фамилий призывников (т.е. мужчин от 18 и до 27 лет).
//    Получить отсортированный по фамилии список потенциально работоспособных
//    людей с высшим образованием в выборке (т.е. людей с высшим образованием
//    от 18 до 60 лет для женщин и до 65 лет для мужчин).

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
                .filter(p -> p.getAge() >= 18 & p.getAge() < 27)
                .map(Person::getFamily)
                .toList();
        Stream<Person> EducatedMan = persons.stream()
                .filter(p -> p.getEducation().equals(Education.HIGHER))
                .filter(p -> p.getSex().equals(Sex.MAN) & p.getAge() >= 18 & p.getAge() < 65);
        Stream<Person> EducatedWoman = persons.stream()
                .filter(p -> p.getEducation().equals(Education.HIGHER))
                .filter(p -> p.getSex().equals(Sex.WOMAN) & p.getAge() >= 18 & p.getAge() < 60);



    }
}
