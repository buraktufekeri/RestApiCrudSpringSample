package com.demo.service;

import com.demo.model.Students;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentsService {
    private static Map<Integer, Students> studentsMap = getStudentsMap();

    public StudentsService() {
        super();
        if (studentsMap == null) {
            studentsMap = new HashMap<>();

            Students students = new Students(1, "Burak", "Tüfekeri");
            Students students1 = new Students(2, "Muhammed", "Özkurt");
            Students students2 = new Students(3, "Sefa", "Eker");
            Students students3 = new Students(4, "Ömer", "Gözübüyük");

            studentsMap.put(students.getId(), students);
            studentsMap.put(students1.getId(), students1);
            studentsMap.put(students2.getId(), students2);
            studentsMap.put(students3.getId(), students3);
        }
    }

    public static int getMaximumId() {
        int maxId = 0;
        for (int id : studentsMap.keySet()) {
            if (maxId <= id) {
                maxId = id;
            }
        }
        return maxId;
    }

    public static Map<Integer, Students> getStudentsMap() {
        return studentsMap;
    }

    public List<Students> getAllStudentsList(){
        return new ArrayList<>(studentsMap.values());
    }

    public Students getStudent(int id){
        return studentsMap.get(id);
    }

    public Students addStudent(Students students){
        students.setId(getMaximumId() + 1);
        studentsMap.put(students.getId(), students);

        return students;
    }

    public Students updateStudent(Students students){
        if (!studentsMap.containsKey(students.getId()))
            return null;
        studentsMap.replace(students.getId(), students);

        return students;
    }

    public List<Students> deleteStudent(int id){
        if (studentsMap.containsKey(id)){
            studentsMap.remove(id);
            return new ArrayList<>(studentsMap.values());
        }else
            return null;
    }
}
