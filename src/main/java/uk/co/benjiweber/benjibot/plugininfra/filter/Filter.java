package uk.co.benjiweber.benjibot.plugininfra.filter;

import uk.co.benjiweber.benjibot.plugininfra.MessageProcessor;
import uk.co.benjiweber.benjibot.plugininfra.responses.Message;
import uk.co.benjiweber.benjibot.plugininfra.responses.Response;
import uk.co.benjiweber.benjibot.utils.Arguments;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Filter<T extends MessageProcessor> implements MessageProcessor {
    private final Pattern filterRegex;
    private final T triggerable;

    public Filter(String filterRegex, T triggerable) {
        this.filterRegex = Pattern.compile(".*?" + filterRegex + ".*");
        this.triggerable = triggerable;
    }

    public Response process(Arguments arguments) {
        Matcher matcher = filterRegex.matcher(arguments.getRaw());
        if (matcher.matches()) {
            return triggerable.process(newArgs(arguments, matcher));
        }
        return new Message(Optional.<String>empty());
    }

    private Arguments newArgs(Arguments arguments, Matcher matcher) {
        List<String> args = new ArrayList<>();
        for (int i = 1; i <= matcher.groupCount(); i++) {
            args.add(matcher.group(i));
        }
        return new Arguments(arguments, arguments.getRaw(), args.toArray(new String[0]));
    }

    public static <T extends MessageProcessor> Filter<T> from(String filterRegex, T triggerable) {
        return new Filter<T>(filterRegex, triggerable);
    }

    public String getRegex() {
        return filterRegex.pattern();
    }
}
