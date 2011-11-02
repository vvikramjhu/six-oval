<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<xsl:stylesheet version="1.0" 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns:win-def="http://oval.mitre.org/XMLSchema/oval-definitions-5#windows"
  >


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
TEMPLATE:  win-def:file
-->
<xsl:template match="win-def:file_test">
    <win_file_test xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#windows">
        <xsl:copy-of select="@*"/>
        <xsl:copy-of select="node()"/>
    </win_file_test>

<!--
    <win_file_test xsmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5#windows">
        <xsl:apply-templates select="@*"/>
    </win_file_test>
-->
</xsl:template>




<xsl:template match="@*|node()">
    <xsl:copy>
        <xsl:apply-templates select="@*"/>
        <xsl:apply-templates/>
    </xsl:copy>
</xsl:template>



</xsl:stylesheet>
