package com.example.watermate.utils.converters

import com.example.watermate.utils.interfaces.IWaterIntakeInGlassesConverter

// Конкретная реализация интерфейса IWaterIntakeInGlassesConverter по умолчанию
class DefaultWaterIntakeInGlassesConverter : IWaterIntakeInGlassesConverter {
    override fun calculateWaterIntakeInGlasses(waterIntake: Double, glassVolume: Int): Int {
        return (waterIntake / glassVolume).toInt() // Возвращаем целую часть от деления объема воды на объем стакана
    }
}