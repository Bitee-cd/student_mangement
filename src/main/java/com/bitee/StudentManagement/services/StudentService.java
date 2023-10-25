package com.bitee.StudentManagement.services;

import com.bitee.StudentManagement.models.Student;
import com.bitee.StudentManagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public void createStudent(Student student){
        Optional<Student> existingStudent =
                studentRepository.findStudentByEmail(student.getEmail());

        if(existingStudent.isPresent()){
            throw new IllegalStateException("email is already taken");
        }
        else {
            studentRepository.save(student);
        }
    }

    public Optional<Student> getSingleStudent(Long id){
        boolean studentExists =
                studentRepository.existsById(id);
        if(!studentExists){
            throw new IllegalStateException("user doesn't" +
                    " exist ");
        }else {
           return studentRepository.findById(id);
        }
    }

    public void deleteStudent(Long id){
        boolean studentExists =
                studentRepository.existsById(id);
        if(!studentExists){
            throw new IllegalStateException("user doesn't" +
                    " exist ");
        }else {
            studentRepository.deleteById(id);
        }

    }
    public void updateStudent(Long id, String email, String name, LocalDate dob){

    }
}
