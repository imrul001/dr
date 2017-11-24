package testsources.CaseConversationTest;


import dr.hasan.casesconversation.entity.CaseHistory;
import dr.hasan.casesconversation.entity.Conversation;
import dr.hasan.casesconversation.service.CaseConversationService;
import dr.hasan.clientLogin.entity.UserLogin;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans/spring-context-config.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback = true)
public class CaseConversationServiceTest {

    @Autowired
    private CaseConversationService caseConversationService;

    @Test
    @Transactional
    public void createCaseConversationServiceTest(){
        Assert.assertEquals(100, caseConversationService.createCaseConversation().getResponseCode());
        UserLogin userLogin = new UserLogin();
        userLogin.setEmail("bimpu@gmail.com");

        List<CaseHistory> histories = caseConversationService.getCaseHistory(userLogin).getItems();
        Assert.assertEquals(1, histories.size());

        List<Conversation> conversations = histories.get(0).getConversations();
        Assert.assertEquals(2, conversations.size());

    }
    
}
