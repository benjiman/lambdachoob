package uk.co.benjiweber.benjibot.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;

public class ArgumentsTest {

    Arguments arguments = Arguments.forTest("!tell.reply one two three four");

    @Test public void should_extract_plugin_name() {
        Assert.assertEquals("tell", arguments.getPluginName().get());
    }

    @Test public void should_extract_command_name() {
        Assert.assertEquals("reply", arguments.getCommandName().get());
    }

    @Test public void should_not_extract_plugin_name_when_no_dot() {
        Assert.assertEquals(Optional.<String>empty(), Arguments.forTest("!tellreply one two three four").getPluginName());
    }

    @Test public void should_not_extract_command_name_when_no_dot() {
        Assert.assertEquals(Optional.<String>empty(), Arguments.forTest("!tellreply one two three four").getCommandName());
    }

    @Test public void should_not_extract_plugin_name_when_no_trigger() {
        Assert.assertEquals(Optional.<String>empty(), Arguments.forTest("tell.reply one two three four").getPluginName());
    }

    @Test public void should_not_extract_command_name_when_no_trigger() {
        Assert.assertEquals(Optional.<String>empty(), Arguments.forTest("tell.reply one two three four").getCommandName());
    }

    @Test public void should_extract_arg1() {
        Assert.assertEquals("one", arguments.arg(1).get());
    }

    @Test public void should_extract_arg2() {
        Assert.assertEquals("two", arguments.arg(2).get());
    }

    @Test public void should_extract_args_3plus() {
        Assert.assertEquals("three four", arguments.argsFrom(3).get());
    }

    @Test public void should_extract_arg_list() {
        Assert.assertEquals(Arrays.asList("one", "two", "three", "four"), arguments.getArgs());
    }

}
