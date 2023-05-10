package org.spokbjorn.lazy;

import java.io.Serializable;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * A generic class for creating a lazy-initialized value that can be computed on-demand.
 *
 * @param <T> the type of value to be lazily initialized
 * @author ghostbear
 * @since 1
 */
public class Lazy<T> implements Supplier<T>, Comparable<T>, Serializable {

    /**
     * Returns a new {@link Lazy} instance that computes its value on-demand
     * using the provided {@link Supplier}.
     *
     * <p>
     * This method is a factory method for creating new instances of the {@link Lazy} class.
     * It takes a non-null {@link Supplier} argument that will be used to compute the value
     * when the {@link Lazy#get()} method is called for the first time. The returned instance
     * of {@link Lazy} is guaranteed to be non-null.
     * </p>
     *
     * @param <T> the type of value to be lazily initialized
     * @param supplier the supplier used to compute the value on-demand; must not be null
     * @return a new {@link Lazy} instance that uses the provided supplier to compute its value
     * @throws NullPointerException if the supplied supplier is null
     */
    @Contract(value = "_ -> new", pure = true)
    public static <T> @NotNull Lazy<T> of(@NotNull Supplier<T> supplier) {
        Objects.requireNonNull(supplier);
        return new Lazy<>(supplier);
    }

    /**
     * Returns a new {@link Lazy} instance that computes its value on-demand
     * using the provided {@link Supplier}.
     *
     * <p>
     * This method is a convenience wrapper for the {@link #of(Supplier)} method, which
     * creates a new {@link Lazy} instance using the supplied {@link Supplier}.
     * </p>
     *
     * @param <T> the type of value to be lazily initialized
     * @param supplier the supplier used to compute the value on-demand; must not be null
     * @return a new {@link Lazy} instance that uses the provided supplier to compute its value
     * @throws NullPointerException if the supplied supplier is null
     */
    @Contract("_ -> new")
    public static <T> @NotNull Lazy<T> lazy(@NotNull Supplier<T> supplier) {
        return of(supplier);
    }

    @NotNull
    private final Supplier<T> lazySupplier;
    @Nullable
    private T value;

    private Lazy(@NotNull Supplier<T> lazySupplier) {
        Objects.requireNonNull(lazySupplier);
        this.lazySupplier = lazySupplier;
    }

    /**
     * Gets the lazily initialized value, computing it if necessary.
     *
     * <p>
     * If the value has not yet been initialized, this method will call the {@link Supplier}
     * provided in the constructor to compute and cache the value. Subsequent calls to this
     * method will return the cached value without calling the supplier again.
     * </p>
     *
     * @return the lazily initialized value
     */
    @Override
    public T get() {
        if (Objects.isNull(value)) {
            value = lazySupplier.get();
        }
        return value;
    }

    /**
     * Returns a new {@link Lazy} instance that holds a lazily evaluated result of applying
     * the given mapping function to the value held by this instance.
     *
     * <p>
     * The mapping function is applied lazily when the value is first accessed through the
     * new instance. If the mapping function is expensive to compute, this can provide
     * significant performance benefits compared to computing the mapping eagerly and
     * then creating a new {@link Lazy} instance.
     * </p>
     *
     * <p>
     * The type of the resulting {@link Lazy} instance is determined by the return type of
     * the mapping function. The input type of the mapping function must be a super type of
     * the type held by this instance.
     * </p>
     *
     * @param function the mapping function to apply to the value held by this instance; must not be null
     * @param <R> the type of the resulting {@link Lazy} instance
     * @return a new {@link Lazy} instance that holds the lazily evaluated result of applying
     * the given mapping function to the value held by this instance
     * @throws NullPointerException if the given mapping function is null
     */
    public <R> Lazy<R> map(Function<? super T, ? extends R> function) {
        Objects.requireNonNull(function);
        return Lazy.of(() -> function.apply(get()));
    }

    /**
     * Compares this {@link Lazy} instance to another instance to determine if they hold
     * the same lazily initialized value.
     *
     * <p>
     * This method returns true if the provided {@link Lazy} instance is not null and if its
     * lazily initialized value is equal to the value held by this instance. The comparison
     * is performed using the {@link Objects#equals(Object, Object)} method.
     * </p>
     *
     * @param other the other {@link Lazy} instance to compare to; may be null
     * @return true if the two instances hold the same lazily initialized value, false otherwise
     */
    public boolean same(@Nullable Lazy<T> other) {
        return Objects.nonNull(other) && Objects.equals(get(), other.get());
    }

    /**
     * Compares this {@link Lazy#get()} instance to another object to determine if they are
     * the same value.
     *
     * <p>
     * This method returns true if the provided object is not null and if it is an instance
     * of the value held by this instance. The comparison is performed using the
     * {@link Objects#equals(Object, Object)} method.
     * </p>
     *
     * @param other the object to compare to; may be null
     * @return true if the object holds the same value, false otherwise
     */
    public boolean same(@Nullable Object other) {
        return Objects.equals(get(), other);
    }

    @Override
    @SuppressWarnings("unchecked")
    public int compareTo(@NotNull T o) {
        if (o instanceof Comparable<?>) {
            return ((Comparable<T>) o).compareTo(get());
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lazy<?> lazy = (Lazy<?>) o;
        return Objects.equals(lazySupplier, lazy.lazySupplier) && Objects.equals(value, lazy.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lazySupplier, value);
    }

    @Override
    public String toString() {
        return String.valueOf(get());
    }

}
