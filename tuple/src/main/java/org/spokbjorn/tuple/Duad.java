package org.spokbjorn.tuple;

/**
 * Represents a duad of values.
 * <p>
 * There is no meaning to values in this class, it can be used for any purpose.
 *
 * @param <T> the type of the value for the {@code first} parameter
 * @param <U> the type of the value for the {@code second} parameter
 *
 * @author ghostbear
 * @since 1.0.0
 */
public record Duad<T, U>(
        T first, U second
) implements Tuple {
}
