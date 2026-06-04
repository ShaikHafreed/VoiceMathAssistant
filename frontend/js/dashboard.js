let solvedCount = 0;

function updateDashboard() {

    solvedCount++;

    const total =
    document.getElementById(
        "totalSolved"
    );

    if(total){

        total.innerText =
        solvedCount;
    }
}