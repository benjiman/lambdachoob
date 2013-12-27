package plugins;

import uk.co.benjiweber.benjibot.Settings;
import uk.co.benjiweber.benjibot.plugininfra.commands.CommandTwoParam;
import uk.co.benjiweber.benjibot.plugininfra.commands.EvaluatorTwoParam;
import uk.co.benjiweber.benjibot.plugininfra.filter.Filter;
import uk.co.benjiweber.benjibot.plugininfra.filter.FilterBuilder;

import java.util.HashMap;
import java.util.Map;

public class Alias {
    private Map<String, String> aliases = new HashMap<>();

    public final CommandTwoParam alias = (name, target) -> {
        aliases.put(name, target);
        return "Aliased " + name + " to " + target;
    };

    public final Filter<EvaluatorTwoParam> filter = FilterBuilder.match("^"+ Settings.Trigger + "(\\w+)(.*)$").then((evaluator, name, args) -> {
        String aliased = aliases.get(name);
        return aliased != null ? evaluator.evaluate(aliased + args).toString() : "";
    });

}
