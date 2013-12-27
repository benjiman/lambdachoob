package uk.co.benjiweber.benjibot.plugininfra.commands;

import uk.co.benjiweber.benjibot.plugininfra.Evaluator;
import uk.co.benjiweber.benjibot.plugininfra.Triggerable;
import uk.co.benjiweber.benjibot.utils.Arguments;
import uk.co.benjiweber.benjibot.utils.Optionals;

import java.util.List;
import java.util.Optional;

public interface EvaluatorParamList extends Triggerable {
    public String command(Evaluator evaluator, List<String> args);

    public default Optional<String> command(Arguments arguments) {
        Evaluator evaluator = new Evaluator(arguments.getMessage(), arguments.getPluginManager());
        return Optional.of(this.command(evaluator, arguments.getArgs()));
    }
}
