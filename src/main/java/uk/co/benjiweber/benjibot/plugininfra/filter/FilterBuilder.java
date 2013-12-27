package uk.co.benjiweber.benjibot.plugininfra.filter;

import uk.co.benjiweber.benjibot.plugininfra.*;

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
            public Filter<DispatchTwoParam> thenDispatch(DispatchTwoParam triggerable) {
                return Filter.from(filterRegex, triggerable);
            }
        };
    }

    public interface SpecifyTriggerable<T extends MessageProcessor> {
        Filter<Command> then(Command triggerable);
        Filter<Command> then(CommandOneParam triggerable);
        Filter<Command> then(CommandTwoParam triggerable);
        Filter<Reply> thenReply(Reply triggerable);
        Filter<Action> thenAction(Action triggerable);
        Filter<Action> thenDispatch(DispatchTwoParam triggerable);
    }
}
