<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Collection extends Model
{
    public function museum(){
    	return $this->belongsTo(Museum::class, 'codMuseum', 'codMuseum');
    }

    public function items(){
		return $this->hasMany(Item::class, 'collectionId', 'collectionId');
	}
}
