package plugins;

import uk.co.benjiweber.benjibot.plugininfra.CommandTwoParam;
import uk.co.benjiweber.benjibot.plugininfra.DispatchTwoParam;
import uk.co.benjiweber.benjibot.plugininfra.filter.Filter;
import uk.co.benjiweber.benjibot.plugininfra.filter.FilterBuilder;

import java.util.HashMap;
import java.util.Map;

public class Alias {
    private Map<String, String> aliases = new HashMap<>();

    public final Filter<DispatchTwoParam> filter = FilterBuilder.match("^(\\w+)(.*)$").thenDispatch((name, args) -> {
        String aliased = aliases.get(name);
        return aliased != null ? aliased + args : "";
    });

    public final CommandTwoParam alias = (name, target) -> {
        aliases.put(name, target);
        return "Aliased " + name + " to " + target;
    };
}
