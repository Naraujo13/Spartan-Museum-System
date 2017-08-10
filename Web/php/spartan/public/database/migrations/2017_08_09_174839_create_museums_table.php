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
           
            $table->timestamps();

            $table->string('codMuseum')->primary();
            $table->string('name')->unique();

            $table->string('cpfdirector')->nullable();
            $table->foreign('cpfdirector')
                    ->references('cpf')->on('users')
                    ->onDelete('set null');

            $table->string('cpftechnician')->nullable();
            $table->foreign('cpftechnician')
                    ->references('cpf')->on('users')
                    ->onDelete('set null');
                    
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
