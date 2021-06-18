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

## The Architecture

![image](https://user-images.githubusercontent.com/31347794/122577491-7acb7200-d070-11eb-9ada-def0963c0c86.png)


The Android app communicates to a Flask backend via REST Calls.
The Flask backend communicates to the IBM Cloudant Database and fetches recipe details based on user search query. 
The Flask backend then parses the query, filters useful results and selects the best recipe matches for the user query based on a scoring algorithm.
Then recipe results are sent to the Android front end UI where user can see all recipe results.

## Meet the team






