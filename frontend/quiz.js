let currentQuestion = "";

loadQuestion();

async function loadQuestion() {

    try {

        const response =
            await fetch(
                "http://localhost:8080/api/quiz"
            );

        const data =
            await response.json();

        currentQuestion =
            data.question;

        document.getElementById(
            "question"
        ).innerText =
            data.question;

    } catch(error) {

        console.error(error);

        document.getElementById(
            "question"
        ).innerText =
            "Unable to load quiz";
    }
}

async function submitAnswer() {

    const answer =
        document.getElementById(
            "answer"
        ).value;

    try {

        const response =
            await fetch(
                "http://localhost:8080/api/quiz/submit",
                {
                    method:"POST",

                    headers:{
                        "Content-Type":
                        "application/json"
                    },

                    body:JSON.stringify({
                        answer:answer
                    })
                }
            );

        const data =
            await response.json();

        document.getElementById(
            "result"
        ).innerHTML =
        `
        ${data.message}<br>
        Score : ${data.score}
        `;

    } catch(error){

        console.error(error);

        document.getElementById(
            "result"
        ).innerText =
            "Submission Failed";
    }
}