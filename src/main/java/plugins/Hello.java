package plugins;

import uk.co.benjiweber.benjibot.plugininfra.commands.CommandOneParam;
import uk.co.benjiweber.benjibot.plugininfra.filter.Filter;

import static uk.co.benjiweber.benjibot.plugininfra.filter.FilterBuilder.match;

public class Hello {

    public final CommandOneParam hello = name -> "Hello, " + name;

    public final Filter lookForHellos = match("hello (\\w+)").then(name -> "hello, " + name);

}
