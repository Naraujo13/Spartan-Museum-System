@extends('layouts.app')

@section('content')
  <!--Adicionar/Editar Item-->
     <div id="Adicionar-editar-item" >
       <main class="mdl-layout__content">
         <div class="page-content">
           <div class="demo-card-wide mdl-card mdl-shadow--2dp collectionCard">
             <div class="mdl-card__title">
               <a href="/items" class="back" id="BackAddItem"><img src="/icons/voltar.svg" class="logo"></a>
               <h2 class="mdl-card__title-text title">Adicionar Item</h2>
             </div>
             <form action="#">
             <div class="mdl-card__supporting-text informacoesGerais">
               <!-- Colored raised button -->
                <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored BotaoImagem" id="MovimentationButton">
                  Adicionar Imagem
                </button>
               <h2 class="mdl-card__title-text">Informações Principais:</h2>
                 <div class="Informacao">
                  <span class="tituloInformacao"> Nome: </span>
                  <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="fname">
                    <label class="mdl-textfield__label" for="fname">Nome</label>
                  </div>
                </div>
                <div class="Informacao">
                 <span class="tituloInformacao"> ID: </span>
                 <div class="mdl-textfield mdl-js-textfield">
                   <input class="mdl-textfield__input" type="text" id="fname">
                   <label class="mdl-textfield__label" for="fname">ID</label>
                 </div>
               </div>
               <div class="Informacao">
                <span class="tituloInformacao"> Autor: </span>
                <div class="mdl-textfield mdl-js-textfield">
                  <input class="mdl-textfield__input" type="text" id="fname">
                  <label class="mdl-textfield__label" for="fname">Autor</label>
                </div>
              </div>
              <div class="Informacao">
               <span class="tituloInformacao"> Ano: </span>
               <div class="mdl-textfield mdl-js-textfield">
                 <input class="mdl-textfield__input" type="text" pattern="-?[0-9]*(\.[0-9]+)?" id="sample2">
                 <label class="mdl-textfield__label" for="fname">Ano</label>
                 <span class="mdl-textfield__error">O ano deve ser numérico, obviamente</span>
               </div>
             </div>
             <div class="Informacao">
              <span class="tituloInformacao"> Museu: </span>
              <div class="mdl-textfield mdl-js-textfield">
                <select class="mdl-textfield__input" id="museum" name="museu">
                  <option></option>
                  <option value="85">Museu Normal</option>
                  <option value="87">Museu do Doce</option>
                  <option value="89">Museu das Cópias</option>
                </select>
                <label class="mdl-textfield__label" for="museu">Museu</label>
              </div>
            </div>
            <div class="Informacao">
             <span class="tituloInformacao"> Coleção: </span>
             <div class="mdl-textfield mdl-js-textfield">
               <select class="mdl-textfield__input" id="collection" name="coleção">
                 <option></option>
                 <option value="85">Picasso</option>
                 <option value="87">Picasso Copycat</option>
                 <option value="89">Vasos</option>
               </select>
               <label class="mdl-textfield__label" for="coleção">Coleção</label>
             </div>
           </div>
           </div>
           <div class="mdl-card__actions mdl-card--border borda"></div>
           <div class="mdl-card__supporting-text Dimensões">
             <h2 class="mdl-card__title-text">Dimensões:</h2>
             <div class="Informacao">
              <span class="tituloInformacao"> Altura: </span>
              <div class="mdl-textfield mdl-js-textfield">
                <input class="mdl-textfield__input" type="text" pattern="-?[0-9]*(\.[0-9]+)?" id="sample2">
                <label class="mdl-textfield__label" for="fname">Altura</label>
                <span class="mdl-textfield__error">A altura deve ser um número, obviamente</span>
              </div>
            </div>
            <div class="Informacao">
             <span class="tituloInformacao"> Largura: </span>
             <div class="mdl-textfield mdl-js-textfield">
               <input class="mdl-textfield__input" type="text" pattern="-?[0-9]*(\.[0-9]+)?" id="sample2">
               <label class="mdl-textfield__label" for="fname">Largura</label>
               <span class="mdl-textfield__error">A largura deve ser um número, obviamente</span>
             </div>
           </div>
           <div class="Informacao">
            <span class="tituloInformacao"> Espessura: </span>
            <div class="mdl-textfield mdl-js-textfield">
              <input class="mdl-textfield__input" type="text" pattern="-?[0-9]*(\.[0-9]+)?" id="sample2">
              <label class="mdl-textfield__label" for="fname">Espessura</label>
              <span class="mdl-textfield__error">A espessura deve ser um número, obviamente</span>
            </div>
          </div>
          <div class="Informacao">
           <span class="tituloInformacao"> Comprimento: </span>
           <div class="mdl-textfield mdl-js-textfield">
             <input class="mdl-textfield__input" type="text" pattern="-?[0-9]*(\.[0-9]+)?" id="sample2">
             <label class="mdl-textfield__label" for="fname">Comprimento</label>
             <span class="mdl-textfield__error">O comprimento deve ser um número, obviamente</span>
           </div>
         </div>
         <div class="Informacao">
          <span class="tituloInformacao"> Circunferência Interna: </span>
          <div class="mdl-textfield mdl-js-textfield">
            <input class="mdl-textfield__input" type="text" pattern="-?[0-9]*(\.[0-9]+)?" id="sample2">
            <label class="mdl-textfield__label" for="fname">Circunferência Interna</label>
            <span class="mdl-textfield__error">A circunferência interna deve ser um número, obviamente</span>
          </div>
        </div>
        <div class="Informacao">
         <span class="tituloInformacao"> Circunferência Externa: </span>
         <div class="mdl-textfield mdl-js-textfield">
           <input class="mdl-textfield__input" type="text" pattern="-?[0-9]*(\.[0-9]+)?" id="sample2">
           <label class="mdl-textfield__label" for="fname">Circunferência Externa</label>
           <span class="mdl-textfield__error">A circunferencia externa deve ser um número, obviamente</span>
         </div>
        </div>
        </div>
        <div class="mdl-card__actions mdl-card--border borda"></div>
          <div class="mdl-card__supporting-text OutrasInformacoes">
            <h2 class="mdl-card__title-text">Outras Informações:</h2>
            <div class="Informacao">
             <span class="tituloInformacao"> Estado de Conservação: </span>
             <div class="mdl-textfield mdl-js-textfield">
               <input class="mdl-textfield__input" type="text" id="fname">
               <label class="mdl-textfield__label" for="fname">Estado de conservação</label>
             </div>
           </div>
           <br>
           <div class="Informacao">
            <span class="tituloInformacao"> Contexto Histórico: </span>
            <div class="mdl-textfield mdl-js-textfield">
              <input class="mdl-textfield__input" type="text" id="fname">
              <label class="mdl-textfield__label" for="fname">Contexto Histórico</label>
            </div>
          </div>
          <br>
          <div class="Informacao">
           <span class="tituloInformacao"> Bibliografia: </span>
           <div class="mdl-textfield mdl-js-textfield">
             <input class="mdl-textfield__input" type="text" id="fname">
             <label class="mdl-textfield__label" for="fname">Bibliografia</label>
           </div>
         </div>
         <br>
         <div class="Informacao">
          <span class="tituloDescrição"> Descrição: </span>
          <br>
          <div class="mdl-textfield mdl-js-textfield OutrasInformacoesInput">
            <textarea class="mdl-textfield__input OutrasInformacoesInput" type="text" rows= "3" id="sample5" ></textarea>
            <label class="mdl-textfield__label" for="sample5">Descrição</label>
          </div>
        </div>
     </div>
      </form>

           <div class="mdl-card__menu">
              <a href="#Main-Colecoes" class="confirmar" id="ConfirmAddItem"><img src="/icons/confirmar.svg" class="confirmar"></a>
          </div>
         </div>
         </div>
       </main>
   </div>
@endsection
