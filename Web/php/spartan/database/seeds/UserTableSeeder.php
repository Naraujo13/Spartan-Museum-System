<?php

use Illuminate\Database\Seeder;

class UserTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        //factory(App\User::class, 50)->create();

         DB::table('users')->insert([
        	'name' => 'Paulo',
        	'cpf' => '000',
        	'email' => "paulo@inf.ufpel.edu.br",
        	'matricula' => null,
        	'password' => '000',
        	'function' => '2',

        ]);
    }
}
