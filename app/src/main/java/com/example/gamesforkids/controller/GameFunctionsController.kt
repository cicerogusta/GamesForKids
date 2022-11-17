package com.example.gamesforkids.controller

import com.example.gamesforkids.MainActivity
import com.example.gamesforkids.interfaces.GameFunctions
import com.example.gamesforkids.model.Animal

class GameFunctionsController(private val activity: MainActivity) : GameFunctions {

    override fun colocaDica() {
        activity.binding.dica = activity.randomAnimal.dica
    }

    override fun selecionaImagemAnimal(animalSelecionado: Animal) {
        activity.binding.imageView.setImageResource(animalSelecionado.image)

    }

    override fun verificarResposta(animalSelecionado: Animal) {
        if (animalSelecionado.resposta.contains(
                activity.binding.editTextTextPersonName.text.toString().trim().toUpperCase()
            )
        ) {
            activity.createDialog(animalSelecionado.resposta)
        }
    }
}