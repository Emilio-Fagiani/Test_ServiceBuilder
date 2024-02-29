package queryutenti.portlet;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import org.osgi.service.component.annotations.Component;
import queryutenti.constants.QueryUtentiPortletKeys;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Utente
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=QueryUtenti",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + QueryUtentiPortletKeys.QUERYUTENTI,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class QueryUtentiPortlet extends MVCPortlet {

	public List<User> getUsersByRole(String roleName) throws SystemException {
		try {
			// Ottieni l'ID del ruolo
			long roleId = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), roleName).getRoleId();
			ClassLoader classLoader = getClass().getClassLoader();

			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(User.class,classLoader)
					.add(PropertyFactoryUtil.forName("userId").in(
							RoleLocalServiceUtil.getUserPrimaryKeys(roleId)
					));

			List<User> users = UserLocalServiceUtil.dynamicQuery(dynamicQuery);
			return users;
		} catch (SystemException | PortalException e) {
			throw new SystemException("Errore durante il recupero degli utenti per il ruolo " + roleName, e);
		}
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {

			List<User> alunni = getUsersByRole("Alunno");

			renderRequest.setAttribute("alunni", alunni);

			super.doView(renderRequest,renderResponse);

		} catch (SystemException e) {
			throw new PortletException(e);
		} catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}