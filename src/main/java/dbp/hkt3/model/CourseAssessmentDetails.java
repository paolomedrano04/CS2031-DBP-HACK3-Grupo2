package dbp.hkt3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "student")
public class CourseAssessmentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sectionGroup;

    private String section;

    private String score;

    @ManyToOne
    @JoinColumn(name =  "student_id")
    @JsonIgnore
    private Student student;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name =  "professor_id")
    private Professor professor;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name =  "course_assessment_id")
    private CourseAssessment courseAssessment;
}
