package dbp.hkt3;

import dbp.hkt3.model.*;
import dbp.hkt3.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Hkt3Application implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private PeriodoRepository periodoRepository;

    @Autowired
    private CourseTypeRepository courseTypeRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseAssessmentRepository courseAssessmentRepository;

    @Autowired
    private CourseAssessmentDetailsRepository courseAssessmentDetailsRepository;

    public static void main(String[] args) {
        SpringApplication.run(Hkt3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Student student = new Student();
        student.setName("Nguyen Van A");
        student.setEmail("nguyen@gmail.com");
        student.setCode("A123");

        studentRepository.save(student);

        Professor professor = new Professor();
        professor.setName("Jorge");
        professor.setLastName("Perez");
        professor.setEmail("jorgeperez@gmail.com");
        professor.setFullName("Jorge Perez");

        professorRepository.save(professor);

        Periodo periodo = new Periodo();
        periodo.setName("Periodo 1");
        periodo.setCode("P1");

        periodoRepository.save(periodo);

        CourseType courseType = new CourseType();
        courseType.setName("Course Type 1");

        courseTypeRepository.save(courseType);

        Course course = new Course();
        course.setName("Course 1");
        course.setCredits(3);
        course.setCode("C1");
        course.setHRGroup("HRG1");
        course.setCycle("C1");
        course.setVRGroup("VRG1");
        CourseType courseType2 = courseTypeRepository.findById(1L).orElse(null);
        if (courseType2 != null) {
            course.setCourseType(courseType2);
        }

        courseRepository.save(course);

        CourseAssessment courseAssessment = new CourseAssessment();
        courseAssessment.setTitle("Course Assessment 1");
        courseAssessment.setTipoNota("Tipo Nota 1");
        courseAssessment.setNumNota("Num Nota 1");
        courseAssessment.setNomenclatura("Nomenclatura 1");
        Course course2 = courseRepository.findById(1L).orElse(null);
        if (course2 != null) {
            courseAssessment.setCourse(course2);
        }
        Periodo periodo2 = periodoRepository.findById(1L).orElse(null);
        if (periodo2 != null) {
            courseAssessment.setPeriodo(periodo2);
        }

        courseAssessmentRepository.save(courseAssessment);

        CourseAssessmentDetails courseAssessmentDetails = new CourseAssessmentDetails();
        courseAssessmentDetails.setSectionGroup("Section Group 1");
        courseAssessmentDetails.setSection("Section 1");
        courseAssessmentDetails.setScore("Score 1");
        Student student2 = studentRepository.findById(1L).orElse(null);
        if (student2 != null) {
            courseAssessmentDetails.setStudent(student2);
        }
        Professor professor2 = professorRepository.findById(1L).orElse(null);
        if (professor2 != null) {
            courseAssessmentDetails.setProfessor(professor2);
        }
        CourseAssessment courseAssessment2 = courseAssessmentRepository.findById(1L).orElse(null);
        if (courseAssessment2 != null) {
            courseAssessmentDetails.setCourseAssessment(courseAssessment2);
        }

        courseAssessmentDetailsRepository.save(courseAssessmentDetails);
    }
}
