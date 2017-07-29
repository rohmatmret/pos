package pos;

/**
 *
 * @author rohmat
 */
public class terbilang {
    String[] nominal ={"","satu","dua","tiga","empat","lima","enam","tujuh","delapan","sembilan","sepuluh","sebelas","dua belas"};
    
    public String bilang(Integer angka)
    {
        if(angka < 12){
            return nominal[angka];
        }else if(angka >=12 && angka <19){
            return nominal[angka % 10] + "belas";
        }else if(angka >=19 && angka<=99){
            return nominal[angka / 10 ]+"puluh"+nominal[angka % 10 ];
        }else if(angka >=100 && angka <=199){
            return nominal[angka / 100 ]+"ratus"+nominal[angka % 10 ];
        }else if(angka >=200 && angka<=999){
            return nominal[angka / 1000 ]+"ribu"+nominal[angka % 10 ];
        }else if(angka >=1000 && angka <=1999){
            return "Seribu"+nominal[angka % 1000];
        }else if(angka >= 2000 && angka <=999999){
            return bilang((int)angka/1000)+" ribu "+bilang(angka%1000);
        }
        return null;
        
    }
}
