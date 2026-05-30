package com.voicemath.ai;

import org.springframework.stereotype.Service;

@Service
public class RecommendationService {

    public String recommend(double score) {

        if(score >= 90)
            return "🚀 Advance to Calculus";

        if(score >= 75)
            return "📚 Practice Algebra";

        return "📝 Revise Basics";
    }
} 