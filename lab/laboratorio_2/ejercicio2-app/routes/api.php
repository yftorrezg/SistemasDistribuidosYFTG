<?php

use App\Http\Controllers\TemperaturaController;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

/* Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
}); */

Route::get('/temperatura',[TemperaturaController::class,'index']);
Route::get('/temperatura/{temperatura}',[TemperaturaController::class,'show']);
Route::post('/temperatura',[TemperaturaController::class,'store']);
Route::put('/temperatura/{temperatura}',[TemperaturaController::class,'update']);
Route::delete('/temperatura/{temperatura}',[TemperaturaController::class,'destroy']);
