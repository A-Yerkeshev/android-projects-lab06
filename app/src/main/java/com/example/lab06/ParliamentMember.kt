package Classworks.cw06_09

data class ParliamentMember(val hetekaId: Int,
                       var seatNumber: Int,
                       var lastname: String,
                       var firstname: String,
                       var party: String,
                       val minister: Boolean = false,
                       var pictureUrl: String) {
}