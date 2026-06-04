fetch(
    "http://localhost:8080/api/recommendation"
)
.then(response => response.json())
.then(data => {

    let html = `
    <div class="card">

        <h2>${data.topic}</h2>

        <p>${data.reason}</p>

        <h3>Recommended Topics</h3>

        <ul>
    `;

    data.suggestions.forEach(topic => {

        html += `
        <li>${topic}</li>
        `;
    });

    html += `
        </ul>

    </div>
    `;

    document.getElementById(
        "recommendation"
    ).innerHTML = html;
})
.catch(error => {

    console.error(error);

    document.getElementById(
        "recommendation"
    ).innerHTML =
        "Failed to load recommendation.";
});