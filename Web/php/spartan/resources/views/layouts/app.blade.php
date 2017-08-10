<!doctype html>
<html lang="{{ app()->getLocale() }}">
    <head>

    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
    <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
    <link rel="stylesheet" href="/css/style.css">
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
           <a href="#MainScreen-BemVindo" class="logo" id="Home"><img src="/icons/spartan.png" class="logo"></a>
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
           <a class="mdl-navigation__link" href="#" id="museumLink"><img src="/icons/museu.svg"><p class="itens">Museus</p></a>
           <a class="mdl-navigation__link" href="#" id="usersLink"><img src="/icons/usuario.svg"><p class="itens">Usuários</p></a>
           <a class="mdl-navigation__link" href="#" id="collectionsLink"><img src="/icons/colecao.svg"><p class="itens">Coleções</p></a>
           <a class="mdl-navigation__link" href="#" id="itensLink"><img src="/icons/itens.svg"><p class="itens">Itens</p></a>
         </nav>
       </div>

     @yield('content')

    </div>
  </body>
  </div>
  </body>

<script src="js/changeDiv.js"></script>
</html>
