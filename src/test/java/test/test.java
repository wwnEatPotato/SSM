package test;

import com.wwn.mapper.BookMapper;
import com.wwn.pojo.Books;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author wwn
 * @creat 2022-03-07-16:51
 */
public class test {
    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSession sqlSession = sqlSessionFactoryBuilder.build(resourceAsStream).openSession(true);
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        List<Books> books = mapper.queryAllBooks();
        books.forEach(book -> System.out.println(book));


    }
}
