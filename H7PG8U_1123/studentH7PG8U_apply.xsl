<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	
	<xsl:template match="/">
		<html>
			<body>
			<h2>Hallgatok apple-template</h2>
			<xsl:apply-templates/>
			</body>
		</html>
	</xsl:template>
	
	<xsl:template match="student">
		<p>
			ID: <span>
			<xsl:value-of select="@id" />
			</span>
			<br />
			<xsl:apply-templates select="vezeteknev"/>
			<xsl:apply-templates select="keresztnev"/>
			<xsl:apply-templates select="becenev"/>
			<xsl:apply-templates select="kor"/>
			<xsl:apply-templates select="fizetes"/>
		</p>
	</xsl:template>
	
	<xsl:template match="id">
		ID: <span style="color:#000000">
		<xsl:value-of select="."/></span>
		<br />
	</xsl:template>
	
	<xsl:template match="vezeteknev">
		Vezeteknev: <span style="color:#00ff00">
		<xsl:value-of select="."/></span>
		<br />
	</xsl:template>
	
	<xsl:template match="keresztnev">
		Vezeteknev: <span style="color:#8b0000">
		<xsl:value-of select="."/></span>
		<br />
	</xsl:template>
	
	<xsl:template match="becenev">
		<xsl:value-of select="."/>
	</xsl:template>
 
	<xsl:template match="kor">
		Kor: <span style="color:#0000ff">
		<xsl:value-of select="."/></span>
		<br />
	</xsl:template>
	
	<xsl:template match="fizetes">
		Fizetes: <span style="color:#ff0000">
		<xsl:value-of select="."/></span>
		<br />
	</xsl:template>



</xsl:stylesheet> 