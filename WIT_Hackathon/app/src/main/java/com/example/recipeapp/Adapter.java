package com.example.recipeapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


    private List<DataClass> dc ;

    public Adapter(List<DataClass> dc)
    {
        this.dc = dc;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
            int res = dc.get(position).getRecipeImage();
            String name = dc.get(position).getRecipeName();
            String course = dc.get(position).getRecipeCourse();
            String duration = dc.get(position).getRecipeDuration();

            holder.setData(res,name,course,duration);


    }

    @Override
    public int getItemCount() {
        return dc.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView recipeImage;
        private TextView recipeName;
        private TextView recipeCourse;
        private TextView recipeDuration;
        public ViewHolder( View itemView) {
            super(itemView);
            recipeImage = itemView.findViewById(R.id.RecipeImage);
            recipeName = itemView.findViewById(R.id.RecipeName);
            recipeCourse = itemView.findViewById(R.id.RecipeCourse);
            recipeDuration = itemView.findViewById(R.id.RecipeDuration);

            Context context = itemView.getContext();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int itemPosition = getLayoutPosition();
                    //Toast.makeText(context, "" + itemPosition, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context,RecipeDetail.class);
                    //intent.putExtra("",);

                    context.startActivity(intent);

                }
            });
        }


        public void setData(int res, String name, String course, String duration) {
            recipeImage.setImageResource(res);
            recipeName.setText(name);
            recipeCourse.setText(course);
            recipeDuration.setText(duration);
        }
    }
}
