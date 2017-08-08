$( "#Home" ).click(function() {
  $("#Main-Museus").hide("liniear");
  $("#Main-Usuarios").hide("liniear");
  $("#Main-Colecoes").hide("liniear");
  $("#Main-Itens").hide("liniear");
  $("#MainScreen-BemVindo").show("liniear");
});

$( "#museumLink" ).click(function() {
  $("#MainScreen-BemVindo").hide("liniear");
  $("#Main-Usuarios").hide("liniear");
  $("#Main-Colecoes").hide("liniear");
  $("#Main-Itens").hide("liniear");
  $("#Main-Museus").show("liniear");
});

$( "#usersLink" ).click(function() {
  $("#MainScreen-BemVindo").hide("liniear");
  $("#Main-Museus").hide("liniear");
  $("#Main-Colecoes").hide("liniear");
  $("#Main-Itens").hide("liniear");
  $("#Main-Usuarios").show("liniear");
});

$( "#collectionsLink" ).click(function() {
  $("#MainScreen-BemVindo").hide("liniear");
  $("#Main-Museus").hide("liniear");
  $("#Main-Usuarios").hide("liniear");
  $("#Main-Itens").hide("liniear");
  $("#Main-Colecoes").show("liniear")
});

$( "#itensLink" ).click(function() {
  $("#MainScreen-BemVindo").hide("liniear");
  $("#Main-Museus").hide("liniear");
  $("#Main-Usuarios").hide("liniear");
  $("#Main-Colecoes").hide("liniear");
  $("#Main-Itens").show("liniear");
});
