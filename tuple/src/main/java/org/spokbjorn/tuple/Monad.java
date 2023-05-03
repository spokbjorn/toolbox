package org.spokbjorn.tuple;

/**
 * Represents a monuple of value.
 * <p>
 * There is no meaning to value in this class, it can be used for any purpose.
 *
 * @param <T> the type of the value for the {@code first} parameter
 *
 * @author ghostbear
 */
public record Monad<T>(
        T first
) implements Tuple {
}
