package com.cg.capbook.services;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.capbook.beans.UserProfile;
import com.cg.capbook.daoservices.SearchDao;

@Component("userProfileSearch")
public class SearchServiceImpl implements SearchService{

	@Autowired
	private SearchDao searchDao;

	@Override
	public List<UserProfile> getUserProfile(String username) {
		List<UserProfile> userList = new ArrayList<UserProfile>();
		List<UserProfile> userProfiles=getAllUserNames();
//		for (UserProfile userProfile : userProfiles) {
//			System.out.println("\n\n"+userProfile.toString());
//		}
		String[] parts=username.split(" ");
		String firstName=parts[0];
		String lastName=parts[1];
		for (UserProfile userProfile : userProfiles) {
//			System.out.println(userProfile.getFirstName());
//			System.out.println(userProfile.getLastName());
			if(userProfile.getFirstName().equalsIgnoreCase(firstName))
				if(userProfile.getLastName().equalsIgnoreCase(lastName))
					userList.add(userProfile);
		}
//		for (UserProfile userProfile : userList) {
//			System.out.println("***************************************third");
//			System.out.println("\n\n"+userProfile.toString());
//		}
		return userList;
	}

	@Override
	public List<UserProfile> getAllUserNames() {
		return searchDao.findAll();
	}

}
