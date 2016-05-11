var collection;

$(document).ready(function(){

	//load data set
	collection = getRawCollectionAsArray();

	//side navigator
	$(".nav").click(function(){
		$(".nav_child").hide();
		$("#left_bottom").children().hide();
		var value = $(this).text();
		
		if(value =="Crime")
		{
			$("#income_legend").show();
			$("#crime_child").show();

		}else if(value == "Politics")
		{
			$("#legend_pos_neg").show();
		}else if(value == "Fitness")
		{
			$("#fitness_child").show();

		}else if(value == "TV Show")
		{


		}else if(value == "Food")
		{
			$("#food_legend").show();
		}else if(value == "Immigration")
		{
			$("#immigration_child").show();
			$("#indian_legend").show();
		}else if(value == "Home")
		{
			$("#groupInfo").show();
		}
	});

	//legand
	$(".nav_child").children("a").click(function(){
		$("#left_bottom").children().hide();
		var value_sub = $(this).text();
		if(value_sub =="Indian")
		{
			$("#indian_legend").show();
		}else if(value_sub =="Chinese")
		{
			$("#chinese_legend").show();
		}else if(value_sub =="Italian")
		{
			$("#italian_legend").show();
		}else if(value_sub =="Vietnam")
		{
			$("#vietnam_legend").show();
		}
	});


})

function linkClick(n)
{
	var urls=["income.html","politics.html","green_inner.html","tv.html","food.html","Immigration.html","trump.html","aus.html"];
	var frame=document.getElementById("frame");
	frame.src=urls[n];
}

function getCountry(n)
{
	var urls=["Indian.html","China.html","Italian.html","Vietnam.html"];
	var frame=document.getElementById("frame");
	frame.src=urls[n];
}