@extends('layouts.app')

@section('content')
      <!--Item Expandido-->
       <div id="Item-Expandido">
         <main class="mdl-layout__content">
           <div class="page-content">
             <div class="demo-card-wide mdl-card mdl-shadow--2dp collectionCard">
               <div class="mdl-card__title">
                 <a href="#Main-Colecoes" class="back" id="BackItem"><img src="icons/voltar.svg" class="logo"></a>
                 <h2 class="mdl-card__title-text title">[Nome do Item]</h2>
               </div>
               <div class="mdl-card__supporting-text informacoesGerais">
                 <img src="icons/vasoAzul.jpg" class="fotoItem">
                 <h2 class="mdl-card__title-text">Informações Principais:</h2>
                   <div class="Informacao">
                    <span class="tituloInformacao"> ID: </span> <span> [ID da obra] </span>
                  </div>
                  <div class="Informacao">
                   <span class="tituloInformacao"> Coleção: </span> <span> [Coleção da obra] </span>
                  </div>
                  <div class="Informacao">
                    <span class="tituloInformacao"> Museu: </span> <span> [Nome do Museu] </span>
                  </div>
                  <div class="Informacao">
                    <span class="tituloInformacao"> Ano: </span> <span> [Ano da obra] </span>
                  </div>
                  <div class="Informacao">
                    <span class="tituloInformacao"> Status: </span> <span> [Status da Obra] </span>
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
                  <span class="tituloInformacao"> Altura: </span> <span class="Dimensão"> [Altura da obra] </span>
                  <span class="tituloInformacao"> Espessura: </span> <span> [Espessura da obra] </span>
                </div>
                <div class="Informacao">
                 <span class="tituloInformacao"> Largura: </span> <span class="Dimensão"> [Largura da obra] </span>
                 <span class="tituloInformacao"> Circunferência Interna: </span> <span> [Circunferência interna da obra] </span>
               </div>
               <div class="Informacao">
                <span class="tituloInformacao"> Comprimento: </span> <span class="Dimensão"> [Comprimento da obra] </span>
                <span class="tituloInformacao"> Circunferência Externa: </span> <span> [Circunferência externa da obra] </span>
              </div>
                <div class="mdl-card__actions mdl-card--border borda">
              </div>
           </div>
           <div class="mdl-card__supporting-text OutrasInformacoes">
             <h2 class="mdl-card__title-text">Outras Informações:</h2>
               <div class="Informacao">
                <span class="tituloInformacao"> Data de aquisição: </span> <span> [Data de aquisição da obra] </span>
              </div>
              <div class="Informacao">
               <span class="tituloInformacao"> Bibliografia: </span> <span> [Bibliografia da obra] </span>
              </div>
              <div class="Informacao">
                <span class="tituloInformacao"> Estado de conservação: </span> <span> [Estado de conservação da obra] </span>
              </div>
              <div class="Informacao">
                <span class="tituloInformacao"> Contexto Histórico: </span> <span> [Contexto histórico da obra] </span>
              </div>
              <div class="Informacao">
                <span class="tituloInformacao"> Descrição: </span>
                <p class="Descrição">  Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum
                </p>
              </div>
         </div>
             <div class="mdl-card__menu">
                <a href="#Main-Colecoes" class="edit" id="EditItem"><img src="icons/editar.svg" class="logo"></a>
            </div>
           </div>
           </div>
         </main>
     </div>
@endsection