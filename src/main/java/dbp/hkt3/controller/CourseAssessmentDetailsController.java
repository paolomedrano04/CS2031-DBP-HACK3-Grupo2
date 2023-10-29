package dbp.hkt3.controller;

import dbp.hkt3.dto.CourseAssessmentDetailsDTO;
import dbp.hkt3.model.CourseAssessment;
import dbp.hkt3.model.CourseAssessmentDetails;
import dbp.hkt3.model.Professor;
import dbp.hkt3.model.Student;
import dbp.hkt3.repository.CourseAssessmentDetailsRepository;
import dbp.hkt3.repository.CourseAssessmentRepository;
import dbp.hkt3.repository.ProfessorRepository;
import dbp.hkt3.repository.StudentRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/course_assessment_details")
@Tag(name = "CourseAssessmentDetailsController", description = "To perform CourseAssessmentDetails Actions")
public class CourseAssessmentDetailsController {


    @Autowired
    private CourseAssessmentDetailsRepository courseAssessmentDetailsRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private CourseAssessmentRepository courseAssessmentRepository;

    @Operation(
            summary = "GET operation all CourseAssessmentDetails",
            description = "It is used for getting all CourseAssessmentDetails that are in the database"
    )
    @GetMapping
    private List<CourseAssessmentDetailsDTO> getAllCourseAssessmentDetails() {
        List<CourseAssessmentDetails> details = courseAssessmentDetailsRepository.findAll();

        return details.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private CourseAssessmentDetailsDTO convertToDTO(CourseAssessmentDetails detail) {
        CourseAssessmentDetailsDTO dto = new CourseAssessmentDetailsDTO();

        dto.setId(detail.getId());
        dto.setSectionGroup(detail.getSectionGroup());
        dto.setSection(detail.getSection());
        dto.setScore(detail.getScore());

        if (detail.getStudent() != null) {
            dto.setStudentId(detail.getStudent().getId());
        }
        if (detail.getProfessor() != null) {
            dto.setProfessorId(detail.getProfessor().getId());
        }
        if (detail.getCourseAssessment() != null) {
            dto.setCourseAssessmentId(detail.getCourseAssessment().getId());
        }

        return dto;
    }

    @Operation(
            summary = "GET operation CourseAssessmentDetails by Id",
            description = "It is used for getting a CourseAssessmentDetails by Id that is in the database"
    )
    @GetMapping("{id}")
    private CourseAssessmentDetailsDTO getCourseAssessmentDetailsById(@PathVariable Long id) {
        CourseAssessmentDetails detail = courseAssessmentDetailsRepository.findById(id).orElse(null);

        if (detail == null) {
            return null;
        }

        return convertToDTO(detail);
    }

    @Operation(
            summary = "DELETE operation CourseAssessmentDetails by Id",
            description = "It is used for deleting a CourseAssessmentDetails by Id that is in the database"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseAssessmentDetailsDTO createCourseAssessmentDetails(@RequestBody CourseAssessmentDetailsDTO dto) {
        CourseAssessmentDetails detail = new CourseAssessmentDetails();

        detail.setSectionGroup(dto.getSectionGroup());
        detail.setSection(dto.getSection());
        detail.setScore(dto.getScore());

        if (dto.getStudentId() != null) {
            Student student = studentRepository.findById(dto.getStudentId()).orElse(null);
            detail.setStudent(student);
        }

        if (dto.getProfessorId() != null) {
            Professor professor = professorRepository.findById(dto.getProfessorId()).orElse(null);
            detail.setProfessor(professor);
        }

        if (dto.getCourseAssessmentId() != null) {
            CourseAssessment courseAssessment = courseAssessmentRepository.findById(dto.getCourseAssessmentId()).orElse(null);
            detail.setCourseAssessment(courseAssessment);
        }

        CourseAssessmentDetails savedDetail = courseAssessmentDetailsRepository.save(detail);
        return convertToDTO(savedDetail);
    }

    @Operation(
            summary = "DELETE operation CourseAssessmentDetails by Id",
            description = "It is used for deleting a CourseAssessmentDetails by Id that is in the database"
    )
    @PutMapping("/{id}")
    public CourseAssessmentDetailsDTO updateCourseAssessmentDetails(@PathVariable Long id, @RequestBody CourseAssessmentDetailsDTO dto) {
        CourseAssessmentDetails detail = courseAssessmentDetailsRepository.findById(id).orElse(null);

        if (detail == null) {
            return null; // Handle this better in a real-world scenario (e.g., throw a custom exception)
        }

        detail.setSectionGroup(dto.getSectionGroup());
        detail.setSection(dto.getSection());
        detail.setScore(dto.getScore());

        if (dto.getStudentId() != null) {
            Student student = studentRepository.findById(dto.getStudentId()).orElse(null);
            detail.setStudent(student);
        }

        if (dto.getProfessorId() != null) {
            Professor professor = professorRepository.findById(dto.getProfessorId()).orElse(null);
            detail.setProfessor(professor);
        }

        if (dto.getCourseAssessmentId() != null) {
            CourseAssessment courseAssessment = courseAssessmentRepository.findById(dto.getCourseAssessmentId()).orElse(null);
            detail.setCourseAssessment(courseAssessment);
        }

        CourseAssessmentDetails updatedDetail = courseAssessmentDetailsRepository.save(detail);
        return convertToDTO(updatedDetail);
    }

    @Operation(
            summary = "DELETE operation CourseAssessmentDetails by Id",
            description = "It is used for deleting a CourseAssessmentDetails by Id that is in the database"
    )
    @PatchMapping("/{id}")
    public CourseAssessmentDetailsDTO partiallyUpdateCourseAssessmentDetails(@PathVariable Long id, @RequestBody CourseAssessmentDetailsDTO dto) {
        CourseAssessmentDetails detail = courseAssessmentDetailsRepository.findById(id).orElse(null);

        if (detail == null) {
            return null; // Handle this better in a real-world scenario (e.g., throw a custom exception)
        }

        if (dto.getSectionGroup() != null) {
            detail.setSectionGroup(dto.getSectionGroup());
        }

        if (dto.getSection() != null) {
            detail.setSection(dto.getSection());
        }

        if (dto.getScore() != null) {
            detail.setScore(dto.getScore());
        }

        // Note: In a PATCH method, only update values if they are provided in the DTO.

        if (dto.getStudentId() != null) {
            Student student = studentRepository.findById(dto.getStudentId()).orElse(null);
            detail.setStudent(student);
        }

        if (dto.getProfessorId() != null) {
            Professor professor = professorRepository.findById(dto.getProfessorId()).orElse(null);
            detail.setProfessor(professor);
        }

        if (dto.getCourseAssessmentId() != null) {
            CourseAssessment courseAssessment = courseAssessmentRepository.findById(dto.getCourseAssessmentId()).orElse(null);
            detail.setCourseAssessment(courseAssessment);
        }

        CourseAssessmentDetails updatedDetail = courseAssessmentDetailsRepository.save(detail);
        return convertToDTO(updatedDetail);
    }
}
