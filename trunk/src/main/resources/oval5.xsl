<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<xsl:stylesheet version="1.0" 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns:win-def="http://oval.mitre.org/XMLSchema/oval-definitions-5#windows"
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



<!-- *********************************************************** -->
<!-- TEMPLATE                                                    -->
<!-- *********************************************************** -->

<!--
TEMPLATE:  file_test
-->
<xsl:template match="*[local-name() = 'file_test'  and  namespace-uri() = 'http://oval.mitre.org/XMLSchema/oval-definitions-5#windows']">
<!-- DEBUG
    <xsl:variable name="ns" select="namespace-uri()"/>
    <xsl:message><xsl:value-of select="$ns"/></xsl:message>
-->

<!-- NG, xmlns attribute is not generated.
    <win_file_test xmlns="{$ns}">
        <xsl:copy-of select="@*[name() != 'xmlns']"/>
        <xsl:copy-of select="node()"/>
    </win_file_test>
-->

<!-- NG, namespace prefix is generated, e.g. ns0:win_file_test xmlns:ns0="..."
    <xsl:element name="{concat('win_', local-name())}" namespace="{namespace-uri()}">
        <xsl:copy-of select="@*[name() != 'xmlns']"/>
        <xsl:copy-of select="node()"/>
    </xsl:element>
-->

<!-- OK
-->
    <win_file_test xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#windows">
        <xsl:copy-of select="@*[name() != 'xmlns']"/>
        <xsl:copy-of select="node()"/>
    </win_file_test>

</xsl:template>




<!-- 
Copy Idiom
-->
<xsl:template match="node() | @*">
    <xsl:copy>
        <xsl:apply-templates select="@* | node()"/>
    </xsl:copy>
</xsl:template>



</xsl:stylesheet>
