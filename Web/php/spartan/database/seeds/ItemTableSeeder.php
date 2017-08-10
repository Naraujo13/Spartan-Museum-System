<?php

use Illuminate\Database\Seeder;

class ItemTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
         DB::table('items')->insert([
        	'itemId' => 'ITM1',
        	'name' => 'Item 1',
        	'collectionId' => "col1",
        	'year' => '1990',
        	'status' => 'Em Armazenamento',
        	'lenght' => '2',
        	'height' => '5',
        	'width' => '3',
        	'thickness' => null,
        	'aquisitionDate' => '2012-10-02',
        	'outerCircumference' => null,
        	'innerCircumference' => null,
        	'weight' => '0.5',
        	'author' => "João Das Obras",
        	'conservationState' => 'Bom',
        	'historicalContext' => 'Novo',
        	'biography' => null,
        	'description' => 'Descrição geral',

        ]);
         DB::table('items')->insert([
        	'itemId' => 'ITM2',
        	'name' => 'Item 2',
        	'collectionId' => "col1",
        	'year' => '1920',
        	'status' => 'Em Armazenamento',
        	'lenght' => '5',
        	'height' => '3',
        	'width' => '2',
        	'thickness' => null,
        	'aquisitionDate' => '2002-10-02',
      		'outerCircumference' => null,
        	'innerCircumference' => null,
        	'weight' => '0.5',
        	'author' => "João Das Obras",
        	'conservationState' => 'Bom',
        	'historicalContext' => 'Antigo',
        	'biography' => null,
        	'description' => 'Descrição geral',

        ]);
         DB::table('items')->insert([
        	'itemId' => 'ITM3',
        	'name' => 'Item 3',
        	'collectionId' => "col1",
        	'year' => '1150',
        	'status' => 'Em Armazenamento',
        	'lenght' => '1',
        	'height' => '2',
        	'width' => '1',
        	'thickness' => null,
        	'aquisitionDate' => '2016-10-02',
        	'outerCircumference' => null,
        	'innerCircumference' => null,
        	'weight' => '0.5',
        	'author' => "João Das Obras",
        	'conservationState' => 'Bom',
        	'historicalContext' => 'Bem antigo',
        	'biography' => null,
        	'description' => 'Descrição geral',
        ]);                        
    }
}
