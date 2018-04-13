package spider1.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import spider1.model.Item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : jiang
 * @time : 2018/4/4 16:57
 */
public class ParseHtml {

    private boolean isFind = false;

    public List<Item> getCurrentPageItems(String html, String lastTitle) throws IOException {
        ArrayList<Item> items = new ArrayList<>();
        Document parse = Jsoup.parse(html);
        Element body = parse.body();
        Element element = body.select("div#forumnew").first();
        Element table = element.nextElementSibling();
        Elements tbodys = table.select("tbody");
        for (Element tbody1 : tbodys) {
            element = tbody1;
            String title = element.select("a.xst").first().html();
            if (title.equals(lastTitle)) {
                isFind = true;
                break;
            }
            Item item = new Item();
            item.setTitle(title);
            Element tbody = element.select("tbody").first();
            Elements tds = tbody.select("td");
            for (int i = 0; i < tds.size(); i++) {
                Element td = tds.get(i);
                switch (i) {
                    case 0:
                        item.setUrl("https://www.52pojie.cn/" + td.select("a").first().attr("href"));
                        Element span = td.select("span").first();
                        if (span != null) {
                            item.setAuthorityLevel(span.html());
                        }
                        break;
                    case 1:
                        item.setPartition(td.select("a").first().html());
                        break;
                    case 2:
                        item.setAuther(td.select("a").first().html());
                        item.setPublishTime(td.select("span").first().html());
                        break;
                    case 3:
                        item.setReplyNum(td.select("a").first().html());
                        item.setViewNum(td.select("em").first().html());
                        break;
                    case 4:
                        item.setLastReplyName(td.select("a").first().html());
                        item.setLastReplyTime(td.select("em").first().html());
                        item.setLastReplyUrl("https://www.52pojie.cn/" + td.select("a").first().attr("href"));
                        break;
                }
            }
            parseLink(item);
            items.add(item);
        }
        return items;
    }

    private void parseLink(Item item) throws IOException {
        if (item.getAuthorityLevel() == null) {
            OkHttpClient client = new OkHttpClient();
            String url = item.getUrl();
            Request build = new Request.Builder().url(url).build();
            Response response = client.newCall(build).execute();
            if (response.isSuccessful()) {
                String str = response.body().string();
                Matcher matcher = Pattern.compile("[^\"](https://pan.baidu.com/s/[\\w\\-0-9_]+[a-zA-Z_0-9])((?!https).)+密码: " +
                        "?([a-zA-Z0-9]{4})[^a-zA-Z0-9]").matcher(str);
                StringBuilder links = new StringBuilder();
                StringBuilder pwds = new StringBuilder();
                while (matcher.find()) {
                    if (links.indexOf(matcher.group(1)) == -1) {
                        links.append(matcher.group(1)).append(";");
                        pwds.append(matcher.group(3)).append(";");
                    }
                }
                if (!links.toString().equals("")) {
                    item.setLinksAndPwdsStr(links.toString() + "#;#" + pwds.toString());
                }
            }
        }
    }

    @Test
    public void testLink() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request build = new Request.Builder().url("https://www.52pojie.cn/thread-719615-1-1.html").build();
        Response response = client.newCall(build).execute();
        if (response.isSuccessful()) {
            String string = response.body().string();
            Matcher authLevel = Pattern.compile("抱歉，本帖要求阅读权限高于\\d+才能浏览").matcher(string);
            System.out.println(string);
            if (authLevel.find()) {
                System.out.println("需要权限");
            } else {
                Matcher matcher = Pattern.compile("[^\"](https://pan.baidu.com/s/[\\w\\-0-9_]+[a-zA-Z_0-9])((?!https).)+密码:" +
                        " ?([a-zA-Z0-9]{4})[^a-zA-Z0-9]").matcher(string);
                while (matcher.find()) {
                    System.out.println("match = " + matcher.group(1) + "--" + matcher.group(3));
                }
            }
        }
    }

    public boolean isFind(){
        return isFind;
    }

    public ParseHtml setFind(boolean find) {
        isFind = find;
        return this;
    }
}




















