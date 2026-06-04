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

const toggleSpeechBtn =
    document.getElementById("toggleSpeechBtn");

let speechEnabled = true;

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
    recognition.continuous = false;
    recognition.interimResults = false;

    let isListening = false;

    voiceBtn.addEventListener(
        "click",
        () => {

            if (isListening) {
                return;
            }

            recognition.start();
        }
    );

    recognition.onstart = () => {

        isListening = true;

        voiceBtn.innerText =
            "🎙 Listening...";
    };

recognition.onresult = (event) => {

    const transcript =
        event.results[0][0].transcript;

    expressionInput.value =
        transcript;

    setTimeout(() => {
        calculateExpression();
    }, 300);
};

recognition.onerror = (event) => {

    console.log("Speech Error:", event.error);

    isListening = false;

    voiceBtn.innerText =
        "🎙 Start Voice";
};

recognition.onend = () => {

    isListening = false;

    voiceBtn.innerText =
        "🎙 Start Voice";
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
<div class="answer-card">

    <h2>✅ Answer</h2>

    <p class="answer">
        ${data.result}
    </p>

    <div class="explanation">

        <h3>
        📚 Step By Step Solution
        </h3>

        <pre>
${data.steps}
        </pre>

    </div>

</div>
`;

addHistory(
    data.expression,
    data.result
);
updateDashboard();

speakResult(
    "The answer is " +
    data.result
);

expressionInput.value = "";

    } catch (error) {

        console.error(error);

        resultDiv.innerHTML =
            "Server Error";
    }
}

// ==========================
// OCR Scanner
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
            "Please select an image"
        );

        return;
    }

    const formData =
        new FormData();

    formData.append(
        "file",
        fileInput.files[0]
    );

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
            <h2>OCR Result</h2>

            <p>${data.ocrText}</p>

            <h3>Expression</h3>

            <p>${data.expression}</p>

            <h3>Answer</h3>

            <p>${data.result}</p>
            `;

        addHistory(
            data.expression,
            data.result
        );

        speakResult(
            "The answer is " +
            data.result
        );

    } catch (error) {

        console.error(error);

        resultDiv.innerHTML =
            "OCR Failed";
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

// ==========================
// Memory
// ==========================

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

            html +=
                `
                <div class="memory-card">

                    <b>You:</b>
                    ${memory.userInput}

                    <br><br>

                    <b>Assistant:</b>
                    ${memory.assistantResponse}

                </div>
                `;
        });

        html +=
            `
            <button onclick="clearMemory()">
                Clear Memory
            </button>
            `;

        resultDiv.innerHTML =
            html;

    } catch (error) {

        resultDiv.innerHTML =
            "Unable to load memory";
    }
}

async function clearMemory() {

    await fetch(
        "http://localhost:8080/api/memory",
        {
            method: "DELETE"
        }
    );

    showMemory();
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
// Dashboard
// ==========================

function openDashboard() {

    window.open(
        "dashboard.html",
        "_blank"
    );
}

// ==========================
// Analytics
// ==========================

function openAnalytics() {

    window.open(
        "analytics.html",
        "_blank"
    );
}

// ==========================
// Profile
// ==========================

function openProfile() {

    window.open(
        "profile.html",
        "_blank"
    );
}

// ==========================
// Progress
// ==========================

function showProgress() {

    openAnalytics();
}

// ==========================
// Voice Output
// ==========================

function speakResult(text) {

    if (!speechEnabled) {
        return;
    }

    window.speechSynthesis.cancel();

    const speech =
        new SpeechSynthesisUtterance(
            text
        );

    speech.lang = "en-US";

    speech.rate = 1;

    speech.pitch = 1;

    speech.volume = 1;

    window.speechSynthesis.speak(
        speech
    );
}

// ==========================
// Voice Toggle
// ==========================

if (toggleSpeechBtn) {

    toggleSpeechBtn.addEventListener(
        "click",
        () => {

            speechEnabled =
                !speechEnabled;

            toggleSpeechBtn.innerText =
                speechEnabled
                    ? "🔊 Voice ON"
                    : "🔇 Voice OFF";
        }
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

// ==========================
// Recommendation
// ==========================

function openRecommendation() {

    window.open(
        "recommendation.html",
        "_blank"
    );
}

// ==========================
// Report
// ==========================

function openReport() {

    window.location.href =
        "report.html";
}

// ==========================
// Study Planner
// ==========================

function openStudyPlan() {

    window.location.href =
        "studyplan.html";
}

// ==========================
// Leaderboard
// ==========================

function openLeaderboard() {

    window.location.href =
        "leaderboard.html";
}

// ==========================
// History Page
// ==========================

function openHistory() {

    window.location.href =
        "history.html";
}

// ==========================
// Removed AI Tutor
// ==========================

function teachTopic() {

    resultDiv.innerHTML =
        `
        <h2>📚 AI Tutor Removed</h2>

        <p>
        Gemini integration has been removed.
        This feature is currently disabled.
        </p>
        `;
}
function openTutor() {

    window.location.href =
        "tutor.html";
}