package com.example.University.Service.ServiceImpl;

import com.example.University.Service.StudentService;
import com.example.University.model.Student;
import com.example.University.repository.StudentRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studRep;

    public Student create(Student student){
        studRep.save(student);
        return student;
    }

    @Override
    public void delete(Long id) {
        studRep.deleteById(id);
    }

    @Override
    public List<Student> getAll() {
        return List.of();
    }

    public Student getById(Long id){
        studRep.findById(id);
        return null;

    }

    public void update(Student student, Long id){

    }
}
