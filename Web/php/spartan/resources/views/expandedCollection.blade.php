  @extends('layouts.app')

  @section('content')

    <!--Coleção Expandida-->
    <div id="Colecao-Expandida">
           <main class="mdl-layout__content">
             <div class="page-content">
               <div class="demo-card-wide mdl-card mdl-shadow--2dp collectionCard">
                 <div class="mdl-card__title">
                   <a href="#Main-Colecoes" class="back" id="BackColecoes"><img src="/icons/voltar.svg" class="logo"></a>
                   <h2 class="mdl-card__title-text title">{{$collection->name}}</h2>
                 </div>
                 <div class="mdl-card__supporting-text">
                   <img src="/icons/colecao.svg" class="icon">
                   <h2 class="mdl-card__title-text">Informações Gerais:</h2>
                   <div class="mdl-card__actions mdl-card--border">
                     <div class="ID">
                      <span class="tituloInformacao"> ID: </span> <span> {{$collection->collectionId}} </span>
                    </div>
                    <div class="Nome">
                     <span class="tituloInformacao"> Nome: </span> <span> {{$collection->name}} </span>
                    </div>
                    <div class="IDMuseu">
                      <span class="tituloInformacao"> ID do Museu: </span> <span> {{$collection->codMuseum}} </span>
                    </div>
                  </div>
               </div>
               <div class="mdl-card__menu">
                  <a href="#Main-Colecoes" class="edit" id="Edit"><img src="/icons/editar.svg" class="logo"></a>
              </div>
             </div>
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
                <tr class="itensRow">
                  <td class="mdl-data-table__cell--non-numeric table-icon"><img src="/icons/itens.svg"></td>
                  <td class="mdl-data-table__cell--non-numeric ">Vaso Azul</td>
                  <td class="mdl-data-table__cell--non-numeric">VZA01</td>
                  <td class="mdl-data-table__cell--non-numeric">Vasos</td>
                  <td class="mdl-data-table__cell--non-numeric">Museu Normal</td>
                  <td class="mdl-data-table__cell--non-numeric">Em Estoque</td>
                </tr>
                <tr class="itensRow">
                  <td class="mdl-data-table__cell--non-numeric table-icon"><img src="/icons/itens.svg"></td>
                  <td class="mdl-data-table__cell--non-numeric ">Mona Lisa</td>
                  <td class="mdl-data-table__cell--non-numeric">MLA01</td>
                  <td class="mdl-data-table__cell--non-numeric">Picasso Copycat</td>
                  <td class="mdl-data-table__cell--non-numeric">Museu das Cópias</td>
                  <td class="mdl-data-table__cell--non-numeric">Emprestada</td>
                </tr>
                <tr class="itensRow">
                  <td class="mdl-data-table__cell--non-numeric table-icon"><img src="/icons/itens.svg"></td>
                  <td class="mdl-data-table__cell--non-numeric ">Escultura de Pedra</td>
                  <td class="mdl-data-table__cell--non-numeric">ESP01</td>
                  <td class="mdl-data-table__cell--non-numeric">Esculturas</td>
                  <td class="mdl-data-table__cell--non-numeric">Museu Normal</td>
                  <td class="mdl-data-table__cell--non-numeric">Em Estoque</td>
                </tr>
                <tr class="itensRow">
                  <td class="mdl-data-table__cell--non-numeric table-icon"><img src="/icons/itens.svg"></td>
                  <td class="mdl-data-table__cell--non-numeric ">Mona Crespa</td>
                  <td class="mdl-data-table__cell--non-numeric">MCA01</td>
                  <td class="mdl-data-table__cell--non-numeric">Picasso Copycat</td>
                  <td class="mdl-data-table__cell--non-numeric">Museu das Cópias</td>
                  <td class="mdl-data-table__cell--non-numeric">Em Exposição</td>
                </tr>
               </tbody>
               </table>
             </div>
           </main>
       </div>
@endsection
