package com.example.tutorapp;


public class Person {
        String Name, Course, Zipcode;


        public Person(String name, String course, String zipcode) {
            Name = name;
            Course = course;
            Zipcode = zipcode;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getCourse() {
            return Course;
        }

        public void setCourse(String course) {
            Course = course;
        }

        public String getZipcode() {
            return Zipcode;
        }

        public void setZipcode(String zipcode) {
            Zipcode = zipcode;
        }
    }

