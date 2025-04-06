
import com.example.cvproject.R
import java.io.Serializable

data class UserData(
      val   firstName : String  = "Rami" ,
      val   lastName : String = "AL Ashhab" ,
      val   email : String = "ramisedra235@gmail.com"  ,
      val   phoneNumber : String  = "0790167276",
      val   picture : Int = R.drawable.photo3,
      val   birthDate : String = "18/12/2003",
      val   uniName : String = "al balqa applied university",
      val   linkedIn : String = "https://www.linkedin.com/in/suhaib-kamal-2b8b1346/"

      
) : Serializable
