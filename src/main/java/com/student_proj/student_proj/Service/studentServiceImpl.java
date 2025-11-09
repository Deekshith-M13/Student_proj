package com.student_proj.student_proj.Service;

import com.student_proj.student_proj.Dto.*;
import com.student_proj.student_proj.Entity.studentEntity;
import com.student_proj.student_proj.Repository.studentRepository;

import com.student_proj.student_proj.Dto.studentDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class studentServiceImpl implements studentService{

    private final studentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<studentDto> getAll() {
        List<studentEntity> students = studentRepository.findAll();
        List<studentDto> studentDto = students.
                stream()
                .map(student -> modelMapper.map(student, studentDto.class))
                .toList();
        return studentDto;
    }

    public studentDto getByID(int id){
        studentEntity student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with id" + id));
        studentDto studentDto = modelMapper.map(student, studentDto.class);
        return studentDto;
    }

    public studentDto addStudent(studentRequestDto studentRequestDto){
            studentEntity newstudent = modelMapper.map(studentRequestDto, studentEntity.class);
            studentEntity st = studentRepository.save(newstudent);
            return modelMapper.map(st, studentDto.class);
    }

    public void deleteStudent(int id){
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
        }
        else{
            throw new IllegalArgumentException("Student does not exits by id" + id);
        }
    }

    @Override
    public studentDto updateStudent(int id, studentRequestDto studentRequestDto) {
        studentEntity student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not present with id"+id));
        modelMapper.map(studentRequestDto, student);
        student = studentRepository.save(student);
        return modelMapper.map(student, studentDto.class);
    }

    @Override
    public studentDto patchStudent(int id, Map<String, Object> updates) {
        studentEntity student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not present with id"+id));

        updates.forEach((field,value) ->{
            switch(field){
                case "name" : student.setName((String) value);
                break;
                case "age" : student.setAge((Integer) value);
                break;

                default: throw new IllegalArgumentException("Field is not applicable");
            }
        });

        studentEntity savedStudent = studentRepository.save(student);
        return modelMapper.map(student, studentDto.class);
    }

}
