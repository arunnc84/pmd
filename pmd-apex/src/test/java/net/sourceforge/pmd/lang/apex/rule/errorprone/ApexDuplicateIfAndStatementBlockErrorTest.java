package net.sourceforge.pmd.lang.apex.rule.errorprone;

import net.sourceforge.pmd.cpd.CPD;
import net.sourceforge.pmd.cpd.CPDConfiguration;
import net.sourceforge.pmd.cpd.LanguageFactory;
import net.sourceforge.pmd.cpd.Match;
import net.sourceforge.pmd.lang.apex.ApexLanguageModule;
import org.apache.commons.io.FilenameUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ApexDuplicateIfAndStatementBlockErrorTest {
    private File testdir;

    @Before
    public void setUp() {
        String path = FilenameUtils.normalize("src/test/resources/net/sourceforge/pmd/cpd/issue427");
        testdir = new File(path);
    }

    @Test
    public void testStatementAndIfBlockErrors() throws IOException {
        CPDConfiguration configuration = new CPDConfiguration();
        configuration.setMinimumTileSize(10);
        configuration.setLanguage(LanguageFactory.createLanguage(ApexLanguageModule.TERSE_NAME));
        CPD cpd = new CPD(configuration);
        cpd.add(new File(testdir, "PmdReplication.cls"));

        cpd.go();

        Iterator<Match> matches = cpd.getMatches();
        int duplications = 0;
        while (matches.hasNext()) {
            matches.next();
            duplications++;
        }
        assertEquals(1, duplications);
        Match firstDuplication = cpd.getMatches().next();
        assertTrue(firstDuplication.getSourceCodeSlice().startsWith("global with sharing class SFDCEncoder"));
    }
}
