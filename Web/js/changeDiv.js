$( "#Home" ).click(function() {
  $("#Main-Museus").hide("liniear");
  $("#Editar-Usuario").hide("liniear");
  $("#Main-Usuarios").hide("liniear");
  $("#Main-Colecoes").hide("liniear");
  $("#Main-Itens").hide("liniear");
  $("#Colecao-Expandida").hide("liniear");
  $("#Item-Expandido").hide("liniear");
  $("#Movimentacoes").hide("liniear");
  $("#Usuario-Expandido").hide("liniear");
  $("#MainScreen-BemVindo").show("liniear");
});

$( "#museumLink" ).click(function() {
  $("#MainScreen-BemVindo").hide("liniear");
  $("#Main-Usuarios").hide("liniear");
  $("#Main-Colecoes").hide("liniear");
  $("#Main-Itens").hide("liniear");
  $("#Colecao-Expandida").hide("liniear");
  $("#Editar-Usuario").hide("liniear");
  $("#Item-Expandido").hide("liniear");
  $("#Movimentacoes").hide("liniear");
  $("#Usuario-Expandido").hide("liniear");
  $("#Main-Museus").show("liniear");
});

$( "#usersLink" ).click(function() {
  $("#MainScreen-BemVindo").hide("liniear");
  $("#Main-Museus").hide("liniear");
  $("#Main-Colecoes").hide("liniear");
  $("#Main-Itens").hide("liniear");
  $("#Editar-Usuario").hide("liniear");
  $("#Colecao-Expandida").hide("liniear");
  $("#Item-Expandido").hide("liniear");
  $("#Movimentacoes").hide("liniear");
  $("#Usuario-Expandido").hide("liniear");
  $("#Main-Usuarios").show("liniear");
});

$( "#collectionsLink" ).click(function() {
  $("#MainScreen-BemVindo").hide("liniear");
  $("#Main-Museus").hide("liniear");
  $("#Main-Usuarios").hide("liniear");
  $("#Editar-Usuario").hide("liniear");
  $("#Main-Itens").hide("liniear");
  $("#Colecao-Expandida").hide("liniear");
  $("#Item-Expandido").hide("liniear");
  $("#Movimentacoes").hide("liniear");
  $("#Usuario-Expandido").hide("liniear");
  $("#Main-Colecoes").show("liniear")
});

$( "#itensLink" ).click(function() {
  $("#MainScreen-BemVindo").hide("liniear");
  $("#Main-Museus").hide("liniear");
  $("#Editar-Usuario").hide("liniear");
  $("#Main-Usuarios").hide("liniear");
  $("#Main-Colecoes").hide("liniear");
  $("#Colecao-Expandida").hide("liniear");
  $("#Item-Expandido").hide("liniear");
  $("#Movimentacoes").hide("liniear");
  $("#Usuario-Expandido").hide("liniear");
  $("#Main-Itens").show("liniear");
});

$( ".collectionRow" ).click(function() {
  $("#MainScreen-BemVindo").hide("liniear");
  $("#Main-Museus").hide("liniear");
  $("#Main-Usuarios").hide("liniear");
  $("#Main-Colecoes").hide("liniear");
  $("#Editar-Usuario").hide("liniear");
  $("#Main-Itens").hide("liniear");
  $("#Item-Expandido").hide("liniear");
  $("#Movimentacoes").hide("liniear");
  $("#Usuario-Expandido").hide("liniear");
  $("#Colecao-Expandida").show("liniear");
});

$( "#BackColecoes" ).click(function() {
  $("#MainScreen-BemVindo").hide("liniear");
  $("#Main-Museus").hide("liniear");
  $("#Main-Usuarios").hide("liniear");
  $("#Main-Itens").hide("liniear");
  $("#Editar-Usuario").hide("liniear");
  $("#Colecao-Expandida").hide("liniear");
  $("#Item-Expandido").hide("liniear");
  $("#Movimentacoes").hide("liniear");
  $("#Usuario-Expandido").hide("liniear");
  $("#Main-Colecoes").show("liniear");
});

$( ".itensRow" ).click(function() {
  $("#MainScreen-BemVindo").hide("liniear");
  $("#Main-Museus").hide("liniear");
  $("#Main-Usuarios").hide("liniear");
  $("#Main-Colecoes").hide("liniear");
  $("#Editar-Usuario").hide("liniear");
  $("#Main-Itens").hide("liniear");
  $("#Colecao-Expandida").hide("liniear");
  $("#Movimentacoes").hide("liniear");
  $("#Usuario-Expandido").hide("liniear");
  $("#Item-Expandido").show("liniear");
});

$( "#BackItem" ).click(function() {
  $("#MainScreen-BemVindo").hide("liniear");
  $("#Main-Museus").hide("liniear");
  $("#Main-Usuarios").hide("liniear");
  $("#Editar-Usuario").hide("liniear");
  $("#Colecao-Expandida").hide("liniear");
  $("#Item-Expandido").hide("liniear");
  $("#Usuario-Expandido").hide("liniear");
  $("#Movimentacoes").hide("liniear");
  $("#Main-Colecoes").hide("liniear");
  $("#Main-Itens").show("liniear");
});

$( "#MovimentationButton" ).click(function() {
  $("#MainScreen-BemVindo").hide("liniear");
  $("#Main-Museus").hide("liniear");
  $("#Editar-Usuario").hide("liniear");
  $("#Main-Usuarios").hide("liniear");
  $("#Colecao-Expandida").hide("liniear");
  $("#Item-Expandido").hide("liniear");
  $("#Main-Colecoes").hide("liniear");
  $("#Usuario-Expandido").hide("liniear");
  $("#Movimentacoes").show("liniear");
});

$( "#Back" ).click(function() {
  $("#MainScreen-BemVindo").hide("liniear");
  $("#Main-Museus").hide("liniear");
  $("#Editar-Usuario").hide("liniear");
  $("#Main-Usuarios").hide("liniear");
  $("#Colecao-Expandida").hide("liniear");
  $("#Main-Colecoes").hide("liniear");
  $("#Movimentacoes").hide("liniear");
  $("#Usuario-Expandido").hide("liniear");
  $("#Item-Expandido").show("liniear");
});

$( ".usersRow" ).click(function() {
  $("#MainScreen-BemVindo").hide("liniear");
  $("#Main-Museus").hide("liniear");
  $("#Main-Usuarios").hide("liniear");
  $("#Main-Colecoes").hide("liniear");
  $("#Main-Itens").hide("liniear");
  $("#Item-Expandido").hide("liniear");
  $("#Editar-Usuario").hide("liniear");
  $("#Movimentacoes").hide("liniear");
  $("#Colecao-Expandida").hide("liniear");
  $("#Usuario-Expandido").show("liniear");
});

$( "#BackUsers" ).click(function() {
  $("#MainScreen-BemVindo").hide("liniear");
  $("#Main-Museus").hide("liniear");
  $("#Main-Itens").hide("liniear");
  $("#Colecao-Expandida").hide("liniear");
  $("#Item-Expandido").hide("liniear");
  $("#Movimentacoes").hide("liniear");
  $("#Main-Colecoes").hide("liniear");
  $("#Usuario-Expandido").hide("liniear");
  $("#Main-Usuarios").show("liniear");
  $("#Editar-Usuario").hide("liniear");

});

$( "#ConfirmEdit" ).click(function() {
  $("#MainScreen-BemVindo").hide("liniear");
  $("#Main-Museus").hide("liniear");
  $("#Main-Itens").hide("liniear");
  $("#Colecao-Expandida").hide("liniear");
  $("#Item-Expandido").hide("liniear");
  $("#Movimentacoes").hide("liniear");
  $("#Main-Colecoes").hide("liniear");
  $("#Usuario-Expandido").show("liniear");
  $("#Main-Usuarios").hide("liniear");
  $("#Editar-Usuario").hide("liniear");
});

$( "#BackEditUsers" ).click(function() {
  $("#MainScreen-BemVindo").hide("liniear");
  $("#Main-Museus").hide("liniear");
  $("#Main-Itens").hide("liniear");
  $("#Colecao-Expandida").hide("liniear");
  $("#Item-Expandido").hide("liniear");
  $("#Movimentacoes").hide("liniear");
  $("#Main-Colecoes").hide("liniear");
  $("#Usuario-Expandido").show("liniear");
  $("#Editar-Usuario").hide("liniear");
  $("#Main-Usuarios").hide("liniear");
});

$( "#EditUsers" ).click(function() {
  $("#MainScreen-BemVindo").hide("liniear");
  $("#Main-Museus").hide("liniear");
  $("#Main-Itens").hide("liniear");
  $("#Colecao-Expandida").hide("liniear");
  $("#Item-Expandido").hide("liniear");
  $("#Movimentacoes").hide("liniear");
  $("#Main-Colecoes").hide("liniear");
  $("#Usuario-Expandido").hide("liniear");
  $("#Main-Usuarios").hide("liniear");
  $("#Editar-Usuario").show("liniear");
});
