package uk.co.benjiweber.benjibot.plugininfra;

import org.pircbotx.hooks.events.MessageEvent;
import uk.co.benjiweber.benjibot.BenjiBot;

public class Evaluator {

    private MessageEvent<BenjiBot> msg;
    private PluginManager pluginManager;

    public Evaluator(MessageEvent<BenjiBot> msg, PluginManager pluginManager) {
        this.msg = msg;
        this.pluginManager = pluginManager;
    }

    public String evaluate(String newMessage) {
        return pluginManager.processMessage(clone(msg, newMessage)).stream().map(response -> response.toString()).reduce("", (a,b) -> a + " " + b);
    }

    private MessageEvent<BenjiBot> clone(MessageEvent<BenjiBot> messageEvent, String newCommand) {
        return new MessageEvent<BenjiBot>(messageEvent.getBot(), messageEvent.getChannel(), messageEvent.getUser(), newCommand);
    }
}
