@extends('layouts.app')

@section('content') 
        <!-- Museu Expandido -->
          <div id="Museu-Expandido">
              <main class="mdl-layout__content">
                  <div class="page-content">
                      <div class="demo-card-wide mdl-card mdl-shadow--2dp museuCard">
                          <div class="mdl-card__title">
                              <a href="#Main-Museus" class="back" id="backspace"><img src="/icons/voltar.svg" class="logo"></a>
                              <!-- Title -->
                              <h2 class="mdl-card__title-text title"> Museu Normal </h2>
                              <!-- Add spacer, to align navigation to the right -->
                              <div class="mdl-layout-spacer">
                                <a href="#Editar-Museu" class="edit" id="editarMuseu"><img src="/icons/editar.svg" class="logo"></a>
                              </div>
                          </div>

                          <div class="mdl-card__supporting-text">
                              <img src="/icons/museu.svg" class="icon">

                              <h3>Editar Informações:</h3>

                            
                              <div class="COD">
                                  <span class="tituloInformacao"> Nome: </span>
                                  <div class="mdl-textfield mdl-js-textfield">
                                  <input class="mdl-textfield__input" type="text" id="fname">
                                  <label class="mdl-textfield__label" for="fname">{{$museum->codMuseum}}</label>
                                </div>
                              </div>
                              <div class="COD">
                                  <span class="tituloInformacao"> Endereço: </span>
                                  <div class="mdl-textfield mdl-js-textfield">
                                  <input class="mdl-textfield__input" type="text" id="fname">
                                  <label class="mdl-textfield__label" for="fname">{{$museum->address}}</label>
                                </div>
                              </div>
                              <div class="COD">
                                  <span class="tituloInformacao"> Telefone: </span>
                                  <div class="mdl-textfield mdl-js-textfield">
                                  <input class="mdl-textfield__input" type="text" id="fname">
                                  <label class="mdl-textfield__label" for="fname">{{$museum->phone}}</label>
                                </div>
                              </div>
                              <div class="COD">
                                  <span class="tituloInformacao"> Horário de Funcionamento: </span>
                                  <div class="mdl-textfield mdl-js-textfield">
                                  <input class="mdl-textfield__input" type="text" id="fname">
                                  <label class="mdl-textfield__label" for="fname">{{$museum->openingHours}}</label>
                                </div>
                              </div>

                              <div class="COD">
                                  <span class="tituloInformacao"> Descrição: </span>
                                  <div class="mdl-textfield mdl-js-textfield">
                                  <input class="mdl-textfield__input" type="text" id="fname">
                                  <label class="mdl-textfield__label" for="fname">{{$museum->description}}</label>
                                </div>
                              </div>
                              <div class="COD">
                                  <span class="tituloInformacao"> Diretor: </span>
                                  <div class="mdl-textfield mdl-js-textfield">
                                  <input class="mdl-textfield__input" type="text" id="fname">
                                  <label class="mdl-textfield__label" for="fname">{{$museum->cpfdirector}}</label>
                                </div>
                              </div>
                              <div class="COD">
                                  <span class="tituloInformacao"> Técnico: </span>
                                  <div class="mdl-textfield mdl-js-textfield">
                                  <input class="mdl-textfield__input" type="text" id="fname">
                                  <label class="mdl-textfield__label" for="fname">{{$museum->cpftechnician}}</label>
                                </div>
                              </div>
                               <div class="mdl-card__menu">
                                 <a href="#Main-Colecoes" class="confirmar" id="ConfirmAddItem"><img src="/icons/confirmar.svg" class="confirmar"></a>
                                </div>
                          </div>
                      </div>
                  </div>
              </main>
          </div>
@endsection