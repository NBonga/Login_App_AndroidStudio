package com.example.login_app;

class ParentModel {
    private String movieCategory;

    public ParentModel(String movieCategory) {
        this.movieCategory = movieCategory;
    }

    public String movieCategory() {
        return movieCategory;
    }
}