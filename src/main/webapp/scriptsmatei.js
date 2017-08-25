function afisare(lista){
    var randuri = "";
    lista.forEach(function(obiect){
        randuri += "<tr>" +
            "<td>" + obiect.obiect + "</td>" +
            "<td>" + obiect.locatie + "</td>" +
            "</tr>";
    });
    $("#obiecte").html(randuri);
}

$.ajax("neverforget?action=list", {
    cache: false
}).done(function(lista){
    console.info("a venit lista", lista);
    afisare(lista.tasks);
});











