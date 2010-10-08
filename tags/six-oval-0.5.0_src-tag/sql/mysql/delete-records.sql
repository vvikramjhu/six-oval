/* ////////////////////////////////////////////////////////////// */
/* // Project SIX: OVAL                                        // */
/* //                                                          // */
/* // Delete All the Records                                   // */
/* ////////////////////////////////////////////////////////////// */

/* @author  Akihito Nakamura, AIST */
/* @version $Id$ */
/* @engine  mysql */


use @six.db.database@;


/* resutls */

DELETE FROM oval_assoc__r_results__d_definitions;
DELETE FROM oval_assoc__r_results__r_system;

DELETE FROM oval_r_tested_variable;
DELETE FROM oval_r_tested_item;
DELETE FROM oval_r_test;
DELETE FROM oval_r_definition;
DELETE FROM oval_r_system;
DELETE FROM oval_r_results;


/* system characteristics */

DELETE FROM oval_assoc__s_sc__s_item;

DELETE FROM oval_s_reference;
DELETE FROM oval_s_variable_value;

DELETE FROM oval_s_item_family;
DELETE FROM oval_s_item_textfilecontent;
DELETE FROM oval_s_item_dpkginfo;
DELETE FROM oval_s_item_rpminfo;
DELETE FROM oval_s_item_uname;
DELETE FROM oval_s_item_file;
DELETE FROM oval_s_item_registry;
DELETE FROM oval_s_item;

DELETE FROM oval_s_object;
DELETE FROM oval_s_interface;
DELETE FROM oval_s_sc;


/* definitions */

DELETE FROM oval_assoc__d_definition__d_object;
DELETE FROM oval_assoc__d_definitions__d_object;
DELETE FROM oval_assoc__d_definitions__d_state;
DELETE FROM oval_assoc__d_definition__d_test;
DELETE FROM oval_assoc__d_definitions__d_test;
DELETE FROM oval_assoc__d_definitions__d_variable;
DELETE FROM oval_assoc__d_definition__d_cve;
DELETE FROM oval_assoc__d_definition__d_platform;
DELETE FROM oval_assoc__d_definition__d_product;
DELETE FROM oval_assoc__d_definition__d_reference;
DELETE FROM oval_assoc__d_definitions__d_definition;


DELETE FROM oval_d_test_family;
DELETE FROM oval_d_test_textfilecontent;
DELETE FROM oval_d_test_unknown;
DELETE FROM oval_d_test_dpkginfo;
DELETE FROM oval_d_test_rpminfo;
DELETE FROM oval_d_test_uname;
DELETE FROM oval_d_test_file;
DELETE FROM oval_d_test_metabase;
DELETE FROM oval_d_test_registry;
DELETE FROM oval_d_test_wmi;
DELETE FROM oval_d_test__state_ref;
DELETE FROM oval_d_test;

DELETE FROM oval_d_object_family;
DELETE FROM oval_d_object_textfilecontent;
DELETE FROM oval_d_object_dpkginfo;
DELETE FROM oval_d_object_rpminfo;
DELETE FROM oval_d_object_uname;
DELETE FROM oval_d_object_file;
DELETE FROM oval_d_object_metabase;
DELETE FROM oval_d_object_registry;
DELETE FROM oval_d_object_wmi;
DELETE FROM oval_d_object;

DELETE FROM oval_d_state_family;
DELETE FROM oval_d_state_textfilecontent;
DELETE FROM oval_d_state_dpkginfo;
DELETE FROM oval_d_state_rpminfo;
DELETE FROM oval_d_state_uname;
DELETE FROM oval_d_state_file;
DELETE FROM oval_d_state_metabase;
DELETE FROM oval_d_state_registry;
DELETE FROM oval_d_state_wmi;
DELETE FROM oval_d_state;

DELETE FROM oval_d_variable_local;
DELETE FROM oval_d_variable;

DELETE FROM oval_d_criteria_element;
DELETE FROM oval_d_criteria;
DELETE FROM oval_d_criterion;
DELETE FROM oval_d_extend_definition;

DELETE FROM oval_d_cve;
DELETE FROM oval_d_platform;
DELETE FROM oval_d_product;
DELETE FROM oval_d_reference;
DELETE FROM oval_d_definition_criteria;
DELETE FROM oval_d_definition;
DELETE FROM oval_d_definitions;



/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

