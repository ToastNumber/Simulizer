package simulizer.assembler.extractor.problem;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

/**
 * Holds information about problems encountered while parsing source code
 * Including data relevant for locating the errors in the code editor
 * @author mbway
 */
public class Problem {

    /**
     * A constant denoting a problem with no associated line number
     */
    public static final int NO_LINE_NUM = -1;


    /**
     * A human readable description of the problem
     */
    public String message;

    /**
     * if the problem is localised to a line in the source then this is
     * populated, otherwise -1
     */
    public int lineNum;


    /**
     * if the problem is localised to a range of characters, these attributes
     * are populated. If not they are both -1.
     * The index is absolute to the whole program string.
     * The interval is inclusive at both ends.
     */
    public int rangeStart;
    public int rangeEnd;


    /**
     * this is private because one might forget to give context. If you actually
     * mean to state the program has no associated line number, use:
     * new Problem("message", Problem.NO_LINE_NUM);
     */
    private Problem(String message) {
    }

    public Problem(String message, int lineNum) {
        this.message = message;
        this.lineNum = lineNum;
        this.rangeStart = -1;
        this.rangeEnd = -1;
    }

    public Problem(String message, int lineNum, int rangeStart, int rangeEnd) {
        this.message = message;
        this.lineNum = lineNum;
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
    }

    /**
     * create a problem which spans the entire context (grammar rule) passed to it
     * @param message a description of the problem
     * @param ctx the context (grammar rule) which the problem pertains to.
     */
    public Problem(String message, ParserRuleContext ctx) {
        this.message = message;

        if(ctx != null) {
            lineNum = ctx.getStart().getLine();
            rangeStart = ctx.getStart().getStartIndex();

            // appears to be null only if the input is an empty string
            Token stop = ctx.getStop();
            if(stop != null) {
                rangeEnd = stop.getStopIndex();
            } else {
                rangeEnd = rangeStart;
            }
        } else {
            lineNum = NO_LINE_NUM;
            rangeStart = -1;
            rangeEnd = -1;
        }
    }

	@Override
	public String toString() {
		return "Problem [message=\"" + message + "\", lineNum=" + lineNum + ", rangeStart=" + rangeStart + ", rangeEnd=" + rangeEnd + "]";
	}

}
