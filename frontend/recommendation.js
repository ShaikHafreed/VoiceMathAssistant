fetch(
    "http://localhost:8080/api/recommendation"
)
.then(response => response.json())
.then(data => {

    document.getElementById(
        "recommendation"
    ).innerHTML =
    `
    <div class="card">

        <h2>
            ${data.topic}
        </h2>

        <p>
            ${data.reason}
        </p>

    </div>
    `;
});