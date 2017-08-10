<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Item extends Model
{
   public function collection(){
        return $this->belongsTo(Collection::class, 'collectionId', 'collectionId');
    }
}
