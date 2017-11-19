package dr.hasan.casesconversation.repository;

import dr.hasan.casesconversation.entity.Conversation;
import dr.hasan.persistence.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ConversationRepository extends BaseRepository<Conversation> {

    public void create(Conversation conversation){
        try{
            getSession().save(conversation);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
