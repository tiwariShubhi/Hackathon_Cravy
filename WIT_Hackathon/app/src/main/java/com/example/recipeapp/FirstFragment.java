package com.example.recipeapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.DynamicDrawableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.recipeapp.databinding.FragmentFirstBinding;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private final String[] dairy_1=new String[]{
            "Cheese","Milk","Paneer","Ghee","Butter","Yoghurt","Butter Milk"
    };
    private String[] Ing=new String[10];
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    Button bt_dis;
    TextView tv;
    FlexboxLayout chip_veg,chip_cer,chip_pul,chip_dai;
    AutoCompleteTextView atv_veg;
    AutoCompleteTextView atv_cer;
    AutoCompleteTextView atv_pul;
    AutoCompleteTextView atv_dai;
    ArrayAdapter<String> adapter_veg,adapter_cer,adapter_pul,adapter_dai;
    ArrayList<String> selected_ingredients = new ArrayList<>();
    ArrayList<String> veggies;
    ArrayList<String > pulses;
    ArrayList<String> cereals;
    ArrayList<String> dairy;
//    ArrayLis
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getData();
         atv_veg=view.findViewById(R.id.atv_veggies);
        atv_cer=view.findViewById(R.id.atv_cereals);
         atv_pul=view.findViewById(R.id.atv_pulses);
        atv_dai=view.findViewById(R.id.atv_dairy);
        bt_dis=view.findViewById(R.id.bt_submit);
        tv=view.findViewById(R.id.tv_display);
//        adapter_veg=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,veggies);
//        adapter_pul=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,pulses);
//        adapter_dai=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,dairy);
//        adapter_cer=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,cereals);
        chip_veg=view.findViewById(R.id.chip_group_veg);
        chip_cer=view.findViewById(R.id.chip_group_cer);
        chip_pul=view.findViewById(R.id.chip_group_pul);
        chip_dai=view.findViewById(R.id.chip_group_dai);
       //tv.setText(Ing[1]);

        atv_veg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                addChipToGroup(adapter_veg.getItem(position).toString(),chip_veg);
                atv_veg.setText("");
                selected_ingredients.add(adapter_veg.getItem(position).toString());
            }
        });
        atv_pul.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                addChipToGroup(adapter_pul.getItem(position).toString(),chip_pul);
                atv_pul.setText("");
                selected_ingredients.add(adapter_pul.getItem(position).toString());
            }
        });
        atv_cer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                addChipToGroup(adapter_cer.getItem(position).toString(),chip_cer);
                atv_cer.setText("");
                selected_ingredients.add(adapter_cer.getItem(position).toString());
            }
        });
        atv_dai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                addChipToGroup(adapter_dai.getItem(position).toString(),chip_dai);
                atv_dai.setText("");
                selected_ingredients.add(adapter_dai.getItem(position).toString());
            }
        });
        bt_dis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               //bt_dis.setText("hello");
                String temp=atv_veg.getText().toString()+atv_cer.getText().toString()+atv_pul.getText().toString()+atv_dai.getText().toString();
               tv.setText(temp);
                moveToNewActivity();
                //getData();
                String listString = "";

                for (String s : selected_ingredients)
                {
                    listString += s + ",";
                }


               sendData(listString);
            }
        });
        /*binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });*/
    }
    private void moveToNewActivity () {
        Intent i = new Intent(getActivity(), SearchResult.class);
        startActivity(i);
        ((Activity) getActivity()).overridePendingTransition(0, 0);
    }
    private void addChipToGroup(String person, FlexboxLayout chip_layout) {
        Chip chip=new Chip(getActivity());
        chip.setText(person);
        chip.isCloseIconVisible();
        chip.isChipIconVisible();
        chip.setCloseIconVisible(true);
        //chip.setCloseIconEnabled();
//        chip.isChipIconVisible = false
//        chip.isCloseIconVisible = true
        // necessary to get single selection working
        chip.isClickable();
        chip.isCheckable();
        //chip.isClickable = true
        // chip.isCheckable = false
        chip_layout.addView(chip);
        chip.setOnCloseIconClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chip_layout.removeView(chip);
                selected_ingredients.remove(chip.getText());
                tv.setText(chip.getText());
            }
        });
    }
    private void getData() {
        String url = "http://100.101.7.147:5000/getIngredients";

        RequestQueue requstQueue = Volley.newRequestQueue(getActivity());

        // Request a string response from the provided URL.
//        JsonObjectRequest jsonobj = new JsonObjectRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONObject>(), {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        tv.setText(response);
//                        Ing=response.split(",");
//                        tv.setText(Ing[0]);
////                        adapter_veg=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,Veggies);
//                        atv_veg.setAdapter(adapter_veg);
//                        // Display the first 500 characters of the response string.
//
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                tv.setText(error.toString());
//            }
//        });
//        stringRequest.setRetryPolicy(new RetryPolicy() {
//            @Override
//            public int getCurrentTimeout() {
//                return 50000;
//            }
//
//            @Override
//            public int getCurrentRetryCount() {
//                return 50000;
//            }
//
//            @Override
//            public void retry(VolleyError error) throws VolleyError {
//
//            }
//        });
//
//// Add the request to the RequestQueue.
//        requstQueue.add(stringRequest);
        JsonObjectRequest jsonobj = new JsonObjectRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //tv.setText(response.toString());
                        try {


                            JSONArray jsonArray_cer = response.getJSONArray("cereals");
                            cereals=new ArrayList<String>();
                            for (int i = 0; i < jsonArray_cer.length(); i++) {
                                cereals.add(jsonArray_cer.get(i).toString());
                            }

                            JSONArray jsonArray_veg = response.getJSONArray("vegetables");
                            veggies=new ArrayList<String>();
                            for (int i = 0; i < jsonArray_veg.length(); i++) {
                                veggies.add(jsonArray_veg.get(i).toString());
                            }

                            JSONArray jsonArray_pul = response.getJSONArray("pulses");
                            pulses=new ArrayList<String>();
                            for (int i = 0; i < jsonArray_pul.length(); i++) {
                                pulses.add(jsonArray_pul.get(i).toString());
                            }

                            JSONArray jsonArray_dai = response.getJSONArray("dairy");
                            dairy=new ArrayList<String>();
                            //tv.setText(dairy.size());
                            for (int i = 0; i < jsonArray_dai.length(); i++) {

                                dairy.add(jsonArray_dai.get(i).toString());
                            }
                            adapter_veg=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,veggies);
                            adapter_pul=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,pulses);
                            adapter_dai=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,dairy_1);
                            adapter_cer=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,cereals);
                            atv_cer.setAdapter(adapter_cer);
                            atv_pul.setAdapter(adapter_pul);
                            atv_dai.setAdapter(adapter_dai);
                            atv_veg.setAdapter(adapter_veg);
                            tv.setText("Succeess");


                            //
//
//
//                            tv.setText(temp.get(0));
//                            Toast.makeText(getActivity(), temp.get(0),
//                                    Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


//                        tv.setText(response);
//                        Ing=response.split(",");
//                        tv.setText(Ing[0]);
////                        adapter_veg=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,Veggies);
//                        atv_veg.setAdapter(adapter_veg);
                        // Display the first 500 characters of the response string.

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        tv.setText(error.toString());
                    }
                }
        ){
            //here I want to post data to sever
        };
        jsonobj.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });
        requstQueue.add(jsonobj);
    }
        //chip.setOnCloseIconClickListener { chip_group.removeView(chip as View) }}

    private void sendData(String temp) {
        String url = "http://100.101.7.147:5000/api/post";

        Map<String, String> MyData = new HashMap<String, String>();
        MyData.put("ingredients", temp); //Add the data you'd like to send to the server
        RequestQueue requstQueue = Volley.newRequestQueue(getActivity());

        JsonObjectRequest jsonobj = new JsonObjectRequest(Request.Method.POST, url,new JSONObject(MyData),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        tv.setText(response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                       tv.setText(error.toString());
                    }
                }
        ){
            //here I want to post data to sever
        };
        jsonobj.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });
        requstQueue.add(jsonobj);
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}