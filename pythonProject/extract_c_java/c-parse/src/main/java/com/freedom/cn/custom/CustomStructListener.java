package com.freedom.cn.custom;


import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

public class CustomStructListener extends CStructBaseListener {


    public void exitStructDefine(CStructParser.StructDefineContext ctx) {


        String text = ctx.struct().getText();

        System.out.println(text);

        String text1 = ctx.Identifier().getText();

        System.out.println(text1);

        String text2 = ctx.structFields().getText();
        System.out.println("============list======="+text2);

    }



}
