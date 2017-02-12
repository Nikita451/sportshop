<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : com.xsl
    Created on : 17 Апрель 2014 г., 16:14
    Author     : Никита
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        
        <xsl:apply-templates select="./messages/message" />
    </xsl:template>
    
    <xsl:template match="message">
        <p>
            <hr />
            <span><xsl:value-of select="name" /></span>  
            <hr />
            <textarea cols="75" rows="5" readonly="readonly">
                <xsl:value-of select="text" />
            </textarea>
            <br />
            <xsl:element name="a">
                <xsl:attribute name="href"><xsl:value-of select="@id" /></xsl:attribute>
                <xsl:attribute name="style">background-color: yellow;position: relative; left: 1000px</xsl:attribute>
                <xsl:text>Удалить</xsl:text>
            </xsl:element>
            
        </p>
    </xsl:template>

</xsl:stylesheet>
