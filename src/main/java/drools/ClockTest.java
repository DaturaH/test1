package drools;
import java.io.File;

/** 
 * @author  作者 E-mail:  hzhutianqi
 * @date 创建时间：2016年9月8日 上午10:55:20 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
import org.kie.api.KieServices;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.io.KieResources;
import org.kie.api.runtime.KieContainer;  
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;


import action.Clock;  
  
public class ClockTest {  
  
    public static void main(String[] args) {  
        KieServices ks = KieServices.Factory.get();  
        KieContainer kContainer = ks.getKieClasspathContainer();  
        KieSession kSession = kContainer.newKieSession("session-clock");  
          
        kSession.insert(new Clock());  
        kSession.fireAllRules();  
        kSession.dispose();  
    }
//
//    	
//    	
////        String ruleFileName = "clock.drl";
////        
////        KieServices kieServices = KieServices.Factory.get();
////        KieFileSystem kfs = kieServices.newKieFileSystem();
////        KieResources kr = kieServices.getResources();
////        kfs.write(kr.newFileSystemResource(new File(ruleFileName)));
////        kieServices.newKieBuilder(kfs).buildAll();
////        KieContainer kContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());
////        StatelessKieSession kSession = kContainer.newStatelessKieSession();
//    	
//
//    }  

//    public static final void main(String[] args) {
//        try {
//            // load up the knowledge base
//	        KieServices ks = KieServices.Factory.get();
//    	    KieContainer kContainer = ks.getKieClasspathContainer();
//        	KieSession kSession = kContainer.newKieSession("ksession-rules");
//
//            // go !
//            Message message = new Message();
//            message.setMessage("Hello World");
//            message.setStatus(Message.HELLO);
//            kSession.insert(message);
//            kSession.fireAllRules();
//        } catch (Throwable t) {
//            t.printStackTrace();
//        }
//    }
//
//    public static class Message {
//
//        public static final int HELLO = 0;
//        public static final int GOODBYE = 1;
//
//        private String message;
//
//        private int status;
//
//        public String getMessage() {
//            return this.message;
//        }
//
//        public void setMessage(String message) {
//            this.message = message;
//        }
//
//        public int getStatus() {
//            return this.status;
//        }
//
//        public void setStatus(int status) {
//            this.status = status;
//        }
//
//    }
}  