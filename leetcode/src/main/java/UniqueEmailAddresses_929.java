import java.util.HashSet;
import java.util.Set;

/**
 * <p>929. Unique Email Addresses</p>
 * Every email consists of a local name and a domain name, separated by the @ sign.
 *
 * For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
 *
 * Besides lowercase letters, these emails may contain '.'s or '+'s.
 *
 * If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)
 *
 * If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not apply for domain names.)
 *
 * It is possible to use both of these rules at the same time.
 *
 * Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails?
 *
 *
 *
 * @author jixd
 * @Date Created in 2019年02月25日 15:40
 */
public class UniqueEmailAddresses_929 {

    public static int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0){
            return 0;
        }
        Set<String> set = new HashSet<>();
        for (String email : emails){
            String[] split = email.split("@");
            String s = split[0].replace(".", "");
            set.add(s.substring(0,s.indexOf("+") == -1 ? s.length():s.indexOf("+"))+"@"+split[1]);
        }
        return set.size();
    }

    public static void main(String[] args) {

        String [] strs = new String[]{"testemail@leetcode.com","testemail1@leetcode.com","testemail+david@lee.tcode.com"};
        numUniqueEmails(strs);

    }
}
