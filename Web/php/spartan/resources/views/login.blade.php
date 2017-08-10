<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <title>Spartan Museum System</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Material Design Lite -->
        <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
        <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
        <!-- Material Icons -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

        <!-- Style -->
        <style>
            #pagecontent {
                align-items: center;
                justify-content: center;
            }

            .mdl-layout__content {
                padding: 24px;
                flex: none;
            }

            #logo {
                display: inline-block;
                height: 100%;
                padding-right: 1%;
            }

            #logo>img {
                vertical-align: middle;
                transform: scale(0.8);
            }

        </style>
    </head>

    <body>
        <!-- Layout -->
        <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
            <!-- Logo/Spartan/Header -->
            <header class="mdl-layout__header">
                <div class="mdl-layout__header-row mdl-color--teal">
                    <img id="logo" src="/icons/spartan.png">
                    <span class="mdl-layout-title">Spartan</span>
                </div>
            </header>
            <!-- Card/Login Section -->
            <div id="pagecontent" class="mdl-layout mdl-js-layout">
                <main class="mdl-layout__content">
                    <div class="page-content">
                        <!-- Login -->
                        <div class="mdl-card-wide mdl-shadow--6dp">
                            <div class="mdl-card__title mdl-color--teal mdl-color-text--white">
                                <h2 class="mdl-card__title-text">Login</h2>
                            </div>
                            <div class="mdl-card__supporting-text">
                                <form action="#">
                                    <div class="mdl-textfield mdl-js-textfield">
                                        <input class="mdl-textfield__input" type="text" id="user" pattern="[0-9]*">
                                        <label class="mdl-textfield__label" for="user">CPF</label>
                                        <span class="mdl-textfield__error">Apenas números</span>
                                    </div>
                                    <div class="mdl-textfield mdl-js-textfield">
                                        <input class="mdl-textfield__input" type="password" id="userpass"/>
                                        <label class="mdl-textfield__label" for="userpass">Senha</label>
                                    </div>
                                </form>
                            </div>
                            <div class="mdl-card__actions mdl-card--border">
                                <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent mdl-color--teal mdl-color-text--white">ENTRAR</button>
                            </div>
                        </div>
                        <!-- End Login -->
                    </div>
                </main>
            </div>
            <!-- Card/Login Section -->
        </div>
    </body>
</html>
