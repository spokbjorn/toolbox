package org.spokbjorn.tuple;

/**
 * Represents a octad of values.
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
 * @param <A> the type of the value for the {@code eighth} parameter
 *
 * @author ghostbear
 */
public record Octad<T, U, V, W, X, Y, Z, A>(
        T first, U second, V third, W fourth, X fifth, Y sixth, Z seventh, A eighth
) implements Tuple {
}
