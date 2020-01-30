<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html>
      <body>
        <h2>Good Games</h2>
        <table border="1">
          <tr bgcolor="#42e5f4">
            <th style="text-align:left">Title</th>
            <th style="text-align:left">Studio</th>
            <th style="text-align:left">Publisher</th>
            <th style="text-align:left">Genre</th>
            <th style="text-align:left">Release</th>
          </tr>
          <xsl:for-each select="goodGames/game">
            <tr>
              <td>
                <xsl:value-of select="title"/>
              </td>
              <td>
                <xsl:value-of select="studio"/>
              </td>
              <td>
                <xsl:value-of select="publisher"/>
              </td>
              <td>
                <xsl:value-of select="genre"/>
              </td>
              <td>
                <xsl:value-of select="release"/>
              </td>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>