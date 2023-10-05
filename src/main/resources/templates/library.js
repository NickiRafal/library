document.addEventListener("DOMContentLoaded", function () {
    const readerForm = document.getElementById("readerForm");
    const readersTable = document.getElementById("readersTable").getElementsByTagName("tbody")[0];

    // Funkcja do wczytywania listy czytelników
    function loadReaders() {
        fetch("/library/readers")
            .then(response => response.json())
            .then(data => {
                // Wyczyszczenie tabeli przed dodaniem nowych danych
                while (readersTable.firstChild) {
                    readersTable.removeChild(readersTable.firstChild);
                }

                data.forEach(reader => {
                    addReaderToTable(reader.name);
                });
            })
            .catch(error => {
                console.error("Błąd podczas wczytywania danych o czytelnikach:", error);
            });
    }

    // Obsługa dodawania nowego czytelnika
    readerForm.addEventListener("submit", function (event) {
        event.preventDefault();

        const nameInput = document.getElementById("name");
        const name = nameInput.value;

        // Wysłanie danych do serwera
        fetch("/library/readers", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ name: name })
        })
            .then(response => response.json())
            .then(data => {
                // Po pomyślnym dodaniu czytelnika, odśwież listę czytelników
                loadReaders();

                // Wyczyść pole do wprowadzania danych
                nameInput.value = "";
            })
            .catch(error => {
                console.error("Błąd podczas dodawania czytelnika:", error);
            });
    });

    // Funkcja do dodawania czytelnika do tabeli
    function addReaderToTable(name) {
        const newRow = readersTable.insertRow();
        const cell = newRow.insertCell(0);
        cell.textContent = name;
    }

    // Wczytaj listę czytelników przy uruchomieniu strony
    loadReaders();
});
