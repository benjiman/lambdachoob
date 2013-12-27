package uk.co.benjiweber.benjibot.plugininfra;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.Test;
import plugins.Hello;
import uk.co.benjiweber.benjibot.plugininfra.filter.Filter;

import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class PluginScannerTest {

    @Test public void should_find_hello_command() {
        Hello plugin = new Hello();
        Map<String,Triggerable> commands = PluginScanner.findCommands(plugin);
        assertEquals(plugin.hello, commands.get("hello"));
    }

    @Test
    public void should_find_hello_filter() {
        Hello plugin = new Hello();
        Set<Filter> filters = PluginScanner.findFilters(plugin);
        assertThat(filters, Matchers.contains(plugin.lookForHellos));
    }
}
