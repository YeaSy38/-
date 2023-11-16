package com.example;
// Programa dlia realizatsiyi patternu Strategy (Strategiia)

import java.util.*;

// Kontekst
class CourseRegistration {
    private RegistrationStrategy registrationStrategy;

    public void setRegistrationStrategy(RegistrationStrategy strategy) {
        this.registrationStrategy = strategy;
    }

    public void registerCourse(String courseName) {
        registrationStrategy.register(courseName);
    }
}

// Strategiia reiestratsiyi na kurs
interface RegistrationStrategy {
    void register(String courseName);
}

// Konkretna strategiia reiestratsiyi: Reiestratsiia cherez veb-storinku
class WebRegistration implements RegistrationStrategy {
    public void register(String courseName) {
        System.out.println("Zareiestruites' na kurs " + courseName + " cherez veb-storinku");
    }
}

// Konkretna strategiia reiestratsiyi: Reiestratsiia cherez telefon
class PhoneRegistration implements RegistrationStrategy {
    public void register(String courseName) {
        System.out.println("Zatelefonuite na nomer i zareiestruites' na kurs " + courseName);
    }
}

// Konkretna strategiia reiestratsiyi: Reiestratsiia cherez poshtu
class MailRegistration implements RegistrationStrategy {
    public void register(String courseName) {
        System.out.println("Nadishlit' lista z vashimi danimi, shchob zareiestruvatis' na kurs " + courseName);
    }
}

// Golovnii klas
public class StrategyPatternExample {
    public static void main(String[] args) {
        // Stvorennia kontekstu
        CourseRegistration registration = new CourseRegistration();

        // Vstanovlennia strategiyi reiestratsiyi cherez veb-storinku
        registration.setRegistrationStrategy(new WebRegistration());
        registration.registerCourse("Kurs Java programuvannia");

        // Vstanovlennia strategiyi reiestratsiyi cherez telefon
        registration.setRegistrationStrategy(new PhoneRegistration());
        registration.registerCourse("Kurs marketingu");

        // Vstanovlennia strategiyi reiestratsiyi cherez poshtu
        registration.setRegistrationStrategy(new MailRegistration());
        registration.registerCourse("Kurs finansiv");
    }
}
