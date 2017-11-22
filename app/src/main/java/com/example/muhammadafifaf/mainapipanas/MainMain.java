package com.example.muhammadafifaf.mainapipanas;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Muhammad Afif AF on 22/11/2017.
 */

public class MainMain extends AsyncTask<String,String,String> {

    @Override
    protected String doInBackground(String... strings) {
        try {
            cobaLagiVerifikasi(strings[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void cobaLagiVerifikasi(String x) throws IOException {
        String url = "https://api.mainapi.net/smsotp/1.0.1/otp/unik/verifications";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Bearer c96564518e30b1107e6764b65f2ef456");

        String urlParameters = "{\"otpstr\":\"";
        urlParameters = urlParameters + x + "\"";
        urlParameters = urlParameters + ",\"digit\":3}";
        Log.v("Mantab Jiwaw",urlParameters);

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        if(responseCode == 200) {
            Log.v("Final Result","OTP benar");
        }
        else {
            Log.v("Final Result","OTP salah");
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        in.close();

        //print result

        //print result
    }
}
