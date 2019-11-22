package tasks;

import common.Person;
import common.PersonService;
import common.Task;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Задача 1
Метод на входе принимает List<Integer> id людей, ходит за ними в сервис (он выдает несортированный Set<Person>)
нужно их отсортировать в том же порядке, что и переданные id.
Оценить асимпотику работы
 */
public class Task1 implements Task {

  // !!! Редактируйте этот метод !!!
  private List<Person> findOrderedPersons(List<Integer> personIds) {
    Set<Person> persons = PersonService.findPersons(personIds);

    //Мапа строится за линию, так как вставка происходит за O(1)
    Map<Integer, Person> personMap = persons.stream()
        .collect(Collectors.toMap(Person::getId, Function.identity()));

    //Аналогично, получение элемента из мапы происходит за O(1), тогда составление финального списка занимает тоже O(n)
    return personIds.stream()
        .map(personMap::get)
        .collect(Collectors.toList());

    //Следовательно итоговая асимптотика - O(n)
  }

  @Override
  public boolean check() {
    List<Integer> ids = List.of(1, 2, 3);

    return findOrderedPersons(ids).stream()
        .map(Person::getId)
        .collect(Collectors.toList())
        .equals(ids);
  }

}
