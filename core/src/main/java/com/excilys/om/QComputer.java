package com.excilys.om;

import static com.mysema.query.types.path.PathMetadataFactory.*;
import com.mysema.query.types.*;
import com.mysema.query.types.path.*;


/**
 * QComputer is a Querydsl query type for Computer
 */
public class QComputer extends PEntity<Computer> {

    private static final long serialVersionUID = 1216998013;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QComputer computer = new QComputer("computer");

    public final QCompany company;

    public final PDateTime<org.joda.time.DateTime> discontinued = createDateTime("discontinued", org.joda.time.DateTime.class);

    public final PNumber<Long> id = createNumber("id", Long.class);

    public final PDateTime<org.joda.time.DateTime> introduced = createDateTime("introduced", org.joda.time.DateTime.class);

    public final PString name = createString("name");

    public QComputer(String variable) {
        this(Computer.class, forVariable(variable), INITS);
    }

    public QComputer(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QComputer(PathMetadata<?> metadata, PathInits inits) {
        this(Computer.class, metadata, inits);
    }

    public QComputer(Class<? extends Computer> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.company = inits.isInitialized("company") ? new QCompany(forProperty("company")) : null;
    }

}

