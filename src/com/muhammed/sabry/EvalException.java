package com.muhammed.sabry;

import org.antlr.v4.runtime.ParserRuleContext;

class EvalException extends RuntimeException {
    EvalException(ParserRuleContext ctx) {
        this("Illegal expression: " + ctx.getText(), ctx);
    }
    
    EvalException(String msg, ParserRuleContext ctx) {
        super(msg + " line:" + ctx.start.getLine());
    }
}
