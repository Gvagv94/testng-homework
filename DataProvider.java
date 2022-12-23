   public class DataProvider {
        @org.testng.annotations.DataProvider(name = "RegistrationDataProvider")
        public Object [][]  getdata  () {
            return new Object[][]
                    { {"Michael", "Brown", "123456789" }, {"Jonh", "Walker", "987654321"}, {"Jimmy", "Lee", "321654987"} };
        }

    }

