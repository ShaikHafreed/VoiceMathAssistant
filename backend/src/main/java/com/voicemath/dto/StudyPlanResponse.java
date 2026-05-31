package com.voicemath.dto;

import java.util.List;

public class StudyPlanResponse {

    private List<String> weekPlan;

    public StudyPlanResponse() {
    }

    public StudyPlanResponse(
            List<String> weekPlan) {

        this.weekPlan = weekPlan;
    }

    public List<String> getWeekPlan() {
        return weekPlan;
    }

    public void setWeekPlan(
            List<String> weekPlan) {

        this.weekPlan = weekPlan;
    }
}