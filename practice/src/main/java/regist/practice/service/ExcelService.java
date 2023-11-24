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

    public  List<TransactionHistory> transList = new ArrayList<>();
    public  List<TransactionHistory> transList1 = new ArrayList<>();




    public void editExcel(TransactionHistory trans){
        transRepo.edit(trans);

    }

    public List<TransactionHistory> getAllContents() {
        return transRepo.findAll();
    }

    public void getCoinListtest1() {
        List<Object[]> coinData = transRepo.findcoin();

        for (Object[] data : coinData) {
            System.out.println(data[0] + " " + data[1]);
        }
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
