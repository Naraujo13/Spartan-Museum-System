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

	$museums = Museum::orderBy('created_at', 'asc')->get();
    $collections = Collection::orderBy('created_at', 'asc')->get();
    $items = Item::orderBy('created_at', 'asc')->get();
    $users = User::orderBy('created_at', 'asc')->get();

    return view('main', [
    	'museums' => $museums, 
    	'collections' => $collections, 
        'items' => $items,
        'users' => $users]);
});