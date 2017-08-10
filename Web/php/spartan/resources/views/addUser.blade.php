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
            <h2 class="mdl-card__title-text title">Editar Usuário</h2>
            <div class="mdl-layout-spacer"></div>
            <a href="#Usuario-Expandido" class="confirm" id="ConfirmEdit"><img src="/icons/confirmar.svg" class="logo"></a>
          </div>

        <div class="mdl-card__supporting-text">
          <img src="/icons/usuario.svg" class="icon">
          <div class="mdl-card__actions mdl-card--border">

            <div class="Funcao">
              <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="option-1";>
                <input type="radio" id="option-1" class="mdl-radio__button" name="options" value="1">
                <span class="mdl-radio__label">Pesquisador</span>
              </label>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
              <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="option-2">
                <input type="radio" id="option-2" class="mdl-radio__button" name="options" value="2">
                <span class="mdl-radio__label">Técnico</span>
              </label>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="option-3">
                <input type="radio" id="option-3" class="mdl-radio__button" name="options" value="3">
                <span class="mdl-radio__label">Diretor</span>
              </label>
            </div>

            <div class="Nome">
              <form action="#">
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                  <input class="mdl-textfield__input" type="text" id="sample3">
                  <label class="mdl-textfield__label" for="sample3">Nome...</label>
                </div>
              </form>
            </div>
            <div class="Email">
              <form action="#">
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                  <input class="mdl-textfield__input" type="text" id="sample3">
                  <label class="mdl-textfield__label" for="sample3">Email...</label>
                </div>
              </form>
            </div>
            <div class="Senha">
              <form action="#">
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                  <input class="mdl-textfield__input" type="text" id="sample3">
                  <label class="mdl-textfield__label" for="sample3">Senha...</label>
                </div>
              </form>
            </div>
            <div class="Matricula">
              <form action="#">
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                  <input class="mdl-textfield__input" type="text" pattern="-?[0-9]*(\.[0-9]+)?" id="sample4">
                  <label class="mdl-textfield__label" for="sample4">Matrícula...</label>
                  <span class="mdl-textfield__error">Input is not a number!</span>
                </div>
              </form>
            </div>
          </div>
        </div>
        </div>
      </div>
    </main>
  </div>
@endsection
