<?php
use App\Museum;
use App\Collection;
use App\Item;
use App\User;
use Illuminate\Http\Request;

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
    return view('login');
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

Route::get('/addUser', function () {

    return view('addUser');
});

Route::get('/editMuseum', function () {

    return view('editMuseum');
});

Route::get('/editItem/{id}', function ($id) {
    
    $item = DB::table('items')->where('itemId', $id)->first();
    return view('editItem', 
        ['item' => $item]);
});

Route::get('/museums', function () {

    $museums = Museum::orderBy('created_at', 'asc')->get();

    return view('museums', ['museums' => $museums]);
});

Route::post('/museums', function (Request $request) {

    DB::table('museums')->insert([
            'codMuseum' => "novoMuseu",
            'name' => $request->name,
            'cpfdirector' => $request->cpfdirector,
            'cpftechnician' => $request->cpftechnician,
            'address' => $request->address,
            'phone' => $request->phone,
            'openingHours' => $request->openingHours,
            'description' => $request->description,
        ]);


    return redirect('/museums');
});

Route::get('/addMuseum', function () {

    return view('addMuseum');
});

Route::post('/users', function (Request $request) {



   DB::table('users')->insert([
            'name' => $request->name,
            'cpf' => $request->cpf,
            'email' => $request->email,
            'matricula' => $request->matricula,
            'password' => $request->password,
            'function' => $request->function,

        ]);


    return redirect('/users');
});

Route::post('/items', function (Request $request) {

   DB::table('items')->insert([
            'itemId' => $request->itemId,
            'name' => $request->name,
            'collectionId' => $request->collectionId,
            'year' => $request->year,
            'status' => "Em Armazenamento",
            'lenght' => $request->lenght,
            'height' => $request->height,
            'width' => $request->width,
            'thickness' => $request->thickness,
            'aquisitionDate' => date(DATE_RFC2822),
            'outerCircumference' => $request->outerCircumference,
            'innerCircumference' => $request->innerCircumference,
            'weight' => 2.5,
            'author' => $request->author,
            'conservationState' => $request->conservationState,
            'historicalContext' => $request->historicalContext,
            'biography' => $request->biography,
            'description' => $request->description,
        ]);


    return redirect('/items');
});

Route::get('/collections', function () {

    $collections = Collection::orderBy('created_at', 'asc')->get();

    return view('collections', ['collections' => $collections]);
});

Route::get('/items', function () {

    $items = Item::orderBy('created_at', 'asc')->get();

    return view('items', ['items' => $items]);
});

Route::get('/addItem', function () {
    $museums = Museum::orderBy('created_at', 'asc')->get();
    $collections = Collection::orderBy('created_at', 'asc')->get();

    return view('addItem', ['museums' => $museums, 'collections' => $collections]);
});

Route::get('/expandedMuseum/{id}', function ($id) {
    
    $museum = DB::table('museums')->where('codMuseum', $id)->first();
    return view('expandedMuseum', 
        ['museum' => $museum]);
});

Route::get('/editMuseum/{id}', function ($id) {
    
    $museum = DB::table('museums')->where('codMuseum', $id)->first();
    return view('editMuseum', 
        ['museum' => $museum]);
});

Route::get('/editUser/{id}', function ($id) {
    
    $user = DB::table('users')->where('cpf', $id)->first();
    return view('editUser', 
        ['user' => $user]);
});

Route::get('/expandedCollection/{id}', function ($id) {
    
    $collection = DB::table('collections')->where('collectionId', $id)->first();
    

    return view('expandedCollection', 
        ['collection' => $collection]);
});


Route::get('/expandedCollection', function() {
    return view('expandedCollection');
});


Route::get('/expandedUser/{id}', function ($id) {
    //Collection::findOrFail($id)->delete();
    $user = DB::table('users')->where('cpf', $id)->first();
    

    return view('expandedUser', 
        ['user' => $user]);
});


Route::get('/expandedUser', function() {
    return view('expandedUser');
});

Route::get('/expandedItem/{id}', function ($id) {
    //Collection::findOrFail($id)->delete();
    $item = DB::table('items')->where('itemId', $id)->first();
    

    return view('expandedItem', 
        ['item' => $item]);
});


Route::get('/expandedItem', function() {
    return view('expandedItem');
});

//Auth::routes();
