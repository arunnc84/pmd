/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.ast.impl.javacc;

import net.sourceforge.pmd.lang.ast.TextAvailableNode;
import net.sourceforge.pmd.lang.ast.impl.GenericNode;

/**
 * Base interface for nodes that are produced by a JJTree parser. Our
 * JJTree implementation gives {@link TextAvailableNode} for free, access
 * to tokens is also guaranteed.
 *
 * @param <N> Self type
 */
public interface JjtreeNode<N extends JjtreeNode<N>> extends GenericNode<N>, TextAvailableNode {


    JavaccToken getFirstToken();

    JavaccToken getLastToken();

}