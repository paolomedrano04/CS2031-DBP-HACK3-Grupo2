package dbp.hkt3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseAssessmentDetailsDTO {

    private Long id;

    private String sectionGroup;

    private String section;

    private String score;

    private Long studentId;

    private Long professorId;

    private Long courseAssessmentId;
}
