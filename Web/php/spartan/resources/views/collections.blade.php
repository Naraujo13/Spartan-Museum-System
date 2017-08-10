@extends('layouts.app')

@section('content')
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
                     <td class="mdl-data-table__cell--non-numeric table-icon"><img src="/icons/colecao.svg"></td>
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
 @endsection
