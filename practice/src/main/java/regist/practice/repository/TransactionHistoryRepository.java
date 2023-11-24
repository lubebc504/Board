package regist.practice.repository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import regist.practice.domain.TransactionHistory;
import regist.practice.domain.Comment;
import regist.practice.domain.Content;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TransactionHistoryRepository {
    private final EntityManager EM;
    public TransactionHistory findById(int id) {
//        return contents.get(id);
        return EM.find(TransactionHistory.class,id);
    }

    public void save(TransactionHistory tran) {
//        content.setId(++sequence);
//        contents.put(content.getId(), content);
        EM.persist(tran);
    }

    public void edit(TransactionHistory tran) {
//        contents.put(id, content);
//        Content target=EM.find(Content.class,id);

        EM.merge(tran);
    }
    public List<TransactionHistory> findAll() {
//        return new ArrayList<>(contents.values());
//        return EM.createQuery("SELECT c FROM Content c", Content.class).getResultList();
        return new ArrayList<>(EM.createQuery("SELECT c FROM TransactionHistory c", TransactionHistory.class).getResultList());
    }

    public List<Object[]> findcoin() {
        return new ArrayList<>(
                EM.createQuery("SELECT coinName, count(state) FROM TransactionHistory c WHERE c.state = ?1 OR c.state = ?2 GROUP BY coinName", Object[].class)
                        .setParameter(1, "매도")
                        .setParameter(2, "자동매도")
                        .getResultList());
    }
}
