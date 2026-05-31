package com.voicemath.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudyPlanService {

    public List<String> generatePlan(
            double averageScore) {

        List<String> plan =
                new ArrayList<>();

        if (averageScore < 50) {

            plan.add("Monday - Percentages");
            plan.add("Tuesday - Fractions");
            plan.add("Wednesday - Basic Algebra");
            plan.add("Thursday - Practice Quiz");
            plan.add("Friday - Revision");

        } else if (averageScore < 80) {

            plan.add("Monday - Algebra");
            plan.add("Tuesday - Geometry");
            plan.add("Wednesday - Statistics");
            plan.add("Thursday - Quiz");
            plan.add("Friday - Revision");

        } else {

            plan.add("Monday - Advanced Algebra");
            plan.add("Tuesday - Trigonometry");
            plan.add("Wednesday - Statistics");
            plan.add("Thursday - Mock Test");
            plan.add("Friday - Revision");
        }

        return plan;
    }
}