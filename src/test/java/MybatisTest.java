import com.dao.IUserDao;
import com.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) throws IOException {
//        1.加载主配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);//SqlSessionFactory无法被new，用build创建
//        3.使用工厂创建SqlSession对象
        SqlSession session=factory.openSession();
//        4.使用SqlSession创建Dao接口的代理对象
        IUserDao userDao =session.getMapper(IUserDao.class);
//        5.使用代理对象的方法
        List<User> users=userDao.findAll();
        for (User user :users){
            System.out.println(user);
        }
//        6.释放资源
        session.close();
        in.close();
    }
}
