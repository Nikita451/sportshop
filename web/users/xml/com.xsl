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
        <p style="background-color: #cc6600">
            <hr />
            <span><xsl:value-of select="name" /></span>  
            <hr />
            <textarea cols="75" rows="5" readonly="readonly">
                <xsl:value-of select="text" />
            </textarea>
            
        </p>
    </xsl:template>

</xsl:stylesheet>
