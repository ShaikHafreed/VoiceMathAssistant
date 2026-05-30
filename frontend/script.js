const expressionInput =
    document.getElementById("expression");

const resultDiv =
    document.getElementById("result");

const historyList =
    document.getElementById("history");

const voiceBtn =
    document.getElementById("voiceBtn");

const calculateBtn =
    document.getElementById("calculateBtn");

const clearBtn =
    document.getElementById("clearBtn");

// ==========================
// Voice Recognition
// ==========================

const SpeechRecognition =
    window.SpeechRecognition ||
    window.webkitSpeechRecognition;

if (SpeechRecognition) {

    const recognition =
        new SpeechRecognition();

    recognition.lang = "en-US";

    voiceBtn.addEventListener(
        "click",
        () => {
            recognition.start();
        }
    );

    recognition.onresult =
        (event) => {

            const speech =
                event.results[0][0].transcript;

            expressionInput.value =
                speech;
        };

} else {

    voiceBtn.disabled = true;
}

// ==========================
// Calculate
// ==========================

calculateBtn.addEventListener(
    "click",
    calculateExpression
);

async function calculateExpression() {

    const speech =
        expressionInput.value.trim();

    if (!speech) {

        resultDiv.innerHTML =
            "Please enter an expression";

        return;
    }

    try {

        const response =
            await fetch(
                "http://localhost:8080/api/calculate",
                {
                    method: "POST",
                    headers: {
                        "Content-Type":
                            "application/json"
                    },
                    body: JSON.stringify({
                        speech: speech
                    })
                }
            );

        const data =
            await response.json();

        resultDiv.innerHTML =
            `
            <h3>Answer</h3>
            <p>${data.result}</p>
            `;

        addHistory(
            data.expression,
            data.result
        );

        speakResult(
            data.result
        );

    } catch (error) {

        console.error(error);

        resultDiv.innerHTML =
            "Server Error";
    }
}

// ==========================
// OCR Math Scanner
// ==========================

async function scanOCRImage() {

    const fileInput =
        document.getElementById(
            "ocrFile"
        );

    if (
        !fileInput.files ||
        fileInput.files.length === 0
    ) {

        alert(
            "Please select an image first"
        );

        return;
    }

    const formData =
        new FormData();

    formData.append(
        "file",
        fileInput.files[0]
    );

    resultDiv.innerHTML =
        "Scanning image...";

    try {

        const response =
            await fetch(
                "http://localhost:8080/api/ocr-math",
                {
                    method: "POST",
                    body: formData
                }
            );

        const data =
            await response.json();

        resultDiv.innerHTML =
            `
            <h3>OCR Text</h3>
            <p>${data.ocrText}</p>

            <h3>Expression</h3>
            <p>${data.expression}</p>

            <h3>Result</h3>
            <p>${data.result}</p>
            `;

        addHistory(
            data.expression,
            data.result
        );

    } catch(error) {

        console.error(error);

        resultDiv.innerHTML =
            "OCR Processing Failed";
    }
}

// ==========================
// History
// ==========================

function addHistory(
    expression,
    result
) {

    const li =
        document.createElement("li");

    li.innerHTML =
        `<b>${expression}</b> = ${result}`;

    historyList.prepend(li);
}

function openHistory() {

    window.open(
        "http://localhost:8080/api/history",
        "_blank"
    );
}

// ==========================
// Dashboard
// ==========================

function openDashboard() {

    window.open(
        "dashboard.html",
        "_blank"
    );
}

// ==========================
// Teach Me
// ==========================

async function teachTopic() {

    const topic =
        prompt(
            "Enter Topic"
        );

    if (!topic) {
        return;
    }

    try {

        const response =
            await fetch(
                `http://localhost:8080/api/tutor/${topic}`
            );

        const data =
            await response.text();

        resultDiv.innerHTML =
            data.replace(
                /\n/g,
                "<br>"
            );

    } catch(error) {

        resultDiv.innerHTML =
            "Unable to load lesson";
    }
}

// ==========================
// Progress
// ==========================

function showProgress() {

    resultDiv.innerHTML =
        `
        <h3>Learning Progress</h3>
        <p>Feature Available In Dashboard</p>
        `;
}

// ==========================
// Memory
// ==========================

function showMemory() {

    resultDiv.innerHTML =
        `
        <h3>Conversation Memory</h3>
        <p>Coming Soon</p>
        `;
}

// ==========================
// Quiz
// ==========================

function startQuiz() {

    window.open(
        "quiz.html",
        "_blank"
    );
}
// ==========================
// Speak Result
// ==========================

function speakResult(text) {

    const speech =
        new SpeechSynthesisUtterance(
            text
        );

    speech.lang =
        "en-US";

    window.speechSynthesis.speak(
        speech
    );
}

// ==========================
// Clear
// ==========================

clearBtn.addEventListener(
    "click",
    () => {

        expressionInput.value =
            "";

        resultDiv.innerHTML =
            "Waiting...";

        historyList.innerHTML =
            "";
    }
);
async function showMemory() {

    try {

        const response =
            await fetch(
                "http://localhost:8080/api/memory"
            );

        const memories =
            await response.json();

        if (memories.length === 0) {

            resultDiv.innerHTML =
                "<h3>No Memory Available</h3>";

            return;
        }

        let html =
            "<h2>🧠 Conversation Memory</h2>";

        memories.reverse().forEach(memory => {

            html += `
            <div style="
                background:#f5f5f5;
                padding:15px;
                margin:10px 0;
                border-radius:10px;
            ">
                <b>You:</b>
                ${memory.userInput}
                <br><br>
                <b>Assistant:</b>
                ${memory.assistantResponse}
            </div>
            `;
        });

        html += `
            <button onclick="clearMemory()">
                Clear Memory
            </button>
        `;

        resultDiv.innerHTML = html;

    } catch(error) {

        console.error(error);

        resultDiv.innerHTML =
            "Unable to load memory";
    }
}
async function clearMemory() {

    const confirmDelete =
        confirm(
            "Delete all memory?"
        );

    if (!confirmDelete) {
        return;
    }

    await fetch(
        "http://localhost:8080/api/memory",
        {
            method: "DELETE"
        }
    );

    showMemory();
}