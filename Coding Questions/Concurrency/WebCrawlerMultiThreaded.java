/*
    Given a url startUrl and an interface HtmlParser, implement a Multi-threaded web crawler to crawl all links that are under the same hostname as startUrl. 

    Return all urls obtained by your web crawler in any order.

    Your crawler should:

    Start from the page: startUrl
    Call HtmlParser.getUrls(url) to get all urls from a webpage of given url.
    Do not crawl the same link twice.
    Explore only the links that are under the same hostname as startUrl.

*/

import java.util.*;

public class WebCrawlerMultiThreaded {
    Set<String> visited = new HashSet();

    public List<String> crawler(String startUrl)
    {
        visited.add(startUrl);
        int N = 2;
        Thread[] thread = new Thread[N];

        for(int i = 0; i < N; i++)
        {
            thread[i] = new Thread(new Runnable()
            {
               public void run()
               {
                   dfs(startUrl);
               }

               public void dfs(String starturl)
               {
                    List<String> urls = getUrls(startUrl);
                    for(String url : urls)
                    {
                        if(!visited.contains(url))
                        {
                            visited.add(url);
                            dfs(url);
                        }
                    }
               }
            });
            thread[i].start();
        }

        for(int i = 0; i < N; i++)
        {
            try {
                thread[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        List<String> res = new ArrayList<>();
        res.addAll(visited);
        return res;
    }

    public List<String> getUrls(String startUrl)
    {
        return null;        
    }

}