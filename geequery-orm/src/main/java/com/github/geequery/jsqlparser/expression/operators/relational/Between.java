/*
 * JEF - Copyright 2009-2010 Jiyi (mr.jiyi@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.geequery.jsqlparser.expression.operators.relational;

import com.github.geequery.jsqlparser.visitor.Expression;
import com.github.geequery.jsqlparser.visitor.ExpressionType;
import com.github.geequery.jsqlparser.visitor.ExpressionVisitor;
import com.github.geequery.jsqlparser.visitor.Ignorable;
import com.github.geequery.jsqlparser.visitor.Notable;

/**
 * A "BETWEEN" expr1 expr2 statement
 */
public class Between implements Expression,Ignorable,Notable {

    private Expression leftExpression;

    private boolean not = false;

    private Expression betweenExpressionStart;

    private Expression betweenExpressionEnd;

    public Expression getBetweenExpressionEnd() {
        return betweenExpressionEnd;
    }

    public Expression getBetweenExpressionStart() {
        return betweenExpressionStart;
    }

    public Expression getLeftExpression() {
        return leftExpression;
    }

    public boolean isNot() {
        return not;
    }

    public void setBetweenExpressionEnd(Expression expression) {
        betweenExpressionEnd = expression;
    }

    public void setBetweenExpressionStart(Expression expression) {
        betweenExpressionStart = expression;
    }

    public void setLeftExpression(Expression expression) {
        leftExpression = expression;
    }

    public void setNot(boolean b) {
        not = b;
    }

    public void accept(ExpressionVisitor expressionVisitor) {
        expressionVisitor.visit(this);
    }

    public String toString() {
    	StringBuilder sb=new StringBuilder();
    	appendTo(sb);
        return sb.toString();
    }

	public void appendTo(StringBuilder sb) {
		leftExpression.appendTo(sb);
		sb.append(' ');
		if(not)sb.append("NOT ");
		sb.append("BETWEEN ");
		betweenExpressionStart.appendTo(sb);
		sb.append(" AND ");
		betweenExpressionEnd.appendTo(sb);
	}
	  //变量绑定值是否为空
    private final ThreadLocal<Boolean> isEmpty = new ThreadLocal<Boolean>();
    
    public boolean isEmpty() {
    	Boolean e=isEmpty.get();
		return e!=null && e;
	}

    public void setEmpty(Boolean isEmpty) {
		this.isEmpty.set(isEmpty);
	}

	public ExpressionType getType() {
		return ExpressionType.between;
	}
}
