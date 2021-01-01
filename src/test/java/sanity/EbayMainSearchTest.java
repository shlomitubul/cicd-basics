package sanity;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.SearchResultPage;
import pages.components.MainSearchArea;

public class EbayMainSearchTest extends BaseTest {
    boolean isResultContainsText;

    @Test
    @Parameters({"searchable","resultContainsText"})
    public void search_result_should_contains_text(String text, final String result) {
        MainSearchArea mainSearchArea = new MainSearchArea(driver,wait);
        mainSearchArea.search(text);

        SearchResultPage searchResultPage = new SearchResultPage(driver,wait);

        isResultContainsText = searchResultPage.searchResults.stream().anyMatch(element ->
                element.getText().toLowerCase().contains(result.toLowerCase()));

        Assert.assertTrue(isResultContainsText,"non of the products name contain " + result + "!!!");
    }
}
