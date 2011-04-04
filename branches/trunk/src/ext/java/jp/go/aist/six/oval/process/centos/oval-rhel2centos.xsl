<?xml version="1.0" encoding="UTF-8"?>

<!-- /////////////////////////////////////////////////////////// -->
<!-- // Project SIX: OVAL - CentOS                            // -->
<!-- //                                                       // -->
<!-- // XSLT Stylesheet                                       // -->
<!-- // source: OVAL Definitions for Red Hat Enterprise Linux // -->
<!-- // result: OVAL Definitions for CentOS                   // -->
<!-- /////////////////////////////////////////////////////////// -->

<!-- @author    Akihito Nakamura, AIST -->
<!-- @version   $Id$ -->

<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5"
    xmlns:oval="http://oval.mitre.org/XMLSchema/oval-common-5" 
    xmlns:oval-def="http://oval.mitre.org/XMLSchema/oval-definitions-5"
    xmlns:unix-def="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix"
    xmlns:red-def="http://oval.mitre.org/XMLSchema/oval-definitions-5#linux"
    xmlns:java="http://xml.apache.org/xalan/java"
    >
<!--
<oval_definitions 
xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5" 
xmlns:oval="http://oval.mitre.org/XMLSchema/oval-common-5" 
xmlns:oval-def="http://oval.mitre.org/XMLSchema/oval-definitions-5" 
xmlns:unix-def="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix" 
xmlns:red-def="http://oval.mitre.org/XMLSchema/oval-definitions-5#linux" 
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
xsi:schemaLocation="http://oval.mitre.org/XMLSchema/oval-common-5 oval-common-schema.xsd http://oval.mitre.org/XMLSchema/oval-definitions-5 oval-definitions-schema.xsd http://oval.mitre.org/XMLSchema/oval-definitions-5#unix unix-definitions-schema.xsd http://oval.mitre.org/XMLSchema/oval-definitions-5#linux linux-definitions-schema.xsd">
-->


    <!-- ******************************************************* -->
    <!-- Scripts                                                 -->
    <!-- ******************************************************* -->
<!--
    xmlns:java-date="java:java.util.Date"
    <xsl:script language="java" implements-prefix="java-date" src="java:java.util.Date"/>
-->



    <!-- ******************************************************* -->
    <!-- Output                                                  -->
    <!-- ******************************************************* -->

    <xsl:output
        method      ="xml"
        encoding    ="UTF-8"
        indent      ="yes"
        />




    <!-- ******************************************************* -->
    <!-- Parameters                                              -->
    <!-- ******************************************************* -->

    <xsl:param name="generator_name" select="'SIX OVAL Generator'"/>
    


    <!-- ******************************************************* -->
    <!-- Keys                                                    -->
    <!-- ******************************************************* -->

    <xsl:key name="key_test-id" 
        match="/oval-def:oval_definitions/oval-def:tests/red-def:rpminfo_test" 
        use="@id"/>

    <xsl:key name="key_object-id" 
        match="/oval-def:oval_definitions/oval-def:objects/red-def:rpminfo_object" 
        use="@id"/>

    <xsl:key name="key_state-id" 
        match="/oval-def:oval_definitions/oval-def:states/red-def:rpminfo_state" 
        use="@id"/>



    <!-- ******************************************************* -->
    <!-- Variables                                               -->
    <!-- ******************************************************* -->

    <!-- XML namespace URI -->
    <xsl:variable name="var_oval_oval-def_xmlns">http://oval.mitre.org/XMLSchema/oval-definitions-5</xsl:variable>
    <xsl:variable name="var_oval_red-def_xmlns">http://oval.mitre.org/XMLSchema/oval-definitions-5#linux</xsl:variable>


    <!-- OVAL entity id -->
    <xsl:variable name="var_six_oval-id-prefix">oval:jp.go.aist.six.oval.centos</xsl:variable>
    <xsl:variable name="var_six_centos-pattern_state_id">oval:jp.go.aist.six.oval.centos:ste:10000000</xsl:variable>
    <xsl:variable name="var_six_centos-pattern-release_test_id-postfix">00000001</xsl:variable>

    <!-- RPM signature key IDs -->
    <xsl:variable name="var_rh_release_keyid">5326810137017186</xsl:variable>
    <xsl:variable name="var_rh_master_keyid">219180cddb42a60e</xsl:variable>
    <xsl:variable name="var_centos5_keyid">a8a447dce8562897</xsl:variable>
    <xsl:variable name="var_centos4_keyid">a53d0bab443e1821</xsl:variable>
    <xsl:variable name="var_centos3_keyid">7049e44d025e513b</xsl:variable>

    <xsl:variable name="var_centos_keyid-pattern"
        select="concat( $var_centos5_keyid, '|', $var_centos4_keyid, '|', $var_centos3_keyid )"/>




    <!-- ******************************************************* -->
    <!-- Templates (matching)                                    -->
    <!-- ******************************************************* -->

    <!--
    /
    ================================================================

    INPUT: 
    OUTPUT:
    ================================================================
    -->
    <xsl:template match="/">
<xsl:text>
</xsl:text>
<xsl:apply-templates/>
    </xsl:template>


    <!--
    /oval_definitions/generator
    ================================================================
    INPUT: 
    OUTPUT:
    ================================================================
    -->
    <xsl:template match="oval-def:generator/oval:product_name">
        <xsl:copy>
            <xsl:value-of select="$generator_name"/>
        </xsl:copy>
    </xsl:template>
    
    <xsl:template match="oval-def:generator/oval:timestamp">
        <xsl:variable name="format">yyyy-MM-dd'T'HH:mm:ss</xsl:variable>
        <xsl:variable name="formatter" select="java:java.text.SimpleDateFormat.new( $format )" />
        <xsl:variable name="date" select="java:java.util.Date.new()"/>
        <xsl:copy>
            <xsl:value-of select="java:format( $formatter, $date )"/>
        </xsl:copy>
    </xsl:template>

    

    <!--
    /oval_definitions/definition
    ================================================================
    INPUT: 
    OUTPUT:
    ================================================================
    -->
    <xsl:template match="oval-def:definition">
        <xsl:copy>
            <xsl:attribute name="id">
                <xsl:call-template name="convertToSixOvalID">
                    <xsl:with-param name="id" select="@id"/>
                </xsl:call-template>
            </xsl:attribute>
            <xsl:copy-of select="@*[name() != 'id']"/>

            <xsl:apply-templates/>
        </xsl:copy>
    </xsl:template>
    
    

    <!--
    /oval_definitions/definitions/definition/metadata
    ================================================================
    INPUT: 
        <affected family="unix">
            <platform>Red Hat Enterprise Linux 3</platform> 
            <platform>Red Hat Enterprise Linux 4</platform> 
            <platform>Red Hat Enterprise Linux 5</platform> 
        </affected>
        
    OUTPUT:
        <affected family="unix">
            <platform>CentOS 3</platform> 
            <platform>CentOS 4</platform> 
            <platform>CentOS 5</platform> 
        </affected>
    ================================================================
    -->
    <xsl:template match="oval-def:affected">
        <!-- Copies this 'affected'. -->
        <xsl:copy>
            <xsl:copy-of select="@*"/>
            <xsl:for-each select="oval-def:platform">
                <xsl:variable name="rhel" select="'Red Hat Enterprise Linux'"/>
                <xsl:variable name="platform" select="."/>
                
                <!-- 'platform' -->
                <xsl:copy> 
                    <xsl:copy-of select="@*"/>
                    <xsl:choose>
                        <xsl:when test="starts-with( $platform, $rhel )">
                            <xsl:value-of select="concat( 'CentOS', substring-after( $platform, $rhel ) )"/>
                        </xsl:when>
                        
                        <xsl:otherwise>
                            <xsl:value-of select="$platform"/>
                        </xsl:otherwise>
                    </xsl:choose>
                </xsl:copy>
            </xsl:for-each>
            
            <xsl:apply-templates select="*[local-name() != 'platform']"/>
        </xsl:copy>

    </xsl:template>
    


    <!-- criteria -->

    <!--
    /oval_definitions/definitions/definition/criteria//criterion
    ================================================================

        test T:  RHEL evr test
        test T1: CentOS evr test generated from RHEL evr test
        test T2: 'centos'-pattern release test
    INPUT: 
        criteria T
    OUTPUT:
        criteria (T AND NOT(T2)) OR (T1 AND T2)
    ================================================================
    -->
    <xsl:template match="oval-def:criterion">
        <xsl:variable name="test_id" select="@test_ref"/>

        <xsl:variable name="test"   select="key( 'key_test-id', $test_id )"/>
        <xsl:variable name="object_id" select="$test/red-def:object/@object_ref"/>
        <xsl:variable name="state_id"  select="$test/red-def:state/@state_ref"/>

        <xsl:variable name="object" select="key( 'key_object-id', $object_id )"/>
        <xsl:variable name="state"  select="key( 'key_state-id',  $state_id )"/>


        <xsl:variable name="is_evr_test" select="$state[red-def:evr]"/>
        <xsl:variable name="is_signature-keyid_test" select="$state[red-def:signature_keyid]"/>
        <xsl:variable name="is_rhel-installed_test" select="$object[red-def:name = 'redhat-release']"/>

        <xsl:choose>
            <xsl:when test="$is_evr_test">
                <xsl:comment>==== SIX: state=<xsl:value-of select="$state_id"/> ====</xsl:comment>

                <xsl:variable name="centos-pattern-test-id">
                    <xsl:call-template name="convertToSixOvalID">
                        <xsl:with-param name="id" select="@test_ref"/>
                        <xsl:with-param name="postfix" select="$var_six_centos-pattern-release_test_id-postfix"/>
                    </xsl:call-template>
                </xsl:variable>

                <xsl:element name="criteria" namespace="{$var_oval_oval-def_xmlns}">
                    <xsl:attribute name="operator">OR</xsl:attribute>

                    <!-- T AND NOT(T2) -->
                    <xsl:element name="criteria" namespace="{$var_oval_oval-def_xmlns}">
                        <xsl:attribute name="operator">AND</xsl:attribute>
                        <xsl:copy-of select="."/> <!-- T -->
                        <xsl:element name="criterion" namespace="{$var_oval_oval-def_xmlns}">
                            <xsl:attribute name="negate">true</xsl:attribute>
                            <xsl:attribute name="test_ref">
                                <xsl:value-of select="$centos-pattern-test-id"/>
                            </xsl:attribute>
                        </xsl:element>
                    </xsl:element>

                    <!-- T1 AND T2 -->
                    <xsl:element name="criteria" namespace="{$var_oval_oval-def_xmlns}">
                        <xsl:attribute name="operator">AND</xsl:attribute>
                        <xsl:element name="criterion" namespace="{$var_oval_oval-def_xmlns}">
                            <xsl:attribute name="test_ref">
                                <xsl:call-template name="convertToSixOvalID">
                                    <xsl:with-param name="id" select="@test_ref"/>
                                </xsl:call-template>
                            </xsl:attribute>
                        </xsl:element>
                        <xsl:element name="criterion" namespace="{$var_oval_oval-def_xmlns}">
                            <xsl:attribute name="test_ref">
                                <xsl:value-of select="$centos-pattern-test-id"/>
                            </xsl:attribute>
                        </xsl:element>
                    </xsl:element>
                </xsl:element>
            </xsl:when>


            <xsl:when test="$is_signature-keyid_test">
                <xsl:comment>==== SIX: state=<xsl:value-of select="$state_id"/> ====</xsl:comment>
                <xsl:copy>
                    <xsl:attribute name="test_ref">
                        <xsl:call-template name="convertToSixOvalID">
                            <xsl:with-param name="id" select="@test_ref"/>
                        </xsl:call-template>
                    </xsl:attribute>
                    <xsl:attribute name="comment"><xsl:value-of select="substring-before(@comment, 'is signed with')"/>is signed with CentOS key</xsl:attribute>
                </xsl:copy>
            </xsl:when>
            

            <xsl:when test="$is_rhel-installed_test">
                <xsl:comment>==== SIX: source=<xsl:value-of select="$test_id"/> ====</xsl:comment>
                <xsl:copy>
                    <xsl:attribute name="test_ref">
                        <xsl:call-template name="convertToSixOvalID">
                            <xsl:with-param name="id" select="@test_ref"/>
                        </xsl:call-template>
                    </xsl:attribute>
                    <xsl:attribute name="comment">CentOS is installed</xsl:attribute>
                </xsl:copy>
            </xsl:when>


            <xsl:otherwise>
                <xsl:copy-of select="."/>
            </xsl:otherwise>
        </xsl:choose>

    </xsl:template>



    <!-- test -->

    <!--
    /oval_definitions/objects/rpminfo_test
    ================================================================

    INPUT:
    OUTPUT:
    ================================================================
    -->
    <xsl:template match="red-def:rpminfo_test">
        <!-- Copies this 'rpminfo_test'. -->
        <xsl:copy>
            <xsl:copy-of select="@*"/>
            <xsl:apply-templates/>
        </xsl:copy>


        <xsl:variable name="object_id" select="red-def:object/@object_ref"/>
        <xsl:variable name="state_id"  select="red-def:state/@state_ref"/>

        <xsl:variable name="object" select="key( 'key_object-id', $object_id )"/>
        <xsl:variable name="state"  select="key( 'key_state-id',  $state_id )"/>

        <xsl:variable name="is_evr_test" select="$state[red-def:evr]"/>

        <xsl:variable name="is_rhel-installed_test"
            select="$object[red-def:name = 'redhat-release']  and  $state[red-def:version[@operation = 'pattern match']]"/>

        <xsl:variable name="is_signature-keyid_test" select="$state[red-def:signature_keyid]"/>


        <xsl:if test="$is_evr_test  or  $is_signature-keyid_test  or  $is_rhel-installed_test">
            <xsl:comment>==== SIX: source=<xsl:value-of select="@id"/></xsl:comment>

            <xsl:variable name="new_comment">
                <xsl:choose>
                    <xsl:when test="$is_evr_test">
                        <xsl:value-of select="concat( $object/red-def:name, ' evr ', $state/red-def:evr/@operation, ' ', $state/red-def:evr )"/>
                    </xsl:when>
                    
                    <xsl:when test="$is_signature-keyid_test">
                        <xsl:value-of select="concat( $object/red-def:name, ' is signed with CentOS key')"/>
                    </xsl:when>
                    
                    <xsl:when test="$is_rhel-installed_test">
                        <xsl:variable name="centos_version">
                            <xsl:call-template name="findRHELVersionFromState">
                                <xsl:with-param name="state_id" select="$state_id"/>
                            </xsl:call-template>
                        </xsl:variable>
                        <xsl:value-of select="concat('CentOS ', $centos_version, ' is installed')"/>
                    </xsl:when>
                    
                    <xsl:otherwise>SIX</xsl:otherwise>
                </xsl:choose>
            </xsl:variable>

            <!-- Creates a new 'rpminfo_test' -->
            <xsl:copy>
                <xsl:attribute name="id">
                    <xsl:call-template name="convertToSixOvalID">
                        <xsl:with-param name="id" select="@id"/>
                    </xsl:call-template>
                </xsl:attribute>
                <xsl:attribute name="comment"><xsl:value-of select="$new_comment"/></xsl:attribute>
                <xsl:copy-of select="@*[name() != 'id'  and  name() != 'comment']"/>

                <!-- 'object' -->
                <xsl:for-each select="red-def:object">
                    <xsl:copy>
                        <xsl:choose>
                            <xsl:when test="$is_rhel-installed_test">
                                <xsl:attribute name="object_ref">
                                    <xsl:call-template name="convertToSixOvalID">
                                        <xsl:with-param name="id" select="$object_id"/>
                                    </xsl:call-template>
                                </xsl:attribute>
                                <xsl:copy-of select="node()[name() != 'object_ref']"/>
                            </xsl:when>
                            <xsl:otherwise>
                                <xsl:copy-of select="@*"/>
                            </xsl:otherwise>
                        </xsl:choose>
                    </xsl:copy>
                </xsl:for-each>

                <!-- 'state' -->
                <xsl:for-each select="red-def:state">
                    <xsl:copy>
                        <xsl:attribute name="state_ref">
                            <xsl:call-template name="convertToSixOvalID">
                                <xsl:with-param name="id" select="$state_id"/>
                            </xsl:call-template>
                        </xsl:attribute>
                        <xsl:apply-templates select="node()[name() != 'state_ref']"/>
                    </xsl:copy>
                </xsl:for-each>
            </xsl:copy>
        </xsl:if>


        <xsl:if test="$is_evr_test">
            <xsl:comment>==== SIX: 'centos'-pattern release test ====</xsl:comment>
            <xsl:element name="rpminfo_test" namespace="{$var_oval_red-def_xmlns}">
                <xsl:attribute name="id">
                    <xsl:call-template name="convertToSixOvalID">
                        <xsl:with-param name="id" select="@id"/>
                        <xsl:with-param name="postfix" select="$var_six_centos-pattern-release_test_id-postfix"/>
                    </xsl:call-template>
                </xsl:attribute>
                <xsl:attribute name="version">1</xsl:attribute>
                <xsl:attribute name="check">at least one</xsl:attribute>
                <xsl:attribute name="comment">
                    <xsl:value-of select="concat( $object/red-def:name, ' is CentOS original release' )"/>
                </xsl:attribute>

                <xsl:element name="object" namespace="{$var_oval_red-def_xmlns}">
                    <xsl:attribute name="object_ref">
                        <xsl:value-of select="$object_id"/>
                    </xsl:attribute>
                </xsl:element>

                <xsl:element name="state" namespace="{$var_oval_red-def_xmlns}">
                    <xsl:attribute name="state_ref">
                        <xsl:value-of select="$var_six_centos-pattern_state_id"/>
                    </xsl:attribute>
                </xsl:element>
            </xsl:element>
        </xsl:if>
    </xsl:template>



    <!-- object -->

    <!--
    /oval_definitions/objects/rpminfo_object
    ================================================================

    INPUT:
    OUTPUT:
    ================================================================
    -->
    <xsl:template match="red-def:rpminfo_object">
        <!-- Copies this 'rpminfo_object'. -->
        <xsl:copy>
            <xsl:copy-of select="@*"/>
            <xsl:apply-templates/>
        </xsl:copy>

        <xsl:if test="red-def:name = 'redhat-release'">
            <xsl:comment>==== SIX: source: id=<xsl:value-of select="@id"/> ====</xsl:comment>

            <!-- Creates a new 'rpminfo_object' -->
            <xsl:copy>
                <xsl:attribute name="id">
                    <xsl:call-template name="convertToSixOvalID">
                        <xsl:with-param name="id" select="@id"/>
                    </xsl:call-template>
                </xsl:attribute>
                <xsl:copy-of select="@*[name() != 'id']"/>

                <xsl:for-each select="red-def:name">
                    <xsl:copy>
                        <xsl:copy-of select="@*"/>
                        <xsl:text>centos-release</xsl:text>
                    </xsl:copy>
                </xsl:for-each>
            </xsl:copy>
        </xsl:if>

    </xsl:template>



    <!-- state -->

    <!--
    /oval_definitions/states
    ================================================================

    INPUT:
    OUTPUT:
    ================================================================
    -->
    <xsl:template match="oval-def:states">
        <xsl:copy> <!-- 'states' -->

            <xsl:apply-templates/>


            <!-- Creates a 'rpminfo_state' with 'centos'-pattern release -->
            <xsl:comment>==== SIX: CentOS specific release pattern ====</xsl:comment>
            <xsl:element name="rpminfo_state" namespace="{$var_oval_red-def_xmlns}">
                <xsl:attribute name="id">
                    <xsl:value-of select="$var_six_centos-pattern_state_id"/>
                </xsl:attribute>
                <xsl:attribute name="version">1</xsl:attribute>
                <!-- xsl:attribute name="comment">release from CentOS</xsl:attribute -->

                <!-- NOTE: There should be NO space in the content of this 'release' element.
                If spaces exist, e.g. <release operation="pattern match">   .*centos.*   </release>,
                they are interpreted as the part of regular expression!!!
                Instead, it must be <release operation="pattern match">.*centos.*</release>.
                -->
                <xsl:element name="release" namespace="{$var_oval_red-def_xmlns}">
                    <xsl:attribute name="operation">pattern match</xsl:attribute>
                    <xsl:text>.*centos.*</xsl:text>
                </xsl:element>
            </xsl:element>

        </xsl:copy>
    </xsl:template>



    <!--
    /oval_definitions/objects/rpminfo_state
    ================================================================

    INPUT:
    OUTPUT:
    ================================================================
    -->
    <xsl:template match="red-def:rpminfo_state">
        <!-- copies this rpminfo_state -->
        <xsl:copy>
            <xsl:copy-of select="@*"/>
            <xsl:apply-templates/>
        </xsl:copy>

        <xsl:if test="./red-def:evr  or  ./red-def:signature_keyid  or  ./red-def:version">
            <xsl:comment>==== SIX: source=<xsl:value-of select="@id"/></xsl:comment>
            <xsl:copy>
                <xsl:attribute name="id">
                    <xsl:call-template name="convertToSixOvalID">
                        <xsl:with-param name="id" select="@id"/>
                    </xsl:call-template>
                </xsl:attribute>
                <xsl:copy-of select="@*[name() != 'id']"/>
                
                <xsl:choose>
                    <xsl:when test="./red-def:evr">
                        <xsl:variable name="centos_evr">
                            <xsl:call-template name="convertToCentOSEvr">
                                <xsl:with-param name="evr" select="./red-def:evr"/>
                            </xsl:call-template>
                        </xsl:variable>
                        <xsl:for-each select="red-def:evr">
                            <xsl:copy>
                                <xsl:copy-of select="@*"/>
                                <xsl:value-of select="$centos_evr"/>
                            </xsl:copy>
                        </xsl:for-each>
                    </xsl:when>

                    <xsl:when test="./red-def:signature_keyid">
                        <xsl:for-each select="red-def:signature_keyid">
                            <xsl:copy>
                                <xsl:attribute name="operation">pattern match</xsl:attribute>
                                <xsl:copy-of select="@*[name() != 'operation']"/>
                                <xsl:value-of select="$var_centos_keyid-pattern"/>
                            </xsl:copy>
                        </xsl:for-each>
                    </xsl:when>

                    <xsl:when test="./red-def:version">
                        <xsl:variable name="version" select="./red-def:version"/>
                        <xsl:variable name="version_number" 
                          select="substring(substring-before($version, '['), 2)"/>
                        <xsl:for-each select="red-def:version">
                            <xsl:copy>
                                <xsl:copy-of select="@*"/>
                                <xsl:value-of select="$version_number"/>
                                <!-- xsl:value-of select="concat('^', $version_number)"/ -->
                            </xsl:copy>
                        </xsl:for-each>
                    </xsl:when>
                </xsl:choose>
            </xsl:copy>
        </xsl:if>
        

    </xsl:template>



    <!--
    /oval_definitions/objects/rpminfo_state
    ================================================================

    INPUT:
    OUTPUT:
    ================================================================
    -->
    <xsl:template match="red-def:rpminfo_state-backup[red-def:evr]">
        <!-- copies this rpminfo_state -->
        <xsl:copy>
            <xsl:copy-of select="@*"/>
            <xsl:apply-templates/>
        </xsl:copy>

        <xsl:variable name="evr" select="red-def:evr"/>
        <xsl:variable name="is_rhel_release" select="contains($evr, '.el')  or  contains($evr, '.rhel')"/>
        
        <xsl:comment>==== SIX: source=<xsl:value-of select="@id"/>, evr=<xsl:value-of select="$evr"/></xsl:comment>
        <xsl:variable name="centos_evr">
            <xsl:call-template name="convertToCentOSEvr">
                <xsl:with-param name="evr" select="$evr"/>
            </xsl:call-template>
        </xsl:variable>
        
        
        <!-- new 'rpminfo_state' -->
        <xsl:copy>
            <xsl:attribute name="id">
                <xsl:call-template name="convertToSixOvalID">
                    <xsl:with-param name="id" select="@id"/>
                </xsl:call-template>
            </xsl:attribute>
            <xsl:copy-of select="@*[name() != 'id']"/>
            <xsl:for-each select="red-def:evr">
                <xsl:copy>
                    <xsl:copy-of select="@*"/>
                    <xsl:value-of select="$centos_evr"/>
                </xsl:copy>
            </xsl:for-each>
        </xsl:copy>

    </xsl:template>



    <!--
    /oval_definitions/objects/rpminfo_state
    ================================================================

    INPUT:
    OUTPUT:
    ================================================================
    -->
    <xsl:template match="red-def:rpminfo_state-backup[red-def:version/@operation = 'pattern match']">
        <!-- copies this rpminfo_state -->
        <xsl:copy>
            <xsl:copy-of select="@*"/>
            <xsl:apply-templates/>
        </xsl:copy>

        <xsl:variable name="version" select="red-def:version"/>
        <xsl:variable name="version_number" select="substring(substring-before($version, '['), 2)"/>

        <xsl:comment>==== SIX: source=<xsl:value-of select="@id"/> ====</xsl:comment>

        <!-- Creates new 'rpminfo_state' -->
        <xsl:copy>
            <xsl:attribute name="id">
                <xsl:call-template name="convertToSixOvalID">
                    <xsl:with-param name="id" select="@id"/>
                </xsl:call-template>
            </xsl:attribute>
            <xsl:copy-of select="@*[name() != 'id']"/>
            <xsl:for-each select="red-def:version">
                <xsl:copy>
                    <xsl:copy-of select="@*"/>
                    <xsl:value-of select="$version_number"/>
                    <!-- xsl:value-of select="concat('^', $version_number)"/ -->
                </xsl:copy>
            </xsl:for-each>
        </xsl:copy>

    </xsl:template>



    <!--
    /oval_definitions/objects/rpminfo_state
    ================================================================

    INPUT:
    OUTPUT:
    ================================================================
    -->
    <xsl:template match="red-def:rpminfo_state-backup[red-def:signature_keyid]">
        <!-- Copies this 'rpminfo_state' deeply -->
        <xsl:copy>
            <xsl:copy-of select="@*"/>
            <xsl:apply-templates/>
        </xsl:copy>

        <xsl:comment>==== SIX: source=<xsl:value-of select="@id"/>, keyid=<xsl:value-of select="red-def:signature_keyid"/></xsl:comment>

        <!-- Creates a new 'rpminfo_state' with the CentOS keyid -->
        <xsl:copy>
            <xsl:attribute name="id">
                <xsl:call-template name="convertToSixOvalID">
                    <xsl:with-param name="id" select="@id"/>
                </xsl:call-template>
            </xsl:attribute>
            <xsl:copy-of select="@*[name() != 'id']"/>
            <xsl:for-each select="red-def:signature_keyid">
                <xsl:copy>
                    <xsl:attribute name="operation">pattern match</xsl:attribute>
                    <xsl:copy-of select="@*[name() != 'operation']"/>
                    <xsl:value-of select="$var_centos_keyid-pattern"/>
                </xsl:copy>
            </xsl:for-each>
        </xsl:copy>

    </xsl:template>



    <!--
    ================================================================
    Copies all the nodes and their attributes.
    ================================================================
    -->
    <xsl:template match="@*|node()">
        <xsl:copy>
            <xsl:apply-templates select="@*"/>
            <xsl:apply-templates/>
        </xsl:copy>
    </xsl:template>




    <!-- ******************************************************* -->
    <!-- Templates (named)                                       -->
    <!-- ******************************************************* -->

    <!--
    findRHELVersionFromState( state_id )
    ================================================================
    ================================================================
    -->
    <xsl:template name="findRHELVersionFromState">
        <xsl:param name="state_id"/>

        <xsl:variable name="state" select="key( 'key_state-id',  $state_id )"/>
        <xsl:choose>
            <xsl:when test="$state/red-def:version[@operation = 'pattern match']">
                <xsl:variable name="version" select="$state/red-def:version"/>
                <xsl:value-of select="substring(substring-before($version, '['), 2)"/>
            </xsl:when>

            <xsl:when test="$state/red-def:version">
                <xsl:value-of select="$state/red-def:version"/>
            </xsl:when>

            <xsl:otherwise>
                <xsl:text/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>
    
    
    
    
    <!--
    convertToCentOSEvr(evr)
    ================================================================
    Converts the specified evr string to the one for CentOS.

    INPUT: Red Hat evr string
            e.g. '0:1.3.5-11.el5_4.1'
    OUTPUT: CentOS evr string
            e.g. '0:1.3.5-11.el5.centos.1'
    ================================================================
    -->
    <xsl:template name="convertToCentOSEvr">
        <xsl:param name="evr"/>

        <xsl:variable name="rhel_pattern">
            <xsl:choose>
                <xsl:when test="contains($evr, '.rhel')">
                    <xsl:value-of select="'.rhel'"/>
                </xsl:when>
                <xsl:otherwise>
                    <xsl:value-of select="'.el'"/>
                </xsl:otherwise>
            </xsl:choose>
        </xsl:variable>
        
        <xsl:variable name="is_rhel_release" select="contains($evr, $rhel_pattern)"/>

        <xsl:choose>
            <xsl:when test="$is_rhel_release">
                <xsl:variable name="rhel_version">
                    <xsl:call-template name="findRHELVersion">
                        <xsl:with-param name="evr" select="$evr"/>
                    </xsl:call-template>
                </xsl:variable>
                <xsl:variable name="evr_prefix" 
                              select="substring-before($evr, $rhel_pattern)"/>
                <xsl:variable name="evr_postfix" 
                              select="substring(substring-after($evr, $rhel_pattern), 2)"/>
                <xsl:variable name="evr_postfix2" 
                              select="substring-after($evr_postfix, '.')"/>
                <xsl:variable name="centos_replacement"
                              select="concat('.el', $rhel_version, '.centos')"/>
                <xsl:choose>
                    <xsl:when test="$evr_postfix2">
                        <xsl:value-of select="concat($evr_prefix, $centos_replacement, '.', $evr_postfix2)"/>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:value-of select="concat($evr_prefix, $centos_replacement)"/>
                    </xsl:otherwise>
                </xsl:choose>
            </xsl:when>

            <xsl:otherwise>
                <xsl:value-of select="$evr"/>
            </xsl:otherwise>
        </xsl:choose>

    </xsl:template>



    <!--
    findRHELVersion(evr)
    ================================================================
    Finds the RHEL version in the specified evr string.
    For some versions, the evr contains '.rhel',
    and others contain '.el'.

    INPUT: RH evr string.
    OUTPUT: RHEL version, e.g. 5, 4, or 3.
        If the evr does not for RH release, this template
        returns an empty string ''.
    ================================================================
    -->
    <xsl:template name="findRHELVersion">
        <xsl:param name="evr"/>

        <xsl:variable name="rhel_pattern">
            <xsl:choose>
                <xsl:when test="contains($evr, '.rhel')">
                    <xsl:value-of select="'.rhel'"/>
                </xsl:when>
                <xsl:otherwise>
                    <xsl:value-of select="'.el'"/>
                </xsl:otherwise>
            </xsl:choose>
        </xsl:variable>

        <xsl:variable name="is_rhel" select="contains($evr, $rhel_pattern)"/>

        <xsl:choose>
            <xsl:when test="$is_rhel">
                <xsl:variable name="postfix" select="substring-after($evr, $rhel_pattern)"/>
                <xsl:value-of select="substring($postfix, 1, 1)"/>
            </xsl:when>

            <xsl:otherwise>
                <xsl:text/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>





    <!--
    convertToSixOvalID(id)
    ================================================================

    INPUT: RH OVAL entity id string
            e.g. 'oval:com.redhat.rhsa:def:20100061'
    OUTPUT: SIX OVAL entity id string
            e.g. oval:jp.go.aist.six:def:20100061
    ================================================================
    -->
    <xsl:template name="convertToSixOvalID">
        <xsl:param name="id"/>
        <xsl:param name="postfix" select="''"/>

        <xsl:choose>
            <xsl:when test="contains($id, ':def:')">
                <xsl:value-of select="concat($var_six_oval-id-prefix, ':def:', substring-after($id, ':def:'), $postfix)"/>
            </xsl:when>
            <xsl:when test="contains($id, ':ste:')">
                <xsl:value-of select="concat($var_six_oval-id-prefix, ':ste:', substring-after($id, ':ste:'), $postfix)"/>
            </xsl:when>
            <xsl:when test="contains($id, ':obj:')">
                <xsl:value-of select="concat($var_six_oval-id-prefix, ':obj:', substring-after($id, ':obj:'), $postfix)"/>
            </xsl:when>
            <xsl:when test="contains($id, ':tst:')">
                <xsl:value-of select="concat($var_six_oval-id-prefix, ':tst:', substring-after($id, ':tst:'), $postfix)"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of select="concat($id, $postfix)"/>
            </xsl:otherwise>
        </xsl:choose>
        
    </xsl:template>

</xsl:stylesheet>

<!-- vim:set tabstop=4:set expandtab:set shiftwidth=4: -->

