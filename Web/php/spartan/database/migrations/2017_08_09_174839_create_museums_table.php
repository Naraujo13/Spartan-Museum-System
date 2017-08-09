<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateMuseumsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('museums', function (Blueprint $table) {
            $table->increments('id');

            $table->timestamps();

            $table->string('museumCode')->primary();
            $table->string('name')->unique();
            $table->foreign('cpfdirector')->nullable()
                    ->references('cpf')->on('users')
                    ->onDelete('set null');
            $table->string('cpftechnician')->nullable()
                    ->references('cpf')->on('users')
                    ->onDelete('set null');
            $table->string('name');
            $table->string('address');
            $table->string('phone')->nullable();
            $table->string('openingHours')->nullable();
            $table->string('description')->nullable();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('museums');
    }
}
