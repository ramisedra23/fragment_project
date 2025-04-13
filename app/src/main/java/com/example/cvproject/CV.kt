
import java.io.Serializable

data class CV(
      val id: Int =0,
      val firstName: String,
      val lastName: String,
      val email: String,
      val phoneNumber: String,
      val birthDate: String,
      val uniName: String,
      val linkedIn: String=""


) : Serializable
