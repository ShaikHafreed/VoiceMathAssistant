package com.voicemath.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudyPlannerService {

    public List<String> generatePlan(double averageScore) {

        List<String> plan = new ArrayList<>();

        if (averageScore < 40) {

            plan.add("Week 1: Basic Arithmetic");
            plan.add("Week 2: Fractions");
            plan.add("Week 3: Percentages");
            plan.add("Week 4: Simple Algebra");

        } else if (averageScore < 60) {

            plan.add("Week 1: Algebra Basics");
            plan.add("Week 2: Linear Equations");
            plan.add("Week 3: Geometry Basics");
            plan.add("Week 4: Statistics");

        } else if (averageScore < 80) {

            plan.add("Week 1: Advanced Algebra");
            plan.add("Week 2: Quadratic Equations");
            plan.add("Week 3: Trigonometry");
            plan.add("Week 4: Geometry Applications");

        } else {

            plan.add("Week 1: Calculus Introduction");
            plan.add("Week 2: Derivatives");
            plan.add("Week 3: Integrals");
            plan.add("Week 4: Advanced Problem Solving");
        }

        return plan;
    }
}