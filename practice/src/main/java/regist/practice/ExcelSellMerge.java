package regist.practice;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import regist.practice.domain.TransactionHistory;
import regist.practice.repository.TransactionHistoryRepository;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class ExcelSellMerge {
/*    public TransactionHistory trans;
    private final TransactionHistoryRepository transRepo;

    List<TransactionHistory> transList = new ArrayList<>();
    public static void main(String[] args) {
        EntityManager EM;

    }

    public  List<TransactionHistory> mergeSell(List<TransactionHistory> transls)
    {
        transls = transRepo.findAll();
        List<TransactionHistory> mergedTrades = mergeTrades(transls);

        // 병합된 거래 내역을 저장
        tradeRepository.saveAll(mergedTrades);

        return mergedTrades;
    }


    private static List<TransactionHistory> mergeTrades(List<TransactionHistory> trans) {
        List<TransactionHistory> mergedTrades = new ArrayList<>();
        for (int i = 0; i < trans.size(); i++) {
            TransactionHistory transHistory = trans.get(i);
            //trans = trade, transHistory = currentTrade
            // 현재 거래가 매도이고, 다음 거래가 존재하며, 타임스탬프 차이가 3초 이내라면 합침
            if ("매도".equals(transHistory.getState()) && i < trans.size() - 1) {
                TransactionHistory nextTrade = trans.get(i + 1);
                long timestampDiff = Math.abs(nextTrade.timestamp.getTime() - currentTrade.timestamp.getTime());
                if ("매도".equals(nextTrade.type) && TimeUnit.MILLISECONDS.toSeconds(timestampDiff) <= 3) {
                    // 두 거래 합치기
                    currentTrade.quantity += nextTrade.quantity;
                    currentTrade.price = (currentTrade.price * currentTrade.quantity + nextTrade.price * nextTrade.quantity)
                            / (currentTrade.quantity + nextTrade.quantity);
                    // 다음 거래는 합쳐진 것으로 처리
                    i++;
                }
            }

            mergedTrades.add(currentTrade);
        }
        return mergedTrades;
    }*/
}
