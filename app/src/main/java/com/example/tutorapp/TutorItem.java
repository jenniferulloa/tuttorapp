package com.example.tutorapp;

public class TutorItem {

    String name = null;
    String subject = null;
    String topic = null;
    String rating = null;
    String cost = null;
    String zip = null;
    int image;

    public TutorItem(String name, String subject, String topic, String rating, String cost, String zip, int image) {
        super();
        this.name = name;
        this.subject = subject;
        this.topic = topic;
        this.rating = rating;
        this.cost = cost;
        this.zip = zip;
        this.image = image;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Integer getImageT() {
        return image;
    }

    public void setImageT(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return image + " " + name + " " + subject + " "
                + topic + " " + rating + " " + cost + " " + zip;
    }
}



















