async function loadLeaderboard() {

    try {

        const response =
            await fetch(
                "http://localhost:8080/api/leaderboard"
            );

        const data =
            await response.json();

        const tbody =
            document.getElementById(
                "leaderboardBody"
            );

        tbody.innerHTML = "";

        data.forEach(student => {

            tbody.innerHTML += `
                <tr>
                    <td>${student.rank}</td>
                    <td>${student.studentName}</td>
                    <td>${student.score}</td>
                </tr>
            `;
        });

    }
    catch(error){

        console.error(error);
    }
}

loadLeaderboard();