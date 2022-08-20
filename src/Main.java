import java.util.*;

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
        filter
    }
}