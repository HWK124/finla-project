import com.baizhi.CmfzApp;
import com.baizhi.entity.Banner;
import com.baizhi.entity.Menu;
import com.baizhi.service.BannerService;
import com.baizhi.service.MenuService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/8/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CmfzApp.class)
public class Test {
    @Autowired
    private MenuService menuService;

    @org.junit.Test
    public void test1() {
        List<Menu> list = menuService.queryAll();
        for (Menu menu : list) {
            System.out.println(menu.getTitle());
            List<Menu> list2 = menu.getContent();
            for (Menu menu1 : list2) {
                System.out.println(menu1.getTitle());
            }
        }
    }

    @Autowired
    BannerService bannerService;

    @org.junit.Test
    public void test2() {
        List<Banner> list = bannerService.queryAll();
        for (Banner banner : list) {
            System.out.println(banner);
        }
    }

    @org.junit.Test
    public void test3() {
        for (int i = 1; i <= 10; i++) {


            Banner banner = new Banner();
            banner.setTitle("轮播图" + i);
            banner.setImgPath("???");
            banner.setDescription("???");
            banner.setStatus("U");
            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            banner.setCreateDate(timeStamp);
            bannerService.add(banner);
        }
    }

    @org.junit.Test
    public void test4() {
        Banner banner = new Banner();
        banner.setId(46);
        bannerService.delete(banner);
    }
}
