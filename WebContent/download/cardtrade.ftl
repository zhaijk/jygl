<?xml version="1.0"?>
<?mso-application progid="Excel.Sheet"?>
<Workbook xmlns="urn:schemas-microsoft-com:office:spreadsheet"
 		  xmlns:o="urn:schemas-microsoft-com:office:office"
 		  xmlns:x="urn:schemas-microsoft-com:office:excel"
 		  xmlns:ss="urn:schemas-microsoft-com:office:spreadsheet"
 		  xmlns:html="http://www.w3.org/TR/REC-html40">
 <DocumentProperties xmlns="urn:schemas-microsoft-com:office:office">
  <Created>1996-12-17T01:32:42Z</Created>
  <LastSaved>2017-03-09T10:16:59Z</LastSaved>
  <Version>12.00</Version>
 </DocumentProperties>
 <OfficeDocumentSettings xmlns="urn:schemas-microsoft-com:office:office">
  <RemovePersonalInformation/>
 </OfficeDocumentSettings>
 <ExcelWorkbook xmlns="urn:schemas-microsoft-com:office:excel">
  <WindowHeight>4530</WindowHeight>
  <WindowWidth>8505</WindowWidth>
  <WindowTopX>480</WindowTopX>
  <WindowTopY>120</WindowTopY>
  <ProtectStructure>False</ProtectStructure>
  <ProtectWindows>False</ProtectWindows>
 </ExcelWorkbook>
 <Styles>
  <Style ss:ID="Default" ss:Name="Normal">
   <Alignment ss:Vertical="Bottom"/>
   <Borders/>
   <Font ss:FontName="瀹嬩綋" x:CharSet="134" ss:Size="12"/>
   <Interior/>
   <NumberFormat/>
   <Protection/>
  </Style>
  <Style ss:ID="s63">
   <Alignment ss:Horizontal="Center" ss:Vertical="Center" ss:WrapText="1"/>
   <Borders>
    <Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="1"
     ss:Color="#000000"/>
    <Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="1"
     ss:Color="#000000"/>
    <Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1"
     ss:Color="#000000"/>
    <Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1"
     ss:Color="#000000"/>
   </Borders>
   <Font ss:FontName="Arial" x:Family="Swiss" ss:Size="12" ss:Color="#333333"
    ss:Bold="1"/>
   <Interior ss:Color="#FFFFFF" ss:Pattern="Solid"/>
  </Style>
  <Style ss:ID="s64">
   <Alignment ss:Horizontal="Center" ss:Vertical="Center" ss:WrapText="1"/>
   <Borders>
    <Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="1"
     ss:Color="#000000"/>
    <Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="1"
     ss:Color="#000000"/>
    <Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1"
     ss:Color="#000000"/>
    <Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1"
     ss:Color="#000000"/>
   </Borders>
   <Font ss:FontName="Arial" x:Family="Swiss" ss:Size="11" ss:Color="#333333"/>
   <Interior ss:Color="#F1F1F1" ss:Pattern="Solid"/>
   <NumberFormat ss:Format="Short Date"/>
  </Style>
  <Style ss:ID="s66">
   <Alignment ss:Horizontal="Center" ss:Vertical="Center"/>
   <Borders>
    <Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="1"
     ss:Color="#000000"/>
   </Borders>
   <Font ss:FontName="瀹嬩綋" x:CharSet="134" ss:Size="26"/>
  </Style>
 </Styles>
 <Worksheet ss:Name="Sheet1">
  <Table ss:ExpandedColumnCount="10" ss:ExpandedRowCount="10000" x:FullColumns="1"
   x:FullRows="1" ss:DefaultColumnWidth="54" ss:DefaultRowHeight="14.25">
   <Column ss:AutoFitWidth="0" ss:Width="87"/>
   <Column ss:AutoFitWidth="0" ss:Width="88.5"/>
   <Column ss:AutoFitWidth="0" ss:Width="91.5"/>
   <Column ss:AutoFitWidth="0" ss:Width="110.25"/>
   <Column ss:AutoFitWidth="0" ss:Width="90.75"/>
   <Column ss:AutoFitWidth="0" ss:Width="105.75"/>
   <Column ss:AutoFitWidth="0" ss:Width="92.25"/>
   <Column ss:AutoitWidth="0" ss:Width="107.25"/>
   <Column ss:AutoFitWidth="0" ss:Width="92.25"/>
   <Column ss:AutoFitWidth="0" ss:Width="113.25"/>
   <Row ss:AutoFitHeight="0" ss:Height="40.5">
    <Cell ss:MergeAcross="9" ss:StyleID="s66"><Data ss:Type="String"> 加油详细列表</Data></Cell>
   </Row>
   <Row ss:AutoFitHeight="0" ss:Height="41.25">
    <Cell ss:StyleID="s63"><Data ss:Type="String">日期</Data></Cell>
    <Cell ss:StyleID="s63"><Data ss:Type="String">时间</Data></Cell>
    <Cell ss:StyleID="s63"><Data ss:Type="String">卡号</Data></Cell>
    <Cell ss:StyleID="s63"><Data ss:Type="String">枪号</Data></Cell>
    <Cell ss:StyleID="s63"><Data ss:Type="String">油品</Data></Cell>
    <Cell ss:StyleID="s63"><Data ss:Type="String">类型</Data></Cell>
    <Cell ss:StyleID="s63"><Data ss:Type="String">加油量</Data></Cell>
    <Cell ss:StyleID="s63"><Data ss:Type="String">消费次数</Data></Cell>
    <Cell ss:StyleID="s63"><Data ss:Type="String">入款次数</Data></Cell>
    <Cell ss:StyleID="s63"><Data ss:Type="String">卡上余额</Data></Cell>
   </Row>
   <#list trades as obj>
   <Row ss:AutoFitHeight="0" ss:Height="24">
    <Cell ss:StyleID="s64"><Data ss:Type="String">${obj.tradeDate}</Data></Cell>
    <Cell ss:StyleID="s64"><Data ss:Type="String">${obj.tradeTime}</Data></Cell>
    <Cell ss:StyleID="s64"><Data ss:Type="String">${obj.cardCode}</Data></Cell>
    <Cell ss:StyleID="s64"><Data ss:Type="String">${obj.gunCode}</Data></Cell>
    <Cell ss:StyleID="s64"><Data ss:Type="String">${obj.oilType}</Data></Cell>
    <Cell ss:StyleID="s64"><Data ss:Type="String">${obj.tradeType}</Data></Cell>
    <Cell ss:StyleID="s64"><Data ss:Type="String">${obj.volumn}</Data></Cell>
    <Cell ss:StyleID="s64"><Data ss:Type="String">${obj.mileage}</Data></Cell>
    <Cell ss:StyleID="s64"><Data ss:Type="String">${obj.sendFlag}</Data></Cell>
    <Cell ss:StyleID="s64"><Data ss:Type="String">${obj.balance}</Data></Cell>
   </Row>
   </#list>   
  </Table>
  <WorksheetOptions xmlns="urn:schemas-microsoft-com:office:excel">
   <Print>
    <ValidPrinterInfo/>
    <PaperSizeIndex>9</PaperSizeIndex>
    <HorizontalResolution>600</HorizontalResolution>
    <VerticalResolution>0</VerticalResolution>
   </Print>
   <Selected/>
   <Panes>
    <Pane>
      <Number>3</Number>
      
    </Pane>
   </Panes>
   <ProtectObjects>False</ProtectObjects>
   <ProtectScenarios>False</ProtectScenarios>
  </WorksheetOptions>
 </Worksheet>
 <Worksheet ss:Name="Sheet2">
  <Table ss:ExpandedColumnCount="1" ss:ExpandedRowCount="1" x:FullColumns="1"
   x:FullRows="1" ss:DefaultColumnWidth="54" ss:DefaultRowHeight="14.25">
  </Table>
  <WorksheetOptions xmlns="urn:schemas-microsoft-com:office:excel">
   <ProtectObjects>False</ProtectObjects>
   <ProtectScenarios>False</ProtectScenarios>
  </WorksheetOptions>
 </Worksheet>
 <Worksheet ss:Name="Sheet3">
  <Table ss:ExpandedColumnCount="1" ss:ExpandedRowCount="1" x:FullColumns="1"
   x:FullRows="1" ss:DefaultColumnWidth="54" ss:DefaultRowHeight="14.25">
  </Table>
  <WorksheetOptions xmlns="urn:schemas-microsoft-com:office:excel">
   <ProtectObjects>False</ProtectObjects>
   <ProtectScenarios>False</ProtectScenarios>
  </WorksheetOptions>
 </Worksheet>
</Workbook>
