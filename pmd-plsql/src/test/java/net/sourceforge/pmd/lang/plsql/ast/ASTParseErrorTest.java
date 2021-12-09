package net.sourceforge.pmd.lang.plsql.ast;

import org.junit.Assert;
import org.junit.Test;

import net.sourceforge.pmd.lang.plsql.AbstractPLSQLParserTst;

/**
 * Test to replciate the SQL parser error
 */

public class ASTParseErrorTest extends AbstractPLSQLParserTst {

    /**
     * Test method to execute parse based on the test SQL from file
     */
    @Test
    public void astParserError() {
        try {
            ASTInput input = plsql.parseResource("ASTErrorParse.sql");
            Assert.assertNotNull("Null, No good",input);
        } catch (Exception ex) {
            Assert.assertTrue ("No Match No Good",ex.getMessage().contains("SELECT"));
        }
    }
}
