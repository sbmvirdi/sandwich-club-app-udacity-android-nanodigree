package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {


            JSONObject base = new JSONObject(json);


            JSONObject name = base.getJSONObject("name");
            JSONArray altNames = name.getJSONArray("alsoKnownAs");
            JSONArray ingredients = base.getJSONArray("ingredients");


            ArrayList<String> altNamesList = new ArrayList<>();

            for(int i=0; i<altNames.length(); i++) {
                altNamesList.add(altNames.getString(i));
            }


            ArrayList<String> ingredientsList = new ArrayList<>();

            for(int i=0; i<ingredients.length(); i++) {
                ingredientsList.add(ingredients.getString(i));
            }


            String mainName = name.getString("mainName");
            String placeOfOrigin = base.getString("placeOfOrigin");
            String description = base.getString("description");
            String image = base.getString("image");


            return new Sandwich(mainName, altNamesList, placeOfOrigin, description, image, ingredientsList);

        } catch (JSONException e) {

            e.printStackTrace();
        }
        return null;
    }
}
