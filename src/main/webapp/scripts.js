
function afisare (lista) {
    var randuri = "";
    lista.forEach(function (obiect) {
        randuri += "<tr>" +
            "<td>" + obiect.obiect +"</td>" +
            "<td>" + obiect.locatie + "</td>" +
            "<td> <a href='neverforget?action=delete&id="+obiect.id+"'>x</a></td>" +
            "</tr>";
    });
    $("#obiect").html(randuri);
}
function cereLista(ordinea, cautaText) {
    $.ajax("neverforget?action=list", {
        cache: false,
        dataType: "json",
        data: {
            order: ordinea,
            search: cautaText
        }
    }).done(function (lista) {
        console.info("a venit lista ", lista);
        afisare(lista.tasks);
    });
}

cereLista("asc");
var sortareaAnterioara = 'asc';

function sorteazaNume(th){
    if(sortareaAnterioara == "asc"){
        cereLista("desc");
        th.innerHTML = "obiecte &uArr;";
        sortareaAnterioara = "desc";
    } else {
        cereLista("asc");
        th.innerHTML = "obiecte &dArr;";
        sortareaAnterioara = "asc";
    }
}

function SuntFata(){
    console.info("salut-sunt-fata");
    var body = document.getElementById("body");
    body.style.backgroundColor="pink";
}

function SuntBaiat(){
    console.info("salut-sunt-baiat");
    var body = document.getElementById("body");
    body.style.backgroundColor="lightblue";
}

function cauta(cautaText) {
    console.info("cauta ", cautaText);
    cereLista(sortareaAnterioara, cautaText);
}
