package Music;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

  public class Artist {
  private String artistID;
  private String birthDate;
  private String address;
  private String bio;
  private List<String> occupations;
  private List<String> awards;
  private List<String> musicGenres;

  public Artist(String artistID,String birthDate, String address, String bio, List<String> occupations, List<String> awards, List<String> musicGenres) 
  {
	  this.artistID = artistID;
	  this.birthDate = birthDate;
	  this.address = address;
	  this.bio = bio;
	  this.occupations = occupations;
	  this.awards = awards;
	  this.musicGenres = musicGenres;
	
	  if (addArtist()) {
		  writeArtistInfoToFile();
	  }
	  else {
		  System.out.println("Invalid Artist info, not added");
	  }
	  
	}

//ADD ARTIST FUNCTION
  
   public boolean addArtist() 
   {
	    if (!isValidArtistID(artistID) || !isValidBirthDate(birthDate) || !isValidAddress(address)
	        || !isValidBio(bio) || !isValidOccupations(occupations) || !isValidAwards(awards)
	        || !isValidMusicGenres(musicGenres)) {
	        return false;
	    }
	    return true;
	}

	protected boolean isValidArtistID(String artistID) {
	//  ID should be 10 characters long
		if (artistID.length() != 10) {
	        return false;
	    }
	
	    //  The first three characters should be numbers between 5 to 9
	    String firstThreeCharacters = artistID.substring(0, 3);
	    if (!firstThreeCharacters.matches("[5-9]{3}")) {
	        return false;
	    }
	
	    // The characters 4th to 8th should be upper case letters (A - Z)
	    String middleCharacters = artistID.substring(3, 8);
	    if (!middleCharacters.matches("[A-Z]{5}")) {

	        return false;
	    }
	
	    // The last two characters should be a special character
	    String lastTwoCharacters = artistID.substring(8);
	    if (!lastTwoCharacters.matches("[^A-Za-z0-9]{2}")) {

	        return false;
	    }
	    return true;
	}
	
	private boolean isValidBirthDate(String birthDate) {
	    return birthDate.matches("\\d{2}-\\d{2}-\\d{4}");
	}
	
	private boolean isValidAddress(String address) {
	    String[] parts = address.split("\\|");
	    // Check if there are exactly three parts (City, State, Country)
	    if (parts.length != 3) {
	        return false;
	    }
	    // Check if each part is not empty
	    for (String part : parts) {
	        if (part.isEmpty()) {
	            return false;
	        }
	    }
	    return true;
	}

	private boolean isValidBio(String bio) {
	    int wordCount = bio.split("\\s+").length;
	    return wordCount >= 10 && wordCount <= 30;
	}
	private boolean isValidOccupations(List<String> occupations) {
	    return !occupations.isEmpty() && occupations.size() <= 5;
	}

	private boolean isValidAwards(List<String> awards) {
	    if (awards.size() > 3) {
	        return false; // More than three awards
	    }
	    for (String award : awards) {
	        String[] parts = award.split(",\\s*", 2); // Split the award into Year and Title
	        if (parts.length != 2) {
	            return false; // Invalid format
	        }
	        String title = parts[1].trim();
	        if (!title.matches("^\\w+(\\s+\\w+){3,9}$")) {
	            return false; // Title does not have 4 to 10 words
	        }
	        if (!parts[0].matches("\\d{4}")) {
	            return false; // Year is not four digits
	        }
	    }
	    return true;
	}
	private boolean isValidMusicGenres(List<String> musicGenres) {
	    return musicGenres.size() >= 2 && musicGenres.size() <= 5
	        && !(musicGenres.contains("pop") && musicGenres.contains("rock"));
	}

	

	
//UPDATE ARTIST FUNCTION
	public boolean updateArtist(String newArtistID, String newBirthDate, String newAddress, String newBio, 
	        List<String> newOccupations, List<String> newAwards, List<String> newMusicGenres) 
	{
	    if (!isValidArtistID(newArtistID) || !isValidBirthDate(newBirthDate) || !isValidAddress(newAddress)
	    || !isValidBio(newBio) || !isValidOccupations(newOccupations) || !isValidAwards(newAwards)
	    || !isValidMusicGenres(newMusicGenres)) {
 		System.out.println("Invalid artist information. Update failed");
	        return false;
	    }
	    
	    // If born before 2000, occupation cannot be changed
	    int birthYear = Integer.parseInt(newBirthDate.substring(6));
	    if (birthYear < 2000) {
	        if (!newOccupations.equals(occupations)) {
	            return false;
	        }
	    }
	      
	    // Awards given before 2000 cannot be changed
	    for (String award : awards) {
	        String[] parts = award.split(",\\s*", 2);
	        int awardYear = Integer.parseInt(parts[0]);
	        
	        if (awardYear < 2000) {
	        	// Checking new awards
	            for (String newAward : newAwards) {
	                String[] newParts = newAward.split(",\\s*", 2);
	                int newAwardYear = Integer.parseInt(newParts[0]);
	     
	                if (newAwardYear != awardYear) {
	                    return false; // Award year cannot be changed
	                }
	            }
	        }
	    }
	    
	    // If all conditions are met, update the artist's information
	    this.artistID = newArtistID;
	    this.birthDate = newBirthDate;
	    this.address = newAddress;
	    this.bio = newBio;
	    this.occupations = newOccupations;
	    this.awards = newAwards;
	    this.musicGenres = newMusicGenres;
	    
	    System.out.println("Artist information updated successfully.");
	    
	 writeArtistInfoToFile();
    return true;
	}
	

	private void writeArtistInfoToFile() {
	    try {
	        File file = new File("/Users/smrithi/Desktop/Masters/Sem-1/SEF/SEF_ASSIGNMENTS/src/Music/artist_info.txt");
	        BufferedReader reader = new BufferedReader(new FileReader(file));
	        List<String> lines = new ArrayList<>();
	        String line;

	        while ((line = reader.readLine()) != null) {
	            lines.add(line);
	        }
	        reader.close();

	        boolean artistExists = false;
	        for (int i = 0; i < lines.size(); i++) { 
	            if (lines.get(i).startsWith("Artist ID: " + artistID)) { //if the artistID is found, artist exists, so update the info
	                artistExists = true;
	                lines.set(i, "Artist ID: " + artistID);
	                lines.set(i + 1, "Birth Date: " + birthDate);
	                lines.set(i + 2, "Address: " + address);
	                lines.set(i + 3, "Bio: " + bio);
	                lines.set(i + 4, "Occupations: " + occupations);
	                lines.set(i + 5, "Awards: " + awards);
	                lines.set(i + 6, "Music Genres: " + musicGenres);
	                break;
	            }
	        }

	        if (!artistExists) { //creating new artist record
	            lines.add("Artist ID: " + artistID);
	            lines.add("Birth Date: " + birthDate);
	            lines.add("Address: " + address);
	            lines.add("Bio: " + bio);
	            lines.add("Occupations: " + occupations);
	            lines.add("Awards: " + awards);
	            lines.add("Music Genres: " + musicGenres+"\n");
	            System.out.println("Artsit "+artistID+" added successfully");
	        }

	        FileWriter writer = new FileWriter(file);
	        for (String updatedLine : lines) {
	            writer.write(updatedLine + "\n");
	        }
	        writer.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

}



