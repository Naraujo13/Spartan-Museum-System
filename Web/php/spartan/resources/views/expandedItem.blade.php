@extends('layouts.app')

@section('content')
      <!--Item Expandido-->
       <div id="Item-Expandido">
         <main class="mdl-layout__content">
           <div class="page-content">
             <div class="demo-card-wide mdl-card mdl-shadow--2dp collectionCard">
               <div class="mdl-card__title">

                 <h2 class="mdl-card__title-text title">{{$item->name}}</h2>
               </div>
               <div class="mdl-card__supporting-text informacoesGerais">
                 <img src="/icons/vasoAzul.jpg" class="fotoItem">
                 <h2 class="mdl-card__title-text">Informações Principais:</h2>
                   <div class="Informacao">
                    <span class="tituloInformacao"> ID: </span> <span> {{$item->itemId}} </span>
                  </div>
                  <div class="Informacao">
                  
                   <span class="tituloInformacao"> Coleção: </span> <span>{{$item->collectionId}}</span>
                  </div>
                  <div class="Informacao">
                    <span class="tituloInformacao"> Museu: </span> <span> Museu 1</span>
                  </div>
                  <div class="Informacao">
                    <span class="tituloInformacao"> Ano: </span> <span> {{$item->year}} </span>
                  </div>
                  <div class="Informacao">
                    <span class="tituloInformacao"> Status: </span> <span> {{$item->year}} </span>
                  </div>
                  <div class="mdl-card__actions mdl-card--border borda">
                </div>
             </div>
             <div class="mdl-card__supporting-text Dimensões">
               <!-- Colored raised button -->
                <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored BotaoMovimentações" id="MovimentationButton">
                  Visualizar Movimentações
                </button>
               <h2 class="mdl-card__title-text">Dimensões:</h2>
                 <div class="Informacao">
                  <span class="tituloInformacao"> Altura: </span> <span class="Dimensão">  {{$item->height}} </span>
                  <span class="tituloInformacao"> Espessura: </span> <span>  {{$item->thickness}} </span>
                </div>
                <div class="Informacao">
                 <span class="tituloInformacao"> Largura: </span> <span class="Dimensão">  {{$item->width}} </span>
                 <span class="tituloInformacao"> Circunferência Interna: </span> <span>  {{$item->innerCircumference}} </span>
               </div>
               <div class="Informacao">
                <span class="tituloInformacao"> Comprimento: </span> <span class="Dimensão">  {{$item->lenght}} </span>
                <span class="tituloInformacao"> Circunferência Externa: </span> <span>  {{$item->outerCircumference}} </span>
              </div>
                <div class="mdl-card__actions mdl-card--border borda">
              </div>
           </div>
           <div class="mdl-card__supporting-text OutrasInformacoes">
             <h2 class="mdl-card__title-text">Outras Informações:</h2>
               <div class="Informacao">
                <span class="tituloInformacao"> Data de aquisição: </span> <span> {{$item->aquisitionDate}} </span>
              </div>
              <div class="Informacao">
               <span class="tituloInformacao"> Bibliografia: </span> <span>  {{$item->biography}} </span>
              </div>
              <div class="Informacao">
                <span class="tituloInformacao"> Estado de conservação: </span> <span>  {{$item->conservationState}} </span>
              </div>
              <div class="Informacao">
                <span class="tituloInformacao"> Contexto Histórico: </span> <span>  {{$item->historicalContext}} </span>
              </div>
              <div class="Informacao">
                <span class="tituloInformacao"> Descrição: </span>
                <p class="Descrição">   {{$item->description}}</p>
              </div>
         </div>
             <div class="mdl-card__menu">
                <a href="{{ URL::to('/editItem/' . $item->itemId) }}"  class="edit" id="EditItem"><img src="/icons/editar.svg" class="logo"></a>
            </div>
           </div>
           </div>
         </main>
     </div>
@endsection
