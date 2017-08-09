$( "#Home" ).click(function() {
  $("#Main-Museus").hide("liniear");
  $("#Main-Usuarios").hide("liniear");
  $("#Main-Colecoes").hide("liniear");
  $("#Main-Itens").hide("liniear");
  $("#Colecao-Expandida").hide("liniear");
  $("#MainScreen-BemVindo").show("liniear");
});

$( "#museumLink" ).click(function() {
  $("#MainScreen-BemVindo").hide("liniear");
  $("#Main-Usuarios").hide("liniear");
  $("#Main-Colecoes").hide("liniear");
  $("#Main-Itens").hide("liniear");
  $("#Colecao-Expandida").hide("liniear");
  $("#Main-Museus").show("liniear");
});

$( "#usersLink" ).click(function() {
  $("#MainScreen-BemVindo").hide("liniear");
  $("#Main-Museus").hide("liniear");
  $("#Main-Colecoes").hide("liniear");
  $("#Main-Itens").hide("liniear");
  $("#Colecao-Expandida").hide("liniear");
  $("#Main-Usuarios").show("liniear");
});

$( "#collectionsLink" ).click(function() {
  $("#MainScreen-BemVindo").hide("liniear");
  $("#Main-Museus").hide("liniear");
  $("#Main-Usuarios").hide("liniear");
  $("#Main-Itens").hide("liniear");
  $("#Colecao-Expandida").hide("liniear");
  $("#Main-Colecoes").show("liniear")
});

$( "#itensLink" ).click(function() {
  $("#MainScreen-BemVindo").hide("liniear");
  $("#Main-Museus").hide("liniear");
  $("#Main-Usuarios").hide("liniear");
  $("#Main-Colecoes").hide("liniear");
  $("#Colecao-Expandida").hide("liniear");
  $("#Main-Itens").show("liniear");
});

$( ".collectionRow" ).click(function() {
  $("#MainScreen-BemVindo").hide("liniear");
  $("#Main-Museus").hide("liniear");
  $("#Main-Usuarios").hide("liniear");
  $("#Main-Colecoes").hide("liniear");
  $("#Main-Itens").hide("liniear");
  $("#Colecao-Expandida").show("liniear");
});

$( "#BackColecoes" ).click(function() {
  $("#MainScreen-BemVindo").hide("liniear");
  $("#Main-Museus").hide("liniear");
  $("#Main-Usuarios").hide("liniear");
  $("#Main-Itens").hide("liniear");
  $("#Colecao-Expandida").hide("liniear");
  $("#Main-Colecoes").show("liniear");
});
