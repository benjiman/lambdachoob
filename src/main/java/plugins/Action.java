package plugins;

import uk.co.benjiweber.benjibot.plugininfra.ActionOneParam;
import uk.co.benjiweber.benjibot.plugininfra.ReplyOneParam;

public class Action {

    public final ActionOneParam hello = name -> "Hello, " + name;

}
