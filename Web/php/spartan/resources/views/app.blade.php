<!doctype html>
<html lang="{{ app()->getLocale() }}">
    <head>

    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
    <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
    <link rel="stylesheet" href="css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

  </head>

  <body>
      <!-- Always shows a header, even in smaller screens. -->
    <!-- The drawer is always open in large screens. The header is always shown,
  even in small screens. -->
      <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header mdl-layout--fixed-drawer">
       <header class="mdl-layout__header">
         <div class="mdl-layout__header-row">
           <!-- Title -->
           <a href="#MainScreen-BemVindo" class="logo" id="Home"><img src="icons/spartan.png" class="logo"></a>
           <span class="mdl-layout-title">Spartan</span>
           <!-- Add spacer, to align navigation to the right -->
           <div class="mdl-layout-spacer"></div>
           <!-- Navigation. We hide it in small screens. -->
           <nav class="mdl-navigation mdl-layout--large-screen-only">
            <a class="mdl-navigation__link" href="">MINHA CONTA</a>
            <a class="mdl-navigation__link" href="">SAIR</a>
          </nav>
         </div>
       </header>
       <div class="mdl-layout__drawer">
         <nav class="mdl-navigation">
           <a class="mdl-navigation__link" href="#" id="museumLink"><img src="icons/museu.svg"><p class="itens">Museus</p></a>
           <a class="mdl-navigation__link" href="#" id="usersLink"><img src="icons/usuario.svg"><p class="itens">Usuários</p></a>
           <a class="mdl-navigation__link" href="#" id="collectionsLink"><img src="icons/colecao.svg"><p class="itens">Coleções</p></a>
           <a class="mdl-navigation__link" href="#" id="itensLink"><img src="icons/itens.svg"><p class="itens">Itens</p></a>
         </nav>
       </div>


       <!--Bem Vindo-->
       <div id="MainScreen-BemVindo">
         <main class="mdl-layout__content">
           <div class="page-content">
             <div class="page-content-int">
               <div class="title">
                 <img src="icons/spartan-green.png">
                 <h1>Seja bem vindo ao sistema de museus Spartan!</h1>
              </div>
              <div class="text">
                <p>
  Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum </p>
              </div>
            </div>
           </div>
         </main>
     </div>

     <!--Museus-->
     <div id="Main-Museus" >
       <main class="mdl-layout__content">
         <div class="page-content">
           <header class="mdl-layout__header collectionsHeader">
             <div class="mdl-layout__header-row">
               <!-- Title -->
               <span class="mdl-layout-title">Museus</span>
               <!-- Add spacer, to align navigation to the right -->
               <div class="mdl-layout-spacer"></div>
               <!-- Navigation. We hide it in small screens. -->
               <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable
                           mdl-textfield--floating-label mdl-textfield--align-right">
                 <label class="mdl-button mdl-js-button mdl-button--icon"
                        for="fixed-header-drawer-exp">
                   <i class="material-icons">search</i>
                 </label>
                 <div class="mdl-textfield__expandable-holder">
                   <input class="mdl-textfield__input" type="text" name="sample"
                          id="fixed-header-drawer-exp">
                 </div>
               </div>
             </div>
           </header>
              <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp fullwidth">
              <thead>
               <tr>
                 <th class="mdl-data-table__cell--non-numeric table-icon"></th>
                 <th class="mdl-data-table__cell--non-numeric login-table">Nome</th>
                 <th class="mdl-data-table__cell--non-numeric">Endereço</th>
               </tr>
              </thead>
              <tbody>
                 @foreach ($museums as $museum)
                   <tr onclick="location.href='#';">
                     <td class="mdl-data-table__cell--non-numeric table-icon"><img src="icons/museu.svg"></td>
                     <td class="mdl-data-table__cell--non-numeric ">{{$museum->name}}</td>
                     <td class="mdl-data-table__cell--non-numeric">{{$museum->address}}</td>
                   </tr>
                 @endforeach
              </tbody>
              </table>
          </div>
           <!-- Colored FAB button with ripple -->
           <button onclick="location.href='#';" class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored mdl-shadow--4dp" id="fabutton">
               <i class="material-icons">add</i>
           </button>
        </main>
      </div>
    </div>
  </body>
  </div>
  </body>

<script src="js/changeDiv.js"></script>
</html>
