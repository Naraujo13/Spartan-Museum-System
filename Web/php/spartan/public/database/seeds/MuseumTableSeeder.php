<?php

use Illuminate\Database\Seeder;

class MuseumTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('museums')->insert([
        	'codMuseum' => 'MSM1',
        	'name' => 'Museum Teste 1',
        	'address' => "Rua 1234",
        	'phone' => '99999999999',
        	'openingHours' => '13 a 18 horas',
        ]);

        DB::table('museums')->insert([
        	'codMuseum' => 'MSM2',
        	'name' => 'Museum Teste 2',
        	'address' => "Rua 325252",
        	'phone' => '99999999999',
        	'openingHours' => '13 a 18 horas',
        ]);
        DB::table('museums')->insert([
        	'codMuseum' => 'MSM3',
        	'name' => 'Museum Teste 3',
        	'address' => "Rua aaaaaa",
        	'phone' => '35252',
        	'openingHours' => '13 a 18 horas',
        ]);
        DB::table('museums')->insert([
        	'codMuseum' => 'MSM4',
        	'name' => 'Museum Teste 4',
        	'address' => "Rua afasfa",
        	'phone' => '99999999999',
        	'openingHours' => '13 a 18 horas',
        ]);
        DB::table('museums')->insert([
        	'codMuseum' => 'MSM5',
        	'name' => 'Museum Teste 5',
        	'address' => "Rua adsafa",
        	'phone' => '99999999999',
        	'openingHours' => '13 a 18 horas',
        ]);
    }
}
