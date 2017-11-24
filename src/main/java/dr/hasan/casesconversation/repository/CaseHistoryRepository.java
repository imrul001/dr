package dr.hasan.casesconversation.repository;

import dr.hasan.casesconversation.entity.CaseHistory;
import dr.hasan.common.enums.YesNo;
import dr.hasan.persistence.BaseRepository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CaseHistoryRepository extends BaseRepository<CaseHistory> {

    public void create(CaseHistory caseHistory){
        try {
            getSession().save(caseHistory);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<CaseHistory> getCaseHistoriesByEmail(String email){
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("patientEmail", email))
                .add(Restrictions.eq("isActive", YesNo.YES.getCode()));
        return criteria.list();
    }
}
