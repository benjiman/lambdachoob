package uk.co.benjiweber.benjibot.plugininfra;

import uk.co.benjiweber.benjibot.utils.Arguments;
import uk.co.benjiweber.benjibot.utils.Optionals;

import java.util.Optional;

public interface EvaluatorTwoParam extends Triggerable {
    public String command(Evaluator evaluator, String arg1, String arg2);

    public default Optional<String> command(Arguments arguments) {
        Evaluator evaluator = new Evaluator(arguments.getMessage(), arguments.getPluginManager());
        return Optionals.flatten(arguments.getArg1().map(arg1 -> arguments.getArg2().map(arg2 -> command(evaluator, arg1, arg2))));
    }
}
