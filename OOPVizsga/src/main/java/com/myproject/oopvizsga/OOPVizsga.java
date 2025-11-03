/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.myproject.oopvizsga;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import org.json.JSONObject;
import org.json.JSONArray;

/**
 *
 * @author istsz
 */
public class OOPVizsga {

    public static void main(String[] args) {

        try {
            FileReader reader = new FileReader("data.json");
            String jsonText = "";
            int counter;
            while ((counter = reader.read()) != -1) {
                jsonText += (char) counter;
            }
            reader.close();

            JSONArray orders = new JSONObject(jsonText).getJSONArray("orders");
            for (int i = 0; i < orders.length(); i++) {
                System.out.println(orders.getJSONObject(i).getString("orderId") + " | "
                        + orders.getJSONObject(i).getString("status"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
