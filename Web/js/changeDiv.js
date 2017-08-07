$( "#Home" ).click(function() {
  $("#Main-Usuarios").hide("liniear");
  $("#MainScreen-BemVindo").show("liniear");
});

$( "#usersLink" ).click(function() {
  $("#MainScreen-BemVindo").hide("liniear");
  $("#Main-Usuarios").show("liniear");
});
