<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Item extends Model
{
    private String ID;
    private String collectionName;
    private String name;
    private int year;
    private String status;
    //Measures
    private float lenght;
    private float height;
    private float width;
    private float thickness;
    private float depth;
    private String aquisitionDate;
    private float outerCircumference;
    private float innerCircumference;
    private float weight;
    //Extra info
    private String author;
    private String conservationState;
    private String historicalContext;
    private String biography;
    private String description;
}
