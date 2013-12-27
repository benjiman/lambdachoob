package plugins;

import com.google.common.base.Joiner;
import uk.co.benjiweber.benjibot.plugininfra.Evaluator;
import uk.co.benjiweber.benjibot.plugininfra.EvaluatorParamList;
import uk.co.benjiweber.benjibot.plugininfra.EvaluatorParamString;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pipes {

    public final EvaluatorParamString eval = (evaluator, argString) -> {
        return evaluate(evaluator, argString, ""); ding
    };

    private static final Pattern pipesPattern = Pattern.compile("(.*?) *?(\\||$) *(.*)");

    private static String evaluate(Evaluator evaluator, String remainingCommandString, String previousResult) {
        Matcher matcher = pipesPattern.matcher(remainingCommandString);
        if (remainingCommandString.length() > 1 && matcher.matches()) {
            String nextCommand = matcher.group(1) + previousResult;
            String nextResult = evaluator.evaluate(nextCommand);
            return evaluate(evaluator, matcher.group(3), nextResult).trim();
        }
        return previousResult.trim();
    }
}
