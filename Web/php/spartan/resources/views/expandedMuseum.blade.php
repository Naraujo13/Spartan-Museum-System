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
                                <a href="{{ URL::to('/editMuseum/' . $museum->codMuseum) }}" class="edit" id="editarMuseu"><img src="/icons/editar.svg" class="logo"></a>
                              </div> 
                          </div>

                          <div class="mdl-card__supporting-text">
                              <img src="/icons/museu.svg" class="icon">

                              <h3>Informações Gerais:</h3>

                              <div class="COD">
                                  <span class="tituloInformacao"> COD: </span> <span> {{$museum->codMuseum}} </span>
                              </div>
                              <div class="Diretor">
                                  <span class="tituloInformacao"> Diretor: </span> <span> {{$museum->cpfdirector}} </span>
                              </div>
                              <div class="Tecnico">
                                  <span class="tituloInformacao"> Técnico: </span> <span> {{$museum->cpftechnician}} </span>
                              </div>
                              <div class="Endereco">
                                  <span class="tituloInformacao"> Endereço: </span> <span> {{$museum->address}} </span>
                              </div>
                              <div class="Funcionamento">
                                  <span class="tituloInformacao"> Horário de Funcionamento: </span> <span> {{$museum->openingHours}} </span>
                              </div>
                              <div class="Description">
                                  <span class="tituloInformacao"> <br>Descrição: </span><br>
                                  <span> {{$museum->description}} </span>
                              </div>
                          </div>
                      </div>
                  </div>
              </main>
          </div>
@endsection