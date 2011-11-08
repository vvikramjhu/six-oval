<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<xsl:stylesheet version="1.0" 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  >
<!--
  xmlns:ind-def="http://oval.mitre.org/XMLSchema/oval-definitions-5#independent"
  xmlns:unix-def="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix"
  xmlns:win-def="http://oval.mitre.org/XMLSchema/oval-definitions-5#windows"
-->

<!-- /////////////////////////////////////////////////////////// -->
<!-- // Project SIX: OVAL                                     // -->
<!-- //                                                       // -->
<!-- // XSLT stylesheet for marshalling pre-process           // -->
<!-- /////////////////////////////////////////////////////////// -->

<!--
@author     Akihito Nakamura, AIST
@version    $Id$
-->


<!-- *********************************************************** -->
<!-- output                                                      -->
<!-- *********************************************************** -->

<xsl:output method="xml" indent="yes"/>



<!-- *********************************************************** -->
<!-- global variables                                            -->
<!-- *********************************************************** -->

<xsl:variable name="var_ns-unix-def-5">
    <xsl:value-of select="'http://oval.mitre.org/XMLSchema/oval-definitions-5#unix'"/>
</xsl:variable>

<xsl:variable name="var_ns-win-def-5">
    <xsl:value-of select="'http://oval.mitre.org/XMLSchema/oval-definitions-5#windows'"/>
</xsl:variable>


<xsl:variable name="var_file-element-unchanged-ns-def-5">
    <xsl:value-of select="$var_ns-win-def-5"/>
<!--
    <xsl:value-of select="$var_ns-unix-def-5"/>
-->
</xsl:variable>



<!-- *********************************************************** -->
<!-- TEMPLATE                                                    -->
<!-- *********************************************************** -->

<!--
TEMPLATE:  Change element names for the file components.
-->
<xsl:template match="*[local-name() = 'file_test'  or  local-name() = 'file_object'  or  local-name() = 'file_state']">
    <xsl:variable name="var_ns" select="namespace-uri()"/>
    <xsl:variable name="var_element" select="local-name()"/>

<!-- DEBUG
-->
    <xsl:message>
        <xsl:value-of select="concat($var_element, ', ', $var_ns)"/>
    </xsl:message>


    <xsl:choose>
        <xsl:when test="$var_ns = $var_file-element-unchanged-ns-def-5">
            <!-- copy the element deeply, i.e. output the element as it is -->
            <xsl:copy>
                <xsl:apply-templates select="@* | node()"/>
            </xsl:copy>
        </xsl:when>
        
        <xsl:otherwise>
            <xsl:call-template name="func_output-file-component">
                <xsl:with-param name="lvar_element" select="$var_element"/>
                <xsl:with-param name="lvar_ns" select="$var_ns"/>
            </xsl:call-template>
        </xsl:otherwise>
    </xsl:choose>

</xsl:template>




<!-- 
TEMPLATE:  Copy idiom.
-->
<xsl:template match="node() | @*">
    <xsl:copy>
        <xsl:apply-templates select="@* | node()"/>
    </xsl:copy>
</xsl:template>



<!-- *********************************************************** -->
<!-- NAMED TEMPLATE                                              -->
<!-- *********************************************************** -->

<!--
NAMED TEMPLATE: Outputs the transformed file components.
-->
<xsl:template name="func_output-file-component">
    <xsl:param name="lvar_element"/>
    <xsl:param name="lvar_ns"/>

    <xsl:choose>
        <xsl:when test="$lvar_ns = $var_ns-unix-def-5">
            <xsl:choose>
                <xsl:when test="$lvar_element = 'file_test'">
                    <unix_file_test xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </unix_file_test>
                </xsl:when>
                <xsl:when test="$lvar_element = 'file_object'">
                    <unix_file_object xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </unix_file_object>
                </xsl:when>
                <xsl:when test="$lvar_element = 'file_state'">
                    <unix_file_state xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </unix_file_state>
                </xsl:when>
            </xsl:choose>
        </xsl:when>

        <xsl:when test="$lvar_ns = $var_ns-win-def-5">
            <xsl:choose>
                <xsl:when test="$lvar_element = 'file_test'">
                    <win_file_test xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#windows">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </win_file_test>
                </xsl:when>
                <xsl:when test="$lvar_element = 'file_object'">
                    <win_file_object xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#windows">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </win_file_object>
                </xsl:when>
                <xsl:when test="$lvar_element = 'file_state'">
                    <win_file_state xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#windows">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </win_file_state>
                </xsl:when>
            </xsl:choose>
        </xsl:when>
    </xsl:choose>

</xsl:template>


</xsl:stylesheet>
