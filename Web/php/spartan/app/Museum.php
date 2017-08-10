<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Museum extends Model
{
    //

	Colecoes(){
		return $this->hasMany(Colecao::class);
	}
}
