package plugins;

import uk.co.benjiweber.benjibot.plugininfra.Command;
import uk.co.benjiweber.benjibot.plugininfra.CommandOneParam;
import uk.co.benjiweber.benjibot.plugininfra.filter.Filter;
import uk.co.benjiweber.benjibot.plugininfra.filter.FilterBuilder;

import static uk.co.benjiweber.benjibot.plugininfra.filter.FilterBuilder.match;

public class Hello {

    public final CommandOneParam hello = name -> "Hello, " + name;

    public final Filter<CommandOneParam> lookForHellos = match("hello (\\w+)").then(name -> "hello, " + name);

}
