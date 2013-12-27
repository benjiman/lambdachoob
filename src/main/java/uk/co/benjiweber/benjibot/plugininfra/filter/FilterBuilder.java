package uk.co.benjiweber.benjibot.plugininfra.filter;

import uk.co.benjiweber.benjibot.plugininfra.*;
import uk.co.benjiweber.benjibot.plugininfra.commands.*;

public class FilterBuilder {
    public static SpecifyTriggerable match(String filterRegex) {
        return new SpecifyTriggerable() {
            public Filter<Command> then(Command triggerable) {
                return Filter.from(filterRegex, triggerable);
            }

            public Filter<CommandOneParam> then(CommandOneParam triggerable) {
                return Filter.from(filterRegex, triggerable);
            }

            public Filter<CommandTwoParam> then(CommandTwoParam triggerable) {
                return Filter.from(filterRegex, triggerable);
            }

            public Filter<Reply> thenReply(Reply triggerable) {
                return Filter.from(filterRegex, triggerable);
            }

            public Filter<Action> thenAction(Action triggerable) {
                return Filter.from(filterRegex, triggerable);
            }

            @Override
            public Filter<EvaluatorTwoParam> then(EvaluatorTwoParam evaluatorTwoParam) {
                return Filter.from(filterRegex, evaluatorTwoParam);
            }
        };
    }

    public interface SpecifyTriggerable<T extends MessageProcessor> {
        Filter<Command> then(Command triggerable);
        Filter<CommandOneParam> then(CommandOneParam triggerable);
        Filter<CommandTwoParam> then(CommandTwoParam triggerable);
        Filter<Reply> thenReply(Reply triggerable);
        Filter<Action> thenAction(Action triggerable);
        Filter<Command> then(EvaluatorTwoParam evaluatorTwoParam);
    }
}
