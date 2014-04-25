package com.excilys.om;

import static com.mysema.query.types.path.PathMetadataFactory.*;
import com.mysema.query.types.*;
import com.mysema.query.types.path.*;


/**
 * QCompany is a Querydsl query type for Company
 */
public class QCompany extends PEntity<Company> {

    private static final long serialVersionUID = 316333275;

    public static final QCompany company = new QCompany("company");

    public final PNumber<Long> id = createNumber("id", Long.class);

    public final PString name = createString("name");

    public QCompany(String variable) {
        super(Company.class, forVariable(variable));
    }

    public QCompany(PEntity<? extends Company> entity) {
        super(entity.getType(),entity.getMetadata());
    }

    public QCompany(PathMetadata<?> metadata) {
        super(Company.class, metadata);
    }

}

