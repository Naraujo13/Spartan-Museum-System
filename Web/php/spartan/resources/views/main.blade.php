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

     <!--Usuários-->
     <div id="Main-Usuarios" >
       <main class="mdl-layout__content">
         <div class="page-content">
           <header class="mdl-layout__header usersHeader">
             <div class="mdl-layout__header-row">
               <!-- Title -->
               <span class="mdl-layout-title">Usuários</span>
               <!-- Add spacer, to align navigation to the right -->
               <div class="mdl-layout-spacer"></div>
               <!-- Navigation. We hide it in small screens. -->
                 <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable
                           mdl-textfield--floating-label mdl-textfield--align-right">
                     <label class="mdl-button mdl-js-button mdl-button--icon"
                            for="fixed-header-drawer-exp2">
                         <i class="material-icons">search</i>
                     </label>
                     <div class="mdl-textfield__expandable-holder">
                         <input class="mdl-textfield__input" type="text" name="sample"
                                id="fixed-header-drawer-exp2">
                     </div>
                 </div>
             </div>
           </header>
              <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp fullwidth">
              <thead>
              
               <tr>
                 <th class="mdl-data-table__cell--non-numeric table-icon"></th>
                 <th class="mdl-data-table__cell--non-numeric login-table">Nome</th>
                 <th class="mdl-data-table__cell--non-numeric">CPF</th>
                 <th class="mdl-data-table__cell--non-numeric">Função</th>
               </tr>
              </thead>
              <tbody>
              @foreach ($users as $user)
                   <tr onclick="location.href='#';">
                   <td class="mdl-data-table__cell--non-numeric table-icon"><img src="icons/usuario.svg"></td>
                   <td class="mdl-data-table__cell--non-numeric ">{{$user->name}}</td>
                   <td class="mdl-data-table__cell--non-numeric">{{$user->cpf}}</td>
                   <td class="mdl-data-table__cell--non-numeric">{{$user->fuction}}</td>
                   </tr>
                 @endforeach
               <tr onclick="location.href='#';">
                 <td class="mdl-data-table__cell--non-numeric table-icon"><img src="icons/usuario.svg"></td>
                 <td class="mdl-data-table__cell--non-numeric ">Admin</td>
                 <td class="mdl-data-table__cell--non-numeric">000.000.000-00</td>
                 <td class="mdl-data-table__cell--non-numeric">Coordenador</td>
               </tr>
               <tr onclick="location.href='#';">
                 <td class="mdl-data-table__cell--non-numeric table-icon"><img src="icons/usuario.svg"></td>
                 <td class="mdl-data-table__cell--non-numeric ">Paulo</td>
                 <td class="mdl-data-table__cell--non-numeric">111.111.111-11</td>
                 <td class="mdl-data-table__cell--non-numeric">Diretor</td>
               </tr>
               <tr onclick="location.href='#';">
                 <td class="mdl-data-table__cell--non-numeric table-icon"><img src="icons/usuario.svg"></td>
                 <td class="mdl-data-table__cell--non-numeric ">Nícolas</td>
                 <td class="mdl-data-table__cell--non-numeric">033.690.375-71</td>
                 <td class="mdl-data-table__cell--non-numeric">Técnico</td>
               </tr>
              </tbody>
              </table>
          </div>
           <!-- Colored FAB button with ripple -->
           <button onclick="location.href='#';" class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored mdl-shadow--4dp" id="fabutton">
               <i class="material-icons">add</i>
           </button>
        </main>
      </div>

      <!--Coleções-->
      <div id="Main-Colecoes" >
        <main class="mdl-layout__content">
          <div class="page-content">
            <header class="mdl-layout__header collectionsHeader">
              <div class="mdl-layout__header-row">
                <!-- Title -->
                <span class="mdl-layout-title">Coleções</span>
                <!-- Add spacer, to align navigation to the right -->
                <div class="mdl-layout-spacer"></div>
                <!-- Navigation. We hide it in small screens. -->
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable
                            mdl-textfield--floating-label mdl-textfield--align-right">
                  <label class="mdl-button mdl-js-button mdl-button--icon"
                         for="fixed-header-drawer-exp3">
                    <i class="material-icons">search</i>
                  </label>
                  <div class="mdl-textfield__expandable-holder">
                    <input class="mdl-textfield__input" type="text" name="sample"
                           id="fixed-header-drawer-exp3">
                  </div>
                </div>
              </div>
            </header>
               <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp fullwidth">
               <thead>
                <tr>
                  <th class="mdl-data-table__cell--non-numeric table-icon"></th>
                  <th class="mdl-data-table__cell--non-numeric login-table">Nome</th>
                  <th class="mdl-data-table__cell--non-numeric">Museu</th>
                  <th class="mdl-data-table__cell--non-numeric">Tamanho (unid.)</th>
                </tr>
               </thead>
               <tbody>
                @foreach ($collections as $collection)
                   <tr onclick="location.href='#';">
                     <td class="mdl-data-table__cell--non-numeric table-icon"><img src="icons/colecao.svg"></td>
                     <td class="mdl-data-table__cell--non-numeric ">{{$collection->name}}</td>
                    
                     <td class="mdl-data-table__cell--non-numeric">{{$collection->museum->name}}</td>
                      
                     
                     <td class="mdl-data-table__cell--non-numeric">{{$collection->items()->count()}}</td>
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

       <!--Itens-->
       <div id="Main-Itens" >
         <main class="mdl-layout__content">
           <div class="page-content">
             <header class="mdl-layout__header collectionsHeader">
               <div class="mdl-layout__header-row">
                 <!-- Title -->
                 <span class="mdl-layout-title">Itens</span>
                 <!-- Add spacer, to align navigation to the right -->
                 <div class="mdl-layout-spacer"></div>
                 <!-- Navigation. We hide it in small screens. -->
                 <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable
                             mdl-textfield--floating-label mdl-textfield--align-right">
                   <label class="mdl-button mdl-js-button mdl-button--icon"
                          for="fixed-header-drawer-exp4">
                     <i class="material-icons">search</i>
                   </label>
                   <div class="mdl-textfield__expandable-holder">
                     <input class="mdl-textfield__input" type="text" name="sample"
                            id="fixed-header-drawer-exp4">
                   </div>
                 </div>
               </div>
             </header>
                <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp fullwidth">
                <thead>
                 <tr>
                   <th class="mdl-data-table__cell--non-numeric table-icon"></th>
                   <th class="mdl-data-table__cell--non-numeric login-table">Nome</th>
                   <th class="mdl-data-table__cell--non-numeric">ID</th>
                   <th class="mdl-data-table__cell--non-numeric">Coleção</th>
                   <th class="mdl-data-table__cell--non-numeric">Museu</th>
                   <th class="mdl-data-table__cell--non-numeric">Status</th>
                 </tr>
                </thead>
                <tbody>

                @foreach ($items as $item)
                   <tr onclick="location.href='#';">
                      <td class="mdl-data-table__cell--non-numeric table-icon"><img src="icons/itens.svg"></td>
                      <td class="mdl-data-table__cell--non-numeric ">{{$item->name}}</td>
                      <td class="mdl-data-table__cell--non-numeric">{{$item->itemId}}</td>
                      <td class="mdl-data-table__cell--non-numeric">{{$item->collection->name}}</td>
                      <td class="mdl-data-table__cell--non-numeric">{{$item->collection->museum->name}}</td>
                      <td class="mdl-data-table__cell--non-numeric">{{$item->status}}</td>

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

        <!--Movimentações-->
        <div id="Movimentacoes" hidden>
          <main class="mdl-layout__content">
            <div class="page-content">
              <header class="mdl-layout__header collectionsHeader">
                <div class="mdl-layout__header-row backPadding">
                  <!-- Title -->
                  <a href="#MainScreen-BemVindo" class="back" id="Back"><img src="icons/voltar.svg" class="logo"></a>
                  <span class="mdl-layout-title">Movimentações de {Nome do Item}</span>
                  <!-- Add spacer, to align navigation to the right -->
                  <div class="mdl-layout-spacer"></div>
                  <!-- Navigation. We hide it in small screens. -->
                  <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable
                              mdl-textfield--floating-label mdl-textfield--align-right">
                    <label class="mdl-button mdl-js-button mdl-button--icon"
                           for="fixed-header-drawer-exp5">
                      <i class="material-icons">search</i>
                    </label>
                    <div class="mdl-textfield__expandable-holder">
                      <input class="mdl-textfield__input" type="text" name="sample"
                             id="fixed-header-drawer-exp5">
                    </div>
                  </div>
                </div>
              </header>
                 <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp fullwidth">
                 <thead>
                  <tr>
                    <th class="mdl-data-table__cell--non-numeric table-icon"></th>
                    <th class="mdl-data-table__cell--non-numeric login-table">Tipo de movimentação</th>
                    <th class="mdl-data-table__cell--non-numeric">Timestamp</th>
                 </thead>
                 <tbody>
                  <tr>
                    <td class="mdl-data-table__cell--non-numeric table-icon"><img src="icons/entrada.svg"></td>
                    <td class="mdl-data-table__cell--non-numeric ">Entrada</td>
                    <td class="mdl-data-table__cell--non-numeric">08/08/2017 - 22:17:21</td>
                  </tr>
                  <tr>
                    <td class="mdl-data-table__cell--non-numeric table-icon"><img src="icons/emprestimo.svg"></td>
                    <td class="mdl-data-table__cell--non-numeric ">Empréstimo</td>
                    <td class="mdl-data-table__cell--non-numeric">08/08/2017 - 22:18:17</td>
                  </tr>
                  <tr>
                    <td class="mdl-data-table__cell--non-numeric table-icon"><img src="icons/armazenamento.svg"></td>
                    <td class="mdl-data-table__cell--non-numeric ">Armazenamento</td>
                    <td class="mdl-data-table__cell--non-numeric">08/08/2017 - 22:18:20</td>
                  </tr>
                  <tr>
                    <td class="mdl-data-table__cell--non-numeric table-icon"><img src="icons/restauracao.svg"></td>
                    <td class="mdl-data-table__cell--non-numeric ">Restauração</td>
                    <td class="mdl-data-table__cell--non-numeric">08/08/2017 - 22:18:30</td>
                  </tr>
                  <tr>
                    <td class="mdl-data-table__cell--non-numeric table-icon"><img src="icons/baixa.svg"></td>
                    <td class="mdl-data-table__cell--non-numeric ">Baixa</td>
                    <td class="mdl-data-table__cell--non-numeric">08/08/2017 - 22:19:15</td>
                  </tr>
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

<script src="js/changeDiv.js"></script>
</html>
