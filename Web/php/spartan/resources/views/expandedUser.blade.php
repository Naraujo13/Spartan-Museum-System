@extends('layouts.app')

@section('content')
  <!-- Usuário Expandido -->
     <div id="Usuario-Expandido">
      <main class="mdl-layout__content">
        <div class="page-content">
          <div class="demo-card-wide mdl-card mdl-shadow--2dp usercard">
            <div class="mdl-card__title">
              <a href="#Main-Usuarios" class="back" id="BackUsers"><img src="/icons/voltar.svg" class="logo"></a>
              <!-- Title -->
              <h2 class="mdl-card__title-text title">{{$user->name}}</h2>
              <!-- Add spacer, to align navigation to the right -->
              <div class="mdl-layout-spacer"></div>
              <a href="#Editar-Usuario" class="edit" id="EditUsers"><img src="/icons/editar.svg" class="logo"></a>
            </div>

          <div class="mdl-card__supporting-text">
            <img src="/icons/usuario.svg" class="icon">

              <div class="Cpf">
               <span class="tituloInformacao"> CPF: </span> <span> {{$user->cpf}}</span>
              </div>
              <div class="Email">
                <span class="tituloInformacao"> Email: </span> <span> {{$user->email}} </span>
              </div>
              <div class="Funcao">
                <span class="tituloInformacao"> Função: </span> <span> {{$user->function}} </span>
              </div>
              <div class="Matricula">
                <span class="tituloInformacao"> Matrícula: </span> <span> Sem matrícula </span>
              </div>

          </div>
          </div>
        </div>
      </main>
    </div>
@endsection
