<?php
use App\Museum;
use App\Collection;
use App\Item;
use App\User;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {	
    return view('loading');
});

Route::get('/login', function () {
    return view('login');
});

Route::get('/home', function () {

    return view('home');
});

Route::get('/users', function () {

    $users = User::orderBy('created_at', 'asc')->get();

    return view('users', ['users' => $users]);
});

Route::get('/museums', function () {

    $museums = Museum::orderBy('created_at', 'asc')->get();

    return view('museums', ['museums' => $museums]);
});

Route::get('/collections', function () {

    $collections = Collection::orderBy('created_at', 'asc')->get();

    return view('collections', ['collections' => $collections]);
});

Route::get('/items', function () {

    $items = Item::orderBy('created_at', 'asc')->get();

    return view('items', ['items' => $items]);
});

Route::get('/expandedCollection/{id}', function () {
    //Collection::findOrFail($id)->delete();
    return view('expandedCollection');
});


Route::get('/expandedCollection', function() {
    return view('expandedCollection');
});


// Authentication 
Route::get('auth/login', 'Auth\AuthController@getLogin');
Route::post('auth/login', 'Auth\AuthController@postLogin');
Route::get('auth/logout', 'Auth\AuthController@getLogout');
