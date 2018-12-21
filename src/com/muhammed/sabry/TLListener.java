package com.muhammed.sabry;// Generated from C:/Users/Muhammed/IdeaProjects/tiny-language-github/src/main/antlr4/tl/antlr4\TL.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TLParser}.
 */
public interface TLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TLParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(TLParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(TLParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLParser#stmt_sequence}.
	 * @param ctx the parse tree
	 */
	void enterStmt_sequence(TLParser.Stmt_sequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLParser#stmt_sequence}.
	 * @param ctx the parse tree
	 */
	void exitStmt_sequence(TLParser.Stmt_sequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(TLParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(TLParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLParser#repeat_stmt}.
	 * @param ctx the parse tree
	 */
	void enterRepeat_stmt(TLParser.Repeat_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLParser#repeat_stmt}.
	 * @param ctx the parse tree
	 */
	void exitRepeat_stmt(TLParser.Repeat_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLParser#read_stmt}.
	 * @param ctx the parse tree
	 */
	void enterRead_stmt(TLParser.Read_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLParser#read_stmt}.
	 * @param ctx the parse tree
	 */
	void exitRead_stmt(TLParser.Read_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLParser#write_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWrite_stmt(TLParser.Write_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLParser#write_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWrite_stmt(TLParser.Write_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(TLParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(TLParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(TLParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(TLParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(TLParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(TLParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLParser#elseStat}.
	 * @param ctx the parse tree
	 */
	void enterElseStat(TLParser.ElseStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLParser#elseStat}.
	 * @param ctx the parse tree
	 */
	void exitElseStat(TLParser.ElseStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(TLParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(TLParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqExpression(TLParser.EqExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqExpression(TLParser.EqExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(TLParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(TLParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringExpression(TLParser.StringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringExpression(TLParser.StringExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionExpression(TLParser.ExpressionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionExpression(TLParser.ExpressionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddExpression(TLParser.AddExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddExpression(TLParser.AddExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCompExpression(TLParser.CompExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCompExpression(TLParser.CompExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpression(TLParser.NumberExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpression(TLParser.NumberExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(TLParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(TLParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultExpression(TLParser.MultExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultExpression(TLParser.MultExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLParser#indexes}.
	 * @param ctx the parse tree
	 */
	void enterIndexes(TLParser.IndexesContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLParser#indexes}.
	 * @param ctx the parse tree
	 */
	void exitIndexes(TLParser.IndexesContext ctx);
}