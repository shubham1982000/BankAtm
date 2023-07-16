package bank.management.system;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

public class SendSMS {

    public static void sendSms(String formno,String cardno,String pin, String number){

        try {
            String message = "(SSM Project)Dear Customer Your Cardno :"+cardno+" and pin : "+pin+ "for Customer id:"+formno;
            String apiKey  = "DRgGeoUWQEjbmutZpkS3iCaH5OPYyM7q4sfFXdvA6h1IBrzNV2JzXdSRBxaqFZGLgr62HTACfDWMKt3c";
            String sendId = "TXTIND";
            //Important step...
            message = URLEncoder.encode(message,"UTF-8");
            String language = "english";
            String route = "p";
//           HttpResponse response = Unirest.get("https://www.fast2sms.com/dev/bulkV2?authorization=YOUR_API_KEY&sender_id=TXTIND&message=This is a test message&route=v3&numbers=9999999999,8888888888,7777777777")

            String myurl = "https://www.fast2sms.com/dev/bulkV2?authorization="+apiKey+"&sender_id="+sendId+"&message="+message+"&route="+route+"&numbers="+number;

            System.out.println(myurl);

//           Sending get request
            URL url = new URL(myurl);
            HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent","Mozilla/5.0");
            con.setRequestProperty("cache-control","no-cache");

            System.out.println("wait...........");
            int code  = con.getResponseCode();

            System.out.println("Response Code : "+code);

            StringBuffer response = new StringBuffer();

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            while(true){
                String  line = br.readLine();
                if(line == null){
                    break;
                }
                response.append(line);
            }
            System.out.println(response);



        }catch (Exception e){
            e.printStackTrace();
        }
    }

}