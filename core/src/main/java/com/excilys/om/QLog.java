package com.excilys.om;

import static com.mysema.query.types.path.PathMetadataFactory.*;
import com.mysema.query.types.*;
import com.mysema.query.types.path.*;


/**
 * QLog is a Querydsl query type for Log
 */
public class QLog extends PEntity<Log> {

    private static final long serialVersionUID = 912269986;

    public static final QLog log = new QLog("log");

    public final PNumber<Long> id = createNumber("id", Long.class);

    public final PString request = createString("request");

    public QLog(String variable) {
        super(Log.class, forVariable(variable));
    }

    public QLog(PEntity<? extends Log> entity) {
        super(entity.getType(),entity.getMetadata());
    }

    public QLog(PathMetadata<?> metadata) {
        super(Log.class, metadata);
    }

}

