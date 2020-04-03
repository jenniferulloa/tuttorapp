package com.example.tutorapp;

import java.util.Objects;

public class Courses {
    private String Course1;
    private String Course2;
    private String Course3;

    public Courses() {

    }

    public Courses(String course1, String course2, String course3) {
        Course1 = course1;
        Course2 = course2;
        Course3 = course3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Courses courses = (Courses) o;
        return Course1.equals(courses.Course1) &&
                Course2.equals(courses.Course2) &&
                Course3.equals(courses.Course3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Course1, Course2, Course3);
    }
}
