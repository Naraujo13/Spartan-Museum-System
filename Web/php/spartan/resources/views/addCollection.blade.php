 @extends('layouts.app')

@section('content')

    <!---Editar Colecao-->
      <div id="Editar-Colecao">
       <main class="mdl-layout__content">
         <div class="page-content">
           <div class="demo-card-wide mdl-card mdl-shadow--2dp editcollectioncard">
             <div class="mdl-card__title">
               <a href="/collections" class="back" id="BackEditCollection"><img src="icons/voltar.svg" class="logo"></a>
               <!-- Title -->
               <h2 class="mdl-card__title-text title">Editar Coleção</h2>
               <div class="mdl-layout-spacer"></div>
               <a href="#Colecao-Expandida" class="confirm" id="ConfirmCollection"><img src="icons/confirmar.svg" class="logo"></a>
             </div>
           <div class="mdl-card__supporting-text">
             <img src="icons/colecao.svg" class="icon">
             <div class="mdl-card__actions mdl-card--border">
               <div class="Informacao">
                <span class="tituloInformacao"> Nome da Coleção: </span>
                <div class="mdl-textfield mdl-js-textfield">
                  <input class="mdl-textfield__input" type="text" id="fname">
                  <label class="mdl-textfield__label" for="fname">Nome Coleção</label>
                </div>
              </div>
               <div class="Informacao">
                <span class="tituloInformacao"> ID Museu: </span>
                <div class="mdl-textfield mdl-js-textfield">
                  <input class="mdl-textfield__input" type="text" id="fname">
                  <label class="mdl-textfield__label" for="fname">ID Museu</label>
                </div>
              </div>
               <div class="Informacao">
                <span class="tituloInformacao"> Museu: </span>
                <div class="mdl-textfield mdl-js-textfield">
                  <select class="mdl-textfield__input" id="museum" name="museu">
                    <option></option>
                    @foreach($museums as $museum)
                      <option>{{$museum->name}}</option>
                    @endforeach
                  </select>
                  <label class="mdl-textfield__label" for="museu">Museu</label>
                </div>
              </div>
              <br />
              <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                <textarea class="mdl-textfield__input" type="text" rows= "7" id="schools"></textarea>
                <label class="mdl-textfield__label" for="schools">Descrição</label>
              </div>
             </div>
           </div>
           </div>
         </div>
       </main>
     </div>
@endsection