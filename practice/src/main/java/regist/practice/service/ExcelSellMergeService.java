package regist.practice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import regist.practice.domain.TransactionHistory;
import regist.practice.repository.TransactionHistoryRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class ExcelSellMergeService {
    private final TransactionHistoryRepository transRepo;
    private Map<String, Integer> coinSellCounts = new HashMap<>();
    public  List<TransactionHistory> transList = new ArrayList<>();
    public  List<TransactionHistory> transList1 = new ArrayList<>();



/*
    public void mergeAndSave(List<TransactionHistory> transactions) {
        List<TransactionHistory> mergedTrades = mergeTrades(transactions);
        for(TransactionHistory history : mergedTrades)
        {
            editExcel(history);
        }
    }

    public List<TransactionHistory> mergeTrades(List<TransactionHistory> trans) {
        for (int i = 0; i < trans.size(); i++) {
            TransactionHistory currentTrade = trans.get(i);
            TransactionHistory nextTrade = trans.get(i + 1);
            // 현재 거래가 매도이고, 다음 거래가 존재하며, 타임스탬프 차이가 3초 이내라면 합침
            if ("매도".equals(currentTrade.getState()) && i + 1 < trans.size()) {


                LocalDateTime currentDateTime = parseDateTime(currentTrade.getTradeDate());
                LocalDateTime nextDateTime = parseDateTime(nextTrade.getTradeDate());

                if (nextDateTime.minusSeconds(3).isBefore(currentDateTime)) {
                    // 매도 거래를 병합
                    TransactionHistory mergedTrade = mergeSellTrades(currentTrade, nextTrade);
                    // 기존 리스트에 변경
                    //trans.add(mergedTrade);
                    trans.set(i,mergedTrade);
                    trans.remove(i+1);

                    // 현재 처리된 매도 거래는 건너뜀
                    i++;
                    continue;
                }
            }
        }
        return trans;
    }

    public TransactionHistory mergeSellTrades(TransactionHistory first, TransactionHistory second) {
        // 매도 거래를 병합
        TransactionHistory mergedTrade = new TransactionHistory();
        mergedTrade.setTradeDate(first.getTradeDate());
        mergedTrade.setUser(first.getUser());
        mergedTrade.setCoinName(first.getCoinName());
        mergedTrade.setAmount(String.valueOf(Double.parseDouble(first.getAmount()) + Double.parseDouble(second.getAmount())));
        mergedTrade.setState(first.getState());
        mergedTrade.setPrice(second.getPrice() + first.getPrice()); // gkqcls 가격으로 설정
        mergedTrade.setFee(first.getFee()+second.getFee()); // 합친 수수료로 설정
        mergedTrade.setAfterTrade(second.getAfterTrade()); // 두 번째 거래의 거래 후 자산으로 설정
        return mergedTrade;
    }

    public LocalDateTime parseDateTime(String dateTimeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(dateTimeString, formatter);
    }

    public void editExcel(TransactionHistory trans){
        transRepo.edit(trans);

    }
*/
    public List<TransactionHistory> getAllContents() {
        return transRepo.findAll();
    }

    public void getCoinListtest1() {
        List<Object[]> coinData = transRepo.findcoin();

        for (Object[] data : coinData) {
            String coinName = (String) data[0];
            Long transactionCount = (Long) data[1];
            System.out.println(data[0] + " " + data[1]);
        }
    }
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

    public void test()
    {
        getCoinListtest1();

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
