package mx.ulsa.josiaslpsw.repository;
import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;
public interface UserDetails {
    Collection<? extends GrantedAuthority> getAuthorities();
    String getPassword();
    String getUsername();

}
