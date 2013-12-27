package plugins;

import uk.co.benjiweber.benjibot.Settings;
import uk.co.benjiweber.benjibot.plugininfra.commands.CommandTwoParam;
import uk.co.benjiweber.benjibot.plugininfra.commands.EvaluatorTwoParam;
import uk.co.benjiweber.benjibot.plugininfra.commands.ReplyTwoParam;
import uk.co.benjiweber.benjibot.plugininfra.filter.Filter;
import uk.co.benjiweber.benjibot.plugininfra.filter.FilterBuilder;

import java.util.HashMap;
import java.util.Map;

public class Alias {
    private Map<String, String> aliases = new HashMap<>();

    public final ReplyTwoParam alias = (name, target) -> {
        if (validCommand(target)) {
            aliases.put(name, target);
            return "Aliased " + name + " to " + target;
        } else {
            return "'" + target + "' doesn't look like a valid command. Is it prefixed with a '" + Settings.Trigger + "' ?";
        }
    };

    private boolean validCommand(String target) {
        return target.length() > 1 && target.startsWith(Settings.Trigger);
    }

    public final Filter filter = FilterBuilder.match("^"+ Settings.Trigger + "(\\w+)(.*)$").then((evaluator, name, args) -> {
        String aliased = aliases.get(name);
        return aliased != null ? evaluator.evaluate(aliased + args).toString() : "";
    });

}
