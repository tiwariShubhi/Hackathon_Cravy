
import json
from flask import Flask, request, jsonify
import ParserEngine
app=Flask(__name__)
app.config["DEBUG"]=True

@app.route('/getIngredients',methods=["GET"])
def home():
	result = ParserEngine.find_ingredients_wrapper();
	dairy = ["cheese","milk,""ice cream","butter","yogurt","sherbet","curd","butter milk","buttermilk","khoa","ghee","custard"]
	veg = ["pumpkin","asparagus","avocado","bean","beetroot","pumpkin","orange","cabbage","capsicum","carrot","cauliflower","celeriac","celery","chickpea","broccoli","cabbage","citrus","sweet corn","cucumber","lettuce","baby corn","mushroom","corn","onion","peas","potato","pumpkin","radish","ratatouille","salsa","sesame", "sprouts","spinach","squash","swede","sweet potato","kumera,""tabbouleh","thai beef salad","thai noodle salad","tomato","tuna and avocado salad","turnip"]
	cer = ["wheat","dalia","atta","maida","flour","maida","suji","noodles","vermicelli","pasta","barley","poha","chidwa","cassava","kuttu","oats","bajra","kutki","makai","rice","puffed rice","sabudana"]
	pul = ["lobia","black eyed Beans","masoor dal","urad dal","toor dal","chori dal","chana dal","rajma","chilkewali","idli rava"]
	dai = set(dairy).intersection(set(result["ingredients"]))
	ing = {}
	ing["dairy"] = list(dai)
	ing["vegetables"] = list(set(veg).intersection(set(result["ingredients"])))
	ing["cereals"] = list(set(cer).intersection(set(result["ingredients"])))
	ing["pulses"] = list(set(pul).intersection(set(result["ingredients"])))
	return ing
	#return ','.join(result["ingredients"])
	#r#eturn "<h1> Hackathon WIT/h1>"

@app.route('/getAllRecipes',methods=["GET"])
def home1():
	result = ParserEngine.get_recipes_wrapper();
	recipe = {}
	p=0
	for r in result:
	    recipe[p]=r["doc"]
	    p+=1
	return recipe

@app.route('/api/post', methods=['POST'])
def update_record():
    request_data = request.get_json()

    value = request_data['ingredients']
    
    print("hello world")
    print(request_data['ingredients'])
    #value = value[:-1]
    value = value.replace(" ","");
    ingredients_list = value.split(",");
    result = ParserEngine.search_wrapper(ingredients_list);
    #print(result)
    recipe = {}
    p=0
    for r in result:
    	recipe[p]=r["doc"]
    	p+=1

    return recipe

app.run(host="0.0.0.0", port="5000")