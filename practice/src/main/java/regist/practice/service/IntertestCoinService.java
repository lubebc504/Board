package regist.practice.service;

import jakarta.persistence.EntityManager;

import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import regist.practice.Api_Client;
import regist.practice.domain.Interest;
import regist.practice.repository.InterestRepository;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class IntertestCoinService {
    private final InterestRepository interestRepo;
     static Api_Client apiClient = new Api_Client("2e969fdde4db75b5abbe099890df4062", "a766900351ec8401599b157fd916a971");


    public void registerInterest(String coinName,String userName) throws JSONException {


        // 관심 코인 등록
        Interest interest = new Interest();
        interest.setCoinName(coinName);
        // 사용자 정보 등록
        interest.setUserName(userName);
        interestRepo.save(interest);
    }
    public void ShowInterest()
    {
        List<Interest> IntercoinData = interestRepo.findAll();
        for(int i = 0; i < IntercoinData.size();i++)
        {
            String url = "/public/ticker/";
            url = url + IntercoinData.get(i).getCoinName() + "_KRW";
            HashMap<String, String> rgParams = new HashMap<String, String>();
            rgParams.put("order_currency", IntercoinData.get(i).getCoinName());
            rgParams.put("payment_currency", "KRW");
            try {
                String result1 = apiClient.callApi(url,rgParams);
                String result = apiClient.callApi("/info/balance", rgParams);
                System.out.println(result1);
                System.out.println(result);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public void DeleteInterest(int coinid)
    {
        Interest interest = interestRepo.findById(coinid);
        interestRepo.delete(coinid);
    }

    public static void main(String[] args) throws JSONException, IOException {
        HashMap<String, String> rgParams = new HashMap<String, String>();
        rgParams.put("order_currency", "BTC");
        rgParams.put("payment_currency", "KRW");


        try {
            String result1 = apiClient.callApi("/public/ticker/BTC_KRW",rgParams);
            String result = apiClient.callApi("/info/balance", rgParams);
            System.out.println(result);
            System.out.println(result1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
