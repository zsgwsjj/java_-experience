package spider1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import spider1.dao.IResourcesDao;
import spider1.service.ISpiderService;

/**
 * @author : jiang
 * @time : 2018/4/12 16:28
 */
public class SpiderService implements ISpiderService {

    @Autowired
    private IResourcesDao resourcesDao;

    @Override
    public void cleanUp() {
        resourcesDao.cleanUp();
    }
}
