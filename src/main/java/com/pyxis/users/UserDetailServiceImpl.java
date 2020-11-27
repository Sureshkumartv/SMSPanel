/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pyxis.entities.EsmeInfo;
import com.pyxis.entities.UserCreditsDetail;
import com.pyxis.utils.SingleUserDetails;

/**
 *
 * @author HP
 */
@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class UserDetailServiceImpl implements UserService, UserDetailsService {

    @Autowired
    UserDAO userDao;
    
    @Autowired
    SingleUserDetails SingleUserDetails;
   
    
    
    Map<Integer, String> rolesMap = new HashMap<>();
    
    {
        rolesMap.put(1,"SUPERADMIN");
        rolesMap.put(2,"ADMIN");
        rolesMap.put(3,"RESELLER");
    	rolesMap.put(4, "USER");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userDao.findByLoginid(username);
        System.out.println("user  ::"+user);
        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }
        String name = user.getUsername();
        
//			Query query = session.createSQLQuery(
//					"SELECT AES_DECRYPT(PASSWORD, '20091129') password FROM user_details where userid = ?");
//			query.setParameter(0, id);
//			return query.list();
//		}
        byte[] password = userDao.getPassword(user.getUserid());
//        System.out.println("password ::"+password);
        boolean enabled = true;
        boolean accountNonExpired = enabled;
        boolean credentialsNonExpired = enabled;
        boolean accountNonLocked = enabled;
        Integer userType = user.getUsertype();
//            String displayname= user.getDisplayname();

        //String requestApproval = user.getRequestForApproval();
        Long userId = user.getUserid();

        Collection<GrantedAuthority> authorities = getAuthorities(rolesMap.get(userType));
        UserToken userToken = new UserToken(userId, name, new String(password), enabled, accountNonExpired, credentialsNonExpired, 
        		accountNonLocked, authorities, userType, user.getSmppid().getId(), user.getSmssendtype());
        userToken.setEmail(user.getEmailid());
        userToken.setCreatedBy(user.getUsercreatedby().getUserid());
        userToken.setAvailableCredits(SingleUserDetails.loadRemainingCredits(user.getUserid().intValue()));
//            userToken.setFavoritePage(user.getFavoritePage());
        return userToken;
    }

    public Collection<GrantedAuthority> getAuthorities(String role) {
        final java.util.List<GrantedAuthority> authList = getGrantedAuthoritie(role);
        return authList;
    }

    public static java.util.List<GrantedAuthority> getGrantedAuthoritie(String roles) {
        final java.util.List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(roles));
        return authorities;
    }

    @Override
    public boolean hasRole(String role) {
        // TODO Auto-generated method stub
        SecurityContext context = SecurityContextHolder.getContext();
        if (context == null) {
            return false;
        }

        Authentication authentication = context.getAuthentication();
        if (authentication == null) {
            return false;
        }

        for (GrantedAuthority auth : authentication.getAuthorities()) {
            if (role.equals(auth.getAuthority())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addRecord(Users s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateRecord(Users id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteRecord(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Users getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Page<Users> listRecords(Integer page, Integer size) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
	public List<EsmeInfo> fetchEsmeInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void submitCredits(UserCreditsDetail s) {
	}

}
