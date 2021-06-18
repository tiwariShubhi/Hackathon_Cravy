# Hackathon_Cravy

## Short Description

## Problem Statement
We all love food. We spend significant amount of time either thinking about it or eating it.
Food not only satisfies our hunger, but our emotions as well.
But sadly , food waste and cooking with limited resource has been a persistent problem .
Specially, last year when the pandemic hit,  all of us were locked up in their homes. There was acute food shortage in markets.
We all had limited cooking resources at home. Ordering pre-cooked food was also a risk.
Moreover even when we order food from outside we end up eating unhealthy food mostly.

## The idea
So we present a simple and easy to use solution. Cravy. 
Cravy is an easy solution when you are craving from some delicious and healthy food.

It is an android app that can be used to find what to cook with the limited resources at hand.
It's one of a kind search feature allows you to search various types of ingredients like Vegetables, Cereals, Dairy and suggest you recipes that can be easily made using these ingredients.
Each recipe is detailed with the list of ingredients, and steps to follow. 
If you are still unsure you can browse from our list of popular recipes.
For all your food cravings you have cravy. 

## Demo Video
https://youtu.be/A0609XR2JDc


## The Architecture

![image](https://user-images.githubusercontent.com/31347794/122578142-3a202880-d071-11eb-8052-21bc0780e31b.png)


When a user searches for recipes by selecting various ingredients ,
1. The Android UI sends this ingredient list to the Android backend.
2. Next the Android backend communicates to a Flask backend via REST Calls. It sends the user query as a JSON object.
3. The Flask backend then communicates to the IBM Cloudant Database via python Cloudant API  
4. Cloudant communicates back sending the required search results containing recipe details like stesp, duration cuisine etc. for the search query. 
5. The Flask backend then parses the query, filters useful results and selects the best recipe matches for the user query based on a scoring algorithm.
6. Then recipe results are sent to the Android front end UI where user can see the recipes and follow them.


## Supported Features
1. Searching recipes based on ingredients from various categories : 
    - Veggies
    - Cereals
    - Dairy
    - Pulses
 2. View popular recipes
![Popular_recepies](https://user-images.githubusercontent.com/31347794/122600712-d35d3800-d08d-11eb-9c0b-d3315cc5a800.png)
 3. Read recipe details like :
    - Recipe Name
    - Total cook time
    - Servings
    - Cuisine
    - Course 


## Future work

1. Sorting and filtering on the basis of cook time, cuisine etc.
2. Integrate voice and image based search for ingredients
3. Show nutritional information for each recipe like Calorie count
4. Favourites option - user can put his liked recipes in a favourite list




## Meet the team






