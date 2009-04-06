/*
 * Copyright (c) 2008 Mysema Ltd.
 * All rights reserved.
 * 
 */
package com.mysema.query;

import com.mysema.query.grammar.OrderSpecifier;
import com.mysema.query.grammar.types.Expr;
import com.mysema.query.grammar.types.Expr.EBoolean;

/**
 * QueryBase provides a basic implementation of the Query interface without the Projectable interface
 * 
 * @author tiwe
 * @version $Id$
 */
public class QueryBase<JoinMeta,SubType extends QueryBase<JoinMeta,SubType>> implements Query<SubType> {
    @SuppressWarnings("unchecked")
    private SubType _this = (SubType)this;
    
    private QueryMetadata<JoinMeta> metadata;
    
    protected String toString;

    public QueryBase() {
        this.metadata = new DefaultMetadata<JoinMeta>();
    }
    
    public QueryBase(QueryMetadata<JoinMeta> metadata) {
        this.metadata = metadata; 
    }
    
    protected SubType addToProjection(Expr<?>... o) {
        metadata.addToProjection(o);
        return _this;
    }
    
    protected void clear(){
        metadata = new DefaultMetadata<JoinMeta>();
    }
    
    public SubType from(Expr<?>... o) {        
        metadata.addToFrom(o);
        return _this;
    }
        
    public SubType fullJoin(Expr<?> o) {
        metadata.addJoin(JoinType.FULLJOIN, o);
        return _this;
    }
    
    public QueryMetadata<JoinMeta> getMetadata(){
        return metadata;
    }
    
    public SubType groupBy(Expr<?>... o) {
        metadata.addToGroupBy(o);
        return _this;
    }
 
    public SubType having(EBoolean... o) {
        metadata.addToHaving(o);
        return _this;
    }
 
    public SubType innerJoin(Expr<?> o) {
        metadata.addJoin(JoinType.INNERJOIN, o);
        return _this;
    }
    
    public SubType join(Expr<?> o) {
        metadata.addJoin(JoinType.JOIN, o);
        return _this;
    }
    
    public SubType leftJoin(Expr<?> o) {
        metadata.addJoin(JoinType.LEFTJOIN, o);
        return _this;
    }

    public SubType on(EBoolean o) {
        metadata.addJoinCondition(o);
        return _this;
    }
        
    public SubType orderBy(OrderSpecifier<?>... o) {
        metadata.addToOrderBy(o);
        return _this;
    }
    
    public SubType where(EBoolean... o) {
        metadata.addToWhere(o);
        return _this;
    }
    

}
