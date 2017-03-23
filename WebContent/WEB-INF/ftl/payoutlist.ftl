<?xml version="1.0"?>
<?mso-application progid="Excel.Sheet"?>
<Workbook xmlns="urn:schemas-microsoft-com:office:spreadsheet"
 xmlns:o="urn:schemas-microsoft-com:office:office"
 xmlns:x="urn:schemas-microsoft-com:office:excel"
 xmlns:ss="urn:schemas-microsoft-com:office:spreadsheet"
 xmlns:html="http://www.w3.org/TR/REC-html40">
 <DocumentProperties xmlns="urn:schemas-microsoft-com:office:office">
  <Author>wuyb</Author>
  <LastAuthor>Windows 鐢ㄦ埛</LastAuthor>
  <Created>2015-06-25T10:12:30Z</Created>
  <Version>14.00</Version>
 </DocumentProperties>
 <OfficeDocumentSettings xmlns="urn:schemas-microsoft-com:office:office">
  <AllowPNG/>
 </OfficeDocumentSettings>
 <ExcelWorkbook xmlns="urn:schemas-microsoft-com:office:excel">
  <WindowHeight>9150</WindowHeight>
  <WindowWidth>14940</WindowWidth>
  <WindowTopX>360</WindowTopX>
  <WindowTopY>270</WindowTopY>
  <ProtectStructure>False</ProtectStructure>
  <ProtectWindows>False</ProtectWindows>
 </ExcelWorkbook>
 <Styles>
  <Style ss:ID="Default" ss:Name="Normal">
   <Alignment ss:Vertical="Bottom"/>
   <Borders/>
   <Font ss:FontName="Arial" x:Family="Swiss"/>
   <Interior/>
   <NumberFormat/>
   <Protection/>
  </Style>
  <Style ss:ID="s21">
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
   <Font ss:FontName="瀹嬩綋" x:CharSet="134" ss:Size="11" ss:Bold="1"/>
  </Style>
  <Style ss:ID="s22">
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
   <Font ss:FontName="瀹嬩綋" x:CharSet="134"/>
  </Style>
 </Styles>
 <Worksheet ss:Name="sheet1">
  <Table ss:ExpandedColumnCount="15" ss:ExpandedRowCount="4" x:FullColumns="1"
   x:FullRows="1">
   <Column ss:AutoFitWidth="0" ss:Width="84" ss:Span="14"/>
   <Row ss:Height="13.5">
    <Cell ss:StyleID="s21"><Data ss:Type="String">鍙戞补娴佹按鍙�</Data></Cell>
    <Cell ss:StyleID="s21"><Data ss:Type="String">閮ㄩ棬鍚嶇О</Data></Cell>
    <Cell ss:StyleID="s21"><Data ss:Type="String">娌圭綈鍚嶇О</Data></Cell>
    <Cell ss:StyleID="s21"><Data ss:Type="String">娌瑰搧鍚嶇О</Data></Cell>
    <Cell ss:StyleID="s21"><Data ss:Type="String">楣や綅鍚嶇О</Data></Cell>
    <Cell ss:StyleID="s21"><Data ss:Type="String">寮�鍗曟棩鏈�</Data></Cell>
    <Cell ss:StyleID="s21"><Data ss:Type="String">鎿嶄綔鍛�</Data></Cell>
    <Cell ss:StyleID="s21"><Data ss:Type="String">鐞嗚鍙戞补閲廡</Data></Cell>
    <Cell ss:StyleID="s21"><Data ss:Type="String">瀵嗗害</Data></Cell>
    <Cell ss:StyleID="s21"><Data ss:Type="String">鐞嗚鍙戞补閲廘</Data></Cell>
    <Cell ss:StyleID="s21"><Data ss:Type="String">瀹為檯鍙戞补閲廡</Data></Cell>
    <Cell ss:StyleID="s21"><Data ss:Type="String">瀹為檯鍙戞补閲廘</Data></Cell>
    <Cell ss:StyleID="s21"><Data ss:Type="String">鍙戞补瀵嗙爜</Data></Cell>
    <Cell ss:StyleID="s21"><Data ss:Type="String">鍗曟嵁鍙�</Data></Cell>
    <Cell ss:StyleID="s21"><Data ss:Type="String">娌瑰簱浠ｇ爜</Data></Cell>
   </Row>
   <#list payOutList as bean>
   <Row ss:Height="24">
    <Cell ss:StyleID="s22"><Data ss:Type="String">${bean.payoutId}</Data></Cell>
    <Cell ss:StyleID="s22"><Data ss:Type="String">${bean.departmentName}</Data></Cell>
    <Cell ss:StyleID="s22"><Data ss:Type="String">${bean.tankName}</Data></Cell>
    <Cell ss:StyleID="s22"><Data ss:Type="String">${bean.oilname}</Data></Cell>
    <Cell ss:StyleID="s22"><Data ss:Type="String">${bean.heweiname}</Data></Cell>
    <Cell ss:StyleID="s22"><Data ss:Type="String">${bean.kaidanriqiStr}</Data></Cell>
    <Cell ss:StyleID="s22"><Data ss:Type="String">${bean.operate}</Data></Cell>
    <Cell ss:StyleID="s22"><Data ss:Type="Number">${bean.oshould_T}</Data></Cell>
    <Cell ss:StyleID="s22"><Data ss:Type="Number">${bean.denisty}</Data></Cell>
    <Cell ss:StyleID="s22"><Data ss:Type="Number">${bean.oshould_L}</Data></Cell>
    <Cell ss:StyleID="s22"><Data ss:Type="Number">${bean.sfshould_T}</Data></Cell>
    <Cell ss:StyleID="s22"><Data ss:Type="Number">${bean.sfshould_l}</Data></Cell>
    <Cell ss:StyleID="s22"><Data ss:Type="String">${bean.payoutPW}</Data></Cell>
    <Cell ss:StyleID="s22"><Data ss:Type="String">${bean.danjuhao}</Data></Cell>
    <Cell ss:StyleID="s22"><Data ss:Type="String">${bean.youku_code}</Data></Cell>
   </Row>
   </#list>
  </Table>
  <WorksheetOptions xmlns="urn:schemas-microsoft-com:office:excel">
   <Print>
    <ValidPrinterInfo/>
    <HorizontalResolution>300</HorizontalResolution>
    <VerticalResolution>300</VerticalResolution>
   </Print>
   <Selected/>
   <ProtectObjects>False</ProtectObjects>
   <ProtectScenarios>False</ProtectScenarios>
  </WorksheetOptions>
 </Worksheet>
</Workbook>
