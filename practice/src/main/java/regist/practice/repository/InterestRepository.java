package regist.practice.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import regist.practice.domain.Interest;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class InterestRepository {
    private final EntityManager EM;
    public void save(Interest interest) {
//        content.setId(++sequence);
//        contents.put(content.getId(), content);
        EM.persist(interest);
    }

    public void edit(Interest interest) {
//        contents.put(id, content);
//        Content target=EM.find(Content.class,id);

        EM.merge(interest);
    }

    public void delete(int id) {
//        contents.remove(id);
        Interest interest = EM.find(Interest.class,id);
        if(interest!=null){
            EM.remove(interest);
        }
    }

    public List<Interest> findAll() {
//        return new ArrayList<>(contents.values());
//        return EM.createQuery("SELECT c FROM Content c", Content.class).getResultList();
        return new ArrayList<>(EM.createQuery("SELECT c FROM Interest c", Interest.class).getResultList());
    }

    public Interest findById(int id) {
//        return contents.get(id);
        return EM.find(Interest.class,id);
    }

    public List<Interest> findByCoinName(String coinName) {
        return EM.createQuery("SELECT c FROM Interest c WHERE c.coinName = :coinName", Interest.class)
                .setParameter("coinName", coinName)
                .getResultList();
    }
}
