package uk.co.benjiweber.benjibot.plugininfra;

import org.junit.Test;
import plugins.Hello;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PluginScannerTest {

    @Test public void should_find_hello_command() {
        Hello plugin = new Hello();
        Map<String,Triggerable> commands = PluginScanner.findCommands(plugin);
        assertEquals(plugin.hello, commands.get("hello"));
    }
}
