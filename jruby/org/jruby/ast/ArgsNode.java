/*
 * ArgsNode.java - No description
 * Created on 05. November 2001, 21:15
 * 
 * Copyright (C) 2001, 2002 Jan Arne Petersen, Benoit Cerrina
 * Jan Arne Petersen <jpetersen@uni-bonn.de>
 * Benoit Cerrina <b.cerrina@wanadoo.fr>
 * 
 * JRuby - http://jruby.sourceforge.net
 * 
 * This file is part of JRuby
 * 
 * JRuby is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * JRuby is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with JRuby; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 * 
 */
package org.jruby.ast;

import org.jruby.*;
import org.jruby.ast.types.*;
import org.jruby.ast.visitor.*;
import org.jruby.runtime.*;
import org.ablaf.ast.visitor.INodeVisitor;
import org.ablaf.common.ISourcePosition;

/**
 * arguments for a function.
 *  this is used both in the function definition
 * and in actual function calls                                     
 * <ul>
 * <li>
 * u1 ==&gt; optNode (BlockNode) Optional argument description
 * </li>
 * <li>
 * u2 ==&gt; rest (int) index of the rest argument (the array arg with a * in front 
 * </li>
 * <li>
 * u3 ==&gt; count (int) number of arguments
 * </li>
 * </ul>
 *
 * @author  jpetersen
 */
public class ArgsNode extends AbstractNode {
    private int argsCount;
    private IListNode optArgs;
    private int restArg;
    private BlockArgNode blockArgNode;

    /**
     * 
     * @param optNode  Node describing the optional arguments
     * 				This Block will contain assignments to locals (LAsgnNode)
     * @param rest  index of the rest argument in the local table
     * 				(the array argument prefixed by a * which collects 
     * 				all additional params)
     * 				or -1 if there is none.
     * @param count number of regular arguments
     * @param blockArgNode An optional block argument (&amp;arg).
     **/
    public ArgsNode(ISourcePosition iPosition, int argsCount, IListNode optArgs, int restArg, BlockArgNode blockArgNode) {
        super(iPosition);

        this.argsCount = argsCount;
        this.optArgs = optArgs;
        this.restArg = restArg;
        this.blockArgNode = blockArgNode;
    }

    /**
     * Accept for the visitor pattern.
     * @param iVisitor the visitor
     **/
    public void accept(INodeVisitor iVisitor) {
        ((NodeVisitor)iVisitor).visitArgsNode(this);
    }

    /**
     * Gets the argsCount.
     * @return Returns a int
     */
    public int getArgsCount() {
        return argsCount;
    }

    /**
     * Sets the argsCount.
     * @param argsCount The argsCount to set
     */
    public void setArgsCount(int argsCount) {
        this.argsCount = argsCount;
    }

    /**
     * Gets the optArgs.
     * @return Returns a IListNode
     */
    public IListNode getOptArgs() {
        return optArgs;
    }

    /**
     * Sets the optArgs.
     * @param optArgs The optArgs to set
     */
    public void setOptArgs(IListNode optArgs) {
        this.optArgs = optArgs;
    }

    /**
     * Gets the restArg.
     * @return Returns a int
     */
    public int getRestArg() {
        return restArg;
    }

    /**
     * Sets the restArg.
     * @param restArg The restArg to set
     */
    public void setRestArgs(int restArg) {
        this.restArg = restArg;
    }

    /**
     * Gets the blockArgNode.
     * @return Returns a BlockArgNode
     */
    public BlockArgNode getBlockArgNode() {
        return blockArgNode;
    }

    /**
     * Sets the blockArgNode.
     * @param blockArgNode The blockArgNode to set
     */
    public void setBlockArgNode(BlockArgNode blockArgNode) {
        this.blockArgNode = blockArgNode;
    }
}
