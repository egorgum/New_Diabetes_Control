package com.example.diabetescontrol.data.mapper

import com.example.diabetescontrol.data.models.ProductDto
import com.example.diabetescontrol.domain.ProductInfo

class ProductMapper {

    fun mapDtoToProductInfoList(dto: ProductDto): List<ProductInfo>{
        val result = mutableListOf<ProductInfo>()
        for (i in dto.hints){
            val item = ProductInfo(
                image = i.food.image,
                label = i.food.label,
                carbohydrates = roundDouble(i.food.nutrients.CHOCDF),
                fats = roundDouble(i.food.nutrients.FAT),
                proteins = roundDouble(i.food.nutrients.PROCNT),
                energy = roundDouble(i.food.nutrients.ENERC_KCAL)

            )
            result.add(item)
        }
        return result
    }

    //Round double numbers to numbers with 2 numbers after dot
    private fun roundDouble(num: Double): Double{
        return "%.2f".format(num).replace(",",".").toDouble()
    }
}