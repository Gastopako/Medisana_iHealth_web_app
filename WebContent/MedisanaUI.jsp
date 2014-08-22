<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Medisana's Vitadock</title>
<link href="MedisanaUI.css" rel="stylesheet" type="text/css"> 


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
                color: '0D818E',
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
                fill: '#0D818E',
                stroke: '#005CB8', 
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
                        fill: '#005CB8',
                        stroke: '#005CB8',
                        'stroke-width': 2,
                    },
                    select: {
                        fill: '#0D818E',
                        stroke: '#005CB8',
                        'stroke-width': 2,
                        style: {
                            color: 'white'
                        }
                    }
                }
            },
            inputBoxBorderColor: '#0D818E',              
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
                barBackgroundColor: '#0D818E',
                barBorderRadius: 7,
                barBorderWidth: 0,
                buttonBackgroundColor: '#0D818E',
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
                             outlineColor: '#0D818E',
                             outlineWidth: 2,

                             series: {
                                 color: '#0D818E',
                             },

                             handles: {
                                 backgroundColor: '#0D818E',
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
        	//color: '#0D818E',
        	color: 'red',
        	
            //name: 'USD to EUR',
            //data: usdeur,
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
    document.getElementById("info_field").innerHTML = "Cardio Dock";
    jsonParser();
}

function Button2() {
    document.getElementById("info_field").innerHTML = "Gluco Dock Glucose";
    jsonParser();
}

function Button3() {
	document.getElementById("info_field").innerHTML = "Gluco Dock Insulin";
    jsonParser();
}

function Button4() {
	document.getElementById("info_field").innerHTML = "Gluco Dock Meal";
    jsonParser();
}

function Button5() {
	document.getElementById("info_field").innerHTML = "Target Scale";
    jsonParser();
}

function Button6() {
	document.getElementById("info_field").innerHTML = "Thermo Dock";
    jsonParser();
}

function Button7() {
	document.getElementById("info_field").innerHTML = "Activity Dock";
    jsonParser();
}

function Button8() {
	document.getElementById("info_field").innerHTML = "Tracker Stats";
    jsonParser();
}

function Button9() {
	document.getElementById("info_field").innerHTML = "Tracker Activity";
    jsonParser();
}

function Button10() {
	document.getElementById("info_field").innerHTML = "Tracker Sleep";
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
objectKeys = Object.keys(newObject[0]);

//Paimamas pirmas objekto elementas.
var newObject2 = newObject[0]; 

// Patikrina ar paimtas elementas yra objektu, 
// jei taip, atliekamos papildomos operacijos, o jei,
// skaicius ar kitas kintamojo tipas, tesiama.
if (typeof newObject2[objectKeys[0]] === 'object')
{
var newObject3 = newObject2[objectKeys[0]];

// document.getElementById("info_field").innerHTML = d;

	objectKeys = Object.keys(newObject3[0]);
	newObject = newObject3;

// 	var adder = 0;
//  	for (var i in newObject){
//  		adder = adder + newObject[i].startTime;
//  		newObject[i].startTime = newObject[i].startTime + adder +d;	
//  	}

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
		//mazosios raides pakeicamos didziosiomis ir padaromi tarpai tarp zodziu
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
	if (keys[i] == 'id' || keys[i] == 'active' || keys[i] == 'version' || keys[i] == 'moduleSerialId' || keys[i] == 'measurementDate'){
		for (var j = 0; j < tbl.rows.length; j++){
			tbl.rows[j].cells[i].style.display="none";
		}}
	else if (keys[i] == 'measurementDate' || keys[i] == 'updatedDate' || keys[i] == 'note') {
		tbl.rows[0].cells[i].className = "unclickable_rule";	
		tbl.rows[0].cells[i].disabled = true;
		if (keys[i] != 'note'){
		for (var j = 1; j < tbl.rows.length; j++){
			var epoch = tbl.rows[j].cells[i].innerHTML;
			//Epochos mikrosekundemis konvertavimas i normalia data:
			var d = new Date(parseInt(epoch)); if (d != null) { d = 
				d.toUTCString();} 
			tbl.rows[j].cells[i].innerHTML = d;	
		}}}
	else if (keys[i] == 'arrhythmic'){
		for (var j = 1; j < tbl.rows.length; j++){
			var variable = tbl.rows[j].cells[i].innerHTML;
            if (variable == '0') 
            tbl.rows[j].cells[i].innerHTML = 'No arrhythmia';
            else if (variable == '1') 
            tbl.rows[j].cells[i].innerHTML = 'Is arrhythmia';		
		}}
	else if (keys[i] == 'bodyWeight' || keys[i] == 'bmi' || keys[i] == 'bodyFat' || keys[i] == 'muscleMass' || keys[i] == 'boneMass' || keys[i] == 'bodyWater'){
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
            // Apverciamas masyvas tam, kad prasidetu nuo mazesniu x verciu iki didesniu, o ne atvirksciai
            // Tada highcharts veikia.
            output = output.reverse(); 
                
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
                                       
                   // Kai kintamasis - epocha, konvertuojama taip:
                   //Epoch = table.rows[i].cells[timecellidx].innerHTML;
                   //var dateFormat = new Date(0); 
                   //var ConvDate = dateFormat.setUTCMilliseconds(Epoch);
                   
                   // Kai kintamasis - normali data, tuomet konvertuojam i epocha:
                   Norm_date = table.rows[i].cells[timecellidx].innerHTML;
                   var Epoch = new Date(Norm_date);                       
                   Epoch = Epoch.getTime();                    
                   helperVal[i - 1] = Epoch; // Pagal data
                   //helperVal[i - 1] = ConvDate; // Pagal data
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
                	 //if (document.getElementById("measurementDate") != null)
                	 time_header_index = document.getElementById("updatedDate").cellIndex;  
                	 //else
                	 //time_header_index = document.getElementById("startTime").cellIndex;
                	 
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
                	 //if (document.getElementById("measurementDate") != null)
                	 time_header_index = document.getElementById("updatedDate").cellIndex;  
                	 //else
                	 //time_header_index = document.getElementById("startTime").cellIndex; 
                	 
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


<form id="form" action="Medisana" method="post">
<!-- <form id="form" action="MedisanaCallback" method="post">  -->

<div style="background-color: #FFFFFF">

<div style="margin-right: auto; text-align:left;" class="info_div">
<%-- <h2 id="info_field"> ${Verifier} </h2> --%>
<h2 id="info_field">  </h2>
</div>


<div style="text-align: center;" class="title_div">
<h1> CARRE Project </h1>
</div>
        
<br/>
	
<div class="button_div">

<input type="submit" name="action1"  value="Cardio Dock"         class="button" onclick="Button1();"/>
<input type="submit" name="action2"  value="Gluco Dock Glucose"  class="button" onclick="Button2();"/>
<input type="submit" name="action3"  value="Gluco Dock Insulin"  class="button" onclick="Button3();"/>
<input type="submit" name="action4"  value="Gluco Dock Meal"     class="button" onclick="Button4();"/>
<input type="submit" name="action5"  value="Target Scale"        class="button" onclick="Button5();"/>
<input type="submit" name="action6"  value="Thermo Dock"         class="button" onclick="Button6();"/>
<input type="submit" name="action7"  value="Activity Dock"       class="button" onclick="Button7();"/>
<input type="submit" name="action8"  value="Tracker Stats"       class="button" onclick="Button8();"/>
<!-- <input type="submit" name="action9"  value="Tracker Activity"    class="button" onclick="Button9();"/> -->
<!-- <input type="submit" name="action10" value="Tracker Sleep"       class="button" onclick="Button10();"/> -->

<!-- <button type="button" id="button_8" onclick="DateFunction();" class="button" >Date</button> -->

</div>

<br/> 
<br/> 
 
 
 <div id='chart_div' class="chart_div"></div> 
 
 <!-- 
<div id="chart_div" style="min-width: 628px; height: 400px; margin: 0 auto"></div>
-->


 <!--
 <div id='chart_div' style='vertical-align:top; margin-left:auto; margin-right:auto; margin-top:40px;' align="left" class="auto-style3"></div>
-->

 <!--  
<div id='chart_div' style='vertical-align:top; margin-left:auto; margin-right:auto; margin-top:40px;' align="left" class="auto-style3"></div>    
-->

<!--  
<div id='my_chart' style='vertical-align:top; margin-left:auto; margin-right:auto; margin-top:40px;' align="left" class="auto-style3"></div>    
-->

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