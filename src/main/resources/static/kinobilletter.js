function formSubmit() {
    const ticket = {
        etternavn: $("#etternavn").val(),
        fornavn: $("#fornavn").val(),
        film: $("#film").val(),
        antall: $("#antall").val(),
        telefon: $("#telefon").val(),
        epost: $("#epost").val(),
    };

    const telefonRegex = /^[0-9]{3} [0-9]{2} [0-9]{3}|[0-9]{8}$/;
    if (!telefonRegex.test(ticket.telefon)) {
        alert("Vennligst skriv et gyldig telefonnummer (8 siffer)");
        return;
    }

    const epostRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    if (!epostRegex.test(ticket.epost)) {
        alert("Vennligst skriv en gyldig epostadresse");
        return;
    }

    $.post("/lagre", ticket, function () {
        hentAlle();
    });
}

function hentAlle() {
    $.get("/hentAlle", function (ticket) {
        formatTickets(ticket);
    });
}

function formatTickets(Ticket) {
    let output = `
        <table>
            <tr>
                <th>Etternavn</th>
                <th>Fornavn</th>
                <th>Film</th>
                <th>Antall</th>
                <th>Telefonnummer</th>
                <th>Epost</th>
            </tr>`;

    for (const ticket of Ticket) {
        output += `
            <tr>
                <td>${ticket.etternavn}</td>
                <td>${ticket.fornavn}</td>
                <td>${ticket.film}</td>
                <td>${ticket.antall}</td>
                <td>${ticket.telefon}</td>
                <td>${ticket.epost}</td>   
            </tr>`;
    }

    output += "</table>";
    $("#ticketsContainer").html(output);
}

function slettAlle() {
    $.get("/slettAlle", function () {
        hentAlle();
    });
}

