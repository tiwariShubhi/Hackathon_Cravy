package com.example.recipeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipeDetail extends AppCompatActivity {

    ImageView imgRecipe;
    TextView txtName;
    TextView txtCourse;
    TextView txtDuration;
    TextView txtCuisine;
    TextView txtServing;
    TextView txtIng;
    TextView txtSteps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        String [] ing = {"1 cup sabudana",
                "¼ cup peanut",
                "2 potato, boiled & mashed",
                "2 chilli, finely chopped",
                "1 tsp cumin / jeera",
                "1 tsp pepper, crushed",
                "1 inch ginger, grated",
                "2 tbsp coriander, finely chopped",
                "1 tsp lemon juice",
                "1 tsp salt",
                "¼ cup singhare ka atta / chestnut flour",
                "oil, for roasting"};
        String [] steps = {
                "firstly, in a large bowl take 1 cup sabudana and rinse well with running water.",
                "drain off and transfer to a large bowl.",
                "add 1 cup water and dip the sabudana completely in water. soak for 4 hours or until the sabudana turns soft and non-sticky. keep aside.",
                "in a pan dry roast ¼ cup peanut on low to medium lame.",
                "cool completely, and peel the skin of peanuts.",
                "now crush the peanuts coarsely. keep aside.",
                "in a large bowl take soaked sabudana, 2 potato, 2 chilli, 1 tsp cumin, 1 tsp pepper.",
                "also add 1 inch ginger, 2 tbsp coriander, 1 tsp lemon juice and 1 tsp salt.",
                "squeeze and mix well making sure all the spices are well combined.",
                "now add ¼ cup singhare ka atta and knead the dough. you can alternatively use wheat flour or rice flour for binding.",
                "prepare a soft dough. sabudana thalipeeth dough is ready.",
                "firstly, grease the butter paper with oil to prevent from sticking.",
                "take a large ball-sized thalipeeth dough and flatten.",
                "press and flatten making sure it is slightly thick. if it is thin, then there are chances for thalipeeth to break while frying.",
                "now flip over to hot tawa and press gently.",
                "after a minute, peel the butter paper gently.",
                "flip over once the base is cooked.",
                "now add oil and roast both sides until it turns slightly golden.",
                "grease the heavy-bottomed tawa with half tsp oil.",
                "take ball sized dough and tap gently to a thick thickness.",
                "place the tawa on medium flame",
                "cook on both sides adding a tsp of oil until it turns golden brown.",
                "finally, enjoy sabundana thalipeeth with butter and spicy chutney."
        };

        imgRecipe = findViewById(R.id.RecipeImage);
        txtName = findViewById(R.id.RecipeName);
        txtCourse = findViewById(R.id.RecipeCourse);
        txtDuration = findViewById(R.id.RecipeDuration);
        txtCuisine = findViewById(R.id.RecipeCuisine);
        txtServing = findViewById(R.id.RecipeServing);
        txtIng = findViewById(R.id.RecipeIng);
        txtSteps = findViewById(R.id.RecipeSteps);


        imgRecipe.setImageResource(R.drawable.paneer);
        txtName.setText("Sabudana Thalipeeth recipe | upvasache thalipeeth | farali thalipeet");
        txtCourse.setText("Course :\n"+"Breakfast");
        txtCuisine.setText("Cuisine :\n"+"maharashtra");
        txtServing.setText("Serving :\n"+"4 Servings");
        txtDuration.setText("Time :\n"+"4 hours 30 minutes");

//        // building ing string
        StringBuilder list = new StringBuilder();

        for(String in : ing)
        {
            list.append("•");
            list.append(in);
            list.append("\n");
        }
        System.out.println(list.toString());
        txtIng.setText(list.toString());

        //build steps string
        list = new StringBuilder();
        int count = 1;
        for(String step : steps)
        {
            list.append(count++ +". ");
            list.append(step);
            list.append("\n");
        }
        txtSteps.setText(list.toString());

    }


}