fetch(
    "http://localhost:8080/api/profile"
)
.then(response => response.json())
.then(data => {

    let html = `
    <div class="card">

        <h2>${data.studentName}</h2>

        <div class="level-box">

    <h3>
        ${data.level}
    </h3>

</div>

<p>

    <strong>XP Points:</strong>

    ${data.totalCalculations * 10}

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