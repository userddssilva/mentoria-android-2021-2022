package com.example.mentoria_i_myapplication

/*
     * 0 "Dimensions.Height",
     * 1 "Dimensions.Length",
     * 2 "Dimensions.Width",
     * 3 "Engine Information.Driveline",
     * 4 "Engine Information.Engine Type",
     * 5 "Engine Information.Hybrid",
     * 6 "Engine Information.Number of Forward Gears",
     * 7 "Engine Information.Transmission",
     * 8 "Fuel Information.City mpg",
     * 9 "Fuel Information.Fuel Type",
     * 10 "Fuel Information.Highway mpg",
     * 11 "Identification.Classification",
     * 12 "Identification.ID",
     * 13 "Identification.Make",
     * 14 "Identification.Model Year",
     * 15 "Identification.Year",
     * 16 "Engine Information.Engine Statistics.Horsepower",
     * 17 "Engine Information.Engine Statistics.Torque"
     * */

data class Cars(
    val engineType: String? = "", // 4
    val numberForwardGears: String? = "", // 6
    val modelYear:String? = "", // 14
    val horsepower: String? = "" // 16
)
