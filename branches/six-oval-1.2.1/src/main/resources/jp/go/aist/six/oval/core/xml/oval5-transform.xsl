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
@version    $Id: oval5-transform.xsl 2967 2012-09-21 03:22:54Z nakamura5akihito@gmail.com $
-->


<!-- %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% -->
<!-- output                                                      -->
<!-- %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% -->

<xsl:output method="xml" indent="yes"/>



<!-- %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% -->
<!-- global variables                                            -->
<!-- %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% -->

<!-- namespaces -->
<xsl:variable name="var_ns-def-5-macos"
    select="'http://oval.mitre.org/XMLSchema/oval-definitions-5#macos'"/>
<xsl:variable name="var_ns-sc-5-macos"
    select="'http://oval.mitre.org/XMLSchema/oval-system-characteristics-5#macos'"/>

<xsl:variable name="var_ns-def-5-unix"
    select="'http://oval.mitre.org/XMLSchema/oval-definitions-5#unix'"/>
<xsl:variable name="var_ns-sc-5-unix"
    select="'http://oval.mitre.org/XMLSchema/oval-system-characteristics-5#unix'"/>

<xsl:variable name="var_ns-def-5-windows"
    select="'http://oval.mitre.org/XMLSchema/oval-definitions-5#windows'"/>
<xsl:variable name="var_ns-sc-5-windows"
    select="'http://oval.mitre.org/XMLSchema/oval-system-characteristics-5#windows'"/>


<!-- %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% -->
<!-- TEMPLATE                                                    -->
<!-- %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% -->

<!-- DUPLICATED components 
    @see OvalComponentType.java
-->
<!--
    dnscache:               unix, windows 
    file:                   unix, windows
    inetlisteningservers:   linux, macos
    interface:              unix, windows
    process:                unix, windows
    process58:              unix, windows
-->


<!-- *********************************************************** -->
<!-- dnscache                                                    -->
<!-- *********************************************************** -->

<!-- dnscache (pre-unmarshalling)
-->
<xsl:template match="*[local-name() = 'dnscache_test'  or  local-name() = 'dnscache_object'  or  local-name() = 'dnscache_state'  or  local-name() = 'dnscache_item']">
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


<!-- dnscache (post-marshalling) -->
<xsl:template match="*[local-name() = 'unix_dnscache_test'  or  local-name() = 'unix_dnscache_object'  or  local-name() = 'unix_dnscache_state'  or  local-name() = 'unix_dnscache_item']">
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



<!-- *********************************************************** -->
<!-- file                                                        -->
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


<!-- file (post-marshalling) -->
<xsl:template match="*[local-name() = 'unix_file_test'  or  local-name() = 'unix_file_object'  or  local-name() = 'unix_file_state'  or  local-name() = 'unix_file_item']">
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



<!-- *********************************************************** -->
<!-- inetlisteningservers                                        -->
<!-- *********************************************************** -->

<!-- inetlisteningservers (pre-unmarshalling)
-->
<xsl:template match="*[local-name() = 'inetlisteningservers_test'  or  local-name() = 'inetlisteningservers_object'  or  local-name() = 'inetlisteningservers_state'  or  local-name() = 'inetlisteningservers_item']">
    <xsl:variable name="lvar_element" select="local-name(.)"/>
    <xsl:variable name="lvar_ns" select="namespace-uri(.)"/>
<!--
    <xsl:message>
        <xsl:value-of select="$lvar_element"/>
        <xsl:value-of select="$lvar_ns"/>
    </xsl:message>
-->

    <xsl:choose>
        <xsl:when test="$lvar_ns = $var_ns-def-5-macos  or  $lvar_ns = $var_ns-sc-5-macos">
            <xsl:call-template name="func_output-oval-5-macos-component">
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


<!-- inetlisteningservers (post-marshalling) -->
<xsl:template match="*[local-name() = 'macos_inetlisteningservers_test'  or  local-name() = 'macos_inetlisteningservers_object'  or  local-name() = 'macos_inetlisteningservers_state'  or  local-name() = 'macos_inetlisteningservers_item']">
    <xsl:variable name="lvar_element" select="local-name(.)"/>
    <xsl:variable name="lvar_ns" select="namespace-uri(.)"/>

    <xsl:choose>
        <xsl:when test="$lvar_ns = $var_ns-def-5-macos  or  $lvar_ns = $var_ns-sc-5-macos">
            <xsl:call-template name="func_output-oval-5-macos-component">
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



<!-- *********************************************************** -->
<!-- interface                                                   -->
<!-- *********************************************************** -->

<!-- interface (pre-unmarshalling) -->
<xsl:template match="*[local-name() = 'interface_test'  or  local-name() = 'interface_object'  or  local-name() = 'interface_state'  or  local-name() = 'interface_item']">
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


<!-- interface (post-marshalling) -->
<xsl:template match="*[local-name() = 'unix_interface_test'  or  local-name() = 'unix_interface_object'  or  local-name() = 'unix_interface_state'  or  local-name() = 'unix_interface_item']">
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



<!-- *********************************************************** -->
<!-- process                                                     -->
<!-- *********************************************************** -->

<!-- process (pre-unmarshalling) -->
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


<!-- process (post-marshalling) -->
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



<!-- *********************************************************** -->
<!-- process58                                                   -->
<!-- *********************************************************** -->

<!-- process58 (pre-unmarshalling) -->
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


<!-- process58 (post-marshalling) -->
<xsl:template match="*[local-name() = 'unix_process58_test'  or  local-name() = 'unix_process58_object'  or  local-name() = 'unix_process58_state'  or  local-name() = 'unix_process58_item']">
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



<!-- *********************************************************** -->
<!-- misc                                                        -->
<!-- *********************************************************** -->

<!-- 
TEMPLATE:  Copy idiom.
-->
<xsl:template match="node() | @*">
    <xsl:copy>
        <xsl:apply-templates select="@* | node()"/>
    </xsl:copy>
</xsl:template>




<!-- %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% -->
<!-- NAMED TEMPLATE                                              -->
<!-- %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% -->

<!-- *********************************************************** -->
<!-- #macos                                                      -->
<!-- *********************************************************** -->
<xsl:template name="func_output-oval-5-macos-component">
    <xsl:param name="lvar_element"/>
    <xsl:param name="lvar_ns"/>

    <xsl:choose>
        <xsl:when test="$lvar_ns = $var_ns-def-5-macos">
            <xsl:choose>
<!-- inetlisteningservers -->
                <xsl:when test="$lvar_element = 'inetlisteningservers_test'">
                    <macos_inetlisteningservers_test xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#macos">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </macos_inetlisteningservers_test>
                </xsl:when>
                <xsl:when test="$lvar_element = 'inetlisteningservers_object'">
                    <macos_inetlisteningservers_object xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#macos">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </macos_inetlisteningservers_object>
                </xsl:when>
                <xsl:when test="$lvar_element = 'inetlisteningservers_state'">
                    <macos_inetlisteningservers_state xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#macos">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </macos_inetlisteningservers_state>
                </xsl:when>

                <xsl:when test="$lvar_element = 'macos_inetlisteningservers_test'">
                    <inetlisteningservers_test xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#macos">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </inetlisteningservers_test>
                </xsl:when>
                <xsl:when test="$lvar_element = 'macos_inetlisteningservers_object'">
                    <inetlisteningservers_object xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#macos">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </inetlisteningservers_object>
                </xsl:when>
                <xsl:when test="$lvar_element = 'macos_inetlisteningservers_state'">
                    <inetlisteningservers_state xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#macos">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </inetlisteningservers_state>
                </xsl:when>
            </xsl:choose>
        </xsl:when>

        <xsl:when test="$lvar_ns = $var_ns-sc-5-macos">
            <xsl:choose>
<!-- inetlisteningservers -->
                <xsl:when test="$lvar_element = 'inetlisteningservers_item'">
                    <macos_inetlisteningservers_item xmlns="http://oval.mitre.org/XMLSchema/oval-system-characteristics-5#macos">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </macos_inetlisteningservers_item>
                </xsl:when>

                <xsl:when test="$lvar_element = 'macos_inetlisteningservers_item'">
                    <inetlisteningservers_item xmlns="http://oval.mitre.org/XMLSchema/oval-system-characteristics-5#macos">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </inetlisteningservers_item>
                </xsl:when>
            </xsl:choose>
        </xsl:when>
    </xsl:choose>

</xsl:template>


<!-- *********************************************************** -->
<!-- #unix                                                       -->
<!-- *********************************************************** -->
<xsl:template name="func_output-oval-5-unix-component">
    <xsl:param name="lvar_element"/>
    <xsl:param name="lvar_ns"/>

    <xsl:choose>
        <xsl:when test="$lvar_ns = $var_ns-def-5-unix">
            <xsl:choose>
                <!-- dnscache -->
                <xsl:when test="$lvar_element = 'dnscache_test'">
                    <unix_dnscache_test xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </unix_dnscache_test>
                </xsl:when>
                <xsl:when test="$lvar_element = 'dnscache_object'">
                    <unix_dnscache_object xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </unix_dnscache_object>
                </xsl:when>
                <xsl:when test="$lvar_element = 'dnscache_state'">
                    <unix_dnscache_state xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </unix_dnscache_state>
                </xsl:when>

                <xsl:when test="$lvar_element = 'unix_dnscache_test'">
                    <dnscache_test xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </dnscache_test>
                </xsl:when>
                <xsl:when test="$lvar_element = 'unix_dnscache_object'">
                    <dnscache_object xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </dnscache_object>
                </xsl:when>
                <xsl:when test="$lvar_element = 'unix_dnscache_state'">
                    <dnscache_state xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </dnscache_state>
                </xsl:when>


                <!-- interface -->
                <xsl:when test="$lvar_element = 'interface_test'">
                    <unix_interface_test xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </unix_interface_test>
                </xsl:when>
                <xsl:when test="$lvar_element = 'interface_object'">
                    <unix_interface_object xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </unix_interface_object>
                </xsl:when>
                <xsl:when test="$lvar_element = 'interface_state'">
                    <unix_interface_state xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </unix_interface_state>
                </xsl:when>

                <xsl:when test="$lvar_element = 'unix_interface_test'">
                    <interface_test xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </interface_test>
                </xsl:when>
                <xsl:when test="$lvar_element = 'unix_interface_object'">
                    <interface_object xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </interface_object>
                </xsl:when>
                <xsl:when test="$lvar_element = 'unix_interface_state'">
                    <interface_state xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </interface_state>
                </xsl:when>


                <!-- file -->
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

                <xsl:when test="$lvar_element = 'unix_file_test'">
                    <file_test xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </file_test>
                </xsl:when>
                <xsl:when test="$lvar_element = 'unix_file_object'">
                    <file_object xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </file_object>
                </xsl:when>
                <xsl:when test="$lvar_element = 'unix_file_state'">
                    <file_state xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </file_state>
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

                <xsl:when test="$lvar_element = 'unix_process58_test'">
                    <process58_test xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </process58_test>
                </xsl:when>
                <xsl:when test="$lvar_element = 'unix_process58_object'">
                    <process58_object xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </process58_object>
                </xsl:when>
                <xsl:when test="$lvar_element = 'unix_process58_state'">
                    <process58_state xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </process58_state>
                </xsl:when>
            </xsl:choose>
        </xsl:when>

        <xsl:when test="$lvar_ns = $var_ns-sc-5-unix">
            <xsl:choose>
                <!-- dnscache -->
                <xsl:when test="$lvar_element = 'dnscache_item'">
                    <unix_dnscache_item xmlns="http://oval.mitre.org/XMLSchema/oval-system-characteristics-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </unix_dnscache_item>
                </xsl:when>

                <xsl:when test="$lvar_element = 'unix_dnscache_item'">
                    <dnscache_item xmlns="http://oval.mitre.org/XMLSchema/oval-system-characteristics-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </dnscache_item>
                </xsl:when>


                <!-- interface -->
                <xsl:when test="$lvar_element = 'interface_item'">
                    <unix_interface_item xmlns="http://oval.mitre.org/XMLSchema/oval-system-characteristics-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </unix_interface_item>
                </xsl:when>

                <xsl:when test="$lvar_element = 'unix_interface_item'">
                    <interface_item xmlns="http://oval.mitre.org/XMLSchema/oval-system-characteristics-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </interface_item>
                </xsl:when>


                <!-- file -->
                <xsl:when test="$lvar_element = 'file_item'">
                    <unix_file_item xmlns="http://oval.mitre.org/XMLSchema/oval-system-characteristics-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </unix_file_item>
                </xsl:when>

                <xsl:when test="$lvar_element = 'unix_file_item'">
                    <file_item xmlns="http://oval.mitre.org/XMLSchema/oval-system-characteristics-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </file_item>
                </xsl:when>


                <!-- process -->
                <xsl:when test="$lvar_element = 'process_item'">
                    <unix_process_item xmlns="http://oval.mitre.org/XMLSchema/oval-system-characteristics-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </unix_process_item>
                </xsl:when>

                <xsl:when test="$lvar_element = 'unix_process_item'">
                    <process_item xmlns="http://oval.mitre.org/XMLSchema/oval-system-characteristics-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </process_item>
                </xsl:when>


                <!-- process58 -->
                <xsl:when test="$lvar_element = 'process58_item'">
                    <unix_process58_item xmlns="http://oval.mitre.org/XMLSchema/oval-system-characteristics-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </unix_process58_item>
                </xsl:when>

                <xsl:when test="$lvar_element = 'unix_process58_item'">
                    <process58_item xmlns="http://oval.mitre.org/XMLSchema/oval-system-characteristics-5#unix">
                        <xsl:copy-of select="@*"/>
                        <xsl:copy-of select="node()"/>
                    </process58_item>
                </xsl:when>
            </xsl:choose>
        </xsl:when>
    </xsl:choose>

</xsl:template>


</xsl:stylesheet>
