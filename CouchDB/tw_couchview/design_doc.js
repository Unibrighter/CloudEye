{
   "general_count": {
       "map": "function(doc) \n{\n\tif (doc.trump_mentioned)\n\t{\n\t\temit(['Topic_Trump',doc.region_code,doc.sentiment],1);\n\t}\n\n\tif (doc.crime)\n\t{\n\t\temit(['Topic_Crime',doc.region_code,doc.sentiment],1);\n\t}\n\t\n\tif (doc.politic)\n\t{\n\t\temit(['Topic_Politic',doc.region_code,doc.sentiment],1);\n\t}\n\tif (doc.fitness)\n\t{\n\t\temit(['Topic_Fitness',doc.region_code,doc.sentiment],1);\n\t}\t\n\t\n\tif (doc.tv_show)\n\t{\n\t\temit(['Topic_TVShow',doc.region_code,doc.sentiment],1);\n\t}\t\n\tif(doc.immigration)\n\t{\n\t\temit(['Topic_Immigration',doc.region_code,doc.sentiment],1);\n\t}\n\tif (doc.asian_food)\n\t{\n\t\temit(['Topic_Food_Asian',doc.region_code,doc.sentiment],1);\n\t}\n\tif (doc.oz_food)\n\t{\n\t\temit(['Topic_Food_OZ',doc.region_code,doc.sentiment],1);\n\t}\t\n\tif (doc.chinese_food)\n\t{\n\t\temit(['Topic_Food_CHINES',doc.region_code,doc.sentiment],1);\n\t}\n\tif (doc.italian_food)\n\t{\n\t\temit(['Topic_Food_ITALY',doc.region_code,doc.sentiment],1);\n\t}\n\tif (doc.french_food)\n\t{\n\t\temit(['Topic_Food_FRENCH',doc.region_code,doc.sentiment],1);\n\t}\t\n}\t",
       "reduce": "function (key,values)\n{\nreturn sum(values);\n\n}"
   },
   "valid_point_count": {
       "map": "function(doc) \n{\n\tif (doc.trump_mentioned && (doc.latitude!=0.0 ||doc.longitude!=0.0))\n\t{\n\t\temit(['Topic_Trump',doc.region_code,doc.sentiment],{\"latitude\":doc.latitude,\"longitude\":doc.longitude});\n\t}\n\n\tif (doc.crime && (doc.latitude!=0.0 ||doc.longitude!=0.0))\n\t{\n\t\temit(['Topic_Crime',doc.region_code,doc.sentiment],{\"latitude\":doc.latitude,\"longitude\":doc.longitude});\n\t}\n\t\n\tif (doc.politic && (doc.latitude!=0.0 ||doc.longitude!=0.0))\n\t{\n\t\temit(['Topic_Politic',doc.region_code,doc.sentiment],{\"latitude\":doc.latitude,\"longitude\":doc.longitude});\n\t}\n\tif (doc.fitness && (doc.latitude!=0.0 ||doc.longitude!=0.0))\n\t{\n\t\temit(['Topic_Fitness',doc.region_code,doc.sentiment],{\"latitude\":doc.latitude,\"longitude\":doc.longitude});\n\t}\t\n\t\n\tif (doc.tv_show && (doc.latitude!=0.0 ||doc.longitude!=0.0))\n\t{\n\t\temit(['Topic_TVShow',doc.region_code,doc.sentiment],{\"latitude\":doc.latitude,\"longitude\":doc.longitude});\n\t}\t\n\tif(doc.immigration && (doc.latitude!=0.0 ||doc.longitude!=0.0))\n\t{\n\t\temit(['Topic_Immigration',doc.region_code,doc.sentiment],{\"latitude\":doc.latitude,\"longitude\":doc.longitude});\n\t}\n\tif (doc.asian_food && (doc.latitude!=0.0 ||doc.longitude!=0.0))\n\t{\n\t\temit(['Topic_Food_Asian',doc.region_code,doc.sentiment],{\"latitude\":doc.latitude,\"longitude\":doc.longitude});\n\t}\n\tif (doc.oz_food && (doc.latitude!=0.0 ||doc.longitude!=0.0))\n\t{\n\t\temit(['Topic_Food_OZ',doc.region_code,doc.sentiment],{\"latitude\":doc.latitude,\"longitude\":doc.longitude});\n\t}\t\n\tif (doc.chinese_food && (doc.latitude!=0.0 ||doc.longitude!=0.0))\n\t{\n\t\temit(['Topic_Food_CHINES',doc.region_code,doc.sentiment],{\"latitude\":doc.latitude,\"longitude\":doc.longitude});\n\t}\n\tif (doc.italian_food && (doc.latitude!=0.0 ||doc.longitude!=0.0))\n\t{\n\t\temit(['Topic_Food_ITALY',doc.region_code,doc.sentiment],{\"latitude\":doc.latitude,\"longitude\":doc.longitude});\n\t}\n\tif (doc.french_food && (doc.latitude!=0.0 ||doc.longitude!=0.0))\n\t{\n\t\temit(['Topic_Food_FRENCH',doc.region_code,doc.sentiment],{\"latitude\":doc.latitude,\"longitude\":doc.longitude});\n\t}\t\n}",
       "reduce": "function (key,values)\n{\n\treturn values.length\n}"
   },
   "topic_geo_trump": {
       "map": "function(doc) \n{\n\tif (doc.trump_mentioned && (doc.latitude!=0.0 ||doc.longitude!=0.0))\n\t{\n\t\temit(['Topic_Trump',doc.region_code,doc.sentiment],{\"latitude\":doc.latitude,\"longitude\":doc.longitude});\n\t}\n\n}"
   },
   "topic_geo_crime": {
       "map": "function(doc) \n{\n\n\tif (doc.crime && (doc.latitude!=0.0 ||doc.longitude!=0.0))\n\t{\n\t\temit(['Topic_Crime',doc.region_code,doc.sentiment],{\"latitude\":doc.latitude,\"longitude\":doc.longitude});\n\t}\n\t\n\n}"
   },
   "topic_geo_politics": {
       "map": "function(doc) \n{\n\n\tif (doc.politic && (doc.latitude!=0.0 ||doc.longitude!=0.0))\n\t{\n\t\temit(['Topic_Politic',doc.region_code,doc.sentiment],{\"latitude\":doc.latitude,\"longitude\":doc.longitude});\n\t}\n\n}"
   },
   "topic_geo_fitness": {
       "map": "function(doc) \n{\n\n\tif (doc.fitness && (doc.latitude!=0.0 ||doc.longitude!=0.0))\n\t{\n\t\temit(['Topic_Fitness',doc.region_code,doc.sentiment],{\"latitude\":doc.latitude,\"longitude\":doc.longitude});\n\t}\t\n\t\n\n}"
   },
   "topic_geo_tvshow": {
       "map": "function(doc) \n{\n\n\tif (doc.tv_show && (doc.latitude!=0.0 ||doc.longitude!=0.0))\n\t{\n\t\temit(['Topic_TVShow',doc.region_code,doc.sentiment],{\"latitude\":doc.latitude,\"longitude\":doc.longitude});\n\t}\t\n\t\n\n}"
   },
   "topic_geo_immigration": {
       "map": "function(doc) \n{\n\tif(doc.immigration && (doc.latitude!=0.0 ||doc.longitude!=0.0))\n\t{\n\t\temit(['Topic_Immigration',doc.region_code,doc.sentiment],{\"latitude\":doc.latitude,\"longitude\":doc.longitude});\n\t}\n\t\n\n}"
   },
   "topic_geo_food_asian": {
       "map": "function(doc) \n{\n\tif (doc.asian_food && (doc.latitude!=0.0 ||doc.longitude!=0.0))\n\t{\n\t\temit(['Topic_Food_Asian',doc.region_code,doc.sentiment],{\"latitude\":doc.latitude,\"longitude\":doc.longitude});\n\t}\n\t\n\n}"
   },
   "topic_geo_food_oz": {
       "map": "function(doc) \n{\n\tif (doc.oz_food && (doc.latitude!=0.0 ||doc.longitude!=0.0))\n\t{\n\t\temit(['Topic_Food_OZ',doc.region_code,doc.sentiment],{\"latitude\":doc.latitude,\"longitude\":doc.longitude});\n\t}\t\n\t\n\n}"
   },
   "topic_geo_food_chinese": {
       "map": "function(doc) \n{\n\tif (doc.chinese_food && (doc.latitude!=0.0 ||doc.longitude!=0.0))\n\t{\n\t\temit(['Topic_Food_CHINESE',doc.region_code,doc.sentiment],{\"latitude\":doc.latitude,\"longitude\":doc.longitude});\n\t}\n\t\n\n}"
   },
   "topic_geo_food_italy": {
       "map": "function(doc) \n{\n\tif (doc.italian_food && (doc.latitude!=0.0 ||doc.longitude!=0.0))\n\t{\n\t\temit(['Topic_Food_ITALY',doc.region_code,doc.sentiment],{\"latitude\":doc.latitude,\"longitude\":doc.longitude});\n\t}\n\t\n\n}"
   },
   "topic_geo_food_french": {
       "map": "function(doc) \n{\n\tif (doc.french_food && (doc.latitude!=0.0 ||doc.longitude!=0.0))\n\t{\n\t\temit(['Topic_Food_FRENCH',doc.region_code,doc.sentiment],{\"latitude\":doc.latitude,\"longitude\":doc.longitude});\n\t}\t\n\n}"
   }
}
