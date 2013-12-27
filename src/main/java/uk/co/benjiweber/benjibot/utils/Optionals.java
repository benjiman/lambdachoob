package uk.co.benjiweber.benjibot.utils;

import java.util.Optional;

public class Optionals {
    public static <T> Optional<T> flatten(Optional<Optional<T>> optionalChain) {
        return optionalChain.orElse(Optional.<T>empty());
    }

    public static <T> Optional<T> flatten2(Optional<Optional<Optional<T>>> optionalChain) {
        return optionalChain.orElse(Optional.<Optional<T>>empty()).orElse(Optional.<T>empty());
    }
}
