package com.freedom.cn.grammer;

import org.antlr.v4.runtime.tree.TerminalNode;

public class StructListener extends CBaseListener {


    public void enterStructOrUnionSpecifier(CParser.StructOrUnionSpecifierContext ctx) {
//        String stuctDeclarList = ctx.structDeclarationList().getText();
//        System.out.println(stuctDeclarList);
//        TerminalNode identifier = ctx.Identifier();
//        System.out.println(identifier);
    }

    public void exitStructOrUnionSpecifier(CParser.StructOrUnionSpecifierContext ctx) {

//        int childCount = ctx.getChildCount();
//
//        for (int i=0; i < childCount; i++)  {
//            System.out.println(ctx.getChild(i).getText());
//        }


        if (ctx.structDeclarationList() != null) {
            String stuctDeclarList = ctx.structDeclarationList().getText();
            System.out.println(stuctDeclarList);
            TerminalNode identifier = ctx.Identifier();
            System.out.println(identifier);
        }
    }

    @Override public void exitStructOrUnion(CParser.StructOrUnionContext ctx) {


//        System.out.println("exitStructOrUnion====="  + ctx.getText());

    }

    @Override public void exitStructDeclarationList(CParser.StructDeclarationListContext ctx) {

//        String text = ctx.getText();
//        System.out.println("======exitStructDeclarationList============="+text);

    }

    @Override public void enterStructDeclarationList(CParser.StructDeclarationListContext ctx) {

//        String text = ctx.getText();
//        System.out.println("======enter============="+text);

    }


}
