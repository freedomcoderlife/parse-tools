package com.freedom.cn;

import com.freedom.cn.custom.CStructLexer;
import com.freedom.cn.custom.CStructParser;
import com.freedom.cn.custom.CustomStructListener;
import com.freedom.cn.grammer.CLexer;
import com.freedom.cn.grammer.CParser;
import com.freedom.cn.grammer.StructListener;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

/**
 * Hello world!
 * 首字母大写时词法，小写时语法
 *
 */
public class App {
    public static void main( String[] args ) throws Exception {
        testStruct();
    }

    public static void testC() throws IOException {
        ANTLRFileStream input = new ANTLRFileStream("/home/liming/code/java/c-parse/src/main/resources/test.c");
        CLexer cLexer = new CLexer(input);
        CommonTokenStream commonTokenStream = new CommonTokenStream(cLexer);

        CParser cParser = new CParser(commonTokenStream);
        CParser.TypeSpecifierContext typeSpecifierContext = cParser.typeSpecifier();
        ParseTreeWalker walk = new ParseTreeWalker();
        StructListener structListener = new StructListener();
        walk.walk(structListener, typeSpecifierContext);
    }

    public static void testStruct() throws IOException {
        ANTLRFileStream input = new ANTLRFileStream("/home/liming/code/java/c-parse/src/main/resources/test.c");
        CStructLexer cStructLexer = new CStructLexer(input);
        CommonTokenStream commonTokenStream = new CommonTokenStream(cStructLexer);
        CStructParser cStructParser = new CStructParser(commonTokenStream);
        cStructParser.setTrace(true);
        CStructParser.PorgContext porg = cStructParser.porg();
        ParseTreeWalker walk = new ParseTreeWalker();
        CustomStructListener structListener = new CustomStructListener();
        walk.walk(structListener, porg);

        String s = porg.toStringTree(cStructParser);
        System.out.println(s);

    }

}
