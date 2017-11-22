package com.example.muhammadafifaf.mainapipanas;

import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Muhammad Afif AF on 21/11/2017.
 */

public class Memanggil extends AsyncTask<String,String,String>{

    private static String readFromStream(InputStream inputStream){
        StringBuilder output = new StringBuilder();
        if(inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = null;
            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            while(line != null) {
                output.append(line);
                try {
                    line = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return output.toString();
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            try {
                cobaLagi();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "a";

    }



    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    private void coba() throws IOException{
        String url = "https://api.mainapi.net/smsnotification/1.0.0/messages";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        con.setRequestProperty("Authorization", "Bearer c96564518e30b1107e6764b65f2ef456");

        String urlParameters = "msisdn=082133210642&content=hello All";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        Log.v("result", String.valueOf(responseCode));

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
    }

    private void cobaLagi() throws IOException, JSONException {
        String url = "https://api.mainapi.net/smsotp/1.0.1/otp/unik";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("PUT");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Bearer c96564518e30b1107e6764b65f2ef456");

        String urlParameters = "{\"phoneNum\":\"082133210642\",\"digit\":3}";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        Log.v("result", String.valueOf(responseCode));

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
    }

    private void cobaLagiVerifikasix(String x) throws IOException{
        String url = "https://api.mainapi.net/smsotp/1.0.1/otp/unik";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Bearer c96564518e30b1107e6764b65f2ef456");


        String urlParameters = "{\"otpstr\":\" + x + \",\"digit\":3}";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        Log.v("result", String.valueOf(responseCode));

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
    }

}