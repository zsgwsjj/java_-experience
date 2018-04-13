package spider1.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author : jiang
 * @time : 2018/4/12 15:42
 */
@Component("taskJob")
public class TaskJob{

    @Scheduled(cron = "0 0 3 * * ?")
    public void job1(){
        System.out.println("任务进行中...");
    }
}
