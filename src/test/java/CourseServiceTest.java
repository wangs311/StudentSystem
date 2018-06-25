import com.nenu.software.common.entity.Course;
import com.nenu.software.service.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author shanjz
 * @since 2018/6/20 10:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring-mybatis.xml"})
public class CourseServiceTest {

    @Autowired
    CourseService courseService;

    @Test
    public void testNewCourse() throws Exception {
        Course course = new Course();
        course.setCourseName("ffffff");
        courseService.newCourse(course);
        System.out.println("new course succeed");
    }

    @Test
    public void testDeleteCourse() throws Exception {
        courseService.deleteCourseById(1);
        System.out.println("delete over");
    }

    @Test
    public void testUpdateCourse() throws Exception {
        Course course = new Course();
        course.setId(2);
        course.setCourseName("去你妈的软件测试");
        courseService.updateCourse(course);
    }

    @Test
    public void testSelectCourse() throws Exception {
        System.out.println(courseService.selectCourseById(3));
        System.out.println(courseService.listCourseByName(null));
    }

    @Test
    public void queryAllCourseTest() throws Exception {
        List<Course> list = courseService.queryAllCourse();
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getCourseName());
        }
    }

}
