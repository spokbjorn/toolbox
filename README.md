# toolbox

_toolbox_ is a collection of Java libraries.

**Java modules**

| module        | package             |
|---------------|---------------------|
| toolbox.lazy  | org.spokbjorn.lazy  |
| toolbox.tuple | org.spokbjorn.tuple |

**Gradle**

| notation            | release                                                                                                                                                         | snapshot                                                                                                                                                        |
|---------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------|
| org.spokbjorn:lazy  | ![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/r/org.spokbjorn/lazy?label=sonatype&server=https%3A%2F%2Fs01.oss.sonatype.org%2F&style=flat-square)  | ![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/s/org.spokbjorn/lazy?label=sonatype&server=https%3A%2F%2Fs01.oss.sonatype.org%2F&style=flat-square)  |
| org.spokbjorn:tuple | ![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/r/org.spokbjorn/tuple?label=sonatype&server=https%3A%2F%2Fs01.oss.sonatype.org%2F&style=flat-square) | ![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/s/org.spokbjorn/tuple?label=sonatype&server=https%3A%2F%2Fs01.oss.sonatype.org%2F&style=flat-square) |

## toolbox.lazy
A lazy value supplier.

What this library provides is a way to make Supplier provide a lazy value which is cached and reused in sequenced calls.

```java
import org.spokbjorn.lazy.Lazy;

class Example {
    public static final lazy = Lazy.of(() -> "Hello, World");
    
    public static void main(String[] main) {
        System.out.println(lazy); // out: Hello, World

        // Doesn't call the supplier again
        System.out.println(lazy); // out: Hello, World
    }
}

```

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
        System.out.printf("%s statement is %s%n", duad.first(), duad.second()); // out: John statement is true
    }
}
```
