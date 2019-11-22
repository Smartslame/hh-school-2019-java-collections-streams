package tasks;

import common.Person;
import common.Task;

import java.time.Instant;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
А теперь о горьком
Всем придется читать код
А некоторым придется читать код, написанный мною
Сочувствую им
Спасите будущих жертв, и исправьте здесь все, что вам не по душе!
P.S. функции тут разные и рабочие (наверное), но вот их понятность и эффективность страдает (аж пришлось писать комменты)
P.P.S Здесь ваши правки желательно прокомментировать (можно на гитхабе в пулл реквесте)
 */
public class Task8 implements Task {


    //Не хотим выдывать апи нашу фальшивую персону, поэтому конвертим начиная со второй
    //Не будем удалять персону, а просто пропустим ее. Она ведь может потом пригодится + обернул все в стрим
    public List<String> getNames(List<Person> persons) {
        return persons.stream()
                .skip(1)
                .map(Person::getFirstName)
                .collect(Collectors.toList());
    }

    //ну и различные имена тоже хочется
    //Не нужен здесь стрим, просто используем конструктор HashSet
    public Set<String> getDifferentNames(List<Person> persons) {
        return new HashSet<>(getNames(persons));
    }

    //Для фронтов выдадим полное имя, а то сами не могут
    //Перейдем на StringBuilder, должно работать быстрее + не будет создавать промежуточных строк.
    //По-хорошему можно было бы toString у персоны переопределить
    public String convertPersonToString(Person person) {
        StringBuilder result = new StringBuilder();
        if (person.getSecondName() != null) {
            result.append(person.getSecondName());
        }

        if (person.getFirstName() != null) {
            result.append(" ");
            result.append(person.getFirstName());
        }

        if (person.getSecondName() != null) {
            result.append(" ");
            result.append(person.getSecondName());
        }
        return result.toString();
    }

    // словарь id персоны -> ее имя
    // Уменьшил количество кода, увеличили читаемость и понятность
    public Map<Integer, String> getPersonNames(Collection<Person> persons) {
        return persons.stream().collect(Collectors.toMap(Person::getId, this::convertPersonToString));
    }

    // есть ли совпадающие в двух коллекциях персоны?
    // Создадим Set от первой коллецкии и потом в ней будем искать персону из второй коллекции.
    // Отработаем за O(n) вместо O(n^2)
    public boolean hasSamePersons(Collection<Person> persons1, Collection<Person> persons2) {
        Set<Person> firstPersonSet = new HashSet<>(persons1);

        for (Person person : persons2) {
            if (firstPersonSet.contains(person)) {
                return true;
            }
        }

        return false;
    }

    //Выглядит вроде неплохо...
    // Не за чем хранить переменную count, стрим умеет считать количество элементов
    public long countEven(Stream<Integer> numbers) {
        return numbers.filter(num -> num % 2 == 0).count();
    }

    // Жду комментов
    @Override
    public boolean check() {
        System.out.println("Слабо дойти до сюда и исправить Fail этой таски?");
        boolean codeSmellsGood = false;
        boolean reviewerDrunk = false;
        return codeSmellsGood || reviewerDrunk;
    }
}
