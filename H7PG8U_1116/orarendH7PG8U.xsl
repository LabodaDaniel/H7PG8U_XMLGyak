<?xml version="1.0"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
    <h2>Órarend</h2>
    <table>
      <xsl:for-each select="orarend/ora">
        <tr>
          <td><xsl:value-of select="targy"/></td>
          <td><xsl:value-of select="idopont/nap"/></td>
          <td><xsl:value-of select="idopont/tol"/></td>
          <td><xsl:value-of select="idopont/ig"/></td>
          <td><xsl:value-of select="helyszin"/></td>
          <td><xsl:value-of select="oktato"/></td>
          <td><xsl:value-of select="szak"/></td>
        </tr>
      </xsl:for-each>
    </table>
  </body>
  </html>
</xsl:template>

</xsl:stylesheet>