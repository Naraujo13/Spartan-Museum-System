@extends('layouts.app')

@section('content')


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
@endsection