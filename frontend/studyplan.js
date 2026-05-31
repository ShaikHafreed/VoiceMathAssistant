const planDiv =
    document.getElementById(
        "plan"
    );

fetch(
    "http://localhost:8080/api/study-plan"
)
.then(response => response.json())
.then(data => {

    planDiv.innerHTML = "";

    data.weekPlan.forEach(item => {

        planDiv.innerHTML +=
        `
        <div class="plan-card">
            ${item}
        </div>
        `;
    });
})
.catch(error => {

    console.error(error);

    planDiv.innerHTML =
        "Failed to load plan";
});