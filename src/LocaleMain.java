import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by admin on 2017-05-10.
 */
public class LocaleMain {

    private static ResourceBundle bundle = null;

    public synchronized static ResourceBundle getBundleInstance(){
        if(bundle == null){
            bundle = ResourceBundle.getBundle("resource", new Locale("en","US"));
        }
        return bundle;
    }

    public static void setBundle(Locale locale){
        bundle = ResourceBundle.getBundle("resource", locale);
    }

    public static void main(String[] args) throws Exception {

        // hello 출력
        System.out.println(getBundleInstance().getString("TEST"));

        // 한국 properties 로 변경
        setBundle(new Locale("ko","KR"));

        // 하이 출력
        System.out.println(new String(getBundleInstance().getString("TEST").getBytes("8859_1"),"euc-kr"));
    }

}

