package ru.otus.example.mongodbdemo.repositories.withlisteners;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import ru.otus.example.mongodbdemo.events.MongoStudentCascadeSaveEventsListener;
import ru.otus.example.mongodbdemo.model.Knowledge;
import ru.otus.example.mongodbdemo.model.Student;
import ru.otus.example.mongodbdemo.repositories.AbstractRepositoryTest;
import ru.otus.example.mongodbdemo.repositories.StudentRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("StudentRepository при наличии listener-ов в контексте ")
@Import(MongoStudentCascadeSaveEventsListener.class)
class StudentRepositoryWithListenersTest extends AbstractRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @DisplayName("должен корректно сохранять студента с отсутствующими в БД знаниями")
    @Test
    void shouldCorrectSaveStudentWithNewKnowledge(){
        val student = new Student("Student #2", new Knowledge("Knowledge #3"));
        val actual = studentRepository.save(student);
        assertThat(actual.getId()).isNotNull();
        assertThat(actual.getName()).isEqualTo(student.getName());
    }

    @DisplayName("должен возвращать корректный список знаний студента")
    @Test
    void shouldReturnCorrectStudentKnowledgeList(){
        val student = studentRepository.findAll().get(0);
        List<Knowledge> knowledgeList = studentRepository.getStudentExperienceById(student.getId());
        assertThat(knowledgeList).containsExactlyInAnyOrderElementsOf(student.getExperience());
    }

    @DisplayName("напечатать все стадии агрегации для getStudentExperienceById")
    @Test
    void shouldPrintAggregationStagesForHetStudentExperienceByIdMethod (){
        val student = studentRepository.findAll().get(0);
        for (int i = 0; i <= 7; i++) {
            studentRepository.printGetStudentExperienceByIdAggregationResultForStage(student.getId(), i);
            System.out.println("\n\n");
        }
    }

}
