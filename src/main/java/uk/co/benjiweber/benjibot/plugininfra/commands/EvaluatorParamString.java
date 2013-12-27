package uk.co.benjiweber.benjibot.plugininfra.commands;

import com.google.common.base.Joiner;
import uk.co.benjiweber.benjibot.plugininfra.Evaluator;
import uk.co.benjiweber.benjibot.plugininfra.Triggerable;
import uk.co.benjiweber.benjibot.utils.Arguments;

import java.util.List;
import java.util.Optional;

public interface EvaluatorParamString extends Triggerable {
    public String command(Evaluator evaluator, String args);

    public default Optional<String> command(Arguments arguments) {
        Evaluator evaluator = new Evaluator(arguments.getMessage(), arguments.getPluginManager());
        return Optional.of(this.command(evaluator, Joiner.on(" ").join(arguments.getArgs())));
    }
}
