fetch(
    "http://localhost:8080/api/profile"
)
.then(response => response.json())
.then(data => {

    let html = `
    <div class="card">

        <h2>${data.studentName}</h2>

        <p>
            <strong>Level:</strong>
            ${data.level}
        </p>

        <p>
            <strong>Total Calculations:</strong>
            ${data.totalCalculations}
        </p>

        <p>
            <strong>Average Score:</strong>
            ${data.averageScore.toFixed(2)}
        </p>

        <h3>
            Achievements
        </h3>

        <ul>
    `;

    data.achievements.forEach(a => {

        html += `<li>${a}</li>`;
    });

    html += `
        </ul>

    </div>
    `;

    document.getElementById(
        "profileCard"
    ).innerHTML = html;
});