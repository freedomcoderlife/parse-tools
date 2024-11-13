// Generated from CStruct.g4 by ANTLR 4.13.2
 package com.freedom.cn.custom; 
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CStructParser}.
 */
public interface CStructListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CStructParser#porg}.
	 * @param ctx the parse tree
	 */
	void enterPorg(CStructParser.PorgContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStructParser#porg}.
	 * @param ctx the parse tree
	 */
	void exitPorg(CStructParser.PorgContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStructParser#struct}.
	 * @param ctx the parse tree
	 */
	void enterStruct(CStructParser.StructContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStructParser#struct}.
	 * @param ctx the parse tree
	 */
	void exitStruct(CStructParser.StructContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStructParser#union}.
	 * @param ctx the parse tree
	 */
	void enterUnion(CStructParser.UnionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStructParser#union}.
	 * @param ctx the parse tree
	 */
	void exitUnion(CStructParser.UnionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStructParser#structDefine}.
	 * @param ctx the parse tree
	 */
	void enterStructDefine(CStructParser.StructDefineContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStructParser#structDefine}.
	 * @param ctx the parse tree
	 */
	void exitStructDefine(CStructParser.StructDefineContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStructParser#structFields}.
	 * @param ctx the parse tree
	 */
	void enterStructFields(CStructParser.StructFieldsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStructParser#structFields}.
	 * @param ctx the parse tree
	 */
	void exitStructFields(CStructParser.StructFieldsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStructParser#unionInStruct}.
	 * @param ctx the parse tree
	 */
	void enterUnionInStruct(CStructParser.UnionInStructContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStructParser#unionInStruct}.
	 * @param ctx the parse tree
	 */
	void exitUnionInStruct(CStructParser.UnionInStructContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStructParser#structInStruct}.
	 * @param ctx the parse tree
	 */
	void enterStructInStruct(CStructParser.StructInStructContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStructParser#structInStruct}.
	 * @param ctx the parse tree
	 */
	void exitStructInStruct(CStructParser.StructInStructContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStructParser#structField}.
	 * @param ctx the parse tree
	 */
	void enterStructField(CStructParser.StructFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStructParser#structField}.
	 * @param ctx the parse tree
	 */
	void exitStructField(CStructParser.StructFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStructParser#structOrUnionField}.
	 * @param ctx the parse tree
	 */
	void enterStructOrUnionField(CStructParser.StructOrUnionFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStructParser#structOrUnionField}.
	 * @param ctx the parse tree
	 */
	void exitStructOrUnionField(CStructParser.StructOrUnionFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStructParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeSpecifier(CStructParser.TypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStructParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeSpecifier(CStructParser.TypeSpecifierContext ctx);
}