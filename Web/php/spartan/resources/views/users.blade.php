@extends('layouts.app')

@section('content')

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


@endsection