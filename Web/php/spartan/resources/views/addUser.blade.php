@extends('layouts.app')

@section('content')
<!-- Editar Usuário -->
<div id="Editar-Usuario">
  <main class="mdl-layout__content">
    <div class="page-content">
      <div class="demo-card-wide mdl-card mdl-shadow--2dp editusercard">
        <div class="mdl-card__title">
          <a href="#Usuario-Expandido" class="back" id="BackEditUsers"><img src="/icons/voltar.svg" class="logo"></a>
          <!-- Title -->
          <h2 class="mdl-card__title-text title">Adicionar Usuário</h2>
          <div class="mdl-layout-spacer"></div>
          <a href="#Usuario-Expandido" class="confirm" id="ConfirmEdit"><img src="/icons/confirmar.svg" class="logo" onclick="$('form').submit()"></a>
        </div>

        <div class="mdl-card__supporting-text">
          <img src="/icons/usuario.svg" class="icon">
          <div class="mdl-card__actions mdl-card--border">

            <form action="/users" method="POST">
              {{ csrf_field() }}

              <div class="Funcao">
                <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="option-1";>
                  <input  name="function" type="radio" id="option-1" class="mdl-radio__button" value="1">
                  <span class="mdl-radio__label">Pesquisador</span>
                </label>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="option-2">
                  <input  name="function"  type="radio" id="option-2" class="mdl-radio__button" value="2">
                  <span class="mdl-radio__label">Técnico</span>
                </label>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="option-3">
                  <input  name="function"  type="radio" id="option-3" class="mdl-radio__button" value="3">
                  <span class="mdl-radio__label">Diretor</span>
                </label>
              </div>


              <div class="Nome">
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                  <input name="name" class="mdl-textfield__input" type="text" id="sample3">
                  <label class="mdl-textfield__label" for="sample3">Nome...</label>
                </div>
              </div>
             
              <div class="CPF">
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                  <input name="cpf" class="mdl-textfield__input" type="number" id="sample3">
                  <label class="mdl-textfield__label" for="sample3">CPF...</label>
                </div>
              </div>

              <div class="Email">
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                  <input name="email" class="mdl-textfield__input" type="email" id="sample3">
                  <label class="mdl-textfield__label" for="sample3">Email...</label>
                </div>

              </div>
              <div class="Senha">
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                  <input name="password" class="mdl-textfield__input" type="password" id="sample3">
                  <label class="mdl-textfield__label" for="sample3">Senha...</label>
                </div>

              </div>
              <div class="Matricula">

                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                  <input name="matricula" class="mdl-textfield__input" type="number" pattern="-?[0-9]*(\.[0-9]+)?" id="sample4">
                  <label class="mdl-textfield__label" for="sample4">Matrícula...</label>
                  <span class="mdl-textfield__error">Digite apenas números!</span>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </main>
</div>
@endsection
