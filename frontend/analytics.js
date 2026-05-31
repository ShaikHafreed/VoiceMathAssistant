fetch(
    "http://localhost:8080/api/analytics"
)
.then(response => response.json())
.then(data => {

    document.getElementById(
        "totalCalculations"
    ).innerText =
        data.totalCalculations;

    document.getElementById(
        "averageScore"
    ).innerText =
        data.averageScore;

    document.getElementById(
        "totalAchievements"
    ).innerText =
        data.totalAchievements;

    document.getElementById(
        "performance"
    ).innerText =
        data.performance;

    createChart(data);

})
.catch(error => {

    console.error(error);

    alert(
        "Unable to load analytics"
    );
});

function createChart(data){

    const ctx =
        document.getElementById(
            "analyticsChart"
        );

    new Chart(ctx, {

        type: "bar",

        data: {

            labels: [

                "Calculations",

                "Average Score",

                "Achievements"

            ],

            datasets: [{

                label:
                "Student Analytics",

                data: [

                    data.totalCalculations,

                    data.averageScore,

                    data.totalAchievements

                ]

            }]
        }
    });
}