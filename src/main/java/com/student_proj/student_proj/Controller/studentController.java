package com.student_proj.student_proj.Controller;

import com.student_proj.student_proj.Dto.studentDto;
import com.student_proj.student_proj.Dto.studentRequestDto;
import com.student_proj.student_proj.Entity.studentEntity;
import com.student_proj.student_proj.Service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class studentController {


    private final studentService studentService;

    @GetMapping
    public ResponseEntity<List<studentDto>> getAllStudents(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<studentDto> getByID(@PathVariable int id){
        return ResponseEntity.ok(studentService.getByID(id));
    }

    @PostMapping("/add")
    public ResponseEntity<studentDto> addStudent(@RequestBody @Valid studentRequestDto studentRequestDto){
        return ResponseEntity.ok(studentService.addStudent(studentRequestDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<studentDto> updateStudent(@PathVariable int id, @RequestBody @Valid studentRequestDto studentRequestDto){
        return ResponseEntity.ok(studentService.updateStudent(id,studentRequestDto));
    }

    @PatchMapping("/patch/{id}")
    public ResponseEntity<studentDto> pathStudent(@PathVariable int id, @RequestBody @Valid Map<String, Object> updates){
        return ResponseEntity.ok(studentService.patchStudent(id,updates));
    }
}
