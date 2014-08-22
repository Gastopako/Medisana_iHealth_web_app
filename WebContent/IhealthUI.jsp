<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to iHealth</title>
<link href="IhealthUI.css" rel="stylesheet" type="text/css"> 


<script type='text/javascript' src='http://www.google.com/jsapi'></script>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

<script src="http://code.highcharts.com/stock/highstock.js"></script>
<script src="http://code.highcharts.com/stock/modules/exporting.js"></script>

<!--<script type="text/javascript" src="http://highcharts.com/js/testing-stock.js"></script>-->
<!--<script type="text/javascript" src="http://highcharts.com/samples/data/usdeur.js"></script>-->




<script type="text/javascript">
// Automatiskai submitina pagal taimeri
window.setTimeout(function() {
    document.getElementById('form').submit();
}, 100000);
</script>



<script> 

function drawChart(data_array, measNam) {
	//function drawChart() {
//$(function() {
        chart = new Highcharts.StockChart({
        
        chart: {
            renderTo: 'chart_div',
                panning: true,

                style:{
                fontFamily: 'Segoe UI Semibold', // default font
                fontSize: '12px'},
        },
        
        credits: {
            text: 'CARRE project',
            href: 'http://www.carre-project.eu'
        },
        
        title: {
            text: measNam,
            style: {
                color: 'Black',
                font: 'bold 22px "Trebuchet MS", Verdana, sans-serif',
            },
        },
        
        xAxis: {

        ordinal:false,
        type: 'datetime',
        minorGridLineWidth: 0,
        gridLineWidth: 1,
        tickWidth: 0.5,
        gridLineColor: 'black',
        //lineColor: '#005CB8',
        lineColor: 'black',
        lineWidth: 2,
        tickColor: '#000',
        labels: {
            style: {
                color: 'black',
                fontWeight: 'bold',
                font: '11px Trebuchet MS, Verdana, sans-serif'
            }
        },
        title: {
            style: {
                color: 'black',
                fontWeight: 'bold',
                fontSize: '12px',
                fontFamily: 'Trebuchet MS, Verdana, sans-serif',
            }
        }
            
        },              
        
        yAxis: {

            plotLines: [{
                value: 0,
                width: 1,
                color: '#CC3300',
            }],

            minorGridLineWidth: 0,
            gridLineColor: 'black',
            gridLineWidth: 1,
            //lineColor: '#005CB8',
            lineColor: 'black',
            lineWidth: 2,
            tickWidth: 0.5,
            tickColor: '#000',
            labels: {
                style: {
                    color: 'black',
                    fontWeight: 'bold',
                    font: '11px Trebuchet MS, Verdana, sans-serif'
                }
            },
            title: {
                style: {
                    color: 'Black',
                    fontWeight: 'bold',
                    fontSize: '12px',
                    fontFamily: 'Trebuchet MS, Verdana, sans-serif'
                }
            }
        },
        
        
        rangeSelector: {
            selected: 0,
            inputEnabled: $('#chart_div').width() > 460,       
            buttonTheme: { // styles for the buttons                 
                fill: '#CC3300',
                stroke: '#B82E00', 
                'stroke-width': 2,
                width: 20,
                padding: 3,
                r: 6,
                style: {
                    color: '#FFFFFF',
                    fontWeight: 'bold'
                },
                states: {
                    hover: {
                        fill: '#B82E00',
                        stroke: '#B82E00',
                        'stroke-width': 2,
                    },
                    select: {
                        fill: '#CC3300',
                        stroke: '#B82E00',
                        'stroke-width': 2,
                        style: {
                            color: 'white'
                        }
                    }
                }
            },
            inputBoxBorderColor: '#CC3300',              
            inputBoxWidth: 100,
            inputBoxHeight: 18,
            inputStyle: {
                color: 'Black',
                fontSize: '14px',
                fontWeight: 'bold',
            },
            labelStyle: {
                color: 'Black',
                fontSize: '14px',
                fontWeight: 'bold',
            },
            selected: 0,
            buttonSpacing: 5,
            buttons: [        
            {type: 'all',
            text: 'All'},
            
            {type: 'hour',
            count: 1,
            text: '1h'},

            {type: 'day',
            count: 1,
            text: '1d'},

            {type: 'week',
            count: 1,
            text: '1w'},

            {type: 'month',
            count: 1,
            text: '1m'},

            {type: 'month',
            count: 3,
            text: '3m'},

            {type: 'month',
            count: 6,
            text: '6m'},

            {type: 'year',
            count: 1,
            text: '1y'},

            //{type: 'ytd',
            //text: 'YTD'},
            ]},
            
            
            scrollbar: {
                barBackgroundColor: '#CC3300',
                barBorderRadius: 7,
                barBorderWidth: 0,
                buttonBackgroundColor: '#CC3300',
                buttonBorderWidth: 0,
                buttonBorderRadius: 7,
                buttonArrowColor:'black',
                trackBackgroundColor: 'none',
                trackBorderWidth: 1,
                trackBorderRadius: 8,
                trackBorderColor: 'black',
                rifleColor: 'black'
            },

            plotOptions: {
                series: {
                    lineWidth: 3,
                    states:
                        {hover: {
                         enabled: true,
                         lineWidth: 4,}}}},
                         
                         
                         navigator: {
                             enabled: true,
                             outlineColor: '#CC3300',
                             outlineWidth: 2,

                             series: {
                                 color: '#CC3300',
                             },

                             handles: {
                                 backgroundColor: '#CC3300',
                                 borderColor: 'black'
                             },
                             maskFill: 'rgba(180, 198, 220, 0.75)',

                             xAxis: {
                                 labels: {
                                     enabled: false
                                 },
                                 title: {
                                     text: false
                                 },
                                 tickWidth: 0
                             }

                         },
        
               
        series: [{
        	//color: '#CC3300',
        	color: 'red',
        	
                name: measNam,
                data: data_array,  
                
            tooltip: {
                valueDecimals: 2
            }
        }]             
                        
    });
//});
}
</script> 
 
  
<script>

function Button1() {
    document.getElementById("info_field").innerHTML = "Blood Pressure Data";
    jsonParser();
}

function Button2() {
    document.getElementById("info_field").innerHTML = "Weight Data";
    jsonParser();
}

function Button3() {
	document.getElementById("info_field").innerHTML = "Blood Glucose Data";
    jsonParser();
}

function Button4() {
	document.getElementById("info_field").innerHTML = "SpO2 Data";
    jsonParser();
}

function Button5() {
	document.getElementById("info_field").innerHTML = "Activity Data";
    jsonParser();
}

function Button6() {
	document.getElementById("info_field").innerHTML = "Sleep Data";
    jsonParser();
}

function Button7() {
	document.getElementById("info_field").innerHTML = "Refresh Access Token";
    jsonParser();
}

</script>

 
<script type="text/javascript">
 
function jsonParser()
{
var jsonString = '${data}';
// Čia iš JSON string gaunamas objektas
var newObject = JSON.parse(jsonString);
// Čia gaunu visų objektų pavadinimus:
objectKeys = Object.keys(newObject);

//Ieskoma elementu su objektais, 
for (var i=0; i<objectKeys.length; i++) {
	if (typeof newObject[objectKeys[i]] === 'object') {
		//document.getElementById("info_field").innerHTML = newObject[objectKeys[i]];
		newObject = newObject[objectKeys[i]];
		//document.getElementById("info_field").innerHTML = Object.keys(newObject[0]);
		objectKeys = Object.keys(newObject[0]);
		}
}

//Iskvieciama lenteles sudarymo funkcija:
tableGenerator(newObject, objectKeys);
}

</script> 
 

 <script type="text/javascript">
 
// Lenteles generavimo is gautu duomenu funkcija
function tableGenerator(data, keys)
{  	
//Lenteles kintamasis:
var tbl = document.getElementById("data_table");
// Isvalo lentele pries sukuriant nauja.
tbl.innerHTML = "";

var table = $('#data_table');
var th;
var td;
var counter = 0;

$.each(data, function(idx, elem){	
	var add_td = 0;	
	var add_th = 0;
	counter++;	
	
	for (var i = 0; i < keys.length; i++)
	{			    
		// Lentelės antraštės	
		td = '<td>' +elem[keys[i]]+ '</td>'; 
		// Antrasciu pavadinimai gaunami is isparsinto JSON masyvo (keys), 
		// mazosios raides pakeicamos didziosiomis ir padaromi tarpai tarp zodziu
		th = '<th>' +(keys[i].charAt(0).toUpperCase()+ keys[i].substring(1)).replace(/([a-zA-Z])([A-Z])([a-z])/g, '$1 $2$3')+ '</th>'; 
	
		add_td = add_td + td;
		if (counter == 1){
		add_th = add_th + th;}
	}
	if (counter == 1){
table.append('<tr>' +add_th+ '</tr>');}
table.append('<tr>' +add_td+ '</tr>');
	
// Nustato id reiksmes kiekvienai lenteles antrastes celei:
for (var i = 0; i < keys.length; i++){	
	tbl.rows[0].cells[i].id = keys[i];}

});

TableCustomizer(keys, tbl);

return table;
}

// Funkcija, slepianti pasirinktus lenteles stulpelius ir konvertuojanti vertes (pagal th id):
function TableCustomizer(keys, tbl){
for (var i = 0; i < keys.length; i++){	
	if (keys[i] == 'DataID' || keys[i] == 'version' || keys[i] == 'moduleSerialId' || keys[i] == 'LastChangeTime'){
		for (var j = 0; j < tbl.rows.length; j++){
			tbl.rows[j].cells[i].style.display="none";
		}}
	else if (keys[i] == 'MDate' || keys[i] == 'LastChangeTime' || keys[i] == 'Note') {
		tbl.rows[0].cells[i].className = "unclickable_rule";	
		tbl.rows[0].cells[i].disabled = true;
		if (keys[i] != 'Note'){
		for (var j = 1; j < tbl.rows.length; j++){
			var epoch = tbl.rows[j].cells[i].innerHTML;
			//Epochos mikrosekundemis konvertavimas i normalia data:
			var d = new Date(parseInt(epoch*1000)); if (d != null) { d = 
				d.toUTCString();} 
			tbl.rows[j].cells[i].innerHTML = d;	
		}}}
	else if (keys[i] == 'IsArr'){
		for (var j = 1; j < tbl.rows.length; j++){
			var variable = tbl.rows[j].cells[i].innerHTML;
            if (variable == '1') 
            tbl.rows[j].cells[i].innerHTML = 'No arrhythmia';
            else if (variable == '2') 
            tbl.rows[j].cells[i].innerHTML = 'Arrhythmia cordis';
            else if (variable == '3') 
            tbl.rows[j].cells[i].innerHTML = 'Unknown';
            else if (variable == '-1') 
            tbl.rows[j].cells[i].innerHTML = 'Null';					
		}}
	else if (keys[i] == 'BMI'){
		for (var j = 1; j < tbl.rows.length; j++){	
			var variable = tbl.rows[j].cells[i].innerHTML;
			tbl.rows[j].cells[i].innerHTML = parseFloat(variable).toFixed(2).toString();
		}}
	
	}}
	
</script> 


 <script type="text/javascript">
          function construct2dArray(myCol1, myCol2, measName) {

            var output = [];
            for (var i = 0; i < myCol1.length; i++) {
                output.push([myCol1[i], myCol2[i]]);};
                
            drawChart(output, measName);
            }
 </script>


 <script type="text/javascript">
 function GetColumnValues(tableId, cellIdx, timecellidx, measName) {
	  
               var columnVal = new Array();
               var helperVal = new Array();
               var FltColVal;
               var table = document.getElementById(tableId);
                            
               for (var i = 1; i < table.rows.length; i++) {
               //for (var i = 1; i < 25; i++) {
            	   
                   FltColVal = parseFloat(table.rows[i].cells[cellIdx].innerHTML);
                            
                   // Suranda NaN vertes
                   var a = isNaN(FltColVal); 
                   if (a == true)
                	   {
                	   //FltColVal = null;
                	   FltColVal = 0;
                	   }
                            
                   columnVal[i - 1] = FltColVal;
                     
                   // Kai kintamasis - normali data, tuomet konvertuojam i epocha:
                   Norm_date = table.rows[i].cells[timecellidx].innerHTML;
                   var Epoch = new Date(Norm_date);                       
                   Epoch = Epoch.getTime();                    
                   helperVal[i - 1] = Epoch; // Pagal data
                   //helperVal[i - 1] = i; // Matavimo numeriais                
                                 
                   construct2dArray(helperVal, columnVal, measName);
               }}
 </script>


 <script language="javascript">
 function TabelHeaderClickListener(){
	 
     var table_id = "data_table";
	 var table_header = document.getElementById(table_id).getElementsByTagName("th");
     	 
	 if (table_header != null) {
		 
         for (var i = 0; i < table_header.length; i++) {
     
                 table_header[i].onclick = function () 
                 {          	 
                	 var header_index = this.cellIndex;
                	 //var header_id = this.id;
                	 var header_name = this.innerHTML;               
                	 //Laiko verte paimama is celes pagal zinoma jos id.
                	 //var time_header_index = document.getElementById("measurementDate").cellIndex;                 
                	 var time_header_index;

                	 time_header_index = document.getElementById("MDate").cellIndex;  
                	 
                	 GetColumnValues(table_id, header_index, time_header_index, header_name);        
                 };               
         }
	 }    
 }
 </script>
    
   
 <script language="javascript">
 function Init(){
	 
     var table_id = "data_table";
	 var table_header = document.getElementById(table_id).getElementsByTagName("th");
     	 
	 if (table_header != null) {
      
                	 var header_index = 0;
                	 //var header_id = this.id;
                	 var header_name = table_header[0].innerHTML;
                	 //Laiko verte paimama is celes pagal zinoma jos id.
                	 //var time_header_index = document.getElementById("measurementDate").cellIndex;                      
                	 
                	 var time_header_index;

                	 time_header_index = document.getElementById("MDate").cellIndex;  
 	 
                	 GetColumnValues(table_id, header_index, time_header_index, header_name);        
	 }  
 }
 </script>    


     
<script type="text/javascript">

function display_on_load()
{
    //document.getElementById("table_1").style.display = "block";	
    jsonParser();
    TabelHeaderClickListener(); 
    Init();
 }

</script> 


 
</head>


<body onload="display_on_load()">


<form id="form" action="IhealthCallback" method="post">
<!-- <form id="form" action="Ihealth" method="post"> -->
    
<div style="background-color: #FFFFFF">

<div style="margin-right: auto; text-align:left;" class="info_div">
<%-- <h2 id="info_field"> ${Code} </h2> --%>
<h2 id="info_field"> </h2>
</div>


<div style="text-align: center;" class="title_div">
<h1> CARRE Project </h1>
</div>
        
<br/>
	
<div class="button_div">

<input type="submit" name="action1"  value="Blood Pressure Data"  class="button" onclick="Button1();"/>
<input type="submit" name="action2"  value="Weight Data"          class="button" onclick="Button2();"/>
<input type="submit" name="action3"  value="Blood Glucose Data"   class="button" onclick="Button3();"/>
<input type="submit" name="action4"  value="SpO2 Data"            class="button" onclick="Button4();"/>
<input type="submit" name="action5"  value="Activity Data"        class="button" onclick="Button5();"/>
<input type="submit" name="action6"  value="Sleep Data"           class="button" onclick="Button6();"/>
<!-- <input type="submit" name="action8"  value="Refresh Access Token" class="button" onclick="Button7();"/> -->

</div>

<br/> 
<br/> 
 
 
<div id='chart_div' class="chart_div"></div> 
 
<div id="data_table_div" class="table_div"> 

<table id="data_table" class="tftable" border="1">

<tbody></tbody>

</table>

</div> 
 
<br style="clear:both"/>
<br/> 
  
  
 
</div>

</form>


</body>
</html>