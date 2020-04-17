package com.luciburcugithub.restapicity.controller

import com.luciburcugithub.restapicity.entity.CityEntity
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class CityController {

    val listOfCities = mutableListOf(
            CityEntity("London", 8908081),
            CityEntity("Paris", 2148271),
            CityEntity("Rome", 2844395)
    )

    @GetMapping(value = ["/"], produces = [APPLICATION_JSON_VALUE])
    fun getCities(): ResponseEntity<List<CityEntity>> {
        return ResponseEntity(listOfCities, HttpStatus.OK)
    }

    @GetMapping(value = ["/{id}"], produces = [APPLICATION_JSON_VALUE])
    fun getCityById(@PathVariable id: Int): ResponseEntity<CityEntity> {
        return ResponseEntity(listOfCities[id], HttpStatus.OK)
    }

    @PostMapping(value = ["/create"], consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
    fun createCity(@RequestBody city: CityEntity): ResponseEntity<CityEntity> {
        listOfCities.add(city)
        return ResponseEntity(city, HttpStatus.CREATED)
    }

    @PutMapping(value=["/update/{id}"], consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
    fun updateCity(@PathVariable id:Int, @RequestBody city: CityEntity): ResponseEntity<CityEntity>{
        listOfCities[id] =  city
        return ResponseEntity(city, HttpStatus.OK)
    }

    @DeleteMapping(value=["/delete/{id}"])
    fun deleteCity(@PathVariable id:Int):ResponseEntity<String>{
        listOfCities.remove(listOfCities[id])
        return ResponseEntity("Deleted", HttpStatus.OK)
    }

}