package com.example.gamesforkids.interfaces

import com.example.gamesforkids.model.Animal

interface GameFunctions {

    fun colocaDica()
    fun selecionaImagemAnimal(animalSelecionado: Animal)
    fun verificarResposta(animalSelecionado: Animal)
}