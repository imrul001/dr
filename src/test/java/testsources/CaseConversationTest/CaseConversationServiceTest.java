package testsources.CaseConversationTest;


import dr.hasan.casesconversation.service.CaseConversationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans/spring-context-config.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback = false)
public class CaseConversationServiceTest {

    @Autowired
    private CaseConversationService caseConversationService;

    @Test
    @Transactional
    public void CreateCaseConversationServiceTest(){
        Assert.assertEquals(100, caseConversationService.createCaseConversation().getResponseCode());
    }

}
