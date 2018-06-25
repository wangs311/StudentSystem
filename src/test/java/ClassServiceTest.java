import com.nenu.software.common.entity.Class;
import com.nenu.software.common.entity.Student;
import com.nenu.software.service.ClassService;
import com.nenu.software.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author shanjz
 * @since 2018/6/20 10:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring-mybatis.xml"})
public class ClassServiceTest {

    @Autowired
    ClassService classService;

    @Test
    public void testNewClass() throws Exception {
        Class clazz = new Class();
        clazz.setGrade("2015");
        clazz.setClassName("ccc");
        classService.newClass(clazz);
        System.out.println("new over");
    }

    @Test
    public void deleteClassById() throws Exception {
        classService.deleteClassById(1);
        System.out.println("delete over");
    }
    @Test
    public void updateClass() throws Exception {
        Class clazz = new Class();
        clazz.setId(3);
        clazz.setClassName("bbb");
        clazz.setGrade("2016");
        classService.updateClass(clazz);
        System.out.println("update over");
    }

    @Test
    public void selectClass() throws Exception {
        System.out.println(classService.selectClassById(2));
        System.out.println(classService.listClassByConditions(null, null));
    }

}
