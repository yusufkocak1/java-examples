package jsoup_example;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class jsoup {
	public void html_string() {
		String html = "<html><head><title>Sample Title</title></head>"
				+ "<body><p>Sample Content</p></body></html>";
		Document document = Jsoup.parse(html);
		System.out.println(document.title());
		Elements paragraphs = document.getElementsByTag("p");
		for (Element paragraph : paragraphs) {
			System.out.println(paragraph.text());
		}
	}

	// login i�lemi farkl� sitelerde farkl� �al��abiliyor.
	public String login(String user, String pass) {
		Document document = null;
		try {
			Response response = Jsoup
					.connect("https://lettmess.com/Home/Login/tr")//giri� yapaca��m�z site url
					.userAgent("Mozilla/5.0")//san�r�m oturum y�netim sistemi ismi tam bilmiyorum
					.timeout(10 * 1000)//tahmin etmek g�� de�il san�r�m..
					.method(Method.POST)//bunu 4.s�n�fta g�r�rs�n�z
					.data("email", user)
					.data("password", pass)
					.followRedirects(true)//y�nlendirdi�i siteye gitmeyi sa�l�yor
					.execute();//formu submit ediyor

			document = response.parse();

		} catch (IOException ioe) {
			System.out.println("Exception: " + ioe);
		}

		return document.getElementsByClass("userpin").text();

	}

	public void connection_url() {
		String url = "https://www.google.com.tr/search?client=opera&q=hava+durumu&sourceid=opera&ie=UTF-8&oe=UTF-8";
		Document document;
		try {
			document = Jsoup.connect(url).get();
			System.out.println(document.getElementById("wob_loc").text());
			System.out.println(document.getElementById("wob_dts").text());
			System.out.println(document.getElementById("wob_dcp").text());
			System.out.println(document.getElementById("wob_tm").text());
			// System.out.println(document.getElementsByClass("wob_t").text());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
