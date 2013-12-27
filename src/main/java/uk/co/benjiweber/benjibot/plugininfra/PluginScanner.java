package uk.co.benjiweber.benjibot.plugininfra;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class PluginScanner {

    public static Map<String, Triggerable> findCommands(Object plugin) {
        return asList(plugin.getClass().getDeclaredFields())
                .stream()
                .filter(field -> Triggerable.class.isAssignableFrom(field.getType()))
                .collect(Collectors.groupingBy(Field::getName, Collectors.maxBy((a, b) -> 1)))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().map(field -> getValue(field, plugin)).orElse(null)));
    }

    private static Triggerable getValue(Field field, Object plugin) {
        try {
            return (Triggerable) field.get(plugin);
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    private static class PluginLoadException extends RuntimeException {
        public PluginLoadException(Exception e) {
            super(e);
        }
    }
}
