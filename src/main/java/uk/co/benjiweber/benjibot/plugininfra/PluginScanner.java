package uk.co.benjiweber.benjibot.plugininfra;

import uk.co.benjiweber.benjibot.plugininfra.filter.Filter;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class PluginScanner {

    public static Map<String, Triggerable> findCommands(Object plugin) {
        return asList(plugin.getClass().getDeclaredFields())
                .stream()
                .filter(field -> Triggerable.class.isAssignableFrom(field.getType()))
                .collect(Collectors.groupingBy(Field::getName, Collectors.maxBy((a, b) -> 1)))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().map(field -> getValue(field, plugin, Triggerable.class)).orElse(null)));
    }

    private static <T> T getValue(Field field, Object plugin, Class<T> expectedType) {
        try {
            return (T) field.get(plugin);
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    public static Set<Filter> findFilters(Object plugin) {
        return asList(plugin.getClass().getDeclaredFields())
                .stream()
                .filter(field -> Filter.class.isAssignableFrom(field.getType()))
                .map(field -> getValue(field, plugin, Filter.class))
                .collect(Collectors.toSet());
    }

    private static class PluginLoadException extends RuntimeException {
        public PluginLoadException(Exception e) {
            super(e);
        }
    }
}
