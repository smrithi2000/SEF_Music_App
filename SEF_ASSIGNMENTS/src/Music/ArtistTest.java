package Music;


import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ArtistTest {
	//ADD ARTIST TESTS
	
    @Test
    @Order(1)
    public void testAddArtist() {
    	
    //TEST CASE : 1 -  Validating artist information
    	
    	//Test Data : 1 - Providing Valid data
    	//System.out.println("569MMMRR_% - Valid Artist : 1");
    	System.out.println("\n Test Case 1 : Adding Valid Data");
    	Artist artist1 = new Artist("569MMMRR_%", "05-11-1980", "Melbourne|Victoria|Australia",
              "TCTD1: A talented singer-songwriter who is passionate in making new tracks and albums in mellow vibes.",
              List.of("Singer", "Songwriter"),
              List.of("2022, Best Composer in the entire world"),
              List.of("pop", "classical"));
      assertTrue(artist1.addArtist());
        // Test Data : 2 - Providing another set of valid data
      	//System.out.println("678FFFGG@$ - Valid Artist : 2");
        Artist artist2 = new Artist("678FFFGG@$", "18-06-2001", "Sydney|New South Wales|Australia",
               "TCTD2: A talented producer, singer-songwriter who loves playing guitar and produces fast-track music for the pop-world.",
                List.of("Singer", "Producer", "Songwriter"),
                List.of("2016, Best Producer for the Year"),
                List.of("pop", "jazz"));
       assertTrue(artist2.addArtist());

     //TEST CASE : 2 - Validating for Invalid ID
         System.out.println("\n Test Case 2 : Adding Invalid ID");
         // Test Data : 1 - Providing Invalid Artist ID without special characters as last 2 characters
         Artist artist3 = new Artist("567ABCXYZ", "05-11-1980", "Melbourne|Victoria|Australia",
                 "A talented singer-songwriter who is passionate in making new tracks and albums in mellow vibes.",
                 List.of("Singer", "Songwriter"),
                 List.of("2022, Best Composer in the entire world"),
                 List.of("pop", "classical"));
         assertFalse(artist3.addArtist());
        
 	     // Test Data : 2 - Providing Artist ID more than 10 characters long
         Artist artist4 = new Artist("569MMMRRDF_%", "05-11-1980", "Melbourne|Victoria|Australia",
                 "A talented singer-songwriter who is passionate in making new tracks and albums in mellow vibes.",
                 List.of("Singer", "Songwriter"),
                 List.of("2022, Best Composer in the entire world"),
                 List.of("pop", "classical"));
         assertFalse(artist4.addArtist());
         
         
     //TEST CASE : 3 - Validating for Invalid BirthDate
     	System.out.println("\n Test Case 3 : Adding Invalid BirthDate");
        //Test Data : 1 - Providing '/' character instead of '-'
 	    Artist artist5 = new Artist("569MMMRR_%", "11/05/1980", "Melbourne|Victoria|Australia",
                 "A talented singer-songwriter who is passionate in making new tracks and albums in mellow vibes.",
                 List.of("Singer", "Songwriter"),
                 List.of("2022, Best Composer in the entire world"),
                 List.of("pop", "classical"));
 	    assertFalse(artist5.addArtist());
 	    
 	    //Test Data : 2 - Providing a different format than DD-MM-YYYY
 	    Artist artist6 = new Artist("569MMMRR_%", "1980-05-11", "Melbourne|Victoria|Australia",
                 "A talented singer-songwriter who is passionate in making new tracks and albums in mellow vibes.",
                 List.of("Singer", "Songwriter"),
                 List.of("2022, Best Composer in the entire world"),
                 List.of("pop", "classical"));
 	    assertFalse(artist6.addArtist());
  
     	
     //TEST CASE : 4 - Validating for Invalid Bio
     	System.out.println("\n Test Case 4 : Adding Invalid Bio");
        //Test Data : 1 - Providing less than 10 words for bio
 	    Artist artist7 = new Artist("569MMMRR_%", "05-11-1980", "Melbourne|Victoria|Australia",
                 "A talented singer",
                 List.of("Singer", "Songwriter"),
                 List.of("2022, Best Composer in the entire world"),
                 List.of("pop", "classical"));
 	    assertFalse(artist7.addArtist());
 	    
 	    //Test Data : 2 - Providing more than 30 words for bio
 	    Artist artist8 = new Artist("569MMMRR_%", "05-11-1980", "Melbourne|Victoria|Australia",
                 "A talented singer-songwriter who is passionate in making new tracks and albums in mellow vibes. I am also well-versed in playing various instruments like the guitar, violin and drums. I produce instrumentals tracks for my youtube channel as well.",
                 List.of("Singer", "Songwriter"),
                 List.of("2022, Best Composer in the entire world"),
                 List.of("pop", "classical"));
 	    assertFalse(artist8.addArtist());
         
     	
     //TEST CASE : 5 - Validating for Invalid Occupations
     	System.out.println("\n Test Case 5 : Adding Invalid Occupations");
        //Test Data : 1 - Providing more than 5 occupations
 	    Artist artist9 = new Artist("569MMMRR_%", "05-11-2002", "Melbourne|Victoria|Australia",
                 "A talented singer-songwriter who is passionate in making new tracks and albums in mellow vibes.",
                 List.of("Singer", "Songwriter", "Producer", "Composer", "Dancer", "Director"),
                 List.of("2022, Best Composer in the entire world"),
                 List.of("pop", "classical"));
 	    assertFalse(artist9.addArtist());
 	    
 	    //Test Data : 2 - Providing no Occupations
 	    Artist artist10 = new Artist("569MMMRR_%", "05-11-2002", "Melbourne|Victoria|Australia",
                 "A talented singer-songwriter who is passionate in making new tracks and albums in mellow vibes.",
                 List.of(),
                 List.of("2022, Best Composer in the entire world"),
                 List.of("pop", "classical"));
 	    assertFalse(artist10.addArtist());
 	    
 	 //TEST CASE : 6 - Validating for Invalid Genres
 	    	System.out.println("\n Test Case 6 : Adding Invalid Genres");
 	        //Test Data : 1 - Providing 'pop' and 'rock' at the same time
 		    Artist artist11 = new Artist("569MMMRR_%", "05-11-1980", "Melbourne|Victoria|Australia",
 	                "A talented singer-songwriter who is passionate in making new tracks and albums in mellow vibes.",
 	                List.of("Singer", "Songwriter"),
 	                List.of("2022, Best Composer in the entire world"),
 	                List.of("pop", "rock"));
 		    assertFalse(artist11.addArtist());
 		    
 		    //Test Data : 2 - Providing more than 5 genres
 		    Artist artist12 = new Artist("569MMMRR_%", "05-11-1980", "Melbourne|Victoria|Australia",
 	                "A talented singer-songwriter who is passionate in making new tracks and albums in mellow vibes.",
 	                List.of("Singer", "Songwriter"),
 	                List.of("2022, Best Composer in the entire world"),
 	                List.of("pop", "jazz", "western", "classical", "hiphop", "kpop"));
 		    assertFalse(artist12.addArtist());


    }

    
    //UPDATE TESTS
    @Test
    @Order(2)
    public void testUpdateArtist() {
    	System.out.println("\n Test Case 7 : Updating with Valid Data");
         
    //TEST CASE : 7 - Updating with Valid data
    	// Test Data 1: Valid occupation update for artist born after 2000
    	//System.out.println("569MMMRR_% - Valid Artist : 1");
    	Artist artist15 = new Artist("569MMMRR_%", "06-11-2004", "Melbourne|Victoria|Australia",
              "TCTD1: A talented singer-songwriter who is passionate in making new tracks and albums in mellow vibes.",
              List.of("Singer", "Songwriter"),
              List.of("2022, Best Composer in the entire world"),
              List.of("pop", "classical"));
    	//System.out.println("VALID UPDATE : 1");
        assertTrue(artist15.updateArtist("569MMMRR_%", "06-11-2004", "Melbourne|Victoria|Australia",
        		"TCTD3:A talented singer-songwriter who is passionate in making new tracks and albums in mellow vibes.",
                List.of("Singer", "Songwriter", "Producer", "Composer"),
                List.of("2022, Best Composer in the entire world"),
                List.of("pop", "classical")));
      
        //Test Data 2 : Valid awards title change for artist award after 2000
      	//System.out.println("678FFFGG@$ - Valid Artist : 2");
        Artist artist16 = new Artist("678FFFGG@$", "18-06-2001", "Sydney|New South Wales|Australia",
               "TCTD2: A talented producer, singer-songwriter who loves playing guitar and produces fast-track music for the pop-world.",
                List.of("Singer", "Producer", "Songwriter"),
                List.of("2016, Best Producer for the Year"),
                List.of("pop", "jazz"));
        assertTrue(artist16.updateArtist("678FFFGG@$", "18-06-2001", "Sydney|New South Wales|Australia",
        		"TCTD4: A talented producer, singer-songwriter who loves playing guitar and produces fast-track music for the pop-world..",
                List.of("Singer", "Producer", "Songwriter"),
                List.of("2016, Best pop Song of the Year"),
                List.of("pop", "jazz")));

        
        //Test Case 8 : Invalid address
        	System.out.println("\n Test Case 8 : Updating with Invalid Address");
            // Test Data 1: Providing more than 3 parts for address(invalid address format)
            assertFalse(artist15.updateArtist("569MMMRR_%", "05-11-1980", "CBD|Melbourne|Victoria|Australia",
            		"A talented singer-songwriter who is passionate in making new tracks and albums in mellow vibes.",
                    List.of("Singer", "Songwriter"),
                    List.of("2022, Best Composer in the entire world"),
                    List.of("pop", "classical")));
            //Test Data 2 : Updating address with invalid format
            assertFalse(artist15.updateArtist("569MMMRR_%", "05-11-1980", "Sydney-New South Wales-Australia",
            		"A talented singer-songwriter who is passionate in making new tracks and albums in mellow vibes.",
                    List.of("Singer", "Songwriter"),
                    List.of("2022, Best Composer in the entire world"),
                    List.of("pop", "classical")));

        
        // Test Case 9 : Awards change attempt
        	System.out.println("\n Test Case 9 : Updating Awards");
            // Test Case 1: Attempting to change awards year
            assertFalse(artist15.updateArtist("569MMMRR_%", "05-11-1980", "Melbourne|Victoria|Australia",
                    "A talented singer-songwriter who is passionate in making new tracks and albums in mellow vibes.",
                    List.of("Singer", "Songwriter"),
                    List.of("2012, Best Singer in the entire world"),
                    List.of("pop", "classical")));
            // Test Case 2: Updating awards with title less than 4 words
            assertFalse(artist15.updateArtist("569MMMRR_%", "05-11-1980", "Melbourne|Victoria|Australia",
                    "A talented singer-songwriter who is passionate in making new tracks and albums in mellow vibes.",
                    List.of("Singer", "Songwriter"),
                    List.of("2022, British Single"),
                    List.of("pop", "classical")));
       
        // Test Case 10 : Occupation change attempt
        	System.out.println("\n Test Case 10 : Updating Occupation");
            // Test Data 1: Artist born before 2000, occupation change attempt
            assertFalse(artist15.updateArtist("569MMMRR_%", "05-11-1980", "Melbourne|Victoria|Australia",
            		"A talented singer-songwriter who is passionate in making new tracks and albums in mellow vibes.",
                    List.of("Producer, Director"),
                    List.of("2022, Best Composer in the entire world"),
                    List.of("pop", "classical")));
            
            // Test Data 2 : Artist born after 2000, but invalid number of occupations change attempt
            assertFalse(artist15.updateArtist("569MMMRR_%", "05-11-2003", "Melbourne|Victoria|Australia",
                    "A talented singer-songwriter who is passionate in making new tracks and albums in mellow vibes.",
                    List.of("Singer","Songwriter","Guitarist", "Pianist","Producer","Composer","Director"),
                    List.of("2022, Best Composer in the entire world"),
                    List.of("pop", "classical")));
            
       
        //Test Case 11 : Updating with invalid Genre
        	System.out.println("\n Test Case 11 : Updating with Invalid Genre");
            // Test Data 1 : Providing 'pop' and 'rock' at the same time          
            assertFalse(artist15.updateArtist("569MMMRR_%", "05-11-1980", "Melbourne|Victoria|Australia",
                    "A talented singer-songwriter who is passionate in making new tracks and albums in mellow vibes.",
                    List.of("Singer", "Songwriter"),
                    List.of("2022, Best Composer in the entire world"),
                    List.of("pop", "rock")));
            // Test Data 2 : Updating artist by providing only 1 genre (At least 2 is needed)
            assertFalse(artist15.updateArtist("569MMMRR_%", "05-11-1980", "Melbourne|Victoria|Australia",
                    "A talented singer-songwriter who is passionate in making new tracks and albums in mellow vibes.",
                    List.of("Singer", "Songwriter"),
                    List.of("2022, Best Composer in the entire world"),
                    List.of("pop")));
            
       
       
        //Test Case 12 : Updating with Invalid ID
        	System.out.println("\n Test Case 12 : Updating with Invalid ID");
            //Updating with ID that does not have first 3 characters as numbers between 5-9
            assertFalse(artist15.updateArtist("123GGHUU_%", "05-11-1980", "Melbourne|Victoria|Australia",
                    "A talented singer-songwriter who is passionate in making new tracks and albums in mellow vibes.",
                    List.of("Singer", "Songwriter"),
                    List.of("2022, Best Composer in the entire world"),
                    List.of("pop", "classical")));
            //Updating with ID where middle characters are not alphabets
            assertFalse(artist15.updateArtist("78967123/$", "05-11-1980", "Melbourne|Victoria|Australia",
                    "A talented singer-songwriter who is passionate in making new tracks and albums in mellow vibes.",
                    List.of("Singer", "Songwriter"),
                    List.of("2022, Best Composer in the entire world"),
                    List.of("pop", "classical")));
            
        }

    }
  
