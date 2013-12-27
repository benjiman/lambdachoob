package uk.co.benjiweber.benjibot.plugininfra;

import org.pircbotx.hooks.events.MessageEvent;
import uk.co.benjiweber.benjibot.LambdaChoob;

public class Evaluator {

    private MessageEvent<LambdaChoob> msg;
    private PluginManager pluginManager;

    public Evaluator(MessageEvent<LambdaChoob> msg, PluginManager pluginManager) {
        this.msg = msg;
        this.pluginManager = pluginManager;
    }

    public String evaluate(String newMessage) {
        return pluginManager.processMessage(clone(msg, newMessage)).stream().map(response -> response.toString()).reduce("", (a,b) -> a + " " + b).trim();
    }

    private MessageEvent<LambdaChoob> clone(MessageEvent<LambdaChoob> messageEvent, String newCommand) {
        return new MessageEvent<LambdaChoob>(messageEvent.getBot(), messageEvent.getChannel(), messageEvent.getUser(), newCommand);
    }
}
