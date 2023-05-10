package org.spokbjorn.lazy;

import java.util.function.Supplier;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LazyTest {

    @Test
    void supplyGivenValue() {
        Lazy<String> stringLazy = Lazy.of(() -> "Hello, Test!");
        assertEquals("Hello, Test!", stringLazy.get());
    }

    @Test
    void isSameValue() {
        Lazy<String> stringLazy = Lazy.of(() -> "Hello, Test!");
        assertTrue(stringLazy.same("Hello, Test!"));
    }

    @Test
    void isNotSameValue() {
        Lazy<String> stringLazy = Lazy.of(() -> "1");
        assertFalse(stringLazy.same(1));
    }

    @Test
    void isSameLazyValue() {
        Lazy<String> stringLazy1 = Lazy.of(() -> "Hello, Test!");
        Lazy<String> stringLazy2 = Lazy.of(() -> "Hello, Test!");
        assertTrue(stringLazy1.same(stringLazy2));
    }

    @Test
    void isEqual() {
        Supplier<String> helloTestSupplier = () -> "Hello, Test";
        Lazy<String> stringLazy1 = Lazy.of(helloTestSupplier);
        Lazy<String> stringLazy2 = Lazy.lazy(helloTestSupplier);

        assertEquals(stringLazy1, stringLazy2);
    }

    @Test
    void isNotEqual() {
        Lazy<String> stringLazy1 = Lazy.of(() -> "Hello, Test");
        Lazy<String> stringLazy2 = Lazy.lazy(() -> "Hello, Test");

        assertNotEquals(stringLazy1, stringLazy2);
    }

    @Test
    void isEqualAfterLazyInitialization() {
        Supplier<String> helloTestSupplier = () -> "Hello, Test";
        Lazy<String> stringLazy1 = Lazy.of(helloTestSupplier);
        Lazy<String> stringLazy2 = Lazy.lazy(helloTestSupplier);

        stringLazy1.get();
        stringLazy2.get();

        assertEquals(stringLazy1, stringLazy2);
    }

    @Test
    void mapValueToAnother() {
        Lazy<String> stringLazy = Lazy.of(() -> "1");
        Lazy<Integer> integerLazy = stringLazy.map(Integer::parseInt);
        assertEquals(1, integerLazy.get());
    }

    @Test
    void lazyToString() {
        Lazy<Integer> integerLazy = Lazy.of(() -> 1);
        assertEquals("1", integerLazy.toString());
    }

}
