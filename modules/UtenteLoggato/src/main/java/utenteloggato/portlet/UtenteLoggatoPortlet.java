package utenteloggato.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import utenteloggato.constants.UtenteLoggatoPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;
import java.io.IOException;

/**
 * @author Utente
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=UtenteLoggato",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + UtenteLoggatoPortletKeys.UTENTELOGGATO,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class UtenteLoggatoPortlet extends MVCPortlet {


	@ProcessAction(name = "utente")
	public void mostraUtente(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, InterruptedException, PortalException {


		ThemeDisplay td = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		// Recupera l'utente specifico
		User user2 = td.getUser();

		String mailUser2 = user2.getEmailAddress().toString();
		String nome = user2.getFullName();

		actionRequest.setAttribute("nome", nome);
		actionRequest.setAttribute("mail", mailUser2);

		System.out.println(nome);
		System.out.println(mailUser2);


	}




}