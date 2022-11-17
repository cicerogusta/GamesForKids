package com.example.gamesforkids

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.gamesforkids.controller.GameFunctionsController
import com.example.gamesforkids.databinding.ActivityMainBinding
import com.example.gamesforkids.interfaces.GameFunctions
import com.example.gamesforkids.model.Animal
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var randomAnimal: Animal
    lateinit var binding: ActivityMainBinding
    private lateinit var gameFunctionsController: GameFunctionsController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gameFunctionsController = GameFunctionsController(this)
        iniciaUmaFase()
        binding.button.setOnClickListener {

        }


    }

    private fun iniciaUmaFase() {
        val animal = Animal(1,R.drawable.gato, "Gato", "_ATO")
        val animal2 = Animal(2,R.drawable.cachorro, "Cachorro", "_ACHORRO")
        val animal5 = Animal(5,R.drawable.tigre, "Tigre", "_IGRE")
        val animal4 = Animal(4,R.drawable.zebra, "Zebra", "_EBRA")
        val animal3 = Animal(3,R.drawable.jacare, "Jacaré", "_ACARÉ")
        val lista = mutableListOf(animal, animal2, animal3, animal4, animal5)
        val animals: HashSet<Animal> = HashSet()

        for (i in 0..lista.size) {
            animals.add(lista[Random.nextInt(5)])
        }


        randomAnimal = animals.random()

        gameFunctionsController.selecionaImagemAnimal(randomAnimal)
        gameFunctionsController.colocaDica()


    }



    fun createDialog(resposta: String) {
        val builder = AlertDialog.Builder(this)
        if (binding.editTextTextPersonName.text.toString().trim().toUpperCase().contains(resposta.substring(0,1))) {
            builder.setTitle("Parabéns!")
            builder.setMessage(randomAnimal.resposta)
            iniciaUmaFase()

        } else if (binding.editTextTextPersonName.text.toString().isBlank()) {
            builder.setTitle("Insira uma letra!")
        } else {
            builder.setTitle("Tente novamente!")

        }
        builder.show()
        binding.editTextTextPersonName.setText("")
        binding.editTextTextPersonName.isFocusable = true
    }





}