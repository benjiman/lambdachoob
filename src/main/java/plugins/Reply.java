package plugins;

import uk.co.benjiweber.benjibot.plugininfra.CommandOneParam;
import uk.co.benjiweber.benjibot.plugininfra.ReplyOneParam;

public class Reply {

    public final ReplyOneParam hello = name -> "Hello, " + name;

}
