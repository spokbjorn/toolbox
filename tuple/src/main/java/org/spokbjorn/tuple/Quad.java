package org.spokbjorn.tuple;

/**
 * Represents a quad of values.
 * <p>
 * There is no meaning to values in this class, it can be used for any purpose.
 *
 * @param <T> the type of the value for the {@code first} parameter
 * @param <U> the type of the value for the {@code second} parameter
 * @param <V> the type of the value for the {@code third} parameter
 * @param <W> the type of the value for the {@code fourth} parameter
 *
 * @author ghostbear
 * @since 1.0.0
 */
public record Quad<T, U, V, W>(
        T first, U second, V third, W fourth
) implements Tuple {
}
