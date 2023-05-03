# toolbox

_toolbox_ is a collection of Java libraries.

**Java modules**
- toolbox.tuple (org.spokbjorn.tuple)

## toolbox.tuple
A collection of tuples.

What this library tries to solve is the lack of generic data objects. There is Map.Entry<K, V> which is not the 
prettiest to import but other than this there is no generic data objects to use. To solve this the library contains eight
generic data objects that can be mixed with different generic values.

```java
import org.spokbjorn.tuple.Tuple;

class Example {
    public static void main(String[] args) {
        Duad<String, Boolean> duad = Tuple.of("John", true);
        System.out.printf("%s statement is %s%n", duad.first(), duad.second());
    }
}
```

```java
import org.spokbjorn.tuple.Tuple;

class Example {

    public static void main(String[] args) {
        List<Triad<String, String, Integer>> students = List.of(
                Tuple.of("John", "Programming", 75),
                Tuple.of("Jane", "History", 62),
                Tuple.of("Peter", "Math", 59));
        List<Duad<String, String>> namesWithCourse = students.stream()
                .filter(student -> student.third() >= 60)
                .map(student -> Tuple.of(student.first(), student.second()))
                .toList();
        System.out.println("Students who passed");
        namesWithCourse.forEach(student -> {
            System.out.printf("%s passed %s\n", student.first(), student.second());
        });
    }
}
```