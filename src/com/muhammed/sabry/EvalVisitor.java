package com.muhammed.sabry;

import com.muhammed.sabry.TLParser.*;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.List;

public class EvalVisitor extends TLBaseVisitor<TLValue> {
    private Scope scope;

    EvalVisitor(Scope scope) {
        this.scope = scope;
    }

    // expression op=( '*' | '/' | '%' ) expression         #multExpression
    @Override
    public TLValue visitMultExpression(MultExpressionContext ctx) {
        switch (ctx.op.getType()) {
            case TLLexer.Multiply:
                return multiply(ctx);
            case TLLexer.Divide:
                return divide(ctx);
            default:
                throw new RuntimeException("unknown operator type: " + ctx.op.getType());
        }
    }

    // expression op=( '+' | '-' ) expression               #addExpression
    @Override
    public TLValue visitAddExpression(AddExpressionContext ctx) {
        switch (ctx.op.getType()) {
            case TLLexer.Add:
                return add(ctx);
            case TLLexer.Subtract:
                return subtract(ctx);
            default:
                throw new RuntimeException("unknown operator type: " + ctx.op.getType());
        }
    }

    // expression op=( '>=' | '<=' | '>' | '<' ) expression #compExpression
    @Override
    public TLValue visitCompExpression(CompExpressionContext ctx) {
        switch (ctx.op.getType()) {
            case TLLexer.LT:
                return lt(ctx);
            case TLLexer.LTEquals:
                return ltEq(ctx);
            case TLLexer.GT:
                return gt(ctx);
            case TLLexer.GTEquals:
                return gtEq(ctx);
            default:
                throw new RuntimeException("unknown operator type: " + ctx.op.getType());
        }
    }

    // expression op=( '==' | '!=' ) expression             #eqExpression
    @Override
    public TLValue visitEqExpression(EqExpressionContext ctx) {
        switch (ctx.op.getType()) {
            case TLLexer.Equals:
                return eq(ctx);
            case TLLexer.NEquals:
                return nEq(ctx);
            default:
                throw new RuntimeException("unknown operator type: " + ctx.op.getType());
        }
    }

    private TLValue multiply(MultExpressionContext ctx) {
        TLValue lhs = this.visit(ctx.expression(0));
        TLValue rhs = this.visit(ctx.expression(1));
        if (lhs == null || rhs == null) {
            System.err.println("lhs " + lhs + " rhs " + rhs);
            throw new EvalException(ctx);
        }

        // number * number
        if (lhs.isNumber() && rhs.isNumber()) {
            return new TLValue(lhs.asDouble() * rhs.asDouble());
        }

        // string * number
        if (lhs.isString() && rhs.isNumber()) {
            StringBuilder str = new StringBuilder();
            int stop = rhs.asDouble().intValue();
            for (int i = 0; i < stop; i++) {
                str.append(lhs.asString());
            }
            return new TLValue(str.toString());
        }

        // list * number
        if (lhs.isList() && rhs.isNumber()) {
            List<TLValue> total = new ArrayList<>();
            int stop = rhs.asDouble().intValue();
            for (int i = 0; i < stop; i++) {
                total.addAll(lhs.asList());
            }
            return new TLValue(total);
        }

        throw new EvalException(ctx);
    }

    private TLValue divide(MultExpressionContext ctx) {
        TLValue lhs = this.visit(ctx.expression(0));
        TLValue rhs = this.visit(ctx.expression(1));
        if (lhs.isNumber() && rhs.isNumber()) {
            return new TLValue(lhs.asDouble() / rhs.asDouble());
        }
        throw new EvalException(ctx);
    }

    private TLValue add(AddExpressionContext ctx) {
        TLValue lhs = this.visit(ctx.expression(0));
        TLValue rhs = this.visit(ctx.expression(1));

        if (lhs == null || rhs == null) {
            throw new EvalException(ctx);
        }

        // number + number
        if (lhs.isNumber() && rhs.isNumber()) {
            return new TLValue(lhs.asDouble() + rhs.asDouble());
        }

        // list + any
        if (lhs.isList()) {
            List<TLValue> list = lhs.asList();
            list.add(rhs);
            return new TLValue(list);
        }

        // string + any
        if (lhs.isString()) {
            return new TLValue(lhs.asString() + "" + rhs.toString());
        }

        // any + string
        if (rhs.isString()) {
            return new TLValue(lhs.toString() + "" + rhs.asString());
        }

        return new TLValue(lhs.toString() + rhs.toString());
    }

    private TLValue subtract(AddExpressionContext ctx) {
        TLValue lhs = this.visit(ctx.expression(0));
        TLValue rhs = this.visit(ctx.expression(1));
        if (lhs.isNumber() && rhs.isNumber()) {
            return new TLValue(lhs.asDouble() - rhs.asDouble());
        }
        if (lhs.isList()) {
            List<TLValue> list = lhs.asList();
            list.remove(rhs);
            return new TLValue(list);
        }
        throw new EvalException(ctx);
    }

    private TLValue gtEq(CompExpressionContext ctx) {
        TLValue lhs = this.visit(ctx.expression(0));
        TLValue rhs = this.visit(ctx.expression(1));
        if (lhs.isNumber() && rhs.isNumber()) {
            return new TLValue(lhs.asDouble() >= rhs.asDouble());
        }
        if (lhs.isString() && rhs.isString()) {
            return new TLValue(lhs.asString().compareTo(rhs.asString()) >= 0);
        }
        throw new EvalException(ctx);
    }

    private TLValue ltEq(CompExpressionContext ctx) {
        TLValue lhs = this.visit(ctx.expression(0));
        TLValue rhs = this.visit(ctx.expression(1));
        if (lhs.isNumber() && rhs.isNumber()) {
            return new TLValue(lhs.asDouble() <= rhs.asDouble());
        }
        if (lhs.isString() && rhs.isString()) {
            return new TLValue(lhs.asString().compareTo(rhs.asString()) <= 0);
        }
        throw new EvalException(ctx);
    }

    private TLValue gt(CompExpressionContext ctx) {
        TLValue lhs = this.visit(ctx.expression(0));
        TLValue rhs = this.visit(ctx.expression(1));
        if (lhs.isNumber() && rhs.isNumber()) {
            return new TLValue(lhs.asDouble() > rhs.asDouble());
        }
        if (lhs.isString() && rhs.isString()) {
            return new TLValue(lhs.asString().compareTo(rhs.asString()) > 0);
        }
        throw new EvalException(ctx);
    }

    private TLValue lt(CompExpressionContext ctx) {
        TLValue lhs = this.visit(ctx.expression(0));
        TLValue rhs = this.visit(ctx.expression(1));
        if (lhs.isNumber() && rhs.isNumber()) {
            return new TLValue(lhs.asDouble() < rhs.asDouble());
        }
        if (lhs.isString() && rhs.isString()) {
            return new TLValue(lhs.asString().compareTo(rhs.asString()) < 0);
        }
        throw new EvalException(ctx);
    }

    private TLValue eq(EqExpressionContext ctx) {
        TLValue lhs = this.visit(ctx.expression(0));
        TLValue rhs = this.visit(ctx.expression(1));
        if (lhs == null) {
            throw new EvalException(ctx);
        }
        return new TLValue(lhs.equals(rhs));
    }

    private TLValue nEq(EqExpressionContext ctx) {
        TLValue lhs = this.visit(ctx.expression(0));
        TLValue rhs = this.visit(ctx.expression(1));
        return new TLValue(!lhs.equals(rhs));
    }

    // expression '&&' expression               #andExpression
    @Override
    public TLValue visitAndExpression(AndExpressionContext ctx) {
        TLValue lhs = this.visit(ctx.expression(0));
        TLValue rhs = this.visit(ctx.expression(1));

        if (!lhs.isBoolean() || !rhs.isBoolean()) {
            throw new EvalException(ctx);
        }
        return new TLValue(lhs.asBoolean() && rhs.asBoolean());
    }

    // expression '||' expression               #orExpression
    @Override
    public TLValue visitOrExpression(OrExpressionContext ctx) {
        TLValue lhs = this.visit(ctx.expression(0));
        TLValue rhs = this.visit(ctx.expression(1));

        if (!lhs.isBoolean() || !rhs.isBoolean()) {
            throw new EvalException(ctx);
        }
        return new TLValue(lhs.asBoolean() || rhs.asBoolean());
    }

    // Number                                   #numberExpression
    @Override
    public TLValue visitNumberExpression(NumberExpressionContext ctx) {
        return new TLValue(Double.valueOf(ctx.getText()));
    }

    private TLValue resolveIndexes(TLValue val, List<ExpressionContext> indexes) {
        for (ExpressionContext ec : indexes) {
            TLValue idx = this.visit(ec);
            if (!idx.isNumber() || (!val.isList() && !val.isString())) {
                throw new EvalException("Problem resolving indexes on " + val + " at " + idx, ec);
            }
            int i = idx.asDouble().intValue();
            if (val.isString()) {
                val = new TLValue(val.asString().substring(i, i + 1));
            } else {
                val = val.asList().get(i);
            }
        }
        return val;
    }

    private void setAtIndex(ParserRuleContext ctx, List<ExpressionContext> indexes, TLValue val, TLValue newVal) {
        if (!val.isList()) {
            throw new EvalException(ctx);
        }
        for (int i = 0; i < indexes.size() - 1; i++) {
            TLValue idx = this.visit(indexes.get(i));
            if (!idx.isNumber()) {
                throw new EvalException(ctx);
            }
            val = val.asList().get(idx.asDouble().intValue());
        }
        TLValue idx = this.visit(indexes.get(indexes.size() - 1));
        if (!idx.isNumber()) {
            throw new EvalException(ctx);
        }
        val.asList().set(idx.asDouble().intValue(), newVal);
    }

    // Identifier indexes?                      #identifierExpression
    @Override
    public TLValue visitIdentifierExpression(IdentifierExpressionContext ctx) {
        String id = ctx.Identifier().getText();
        TLValue val = scope.resolve(id);

        if (ctx.indexes() != null) {
            List<ExpressionContext> exps = ctx.indexes().expression();
            val = resolveIndexes(val, exps);
        }
        return val;
    }

    // String indexes?                          #stringExpression
    @Override
    public TLValue visitStringExpression(StringExpressionContext ctx) {
        String text = ctx.getText();
        text = text.substring(1, text.length() - 1).replaceAll("\\\\(.)", "$1");
        TLValue val = new TLValue(text);
        if (ctx.indexes() != null) {
            List<ExpressionContext> exps = ctx.indexes().expression();
            val = resolveIndexes(val, exps);
        }
        return val;
    }

    // '(' expression ')' indexes?              #expressionExpression
    @Override
    public TLValue visitExpressionExpression(ExpressionExpressionContext ctx) {
        TLValue val = this.visit(ctx.expression());
        if (ctx.indexes() != null) {
            List<ExpressionContext> exps = ctx.indexes().expression();
            val = resolveIndexes(val, exps);
        }
        return val;
    }


    // assignment
    // : Identifier indexes? '=' expression
    // ;
    @Override
    public TLValue visitAssignment(AssignmentContext ctx) {
        TLValue newVal = this.visit(ctx.expression());
        if (ctx.indexes() != null) {
            TLValue val = scope.resolve(ctx.Identifier().getText());
            List<ExpressionContext> exps = ctx.indexes().expression();
            setAtIndex(ctx, exps, val, newVal);
        } else {
            String id = ctx.Identifier().getText();
            scope.assign(id, newVal);
        }
        return TLValue.VOID;
    }

    // ifStatement
    //  : ifStat elseIfStat* elseStat? End
    //  ;
    //
    // ifStat
    //  : If expression Do block
    //  ;
    //
    // elseIfStat
    //  : Else If expression Do block
    //  ;
    //
    // elseStat
    //  : Else Do block
    //  ;
    @Override
    public TLValue visitIfStatement(IfStatementContext ctx) {

        // if ...
        if (this.visit(ctx.ifStat().expression()).asBoolean()) {
            return this.visit(ctx.ifStat().stmt_sequence());
        }

        // else if ...
        if (this.visit(ctx.elseStat().Else()).asBoolean()) {
            return this.visit(ctx.elseStat().stmt_sequence());
        }
        // else ...
        if (ctx.elseStat() != null) {
            return this.visit(ctx.elseStat().stmt_sequence());
        }

        return TLValue.VOID;
    }

    @Override
    public TLValue visitStmt_sequence(TLParser.Stmt_sequenceContext ctx) {

        scope = new Scope(scope); // create new local scope
        for (StatementContext sx : ctx.statement()) {
            this.visit(sx);
        }
        ExpressionContext ex;
        if ((ex = ctx.expression()) != null) {
            TLValue value = this.visit(ex);
            scope = scope.parent();
            throw new RuntimeException(value.toString());
        }
        scope = scope.parent();
        return TLValue.VOID;
    }


}
