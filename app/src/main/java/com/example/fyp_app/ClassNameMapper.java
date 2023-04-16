package com.example.fyp_app;

import java.util.HashMap;

public class ClassNameMapper {
    private HashMap<Integer, String> class_names;

    public ClassNameMapper() {
        this.class_names = new HashMap<Integer, String>();
        this.class_names.put(0, "Apple - Apple Scab");
        this.class_names.put(1, "apple black rot");
        this.class_names.put(2, "cedar apple rust");
        this.class_names.put(3, "apple healthy");
        this.class_names.put(4, "blackgram -anthracnose");
        this.class_names.put(5, "blackgram- HEALTHY");
        this.class_names.put(6, "blackgram- leaf crinkle");
        this.class_names.put(7, "blackgram - powdery mildew");
        this.class_names.put(8, "blackgram yellow mosaic");
        this.class_names.put(9, "grape black rot");
        this.class_names.put(10, "grape esca black measles");
        this.class_names.put(11, "grape HEALTHY");
        this.class_names.put(12, "grape leaf blight");
        this.class_names.put(13, "potato early blight");
        this.class_names.put(14, "potato healthy");
        this.class_names.put(15, "potato late blight");
        this.class_names.put(16, "tomato bacterial spot");
        this.class_names.put(17, "tomato early blight");
        this.class_names.put(18, "tomato healthy");
        this.class_names.put(19, "tomato late blight");
        this.class_names.put(20, "tomato septoria");
    }

    public String getClassName(int index) {
        return this.class_names.get(index);
    }
}
