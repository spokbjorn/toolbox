package org.spokbjorn.lazy;

import java.util.Objects;
import java.util.Scanner;
import static org.spokbjorn.lazy.Lazy.lazy;

public class Example {

    public static final Lazy<String> lazy = lazy(() -> "A".repeat(100_000_000));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press any key (q to quit)");
        while (true) {
            String input = scanner.next();
            if (Objects.equals(input, "q")) {
                break;
            }
            System.out.println(lazy);
        }
    }

}
