<?xml version = "1.0" encoding = "UTF-8"?>
<xsl:stylesheet
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

	<xsl:template match="/">
		<html>
			<body>
				<h2>Students</h2>
				<table border="1">
					<tr bgcolor="#9acd32">
						<th>Id</th>
						<th>Keresztnev</th>
						<th>Vezeteknev</th>
						<th>Becenev</th>
						<th>Kor</th>
						<th>Fizetes</th>
						<th>Fokozat</th>
					</tr>

					<xsl:for-each select="class/student">
						<tr>
							<td>
								<xsl:value-of select="@id" />
							</td>
							<td>
								<xsl:value-of select="keresztnev" />
							</td>
							<td>
								<xsl:value-of select="vezeteknev" />
							</td>
							<td>
								<xsl:value-of select="becenev" />
							</td>
							<td>
								<xsl:value-of select="kor" />
							</td>
							<td>
								<xsl:value-of select="fizetes" />
							</td>
							  <xsl:choose>
								<xsl:when test="fizetes>'200000'">
									<td>
										<xsl:element name="fokozat">Height</xsl:element>
									</td>
								</xsl:when>
								<xsl:when test="fizetes>'100000'">
									<td>
										<xsl:element name="fokozat">Medium</xsl:element>
									</td>
								</xsl:when>
								<xsl:otherwise>
									<td>
										<xsl:element name="fokozat">Low</xsl:element>
									</td>
								</xsl:otherwise>
							</xsl:choose>
						</tr>
					</xsl:for-each>

				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>