package com.company;

import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        File myFile = new File("Dummy_data.json");
        String readData = "";
        try {
            Scanner input = new Scanner(myFile);
            while (input.hasNextLine()) {
                readData += input.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = new JSONObject(readData);
        System.out.println(" Choose the Section you like!");
        String[] cat = new String[jsonObject.getJSONArray("Sections").length()];
        for (int i = 0; i < jsonObject.getJSONArray("Sections").length(); i++) {
            cat[i] += jsonObject.getJSONArray("Sections").getJSONObject(i).getString("title");
        }
        for (int i = 0; i < cat.length; i++) {
            System.out.print(cat[i] + " #code(s" + (i + 1) + ")  -  ");
        }
        System.out.println();
        System.out.print("Enter the code here : ");
        String IdOfSection;
        IdOfSection = in.nextLine();
        ArrayList<String> categoriesM = new ArrayList<>();
        String[] newCategories = new String[10];
        int sum = 0;
        for (int j = 0; j < jsonObject.getJSONObject("Meals").length(); j++) {
            for (int i = 0; i < jsonObject.getJSONObject("Meals").getJSONObject("Meal_" + (j + 1)).getJSONArray("categories").length(); i++) {
                categoriesM.add(jsonObject.getJSONObject("Meals").getJSONObject("Meal_" + (j + 1)).getJSONArray("categories").getString(i));
            }
            if (categoriesM.contains(IdOfSection)) {
                newCategories[sum] = jsonObject.getJSONObject("Meals").getJSONObject("Meal_" + (j + 1)).getString("id");
                sum++;
            }
            for (int i = 0; i < jsonObject.getJSONObject("Meals").getJSONObject("Meal_" + (j + 1)).getJSONArray("categories").length(); i++) {
                categoriesM.remove(jsonObject.getJSONObject("Meals").getJSONObject("Meal_" + (j + 1)).getJSONArray("categories").getString(i));
            }

        }

        for (int index = 0; index < jsonObject.getJSONObject("Meals").length(); index++) {


            for (int j = 0; j < jsonObject.getJSONObject("Meals").length(); j++) {
                if (newCategories[index] == jsonObject.getJSONObject("Meals").getJSONObject("Meal_" + (j + 1)).getString("id")) {
                    System.out.println("Title : " + jsonObject.getJSONObject("Meals").getJSONObject("Meal_" + (j + 1)).getString("title"));
                    System.out.println();
                    System.out.println("          > Ingredients <  ");
                    System.out.println();
                    String[] ingredientsM = new String[jsonObject.getJSONObject("Meals").getJSONObject("Meal_" + (j + 1)).getJSONArray("ingredients").length()];
                    Meals MyIngredients = new Meals(jsonObject.getJSONObject("Meals").getJSONObject("Meal_" + (j + 1)).getString("id"), jsonObject.getJSONObject("Meals").getJSONObject("Meal_" + (j + 1)).getString("title"), ingredientsM);

                    for (int i = 0; i < jsonObject.getJSONObject("Meals").getJSONObject("Meal_" + (j + 1)).getJSONArray("ingredients").length(); i++) {
                        ingredientsM[i] += jsonObject.getJSONObject("Meals").getJSONObject("Meal_" + (j + 1)).getJSONArray("ingredients").getString(i);
                    }
                    for (int i = 0; i < ingredientsM.length; i++) {
                        System.out.println(ingredientsM[i] + " ");
                    }
                    System.out.println();
                    System.out.println("          > Steps <  ");
                    System.out.println();
                    String[] stepsM = new String[jsonObject.getJSONObject("Meals").getJSONObject("Meal_" + (j + 1)).getJSONArray("steps").length()];
                    Meals MySteps = new Meals(jsonObject.getJSONObject("Meals").getJSONObject("Meal_" + (j + 1)).getString("id"), jsonObject.getJSONObject("Meals").getJSONObject("Meal_" + (j + 1)).getString("title"), ingredientsM);
                    for (int i = 0; i < jsonObject.getJSONObject("Meals").getJSONObject("Meal_" + (j + 1)).getJSONArray("steps").length(); i++) {
                        stepsM[i] += jsonObject.getJSONObject("Meals").getJSONObject("Meal_" + (j + 1)).getJSONArray("steps").getString(i);
                    }
                    for (int i = 0; i < stepsM.length; i++) {
                        System.out.println(stepsM[i] + " ");
                    }

                }
            }

        }
    }
}
