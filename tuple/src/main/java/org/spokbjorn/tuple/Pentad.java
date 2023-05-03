package org.spokbjorn.tuple;

/**
 * Represents a pentad of values.
 * <p>
 * There is no meaning to values in this class, it can be used for any purpose.
 *
 * @param <T> the type of the value for the {@code first} parameter
 * @param <U> the type of the value for the {@code second} parameter
 * @param <V> the type of the value for the {@code third} parameter
 * @param <W> the type of the value for the {@code fourth} parameter
 * @param <X> the type of the value for the {@code fifth} parameter
 *
 * @author ghostbear
 */
public record Pentad<T, U, V, W, X>(
        T first, U second, V third, W fourth, X fifth
) implements Tuple {
}
