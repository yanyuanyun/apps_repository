import com.zhiyun.dao.FindUser;
import com.zhiyun.domian.User;
import com.zhiyun.util.JDBCUtil;
import org.junit.Test;

import javax.sql.DataSource;

public class TestDemo {
    @Test
    public void test01(){
        User user = new User("张三", "123456");
        User results = FindUser.find(user);
        System.out.println(results);
    }

    @Test
    public void testgetDS(){
        DataSource ds = JDBCUtil.getDs();
        System.out.println(ds);
    }
}
