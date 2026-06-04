package com.voicemath.service;

import org.springframework.stereotype.Service;

import com.voicemath.dto.TutorResponse;

@Service
public class AITutorService {

    public TutorResponse teach(
            String topic) {

        topic =
                topic.toLowerCase();

        if (topic.contains("quadratic")) {

            return new TutorResponse(

                    "Quadratic Equations",

                    """
                    A quadratic equation
                    is an equation with degree 2.

                    Standard Form:

                    ax² + bx + c = 0
                    """,

                    """
                    Example:

                    x² + 5x + 6 = 0

                    Factors:

                    (x + 2)(x + 3)

                    Roots:

                    x = -2 and x = -3
                    """,

                    """
                    Quiz:

                    Solve:

                    x² + 7x + 10 = 0
                    """
            );
        }

        if (topic.contains("algebra")) {

            return new TutorResponse(

                    "Basic Algebra",

                    """
                    Algebra uses symbols
                    and variables.

                    Example variable:

                    x
                    """,

                    """
                    Example:

                    x + 5 = 10

                    x = 5
                    """,

                    """
                    Quiz:

                    Solve:

                    x + 8 = 20
                    """
            );
        }

        return new TutorResponse(

                topic,

                """
                Topic explanation
                coming soon.
                """,

                "Example unavailable",

                "Quiz unavailable"
        );
    }
}