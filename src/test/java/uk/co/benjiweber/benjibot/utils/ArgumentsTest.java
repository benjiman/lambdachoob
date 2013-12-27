package uk.co.benjiweber.benjibot.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ArgumentsTest {

    @Test public void should_extract_pluginname_commandname_and_arguments() {
        Arguments arguments = Arguments.fromString("tell.reply one two three");
        Assert.assertEquals("tell", arguments.getPluginName().get());
        Assert.assertEquals("reply", arguments.getCommandName().get());
        Assert.assertEquals("one", arguments.getArg1().get());
        Assert.assertEquals("two", arguments.getArg2().get());
        Assert.assertEquals("three", arguments.getArg3().get());
        Assert.assertEquals(Arrays.asList("one","two","three"), arguments.getArgs());
    }
}
