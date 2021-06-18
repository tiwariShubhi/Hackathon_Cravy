package com.example.recipeapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AllRecipe#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AllRecipe extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AllRecipe() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AllRecipe.
     */
    // TODO: Rename and change types and number of parameters
    public static AllRecipe newInstance(String param1, String param2) {
        AllRecipe fragment = new AllRecipe();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_recipe, container, false);
        CardView card_view1 = (CardView) view.findViewById(R.id.cardView00); // creating a CardView and assigning a value.
        CardView card_view2 = (CardView) view.findViewById(R.id.cardView01);
        CardView card_view3 = (CardView) view.findViewById(R.id.cardView10);
        CardView card_view4 = (CardView) view.findViewById(R.id.cardView11);
        CardView card_view5 = (CardView) view.findViewById(R.id.cardView20);
        CardView card_view6 = (CardView) view.findViewById(R.id.cardView21);
        CardView card_view7 = (CardView) view.findViewById(R.id.cardView30);
        CardView card_view8 = (CardView) view.findViewById(R.id.cardView31);
        CardView card_view9 = (CardView) view.findViewById(R.id.cardView40);
        CardView card_view10 = (CardView) view.findViewById(R.id.cardView41);
        CardView card_view11 = (CardView) view.findViewById(R.id.cardView50);
        CardView card_view12 = (CardView) view.findViewById(R.id.cardView51);

        card_view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = card_view1.getContext();
                // do whatever you want to do on click (to launch any fragment or activity you need to put intent here.)
                Intent intent = new Intent(context,RecipeDetail.class);
                //intent.putExtra("",);

                context.startActivity(intent);
            }
        });

        card_view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = card_view2.getContext();
                // do whatever you want to do on click (to launch any fragment or activity you need to put intent here.)
                Intent intent = new Intent(context,RecipeDetail.class);
                //intent.putExtra("",);

                context.startActivity(intent);
            }
        });

        card_view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = card_view3.getContext();
                // do whatever you want to do on click (to launch any fragment or activity you need to put intent here.)
                Intent intent = new Intent(context,RecipeDetail.class);
                //intent.putExtra("",);

                context.startActivity(intent);
            }
        });

        card_view4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = card_view4.getContext();
                // do whatever you want to do on click (to launch any fragment or activity you need to put intent here.)
                Intent intent = new Intent(context,RecipeDetail.class);
                //intent.putExtra("",);

                context.startActivity(intent);
            }
        });

        card_view5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = card_view5.getContext();
                // do whatever you want to do on click (to launch any fragment or activity you need to put intent here.)
                Intent intent = new Intent(context,RecipeDetail.class);
                //intent.putExtra("",);

                context.startActivity(intent);
            }
        });

        card_view6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = card_view6.getContext();
                // do whatever you want to do on click (to launch any fragment or activity you need to put intent here.)
                Intent intent = new Intent(context,RecipeDetail.class);
                //intent.putExtra("",);

                context.startActivity(intent);
            }
        });

        card_view7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = card_view7.getContext();
                // do whatever you want to do on click (to launch any fragment or activity you need to put intent here.)
                Intent intent = new Intent(context,RecipeDetail.class);
                //intent.putExtra("",);

                context.startActivity(intent);
            }
        });

        card_view8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = card_view8.getContext();
                // do whatever you want to do on click (to launch any fragment or activity you need to put intent here.)
                Intent intent = new Intent(context,RecipeDetail.class);
                //intent.putExtra("",);

                context.startActivity(intent);
            }
        });

        card_view9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = card_view9.getContext();
                // do whatever you want to do on click (to launch any fragment or activity you need to put intent here.)
                Intent intent = new Intent(context,RecipeDetail.class);
                //intent.putExtra("",);

                context.startActivity(intent);
            }
        });

        card_view10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = card_view10.getContext();
                // do whatever you want to do on click (to launch any fragment or activity you need to put intent here.)
                Intent intent = new Intent(context,RecipeDetail.class);
                //intent.putExtra("",);

                context.startActivity(intent);
            }
        });

        card_view11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = card_view11.getContext();
                // do whatever you want to do on click (to launch any fragment or activity you need to put intent here.)
                Intent intent = new Intent(context,RecipeDetail.class);
                //intent.putExtra("",);

                context.startActivity(intent);
            }
        });

        card_view12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = card_view12.getContext();
                // do whatever you want to do on click (to launch any fragment or activity you need to put intent here.)
                Intent intent = new Intent(context,RecipeDetail.class);
                //intent.putExtra("",);

                context.startActivity(intent);
            }
        });
        return view;

    }


    @Override
    public void onClick(View v) {

    }
}