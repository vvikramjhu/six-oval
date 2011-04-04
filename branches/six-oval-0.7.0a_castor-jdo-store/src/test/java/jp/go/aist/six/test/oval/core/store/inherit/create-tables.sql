use test;



/* ============================================================== */
/* Test                                                           */
/* ============================================================== */
DROP TABLE IF EXISTS oval_d_test;
CREATE TABLE IF NOT EXISTS oval_d_test
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:org.mitre.oval:obj:419:1 */

    castor_ts           BIGINT,

    id                  VARCHAR(64)     NOT NULL,
                        /* e.g. oval:org.mitre.oval:obj:419 */
    version             INT             NOT NULL,

    deprecated          BOOLEAN                     DEFAULT false,
    comment             VARCHAR(255)    NOT NULL,

    check1              VARCHAR(16)     NOT NULL,
    existence           VARCHAR(20)                 DEFAULT 'at_least_one_exists',

    state_operator      VARCHAR(4)                  DEFAULT 'AND',
    
    object_ref          VARCHAR(64),

    entity_type         VARCHAR(32)     NOT NULL,

    /* (FK) */

    /* (PK) */
    PRIMARY KEY (PID),

    /* INDEX */
    UNIQUE (id, version)

)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* StateRef                                                       */
/* ============================================================== */
DROP TABLE IF EXISTS oval_d_test__state_ref;
CREATE TABLE IF NOT EXISTS oval_d_test__state_ref
(
    PID                 INT             NOT NULL    AUTO_INCREMENT,
    
    state_ref           VARCHAR(64)     NOT NULL,

    /* (FK) */
    d_test__PID         VARCHAR(64)     NOT NULL,

    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* RegistryTest                                                   */
/* ============================================================== */
DROP TABLE IF EXISTS oval_d_test_registry;
CREATE TABLE IF NOT EXISTS oval_d_test_registry
(
    PID                 VARCHAR(64)     NOT NULL,

    /* (FK) */

    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;


