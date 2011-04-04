<?xml version="1.0" encoding="UTF-8"?>

<!-- /////////////////////////////////////////////////////////// -->
<!-- // Project SIX: OVAL                                     // -->
<!-- //                                                       // -->
<!-- // XSLT Stylesheet                                       // -->
<!-- // source: OVAL Definitions, SC, or Results              // -->
<!-- // result: CSV for human                                 // -->
<!-- /////////////////////////////////////////////////////////// -->

<!-- @author    Akihito Nakamura, AIST -->
<!-- @version   $Id$ -->

<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns="http://oval.mitre.org/XMLSchema/oval-definitions-5"
    xmlns:oval-def="http://oval.mitre.org/XMLSchema/oval-definitions-5"
    xmlns:unix-def="http://oval.mitre.org/XMLSchema/oval-definitions-5#unix"
    xmlns:red-def="http://oval.mitre.org/XMLSchema/oval-definitions-5#linux"
    xmlns:oval-results="http://oval.mitre.org/XMLSchema/oval-results-5"
    xmlns:oval-sc="http://oval.mitre.org/XMLSchema/oval-system-characteristics-5"
    xmlns:red-sc="http://oval.mitre.org/XMLSchema/oval-system-characteristics-5#linux"
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
    <!-- Output                                                  -->
    <!-- ******************************************************* -->

    <xsl:output
        method      ="text"
        encoding    ="UTF-8"
        indent      ="yes"
        />


    <!-- ******************************************************* -->
    <!-- Parameters                                              -->
    <!-- ******************************************************* -->

    <xsl:param name="separator" select="','"/>
    <xsl:param name="text_delimiter" select="'&quot;'"/>



    <!-- ******************************************************* -->
    <!-- Variables                                               -->
    <!-- ******************************************************* -->




    <!-- ******************************************************* -->
    <!-- Templates (matching)                                    -->
    <!-- ******************************************************* -->

    <!-- definitions -->

    <!--
    oval_definitions/definitions
    ================================================================

    INPUT:
    OUTPUT:
    ================================================================
    -->
    <xsl:template match="oval-def:oval_definitions/oval-def:definitions">
        <xsl:text>definitions:
</xsl:text>

        <xsl:text>id</xsl:text>             <xsl:value-of select="$separator"/>
        <xsl:text>title</xsl:text>          <xsl:value-of select="$separator"/>
        <xsl:text>result</xsl:text>
        <xsl:text>
</xsl:text>
        
        <xsl:apply-templates/>
    </xsl:template>



    <!--
    oval_definitions/definitions/definition
    ================================================================

    INPUT:
    OUTPUT:
    ================================================================
    -->
    <xsl:template match="oval-def:oval_definitions/oval-def:definitions/oval-def:definition">
        <xsl:variable name="def_id" select="@id"/>

        <xsl:value-of select="$def_id"/>
        <xsl:value-of select="$separator"/>
        
        <xsl:value-of select="$text_delimiter"/><xsl:value-of select="normalize-space(oval-def:metadata/oval-def:title)"/><xsl:value-of select="$text_delimiter"/>
        <xsl:value-of select="$separator"/>

        <!-- result -->
        <xsl:for-each select="/oval-results:oval_results/oval-results:results/oval-results:system/oval-results:definitions/oval-results:definition[@definition_id = $def_id]">
            <xsl:value-of select="@result"/>
        </xsl:for-each>

        <xsl:text>
</xsl:text>
    </xsl:template>






    <!-- tests -->

    <!--
    oval_definitions/tests
    ================================================================

    INPUT:
    OUTPUT:
    ================================================================
    -->
    <xsl:template match="oval-def:oval_definitions/oval-def:tests">
        <xsl:text>
</xsl:text>
        <xsl:text>tests:
</xsl:text>

        <xsl:text>id</xsl:text>             <xsl:value-of select="$separator"/>
        <xsl:text>object</xsl:text>         <xsl:value-of select="$separator"/>
        <xsl:text>state</xsl:text>          <xsl:value-of select="$separator"/>
        <xsl:text>description</xsl:text>    <xsl:value-of select="$separator"/>
        <xsl:text>result</xsl:text>         <xsl:value-of select="$separator"/>
        <xsl:text>item</xsl:text>
        <xsl:text>
</xsl:text>

        <!-- xxx_test -->
        <xsl:for-each select="*">
            <xsl:value-of select="@id"/>
            <xsl:value-of select="$separator"/>

            <!-- object -->
            <xsl:variable name="object_id" select="red-def:object/@object_ref"/>
            <xsl:value-of select="$object_id"/>
            <xsl:value-of select="$separator"/>
        
            <!-- state -->
            <xsl:variable name="state_id" select="red-def:state/@state_ref"/>
            <xsl:value-of select="$state_id"/>
            <xsl:value-of select="$separator"/>

            <!-- description -->
            <xsl:variable name="object_name" select="//oval-def:oval_definitions/oval-def:objects/*[@id = $object_id]/red-def:name"/>
            <xsl:variable name="state" select="//oval-def:oval_definitions/oval-def:states/*[@id = $state_id]"/>
            <xsl:value-of select="$text_delimiter"/>
            <xsl:if test="$object_name">
                <xsl:value-of select="$object_name"/>
            </xsl:if>
            <xsl:if test="$state">
                <xsl:for-each select="$state/*">
                    <xsl:value-of select="concat(' ', name(), ' ', @operation, ' ', .)"/>
                </xsl:for-each>
            </xsl:if>
            <xsl:value-of select="$text_delimiter"/>
            <xsl:value-of select="$separator"/>

            <!-- result, items -->
            <xsl:variable name="test_id" select="@id"/>
            <xsl:for-each select="/oval-results:oval_results/oval-results:results/oval-results:system/oval-results:tests/oval-results:test[@test_id = $test_id]">
                <xsl:value-of select="@result"/><xsl:value-of select="$separator"/>
                <xsl:for-each select="oval-results:tested_item">
                    <xsl:value-of select="concat(@item_id, ' ')"/>
                </xsl:for-each>
            </xsl:for-each>

            <xsl:text>
</xsl:text>
        </xsl:for-each>        
    </xsl:template>



    <!--
    oval_definitions/tests/rpminfo_test
    ================================================================

    INPUT:
    OUTPUT:
    ================================================================
    -->
    <xsl:template match="oval-def:oval_definitions/oval-def:tests/red-def:rpminfo_test-backup">
        <xsl:value-of select="@id"/>
        <xsl:value-of select="$separator"/>


        <!-- object -->
        <xsl:variable name="object_id" select="red-def:object/@object_ref"/>
        <xsl:value-of select="$object_id"/>
        <xsl:value-of select="$separator"/>
        
        
        <!-- state -->
        <xsl:variable name="state_id" select="red-def:state/@state_ref"/>
        <xsl:value-of select="$state_id"/>
        <xsl:value-of select="$separator"/>


        <!-- description -->
        <xsl:variable name="object_name" select="//oval-def:oval_definitions/oval-def:objects/red-def:rpminfo_object[@id = $object_id]/red-def:name"/>
        <xsl:variable name="state" select="//oval-def:oval_definitions/oval-def:states/red-def:rpminfo_state[@id = $state_id]"/>
        <xsl:value-of select="$text_delimiter"/>
        <xsl:if test="$object_name">
            <xsl:value-of select="$object_name"/>
        </xsl:if>
        <xsl:if test="$state">
            <xsl:for-each select="$state/*">
                <xsl:value-of select="concat(' ', name(), ' ', @operation, ' ', .)"/>
            </xsl:for-each>
        </xsl:if>
        <xsl:value-of select="$text_delimiter"/>
        <xsl:value-of select="$separator"/>

        <xsl:variable name="test_id" select="@id"/>
        <xsl:for-each select="/oval-results:oval_results/oval-results:results/oval-results:system/oval-results:tests/oval-results:test[@test_id = $test_id]">
            <xsl:value-of select="@result"/><xsl:value-of select="$separator"/>
            <xsl:for-each select="oval-results:tested_item">
                <xsl:value-of select="concat(@item_id, ' ')"/>
            </xsl:for-each>
        </xsl:for-each>

        <xsl:text>
</xsl:text>
    </xsl:template>



    <!-- objects -->

    <!--
    oval_definitions/objects
    ================================================================

    INPUT:
    OUTPUT:
    ================================================================
    -->
    <xsl:template match="oval-def:oval_definitions/oval-def:objects">
        <xsl:text>
</xsl:text>
        <xsl:text>objects:
</xsl:text>
        <xsl:text>id</xsl:text>     <xsl:value-of select="$separator"/>
        <xsl:text>name</xsl:text>   <xsl:value-of select="$separator"/>
        <xsl:text>flag</xsl:text>   <xsl:value-of select="$separator"/>
        <xsl:text>item</xsl:text>

        <xsl:text>
</xsl:text>

        <!-- xxx_object -->
        <xsl:for-each select="*">
            <xsl:variable name="object_id" select="@id"/>

            <xsl:value-of select="$object_id"/> 
            <xsl:value-of select="$separator"/>
        
            <xsl:value-of select="red-def:name"/>
            <xsl:value-of select="$separator"/>

            <xsl:for-each select="/oval-results:oval_results/oval-results:results/oval-results:system/oval-sc:oval_system_characteristics/oval-sc:collected_objects/oval-sc:object[@id = $object_id]">
                <xsl:value-of select="$text_delimiter"/>
                <xsl:value-of select="@flag"/>
                <xsl:value-of select="$text_delimiter"/>
                <xsl:value-of select="$separator"/>

                <xsl:for-each select="oval-sc:reference">
                    <xsl:value-of select="concat(@item_ref, ' ')"/>
                </xsl:for-each>
            </xsl:for-each>
        
            <xsl:text>
</xsl:text>
        </xsl:for-each>        

    </xsl:template>




    <!--
    oval_definitions/objects/rpminfo_object
    ================================================================

    INPUT:
    OUTPUT:
    ================================================================
    -->
    <xsl:template match="oval-def:oval_definitions/oval-def:objects/red-def:rpminfo_object-backup">
        <xsl:variable name="object_id" select="@id"/>

        <xsl:value-of select="$object_id"/> 
        <xsl:value-of select="$separator"/>
        
        <xsl:value-of select="red-def:name"/>
        <xsl:value-of select="$separator"/>

        <xsl:for-each select="/oval-results:oval_results/oval-results:results/oval-results:system/oval-sc:oval_system_characteristics/oval-sc:collected_objects/oval-sc:object[@id = $object_id]">
            <xsl:value-of select="$text_delimiter"/>
            <xsl:value-of select="@flag"/>
            <xsl:value-of select="$text_delimiter"/>
            <xsl:value-of select="$separator"/>

            <xsl:for-each select="oval-sc:reference">
                <xsl:value-of select="concat(@item_ref, ' ')"/>
            </xsl:for-each>
        </xsl:for-each>
        
        <xsl:text>
</xsl:text>
    </xsl:template>



    <!-- states -->

    <!--
    oval_definitions/states
    ================================================================

    INPUT:
    OUTPUT:
    ================================================================
    -->
    <xsl:template match="oval-def:oval_definitions/oval-def:states">
        <xsl:text>
</xsl:text>
        <xsl:text>states:
</xsl:text>
        <xsl:text>id</xsl:text> <xsl:value-of select="$separator"/>
        <xsl:text>description</xsl:text>
        <xsl:text>
</xsl:text>

        <xsl:for-each select="*">
            <xsl:value-of select="@id"/><xsl:value-of select="$separator"/>
        
            <xsl:for-each select="*">
                <xsl:value-of select="$text_delimiter"/>
                <xsl:value-of select="concat(name(), ' ', @operation, ' ', .)"/>
                <xsl:value-of select="$text_delimiter"/>
            </xsl:for-each>

            <xsl:text>
</xsl:text>
        </xsl:for-each>        

    </xsl:template>



    <!--
    oval_definitions/states/rpminfo_state
    ================================================================

    INPUT:
    OUTPUT:
    ================================================================
    -->
    <xsl:template match="oval-def:oval_definitions/oval-def:states/red-def:rpminfo_state-backup">
        <xsl:value-of select="@id"/><xsl:value-of select="$separator"/>
        
        <xsl:for-each select="*">
            <xsl:value-of select="$text_delimiter"/>
            <xsl:value-of select="concat(name(), ' ', @operation, ' ', .)"/>
            <xsl:value-of select="$text_delimiter"/>
        </xsl:for-each>

        <xsl:text>
</xsl:text>
    </xsl:template>




    <!-- test result -->

    <!--
    system/tests
    ================================================================

    INPUT:
    OUTPUT:
    ================================================================
    <xsl:template match="oval-results:system/oval-results:tests">
        <xsl:text>
</xsl:text>
        <xsl:text>test result:
</xsl:text>
        <xsl:value-of select="'id'"/><xsl:value-of select="$separator"/>
        <xsl:value-of select="'result'"/><xsl:value-of select="$separator"/>
        <xsl:value-of select="'item'"/>
        <xsl:text>
</xsl:text>
        
        <xsl:apply-templates/>
    </xsl:template>
    -->



    <!--
    system/tests/test
    ================================================================

    INPUT:
    OUTPUT:
    ================================================================
    <xsl:template match="oval-results:system/oval-results:tests/oval-results:test">
        <xsl:value-of select="@test_id"/><xsl:value-of select="$separator"/>
        <xsl:value-of select="@result"/>
        
        <xsl:for-each select="oval-results:tested_item">
            <xsl:value-of select="$separator"/><xsl:value-of select="@item_id"/>
        </xsl:for-each>
        <xsl:text>
</xsl:text>
    </xsl:template>
    -->





    <!-- sc collected objects -->

    <!--
    oval_system_characteristics/collected_objects
    ================================================================

    INPUT:
    OUTPUT:
    ================================================================
    <xsl:template match="oval-sc:oval_system_characteristics/oval-sc:collected_objects">
        <xsl:text>
</xsl:text>
        <xsl:text>collected objects:
</xsl:text>
        <xsl:value-of select="'id'"/><xsl:value-of select="$separator"/>
        <xsl:value-of select="'flag'"/><xsl:value-of select="$separator"/>
        <xsl:value-of select="'item'"/>
        <xsl:text>
</xsl:text>
        
        <xsl:apply-templates/>
    </xsl:template>
    -->



    <!--
    oval_system_characteristics/collected_objects/object
    ================================================================

    INPUT:
    OUTPUT:
    ================================================================
    <xsl:template match="oval-sc:oval_system_characteristics/oval-sc:collected_objects/oval-sc:object">
        <xsl:value-of select="@id"/><xsl:value-of select="$separator"/>

        <xsl:value-of select="$text_delimiter"/>
        <xsl:value-of select="@flag"/>
        <xsl:value-of select="$text_delimiter"/>
        <xsl:value-of select="$separator"/>

        <xsl:for-each select="oval-sc:reference">
            <xsl:value-of select="concat(@item_ref, ' ')"/>
        </xsl:for-each>

        <xsl:text>
</xsl:text>
    </xsl:template>
    -->



    <!-- sc items -->

    <!--
    oval_system_characteristics/system_data
    ================================================================

    INPUT:
    OUTPUT:
    ================================================================
    -->
    <xsl:template match="oval-sc:oval_system_characteristics/oval-sc:system_data">
        <xsl:text>
</xsl:text>
        <xsl:text>items:
</xsl:text>

        <xsl:text>id</xsl:text>             <xsl:value-of select="$separator"/>
        <xsl:text>name</xsl:text>           <xsl:value-of select="$separator"/>
        <xsl:text>evr</xsl:text>
        <xsl:if test="*/red-sc:signature_keyid">
            <xsl:value-of select="$separator"/>
            <xsl:text>signature_keyid</xsl:text>
        </xsl:if>
        <xsl:text>
</xsl:text>

        <xsl:for-each select="*">
            <xsl:value-of select="@id"/>            <xsl:value-of select="$separator"/>
            <xsl:value-of select="red-sc:name"/>    <xsl:value-of select="$separator"/>
            <xsl:value-of select="red-sc:evr"/>
            <xsl:if test="red-sc:signature_keyid">
                <xsl:value-of select="$separator"/>
                <xsl:value-of select="red-sc:signature_keyid"/>
            </xsl:if>     
            <xsl:text>
</xsl:text>
        </xsl:for-each>        

    </xsl:template>



    <!--
    oval_system_characteristics/system_data/rpminfo_item
    ================================================================

    INPUT:
    OUTPUT:
    ================================================================
    -->
    <xsl:template match="oval-sc:oval_system_characteristics/oval-sc:system_data/red-sc:rpminfo_item-backup">
        <xsl:value-of select="@id"/>            <xsl:value-of select="$separator"/>
        <xsl:value-of select="red-sc:name"/>    <xsl:value-of select="$separator"/>
        <xsl:value-of select="red-sc:evr"/>     <xsl:value-of select="$separator"/>
        <xsl:value-of select="red-sc:signature_keyid"/>
        <xsl:text>
</xsl:text>

    </xsl:template>



    <!--
    ================================================================
    Copies all the nodes and their attributes.
    ================================================================
    -->
    <xsl:template match="@*|node()">
        <xsl:apply-templates/>
    </xsl:template>



    <!-- ******************************************************* -->
    <!-- Templates (named)                                       -->
    <!-- ******************************************************* -->


</xsl:stylesheet>

<!-- vim:set tabstop=4:set expandtab:set shiftwidth=4: -->

