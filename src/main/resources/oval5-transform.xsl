<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<xsl:stylesheet version="1.0" 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  >
<!--
  xmlns:oval-def-5="http://oval.mitre.org/XMLSchema/oval-definitions-5"
  xmlns:oval-sc-5="http://oval.mitre.org/XMLSchema/oval-system-characteristics-5"
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

<!-- namespaces -->
<xsl:variable name="var_ns-def-5-unix"
    select="'http://oval.mitre.org/XMLSchema/oval-definitions-5#unix'"/>
<xsl:variable name="var_ns-sc-5-unix"
    select="'http://oval.mitre.org/XMLSchema/oval-system-characteristics-5#unix'"/>

<xsl:variable name="var_ns-def-5-windows"
    select="'http://oval.mitre.org/XMLSchema/oval-definitions-5#windows'"/>
<xsl:variable name="var_ns-sc-5-windows"
    select="'http://oval.mitre.org/XMLSchema/oval-system-characteristics-5#windows'"/>


<!-- components -->
<!-- 
    file:       unix, windows
    process:    unix, windows
    process58:  unix, windows
-->



<!-- *********************************************************** -->
<!-- TEMPLATE                                                    -->
<!-- *********************************************************** -->

<!-- file (pre-unmarshalling)
<xsl:template match="oval-def-5:tests/*[local-name() = 'file_test'] | oval-def-5:objects/*[local-name() = 'file_object'] | oval-def-5:states/*[local-name() = 'file_state'] | oval-sc-5:system_data/*[local-name() = 'file_item']">
-->
<xsl:template match="*[local-name() = 'file_test'  or  local-name() = 'file_object'  or  local-name() = 'file_state'  or  local-name() = 'file_item']">
    <xsl:variable name="lvar_element" select="local-name(.)"/>
    <xsl:variable name="lvar_ns" select="namespace-uri(.)"/>
<!--
    <xsl:message>
        <xsl:value-of select="$lvar_element"/>
        <xsl:value-of select="$lvar_ns"/>
    </xsl:message>
-->

    <xsl:choose>
        <xsl:when test="$lvar_ns = $var_ns-def-5-unix  or  $lvar_ns = $var_ns-sc-5-unix">
            <xsl:call-template name="func_output-oval-5-unix-component">
                <xsl:with-param name="lvar_element" select="$lvar_element"/>
                <xsl:with-param name="lvar_ns" select="$lvar_ns"/>
            </xsl:call-template>
        </xsl:when>
        
        <xsl:otherwise>
            <!-- copy the element deeply, i.e. output the element as it is -->
            <xsl:copy>
                <xsl:apply-templates select="@* | node()"/>
            </xsl:copy>
        </xsl:otherwise>
    </xsl:choose>

</xsl:template>


<!-- process (pre-unmarshalling)
<xsl:template match="oval-def-5:tests/*[local-name() = 'process_test'] | oval-def-5:objects/*[local-name() = 'process_object'] | oval-def-5:states/*[local-name() = 'process_state'] | oval-sc-5:system_data/*[local-name() = 'process_item']">
-->
<xsl:template match="*[local-name() = 'process_test'  or  local-name() = 'process_object'  or  local-name() = 'process_state'  or  local-name() = 'process_item']">
    <xsl:variable name="lvar_element" select="local-name(.)"/>
    <xsl:variable name="lvar_ns" select="namespace-uri(.)"/>

    <xsl:choose>
        <xsl:when test="$lvar_ns = $var_ns-def-5-unix  or  $lvar_ns = $var_ns-sc-5-unix">
            <xsl:call-template name="func_output-oval-5-unix-component">
                <xsl:with-param name="lvar_element" select="$lvar_element"/>
                <xsl:with-param name="lvar_ns" select="$lvar_ns"/>
            </xsl:call-template>
        </xsl:when>
        
        <xsl:otherwise>
            <!-- copy the element deeply, i.e. output the element as it is -->
            <xsl:copy>
                <xsl:apply-templates select="@* | node()"/>
            </xsl:copy>
        </xsl:otherwise>
    </xsl:choose>

</xsl:template>


<!-- process (post-marshalling)
<xsl:template match="oval-def-5:tests/*[local-name() = 'process_test'] | oval-def-5:objects/*[local-name() = 'process_object'] | oval-def-5:states/*[local-name() = 'process_state'] | oval-sc-5:system_data/*[local-name() = 'process_item']">
-->
<xsl:template match="*[local-name() = 'unix_process_test'  or  local-name() = 'unix_process_object'  or  local-name() = 'unix_process_state'  or  local-name() = 'unix_process_item']">
    <xsl:variable name="lvar_element" select="local-name(.)"/>
    <xsl:variable name="lvar_ns" select="namespace-uri(.)"/>

    <xsl:choose>
        <xsl:when test="$lvar_ns = $var_ns-def-5-unix  or  $lvar_ns = $var_ns-sc-5-unix">
            <xsl:call-template name="func_output-oval-5-unix-component">
                <xsl:with-param name="lvar_element" select="$lvar_element"/>
                <xsl:with-param name="lvar_ns" select="$lvar_ns"/>
            </xsl:call-template>
        </xsl:when>
        
        <xsl:otherwise>
            <!-- copy the element deeply, i.e. output the element as it is -->
            <xsl:copy>
                <xsl:apply-templates select="@* | node()"/>
            </xsl:copy>
        </xsl:otherwise>
    </xsl:choose>

</xsl:template>




<!-- process58 
<xsl:template match="oval-def-5:tests/*[local-name() = 'process58_test'] | oval-def-5:objects/*[local-name() = 'process58_object'] | oval-def-5:states/*[local-name() = 'process58_state'] | oval-sc-5:system_data/*[local-name() = 'process58_item']">
-->
<xsl:template match="*[local-name() = 'process58_test'  or  local-name() = 'process58_object'  or  local-name() = 'process58_state'  or  local-name() = 'process58_item']">
    <xsl:variable name="lvar_element" select="local-name(.)"/>
    <xsl:variable name="lvar_ns" select="namespace-uri(.)"/>

    <xsl:choose>
        <xsl:when test="$lvar_ns = $var_ns-def-5-unix  or  $lvar_ns = $var_ns-sc-5-unix">
            <xsl:call-template name="func_output-oval-5-unix-component">
                <xsl:with-param name="lvar_element" select="$lvar_element"/>
                <xsl:with-param name="lvar_ns" select="$lvar_ns"/>
            </xsl:call-template>
        </xsl:when>
        
        <xsl:otherwise>
            <!-- copy the element deeply, i.e. output the element as it is -->
            <xsl:copy>
                <xsl:apply-templates select="@* | node()"/>
            </xsl:copy>
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

<xsl:template name="func_output-oval-5-unix-component">
    <xsl:param name="lvar_element"/>
    <xsl:param name="lvar_ns"/>

    <xsl:choose>
        <xsl:when test="$lvar_ns = $var_ns-def-5-unix">
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

                <!-- process -->
                <xsl:when test="$lvar_element = 'process_test'">
                    <unix_process_test xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </unix_process_test>
                </xsl:when>
                <xsl:when test="$lvar_element = 'process_object'">
                    <unix_process_object xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </unix_process_object>
                </xsl:when>
                <xsl:when test="$lvar_element = 'process_state'">
                    <unix_process_state xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </unix_process_state>
                </xsl:when>

                <xsl:when test="$lvar_element = 'unix_process_test'">
                    <process_test xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </process_test>
                </xsl:when>
                <xsl:when test="$lvar_element = 'unix_process_object'">
                    <process_object xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </process_object>
                </xsl:when>
                <xsl:when test="$lvar_element = 'unix_process_state'">
                    <process_state xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </process_state>
                </xsl:when>


                <!-- process58 -->
                <xsl:when test="$lvar_element = 'process58_test'">
                    <unix_process58_test xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </unix_process58_test>
                </xsl:when>
                <xsl:when test="$lvar_element = 'process58_object'">
                    <unix_process58_object xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </unix_process58_object>
                </xsl:when>
                <xsl:when test="$lvar_element = 'process58_state'">
                    <unix_process58_state xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </unix_process58_state>
                </xsl:when>
            </xsl:choose>
        </xsl:when>

        <xsl:when test="$lvar_ns = $var_ns-sc-5-unix">
            <xsl:choose>
                <xsl:when test="$lvar_element = 'file_item'">
                    <unix_file_item xmlns="http://oval.mitre.org/XMLSchema/oval-system-characteristics-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </unix_file_item>
                </xsl:when>

                <xsl:when test="$lvar_element = 'process_item'">
                    <unix_process_item xmlns="http://oval.mitre.org/XMLSchema/oval-system-characteristics-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </unix_process_item>
                </xsl:when>

                <xsl:when test="$lvar_element = 'process58_item'">
                    <unix_process58_item xmlns="http://oval.mitre.org/XMLSchema/oval-system-characteristics-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </unix_process58_item>
                </xsl:when>
            </xsl:choose>
        </xsl:when>
    </xsl:choose>

</xsl:template>

</xsl:stylesheet>
