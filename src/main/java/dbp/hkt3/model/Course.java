package dbp.hkt3.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer credits;

    private String code;

    private String HRGroup;

    private String cycle;

    private String VRGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_type_id")
    private CourseType courseType;

    @OneToMany(mappedBy = "course")
    private List<CourseAssessment> courseAssessments;
}
