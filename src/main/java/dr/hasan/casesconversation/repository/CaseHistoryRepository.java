package dr.hasan.casesconversation.repository;

import dr.hasan.casesconversation.entity.CaseHistory;
import dr.hasan.persistence.BaseRepository;
import org.springframework.stereotype.Repository;


@Repository
public class CaseHistoryRepository extends BaseRepository<CaseHistory> {

    public void create(CaseHistory caseHistory){
        try {
            getSession().save(caseHistory);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
