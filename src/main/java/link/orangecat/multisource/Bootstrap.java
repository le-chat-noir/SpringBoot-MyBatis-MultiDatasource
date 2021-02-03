package link.orangecat.multisource;

import link.orangecat.multisource.persistence.dao.primary.ArticleDao;
import link.orangecat.multisource.persistence.dao.primary.TestDao;
import link.orangecat.multisource.persistence.dao.secondary.VideoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    private TestDao testDao;

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private VideoDao videoDao;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(testDao.selectBlog(1).getText());
        System.out.println(articleDao.selectArticle().get(0).getA_name());
        System.out.println(videoDao.selectVideo(2).getV_name());

    }
}
