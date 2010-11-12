/* ////////////////////////////////////////////////////////////// */
/* // Project SIX: OVAL                                        // */
/* //                                                          // */
/* // Database Schema Definition SQL                           // */
/* ////////////////////////////////////////////////////////////// */

/* @author  Akihito Nakamura, AIST */
/* @version $Id$ */
/* @engine  mysql */


use @six.db.database@;


/* results */

DROP TABLE IF EXISTS oval_assoc__r_results__d_definitions;
DROP TABLE IF EXISTS oval_assoc__r_results__r_system;

DROP TABLE IF EXISTS oval_r_tested_variable;
DROP TABLE IF EXISTS oval_r_tested_item;
DROP TABLE IF EXISTS oval_r_test;
DROP TABLE IF EXISTS oval_r_definition;
DROP TABLE IF EXISTS oval_r_system;
DROP TABLE IF EXISTS oval_r_results;


/* system characteristics */

DROP TABLE IF EXISTS oval_assoc__s_sc__s_item;

DROP TABLE IF EXISTS oval_s_reference;
DROP TABLE IF EXISTS oval_s_variable_value;

DROP TABLE IF EXISTS oval_s_item_family;
DROP TABLE IF EXISTS oval_s_item_textfilecontent;
DROP TABLE IF EXISTS oval_s_item_dpkginfo;
DROP TABLE IF EXISTS oval_s_item_rpminfo;
DROP TABLE IF EXISTS oval_s_item_uname;
DROP TABLE IF EXISTS oval_s_item_file;
DROP TABLE IF EXISTS oval_s_item_registry;
DROP TABLE IF EXISTS oval_s_item;

DROP TABLE IF EXISTS oval_s_object;
DROP TABLE IF EXISTS oval_s_interface;
DROP TABLE IF EXISTS oval_s_sc;


/* definitions */

DROP TABLE IF EXISTS oval_assoc__d_definition__d_object;
DROP TABLE IF EXISTS oval_assoc__d_definitions__d_object;
DROP TABLE IF EXISTS oval_assoc__d_definitions__d_state;
DROP TABLE IF EXISTS oval_assoc__d_definition__d_test;
DROP TABLE IF EXISTS oval_assoc__d_definitions__d_test;
DROP TABLE IF EXISTS oval_assoc__d_definitions__d_variable;
DROP TABLE IF EXISTS oval_assoc__d_definition__d_cve;
DROP TABLE IF EXISTS oval_assoc__d_definition__d_platform;
DROP TABLE IF EXISTS oval_assoc__d_definition__d_product;
DROP TABLE IF EXISTS oval_assoc__d_definition__d_reference;
DROP TABLE IF EXISTS oval_assoc__d_definitions__d_definition;


DROP TABLE IF EXISTS oval_d_test_family;
DROP TABLE IF EXISTS oval_d_test_textfilecontent54;
DROP TABLE IF EXISTS oval_d_test_textfilecontent;
DROP TABLE IF EXISTS oval_d_test_unknown;
DROP TABLE IF EXISTS oval_d_test_dpkginfo;
DROP TABLE IF EXISTS oval_d_test_rpminfo;
DROP TABLE IF EXISTS oval_d_test_uname;
DROP TABLE IF EXISTS oval_d_test_file;
DROP TABLE IF EXISTS oval_d_test_metabase;
DROP TABLE IF EXISTS oval_d_test_registry;
DROP TABLE IF EXISTS oval_d_test_wmi;
DROP TABLE IF EXISTS oval_d_test__state_ref;
DROP TABLE IF EXISTS oval_d_test;

DROP TABLE IF EXISTS oval_d_object_family;
DROP TABLE IF EXISTS oval_d_object_textfilecontent54;
DROP TABLE IF EXISTS oval_d_object_textfilecontent;
DROP TABLE IF EXISTS oval_d_object_dpkginfo;
DROP TABLE IF EXISTS oval_d_object_rpminfo;
DROP TABLE IF EXISTS oval_d_object_uname;
DROP TABLE IF EXISTS oval_d_object_file;
DROP TABLE IF EXISTS oval_d_object_metabase;
DROP TABLE IF EXISTS oval_d_object_registry;
DROP TABLE IF EXISTS oval_d_object_wmi;
DROP TABLE IF EXISTS oval_d_object;

DROP TABLE IF EXISTS oval_d_state_family;
DROP TABLE IF EXISTS oval_d_state_textfilecontent54;
DROP TABLE IF EXISTS oval_d_state_textfilecontent;
DROP TABLE IF EXISTS oval_d_state_dpkginfo;
DROP TABLE IF EXISTS oval_d_state_rpminfo;
DROP TABLE IF EXISTS oval_d_state_uname;
DROP TABLE IF EXISTS oval_d_state_file;
DROP TABLE IF EXISTS oval_d_state_metabase;
DROP TABLE IF EXISTS oval_d_state_registry;
DROP TABLE IF EXISTS oval_d_state_wmi;
DROP TABLE IF EXISTS oval_d_state;

DROP TABLE IF EXISTS oval_d_variable_local;
DROP TABLE IF EXISTS oval_d_variable;

DROP TABLE IF EXISTS oval_d_criteria_element;
DROP TABLE IF EXISTS oval_d_criteria;
DROP TABLE IF EXISTS oval_d_criterion;
DROP TABLE IF EXISTS oval_d_extend_definition;

DROP TABLE IF EXISTS oval_d_cve;
DROP TABLE IF EXISTS oval_d_platform;
DROP TABLE IF EXISTS oval_d_product;
DROP TABLE IF EXISTS oval_d_reference;
--DROP TABLE IF EXISTS oval_d_definition_criteria;
DROP TABLE IF EXISTS oval_d_definition;
DROP TABLE IF EXISTS oval_d_definitions;




/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

