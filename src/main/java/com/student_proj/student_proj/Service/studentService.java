package com.student_proj.student_proj.Service;

import com.student_proj.student_proj.Dto.*;

import java.util.List;
import java.util.Map;

public interface studentService {
    public List<studentDto> getAll();
    public studentDto getByID(int id);
    public studentDto addStudent(studentRequestDto studentRequestDto);

    void deleteStudent(int id);

    studentDto updateStudent(int id, studentRequestDto studentRequestDto);

    studentDto patchStudent(int id, Map<String, Object> updates);
}
