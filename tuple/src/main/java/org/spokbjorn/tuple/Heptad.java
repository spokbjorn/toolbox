package org.spokbjorn.tuple;

/**
 * Represents a heptad of values.
 * <p>
 * There is no meaning to values in this class, it can be used for any purpose.
 *
 * @param <T> the type of the value for the {@code first} parameter
 * @param <U> the type of the value for the {@code second} parameter
 * @param <V> the type of the value for the {@code third} parameter
 * @param <W> the type of the value for the {@code fourth} parameter
 * @param <X> the type of the value for the {@code fifth} parameter
 * @param <Y> the type of the value for the {@code sixth} parameter
 * @param <Z> the type of the value for the {@code seventh} parameter
 *
 * @author ghostbear
 * @since 1.0.0
 */
public record Heptad<T, U, V, W, X, Y, Z>(
        T first, U second, V third, W fourth, X fifth, Y sixth, Z seventh
) implements Tuple {
}
