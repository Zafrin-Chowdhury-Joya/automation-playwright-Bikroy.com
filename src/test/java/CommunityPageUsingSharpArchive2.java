

import com.automation.base.BaseTest;
import com.microsoft.playwright.Page;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CommunityPageUsingSharpArchive2 extends BaseTest {

	@BeforeClass(alwaysRun = true)
	public void setup() {
	    try {
	        page.navigate("https://sharparchive.com/");

	        // Accept cookies if any
	        if (page.isVisible("//button[normalize-space()='Accept']", new Page.IsVisibleOptions().setTimeout(5000))) {
	            page.click("//button[normalize-space()='Accept']");
	        }

	        // Scroll to footer so that Community link is visible
	        page.evaluate("window.scrollTo(0, document.body.scrollHeight)");

	        // Click on Community in footer
	        page.waitForSelector("(//p[normalize-space()='Community'])[1]", new Page.WaitForSelectorOptions().setTimeout(15000));
	        page.click("(//p[normalize-space()='Community'])[1]");

	        // Click Using Sharp Archive link
	        page.waitForSelector("(//a[normalize-space()='Using Sharp Archive'])[1]", new Page.WaitForSelectorOptions().setTimeout(15000));
	        page.click("(//a[normalize-space()='Using Sharp Archive'])[1]");

	    } catch (Throwable t) {
	        System.err.println("⚠️ Setup failed: " + t.getMessage());
	    }
	}


    private String normalizeText(String text) {
        // Replace multiple spaces, tabs, newlines with a single space, then trim
        return text.replaceAll("\\s+", " ").trim();
    }
    @Test(priority = 95)
    public void verifyPinterestDataTypesText() {
        page.click("//p[contains(text(),'What types of Pinterest')]");

        String actualQuestion = page.textContent("//p[contains(text(),'What types of Pinterest')]");
        String expectedQuestion = "What types of Pinterest data can be archived with Sharp Archive?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Pinterest data types question mismatch!");

        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Sharp Archive can archive Pinterest posts, including post Title, images, videos, descriptions.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Pinterest data types answer mismatch!");

        page.goBack();
    }
    @Test(priority = 96)
    public void verifyPinterestCommentsArchiveText() {
        page.click("(//p[contains(text(),'Can Sharp Archive archive Pinterest')])[2]");

        String actualQuestion = page.textContent("(//p[contains(text(),'Can Sharp Archive archive Pinterest')])[2]");
        String expectedQuestion = "Can Sharp Archive archive Pinterest comments under pins?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Pinterest comments question mismatch!");

        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "No, Sharp Archive can’t archive comments under Pinterest pins.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Pinterest comments answer mismatch!");

        page.goBack();
    }

    @Test(priority = 97)
    public void verifyPinterestDeletedPinsDisplayText() {
        page.click("(//p[contains(text(),'Can Sharp Archive display')])[19]");

        String actualQuestion = page.textContent("(//p[contains(text(),'Can Sharp Archive display')])[19]");
        String expectedQuestion = "Can Sharp Archive display deleted Pinterest pins?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Pinterest deleted pins question mismatch!");

        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "No, Sharp Archive can display deleted Pinterest pins.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Pinterest deleted pins answer mismatch!");

        page.goBack();
    }
    @Test(priority = 98)
    public void verifyPinterestEditArchivedDataText() {
        page.click("(//p[contains(text(),'Is it possible to')])[11]");

        String actualQuestion = page.textContent("(//p[contains(text(),'Is it possible to')])[11]");
        String expectedQuestion = "Is it possible to edit archived Pinterest data using Sharp Archive?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Pinterest edit archived data question mismatch!");

        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "No, it is not possible to edit archived Pinterest data using Sharp Archive.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Pinterest edit archived data answer mismatch!");

        page.goBack();
    }

    @Test(priority = 99)
    public void verifyPinterestFollowersFollowingArchiveText() {
        page.click("(//p[contains(text(),'Can Sharp Archive archive Pinterest')])[5]");

        String actualQuestion = page.textContent("(//p[contains(text(),'Can Sharp Archive archive Pinterest')])[5]");
        String expectedQuestion = "Can Sharp Archive archive Pinterest followers or following lists?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Pinterest followers/following question mismatch!");

        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "No, Sharp Archive does not archive Pinterest followers or following lists.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Pinterest followers/following answer mismatch!");

        page.goBack();
    }

    @Test(priority = 100)
    public void verifyPinterestBoardsArchiveText() {
        page.click("//div[@id='usingSharpArchive6']//li[@id='questions2']//p[1]");

        String actualQuestion = page.textContent("//h2[@class='text-orange-dark font-bold pb-5']//p[1]");
        String expectedQuestion = "Can Sharp Archive archive Pinterest boards?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Pinterest boards question mismatch!");

        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Yes, Sharp Archive can archive entire Pinterest boards, including all pins, descriptions, and board titles.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Pinterest boards answer mismatch!");

        page.goBack();
    }

    @Test(priority = 101)
    public void verifyPinterestLikesArchiveText() {
        page.click("(//p[contains(text(),'Can Sharp Archive archive Pinterest')])[3]");

        String actualQuestion = page.textContent("(//p[contains(text(),'Can Sharp Archive archive Pinterest')])[3]");
        String expectedQuestion = "Can Sharp Archive archive Pinterest likes under pins?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Pinterest likes question mismatch!");

        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "No, Sharp Archive can archive Pinterest likes under pins";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Pinterest likes answer mismatch!");

        page.goBack();
    }
    @Test(priority = 102)
    public void verifyPinterestVideosDisplayText() {
        page.click("//div[@id='usingSharpArchive6']//li[@id='questions6']//p[1]");

        String actualQuestion = page.textContent("//h2[@class='text-orange-dark font-bold pb-5']//p[1]");
        String expectedQuestion = "Can Sharp Archive display Pinterest videos?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Pinterest videos display question mismatch!");

        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "No, Sharp Archive can’t display Pinterest videos.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Pinterest videos display answer mismatch!");

        page.goBack();
    }

    @Test(priority = 103)
    public void verifyPinterestMessagesArchiveText() {
        page.click("//div[@id='usingSharpArchive6']//li[@id='questions8']//p[1]");

        String actualQuestion = page.textContent("//h2[@class='text-orange-dark font-bold pb-5']//p[1]");
        String expectedQuestion = "Can Sharp Archive archive Pinterest messages?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Pinterest messages archive question mismatch!");

        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "No, Sharp Archive does not archive Pinterest messages, as it focuses on archiving posts and boards.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Pinterest messages archive answer mismatch!");

        page.goBack();
    }
    @Test(priority = 104)
    public void verifyPinterestInteractionCapabilitiesText() {
        page.click("(//p[contains(text(),'Does Sharp Archive offer any')])[2]");

        String actualQuestion = page.textContent("(//p[contains(text(),'Does Sharp Archive offer any')])[2]");
        String expectedQuestion = "Does Sharp Archive offer any interaction capabilities on Pinterest?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Pinterest interaction capabilities question mismatch!");

        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "No, Sharp Archive does not offer interaction capabilities; it is purely an archiving tool.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Pinterest interaction capabilities answer mismatch!");

        page.goBack();
    }
    @Test(priority = 105)
    public void verifyRedditDataTypesArchived() {
        page.click("(//p[contains(text(),'What types of')])[4]");

        String actualQuestion = page.textContent("(//p[contains(text(),'What types of')])[4]");
        String expectedQuestion = "What types of data can be archived from Reddit using Sharp Archive?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Reddit data types question mismatch!");

        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Sharp Archive can archive Reddit posts, including the title, description, images, videos, polls, and comments. Additionally, metadata such as the posted date, approval status, and whether the post is saved, hidden, or marked as spam can also be archived.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Reddit data types answer mismatch!");

        page.goBack();
    }

    @Test(priority = 106)
    public void verifyRedditDisplayDeletedPosts() {
        page.click("(//p[contains(text(),'Can Sharp Archive display')])[23]");

        String actualQuestion = page.textContent("(//p[contains(text(),'Can Sharp Archive display')])[23]");
        String expectedQuestion = "Can Sharp Archive display deleted Reddit posts?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Reddit deleted posts question mismatch!");

        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Sharp Archive can display deleted Reddit posts only if they were archived before being deleted. Posts deleted before archiving cannot be retrieved.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Reddit deleted posts answer mismatch!");

        page.goBack();
    }

    @Test(priority = 107)
    public void verifyRedditArchiveComments() {
        page.click("(//p[contains(text(),'Can Sharp Archive archive')])[47]");

        String actualQuestion = page.textContent("(//p[contains(text(),'Can Sharp Archive archive')])[47]");
        String expectedQuestion = "Can Sharp Archive archive comments under Reddit posts?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Reddit archive comments question mismatch!");

        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Yes, Sharp Archive can archive comments under Reddit posts, along with metadata such as approval status, save status, and spam markers.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Reddit archive comments answer mismatch!");

        page.goBack();
    }
    @Test(priority = 108)
     public void verifyRedditSaveMetadata() {
        page.click("(//p[contains(text(),'Can Sharp Archive save')])[1]");

        String actualQuestion = page.textContent("//p[contains(text(),'Can Sharp Archive save the')]");
        String expectedQuestion = "Can Sharp Archive save the meta data of Reddit posts, such as the posted date and save status?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Reddit metadata save question mismatch!");

        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Yes, Sharp Archive can save and display metadata, including the posted date, whether the post was saved, hidden, or marked as spam.\n";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Reddit metadata save answer mismatch!");

        page.goBack();
    }

 

    @Test(priority = 109)
    public void verifyRedditModerationCapabilities() {
        page.click("(//p[contains(text(),'Does Sharp Archive offer')])[8]");

        String actualQuestion = page.textContent("(//p[contains(text(),'Does Sharp Archive offer')])[8]");
        String expectedQuestion = "Does Sharp Archive offer moderation capabilities for Reddit?\n";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Reddit moderation capabilities question mismatch!");

        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "No, Sharp Archive does not offer moderation capabilities. It is solely an archiving tool.\n";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Reddit moderation capabilities answer mismatch!");

        page.goBack();
    }

    @Test(priority = 110)
    public void verifyRedditDisplayAllArchivedPosts() {
        page.click("//span[normalize-space()='all archived Reddit posts']");

        String actualQuestion = page.textContent("//h2[@class='text-orange-dark font-bold pb-5']//p[1]");
        String expectedQuestion = "Can Sharp Archive display all archived Reddit posts?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Reddit display all archived posts question mismatch!");

        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Yes, Sharp Archive can display all archived Reddit posts, including text, images, videos, polls, and comments.\n";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Reddit display all archived posts answer mismatch!");

        page.goBack();
    }

    @Test(priority = 111)
    public void verifyRedditEditArchivedData() {
        page.click("(//p[contains(text(),'Is it possible to')])[12]");

        String actualQuestion = page.textContent("(//p[contains(text(),'Is it possible to')])[12]");
        String expectedQuestion = "Is it possible to edit archived Reddit data using Sharp Archive?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Reddit edit archived data question mismatch!");

        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "No, it is not possible to edit archived data using Sharp Archive. The tool is designed for archiving and viewing, not for modifying content.\n";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Reddit edit archived data answer mismatch!");

        page.goBack();
    }

    @Test(priority = 112)
    public void verifyRedditDisplayApprovalStatus() {
        page.click("(//p[contains(text(),'Can Sharp Archive display the')])[7]");

        page.goBack();
    }
    @Test(priority = 113)
    public void verifyRedditArchivePolls() {
        page.click("//div[@id='usingSharpArchive7']//li[@id='questions8']//p[1]");

        String actualQuestion = page.textContent("//h2[@class='text-orange-dark font-bold pb-5']//p[1]");
        String expectedQuestion = "Can Sharp Archive archive and display Reddit polls?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Reddit polls question mismatch!");

        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Yes, Sharp Archive can archive and display Reddit polls, including the poll question, options, and the votes received.\n";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Reddit polls answer mismatch!");

        page.goBack();
    }
    @Test(priority = 114)
    public void verifyMicrosoftMailArchivedDataTypes() {
        page.click("(//p[contains(text(),'What types of')])[5]");

        String actualQuestion = page.textContent("(//p[contains(text(),'What types of')])[5]");
        String expectedQuestion = "What types of data can be archived from Microsoft Mail using Sharp Archive?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Microsoft Mail data types question mismatch!");

        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Sharp Archive can archive all types of emails, including incoming, outgoing, junk, and permanently deleted mail.\n";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Microsoft Mail data types answer mismatch!");

        page.goBack();
    }

    @Test(priority = 115)
    public void verifyMicrosoftMailDisplayDeletedEmails() {
        page.click("//p[contains(text(),'Can Sharp Archive display permanently')]");

        String actualQuestion = page.textContent("//p[contains(text(),'Can Sharp Archive display permanently')]");
        String expectedQuestion = "Can Sharp Archive display permanently deleted emails from Microsoft Mail?\n";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Microsoft Mail deleted emails question mismatch!");

        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Sharp Archive can display permanently deleted emails, provided they were archived before deletion.\n";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Microsoft Mail deleted emails answer mismatch!");

        page.goBack();
    }

    @Test(priority = 116)
    public void verifyMicrosoftMailArchiveAttachments() {
        page.click("(//p[contains(text(),'Is it possible to archive')])[2]");

        String actualQuestion = page.textContent("(//p[contains(text(),'Is it possible to archive')])[2]");
        String expectedQuestion = "Is it possible to archive attachments in emails using Sharp Archive?\n";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Microsoft Mail archive attachments question mismatch!");

        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Yes, Sharp Archive can archive attachments along with the emails from Microsoft Mail.\n";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Microsoft Mail archive attachments answer mismatch!");

        page.goBack();
    }

    @Test(priority = 117)
    public void verifyMicrosoftMailDisplayAllArchivedEmails() {
        page.click("(//p[contains(text(),'Can Sharp Archive display')])[26]");

        String actualQuestion = page.textContent("(//p[contains(text(),'Can Sharp Archive display')])[26]");
        String expectedQuestion = "Can Sharp Archive display all archived emails from Microsoft Mail?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Microsoft Mail display archived emails question mismatch!");

        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Yes, Sharp Archive can display all archived emails from Microsoft Mail, including those from the inbox, sent items, junk, and deleted items.\n";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Microsoft Mail display archived emails answer mismatch!");

        page.goBack();
    }

    @Test(priority = 118)
    public void verifyMicrosoftMailStoreJunkEmails() {
        page.click("//p[contains(text(),'Can Sharp Archive store emails that have been mark')]");

        String actualQuestion = page.textContent("//p[contains(text(),'Can Sharp Archive store emails that have been mark')]");
        String expectedQuestion = "Can Sharp Archive store emails that have been marked as junk in Microsoft Mail?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Microsoft Mail junk emails question mismatch!");

        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Yes, Sharp Archive can store and display emails that have been marked as junk in Microsoft Mail.\n";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Microsoft Mail junk emails answer mismatch!");

        page.goBack();
    }
    @Test(priority = 119)
    public void verifyMicrosoftMailArchiveDrafts() {
        // Click on the specific question
        page.click("(//p[contains(text(),'Can Sharp Archive archive')])[49]");

        // Validate the question text
        String actualQuestion = page.textContent("(//p[contains(text(),'Can Sharp Archive archive')])[49]");
        String expectedQuestion = "Can Sharp Archive archive drafts from Microsoft Mail?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Microsoft Mail archive drafts question mismatch!");

        // Validate the answer text
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Sharp Archive can archive drafts, provided they are included in the archiving process.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Microsoft Mail archive drafts answer mismatch!");

        // Navigate back
        page.goBack();
    }
    @Test(priority = 120)
    public void verifyMicrosoftMailCalendarEventsArchiving() {
        page.click("//div[@id='usingSharpArchive8']//li[@id='questions7']//p[1]");
        String actualQuestion = page.textContent("//div[@id='usingSharpArchive8']//li[@id='questions7']//p[1]");
        String expectedQuestion = "Can Sharp Archive archive Microsoft Mail calendar events?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Microsoft Mail calendar events question mismatch!");

        // Verify the answer text
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "No, Sharp Archive is designed to archive email data only and does not archive calendar events from Microsoft Mail.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Microsoft Mail calendar events answer mismatch!");

        // Go back to the previous page
        page.goBack();
    }
    @Test(priority = 121)
    public void verifyMicrosoftMailContactsArchiveText() {
        // Click on the question
        page.click("//div[@id='usingSharpArchive8']//li[@id='questions8']//p[1]");

        // Validate the question text
        String actualQuestion = page.textContent("//div[@id='usingSharpArchive8']//li[@id='questions8']//p[1]");
        String expectedQuestion = "Can Sharp Archive archive Microsoft Mail contacts?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");

        // Validate the answer text
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "No, Sharp Archive focuses on archiving emails and does not archive contact information from Microsoft Mail.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }
    @Test(priority = 122)
    public void verifyEditArchivedEmailsText() {
        // Click on the question
        page.click("(//p[contains(text(),'Is it possible to')])[14]");

        // Validate the question text
        String actualQuestion = page.textContent("(//p[contains(text(),'Is it possible to')])[14]");
        String expectedQuestion = "Is it possible to edit archived emails using Sharp Archive?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");

        // Validate the answer text
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "No, it is not possible to edit archived emails using Sharp Archive.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }
    @Test(priority = 123)
    public void verifyMicrosoftMailFolderArchivingText() {
        // Click on the question
        page.click("//p[contains(text(),'Does Sharp Archive support archiving of email')]");

        // Validate the question text
        String actualQuestion = page.textContent("//p[contains(text(),'Does Sharp Archive support archiving of email')]");
        String expectedQuestion = "Does Sharp Archive support archiving of email folders from Microsoft Mail?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");

        // Validate the answer text
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Yes, Sharp Archive can archive entire email folders from Microsoft Mail.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }
    @Test(priority = 124)
    public void verifySharedMailboxDisplayText() {
        // Click on the question
        page.click("(//p[contains(text(),'Can Sharp Archive display emails from')])[1]");

        // Validate the question text
        String actualQuestion = page.textContent("//p[contains(text(),'Can Sharp Archive display emails from')]");
        String expectedQuestion = "Can Sharp Archive display emails from shared mailboxes in Microsoft Mail?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");

        // Validate the answer text
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Yes, Sharp Archive can display emails from shared mailboxes if they are included in the archive.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }
    @Test(priority = 125)
    public void verifySearchFunctionalityInMicrosoftMailText() {
        // Click on the question
        page.click("//p[contains(text(),'Does Sharp Archive allow for')]");

        // Validate the question text
        String actualQuestion = page.textContent("//p[contains(text(),'Does Sharp Archive allow for')]");
        String expectedQuestion = "Does Sharp Archive allow for search functionality within archived Microsoft Mail emails?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");

        // Validate the answer text
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Yes, Sharp Archive provides search functionality to find specific emails within the archived Microsoft Mail data.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }
    @Test(priority = 126)
    public void verifyArchiveEmailsByDateRangeText() {
        // Click on the question
        page.click("//p[contains(text(),'Can Sharp Archive archive emails from Microsoft Ma')]");

        // Validate the question text
        String actualQuestion = page.textContent("//p[contains(text(),'Can Sharp Archive archive emails from Microsoft Ma')]");
        String expectedQuestion = "Can Sharp Archive archive emails from Microsoft Mail that are older than a certain date?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");

        // Validate the answer text
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Yes, Sharp Archive can archive emails based on specific date ranges, including older emails.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }
    @Test(priority = 127)
    public void verifyDisplayEmailsFromJunkFolderText() {
        // Click on the question
        page.click("//p[contains(text(),'Can Sharp Archive display emails from the Microsof')]");

        // Validate the question text
        String actualQuestion = page.textContent("//p[contains(text(),'Can Sharp Archive display emails from the Microsof')]");
        String expectedQuestion = "Can Sharp Archive display emails from the Microsoft Mail junk folder?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");

        // Validate the answer text
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Yes, Sharp Archive can display emails that were archived from the junk folder of Microsoft Mail.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }
    @Test(priority = 128)
    public void verifyArchiveSharedMicrosoftMailFoldersText() {
        // Click on the question
        page.click("(//p[contains(text(),'Can Sharp Archive archive Microsoft Mail')])[3]");

        // Validate the question text
        String actualQuestion = page.textContent("(//p[contains(text(),'Can Sharp Archive archive Microsoft Mail')])[3]");
        String expectedQuestion = "Can Sharp Archive archive Microsoft Mail folders that are shared with others?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");

        // Validate the answer text
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Yes, Sharp Archive can archive shared folders if they are included in the archiving process.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }
    @Test(priority = 129)
    public void verifyViewDeletedMicrosoftMailEmailsText() {
        // Click on the question
        page.click("(//p[contains(text(),'Is it possible to view')])[4]");

        // Validate the question text
        String actualQuestion = page.textContent("(//p[contains(text(),'Is it possible to view')])[4]");
        String expectedQuestion = "Is it possible to view deleted Microsoft Mail emails through Sharp Archive?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");

        // Validate the answer text
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Yes, deleted emails can be viewed in Sharp Archive, provided they were archived before deletion.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }
    @Test(priority = 130)
    public void verifyArchivingMicrosoftMailInMultipleLanguagesText() {
        // Click on the question
        page.click("//p[contains(text(),'Does Sharp Archive support archiving Microsoft Mai')]");

        // Validate the question text
        String actualQuestion = page.textContent("(//p[contains(text(),'Does Sharp Archive support archiving Microsoft Mai')])[1]");
        String expectedQuestion = "Does Sharp Archive support archiving Microsoft Mail emails in different languages?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");

        // Validate the answer text
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Yes, Sharp Archive can archive emails in multiple languages as supported by Microsoft Mail.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }
    @Test(priority = 131)
    public void verifyReArchivePreviouslyArchivedEmailsText() {
        // Click on the question
        page.click("(//p[contains(text(),'Can Sharp Archive archive Microsoft Mail emails th')])[1]");

        // Validate the question text
        String actualQuestion = page.textContent("(//p[contains(text(),'Can Sharp Archive archive Microsoft Mail emails th')])[1]");
        String expectedQuestion = "Can Sharp Archive archive Microsoft Mail emails that have been archived before?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");

        // Validate the answer text
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Sharp Archive can archive and manage emails that were previously archived within Microsoft Mail, ensuring comprehensive data retention.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }
    @Test(priority = 132)
    public void verifyArchiveWebsiteAfterLoginText() {
        // Click on the question
        page.click("(//p[contains(text(),'How can I')])[2]");

        // Validate the question text
        String actualQuestion = page.textContent("(//p[contains(text(),'How can I')])[2]");
        String expectedQuestion = "How can I archive a website after logging in to Sharp Archive?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");

        // Validate the answer text
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "After logging in, click on the \"Add More feed\" button, select \"Website,\" and provide the website URL. The website will then need admin approval before appearing in your feed.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }
    @Test(priority = 133)
    public void verifyArchiveAllTypesOfWebsitesText() {
        // Click on the question
        page.click("(//p[contains(text(),'Can Sharp Archive archive')])[55]");

        // Validate the question text
        String actualQuestion = page.textContent("(//p[contains(text(),'Can Sharp Archive archive')])[55]");
        String expectedQuestion = "Can Sharp Archive archive all types of websites, including blogs and e-commerce sites?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");
        

        // Validate the answer text
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Yes, Sharp Archive can archive various types of websites, including blogs and e-commerce sites, as long as the content is accessible and falls within the scope of the archiving tool.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }
    @Test(priority = 134)
    public void verifyWebsiteAppearanceTimeInSharpArchiveText() {
        // Click on the question
        page.click("//p[contains(text(),'How long does it take for a website to')]");

        // Validate the question text
        String actualQuestion = page.textContent("//p[contains(text(),'How long does it take for a website to')]");
        String expectedQuestion = "How long does it take for a website to appear in Sharp Archive after submitting a URL?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");

        // Validate the answer text
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "The time it takes for a website to appear in Sharp Archive depends on the approval process and indexing time. Usually, it will be visible once it has been reviewed and approved by the admin.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }
    @Test(priority = 135)
    public void verifyViewArchivedWebsiteVersionsText() {
        // Click on the question
        page.click("//p[contains(text(),'Can I view archived')]");

        // Validate the question text
        String actualQuestion = page.textContent("//p[contains(text(),'Can I view archived')]");
        String expectedQuestion = "Can I view archived versions of a website using Sharp Archive?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");

        // Validate the answer text
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Yes, Sharp Archive allows you to view archived versions of a website, capturing the state of the site at the time of archiving.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }
    @Test(priority = 136)
    public void verifyGmailAccountTypesArchivingText() {
        // Click on the question
        page.click("//p[contains(text(),'What type of Gmail')]");

        // Validate the question text
        String actualQuestion = page.textContent("//p[contains(text(),'What type of Gmail')]");
        String expectedQuestion = "What type of Gmail accounts can be archived with Sharp Archive?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");

        // Validate the answer text
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Sharp Archive can archive both personal and business Gmail accounts.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }
    @Test(priority = 137)
    public void verifySpecificGmailDataArchivingText() {
        // Click on the question
        page.click("(//p[contains(text(),'What specific')])[4]");

        // Validate the question text
        String actualQuestion = page.textContent("(//p[contains(text(),'What specific')])[4]");
        String expectedQuestion = "What specific data from Gmail can be archived with Sharp Archive?\n";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");

        // Validate the answer text
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Sharp Archive can archive various types of Gmail data, including emails, attachments, sent items, received items, drafts, spam, and trash.\n";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }
    @Test(priority = 138)
    public void verifyChangedNewPAssword() {
        // Click on the question
        page.click("//p[contains(text(),'I changed my password on Gmail. How do I')]");
        page.goBack();
    }
    @Test(priority = 139)
    public void verifyDisplayAllGmailEmailsText() {
        // Click on the question
        page.click("//div[@id='usingSharpArchive10']//li[@id='questions4']//p[1]");

        // Validate the question text (note: this FAQ renders the question in the orange H2 area)
        String actualQuestion = page.textContent("//h2[@class='text-orange-dark font-bold pb-5']//p[1]");
        String expectedQuestion = "Can Sharp Archive display all Gmail emails?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");

        // Validate the answer text
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Yes, Sharp Archive can display all Gmail emails that were included in the archive before deletion. Emails deleted before archiving cannot be accessed.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }
    @Test(priority = 140)
    public void verifyViewDeletedGmailEmailsText() {
        // Click on the question
        page.click("(//p[contains(text(),'Is it possible to view')])[5]");

        // Validate the question text
        String actualQuestion = page.textContent("(//p[contains(text(),'Is it possible to view')])[5]");
        String expectedQuestion = "Is it possible to view deleted Gmail emails through Sharp Archive?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");

        // Validate the answer text
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Yes, deleted Gmail emails can be viewed through Sharp Archive if they were archived before being deleted. Emails deleted before the archiving process cannot be retrieved.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }
    @Test(priority = 141)
    public void verifySearchThroughArchivedGmailEmailsText() {
        // Click on the question
        page.click("(//a[@id='link6'])[9]");

        // Validate the question text
        String actualQuestion = page.textContent("//h2[contains(text(),'Is it possible to')]");
        String expectedQuestion = "Is it possible to search through archived Gmail emails?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");

        // Validate the answer text
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Yes, you can search through archived Gmail emails using keywords, dates, and other filters to quickly find specific messages.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }
    @Test(priority = 142)
    public void verifyArchiveGmailLabelsOrFoldersText() {
        // Click on the question
        page.click("//div[@id='usingSharpArchive10']//li[@id='questions7']//p[1]");

        // Validate the question text
        String actualQuestion = page.textContent("//h2[@class='text-orange-dark font-bold pb-5']//p[1]");
        String expectedQuestion = "Can Sharp Archive archive Gmail labels or folders?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");

        // Validate the answer text
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Sharp Archive does not archive Gmail labels or folders; it archives the emails and their content.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }
    @Test(priority = 143)
    public void verifyDisplayGmailAttachmentsText() {
        // Click on the question
        page.click("//div[@id='usingSharpArchive10']//li[@id='questions8']//p[1]");

        // Validate the question text
        String actualQuestion = page.textContent("//h2[@class='text-orange-dark font-bold pb-5']//p[1]");
        String expectedQuestion = "Can Sharp Archive display Gmail attachments?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");

        // Validate the answer text
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Yes, Sharp Archive can display Gmail attachments that are included in the archived emails.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }
    @Test(priority = 144)
    public void verifyGmailEmailSendingCapabilitiesText() {
        // Click on the question
        page.click("//p[contains(text(),'Does Sharp Archive offer email')]");

        // Validate the question text
        String actualQuestion = page.textContent("//p[contains(text(),'Does Sharp Archive offer email')]");
        String expectedQuestion = "Does Sharp Archive offer email sending capabilities for Gmail?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");

        // Validate the answer text
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "No, Sharp Archive does not offer email sending capabilities; it is designed for archiving purposes only.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");

        page.goBack();
    }
    @Test(priority = 145)
    public void verifyEditArchivedGmailDataText() {
        // Click on the question
        page.click("(//p[contains(text(),'Is it possible to')])[17]");

        // Validate the question text
        String actualQuestion = page.textContent("//p[contains(text(),'Is it possible to')]");
        String expectedQuestion = "Is it possible to edit archived data using Sharp Archive?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");

        // Validate the answer text
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "No, it is not possible to edit archived Gmail data using Sharp Archive. The archived data remains unchanged and viewable only.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");

        page.goBack();
    }
    @Test(priority = 146)
    public void verifyDownloadArchivedGmailEmailsText() {
        // Click on the question
        page.click("//a[@id='link11']//p[contains(text(),'Can I')]");

        // Validate the answer text
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Yes, users can download their archived Gmail emails from Sharp Archive for offline access or backup purposes.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");

        page.goBack();
    }
    @Test(priority = 147)
    public void verifyGmailDataSecurityText() {
        page.click("(//p[contains(text(),'How')])[9]");
        String actualQuestion = page.textContent("(//p[contains(text(),'How')])[9]");
        String expectedQuestion = "How secure is my archived Gmail data?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Sharp Archive uses advanced encryption and security protocols to ensure your archived Gmail data is protected from unauthorized access.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }

    @Test(priority = 148)
    public void verifyGmailDataThirdPartySharingText() {
        page.click("//p[contains(text(),'Is my Gmail data')]");
        String actualQuestion = page.textContent("//p[contains(text(),'Is my Gmail data')]");
        String expectedQuestion = "Is my Gmail data shared with third parties?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");
        page.goBack();
    }

    @Test(priority = 149)
    public void verifyGmailArchivingSetupText() {
        page.click("//p[contains(text(),'How do I set up Gmail')]");
        String actualQuestion = page.textContent("//p[contains(text(),'How do I set up Gmail')]");
        String expectedQuestion = "How do I set up Gmail Archiving in Sharp Archive?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Setting up Gmail Archiving involves connecting your Gmail account to Sharp Archive. Detailed setup instructions are provided within the platform, guiding you through the process step by step.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }

    @Test(priority = 150)
    public void verifyArchiveMultipleGmailAccountsText() {
        page.click("//p[contains(text(),'Can I archive')]");
        String actualQuestion = page.textContent("//p[contains(text(),'Can I archive')]");
        String expectedQuestion = "Can I archive multiple Gmail accounts?\n";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Sharp Archive supports archiving multiple Gmail accounts, allowing you to manage and access all your emails from a single platform.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }

    @Test(priority = 151)
    public void verifyGmailDataArchivingFrequencyText() {
        page.click("//div[@id='usingSharpArchive10']//li[@id='questions16']//p[1]");
        String actualQuestion = page.textContent("//h2[@class='text-orange-dark font-bold pb-5']//p[1]");
        String expectedQuestion = "How often is my Gmail data ?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "The archiving frequency can be configured based on your preferences, ranging from real-time archiving to scheduled intervals.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }

    @Test(priority = 152)
    public void verifyGmailDataLimitationsText() {
        page.click("//p[contains(text(),'Are there any')]");
        String actualQuestion = page.textContent("//p[contains(text(),'Are there any')]");
        String expectedQuestion = "Are there any limitations on the amount of Gmail data that can be archived?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "The amount of data you can archive may depend on your subscription plan with Sharp Archive. Higher-tier plans typically offer more storage capacity.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }

    @Test(priority = 153)
    public void verifyGmailStorageQuotaImpactText() {
        page.click("//p[contains(text(),'Will archiving emails in Sharp Archive affect my G')]");
        String actualQuestion = page.textContent("//p[contains(text(),'Will archiving emails in Sharp Archive affect my G')]");
        String expectedQuestion = "Will archiving emails in Sharp Archive affect my Gmail storage quota?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "No, archiving emails in Sharp Archive does not affect your Gmail storage quota. The data is stored separately within Sharp Archive's secure servers.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }
    @Test(priority = 154)
    public void verifyRingCentralAccountTypesText() {
        page.click("//p[contains(text(),'What type of RingCentral account can be archived w')]");
        String actualQuestion = page.textContent("//p[contains(text(),'What type of RingCentral account can be archived w')]");
        String expectedQuestion = "What type of RingCentral account can be archived with Sharp Archive?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "We archive text messages from any RingCentral account that supports text messaging functionality.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }

    @Test(priority = 155)
    public void verifySpecificRingCentralDataText() {
        page.click("//p[contains(text(),'What specific data from RingCentral can be archive')]");
        String actualQuestion = page.textContent("//p[contains(text(),'What specific data from RingCentral can be archive')]");
        String expectedQuestion = "What specific data from RingCentral can be archived with Sharp Archive?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "We archive all types of messages, including text messages (SMS), images, and videos sent through RingCentral.\n";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }

    @Test(priority = 156)
    public void verifyArchiveAllRingCentralMessagesText() {
        page.click("//p[contains(text(),'Can Sharp Archive archive all text messages sent t')]");
        String actualQuestion = page.textContent("//p[contains(text(),'Can Sharp Archive archive all text messages sent t')]");
        String expectedQuestion = "Can Sharp Archive archive all text messages sent through RingCentral?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Before the first archiving, we only archive text messages exchanged within the 24-hour period before archiving. After the first successful archive, we archive all text messages going forward.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }

    @Test(priority = 157)
    public void verifyArchive24HourRingCentralMessagesText() {
        page.click("//p[contains(text(),'Can Sharp Archive archive only text messages excha')]");
        String actualQuestion = page.textContent("//p[contains(text(),'Can Sharp Archive archive only text messages excha')]");
        String expectedQuestion = "Can Sharp Archive archive only text messages exchanged within 24 hours of archiving?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Only before the first archiving. After the first archive, we capture all text messages without any time restriction.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }

    @Test(priority = 158)
    public void verifyRingCentralOriginalFormatText() {
        page.click("//p[contains(text(),'Can Sharp Archive display text messages in their o')]");
        String actualQuestion = page.textContent("//p[contains(text(),'Can Sharp Archive display text messages in their o')]");
        String expectedQuestion = "Can Sharp Archive display text messages in their original format as they appear in RingCentral?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "While we archive the text content, the display format may differ from the RingCentral interface.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }

    @Test(priority = 159)
    public void verifyRingCentralMessagingCapabilitiesText() {
        page.click("//p[contains(text(),'Does Sharp Archive offer messaging capabilities di')]");
        String actualQuestion = page.textContent("//p[contains(text(),'Does Sharp Archive offer messaging capabilities di')]");
        String expectedQuestion = "Does Sharp Archive offer messaging capabilities directly within RingCentral?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "No, Sharp Archive is solely for archiving text messages and does not provide messaging capabilities.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }

    @Test(priority = 160)
    public void verifyArchiveRingCentralNonUserContactsText() {
        page.click("//p[contains(text(),'Can Sharp Archive archive text messages sent to Ri')]");
        String actualQuestion = page.textContent("//p[contains(text(),'Can Sharp Archive archive text messages sent to Ri')]");
        String expectedQuestion = "Can Sharp Archive archive text messages sent to RingCentral contacts who are not using RingCentral?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Yes, we can archive text messages exchanged with any contacts, regardless of whether they are using RingCentral.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }

    @Test(priority = 161)
    public void verifyArchiveRingCentralMultimediaText() {
        page.click("//p[contains(text(),'Can Sharp Archive archive multimedia content (imag')]");
        String actualQuestion = page.textContent("//p[contains(text(),'Can Sharp Archive archive multimedia content (imag')]");
        String expectedQuestion = "Can Sharp Archive archive multimedia content (images, videos) sent through RingCentral text messages?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Yes, we archive all types of messages, including text messages (SMS), images, and videos sent through RingCentral.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }

    @Test(priority = 162)
    public void verifyViewDeletedRingCentralMessagesText() {
        page.click("//p[contains(text(),'Is it possible to view deleted text messages from ')]");
        String actualQuestion = page.textContent("//p[contains(text(),'Is it possible to view deleted text messages from ')]");
        String expectedQuestion = "Is it possible to view deleted text messages from RingCentral through Sharp Archive?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "No, if a text message is deleted before archiving, it cannot be recovered.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }
    @Test(priority = 163)
    public void verifySpecificRingCentralDataText2() {
        page.click("//p[contains(text(),'What specific data from RingCentral can be archive')]");
        String actualQuestion = page.textContent("//p[contains(text(),'What specific data from RingCentral can be archive')]");
        String expectedQuestion = "What specific data from RingCentral can be archived with Sharp Archive?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "We archive all types of messages, including text messages (SMS), images, and videos sent through RingCentral.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }

    @Test(priority = 164)
    public void verifyArchiveAllTextMessagesAfterFirstArchiveText() {
        page.click("//p[contains(text(),'After archiving, can Sharp Archive archive all tex')]");
        String actualQuestion = page.textContent("//p[contains(text(),'After archiving, can Sharp Archive archive all tex')]");
        String expectedQuestion = "After archiving, can Sharp Archive archive all text messages?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Yes, after the first successful archive, we archive all text messages exchanged without any time restrictions.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }

    @Test(priority = 165)
    public void verifyArchiveTextMessagesAllContactsText() {
        page.click("(//a[contains(text(),'Can Sharp Archive archive text messages sent to an')])[1]");
        String actualQuestion = page.textContent("//h2[contains(text(),'Can Sharp Archive archive text messages sent to an')]");
        String expectedQuestion = "Can Sharp Archive archive text messages sent to and received from all contacts on RingCentral?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Yes, we can archive text messages exchanged with all contacts.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }

    @Test(priority = 166)
    public void verifyStoreDeletedRingCentralMessagesText() {
        page.click("//p[contains(text(),'Can Sharp Archive store deleted text messages from')]");
        String actualQuestion = page.textContent("//p[contains(text(),'Can Sharp Archive store deleted text messages from')]");
        String expectedQuestion = "Can Sharp Archive store deleted text messages from RingCentral?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "No, we only archive messages that are available at the time of archiving. Deleted messages before archiving cannot be recovered.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }

    @Test(priority = 167)
    public void verifyDisplayAllArchivedRingCentralText() {
        page.click("//p[contains(text(),'Can Sharp Archive display all archived RingCentral')]");
        String actualQuestion = page.textContent("//p[contains(text(),'Can Sharp Archive display all archived RingCentral')]");
        String expectedQuestion = "Can Sharp Archive display all archived RingCentral text messages?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Yes, all archived text messages can be accessed and viewed.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }

    @Test(priority = 168)
    public void verifyArchiveGroupChatTextMessagesText() {
        page.click("//p[contains(text(),'Can Sharp Archive archive text messages exchanged ')]");
        String actualQuestion = page.textContent("(//h2[@class='text-orange-dark font-bold pb-5'])[1]");
        String expectedQuestion = "Can Sharp Archive archive text messages exchanged in group chats on RingCentral?\n";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "Yes, group chat text messages can be archived.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }

    @Test(priority = 169)
    public void verifyEditArchivedRingCentralMessagesText() {
        page.click("//p[contains(text(),'Is it possible to edit archived RingCentral text m')]");
        String actualQuestion = page.textContent("//p[contains(text(),'Is it possible to edit archived RingCentral text m')]");
        String expectedQuestion = "Is it possible to edit archived RingCentral text message data using Sharp Archive?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");
        String actualAnswer = page.textContent("(//p[@class='pb-7'])[1]");
        String expectedAnswer = "No, archived text message data is stored as read-only and cannot be edited.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }

    @Test(priority = 170)
    public void verifyReconnectRingCentralAccountText() {
        page.click("//p[contains(text(),'I changed my password on RingCentral. How do I rec')]");
        String actualQuestion = page.textContent("//p[contains(text(),'I changed my password on RingCentral. How do I rec')]");
        String expectedQuestion = "I changed my password on RingCentral. How do I reconnect my account to Sharp Archive with the new password?";
        Assert.assertEquals(normalizeText(actualQuestion), normalizeText(expectedQuestion), "Question text mismatch!");
        String actualAnswer = page.textContent("(//div[@class='pb-7'])[1]");
        String expectedAnswer = "To reconnect:\n" +
                "1. Log in to the RingCentral Admin Portal.\n" +
                "2. Navigate to the Archiver settings.\n" +
                "3. Update your credentials or reauthorize the connection.";
        Assert.assertEquals(normalizeText(actualAnswer), normalizeText(expectedAnswer), "Answer text mismatch!");
        page.goBack();
    }



























    



}
