package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static final String NAME = "name";
    private static final String MAIN_NAME = "mainName";
    private static final String ALSO_KNOWN_AS = "alsoKnownAs";
    private static final String PLACE_OF_ORIGIN = "placeOfOrigin";
    private static final String DESCRIPTION = "description";
    private static final String IMAGE = "image";
    private static final String INGREDIENTS = "ingredients";

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject sandwitch = new JSONObject(json);
            JSONObject name = sandwitch.getJSONObject(NAME);
            return new Sandwich(
                    name.getString(MAIN_NAME),
                    convertStringJSONArray(name.getJSONArray(ALSO_KNOWN_AS)),
                    sandwitch.getString(PLACE_OF_ORIGIN),
                    sandwitch.getString(DESCRIPTION),
                    sandwitch.getString(IMAGE),
                    convertStringJSONArray(sandwitch.getJSONArray(INGREDIENTS))
            );
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static List<String> convertStringJSONArray(JSONArray jsonArray) throws JSONException {
        List<String> stringList = new ArrayList<String>();
        for(int i=0; i < jsonArray.length(); i++){
            stringList.add(jsonArray.getString(i));
        }
        return stringList;
    }
}