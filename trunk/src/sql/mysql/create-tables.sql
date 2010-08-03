/* ////////////////////////////////////////////////////////////// */
/* // Project SIX: OVAL                                        // */
/* //                                                          // */
/* // Database Schema Definition SQL                           // */
/* ////////////////////////////////////////////////////////////// */

/* @author  Akihito Nakamura, AIST */
/* @version $Id$ */
/* @engine  mysql */


use @six.db.database@;

/* %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% */
/* %                                                            % */
/* % Common Rules: Data types and length                        % */
/* %                                                            % */
/* %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% */

-- * UUID:
--      xxx                 CHAR(36),
--
-- * URL:
--      xxx                 VARCHAR(255),
--
-- * Generator:
--      gen_timestamp       DATETIME        NOT NULL,
--      gen_schema_version  VARCHAR(8)      NOT NULL,
--      gen_product_name    VARCHAR(64),
--      gen_product_version VARCHAR(64),
--
-- * datatype               VARCHAR(16),
--                          /* max. length = 16, 'fileset_revision' */
--
-- * OVAL ID (e.g. 'oval:org.mitre.oval:def:1001')
--      id                  VARCHAR(64)    NOT NULL,
--
-- * host name:
--                          VARCHAR(64),
-- * message digest:
--      xxx_digest          VARCHAR(32),



/* %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% */
/* %                                                            % */
/* % OVAL Definitions                                           % */
/* %                                                            % */
/* %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% */

/* ============================================================== */
/* OvalDefinitions                                                */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_definitions
(
    PID                 CHAR(36)        NOT NULL,
                        /* 911d6c54-6965-48df-88c3-2af47e54acd2 */

    gen_timestamp       DATETIME        NOT NULL,
    gen_schema_version  VARCHAR(8)      NOT NULL,
    gen_product_name    VARCHAR(64),
    gen_product_version VARCHAR(64),
    
    definitions_digest  VARCHAR(32)  /* NOT NULL */,
/*    objects_digest      VARCHAR(32)     NOT NULL, */

    /* (PK) */
    PRIMARY KEY(PID),

    /* INDEX */
    INDEX (definitions_digest)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* Definition                                                     */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_definition
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:com.redhat.rhsa:def:20090003:302 */

    id                  VARCHAR(64)     NOT NULL,
                        /* e.g. oval:com.redhat.rhsa:def:20090003 */
    version             INT             NOT NULL,
    deprecated          BOOLEAN         NOT NULL    DEFAULT false,

    class               VARCHAR(16)     NOT NULL,
                        /* ENUM( 'vulnerability', 'patch', 'inventory', ...) */

    /* // metadata // */
    last_modified       VARCHAR(10),
                        /* e.g. '2009-05-07' */
    affected_family     VARCHAR(16)     NOT NULL,
                        /* ENUM( 'ios', 'unix', 'windows', ...) */
    title               VARCHAR(255)    NOT NULL,
    description         VARCHAR(4095)   NOT NULL,
                        /* max. length = 3960, id = com.redhat.rhsa:def:20090473 */

    /* criteria as string */
    /* This column is moved to oval_d_definition_criteria table. */
/*  criteria            VARCHAR(8191), */ 
                        /* max. length = 7452, id = oval:org.mitre.oval:def:6233 */

    /* (FK) */

    /* (PK) */
    PRIMARY KEY (PID),

    /* INDEX */
    UNIQUE (id, version),
    INDEX  (affected_family)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* DefinitionCriteria                                             */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_definition_criteria
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:com.redhat.rhsa:def:20090003:302 */

    id                  VARCHAR(64)     NOT NULL,
                        /* e.g. oval:com.redhat.rhsa:def:20090003 */
    version             INT             NOT NULL,

    /* criteria as string */
    criteria            MEDIUMTEXT,
                        /* max. length = 49,152, id = oval:com.redhat.rhsa:def:20100101 */

    /* (FK) */

    /* (PK) */
    PRIMARY KEY (PID),

    /* INDEX */
    UNIQUE (id, version)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* OvalDefinitions - Definition association                       */
/* ============================================================== */
/* CREATE TABLE IF NOT EXISTS oval_d_definitions__definition */
CREATE TABLE IF NOT EXISTS oval_assoc__d_definitions__d_definition
(
    PID                 INT             NOT NULL    AUTO_INCREMENT,

    /* (FK) */
    definitions__PID    CHAR(36)        NOT NULL,
    definition__PID     VARCHAR(64)     NOT NULL,

    /* (PK) */
    PRIMARY KEY (PID),
    
    /* INDEX */
    UNIQUE (definitions__PID, definition__PID)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* Reference                                                      */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_reference
(
    PID                 INT             NOT NULL    AUTO_INCREMENT,

    source              VARCHAR(64)     NOT NULL,
    ref_id              VARCHAR(64)     NOT NULL,
    ref_url             VARCHAR(255),

    /* (FK) */

    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* Definition - Reference association                             */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_assoc__d_definition__d_reference
(
    PID                 INT             NOT NULL    AUTO_INCREMENT,

    definition__PID     VARCHAR(64)     NOT NULL,
    reference__PID      INT             NOT NULL,

    /* (PK) */
    PRIMARY KEY (PID),
    
    /* INDEX */
    UNIQUE (definition__PID, reference__PID)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* Platform                                                       */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_platform
(
    PID                 VARCHAR(128)    NOT NULL,
                        /* e.g. 'Red Hat Enterprise Linux 5', 'Microsoft Windows XP' */

    /* (PK) */
    PRIMARY KEY (PID)

)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* Definition - Platform association                              */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_assoc__d_definition__d_platform
(
    PID                 INT             NOT NULL    AUTO_INCREMENT,

    definition__PID     VARCHAR(64)     NOT NULL,
    platform__PID       VARCHAR(128)    NOT NULL,

    /* (PK) */
    PRIMARY KEY (PID),
    
    /* INDEX */
    UNIQUE (definition__PID, platform__PID)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* Product                                                        */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_product
(
    PID                 VARCHAR(128)    NOT NULL,
                        /* e.g. 'Microsoft Internet Explorer' */

    /* (PK) */
    PRIMARY KEY (PID)

)
ENGINE=InnoDB
CHARACTER SET utf8;


/* ============================================================== */
/* Definition - Product association                               */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_assoc__d_definition__d_product
(
    PID                 INT             NOT NULL    AUTO_INCREMENT,

    definition__PID     VARCHAR(64)     NOT NULL,
    product__PID        VARCHAR(128)    NOT NULL,

    /* (PK) */
    PRIMARY KEY (PID),
    
    /* INDEX */
    UNIQUE (definition__PID, product__PID)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* Cve                                                            */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_cve
(
    PID                 CHAR(13)        NOT NULL,
                        /* e.g. 'CVE-2009-0001' */

    /* (PK) */
    PRIMARY KEY (PID)
)
ENGINE=InnoDB
CHARACTER SET utf8;


/* ============================================================== */
/* Definition - Cve association                                   */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_assoc__d_definition__d_cve
(
    PID                 INT             NOT NULL    AUTO_INCREMENT,

    definition__PID     VARCHAR(64)     NOT NULL,
    cve__PID            CHAR(13)        NOT NULL,

    /* (PK) */
    PRIMARY KEY (PID),
    
    /* INDEX */
    UNIQUE (definition__PID, cve__PID)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* Test                                                           */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_test
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:org.mitre.oval:obj:419:1 */

    id                  VARCHAR(64)     NOT NULL,
                        /* e.g. oval:org.mitre.oval:obj:419 */
    version             INT             NOT NULL,

    deprecated          BOOLEAN         NOT NULL    DEFAULT false,
    comment             VARCHAR(255),

    tst_check           VARCHAR(16)     NOT NULL,
    tst_existence       VARCHAR(20)                 DEFAULT 'at_least_one_exists',

    state_operator      VARCHAR(4)                  DEFAULT 'AND',
    
    object__id          VARCHAR(64),

    object_type         VARCHAR(32)     NOT NULL,

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
CREATE TABLE IF NOT EXISTS oval_d_test__state_ref
(
    PID                 INT             NOT NULL    AUTO_INCREMENT,
    
    state_ref           VARCHAR(64)     NOT NULL,

    /* (FK) */
    test__PID           VARCHAR(64)     NOT NULL,

    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* OvalDefinitions - Test association                             */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_assoc__d_definitions__d_test
(
    PID                 INT             NOT NULL    AUTO_INCREMENT,

    /* (FK) */
    definitions__PID    CHAR(36)        NOT NULL,
    test__PID           VARCHAR(64)     NOT NULL,

    /* (PK) */
    PRIMARY KEY (PID),
    
    /* INDEX */
    UNIQUE (definitions__PID, test__PID)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* Definition - Test association                                  */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_assoc__d_definition__d_test
(
    PID                 INT             NOT NULL    AUTO_INCREMENT,

    /* (FK) */
    definition__PID     VARCHAR(64)     NOT NULL,
    test__PID         VARCHAR(64)     NOT NULL,

    /* (PK) */
    PRIMARY KEY (PID),
    
    /* INDEX */
    UNIQUE (definition__PID, test__PID)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* SystemObject                                                   */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_object
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:org.mitre.oval:obj:419:1 */

    id                  VARCHAR(64)     NOT NULL,
                        /* e.g. oval:org.mitre.oval:obj:419 */
    version             INT             NOT NULL,

    deprecated          BOOLEAN         NOT NULL    DEFAULT false,
    comment             VARCHAR(255),

    object_type         VARCHAR(32)     NOT NULL,
    
    /* (FK) */

    /* (PK) */
    PRIMARY KEY (PID),

    /* INDEX */
    UNIQUE (id, version)

)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* OvalDefinitions - SystemObject association                     */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_assoc__d_definitions__d_object
(
    PID                 INT             NOT NULL    AUTO_INCREMENT,

    /* (FK) */
    definitions__PID    CHAR(36)        NOT NULL,
    object__PID         VARCHAR(64)     NOT NULL,

    /* (PK) */
    PRIMARY KEY (PID),
    
    /* INDEX */
    UNIQUE (definitions__PID, object__PID)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* Definition - SystemObject association                          */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_assoc__d_definition__d_object
(
    oid                 INT             NOT NULL    AUTO_INCREMENT,

    /* (FK) */
    definition__oid     VARCHAR(64)     NOT NULL,
    object__oid         VARCHAR(64)     NOT NULL,

    /* (PK) */
    PRIMARY KEY (oid),
    
    /* INDEX */
    UNIQUE (definition__oid, object__oid)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* State                                                          */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_state
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:org.mitre.oval:ste:419:1 */

    id                  VARCHAR(64)     NOT NULL,
                        /* e.g. oval:org.mitre.oval:obj:419 */
    version             INT             NOT NULL,

    deprecated          BOOLEAN         NOT NULL    DEFAULT false,
    comment             VARCHAR(255),

    /* We found NO state with an explicit operator. */
/*  ste_operator        VARCHAR(16)     NOT NULL    DEFAULT 'AND', */

    /* We found NO state with an explicit note. */

    object_type          VARCHAR(32)    NOT NULL,

    /* (FK) */

    /* (PK) */
    PRIMARY KEY (PID),

    /* INDEX */
    UNIQUE (id, version)

)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* OvalDefinitions - State association                            */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_assoc__d_definitions__d_state
(
    PID                 INT             NOT NULL    AUTO_INCREMENT,

    /* (FK) */
    definitions__PID    CHAR(36)        NOT NULL,
    state__PID          VARCHAR(64)     NOT NULL,

    /* (PK) */
    PRIMARY KEY (PID),
    
    /* INDEX */
    UNIQUE (definitions__PID, state__PID)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* Variable                                                       */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_variable
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:org.mitre.oval:var:419:1 */

    id                  VARCHAR(64)     NOT NULL,
                        /* e.g. oval:org.mitre.oval:var:419 */
    version             INT             NOT NULL,

    deprecated          BOOLEAN         NOT NULL    DEFAULT false,
    comment             VARCHAR(255),

    datatype            VARCHAR(16)     NOT NULL,

    object_type         VARCHAR(32)     NOT NULL,

    /* (FK) */

    /* (PK) */
    PRIMARY KEY (PID),

    /* INDEX */
    UNIQUE (id, version)

)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* LocalVariable                                                  */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_variable_local
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:org.mitre.oval:var:419:1 */

    /* (FK) */
    
    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% */
/* %                                                            % */
/* % OVAL System Characteristics                                % */
/* %                                                            % */
/* %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% */


/* ============================================================== */
/* OvalSystemCharacteristics                                      */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_s_sc
(
    PID                 CHAR(36)        NOT NULL,
                        /* UUID: e.g. 911d6c54-6965-48df-88c3-2af47e54acd2 */

    sys_primary_host_name   VARCHAR(64) NOT NULL,
    sys_os_name         VARCHAR(64)     NOT NULL,
    sys_os_version      VARCHAR(64)     NOT NULL,
    sys_architecture    VARCHAR(16)     NOT NULL,

    gen_timestamp       DATETIME        NOT NULL,
    gen_schema_version  VARCHAR(8)      NOT NULL,
    gen_product_name    VARCHAR(64),
    gen_product_version VARCHAR(64),

    objects_digest      VARCHAR(32)     /* NOT NULL */,

    /* (PK) */
    PRIMARY KEY(PID),

    /* INDEX */
    INDEX (sys_primary_host_name)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* NetworkInterface                                               */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_s_interface
(
    PID                 INT             NOT NULL    AUTO_INCREMENT,

    interface_name      VARCHAR(255)    NOT NULL,
    ip_address          VARCHAR(32)     NOT NULL,
    mac_address         VARCHAR(20)     NOT NULL,

    /* (FK) */
    s_sc__PID           CHAR(36)        NOT NULL,

    /* (PK) */
    PRIMARY KEY(PID),

    /* INDEX */
    INDEX (s_sc__PID)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* CollectedSystemObject                                          */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_s_object
(
    PID                 INT             NOT NULL    AUTO_INCREMENT,

    id                  VARCHAR(64)     NOT NULL,
                        /* e.g. oval:org.mitre.oval:obj:419 */
    version             INT             NOT NULL,
    flag                VARCHAR(16)     NOT NULL,
                        /* ENUM( 'error', ..., 'not applicable') */

    variable_instance   INT,
    comment             VARCHAR(255),
    message             VARCHAR(255),

    /* (FK) */
    s_sc__PID           CHAR(36)        NOT NULL,
    d_object__PID       VARCHAR(64)     NOT NULL,

    /* (PK) */
    PRIMARY KEY (PID),
    
    /* INDEX */
    INDEX (id),
    INDEX (s_sc__PID),
    INDEX (d_object__PID)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* VariableValue                                                  */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_s_object__variable_value
(
    PID                 INT             NOT NULL    AUTO_INCREMENT,

    variable_id         VARCHAR(64)     NOT NULL,
                        /* e.g. oval:org.mitre.oval:var:419 */
    value               VARCHAR(255),

    /* (FK) */
    s_object__PID       VARCHAR(64)     NOT NULL,

    /* (PK) */
    PRIMARY KEY (PID),
    
    /* INDEX */
/*  INDEX (variable_id), */
    INDEX (s_object__PID)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* OvalSystemCharacteristics - CollectedSystemObject association  */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_assoc__s_sc__s_object
(
    PID                 INT             NOT NULL    AUTO_INCREMENT,

    /* (FK) */
    s_sc__PID           CHAR(36)        NOT NULL,
    s_object__PID       INT             NOT NULL,

    /* (PK) */
    PRIMARY KEY (PID),
    
    /* INDEX */
    UNIQUE (s_sc__PID, s_object__PID)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* ItemReference                                                  */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_s_object__item_reference
(
    PID                 INT             NOT NULL    AUTO_INCREMENT,

    item_ref            INT             NOT NULL,

    /* (FK) */
    s_object__PID       INT             NOT NULL,

    /* (PK) */
    PRIMARY KEY (PID),
    
    /* INDEX */
    UNIQUE (s_object__PID, item_ref)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* Item                                                           */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_s_item
(
    PID                 INT             NOT NULL    AUTO_INCREMENT,

    id                  INT             NOT NULL,
    status              VARCHAR(16)     NOT NULL    DEFAULT 'exists',
                        /* ENUM( 'error', ..., 'not collected') */
    
    object_type         VARCHAR(32)     NOT NULL,

    /* (FK) */
    s_sc__PID           CHAR(36)        NOT NULL,

    /* (PK) */
    PRIMARY KEY(PID),
    
    /* INDEX */
    INDEX (s_sc__PID)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% */
/* %                                                            % */
/* % OVAL Resutls                                               % */
/* %                                                            % */
/* %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% */

/* ============================================================== */
/* OvalResults                                                    */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_r_results
(
    PID                 CHAR(36)        NOT NULL,
                        /* UUID: 911d6c54-6965-48df-88c3-2af47e54acd2 */

    gen_timestamp       DATETIME        NOT NULL,
    gen_schema_version  VARCHAR(8)      NOT NULL,
    gen_product_name    VARCHAR(64),
    gen_product_version VARCHAR(64),
    
    /* directives */
    definition_true_reported            BOOLEAN NOT NULL,
    definition_true_content             VARCHAR(4), /* {'full', 'thin'} */
    definition_false_reported           BOOLEAN NOT NULL,
    definition_false_content            VARCHAR(4),
    definition_unknown_reported         BOOLEAN NOT NULL,
    definition_unknown_content          VARCHAR(4),
    definition_error_reported           BOOLEAN NOT NULL,
    definition_error_content            VARCHAR(4),
    definition_not_evaluated_reported   BOOLEAN NOT NULL,
    definition_not_evaluated_content    VARCHAR(4),
    definition_not_applicable_reported  BOOLEAN NOT NULL,
    definition_not_applicable_content   VARCHAR(4),

    /* (FK) */
    d_definitions__PID  CHAR(36),

    /* (PK) */
    PRIMARY KEY (PID),
    
    /* INDEX */
    INDEX (d_definitions__PID)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* OvalResults - OvalDefinitions association                      */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_assoc__r_results__d_definitions
(
    PID                 INT             NOT NULL    AUTO_INCREMENT,

    /* (FK) */
    r_results__PID      CHAR(36)        NOT NULL,
    d_definitions__PID  CHAR(36)        NOT NULL,

    /* (PK) */
    PRIMARY KEY (PID),
    
    /* INDEX */
    UNIQUE (r_results__PID, d_definitions__PID)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* SystemResult                                                   */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_r_system
(
    PID                 CHAR(36)        NOT NULL,
                        /* UUID: 911d6c54-6965-48df-88c3-2af47e54acd2 */

    definitions_digest  VARCHAR(32)     /* NOT NULL */,

    /* (FK) */
    s_sc__PID           CHAR(36)        NOT NULL,

    /* (PK) */
    PRIMARY KEY (PID),
    
    /* INDEX */
    INDEX (s_sc__PID),
    INDEX (definitions_digest)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* OvalResults - SystemResult association                         */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_assoc__r_results__r_system
(
    PID                 INT             NOT NULL    AUTO_INCREMENT,

    /* (FK) */
    r_results__PID      CHAR(36)        NOT NULL,
    r_system__PID       CHAR(36)        NOT NULL,

    /* (PK) */
    PRIMARY KEY (PID),
    
    /* INDEX */
    UNIQUE (r_results__PID, r_system__PID)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* DefinitionResult                                               */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_r_definition
(
    PID                 INT             NOT NULL    AUTO_INCREMENT,

    definition_id       VARCHAR(64)     NOT NULL,
                        /* e.g. oval:org.mitre.oval:def:1001 */
    version             INT             NOT NULL,
    variable_instance   INT                         DEFAULT 1,
    result              VARCHAR(14)     NOT NULL,
                        /* ENUM( 'true', 'false', ..., 'not applicable') */

    /* (FK) */
    r_system__PID       CHAR(36)        NOT NULL,
    d_definition__PID   VARCHAR(64)     NOT NULL,

    /* (PK) */
    PRIMARY KEY (PID),
    
    /* INDEX */
    INDEX (r_system__PID),
    INDEX (definition_id)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* TestResult                                                     */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_r_test
(
    PID                 INT             NOT NULL    AUTO_INCREMENT,

    test_id             VARCHAR(64)     NOT NULL,
                        /* e.g. oval:org.mitre.oval:tst:1001 */
    version             INT             NOT NULL,
    variable_instance   INT                         DEFAULT 1,
    existence           VARCHAR(20)                 DEFAULT 'at_least_one_exists',
    check1              VARCHAR(16)     NOT NULL,
    state_operator      VARCHAR(4)                  DEFAULT 'AND',
    result              VARCHAR(14)     NOT NULL,
                        /* ENUM( 'true', 'false', ..., 'not applicable') */

    /* (FK) */
    r_system__PID       CHAR(36)        NOT NULL,
    d_test__PID         VARCHAR(64)     NOT NULL,

    /* (PK) */
    PRIMARY KEY (PID),
    
    /* INDEX */
    INDEX (r_system__PID),
    INDEX (test_id)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* TestedItem                                                     */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_r_test__tested_item
(
    PID                 INT             NOT NULL    AUTO_INCREMENT,

    item_id             INT             NOT NULL,
    result              VARCHAR(14)     NOT NULL,
                        /* ENUM( 'true', 'false', ..., 'not applicable') */

    /* (FK) */
    r_test__PID         INT             NOT NULL,

    /* (PK) */
    PRIMARY KEY (PID),
    
    /* INDEX */
    INDEX (r_test__PID)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* TestedVariable                                                 */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_r_test__tested_variable
(
    PID                 INT             NOT NULL    AUTO_INCREMENT,

    variable_id         INT             NOT NULL,
    value               VARCHAR(255),

    /* (FK) */
    r_test__PID         INT             NOT NULL,

    /* (PK) */
    PRIMARY KEY (PID),
    
    /* INDEX */
    INDEX (r_test__PID)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% */
/* %                                                            % */
/* % #independent                                               % */
/* %                                                            % */
/* %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% */

/* ============================================================== */
/* FamilyTest                                                     */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_test_family
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:org.mitre.oval:tst:419:1 */

    /* (FK) */
    
    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* FamilyObject                                                   */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_object_family
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:org.mitre.oval:obj:419:1 */

    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* FamilyState                                                    */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_state_family
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:org.mitre.oval:ste:419:1 */

    family              VARCHAR(16),
    family_operation    VARCHAR(32)     NOT NULL    DEFAULT 'equals',
                        /* enum('equals', ..., 'case insensitive not equal', ...) */

    /* (FK) */
    
    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* FamilyItem                                                     */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_s_item_family
(
    PID                 INT             NOT NULL,

    family              VARCHAR(16)     NOT NULL,
                        /* ENUM( 'ios', 'unix', 'windows', ...) */

    /* (PK) */
    PRIMARY KEY (PID),

    /* INDEX */
    INDEX (family)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* TextFileContentTest                                            */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_test_textfilecontent
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:org.mitre.oval:tst:419:1 */

    /* (FK) */
    
    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* TextFileContentObject                                          */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_object_textfilecontent
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:org.mitre.oval:obj:419:1 */

    /* path */
    path                VARCHAR(255),
    path_var_ref        VARCHAR(255),
    path_var_check      VARCHAR(16)     NOT NULL    DEFAULT 'all',
                        /* enum('all', 'at least one',...) */
/*  path_datatype       VARCHAR(16)     NOT NULL    DEFAULT 'string', */
                        /*** all the datatype may be 'string'. ***/
    path_operation      VARCHAR(32)     NOT NULL    DEFAULT 'equals',
                        /* enum('equals', ..., 'case insensitive not equal', ...) */
/*  path_mask           BOOLEAN         NOT NULL    DEFAULT false,    */

    /* filename */
    filename            VARCHAR(255),

    /* line */
    line                VARCHAR(255),
    line_var_ref        VARCHAR(255),
    line_var_check      VARCHAR(16)     NOT NULL    DEFAULT 'all',
                        /* enum('all', 'at least one',...) */
/*  line_datatype       VARCHAR(16)     NOT NULL    DEFAULT 'string', */
                        /*** all the datatype may be 'string'. ***/
    line_operation      VARCHAR(32)     NOT NULL    DEFAULT 'equals',
                        /* enum('equals', ..., 'case insensitive not equal', ...) */
/*  line_mask           BOOLEAN         NOT NULL    DEFAULT false,    */

    /* behaviors */
/*  max_depth           INT             NOT NULL    DEFAULT -1,      */
/*  recurse_direction   VARCHAR(8)      NOT NULL    DEFAULT 'none',  */
                        /* enum('none', 'up', 'down') */

    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* TextFileContentState                                           */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_state_textfilecontent
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:org.mitre.oval:ste:419:1 */

    line                VARCHAR(255),
    line_operation      VARCHAR(32)     DEFAULT 'equals',

    subexpression       VARCHAR(255),
    subexpression_operation VARCHAR(32) DEFAULT 'equals',
                        /* enum('equals', ..., 'case insensitive not equal', ...) */

    /* (FK) */
    
    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* TextFileContentItem                                            */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_s_item_textfilecontent
(
    PID                 INT             NOT NULL,

    filepath            VARCHAR(255),
    path                VARCHAR(255),
    filename            VARCHAR(64),
    pattern             VARCHAR(64),
    instance            VARCHAR(32),    /* int as string */
    line                VARCHAR(64),
    text                VARCHAR(255),

    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* UnknownTest                                                    */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_test_unknown
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:org.mitre.oval:tst:419:1 */

    /* (FK) */
    
    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% */
/* %                                                            % */
/* % #linux                                                     % */
/* %                                                            % */
/* %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% */

/* ============================================================== */
/* DpkgInfoTest                                                   */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_test_dpkginfo
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:org.mitre.oval:tst:419:1 */

    /* (FK) */

    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* RpmInfoTest                                                    */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_test_rpminfo
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:org.mitre.oval:tst:419:1 */

    /* (FK) */

    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* DpkgInfoObject                                                 */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_object_dpkginfo
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:org.mitre.oval:obj:419:1 */

    name                VARCHAR(64)     NOT NULL,

    /* (PK) */
    PRIMARY KEY (PID),

    /* INDEX */
    INDEX (name)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* RpmInfoObject                                                  */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_object_rpminfo
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:org.mitre.oval:obj:419:1 */

    name                VARCHAR(64)     NOT NULL,

    /* (PK) */
    PRIMARY KEY (PID),

    /* INDEX */
    INDEX (name)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* DpkgInfoState                                                  */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_state_dpkginfo
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:org.mitre.oval:ste:419:1 */

    name                VARCHAR(64),

    evr                 VARCHAR(128),
    evr_operation       VARCHAR(32),
    evr_datatype        VARCHAR(16),

    arch                VARCHAR(16),
    epoch               VARCHAR(32),
    release1            VARCHAR(64),
    /* 'release' is a reserved word in MySQL. */
    
    version             VARCHAR(64),
    version_operation   VARCHAR(32),
                        /* operation: 'equals', datatype: 'string' */

    /* (FK) */
    
    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* RpmInfoState                                                   */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_state_rpminfo
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:org.mitre.oval:ste:419:1 */

    name                VARCHAR(64),

    evr                 VARCHAR(128),
    evr_operation       VARCHAR(32),
    evr_datatype        VARCHAR(16),

    arch                VARCHAR(16),
    epoch               VARCHAR(32),
    release1            VARCHAR(64),
    /* 'release' is a reserved word in MySQL. */
    
    version             VARCHAR(64),
    version_operation   VARCHAR(32),
                        /* operation: 'equals', datatype: 'string' */

    sigkeyid            VARCHAR(32),
    sigkeyid_operation  VARCHAR(32),

    /* (FK) */
    
    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* DpkgInfoItem                                                   */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_s_item_dpkginfo
(
    PID                 INT             NOT NULL,

    name                VARCHAR(64),
    arch                VARCHAR(16),
    epoch               VARCHAR(32),
    release1            VARCHAR(64),
    /* 'release' is a reserved word in MySQL. */
    version             VARCHAR(64),
    evr                 VARCHAR(128),

    /* (PK) */
    PRIMARY KEY (PID),

    /* INDEX */
    INDEX (name)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* RpmInfoItem                                                    */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_s_item_rpminfo
(
    PID                 INT             NOT NULL,

    name                VARCHAR(64),
    arch                VARCHAR(16),
    epoch               VARCHAR(32),
    release1            VARCHAR(64),
    /* 'release' is a reserved word in MySQL. */
    version             VARCHAR(64),
    evr                 VARCHAR(128),
    signature_keyid     VARCHAR(32),

    /* (PK) */
    PRIMARY KEY (PID),

    /* INDEX */
    INDEX (name)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% */
/* %                                                            % */
/* % #unux                                                      % */
/* %                                                            % */
/* %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% */

/* ============================================================== */
/* UnameTest                                                      */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_test_uname
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:org.mitre.oval:tst:419:1 */

    /* (FK) */

    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* UnameObject                                                    */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_object_uname
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:org.mitre.oval:obj:419:1 */

    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* UnameItem                                                      */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_s_item_uname
(
    PID                 INT             NOT NULL,

    machine_class       VARCHAR(16),
                        /* e.g. i686 */
    node_name           VARCHAR(64),
    os_name             VARCHAR(64),
    os_release          VARCHAR(64),
    os_version          VARCHAR(64),
    processor_type      VARCHAR(16),
                        /* e.g. i686 */

    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% */
/* %                                                            % */
/* % #windows                                                   % */
/* %                                                            % */
/* %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% */

/* ============================================================== */
/* FileTest                                                       */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_test_file
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:org.mitre.oval:tst:419:1 */

/*    object__id          VARCHAR(64)     NOT NULL, */
/*    state__id           VARCHAR(64), */
    
    /* (FK) */

    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* StateRef                                                       */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_state_ref
(
    PID                 VARCHAR(64)     NOT NULL,
    
    /* (FK) */

    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* Test - StateRef association                                    */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_assoc__d_test__d_state_ref
(
    PID                 INT             NOT NULL    AUTO_INCREMENT,

    test__PID           VARCHAR(64)     NOT NULL,
    state_ref__PID      VARCHAR(64)     NOT NULL,

    /* (PK) */
    PRIMARY KEY (PID),
    
    /* INDEX */
    UNIQUE (test__PID, state_ref__PID)
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* FileObject                                                     */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_object_file
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:org.mitre.oval:obj:419:1 */

    /* XSD: choice( filepath, sequence(path, filename) ) */
    /* Therefore, 'NOT NULL' can't be specified. */
    
    /* path */
    path                VARCHAR(255),
    path_var_ref        VARCHAR(255),
    path_var_check      VARCHAR(16)   /*NOT NULL*/    DEFAULT 'all',
                        /* enum('all', 'at least one',...) */
/*  path_datatype       VARCHAR(16)     NOT NULL    DEFAULT 'string', */
                        /*** all the datatype may be 'string'. ***/
    path_operation      VARCHAR(32)   /*NOT NULL*/  DEFAULT 'equals',
                        /* enum('equals', ..., 'case insensitive not equal', ...) */
/*  path_mask           BOOLEAN         NOT NULL    DEFAULT false,    */

    /* filename */
    filename            VARCHAR(255),

    /* behaviors */
/*  max_depth           INT             NOT NULL    DEFAULT -1,      */
/*  recurse_direction   VARCHAR(8)      NOT NULL    DEFAULT 'none',  */
                        /* enum('none', 'up', 'down') */

    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* FileState                                                      */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_state_file
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:org.mitre.oval:ste:419:1 */

    version             VARCHAR(64),
    version_operation   VARCHAR(32)     DEFAULT 'equals',
                        /* enum('equals', ..., 'case insensitive not equal', ...) */
    version_datatype    VARCHAR(16),
    
    /* (FK) */
    
    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* FileItem                                                       */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_s_item_file
(
    PID                 INT             NOT NULL,

    filepath            VARCHAR(255),
    path                VARCHAR(255),
    filename            VARCHAR(255),
    owner               VARCHAR(64),
    company             VARCHAR(128),
                        /* We found the following longest company: 88 characters. */
                        /* 'Macrovision Corporation, Macrovision Europe Limited, and Macrovision Japan and Asia K.K.' */
    product_name        VARCHAR(64),
    product_version     VARCHAR(64),

    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* MetabaseTest                                                   */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_test_metabase
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:org.mitre.oval:tst:419:1 */

    /* (FK) */

    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* MetabaseObject                                                 */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_object_metabase
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:org.mitre.oval:obj:419:1 */

    /* key */
    mb_key              VARCHAR(255),

    /* id */
    mb_id               VARCHAR(255),
    mb_id_datatype      VARCHAR(16),

    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* MetabaseState                                                  */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_state_metabase
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:org.mitre.oval:ste:419:1 */

    data                VARCHAR(255),
    data_operation      VARCHAR(32)     NOT NULL    DEFAULT 'equals',
                        /* enum('equals', ..., 'case insensitive not equal', ...) */

    /* (FK) */
    
    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* RegistryTest                                                   */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_test_registry
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:org.mitre.oval:tst:419:1 */

    /* (FK) */

    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* RegistryObject                                                 */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_object_registry
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:org.mitre.oval:obj:419:1 */

    hive                VARCHAR(24)     NOT NULL,
                        /* enum('HKEY_CLASSES_ROOT', 'HKEY_CURRENT_CONFIG',...) */

    /* key */
    regkey              VARCHAR(255),
    regkey_var_ref      VARCHAR(255),
    regkey_var_check    VARCHAR(16)     NOT NULL    DEFAULT 'all',
/*  regkey_datatype     VARCHAR(16)     NOT NULL    DEFAULT 'string', */
                        /*** all the datatype may be 'string'. ***/
    regkey_operation    VARCHAR(32)     NOT NULL    DEFAULT 'equals',
/*  regkey_mask         BOOLEAN         NOT NULL    DEFAULT false,    */

    /* name */
    regname             VARCHAR(255),

    /* behaviors */
/*  max_depth           INT             NOT NULL    DEFAULT -1,       */
/*  recurse_direction   VARCHAR(8)      NOT NULL    DEFAULT 'none',   */

    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* RegistryState                                                  */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_state_registry
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:org.mitre.oval:ste:419:1 */

    value_data          VARCHAR(255),
    value_datatype      VARCHAR(16)     NOT NULL    DEFAULT 'string',
    value_operation     VARCHAR(32)     NOT NULL    DEFAULT 'equals',
                        /* enum('equals', ..., 'case insensitive not equal', ...) */

    type_data           VARCHAR(16),

    /* (FK) */
    
    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* RegistryItem                                                   */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_s_item_registry
(
    PID                 INT             NOT NULL,

    hive                VARCHAR(24)     NOT NULL,
                        /* enum('HKEY_CLASSES_ROOT', 'HKEY_CURRENT_CONFIG',...) */
    key1                VARCHAR(255),
    name                VARCHAR(255),
    type1               VARCHAR(16),
    value1              VARCHAR(255),

    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* WmiTest                                                        */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_test_wmi
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:org.mitre.oval:tst:419:1 */

    /* (FK) */

    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* WmiObject                                                      */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_object_wmi
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:org.mitre.oval:obj:419:1 */

    /* key */
    namespace           VARCHAR(64),
    namespace_var_ref   VARCHAR(255),
    namespace_var_check VARCHAR(16)     DEFAULT 'all',
    namespace_operation VARCHAR(32)     DEFAULT 'equals',

    wql                 VARCHAR(255),
    wql_operation       VARCHAR(32)     DEFAULT 'equals',

    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* ============================================================== */
/* WmiState                                                       */
/* ============================================================== */
CREATE TABLE IF NOT EXISTS oval_d_state_wmi
(
    PID                 VARCHAR(64)     NOT NULL,
                        /* id + version, e.g. oval:org.mitre.oval:ste:419:1 */

    namespace           VARCHAR(64),
    namespace_datatype  VARCHAR(16)     DEFAULT 'string',
    namespace_operation VARCHAR(32)     DEFAULT 'equals',
                        /* enum('equals', ..., 'case insensitive not equal', ...) */

    wql                 VARCHAR(255),

    result              VARCHAR(255),
    result_operation    VARCHAR(32)     DEFAULT 'equals',

    /* (FK) */
    
    /* (PK) */
    PRIMARY KEY (PID)

    /* INDEX */
)
ENGINE=InnoDB
CHARACTER SET utf8;



/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

