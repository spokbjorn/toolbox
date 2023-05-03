package org.spokbjorn.tuple;

import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

/**
 * Tuple is a finite-ordered list of elements.
 *
 * @author ghostbear
 */
public sealed interface Tuple permits Duad, Heptad, Hexad, Monad, Octad, Pentad, Quad, Triad, Unit {

    /**
     * Returns an unmodifiable list based on the tuple that is inputted.
     *
     * @param tuple the tuple to be converted
     * @return an unmodifiable list
     * @param <T> the type of the return value
     */
    static <T> @Unmodifiable @NotNull List<? super T> asList(@NotNull Tuple tuple) {
        if (tuple instanceof Monad monad) {
            return asList(monad);
        } else if (tuple instanceof Duad duad) {
            return asList(duad);
        } else if (tuple instanceof Heptad heptad) {
            return asList(heptad);
        } else if (tuple instanceof Hexad hexad) {
            return asList(hexad);
        } else if (tuple instanceof Octad octad) {
            return asList(octad);
        } else if (tuple instanceof Pentad pentad) {
            return asList(pentad);
        } else if (tuple instanceof Quad quad) {
            return asList(quad);
        } else if (tuple instanceof Triad triad) {
            return asList(triad);
        } else if (tuple instanceof Unit) {
            return Collections.emptyList();
        }
        throw new IllegalArgumentException();
    }

    /**
     * Returns an empty unmodifiable list.
     *
     * @param unit the unit to be converted
     * @return an empty unmodifiable list
     * @param <T> the type of the return value
     */
    @Contract(pure = true)
    static <T>  @Unmodifiable @NotNull List<T> asList(@NotNull Unit unit) {
        return Collections.emptyList();
    }

    /**
     * Returns an unmodifiable list of the value in the monad.
     *
     * @param monad the monad to be converted
     * @return an unmodifiable list of the value in the monad
     * @param <T> the type of the return value
     */
    static <T> @Unmodifiable @NotNull List<T> asList(@NotNull Monad<? extends T> monad) {
        return List.of(monad.first());
    }

    /**
     * Returns an unmodifiable list of all the values in the duad.
     *
     * @param duad the duad to be converted
     * @return an unmodifiable list of all the values in the duad
     * @param <T> the type of the return value
     */
    static <T> @Unmodifiable @NotNull List<T> asList(@NotNull Duad<? extends T, ? extends T> duad) {
        return List.of(duad.first(), duad.second());
    }

    /**
     * Returns an unmodifiable list of all the values in the triad.
     *
     * @param triad the triad to be converted
     * @return an unmodifiable list of all the values in the triad
     * @param <T> the type of the return value
     */
    static <T> @Unmodifiable @NotNull List<T> asList(@NotNull Triad<? extends T, ? extends T, ? extends T> triad) {
        return List.of(triad.first(), triad.second(), triad.third());
    }

    /**
     * Returns an unmodifiable list of all the values in the quad.
     *
     * @param quad the quad to be converted
     * @return an unmodifiable list of all the values in the quad
     * @param <T> the type of the return value
     */
    static <T> @Unmodifiable @NotNull List<T> asList(@NotNull Quad<? extends T, ? extends T, ? extends T, ? extends T> quad) {
        return List.of(quad.first(), quad.second(), quad.third(), quad.fourth());
    }

    /**
     * Returns an unmodifiable list of all the values in the pentad.
     *
     * @param pentad the pentad to be converted
     * @return an unmodifiable list of all the values in the pentad
     * @param <T> the type of the return value
     */
    static <T> @Unmodifiable @NotNull List<T> asList(@NotNull Pentad<? extends T, ? extends T, ? extends T, ? extends T, ? extends T> pentad) {
        return List.of(pentad.first(), pentad.second(), pentad.third(), pentad.fourth(), pentad.fifth());
    }

    /**
     * Returns an unmodifiable list of all the values in the hexad.
     *
     * @param hexad the duad to be converted
     * @return an unmodifiable list of all the values in the hexad
     * @param <T> the type of the return value
     */
    static <T> @Unmodifiable @NotNull List<T> asList(@NotNull Hexad<? extends T, ? extends T, ? extends T, ? extends T, ? extends T, ? extends T> hexad) {
        return List.of(hexad.first(), hexad.second(), hexad.third(), hexad.fourth(), hexad.fifth(), hexad.sixth());
    }

    /**
     * Returns an unmodifiable list of all the values in the heptad.
     *
     * @param heptad the heptad to be converted
     * @return an unmodifiable list of all the values in the heptad
     * @param <T> the type of the return value
     */
    static <T> @Unmodifiable @NotNull List<T> asList(@NotNull Heptad<? extends T, ? extends T, ? extends T, ? extends T, ? extends T, ? extends T, ? extends T> heptad) {
        return List.of(heptad.first(), heptad.second(), heptad.third(), heptad.fourth(), heptad.fifth(), heptad.sixth(), heptad.seventh());
    }

    /**
     * Returns an unmodifiable list of all the values in the octad.
     *
     * @param octad the octad to be converted
     * @return an unmodifiable list of all the values in the octad
     * @param <T> the type of the return value
     */
    static <T> @Unmodifiable @NotNull List<T> asList(@NotNull Octad<? extends T, ? extends T, ? extends T, ? extends T, ? extends T, ? extends T, ? extends T, ? extends T> octad) {
        return List.of(octad.first(), octad.second(), octad.third(), octad.fourth(), octad.fifth(), octad.sixth(), octad.seventh(), octad.eighth());
    }

    /**
     * Returns an empty tuple instance.
     *
     * @return an empty tuple instance
     */
    @Contract(" -> new")
    static @NotNull Unit empty() {
        return new Unit();
    }

    /**
     * Returns a monad instance.
     *
     * @return a monad instance
     * @param <T> the type of the {@code first} value
     */
    @Contract("_ -> new")
    static <T> @NotNull Monad<T> of(T first) {
        return new Monad<>(first);
    }

    /**
     * Returns a duad instance.
     *
     * @return a duad instance
     * @param <T> the type of the {@code first} value
     * @param <U> the type of the {@code second} value
     */
    @Contract("_, _ -> new")
    static <T, U> @NotNull Duad<T, U> of(T first, U second) {
        return new Duad<>(first, second);
    }

    /**
     * Returns a triad instance.
     *
     * @return a triad instance
     * @param <T> the type of the {@code first} value
     * @param <U> the type of the {@code second} value
     * @param <V> the type of the {@code third} value
     */
    @Contract("_, _, _ -> new")
    static <T, U, V> @NotNull Triad<T, U, V> of(T first, U second, V third) {
        return new Triad<>(first, second, third);
    }

    /**
     * Returns a quad instance.
     *
     * @return a quad instance
     * @param <T> the type of the {@code first} value
     * @param <U> the type of the {@code second} value
     * @param <V> the type of the {@code third} value
     * @param <W> the type of the {@code fourth} value
     */
    @Contract("_, _, _, _ -> new")
    static <T, U, V, W> @NotNull Quad<T, U, V, W> of(T first, U second, V third, W fourth) {
        return new Quad<>(first, second, third, fourth);
    }

    /**
     * Returns a pentad instance.
     *
     * @return a pentad instance
     * @param <T> the type of the {@code first} value
     * @param <U> the type of the {@code second} value
     * @param <V> the type of the {@code third} value
     * @param <W> the type of the {@code fourth} value
     * @param <X> the type of the {@code fifth} value
     */
    @Contract("_, _, _, _, _ -> new")
    static <T, U, V, W, X> @NotNull Pentad<T, U, V, W, X> of(T first, U second, V third, W fourth, X fifth) {
        return new Pentad<>(first, second, third, fourth, fifth);
    }

    /**
     * Returns a hexad instance.
     *
     * @return a hexad instance
     * @param <T> the type of the {@code first} value
     * @param <U> the type of the {@code second} value
     * @param <V> the type of the {@code third} value
     * @param <W> the type of the {@code fourth} value
     * @param <X> the type of the {@code fifth} value
     * @param <Y> the type of the {@code sixth} value
     */
    @Contract("_, _, _, _, _, _ -> new")
    static <T, U, V, W, X, Y> @NotNull Hexad<T, U, V, W, X, Y> of(T first, U second, V third, W fourth, X fifth, Y sixth) {
        return new Hexad<>(first, second, third, fourth, fifth, sixth);
    }

    /**
     * Returns a heptad instance.
     *
     * @return a heptad instance
     * @param <T> the type of the {@code first} value
     * @param <U> the type of the {@code second} value
     * @param <V> the type of the {@code third} value
     * @param <W> the type of the {@code fourth} value
     * @param <X> the type of the {@code fifth} value
     * @param <Y> the type of the {@code sixth} value
     * @param <Z> the type of the {@code seventh} value
     */
    @Contract("_, _, _, _, _, _, _ -> new")
    static <T, U, V, W, X, Y, Z> @NotNull Heptad<T, U, V, W, X, Y, Z> of(T first, U second, V third, W fourth, X fifth, Y sixth, Z seventh) {
        return new Heptad<>(first, second, third, fourth, fifth, sixth, seventh);
    }

    /**
     * Returns a octad instance.
     *
     * @return a octad instance
     * @param <T> the type of the {@code first} value
     * @param <U> the type of the {@code second} value
     * @param <V> the type of the {@code third} value
     * @param <W> the type of the {@code fourth} value
     * @param <X> the type of the {@code fifth} value
     * @param <Y> the type of the {@code sixth} value
     * @param <Z> the type of the {@code seventh} value
     * @param <A> the type of the {@code eighth} value
     */
    @Contract("_, _, _, _, _, _, _, _ -> new")
    static <T, U, V, W, X, Y, Z, A> @NotNull Octad<T, U, V, W, X, Y, Z, A> of(T first, U second, V third, W fourth, X fifth, Y sixth, Z seventh, A eighth) {
        return new Octad<>(first, second, third, fourth, fifth, sixth, seventh, eighth);
    }

}
