fetch("http://localhost:8080/api/dashboard")

.then(response => response.json())

.then(data => {

    document.getElementById(
        "totalCalculations"
    ).innerText =
        data.totalCalculations;

    document.getElementById(
        "totalTopics"
    ).innerText =
        data.totalTopics;

    document.getElementById(
        "averageScore"
    ).innerText =
        data.averageScore;

    document.getElementById(
        "performance"
    ).innerText =
        data.performance;
})

.catch(error => {

    console.error(error);

    alert(
        "Unable to load dashboard data"
    );
});