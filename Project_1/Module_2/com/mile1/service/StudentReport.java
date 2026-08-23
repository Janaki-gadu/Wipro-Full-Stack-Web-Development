package com.mile1.service;

import com.mile1.bean.Student;
import com.mile1.exception.*;

public class StudentReport {

    public String findGrade(Student studentObject) {

        int marks[] = studentObject.getMarks();

        for (int mark : marks) {
            if (mark < 35)
                return "F";
        }

        int sum = 0;

        for (int mark : marks)
            sum += mark;

        if (sum <= 150)
            return "D";
        else if (sum <= 200)
            return "C";
        else if (sum <= 250)
            return "B";
        else
            return "A";
    }

    public String validate(Student studentObject)
            throws NullStudentException,
            NullNameException,
            NullMarksArrayException {

        if (studentObject == null)
            throw new NullStudentException();

        if (studentObject.getName() == null)
            throw new NullNameException();

        if (studentObject.getMarks() == null)
            throw new NullMarksArrayException();

        return findGrade(studentObject);
    }
}