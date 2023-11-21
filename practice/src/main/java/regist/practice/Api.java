package regist.practice;

import com.fasterxml.jackson.databind.util.JSONPObject;
import jakarta.persistence.EntityManager;
import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.IOException;

public class Api {
    public static void main(String[] args) throws IOException, JSONException {


        PrivateApi();
    }

    public static void PublicApi() throws IOException, JSONException {
        EntityManager EM;
        OkHttpClient client =new OkHttpClient();
        Request requset = new Request.Builder()
                .url("https://api.bithumb.com/public/ticker/BTC_KRW")
                .get()
                .addHeader("accept","application.json")
                .build();
        Response response = client.newCall(requset).execute();
        ResponseBody body=response.body();

        JSONObject json = new JSONObject(body.string());
        System.out.println("hi"+json.getString("data"));
        String temp=json.getString("data");
        JSONObject json2 = new JSONObject(temp);
        System.out.println("hi"+json2.getString("opening_price"));
    }

    public static void PrivateApi() throws IOException {
        OkHttpClient client1 = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body1 = RequestBody.create(mediaType, "order_currency=string&payment_currency=string");
        Request request = new Request.Builder()
                .url("https://api.bithumb.com/info/account")
                .post(body1)
                .addHeader("accept", "application/json")
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .addHeader("Api-Key", "2e969fdde4db75b5abbe099890df4062")
                .addHeader("Api-Nonce", "System.currentTimeMillis()")
                .addHeader("Api-Sign", "상세 가이드 참고")
                .build();

        Response response1 = client1.newCall(request).execute();
    }
}

