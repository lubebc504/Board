package regist.practice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import regist.practice.domain.TransactionHistory;
import regist.practice.repository.TransactionHistoryRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class ExcelService {
    private final TransactionHistoryRepository transRepo;
    //private Map<String, Integer> coinSellCounts = new HashMap<>();
    public  List<TransactionHistory> transList = new ArrayList<>();
    public  List<TransactionHistory> transList1 = new ArrayList<>();




    public void editExcel(TransactionHistory trans){
        transRepo.edit(trans);

    }

    public List<TransactionHistory> getAllContents() {
        return transRepo.findAll();
    }

    public void GroupByCoinList() {
        List<Object[]> coinData = transRepo.findcoin();

        for (Object[] data : coinData) {
            System.out.println(data[0] + " " + data[1]);
        }
    }
    /*
    public void getTradeCoin(List<TransactionHistory> tranlist)
    {
        tranlist = getAllContents();

        for (int i = 0; i < tranlist.size(); i++) {
            TransactionHistory transaction = tranlist.get(i);

            // Check if the transaction is a sell
            if ("매도".equals(transaction.getState()) || "자동매도".equals(transaction.getState())) {
                System.out.println(transaction.getState());
                // Increment the sell count for the coin
                incrementSellCount(transaction.getCoinName());
            }
        }
    }

    private void incrementSellCount(String coinName) {
        // Get the current count for the coin or initialize to 0 if not present
        int currentCount = coinSellCounts.getOrDefault(coinName, 0);
        System.out.println(coinName+","+currentCount+1);
        // Increment the count
        coinSellCounts.put(coinName, currentCount + 1);
    }

    public Map<String, Integer> getCoinSellCounts() {
        return new HashMap<>(coinSellCounts);
    }

    public void resetCoinSellCounts() {
        coinSellCounts.clear();
    }
*/
    public void groupbycointest()
    {
        GroupByCoinList();

        //System.out.println(getCoinSellCounts());
    }

    public void showList()
    {
        transList = getAllContents();
        for(int i = 0; i < transList.size(); i++)
        {
            System.out.println(transList.get(i).getId());
            System.out.println(transList.get(i).getState());
            System.out.println(transList.get(i).getTradeDate());
            System.out.println(transList.get(i).getPrice());
            System.out.println(transList.get(i).getCoinName());

            System.out.println("========================");

        }

    }
}
