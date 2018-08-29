import com.baizhi.CmfzApp;
import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
}
