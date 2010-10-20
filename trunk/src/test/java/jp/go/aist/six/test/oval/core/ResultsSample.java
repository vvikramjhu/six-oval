package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.common.Check;
import jp.go.aist.six.oval.model.results.DefinitionResult;
import jp.go.aist.six.oval.model.results.Result;
import jp.go.aist.six.oval.model.results.TestResult;
import jp.go.aist.six.oval.model.results.TestedItem;
import jp.go.aist.six.oval.model.results.TestedVariable;



/**
 * OVAL Results sample objects.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class ResultsSample
{

    //==============================================================
    //  oval-res:definition
    //==============================================================

    public static final DefinitionResult  DEFINITION_RESULT_8050 =
        new DefinitionResult( "oval:org.mitre.oval:def:8050", 1, Result.FALSE );

    public static final DefinitionResult  DEFINITION_RESULT_305 =
        new DefinitionResult( "oval:org.mitre.oval:def:305", 3, Result.FALSE );

    public static final DefinitionResult  DEFINITION_RESULT_666 =
        new DefinitionResult( "oval:org.mitre.oval:def:666", 3, Result.TRUE );



    //==============================================================
    //  oval-res:test
    //==============================================================

    public static final TestResult  TEST_RESULT_704 =
        new TestResult( "oval:org.mitre.oval:tst:704", 2, Result.FALSE )
    .check( Check.AT_LEAST_ONE )
    .testedItem( new TestedItem( 2, Result.NOT_EVALUATED ) )
    ;

    public static final TestResult  TEST_RESULT_21080 =
        new TestResult( "oval:org.mitre.oval:tst:21080", 1, Result.FALSE )
    .check( Check.AT_LEAST_ONE )
    .testedItem( new TestedItem( 4, Result.FALSE ) )
    .testedVariable( new TestedVariable( "oval:org.mitre.oval:var:225", "C:\\Program Files\\Microsoft Office\\OFFICE11\\" ) )
    ;

    public static final TestResult  TEST_RESULT_1204 =
        new TestResult( "oval:org.mitre.oval:tst:1204", 2, Result.TRUE )
    .check( Check.AT_LEAST_ONE )
    .testedItem( new TestedItem( 1, Result.NOT_EVALUATED ) )
    ;

    public static final TestResult  TEST_RESULT_20855 =
        new TestResult( "oval:org.mitre.oval:tst:20855", 1, Result.FALSE )
    .check( Check.AT_LEAST_ONE )
    .testedItem( new TestedItem( 4, Result.FALSE ) )
    .testedVariable( new TestedVariable( "oval:org.mitre.oval:var:225", "C:\\Program Files\\Microsoft Office\\OFFICE11\\" ) )
    ;



}
// ScSample
