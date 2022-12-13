<?php

namespace App\Http\Controllers;

use App\Models\Temperatura;
use Illuminate\Http\Request;

class TemperaturaController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        return response()->json(Temperatura::all(),200);
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $ciudad=Temperatura::create($request->all());
        return response()->json($ciudad,201);
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Temperatura  $temperatura
     * @return \Illuminate\Http\Response
     */
    public function show(Temperatura $temperatura)
    {
        return response()->json($temperatura,200);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Temperatura  $temperatura
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Temperatura $temperatura)
    {
        $temperatura->update($request->all());
        return response()->json($temperatura,200);
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Temperatura  $temperatura
     * @return \Illuminate\Http\Response
     */
    public function destroy(Temperatura $temperatura)
    {
        $temperatura->delete();
        return response()->json(null,204);
    }
}
