<?php

use Illuminate\Database\Seeder;

class CollectionTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('collections')->insert([
        	'collectionId' => 'col1',
        	'codMuseum' => 'MSM1',
        	'name' => 'Coleção Inútil',
        ]);
        DB::table('collections')->insert([
        	'collectionId' => 'col2',
        	'codMuseum' => 'MSM1',
        	'name' => 'Coleção Lixo',
        ]);
        DB::table('collections')->insert([
        	'collectionId' => 'col3',
        	'codMuseum' => 'MSM1',
        	'name' => 'Coleção Imprestável',
        ]);

      	DB::table('collections')->insert([
        	'collectionId' => 'col4',
        	'codMuseum' => 'MSM2',
        	'name' => 'Coleção Legal',
        ]);
        DB::table('collections')->insert([
        	'collectionId' => 'col5',
        	'codMuseum' => 'MSM2',
        	'name' => 'Coleção Jóia',
        ]);
        DB::table('collections')->insert([
        	'collectionId' => 'col6',
        	'codMuseum' => 'MSM2',
        	'name' => 'Coleção Boa',
        ]);

       	DB::table('collections')->insert([
        	'collectionId' => 'col7',
        	'codMuseum' => 'MSM3',
        	'name' => 'Coleção Feia',
        ]);
        DB::table('collections')->insert([
        	'collectionId' => 'col8',
        	'codMuseum' => 'MSM3',
        	'name' => 'Coleção Horrível',
        ]);
        DB::table('collections')->insert([
        	'collectionId' => 'col9',
        	'codMuseum' => 'MSM3',
        	'name' => 'Coleção Horripilante',
        ]);

        DB::table('collections')->insert([
        	'collectionId' => 'col10',
        	 'codMuseum'=> 'MSM4',
        	'name' => 'Coleção Sem Nome',
        ]);
        DB::table('collections')->insert([
        	'collectionId' => 'col11',
        	'codMuseum' => 'MSM4',
        	'name' => 'Coleção Eu Não Sei',
        ]);
        DB::table('collections')->insert([
        	'collectionId' => 'col12',
        	'codMuseum' => 'MSM4',
        	'name' => 'Coleção Sem Criatividade',
        ]);    

         DB::table('collections')->insert([
        	'collectionId' => 'col13',
        	'codMuseum' => 'MSM5',
        	'name' => 'Ta Acabando',
        ]);
        DB::table('collections')->insert([
        	'collectionId' => 'col14',
        	'codMuseum' => 'MSM5',
        	'name' => 'Acabooou',
        ]);
        DB::table('collections')->insert([
        	'collectionId' => 'col15',
        	'codMuseum' => 'MSM5',
        	'name' => 'É Tetra',
        ]);           

    }
}
