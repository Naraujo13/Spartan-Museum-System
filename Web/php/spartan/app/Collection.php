<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Collection extends Model
{
    Museum(){
    	return $this->belongsTo(Museum::class);
    }
}
