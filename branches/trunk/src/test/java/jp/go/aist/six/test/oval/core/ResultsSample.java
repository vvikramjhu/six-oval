package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.common.Check;
import jp.go.aist.six.oval.model.common.Generator;
import jp.go.aist.six.oval.model.common.Operator;
import jp.go.aist.six.oval.model.mitre.Vendor;
import jp.go.aist.six.oval.model.results.Content;
import jp.go.aist.six.oval.model.results.CriteriaResult;
import jp.go.aist.six.oval.model.results.CriterionResult;
import jp.go.aist.six.oval.model.results.DefaultDirectives;
import jp.go.aist.six.oval.model.results.DefinitionResult;
import jp.go.aist.six.oval.model.results.Directive;
import jp.go.aist.six.oval.model.results.ExtendDefinitionResult;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.results.Result;
import jp.go.aist.six.oval.model.results.SystemResult;
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

    private static final CriteriaResult  _CRITERIA_RESULT_8050_ =
        new CriteriaResult( Operator.OR,Result.FALSE )
    .element(
                    new CriteriaResult( Operator.AND, Result.FALSE )
                    .element( new ExtendDefinitionResult( "oval:org.mitre.oval:def:305", 3,
                                    Result.FALSE )
                    )
                    .element( new CriterionResult( "oval:org.mitre.oval:tst:21080", 1,
                                    Result.FALSE )
                    )
    )
    .element(
                    new CriteriaResult( Operator.AND, Result.FALSE )
                    .element( new ExtendDefinitionResult( "oval:org.mitre.oval:def:666", 3,
                                    Result.TRUE )
                    )
                    .element( new CriterionResult( "oval:org.mitre.oval:tst:20855", 1,
                                    Result.FALSE )
                    )
    )
    ;


    public static final DefinitionResult  DEFINITION_RESULT_8050 =
        new DefinitionResult( "oval:org.mitre.oval:def:8050", 1, Result.FALSE )
    .criteria( _CRITERIA_RESULT_8050_ )
    ;


    private static final CriteriaResult  _CRITERIA_RESULT_305_ =
        new CriteriaResult( Operator.AND, Result.FALSE )
    .element(
                    new CriterionResult( "oval:org.mitre.oval:tst:704", 2,
                                    Result.FALSE
                    )
    )
    ;


    public static final DefinitionResult  DEFINITION_RESULT_305 =
        new DefinitionResult( "oval:org.mitre.oval:def:305", 3, Result.FALSE )
    .criteria( _CRITERIA_RESULT_305_ )
    ;


    private static final CriteriaResult  _CRITERIA_RESULT_666_ =
        new CriteriaResult( Operator.AND, Result.TRUE )
    .element(
                    new CriterionResult( "oval:org.mitre.oval:tst:1204", 2,
                                    Result.TRUE
                    )
    )
    ;


    public static final DefinitionResult  DEFINITION_RESULT_666 =
        new DefinitionResult( "oval:org.mitre.oval:def:666", 3, Result.TRUE )
    .criteria( _CRITERIA_RESULT_666_ )
    ;



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



    //==============================================================
    //  def:oval_results
    //==============================================================

    private static final Generator  _GENERATOR_ =
        new Generator( "5.8",
                        "2010-10-20T11:21:33",
                        "OVAL Definition Interpreter",
                        "5.8 Build: 2"
        )
    .additionalInfo( new Vendor( "The MITRE Corporation" ) )
    ;


    private static final DefaultDirectives  _DIRECTIVES_ =
        new DefaultDirectives(
                        true,
                        new Directive( true, Content.FULL ),
                        new Directive( true, Content.FULL ),
                        new Directive( true, Content.FULL ),
                        new Directive( true, Content.FULL ),
                        new Directive( true, Content.FULL ),
                        new Directive( true, Content.FULL )
        )
    ;



    private static final SystemResult  _SYSTEM_RESULT_8050_ =
        new SystemResult(
                        ScSample.OVAL_SC_DEF8050,
                        new DefinitionResult[] {
                                        DEFINITION_RESULT_8050,
                                        DEFINITION_RESULT_305,
                                        DEFINITION_RESULT_666
                        },
                        new TestResult[] {
                                        TEST_RESULT_704,
                                        TEST_RESULT_21080,
                                        TEST_RESULT_1204,
                                        TEST_RESULT_20855
                        }
        )
    ;


    public static final OvalResults  OVAL_RESULTS_8050 =
        new OvalResults(
                        _GENERATOR_,
                        _DIRECTIVES_,
                        new SystemResult[] { _SYSTEM_RESULT_8050_ }
                        )
    .ovalDefinitions( DefinitionsSample.OVAL_DEFINITIONS_8050 )
    ;

}
// ScSample
