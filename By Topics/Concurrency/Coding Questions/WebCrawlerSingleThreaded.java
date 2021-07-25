import java.util.*;

public class WebCrawlerSingleThreaded {

    public List<String> crawler(String startUrl)
    {
        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(startUrl);
        
        while(!stack.isEmpty())
        {
            String currentUrl = stack.pop();
            visited.add(currentUrl);
            List<String> urls = getUrls(currentUrl);
            for(String url : urls)
            {
                if(!visited.contains(url))
                {
                    stack.push(url);
                }
            }
        }

        return new ArrayList<>(visited);
    }

    public List<String> getUrls(String startUrl)
    {
        return null;        
    }
}
