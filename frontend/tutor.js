async function loadTopic() {

    const topic =
        document.getElementById("topic")
        .value
        .trim();

    if (!topic) {

        alert("Enter a topic");

        return;
    }

    try {

        const response =
            await fetch(
                `http://localhost:8080/api/tutor/${topic}`
            );

        if (!response.ok) {

            throw new Error(
                "Server returned " +
                response.status
            );
        }

        const data =
            await response.json();

        document.getElementById(
            "content"
        ).innerHTML =

        `
        <div class="card">

            <h2>${data.topic}</h2>

            <h3>Explanation</h3>
            <p>${data.explanation}</p>

            <h3>Example</h3>
            <p>${data.example}</p>

            <h3>Quiz</h3>
            <p>${data.quiz}</p>

        </div>
        `;

    } catch (error) {

        console.error(error);

        document.getElementById(
            "content"
        ).innerHTML =

        `
        <div class="card">

            <h2>❌ Error</h2>

            <p>
            Could not load topic.
            </p>

            <p>
            ${error.message}
            </p>

        </div>
        `;
    }
}