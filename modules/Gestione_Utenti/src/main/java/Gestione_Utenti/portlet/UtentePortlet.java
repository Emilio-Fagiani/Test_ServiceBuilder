package Gestione_Utenti.portlet;

import Gestione_Utenti.constants.UtentePortletKeys;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Utente
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Utente",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + UtentePortletKeys.UTENTE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class UtentePortlet extends MVCPortlet {




    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        try {
            List<User> users = UserLocalServiceUtil.getUsers(-1, -1);

            Map<User, List<Role>> userRolesMap = new HashMap<>();
            for(User uMail : users) {

                String usersMail = uMail.getEmailAddress();
                renderRequest.setAttribute("usersMail", usersMail);

                for (User user : users) {

                    List<Role> roles = RoleLocalServiceUtil.getUserRoles(user.getUserId());
                    userRolesMap.put(user, roles);
                }
            }
            renderRequest.setAttribute("userRolesMap", userRolesMap);

            super.doView(renderRequest,renderResponse);
        } catch (IOException e) {
            throw new PortletException(e);
        }
    }
}