package net.sourceforge.pmd.lang.plsql.ast;

import org.junit.Test;

import net.sourceforge.pmd.lang.plsql.AbstractPLSQLParserTst;

public class ASTParseErrorTest extends AbstractPLSQLParserTst {

    @Test
    public void ASTParserError() {
        try {
            ASTInput input = plsql.parseResource("ASTErrorParse.sql");
        } catch (Exception ex) {
            assert (ex.getMessage().contains("SELECT"));
        }
        //as expected the class is failing with
    }
}
