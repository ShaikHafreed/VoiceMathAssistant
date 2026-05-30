async function loadHistory() {

    try {

        const response =
            await fetch(
                "http://localhost:8080/api/history"
            );

        const data =
            await response.json();

        const table =
            document.getElementById(
                "historyTable"
            );

        table.innerHTML = "";

        data.reverse().forEach(item => {

            const row =
                document.createElement("tr");

            row.innerHTML = `
                <td>${item.id}</td>
                <td>${item.expression}</td>
                <td>${item.result}</td>
            `;

            table.appendChild(row);
        });

    } catch (error) {

        console.error(error);

        alert(
            "Unable to load history"
        );
    }
}

loadHistory();