<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateItemsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('items', function (Blueprint $table) {
            $table->timestamps();
            $table->string('itemId')->primary();
            $table->string('name');

            $table->string('collectionId');
            $table->foreign('collectionId')
                    ->references('collectionId')->on('collections')
                    ->onDelete('cascade');

            $table->integer('year');
            $table->string('status');
            $table->float('lenght');
            $table->float('height');
            $table->float('width');
            $table->float('thickness')->nullable();
            $table->string('aquisitionDate');
            $table->float('outerCircumference')->nullable();
            $table->float('innerCircumference')->nullable();
            $table->float('weight');
            $table->string('author')->nullable();
            $table->string('conservationState')->nullable();
            $table->string('historicalContext')->nullable();
            $table->string('biography')->nullable();
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
        Schema::dropIfExists('items');
    }
}
