<?xml version="1.0"?>
<?mso-application progid="Excel.Sheet"?>
<Workbook xmlns="urn:schemas-microsoft-com:office:spreadsheet"
 xmlns:o="urn:schemas-microsoft-com:office:office"
 xmlns:x="urn:schemas-microsoft-com:office:excel"
 xmlns:ss="urn:schemas-microsoft-com:office:spreadsheet"
 xmlns:html="http://www.w3.org/TR/REC-html40">
 <DocumentProperties xmlns="urn:schemas-microsoft-com:office:office">
  <Author>derun</Author>
  <LastAuthor>derun</LastAuthor>
  <Created></Created>
  <LastSaved></LastSaved>
  <Version>12.00</Version>
 </DocumentProperties>
 <ExcelWorkbook xmlns="urn:schemas-microsoft-com:office:excel">
  <WindowHeight>5715</WindowHeight>
  <WindowWidth>12765</WindowWidth>
  <WindowTopX>0</WindowTopX>
  <WindowTopY>105</WindowTopY>
  <ProtectStructure>False</ProtectStructure>
  <ProtectWindows>False</ProtectWindows>
 </ExcelWorkbook>
 <Styles>
  <Style ss:ID="Default" ss:Name="Normal">
   <Alignment ss:Vertical="Bottom"/>
   <Borders/>
   <Font ss:FontName="Tahoma" x:Family="Swiss" ss:Size="11" ss:Color="#000000"/>
   <Interior/>
   <NumberFormat/>
   <Protection/>
  </Style>
  <Style ss:ID="s125">
   <Alignment ss:Horizontal="Center" ss:Vertical="Center"/>
   <Borders>
    <Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="2"
     ss:Color="#000000"/>
   </Borders>
   <Font ss:FontName="瀹嬩綋" x:CharSet="134" ss:Size="24" ss:Color="#000000"/>
  </Style>
  <Style ss:ID="s128">
   <Alignment ss:Horizontal="Center" ss:Vertical="Center" ss:WrapText="1"/>
   <Borders>
    <Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="2"
     ss:Color="#000000"/>
    <Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="2"
     ss:Color="#000000"/>
    <Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="2"
     ss:Color="#000000"/>
   </Borders>
   <Font ss:FontName="Arial" x:Family="Swiss" ss:Size="11" ss:Color="#555555"
    ss:Bold="1"/>
   <Interior ss:Color="#FFFFFF" ss:Pattern="Solid"/>
  </Style>
  <Style ss:ID="s129">
   <Alignment ss:Horizontal="Center" ss:Vertical="Bottom"/>
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
  </Style>
 </Styles>
 <Worksheet ss:Name="Sheet1">
  <Table ss:ExpandedColumnCount="10" ss:ExpandedRowCount="25" x:FullColumns="1"
   x:FullRows="1" ss:DefaultColumnWidth="54" ss:DefaultRowHeight="14.25">
   <Column ss:AutoFitWidth="0" ss:Width="78.75"/>
   <Column ss:AutoFitWidth="0" ss:Width="75"/>
   <Column ss:AutoFitWidth="0" ss:Width="80.25"/>
   <Column ss:AutoFitWidth="0" ss:Width="68.25"/>
   <Column ss:AutoFitWidth="0" ss:Width="76.5"/>
   <Column ss:AutoFitWidth="0" ss:Width="81"/>
   <Column ss:AutoFitWidth="0" ss:Width="83.25" ss:Span="1"/>
   <Column ss:Index="9" ss:AutoFitWidth="0" ss:Width="100.5"/>
   <Column ss:AutoFitWidth="0" ss:Width="83.25"/>
   <Row ss:AutoFitHeight="0" ss:Height="40.5">
    <Cell ss:MergeAcross="9" ss:StyleID="s63"><Data ss:Type="String"> 加油详细列表</Data></Cell>
   </Row>
   <Row ss:AutoFitHeight="0" ss:Height="41.25">
    <Cell ss:StyleID="s65"><Data ss:Type="String">日期</Data></Cell>
    <Cell ss:StyleID="s65"><Data ss:Type="String">时间</Data></Cell>
    <Cell ss:StyleID="s65"><Data ss:Type="String">卡号</Data></Cell>
    <Cell ss:StyleID="s65"><Data ss:Type="String">枪号</Data></Cell>
    <Cell ss:StyleID="s65"><Data ss:Type="String">油品</Data></Cell>
    <Cell ss:StyleID="s65"><Data ss:Type="String">类型</Data></Cell>
    <Cell ss:StyleID="s65"><Data ss:Type="String">加油量</Data></Cell>
    <Cell ss:StyleID="s65"><Data ss:Type="String">消费次数</Data></Cell>
    <Cell ss:StyleID="s65"><Data ss:Type="String">入款次数</Data></Cell>
    <Cell ss:StyleID="s65"><Data ss:Type="String">卡上余额</Data></Cell>
   <#list trades as obj>
   <Row>
    <Cell ss:StyleID="s65"><Data ss:Type="String">${obj.tradeDate}</Data></Cell>
    <Cell ss:StyleID="s65"><Data ss:Type="String">${obj.tradeTime}</Data></Cell>
    <Cell ss:StyleID="s65"><Data ss:Type="String">${obj.cardCode}</Data></Cell>
    <Cell ss:StyleID="s65"><Data ss:Type="String">${obj.gunCode}</Data></Cell>
    <Cell ss:StyleID="s65"><Data ss:Type="String">${obj.oilType}</Data></Cell>
    <Cell ss:StyleID="s65"><Data ss:Type="String">${obj.tradeType}</Data></Cell>
    <Cell ss:StyleID="s65"><Data ss:Type="String">${obj.volumn}</Data></Cell>
    <Cell ss:StyleID="s65"><Data ss:Type="String">${obj.mileage}</Data></Cell>
    <Cell ss:StyleID="s65"><Data ss:Type="String">${obj.sendFlag}</Data></Cell>
    <Cell ss:StyleID="s65"><Data ss:Type="String">${obj.balance}</Data></Cell>
   </Row>
   </#list>   
  </Table>
  <WorksheetOptions xmlns="urn:schemas-microsoft-com:office:excel">
   <PageSetup>
    <Header x:Margin="0.3"/>
    <Footer x:Margin="0.3"/>
    <PageMargins x:Bottom="0.75" x:Left="0.7" x:Right="0.7" x:Top="0.75"/>
   </PageSetup>
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
     <ActiveRow>23</ActiveRow>
     <ActiveCol>5</ActiveCol>
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
   <PageSetup>
    <Header x:Margin="0.3"/>
    <Footer x:Margin="0.3"/>
    <PageMargins x:Bottom="0.75" x:Left="0.7" x:Right="0.7" x:Top="0.75"/>
   </PageSetup>
   <ProtectObjects>False</ProtectObjects>
   <ProtectScenarios>False</ProtectScenarios>
  </WorksheetOptions>
 </Worksheet>
 <Worksheet ss:Name="Sheet3">
  <Table ss:ExpandedColumnCount="1" ss:ExpandedRowCount="1" x:FullColumns="1"
   x:FullRows="1" ss:DefaultColumnWidth="54" ss:DefaultRowHeight="14.25">
  </Table>
  <WorksheetOptions xmlns="urn:schemas-microsoft-com:office:excel">
   <PageSetup>
    <Header x:Margin="0.3"/>
    <Footer x:Margin="0.3"/>
    <PageMargins x:Bottom="0.75" x:Left="0.7" x:Right="0.7" x:Top="0.75"/>
   </PageSetup>
   <ProtectObjects>False</ProtectObjects>
   <ProtectScenarios>False</ProtectScenarios>
  </WorksheetOptions>
 </Worksheet>
</Workbook>
