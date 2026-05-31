fetch(
    "http://localhost:8080/api/profile"
)
.then(response => response.json())
.then(data => {

    document.getElementById(
        "calculations"
    ).innerText =
        data.totalCalculations;

    document.getElementById(
        "score"
    ).innerText =
        data.averageScore.toFixed(2);

    document.getElementById(
        "level"
    ).innerText =
        data.level;

    document.getElementById(
        "achievements"
    ).innerText =
        data.achievements.length;

    const ctx =
        document.getElementById(
            "scoreChart"
        );

    new Chart(
        ctx,
        {
            type:"bar",

            data:{

                labels:[
                    "Calculations",
                    "Score",
                    "Achievements"
                ],

                datasets:[
                    {

                        label:
                        "Learning Analytics",

                        data:[
                            data.totalCalculations,
                            data.averageScore,
                            data.achievements.length
                        ]
                    }
                ]
            }
        }
    );
});