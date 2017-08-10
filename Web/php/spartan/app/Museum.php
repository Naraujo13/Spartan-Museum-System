<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Museum extends Model
{
    //

	public function collections(){
		return $this->hasMany(Collection::class, 'codMuseum', 'codMuseum');
	}
}
