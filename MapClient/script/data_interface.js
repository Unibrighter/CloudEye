//general counting view, no matter whether the geo location is provided or not
var view_general_count_url="http://115.146.89.246:5984/tweets/_design/topic_result/_view/general_count?group=true"
		
//tweet view for those including longitude and latitude pair
var view_valid_point_count="http://115.146.89.246:5984/tweets/_design/topic_result/_view/valid_point_count?reduce=false"

		
function Get(yourUrl)
{// using a get to retrieve the raw text
	var Httpreq = new XMLHttpRequest();
	Httpreq.open("GET",yourUrl,false);
	Httpreq.send(null);
	return Httpreq.responseText;          
}
		
function getRawCollectionAsArray()
{//get the json object as well as the result array
	var json_obj = JSON.parse(Get(view_valid_point_count));	
	var result_array=json_obj.rows;
	return result_array;
}

function filterTopic(raw_array,topic_code)
{
	var result_array=new Array();
	for (var i=0;i<raw_array.length;i++)
	{
		if(raw_array[i].key[0]==topic_code)
			result_array.push(raw_array[i]);
	}
	return result_array;
}

function filterRegion(raw_array,topic_code)
{
	var result_array=new Array();
	for (var i=0;i<raw_array.length;i++)
	{
		if(raw_array[i].key[1]==topic_code)
			result_array.push(raw_array[i]);
	}
	return result_array;
}

function filterSentiment(raw_array,topic_code)
{
	var result_array=new Array();
	for (var i=0;i<raw_array.length;i++)
	{
		if(raw_array[i].key[2]==topic_code)
			result_array.push(raw_array[i]);
	}
	return result_array;
}

function compactResultArray(raw_array)
{
	var result_array=new Array();
	for (var i=0;i<raw_array.length;i++)
	{
			result_array.push(raw_array[i].value);
	}
	return result_array;
}
