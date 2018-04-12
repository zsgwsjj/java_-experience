package spider1.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import spider1.dao.IResourcesDao;
import spider1.model.Item;

/**
 * @author : jiang
 * @time : 2018/4/10 22:25
 */
@Repository
public class ResourcesDao implements IResourcesDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String TABLE = "resource_spider";
    private static final String ALL_COLUMNS = " title,url,links_pwds,publish_time,authority_level,parti_tion,auther,reply_num,view_num," +
            "last_reply_name,last_reply_time,last_reply_url,first_page_reply,is_need_reply,search_link_times,create_time ";
    private static final String INSERT = " INSERT INTO " + TABLE + "(" + ALL_COLUMNS + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

    @Override
    public void insertRes(Item item) {
        jdbcTemplate.update(INSERT, item.getTitle(), item.getUrl(), item.getLinksAndPwdsStr(),
                item.getPublishTime(), item.getAuthorityLevel(), item.getPartition(), item.getAuther(),
                item.getReplyNum(), item.getViewNum(), item.getLastReplyName(), item.getLastReplyTime(),
                item.getLastReplyUrl(), item.getFirstPageReply(), item.isNeedReply(), item.getSearchLinkTimes(),
                System.currentTimeMillis() / 1000);
    }
}
