<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:cv21="http://univ.fr/cv21"
                exclude-result-prefixes="cv21">
    <xsl:template match="/">
            <!-- TODO: Auto-generated template -->
        <!-- <xsl:element name="html">
            <xsl:element name="body"> -->
                <xsl:element name="p">Le 10 février 2021</xsl:element>
                <xsl:element name="p">CV21 - XSLT V1.0</xsl:element>


                <xsl:apply-templates select="/cv21/objectif"/>

                <xsl:apply-templates select="/cv21/Identite"/>


                <xsl:if test="/cv21/prof">
                    <xsl:apply-templates select="/cv21/prof"/>
                </xsl:if>

                <xsl:apply-templates select="/cv21/competence/diplome"/>


                <xsl:if test="/cv21/competence/certif">
                    <xsl:apply-templates select="/cv21/competence/certif"/>
                </xsl:if>

                <xsl:apply-templates select="/cv21/divers/lv"/>


                <xsl:if test="/cv21/divers/autre">
                    <xsl:apply-templates select="/cv21/divers/autre"/>
                </xsl:if>

            <!-- </xsl:element>
        </xsl:element> -->
    </xsl:template>

    <xsl:template match="/cv21/objectif">
        <xsl:element name="h1">UN TITRE</xsl:element>
        <xsl:value-of select="concat('Demande de ',status)"/>
    </xsl:template>

    <xsl:template match="/cv21/Identite">
        <xsl:element name="h2">
            <xsl:value-of select="concat(genre, ' ')"/>
            <xsl:value-of select="concat(nom, ' ')"/>
            <xsl:value-of select="prenom"/>
        </xsl:element>

        <xsl:element name="p">
            <xsl:value-of select="concat('Tel: ', tel)"/>
            <xsl:element name="br"/>
            <xsl:value-of select="concat('Mel: ', mel)"/>
        </xsl:element>
    </xsl:template>

    <xsl:template match="/cv21/prof">
        <xsl:element name="h2">Expériences proféssionnelles</xsl:element>
        <xsl:element name="ol">
            <xsl:attribute name="type">1</xsl:attribute>
            <xsl:for-each select="expe">
                <xsl:element name="li">
                    <xsl:value-of select="concat(titre,' (du ')"/>
                    <xsl:value-of select="concat(datedeb,' au ')"/>
                    <xsl:value-of select="concat(datefin,')')"/>
                </xsl:element>
            </xsl:for-each>
        </xsl:element>
    </xsl:template>

    <xsl:template match="/cv21/competence/diplome">
        <xsl:element name="h2">Diplômes</xsl:element>
        <xsl:element name="table">
            <xsl:for-each select=".">
                <xsl:element name="tr">
                    <xsl:element name="td">
                        <xsl:value-of select="date"/>
                    </xsl:element>
                    <xsl:element name="td">
                        <xsl:value-of select="titre"/>
                    </xsl:element>
                    <xsl:element name="td">
                        <xsl:value-of select="concat('(',niveau,')')"/>
                    </xsl:element>
                    <xsl:element name="td">
                        <xsl:value-of select="etab"/>
                    </xsl:element>
                </xsl:element>
            </xsl:for-each>
        </xsl:element>
    </xsl:template>

    <xsl:template match="/cv21/competence/certif">
        <xsl:element name="h2">Certifications</xsl:element>
        <xsl:element name="table">
            <xsl:for-each select=".">
                <xsl:element name="tr">
                    <xsl:element name="td">
                        <xsl:value-of select="concat(deb, ' - ', datefin)"/>
                    </xsl:element>
                    <xsl:element name="td">
                        <xsl:value-of select="titre"/>
                    </xsl:element>
                </xsl:element>
            </xsl:for-each>
        </xsl:element>
    </xsl:template>

    <xsl:template match="/cv21/divers/lv">
        <xsl:element name="h2">Langues</xsl:element>
        <xsl:element name="ul">
            <xsl:for-each select=".">
                <xsl:element name="li">
                    <xsl:value-of select="concat(lang, ' : ')"/>
                    <xsl:value-of select="concat(Cert, ' ')"/>
                    <xsl:choose>
                        <xsl:when test="@nivs">
                            <xsl:value-of select="concat('(',nivs, ')')"/>
                        </xsl:when>
                        <xsl:otherwise>
                            <xsl:value-of select="concat('(',nivi, ')')"/>
                        </xsl:otherwise>
                    </xsl:choose>
                </xsl:element>
            </xsl:for-each>
        </xsl:element>
    </xsl:template>

    <xsl:template match="/cv21/divers/autre">
        <xsl:element name="h2">Divers</xsl:element>
        <xsl:element name="ul">
            <xsl:for-each select=".">
                <xsl:element name="li">
                    <xsl:value-of select="concat(titre, ' : ')"/>
                    <xsl:value-of select="comment"/>
                </xsl:element>
            </xsl:for-each>
        </xsl:element>
    </xsl:template>


</xsl:stylesheet>
