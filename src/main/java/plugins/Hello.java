package plugins;

import uk.co.benjiweber.benjibot.plugininfra.CommandOneParam;

public class Hello {

    public final CommandOneParam hello = name -> "Hello, " + name;

}
